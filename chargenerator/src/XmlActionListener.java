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
import java.awt.event.*;

import javax.swing.JPanel;

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
     //declaration
	XmlActionListener(CharacterSheet charsheet, JPanel steps){
	this.charsheet = charsheet;
	this.steps = steps;
}
//performance of action
	public void actionPerformed(ActionEvent e){
	CardLayout c1 = (CardLayout) (steps.getLayout());
	String cmd = e.getActionCommand();
	if(cmd.equals(HTML)){
		charsheet.exportAsHTML();
	}else if (cmd.equals(NEXT)){
		c1.next(steps);
	}else if(cmd.equals(PREVIOUS)){
		c1.previous(steps);
	}else if(cmd.equals(SHOW)){
		charsheet.show();
	}else if(cmd.equals(QUIT)){
		System.exit(0);
	}
	}
}
