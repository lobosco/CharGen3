/*
Character Generator 3.0 - a simple Generator for Character Sheets compliant with Version 3.0 of the Amuntalon Rules

Copyright (C) 2013 Wolfgang Knopki

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    

*/

import java.awt.CardLayout;
import javax.swing.*;
import java.awt.event.*;

public class XmlActionListener implements ActionListener {
	final String QUIT = "QUIT";
	final String SHOW = "SHOW";
	final String NEXT = "NEXT";
	final String PREVIOUS = "PREVIOUS";
	final String HTML = "HTML";
	final String SND = "SND";
    CharacterSheet charsheet;
    JPanel steps;
    JComboBox combo;
    JTextField text;
    JButton button;
    JList list;
    JFrame frame;
    JComboBox combo1;
    JComboBox combo2;
    JLabel Label;
    Client client;
    ServerThread server;
     //declaration
	XmlActionListener(CharacterSheet charsheet, JPanel steps){
	this.charsheet = charsheet;
	this.steps = steps;
}
	XmlActionListener(CharacterSheet charsheet, JPanel steps, JFrame frame){
		this.charsheet = charsheet;
		this.steps = steps;
		this.frame=frame;
	}
	XmlActionListener(CharacterSheet charsheet, JButton button){
		this.charsheet = charsheet;
		this.button = button;
	}
	XmlActionListener(Client client, JTextField text){
		this.client = client;
		this.text = text;
	}
	XmlActionListener(Client client, JButton button){
		this.client = client;
		this.button = button;
	}
	XmlActionListener(ServerThread server, JButton button){
		this.server = server;
		this.button = button;
	}
	XmlActionListener(ServerThread server, JPanel panel){
		this.server = server;
		this.steps = panel;
	}
	XmlActionListener(CharacterSheet charsheet, JComboBox combo){
		this.charsheet = charsheet;
		this.combo = combo;
	}
	XmlActionListener(CharacterSheet charsheet, JComboBox combo, JFrame frame){
		this.charsheet = charsheet;
		this.combo = combo;
		this.frame = frame;
	}
	XmlActionListener(CharacterSheet charsheet, JTextField text){
		this.charsheet = charsheet;
		this.text = text;
	}
	XmlActionListener(CharacterSheet charsheet, JList list){
		this.charsheet= charsheet;
		this.list = list;
	}XmlActionListener(CharacterSheet charsheet, JList list, JComboBox steps, JComboBox steps1, JComboBox steps2){
		this.charsheet= charsheet;
		this.list = list;
		this.combo=steps;
		this.combo1=steps1;
		this.combo2=steps2;
	}
	XmlActionListener(CharacterSheet charsheet, JFrame frame){
		this.charsheet = charsheet;
		this.frame = frame;
	}
//performance of action
	public void actionPerformed(ActionEvent e){
	String cmd = e.getActionCommand();
	
	if(cmd.equals(HTML)){
		charsheet.exportAsHTML();
	
	}else if(cmd.equals(SND)){
	charsheet.send();
	}else if(cmd.equals("HTMLS")){
		server.exportashtml(server.input);
	}else if(cmd.equals("TEX")){
		server.compileTex(server.input);
	}else if(cmd.equals("IP")){
		client.IP = text.getText();
		client.send();
	}else if (cmd.equals(NEXT)){
		CardLayout c1 = (CardLayout) (steps.getLayout());
		c1.next(steps);
	
	}else if(cmd.equals(PREVIOUS)){
		CardLayout c1 = (CardLayout) (steps.getLayout());
		c1.previous(steps);
	
	}else if(cmd.equals(SHOW)){
		charsheet.show();
	
	}else if(cmd.equals(QUIT)){
		System.exit(0);
	
	}else if(cmd.equals("RACE")){
		charsheet.Race = combo.getSelectedItem().toString(); 
	
	}else if(cmd.equals("CULTURE")){
		charsheet.Culture = combo.getSelectedItem().toString(); 
	
	}else if(cmd.equals("ARCHETYPE")){
		charsheet.Archetype = combo.getSelectedItem().toString(); 
	
	}else if(cmd.equals("RELIGION")){
		charsheet.Religion = combo.getSelectedItem().toString(); 
	
	}else if(cmd.equals("GENDER")){
		charsheet.Gender = combo.getSelectedItem().toString(); 
	
	}else if (cmd.equals("NAME")){
		charsheet.Name = text.getText();
	
	}else if (cmd.equals("AGE")){
	charsheet.Age = Integer.parseInt(text.getText());	
	
	}else if(cmd.equals("HAND")){
		charsheet.Hand = combo.getSelectedItem().toString(); 
	
	}else if(cmd.equals("LOOK")){
		charsheet.Look = text.getText(); 
	
	}else if (cmd.equals("STEP1")){
		charsheet.setSpellList(charsheet);
		charsheet.raceMod(charsheet);
		int[] selectedIndices = list.getSelectedIndices();
		String selectedElement = (String) list.getModel().getElementAt(selectedIndices[0]);
		for (int i=1; i<selectedIndices.length; i++){
			String elem = (String) list.getModel().getElementAt(selectedIndices[i]);
			selectedElement += "; "+ elem;
		}
		charsheet.Language=selectedElement;
	}else if(cmd.equals("HP")){
		charsheet.Hitpoints += Integer.parseInt(text.getText());
	
	}else if(cmd.equals("ENERGY")){
		charsheet.Energy += Integer.parseInt(text.getText());
	
	}else if(cmd.equals("INT")){
		charsheet.Stats[0]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("CHARI")){
		charsheet.Stats[1]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("GESCH")){
		charsheet.Stats[2]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("SCHNELL")){
		charsheet.Stats[3]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("KRAFT")){
		charsheet.Stats[4]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("AUSD")){
		charsheet.Stats[5]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("MUT")){
		charsheet.Stats[6]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("WACHS")){
		charsheet.Stats[7]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("INTU")){
		charsheet.Stats[8]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("STRENGTH")){
		charsheet.Strength += combo.getSelectedItem().toString();
		
	}else if(cmd.equals("WEAK")){
		charsheet.Weakness += combo.getSelectedItem().toString();
	
	}else if(cmd.equals("ALI")){
		charsheet.Alignment = combo.getSelectedItem().toString();
	
	}else if(cmd.equals("ABIL")){
		int[] selectedIndices = list.getSelectedIndices();
		for (int i=0; i<selectedIndices.length; i++){
			String elem = (String) list.getModel().getElementAt(selectedIndices[i]);
			charsheet.Abilities[i] = elem;
		}
	
	}else if(cmd.equals("SPELL")){
		charsheet.setVampWereDuel(charsheet);
		DefaultComboBoxModel meleemod = new DefaultComboBoxModel(charsheet.meleeList);
		DefaultComboBoxModel rangemod = new DefaultComboBoxModel(charsheet.rangeList);
		DefaultComboBoxModel armormod = new DefaultComboBoxModel(charsheet.armorTypeList);
		
		combo.setModel(meleemod);
		combo1.setModel(rangemod);
		combo2.setModel(armormod);
		int[] selectedIndices = list.getSelectedIndices();
	    for (int i=0; i<selectedIndices.length; i++){
			int j=selectedIndices[i];
	        charsheet.Spells[i] = charsheet.completeSpells[j];
		}
	
	}else if(cmd.equals("MELEE")){
		String art = combo.getSelectedItem().toString();
		if(art.equals("Stab")){
			charsheet.Melee.Name="Stab";
			charsheet.Melee.Material="Haselnuss";
			charsheet.Melee.Break=3;
			charsheet.Melee.Attack="2W6+3";
			charsheet.Melee.Block="1W6+2";
		
		}else if (art.equals("Dolch")){

			charsheet.Melee.Name="Schwertdolch";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="1W6+4";
			charsheet.Melee.Block="1W6+3";
		
		}else if (art.equals("Fechtwaffe")){
			charsheet.Melee.Name="Trinidischer Rapier";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="1W6+4";
			charsheet.Melee.Block="1W6+4";
            charsheet.Stats[3]+=2;
            charsheet.Stats[2]-=1;
		}else if (art.equals("Einhandschwert")){
			charsheet.Melee.Name="Kurzschwert";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="2W6+1";
			charsheet.Melee.Block="2W6+2";
		
		}else if (art.equals("Zweihandschwert")){

			charsheet.Melee.Name="Bastardschwert";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="3W6+1";
			charsheet.Melee.Block="2W6+2";
		
		}else if (art.equals("Einhandaxt")){

			charsheet.Melee.Name="Kriegsbeil";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="2W6+1";
			charsheet.Melee.Block="2W6+1";
		
		}else if (art.equals("Zweihandaxt")){

			charsheet.Melee.Name="Henkersbeil";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="3W6+2";
			charsheet.Melee.Block="2W6+2";
		
		}else if (art.equals("Einhandstreitkolben")){

			charsheet.Melee.Name="Morgenstern";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="2W6+3";
			charsheet.Melee.Block="1W6+4";
		
		}else if (art.equals("Zweihandstreitkolben")){

			charsheet.Melee.Name="Schlachthammer";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="3W6+3";
			charsheet.Melee.Block="2W6+1";
		
		}else if (art.equals("Lanze")){

			charsheet.Melee.Name="Speer";
			charsheet.Melee.Material="Eisen";
			charsheet.Melee.Break=-1;
			charsheet.Melee.Attack="2W6+3";
			charsheet.Melee.Block="1W6+2";
		}
	}else if(cmd.equals("MELEE2")){
		String art = combo.getSelectedItem().toString();
		
		if (art.equals("Fechtwaffe")){
			charsheet.Melee2.Name="Trinidischer Rapier";
			charsheet.Melee2.Material="Eisen";
			charsheet.Melee2.Break=-1;
			charsheet.Melee2.Attack="1W6+4";
			charsheet.Melee2.Block="1W6+4";
            charsheet.Stats[3]+=2;
            charsheet.Stats[2]-=1;
		}else if (art.equals("Einhandschwert")){
			charsheet.Melee2.Name="Kurzschwert";
			charsheet.Melee2.Material="Eisen";
			charsheet.Melee2.Break=-1;
			charsheet.Melee2.Attack="2W6+1";
			charsheet.Melee2.Block="2W6+2";
		
				}else if (art.equals("Einhandaxt")){

			charsheet.Melee2.Name="Kriegsbeil";
			charsheet.Melee2.Material="Eisen";
			charsheet.Melee2.Break=-1;
			charsheet.Melee2.Attack="2W6+1";
			charsheet.Melee2.Block="2W6+1";
		
		}
		}else if(cmd.equals("RAN")){
		String art = combo.getSelectedItem().toString();
		if(art.equals("Bogen")){
			charsheet.Range.Name="Primitivbogen";
			charsheet.Range.AmmoName="Kriegspfeil";
			charsheet.Range.Attack="1W6+6";
			charsheet.Range.Distance="60/100";
			charsheet.Range.Break=5;//Genauigkeitswert 
		}else if (art.equals("Armbrust")){
			charsheet.Range.Name="Balester";
			charsheet.Range.AmmoName="Steinkugel";
			charsheet.Range.Attack="1W6+4";
			charsheet.Range.Distance="60/100";
			charsheet.Range.Break=5;//Genauigkeitswert
		}
	
	}else if(cmd.equals("ARM")){
		String art = combo.getSelectedItem().toString();
		if(art.equals("Stoff")){
			charsheet.Armor[0].Name="leichte Bekleidung";
			charsheet.Armor[0].Sort="Brust";
			charsheet.Armor[0].Protection=1;
			charsheet.Armor[0].Break="4/8/11";
		
		}else if (art.equals("Leder")){
			charsheet.Armor[0].Name="Lederwams";
			charsheet.Armor[0].Sort="Brust";
			charsheet.Armor[0].Protection=1;
			charsheet.Armor[0].Break="6/10";
		}else if (art.equals("Metall")){
			charsheet.Armor[0].Name="Kettenhemd";
			charsheet.Armor[0].Sort="Brust";
			charsheet.Armor[0].Protection=3;
			charsheet.Armor[0].Break="6";
			charsheet.Stats[2]-=1;
		}
	
	}else if(cmd.equals("wille")){
		charsheet.Skills[0]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("konz")){
		charsheet.Skills[1]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("init")){
		charsheet.Skills[2]+=Integer.parseInt(text.getText());
	
	}else if(cmd.equals("selbstb")){
		charsheet.Skills[3]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("gelenk")){
		charsheet.Skills[4]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("waffe")){
		charsheet.Skills[5]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("trag")){
		charsheet.Skills[6]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("reisev")){
		charsheet.Skills[7]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("reg")){
		charsheet.Skills[8]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("immun")){
		charsheet.Skills[9]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("glaube")){
		charsheet.Skills[10]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("glück")){
		charsheet.Skills[11]+=Integer.parseInt(text.getText());
		
	}else if(cmd.equals("SPECB")){
		charsheet.SpecialItems[0]=combo.getSelectedItem().toString();
		frame.dispose();
	}else if(cmd.equals("SPECH")){
		charsheet.SpecialItems[4]=combo.getSelectedItem().toString();
	    frame.dispose();
	}else if(cmd.equals("SPECG")){
		charsheet.Talents[0]="Waffenkenntnis:" + combo.getSelectedItem().toString();
	    frame.dispose();
	}else if(cmd.equals("SPECW")){
		charsheet.Talents[0]="Waffenkenntnis: " +combo.getSelectedItem().toString();
	    frame.dispose();
	}else if (cmd.equals("VWEAK")){
		charsheet.Weakness = "Sonnenlicht, Knoblauch, " + combo.getSelectedItem().toString();
	
	}else if (cmd.equals("VSTRENGTH")){
		charsheet.Strength= "Vampirreflexe, Untotes Leben, " + combo.getSelectedItem().toString();
	
	}else if (cmd.equals("WWEAK")){
		charsheet.Weakness = "Silber, Wolfsfluch, " + combo.getSelectedItem().toString();	
	
	}else if (cmd.equals("WSTRENGTH")){
		charsheet.Strength= "Wolfskraft, Lynusblut, " + combo.getSelectedItem().toString();
	}else if (cmd.equals("close")){
		frame.dispose();
	}
	
	}
}
