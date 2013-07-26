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

public class CharacterSheet {
 //List of Objects
	int Hitpoints;
	int Energy;
	int Age;
	String Name;
	String Race;
	String Archetype;
	String Look;
	String[] Abilities;
	String[] Talents;
	String Strength;
	String Weakness;
	int[] Stats;
	int[] Skills;
	int[] Money;
	String Gender;
	String Culture;
	String[] Bag;
	int Level;
	String[] SpecialItems;
	Weapon Melee;
	Weapon Range;
	Armor[] Armor;
	Spell[] Spells;
	String Language;
	String Alignment;
	String Hand;
	String Religion;
	
	
	/*initializes Character Sheet*/
	public CharacterSheet(int Hitpoints, int Energy, int Age, String Name, String Race, String Archetype,	String Look, String[] Abilities, String[] Talents, String Strength,	String Weakness, int[] Stats, int[] Skills,	int[] Money, String Gender,	String Culture,	String[] Bag, int Level, String[] SpecialItems, Weapon Melee, Weapon Range, Armor[] Armor, Spell[] Spells, String Language, String Religion, String Hand, String Alignment ){
		this.Hitpoints = Hitpoints;
		this.Energy = Energy;
		this.Age = Age;
		this.Name = Name;
		this.Race= Race;
		this.Archetype = Archetype;
		this.Look = Look;
		this.Abilities = Abilities;
		this.Talents = Talents;
		this.Strength = Strength;
		this.Weakness = Weakness;
		this.Stats = Stats;
		this.Skills = Skills;
		this.Money = Money;
		this.Gender = Gender;
		this.Culture = Culture;
		this.Bag = Bag;
		this.Level = Level;
		this.SpecialItems = SpecialItems;
		this.Melee = Melee;
		this.Range = Range;
		this.Armor = Armor;
		this.Spells = Spells;
		this.Religion = Religion;
		this.Language = Language;
		this.Hand = Hand;
		this.Alignment = Alignment;
	}
	
	
	public void show(){
		//initialize Window
		JFrame f = new JFrame("Charakterbogen");
		JPanel buttons = new JPanel(new GridBagLayout());
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		f.setSize( 800, 600 );
		//Layout
		GridBagConstraints cst = new GridBagConstraints();
		
		
		
		String Sheet = "<html>  " +
				"Name:   "+ this.Name + "<p/>"+
				"Rasse:   " + this.Race + "<p/>"+
				"Archetyp:   " + this.Archetype + "<p/>"+
				"Religion:   " + this.Religion + "<p/>"+
				"Geschlecht:   " + this.Gender + "<p/>"+
				"Alter:   " + String.valueOf(this.Age) + "<p/>"+
				"Aussehen:   " + this.Look + "<p/>"+
				"Kampfhand:   " + this.Hand + "<p/>"+
				"Leben:   " + String.valueOf(this.Hitpoints) +"<p/><p/>"+
				"Charakterwerte: <p/>"+
				"Intelligenz:   " + String.valueOf(this.Stats[1]) +"<p/>"+
				"Charisma:   " + String.valueOf(this.Stats[2]) +"<p/>"+
				"Geschicklichkeit:   " + String.valueOf(this.Stats[3]) +"<p/>"+
				"Schnelligkeit:   " + String.valueOf(this.Stats[4]) +"<p/>"+
				"Kraft:   " + String.valueOf(this.Stats[5]) +"<p/>"+
				"Ausdauer:   " + String.valueOf(this.Stats[6]) +"<p/>"+
				"Mut:   " + String.valueOf(this.Stats[7]) +"<p/>"+
				"Wachsamkeit:   " + String.valueOf(this.Stats[8]) +"<p/>"+
				"Intuition:   " + String.valueOf(this.Stats[9]) +"<p/><p/>"+
				"Klassentalente:   " + this.Talents[0]+ "   " + this.Talents[1] + "<p/>"+
				"Kenntnisse:   "+ this.Abilities[0] + "   "+this.Abilities[1] +"   "+ this.Abilities[2] + "<p/>"+
				"Stärke:   " + this.Strength + "<p/>"+
				"Schwäche:   " + this.Weakness + "<p/>"+
				"Gesinnung:   " + this.Alignment + "<p/>"+
				"Nahkampfwaffe:   " + this.Melee.Name +"   "+ this.Melee.Material +"   "+ String.valueOf(this.Melee.Attack)+"   " + String.valueOf(this.Melee.Block)+"   "+ String.valueOf(this.Melee.Break)+ "<p/><p/>"+
				"Fähigkeiten:<p/>"+
				this.Spells[1].Name+ "   " + this.Spells[1].Prerequisites+"   " + this.Spells[1].Effect+"   "+ "<p/>"+
				this.Spells[2].Name+ "   " + this.Spells[2].Prerequisites+"   " + this.Spells[2].Effect+"   "+ "<p/>"+
				this.Spells[3].Name+"   " + this.Spells[3].Prerequisites+"   " + this.Spells[3].Effect+ "<p/>"+
				this.Spells[3].Name + this.Spells[3].Prerequisites + this.Spells[3].Effect+ "<p/>"+
				"Rüstung:   " + this.Armor[1].Name + "<p/>"+
				"Moral:   " + String.valueOf(this.Level)+ "<p/>"+"</html>";
		JLabel l = new JLabel (Sheet);
		
		cst.fill = GridBagConstraints.HORIZONTAL;
		cst.gridheight=29;
		cst.gridwidth=2;
		cst.gridx=0;
		cst.gridy=0;
		buttons.add(l,cst);
		
		
		//Buttons
		JButton xml = new JButton ("Als HTML speichern");
		JPanel set = new JPanel(new CardLayout());
		xml.setActionCommand("HTML");
		xml.addActionListener( new XmlActionListener(this, set));
		
		JButton end = new JButton("Ohne Speichern beenden");
		
		ActionListener finish = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		end.addActionListener(finish);

		cst.fill = GridBagConstraints.HORIZONTAL;
		cst.gridwidth=1;
		cst.gridx=0;
		cst.gridy=30;
		buttons.add(end,cst);
		
		cst.fill = GridBagConstraints.HORIZONTAL;
		cst.gridx=1;
		cst.gridy=30;
		buttons.add(xml,cst);
		f.getContentPane().add(buttons);
		f.pack();
		f.setVisible ( true );
		
	}
	
	public void mainmenu (){
		final String TEXT = "<html>Herzlich Willkommen zum Charaktergenerator 3.00.<p/> Dieses Programm ist angepasst auf die Version 3.0 des Amuntalon-Regelwerkes.<p/> Bitte folgen Sie den Anweisungen auf dem Bildschirm.<p/><p/>" +
				"LICENSE: <p/> Dieses Programm wurde unter der GNU General Public License Version 3 veröffentlicht</html>";
		//Main Window
        JFrame fi = new JFrame( "Willkommen" );
		fi.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		fi.setSize( 800, 600 );
		
		JLabel li = new JLabel( TEXT );
		//Buttons
		JPanel buttons = new JPanel(new GridBagLayout());
		JButton xml = new JButton("Als HTML speichern");
		JButton bu = new JButton("Ohne Speichern beenden");
		
		//Layout
		GridBagConstraints cst = new GridBagConstraints();
		
		//panel for ActionListener
		JPanel step = new JPanel(new CardLayout());	
        
        xml.setActionCommand("HTML");
		xml.addActionListener(new XmlActionListener(this, step));
		
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		bu.addActionListener(al);
		//positions buttons
		cst.gridheight=30;
		cst.gridwidth=2;
		cst.gridx=0;
		cst.gridy=0;
		buttons.add(li, cst);
		cst.gridheight=1;
		cst.gridwidth=1;
		cst.gridx=0;
		cst.gridy=31;
		buttons.add( bu, cst );
		cst.gridx=1;
		cst.gridy=31;
		buttons.add(xml,cst);
		
        //assembles window
		fi.getContentPane().add(buttons);
		fi.pack();
		fi.setVisible ( true );
		
	}
	public void exportAsHTML(){
		System.out.println("Wurde als HTML exportiert");
	}
	
	public void setStats(){
		//button commands:
		final String SHOW = "SHOW";
		final String NEXT = "NEXT";
		final String PREVIOUS = "PREVIOUS";
		final String HTML = "HTML";
		final String QUIT = "QUIT";
		
		//creating window
		JFrame window = new JFrame("Charakterbogengenerator");
		JPanel steps = new JPanel(new CardLayout());
		
		//Buttons
		XmlActionListener listener = new XmlActionListener(this, steps);
		
		JButton next = new JButton("Weiter");
		next.setActionCommand(NEXT);
		next.addActionListener(listener);
		
		JButton quit = new JButton("Ohne Speichern beenden");
		quit.setActionCommand(QUIT);
		quit.addActionListener(listener);
		
		JButton previous = new JButton("Zurück");
		previous.setActionCommand(PREVIOUS);
		previous.addActionListener(listener);
		
		JButton show = new JButton("Anzeigen");
		show.setActionCommand(SHOW);
		show.addActionListener(listener);
		JPanel buttons = new JPanel();
		buttons.add(previous);
		buttons.add(next);
		buttons.add(show);
		buttons.add(quit);
		
		//creating individual subwindows
		JPanel step1 = new JPanel();
		step1.add(new JLabel("erster Schritt"));
		
		JPanel step2 = new JPanel();
		step2.add(new JLabel("zweiter Schritt"));
		steps.add(step1);
		steps.add(step2);
		
		//assembling the windows
		Container pane = window.getContentPane();
		pane.add(steps, BorderLayout.CENTER);
		pane.add(buttons, BorderLayout.PAGE_END);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800,600);
		window.setVisible(true);
	}
  //further methods are obsolete
	public void setName(){
    	
    }
	public void setRace(){
		
	}
	public void setArchetype(){
		
	}
	public void setLook(){
		
	}
	public void setAge(){
		
	}
	public void setMelee(){
		
	}
	public void setRange(){
		
	}
	public void setAbilities(){
		
	}
	public void setStrength(){
		
	}
	public void setWeakness(){
	
	}
	public void setTalents(){
		
	}
	public void setArmor(){
		
	}
	public void setSkills(){
		
	}
	public void setMoney(){
		
	}
	public void setCulture(){
		
	}
	public void setGender(){
		
	}
	public void setBag(){
		
	}
	public void setSpecialItems(){
		
	}
	public void setSpells(){
		
	}
	public void setLevel(){
		
	}
	public void setEnergy(){
		
	}

	}
