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
	
	//declaring constants
	final String[] RACELIST = {"Amazone", "Amunier", "Bergzwerg", "Dathure", "Elf", "Gnom", "Grimmtaure", "Halbelf", "Hügelzwerg", "Kobold", "Minotaur", "Nordländer", "Ork", "Taravellaner", "Scantare", "Schattenelf", "Talonier", "Trinide", "Wanure","Zentaur" };
	final String[] ARCHETYPELIST = {"Magier", "Beschwörer", "Druide", "Nekromant", "Schamane", "Hexendoktor", "Arkanist", "Krieger", "Ritter", "Baphosritter", "Hüter", "Berserker", "Waffenmeister", "Duellant", "Späher", "Jäger", "Waldläufer", "Pirat", "Dieb", "Assassine", "Gaukler", "Scharlatan", "Hexenjäger", "Alchemist", "Drachenjäger", "Kleriker", "Hohepriester", "Inquisitor", "Arzt", "Barde", "Vampir", "Werwolf"};
	final String[] CULTURELIST = {"Arquill", "Denquill", "Brenland", "Tarek", "Tjam-Wüste", "Wisha Küste", "Tundra", "Bergland", "Fjordland", "Trinidas", "Nebelmarschen", "Sieben Ebenen", "Kristallwüste", "Tortaja und Girada", "Roma", "Dathuria", "Elfen", "Schattenelfen", "Bergzwerge", "Hügelzwerge"};
	final String[] LANGUAGELIST = {"Moiar", "Bhasa", "Run Mor", "Suara", "Barach", "Draak Huil", "Duwia", "Latanis", "Ingelesa", "Gerunnik", "Aggara"};
	final String[] TALENTLIST = {};
	final String[] ALIGNMENTLIST = {"aufopfernd", "neutral", "skrupellos"};
	final String[] GENDERLIST = {"männlich", "weiblich"};
	final String[] ABILITYLIST = {"Kochen", "Schreiben", "Rechnen", "Feuer machen", "Malen", "Klettern", "Schwimmen", "Reiten", "Erste Hilfe", "Kräuterkunde", "Schnitzen", "Nähen", "Schmieden", "Bergbau", "Giftherstellung", "Alchemie", "Kürschnern", "Astrologie", "Etikette", "Seefahrt", "Abrichten", "Religion", "Tierkunde", "Gesteinskunde", "Navigation", "Schätzen", "Überreden", "Feilschen", "Gesteinskenntnisse", "Geschichten und Legenden", "Musizieren", "Sprachkenntnisse: Bhasa", "Sprachkenntnisse: Run Mor", "Sprachkenntnisse: Suara", "Sprachkenntnisse: Barach", "Sprachkenntnisse: Draak Huil", "Sprachkenntnisse: Duwia","Sprachkenntnisse: Latanis", "Sprachkenntnisse: Ingelesa","Sprachkenntnisse: Gerunnik", "Sprachkenntnisse: Aggara", "Schleichen", "Stehlen", "Zinken", "Angeln", "Knoten", "Schlösser knacken", "Betören", "Magiedilettant", "Astrale Hand", "Magiewissen"};
	final String[] RELIGIONLIST = {"Glaube der Zwölf: Aleus","Glaube der Zwölf: Ariasa","Glaube der Zwölf: Baphos","Glaube der Zwölf: Dragana","Glaube der Zwölf: Fyrnur","Glaube der Zwölf: Goran","Glaube der Zwölf: Lynus","Glaube der Zwölf: Maradur","Glaube der Zwölf: Rohmos","Glaube der Zwölf: Rorin","Glaube der Zwölf: Thoran","Glaube der Zwölf: Vita", "Ekadevata", "Sabbadon", "Das Dunkle Auge", "Ular"};
	final String[] STRENGTHLIST = {"Diplomat", "Logiker", "Optimist", "Muskulös", "Adlige Abstammung", "Akademiker", "Athletisch", "gut aussehend", "gelassen", "Makellos", "gläubig", "gerecht", "berühmt", "auserwählt"};
	final String[] WEAKNESSLIST = {"Angst", "Habgier", "Sturheit", "schüchtern", "Arroganz", "Einarmig", "Einbeinig", "blind", "fettleibig", "Gesucht", "aggressiv", "stumm", "Sprachfehler", "Pazifist", "depressiv", "emotionslos", "fanatisch"};
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
		final String TEXT = "<html>Herzlich Willkommen zum Charaktergenerator 3.00.<p/> Dieses Programm ist angepasst auf die Version 3.0 des Amuntalon-Regelwerkes.<p/> Dieses Programm dient nur der Ergänzung und kann das Regelwerk nicht ersetzen. <p/> Es ist deshalb angeraten, das Regelbuch griffbereit zu halten.<p/><p/>" +
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
		JPanel step1 = new JPanel(new GridBagLayout());
        GridBagConstraints gcs = new GridBagConstraints();
		
        JLabel n = new JLabel("Name:");
		JTextField name = new JTextField(30);
		name.setActionCommand("NAME");
		name.addActionListener(new XmlActionListener(this, name));
		n.setLabelFor(name);
		
		JLabel r = new JLabel("Rasse:");
		JComboBox race = new JComboBox(RACELIST);
		race.setActionCommand("RACE");
		race.addActionListener(new XmlActionListener(this, race));
		r.setLabelFor(race);
		
		JLabel c = new JLabel("Kultur:");
		JComboBox culture = new JComboBox(CULTURELIST);
		culture.setActionCommand("CULTURE");
		culture.addActionListener(new XmlActionListener(this, culture));
		c.setLabelFor(culture);
		
		JLabel a = new JLabel("Archetyp:");
		JComboBox archetype = new JComboBox(ARCHETYPELIST);
		archetype.setActionCommand("ARCHETYPE");
		archetype.addActionListener(new XmlActionListener(this, archetype));
		a.setLabelFor(archetype);
		
		JLabel rel = new JLabel("Religion/ Patron:");
		JComboBox religion = new JComboBox(RELIGIONLIST);
		religion.setActionCommand("RELIGION");
		religion.addActionListener(new XmlActionListener(this, religion));
		rel.setLabelFor(religion);
		
		JLabel gen = new JLabel("Geschlecht:");
		JComboBox gender = new JComboBox(GENDERLIST);
		gender.setActionCommand("GENDER");
		gender.addActionListener(new XmlActionListener(this, gender));
		gen.setLabelFor(gender);
		
		JLabel ag = new JLabel("Alter:"); 
		JTextField age = new JTextField(5);
		age.setActionCommand("AGE");
		age.addActionListener(new XmlActionListener(this, age));
		ag.setLabelFor(age);
		
		JLabel lan = new JLabel("Sprache:");
		JList language = new JList(LANGUAGELIST);
		JScrollPane scrolllan = new JScrollPane(language);
		lan.setLabelFor(language);
		JButton getstep1 = new JButton("Auswahl übernehmen");
		getstep1.setActionCommand("STEP1!");
		//getstep1.addActionListener(new XmlActionListener(this, name, race, culture, archetype, religion, gender, age, language))
		step1.setLayout(new GridLayout(9,2));
		
		step1.add(n);
		step1.add(name);
		step1.add(r);
		step1.add(race);
		step1.add(c);
		step1.add(culture);
		step1.add(a);
		step1.add(archetype);
		step1.add(rel);
		step1.add(religion);
		step1.add(gen);
		step1.add(gender);
		step1.add(ag);
		step1.add(age);
		step1.add(lan);
		step1.add(scrolllan);
		step1.add(getstep1);
		
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
