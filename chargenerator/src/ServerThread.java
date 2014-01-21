import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/*
 * ServerThread, implements a threaded Server to process incoming requests
 * 
 */
public class ServerThread extends Thread{
	
	private Socket clientSocket = null;
	public String[] input = null;
	
	public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

	public void run(){
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String fromClient, toClient = null;
        
        toClient = "awaiting§ requests";
        out.println(toClient);
        System.out.println("Sent Message: " + toClient);
        while ((fromClient = in.readLine()) != null) {
            System.out.println("Received message: " + fromClient);
            toClient = "end§hallo"; 
            this.input = fromClient.split("§");
            System.out.println("Länge: " + this.input.length);
            process(this.input);       
            out.println(toClient); //sending the answer
        }
        System.out.println("Closing server thread...");
        out.close();
        in.close();
        clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void process(String[] input){
		
		JFrame f = new JFrame("Server");
		JPanel buttons = new JPanel(new FlowLayout());
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		f.setSize( 800, 600 );
		//Layout
		f.setLayout(new GridLayout());
		
		String Sheet = output(1,input);
		JLabel l = new JLabel (Sheet);
		
		JLabel sav = new JLabel("Bitte beim Speichern auch die Endung .html angeben");
		
		//Buttons
		JButton xml = new JButton ("Als HTML speichern");
		JPanel set = new JPanel(new CardLayout());
		xml.setActionCommand("HTMLS");
		xml.addActionListener( new XmlActionListener(this, set));
		
		JButton snd = new JButton ("mit LaTeX verarbeiten");
		snd.setActionCommand("TEX");
		snd.addActionListener( new XmlActionListener(this, set));
		
		
		JButton end = new JButton("Ohne Speichern beenden");
		
		ActionListener finish = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		end.addActionListener(finish);
		f.add(new JScrollPane(l));
		
		buttons.add(end);
		buttons.add(xml);
		buttons.add(sav);
		buttons.add(snd);
		f.add(buttons);
		f.setVisible ( true );
		
	
		
	}
	
	public void exportashtml(String[] input){
		JFrame frame = new JFrame("Als HTML speichern");
		Writer write = null;
		JFileChooser save = new JFileChooser();
		save.setMultiSelectionEnabled(false);
		save.showSaveDialog(frame);
		File file = save.getSelectedFile();
		String text=output(0,input); 
		try{
			if(file != null){
			write=new FileWriter(file);
			write.write(text);}
			
		}catch(IOException e){
			System.err.println("Fehler beim Speichern");
		}
		finally {
			if(write != null){
			try{ write.close(); }catch(IOException e){}
			}
		}
		
	}
	
	public String output(int i, String[] input){
		String erg="";
		String texto="";
		String texta="";
		String textu="";
		String rohtext = "<html><table border=1><tr><td>Name</td><td>"+ input[1]+"</td></tr><tr><td>Rasse</td><td>"+
				   input[2]+"</td></tr><tr><td>Kultur</td><td>"
				+ input[3] +"</td></tr><tr><td>Archetyp</td><td>"
				+input[4]+"</td></tr><tr><td>Religion</td><td>"
				+input[5]+"</td></tr><tr><td>Geschlecht</td><td>"+
				input[6]+"</td></tr><tr><td>Alter</td><td>"+
				input[7]+"</td></tr><tr><td>Sprache</td><td>"+
				input[8]+"</td></tr><tr><td>Kampfhand</td><td>"+
				input[9]+"</td></tr></table><table border=1><tr><td>Aussehen</td> <td>"+
				input[10]+"</td></tr></table><table border=1><tr><td>Leben</td> <td>"
				+input[11]+"</td><td>Energie</td><td>"+
				input[12]+"</td></tr></table><table><tr><td><table border=1> <th>Charakterwerte</th> <tr><td>Intelligenz</td><td>"+
				input[13]+"</td></tr><tr><td>Charisma</td><td>"+
				input[14]+"</td></tr><tr><td>Geschicklichkeit</td><td>"+
				input[15]+"</td></tr><tr><td>Schnelligkeit</td><td>"+
				input[16]+"</td></tr><tr><td>Kraft</td><td>"+
				input[17]+"</td></tr><tr><td>Ausdauer</td><td>"+
				input[18]+"</td></tr><tr><td>Mut</td><td>"+
				input[19]+"</td></tr><tr><td>Wachsamkeit</td><td>"+
				input[20]+"</td></tr><tr><td>Intuition</td><td>"+
				input[21]+"</td></tr></table></td><td><table border=1><th>Klassentalente</th><tr><td>"+
				input[22]+"</td></tr><tr><td>"+input[23]+"</td></tr></table><table border=1><th>Kenntnisse</th><tr><td>"+
				input[24]+"</td></tr><tr><td>"+input[25]+"</td></tr><tr><td>"+input[26]+"</td></tr></table></td><td><table border=1><th>Stärke</th><tr><td>"+
				input[27]+"</td></tr></table><table border=1><th>Schwäche</th><tr><td>"+input[28]+"</td></tr></table><table border=1><th>Gesinnung</th><tr><td>"+
				input[29]+"</td></tr></table></td></tr></table><h3>Nahkampfwaffen</h3><table border=1> <th> Name</th><th>Material</th><th>Angriffswert</th><th>Blockwert</th><th>Bruchfaktor</th><tr><td>"+
				input[30]+"</td><td>"+input[31]+ "</td><td>"+input[32]+"</td><td>"+input[33]+"</td><td>"+input[34]+"</td></tr><tr><td>"+
				input[35]+"</td><td>"+input[36]+"</td><td>"+input[37]+"</td><td>"+input[38]+"</td><td>"+input[39]+"</td></tr></table><table><tr><td><h3>Fernkampfwaffen</h3><table border=1><th>Name</th><th>Reichweite</th><th>Genauigkeit</th><tr><td>"+
				input[40]+"</td><td>"+input[41]+"</td><td>"+input[42]+"</td></tr></table></td><td><h3>Munition</h3><table border=1><th>Name</th><th>Angriff</th><tr><td>"+
				input[43]+"</td><td>"+input[44]+"</td></tr></table></td></tr></table><h3>Fähigkeiten</h3><table border=1><th>Name</th><th>Voraussetzung</th><th>Wirkung</th><tr><td>"+
				input[45] + "</td><td>"+ input[46]+"</td><td>"+input[47]+"</td></tr><tr><td>"+
				input[48] + "</td><td>"+ input[49]+"</td><td>"+input[50]+"</td></tr><tr><td>"+
				input[51] + "</td><td>"+ input[52]+"</td><td>"+input[53]+"</td></tr><tr><td>"+
				input[54] + "</td><td>"+ input[55]+"</td><td>"+input[56]+"</td></tr></table><h3>Rüstung</h3><table border=1><th>Name</th><th>Rüstungsart</th><th>Schutzwert</th><th>Rissfaktor</th><tr><td>"+
				input[57] + "</td><td>"+input[58]+"</td><td>"+input[59]+"</td><td>"+input[60]+"</td></tr><tr><td>"+
				input[61] + "</td><td>"+input[62]+"</td><td>"+input[63]+"</td><td>"+input[64]+"</td></tr><table><table border=1><tr><td>Gesamtschutzwert</td><td>"+
				input[65]+"</td></tr></table><table><th>Charaktereigenschaften</th><th> Moral</th><th>Ränge</th><tr><td><table border=1><tr><td>Willenskraft</td><td>"+
				input[66]+"</td><td> Tragkraft</td><td>"+
				input[67]+"</td></tr><tr><td>Konzentration</td><td>"+
				input[68]+"</td><td>Reisegeschwindigkeit</td><td>"+
				input[69]+"</td></tr><tr><td>Initiative</td><td>"+
				input[70]+"</td><td>Regeneration</td><td>"+
				input[71]+"</td></tr><tr><td>Selbstbeherrschung</td><td>"+
				input[72]+"</td><td>Imunsystem</td><td>"+
				input[73]+"</td></tr><tr><td>Gelenkigkeit</td><td>"+
				input[74]+"</td><td>Glaube</td><td>"+
				input[75]+"</td></tr><tr><td>Waffenkunde</td><td>"+
				input[76]+"</td><td>Glück</td><td>"+
				input[77]+"</td></tr></table></td><td><table border=1><tr><td>90</td><td>+5</td><td></td></tr><tr><td>80</td><td>+4</td><td></td></tr><tr><td>70</td><td>+3</td><td></td></tr><tr><td>60</td><td>+2</td><td></td></tr><tr><td>50</td><td>+0</td><td>50</td></tr><tr><td>40</td><td>-2</td><td></td></tr><tr><td>30</td><td>-3</td><td></td></tr><tr><td>20</td><td>-4</td><td></td></tr><tr><td>10</td><td>-5</td><td></td></tr></table></td><td><table border=1, cellspacing=30%><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr></table></td></tr></table><h3>Besondere Besitztümer</h3><table border=1><tr><td>"+
				input[78]+"</td><td>"+
				input[79]+"</td><td>"+input[80]+"</td></tr><tr><td>"+input[81]+"</td><td>"+input[82]+"</td><td>"+input[83]+"</td></tr></table><h3>Beutel</h3><table border=1, cellspacing=200%><tr><td></td><td></td></tr></table></html>";

	
		if(i==0){
		texta=rohtext.replaceAll("ä", "&auml");
		texto=texta.replaceAll("ö", "&ouml");
		textu=texto.replaceAll("ü", "&uuml");
		erg=textu.replaceAll("ß", "&szlig");
		}else{
			erg = rohtext;
		}
		return erg;	
	}
	
	
	public void compileTex(String[] input){
		String filename = input[1]+".tex";
		//String filename = "test1.tex";
		String texcommand = "/usr/local/texlive/2013/bin/x86_64-linux/pdflatex " + filename; //works on my machine, global use still to be implemented
		
		File texfile = new File(filename);
		Writer write = null;
		String rohtext = "\\documentclass[12pt]{scrartcl}\n\n\\usepackage[utf8]{inputenc}\n\\usepackage[ngerman]{babel}\n\\usepackage{graphicx}\n\\usepackage{multicol}\n\\begin{document}\n\n\\begin{multicols}{2}\n\n\\section*{Charakterbogen}\n\\columnbreak\n\n\\begin{tabular}{|lp{0.5\\columnwidth}|}\n\\hline\nName &"
				+ input[1] + " \\\\\\hline\nRasse&"+ 
				input[2] + " \\\\\n Kultur& "+
				input[3]+"\\\\\n Archetyp & "+
				input[4] + "\\\\\n Religion &"+
				input[5] + "\\\\\n Geschlecht &"+
				input[6] +"\\\\\n Alter &"+
				input[7] +"\\\\\n Sprache &"+
				input[8] +"\\\\\n Kampfhand &"+
				input[9] +"\\\\\\hline\n\\textbf{Leben} &"+
				input[11] +"\\\\\\hline\n \\textbf{Energie} &"+
				input[12] + "\\\\\\hline\n\\end{tabular}\n\\end{multicols}\n\n\\subsection*{Aussehen}\n"+
				input[10] +"\n\n\\begin{multicols}{3}\n\\subsection*{Charakterwerte}\n\\begin{tabular}{|lr|}\n\\hline\n Intelligenz &"+
				input[13]+"\\\\\n Charisma &"+
				input[14]+"\\\\\n Geschicklichkeit &"+
				input[15] +"\\\\\n Schnelligkeit &"+
				input[16] +"\\\\\n Kraft &"+
				input[17] +"\\\\\n Ausdauer &"+
				input[18] +"\\\\\n Mut &"+
				input[19] +"\\\\\n Wachsamkeit &"+
				input[20] +"\\\\\n Intuition &"+
				input[21] +"\\\\\\hline\n \\end{tabular}\n \\columnbreak\n \\subsection*{Klassentalente}\n \\begin{tabular}{|c|}\\hline\n"+
				input[22] +"\\\\\\hline\n"+
				input[23] +"\\\\\\hline\n\\end{tabular}\n\\subsection*{Kentnisse}\n\\begin{tabular}{|c|}\\hline\n"+
				input[24] +"\\\\\\hline\n"+
				input[25] +"\\\\\\hline\n"+
				input[26] +"\\\\\\hline\n\\end{tabular}\n\\columnbreak\n\n\\subsection*{Schwäche}\n"+
				input[27] +"\n\\subsection*{Stärke}\n"+
				input[28] +"\n\\end{multicols}\n\n\\subsection*{Nahkampfwaffen}\n\\begin{tabular}{|c|c|c|c|c|}\\hline\n\\textbf{Name} & \\textbf{Material} & \\textbf{Angriffswert} &\\textbf{Blockwert} & \\textbf{Bruchfaktor}\\\\\\hline\n"+
				input[29] +"&"+ input[30] +"&"+input[31] + "&" + input[32] +"&" + input[33] +"\\\\\\hline\n"+
				input[34] +"&"+ input[35] +"&"+input[36] + "&" + input[37] +"&" + input[38] +"\\\\\\hline\n\\end{tabular}\n\n\\begin{multicols}{2}\n\\subsection*{Fernkampfwaffen}\n\n\\begin{tabular}{|c|c|c|}\\hline\n\\textbf{Name} & \\textbf{Reichweite} & \\textbf{Genauigkeit} \\\\\\hline\n"+
				input[39] +"&"+ input[40] +"&" + input[41]+"\\\\\\hline\n"+
				input[42] +"&" + input[43] +"&"+ input[44]+"\\\\\\hline\n\\end{tabular}\n\\columnbreak\n\\subsubsection*{Munition}\n\\begin{tabular}{|c|c|}\\hline\n\\textbf{Name} & \\textbf{Angriff} \\\\\\hline\n"+
				input[45] +"&"+ input[46] +"\\\\\\hline\n"+
				input[47] + "&" +input[48] +"\\\\\\hline\n\\end{tabular}\n\\end{multicols}\n\\subsection*{Fähigkeiten}\n\\begin{tabular}{|p{0.2\\columnwidth}|p{0.2\\columnwidth}|p{0.6\\columnwidth}|}\\hline\n\\textbf{Name} & \\textbf{Voraussetzung} & \\textbf{Wirkung} \\\\\\hline\n"+
				input[49] +"&"+ input[50] +"\\\\\\hline\n"+
				input[51] +"&"+ input[52] +"\\\\\\hline\n"+
				input[53] +"&"+ input[54] +"\\\\\\hline\n"+
				input[54] +"&"+ input[56] +"\\\\\\hline\n\\end{tabular}\n\n\\subsection*{Rüstung}\n\\begin{tabular}{|c|c|c|c|}\\hline\n\\textbf{Name} & \\textbf{Rüstungsart} & \\textbf{Schutzwert} & \\textbf{Rissfaktor}\\\\ \\hline\n"+
				input[57] +"&" + input[58] +"&" + input[59] +"&" +input[60]+"\\\\\\hline\n"+
				input[61] +"&" + input[62] +"&" + input[63] +"&" +input[64]+"\\\\\\hline\n\\end{tabular}\n\n\\textbf{Gesamtschutzwert:}"+
				input[65]+"\n\n\\begin{tabular}{p{0.6\\columnwidth} p{0.2\\columnwidth} p{0.2\\columnwidth}}\n\\begin{flushleft}\n\\subsection*{Charaktereigenschaften}\n\\begin{tabular}{|c|c|c|c|}\\hline\n Willenskraft &"+
				input[66] +"& Tragkraft &"+ input[67]+"\\\\ \\hline\nKonzentration &"+
				input[68]+"&Reisegeschwindigkeit &"+ input[69]+"\\\\\\hline\nInitiative &"+
				input[70]+"&Regeneration &"+ input[71]+"\\\\\\hline\n Selbstbeherrschung &"+
				input[72]+"& Immunsystem&"+input[73]+"\\\\\\hline\n Gelenkigkeit &"+
				input[74]+"&Glaube &"+input[75]+"\\\\\\hline\n Waffenkunde &"+
				input[76]+"&Glück&"+input[77]+
				"\\\\\\hline\n\\end{tabular}\n\\end{flushleft}\n&\n\\subsection*{Moral}\n\\begin{tabular}{|c|c|c|}\\hline\n90& +5& \\\\\\hline\n80& +4& \\\\\\hline\n70& +3& \\\\\\hline\n60& +2& \\\\\\hline\n50& 0& 50\\\\\\hline\n40& -2& \\\\\\hline\n30& -3& \\\\\\hline\n20& -4& \\\\\\hline\n10& -5& \\\\\\hline\n\\end{tabular}\n&\n\\subsection*{Ränge}\n\\end{tabular}\n\n\\subsection*{Besondere Besitztümer}\n"+
				input[78]+";"+ input[79]+";"+ input[80]+";"+ input[81]+";"+input[82]+";"+ input[83]+"\n\\subsection*{Beutel}\n\\end{document}"; 
		try{
			if(texfile != null){
			write=new FileWriter(texfile);
			write.write(rohtext);}
			
		}catch(IOException e){
			System.err.println("Fehler beim Speichern");
		}
		finally {
			if(write != null){
			try{ write.close(); }catch(IOException e){}
			}
		}
		
		try{
			Process p = Runtime.getRuntime().exec(texcommand);
			System.out.println("texfile compiled succesfully:" +filename);
		}catch (IOException e) {
		            System.out.println("Fehler - Trace: ");
		            e.printStackTrace();
		            System.exit(-1);
		}
	}
	
	
}
