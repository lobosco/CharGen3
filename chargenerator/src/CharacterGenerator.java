import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

//import libraries
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

public class CharacterGenerator {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    
        
         // initial values, basically all gibberish, except for l, which has to be all zeros
         int a = 0; //hp
         int b = 0; //energy
         int c = 0; //age
         String d = "Name";//name
         String e = " ";//race
         String f = " ";//archetype
         String g = " ";//look
         String[] h = {" ", " ", " "};//abilities 
         String[] i = {" ", " "};//talents
         String j = " ";  //strength
         String k = " ";  //weakness
         int[] l = {0,0,0,0,0,0,0,0,0,0};//stats
         int[] m = {0,0,0,0,0,0,0,0,0,0,0,0};//skills
         int[] n = {0,0,0};//money
         String o = " ";//gender
         String p = " ";//culture
         String[] q = {" ", " "};//bag
         int r = 0;//level
         String[] s = {" ", " ", " ", " ", " ", " "};//Special Items
         Weapon t = new Weapon(" ", 0," "," "," ", " ", " ");//melee
         Weapon t1 = new Weapon(" ", 0," "," "," ", " ", " ");//melee
         Weapon u = new Weapon(" ", 0," "," "," ",  " ", " ");//range
         Armor[] v = {new Armor(" "," ", " ",0," " ), new Armor(" "," ", " ",0," ")};//armor
         Spell[] w = {new Spell(" ", " ", " "), new Spell(" ", " ", " "), new Spell(" ", " ", " "), new Spell("", "", "")};//spells
         String x = " ";//language
         String y = " ";//religion
         String z = " ";//hand
         String ar = " ";//alignment
        
         //other initializations/variables
         final String TEXT = "<html>Herzlich Willkommen zum Charaktergenerator 3.01.<p/> Dieses Programm ist angepasst auf die Version 3.0 des Amuntalon-Regelwerkes.<p/> Dieses Programm dient nur der Ergänzung und kann das Regelwerk nicht ersetzen. <p/> Es ist deshalb angeraten, das Regelbuch griffbereit zu halten.<p/><p/>" +
 				"LICENSE: <p/> Dieses Programm wurde unter der GNU General Public License Version 3 veröffentlicht<p/><p/>Bitte wählen Sie Ihre gewünschte Regelwerksversion aus: </html>";
         
         //initializes Character Sheet
         CharacterSheet charsheet = new CharacterSheet(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t, t1,u,v,w,x,y,z,ar);
         
         //initializes first 
         JFrame window = new JFrame("Charakterbogengenerator");
         JLabel text = new JLabel(TEXT);
         JButton amun = new JButton("Amuntalon Grundversion");
         amun.setActionCommand("AMUN");
         amun.addActionListener(new XmlActionListener(charsheet,amun));
         Container pane = window.getContentPane();
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JPanel versions = new JPanel(new GridBagLayout());
         pane.add(text, BorderLayout.CENTER);
         versions.add(amun);
         pane.add(versions, BorderLayout.PAGE_END);
         window.setSize(800,600);
         window.setVisible(true);
         
  
   }
}
