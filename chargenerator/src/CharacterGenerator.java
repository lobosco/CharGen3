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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterGenerator {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    
        
         // initial values, basically all gibberish, except for l, which has to be all zeros
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
         int[] m = {0,0,0,0,0,0,0,0,0,0,0,0};
         int[] n = {0,0,0};
         String o = "neutral";
         String p = "kulturell";
         String[] q = {"her", "hin"};
         int r = 42;
         String[] s = {"bla", "blubb"};
         Weapon t = new Weapon("zerhackender Zerhacker", 0,0,0,0,0, "fleisch", "kuh");
         Weapon u = new Weapon("zerhackender Zerhacker", 0,0,0,0,0, "fleisch", "kuh");
         Armor[] v = {new Armor("hut","kopf", "eisen",0,0 ), new Armor("hut","kopf", "eisen",0,0)};
         Spell[] w = {new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut")};
         String x = "chinesisch";
         String y = "Religion";
         String z = "dritte Hand";
         String ar = "aphatisch";
        
         //initializes Character Sheet
         CharacterSheet charsheet = new CharacterSheet(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,ar);

         charsheet.setStats();
  
   }
}
