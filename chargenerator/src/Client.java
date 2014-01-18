import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Client, provides functionality to connect to a central server
 * 
 */
public class Client extends Thread {

	final String ESC = "§";
	private CharacterSheet charsheet;
	public String IP;
	public Client(CharacterSheet charsheet){
		this.charsheet = charsheet;
	}
	
	public void run(){
	
		JFrame f = new JFrame("Client zum Senden");
		
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		f.setSize( 600, 60 );
		f.setLayout(new GridLayout());
		
		JLabel ipl = new JLabel ("IP- Adresse des Servers angeben:");
		JTextField ip = new JTextField(5);
		ip.setActionCommand("IP");
		ip.addActionListener(new XmlActionListener(this, ip));
		ipl.setLabelFor(ip);
		
		f.add(ipl);
		f.add(ip);
		f.setVisible(true);
		
	}
	
	public void send(){
		Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            clientSocket = new Socket(IP, 1337);

            System.out.println("Successfully connected to server.");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String fromServer, toServer = null;
            
            while ((fromServer = in.readLine()) != null) {
            	 String[]   splitInput = fromServer.split(ESC);
            	 String msgtype = splitInput[0];
                 if (msgtype.equals("end")) {
                     break;
                 }
            	 toServer = "code" + ESC + charsheet.Name+ESC+
            			   charsheet.Race+ESC
            			   + charsheet.Culture +ESC
            			   +charsheet.Archetype+ESC
            			   +charsheet.Religion+ESC+
            			   charsheet.Gender+ESC+
            			   String.valueOf(charsheet.Age)+ESC+
            			   charsheet.Language+ESC+
            			   charsheet.Hand+ESC+
            			   charsheet.Look+ESC
            			   +String.valueOf(charsheet.Hitpoints)+ESC+
            			   String.valueOf(charsheet.Energy)+ESC+
            			   String.valueOf(charsheet.Stats[0])+ESC+
            			   String.valueOf(charsheet.Stats[1])+ESC+
            			   String.valueOf(charsheet.Stats[2])+ESC+
            			   String.valueOf(charsheet.Stats[3])+ESC+
            			   String.valueOf(charsheet.Stats[4])+ESC+
            			   String.valueOf(charsheet.Stats[5])+ESC+
            			   String.valueOf(charsheet.Stats[6])+ESC+
            			   String.valueOf(charsheet.Stats[7])+ESC+
            			   String.valueOf(charsheet.Stats[8])+ESC+
            			   charsheet.Talents[0]+ESC+charsheet.Talents[1]+ESC+
            			   charsheet.Abilities[0]+ESC+charsheet.Abilities[1]+ESC+charsheet.Abilities[2]+ESC+
            			   charsheet.Strength+ESC+charsheet.Weakness+ESC+
            			   charsheet.Alignment+ESC+
            			   charsheet.Melee.Name+ESC+charsheet.Melee.Material+ ESC+charsheet.Melee.Attack+ESC+charsheet.Melee.Block+ESC+String.valueOf(charsheet.Melee.Break)+ESC+
            			   charsheet.Melee2.Name+ESC+charsheet.Melee2.Material+ESC+charsheet.Melee2.Attack+ESC+charsheet.Melee2.Block+ESC+String.valueOf(charsheet.Melee2.Break)+ESC+
            			   charsheet.Range.Name+ESC+charsheet.Range.Distance+ESC+String.valueOf(charsheet.Range.Break)+ESC+
            			   charsheet.Range.AmmoName +ESC+charsheet.Range.Attack+ESC+
            			   charsheet.Spells[0].Name + ESC+ charsheet.Spells[0].Prerequisites+ESC+charsheet.Spells[0].Effect+ESC+
            			   charsheet.Spells[1].Name + ESC+ charsheet.Spells[1].Prerequisites+ESC+charsheet.Spells[1].Effect+ESC+
            			   charsheet.Spells[2].Name + ESC+ charsheet.Spells[2].Prerequisites+ESC+charsheet.Spells[2].Effect+ESC+
            			   charsheet.Spells[3].Name + ESC+ charsheet.Spells[3].Prerequisites+ESC+charsheet.Spells[3].Effect+ESC+
            			   charsheet.Armor[0].Name + ESC+charsheet.Armor[0].Sort+ESC+String.valueOf(charsheet.Armor[0].Protection)+ESC+charsheet.Armor[0].Break+ESC+
            			   charsheet.Armor[1].Name + ESC+charsheet.Armor[1].Sort+ESC+String.valueOf(charsheet.Armor[1].Protection)+ESC+charsheet.Armor[1].Break+ESC+
            			   String.valueOf(charsheet.Armor[0].Protection+ charsheet.Armor[1].Protection)+ESC+
            			   String.valueOf(charsheet.Skills[0])+ESC+
            			   String.valueOf(charsheet.Skills[6])+ESC+
            			   String.valueOf(charsheet.Skills[1])+ESC+
            			   String.valueOf(charsheet.Skills[7])+ESC+
            			   String.valueOf(charsheet.Skills[2])+ESC+
            			   String.valueOf(charsheet.Skills[8])+ESC+
            			   String.valueOf(charsheet.Skills[3])+ESC+
            			   String.valueOf(charsheet.Skills[9])+ESC+
            			   String.valueOf(charsheet.Skills[4])+ESC+
            			   String.valueOf(charsheet.Skills[10])+ESC+
            			   String.valueOf(charsheet.Skills[5])+ESC+
            			   String.valueOf(charsheet.Skills[11])+ESC+
            			   charsheet.SpecialItems[0]+ESC+
            			   charsheet.SpecialItems[1]+ESC+charsheet.SpecialItems[2]+ESC+charsheet.SpecialItems[3]+ESC+charsheet.SpecialItems[4]+ESC+charsheet.SpecialItems[5]+ESC;
            	 
            	 out.println(toServer);
                 System.out.println("Request to server: " + toServer);
            	 
	}
            System.out.println("Leaving client program...");
            out.close();
            in.close();
            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
}
}
