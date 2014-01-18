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
        String msgtype = "";
        String fromClient, toClient = null;
        
        toClient = "awaiting§ requests";
        out.println(toClient);
        System.out.println("Sent Message: " + toClient);
        while ((fromClient = in.readLine()) != null) {
            System.out.println("Received message: " + fromClient);
            toClient = "end§hallo"; 
            this.input = fromClient.split("§"); 
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
		
		String Sheet = "hallo";//hier ist noch der html-Code einzusetzen
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
		String text="hallo"; // auch hier ist noch die html-implementierung einzusetzen
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
	
	
	
	public void compileTex(String[] input){
		
	}
	
	
}
