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
/*//initialisation of charsheet
	 int a = 50;
     int b = 5;
     int c = 20;
     String d = "name namerson";
     String e = "canado-asian";
     String f = "Arschkriecher";
     String g = "Bla und Blubb";
     String[] h = {"rödeln", "dödeln", "blasen"};
     String[] i = {"talent", "los"};
     String j = "strength";
     String k = "weakness";
     int[] l = {0,0,0,0,0,0,0,0,0,0};
     int[] m = {0,0,0,0,0,0,0,0,0,0};
     int[] n = {0,0,0};
     String o = "neutral";
     String p = "kulturell";
     String[] q = {"her", "hin"};
     int r = 42;
     String[] s = {"bla", "blubb"};
     Weapon t = new Weapon("zerhackender Zerhacker", 0,0,0,0,0, "fleisch");
     Weapon u = new Weapon("zerhackender Zerhacker", 0,0,0,0,0, "fleisch");
     Armor[] v = {new Armor("hut","kopf", "eisen",0,0 ), new Armor("hut","kopf", "eisen",0,0)};
     Spell[] w = {new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut")};
     String x = "chinesisch";
     String y = "Religion";
     String z = "dritte Hand";
     String ar = "aphatisch";
	*/
	final String QUIT = "QUIT";
	final String SHOW = "SHOW";
	final String NEXT = "NEXT";
	final String PREVIOUS = "PREVIOUS";
	final String HTML = "HTML";
    CharacterSheet charsheet;// = new CharacterSheet(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,ar);
    JPanel steps;
    JComboBox combo;
    JTextField text;
    JButton button;
    JList list;
     //declaration
	XmlActionListener(CharacterSheet charsheet, JPanel steps){
	this.charsheet = charsheet;
	this.steps = steps;
}
	XmlActionListener(CharacterSheet charsheet, JButton button){
		this.charsheet = charsheet;
		this.button = button;
	}
	XmlActionListener(CharacterSheet charsheet, JComboBox combo){
		this.charsheet = charsheet;
		this.combo = combo;
	}
	XmlActionListener(CharacterSheet charsheet, JTextField text){
		this.charsheet = charsheet;
		this.text = text;
	}
	XmlActionListener(CharacterSheet charsheet, JList list){
		this.charsheet= charsheet;
		this.list = list;
	}
//performance of action
	public void actionPerformed(ActionEvent e){
	String cmd = e.getActionCommand();
	
	if(cmd.equals(HTML)){
		CardLayout c1 = (CardLayout) (steps.getLayout());
		charsheet.exportAsHTML();
	
	}else if (cmd.equals(NEXT)){
		CardLayout c1 = (CardLayout) (steps.getLayout());
		c1.next(steps);
	
	}else if(cmd.equals(PREVIOUS)){
		CardLayout c1 = (CardLayout) (steps.getLayout());
		c1.previous(steps);
	
	}else if(cmd.equals(SHOW)){
		CardLayout c1 = (CardLayout) (steps.getLayout());
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
		charsheet.Hitpoints = Integer.parseInt(text.getText());
	
	}else if(cmd.equals("ENERGY")){
		charsheet.Energy = Integer.parseInt(text.getText());
	
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
		charsheet.Strength = combo.getSelectedItem().toString();
		
	}else if(cmd.equals("WEAK")){
		charsheet.Weakness = combo.getSelectedItem().toString();
	
	}else if(cmd.equals("ALI")){
		charsheet.Alignment = combo.getSelectedItem().toString();

		
	
	}else if(cmd.equals("ABIL")){
		int[] selectedIndices = list.getSelectedIndices();
		for (int i=0; i<selectedIndices.length; i++){
			String elem = (String) list.getModel().getElementAt(selectedIndices[i]);
			charsheet.Abilities[i] = elem;
		}
	
	}else if(cmd.equals("SPELL")){
		int[] selectedIndices = list.getSelectedIndices();
		String selectedElement = (String) list.getModel().getElementAt(selectedIndices[0]);
		for (int i=1; i<selectedIndices.length; i++){
			int j=selectedIndices[i];
			String elem = (String) list.getModel().getElementAt(selectedIndices[i]);
			charsheet.Spells[i] = charsheet.completeSpells[j];
			selectedElement += "; "+ elem;
		}
	
	}else if(cmd.equals("MELEE")){
		String art = combo.getSelectedItem().toString();
		if(art.equals("Stab")){
			charsheet.Melee.Name="Stab";
		}else if (art.equals("Dolch")){

			charsheet.Melee.Name="Schwertdolch";
		}else if (art.equals("Fechtwaffe")){
			charsheet.Melee.Name="Trinidischer Rapier";
			
		}else if (art.equals("Einhandschwert")){
			charsheet.Melee.Name="Kurzschwert";
			
		}else if (art.equals("Zweihandschwert")){

			charsheet.Melee.Name="Bastardschwert";
		}else if (art.equals("Einhandaxt")){

			charsheet.Melee.Name="Kriegsbeil";
		}else if (art.equals("Zweihandaxt")){

			charsheet.Melee.Name="Henkersbeil";
		}else if (art.equals("Einhandstreitkolben")){

			charsheet.Melee.Name="Morgenstern";
		}else if (art.equals("Zweihandstreitkolben")){

			charsheet.Melee.Name="Schlachthammer";
		}else if (art.equals("Lanze")){

			charsheet.Melee.Name="Speer";
		}
	
	}else if(cmd.equals("RAN")){
		String art = combo.getSelectedItem().toString();
		if(art.equals("Bogen")){
			charsheet.Range.Name="Primitivbogen";
			charsheet.Range.AmmoName="Kriegspfeil";
		}else if (art.equals("Armbrust")){
			charsheet.Range.Name="Balester";
			charsheet.Range.AmmoName="Steinkugel";
		}
	
	}else if(cmd.equals("ARM")){
		String art = combo.getSelectedItem().toString();
		if(art.equals("Stoff")){
			charsheet.Armor[0].Name="leichte Bekleidung";
			
		}else if (art.equals("Leder")){
			charsheet.Armor[0].Name="Lederwams";
			
		}else if (art.equals("Metall")){
			charsheet.Armor[0].Name="Kettenhemd";
			
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
		
	}
	}
}
