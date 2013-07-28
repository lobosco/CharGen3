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
	final String[] RACELIST = {"","Amazone", "Amunier", "Bergzwerg", "Dathure", "Elf", "Gnom", "Grimmtaure", "Halbelf", "Hügelzwerg", "Kobold", "Minotaur", "Nordländer", "Ork", "Taravellaner", "Scantare", "Schattenelf", "Talonier", "Trinide", "Wanure","Zentaur" };
	final String[] ARCHETYPELIST = {"","Magier", "Beschwörer", "Druide", "Nekromant", "Schamane", "Hexendoktor", "Arkanist", "Krieger", "Ritter", "Baphosritter", "Hüter", "Berserker", "Waffenmeister", "Duellant", "Späher", "Jäger", "Waldläufer", "Pirat", "Dieb", "Assassine", "Gaukler", "Scharlatan", "Hexenjäger", "Alchemist", "Drachenjäger", "Kleriker", "Hohepriester", "Inquisitor", "Arzt", "Barde", "Vampir", "Werwolf"};
	final String[] CULTURELIST = {"","Arquill", "Denquill", "Brenland", "Tarek", "Tjam-Wüste", "Wisha Küste", "Tundra", "Bergland", "Fjordland", "Trinidas", "Nebelmarschen", "Sieben Ebenen", "Kristallwüste", "Tortaja und Girada", "Roma", "Dathuria", "Elfen", "Schattenelfen", "Bergzwerge", "Hügelzwerge"};
	final String[] LANGUAGELIST = {"","Moiar", "Bhasa", "Run Mor", "Suara", "Barach", "Draak Huil", "Duwia", "Latanis", "Ingelesa", "Gerunnik", "Aggara"};
	final String[] ALIGNMENTLIST = {"", "aufopfernd", "neutral", "skrupellos"};
	final String[] GENDERLIST = {"", "männlich", "weiblich"};
	final String[] ABILITYLIST = {"", "Kochen", "Schreiben", "Rechnen", "Feuer machen", "Malen", "Klettern", "Schwimmen", "Reiten", "Erste Hilfe", "Kräuterkunde", "Schnitzen", "Nähen", "Schmieden", "Bergbau", "Giftherstellung", "Alchemie", "Kürschnern", "Astrologie", "Etikette", "Seefahrt", "Abrichten", "Religion", "Tierkunde", "Gesteinskunde", "Navigation", "Schätzen", "Überreden", "Feilschen", "Gesteinskenntnisse", "Geschichten und Legenden", "Musizieren", "Sprachkenntnisse: Bhasa", "Sprachkenntnisse: Run Mor", "Sprachkenntnisse: Suara", "Sprachkenntnisse: Barach", "Sprachkenntnisse: Draak Huil", "Sprachkenntnisse: Duwia","Sprachkenntnisse: Latanis", "Sprachkenntnisse: Ingelesa","Sprachkenntnisse: Gerunnik", "Sprachkenntnisse: Aggara", "Schleichen", "Stehlen", "Zinken", "Angeln", "Knoten", "Schlösser knacken", "Betören", "Magiedilettant", "Astrale Hand", "Magiewissen"};
	final String[] RELIGIONLIST = {"", "Glaube der Zwölf: Aleus","Glaube der Zwölf: Ariasa","Glaube der Zwölf: Baphos","Glaube der Zwölf: Dragana","Glaube der Zwölf: Fyrnur","Glaube der Zwölf: Goran","Glaube der Zwölf: Lynus","Glaube der Zwölf: Maradur","Glaube der Zwölf: Rohmos","Glaube der Zwölf: Rorin","Glaube der Zwölf: Thoran","Glaube der Zwölf: Vita", "Ekadevata", "Sabbadon", "Das Dunkle Auge", "Ular"};
	final String[] STRENGTHLIST = {"", "Diplomat", "Logiker", "Optimist", "Muskulös", "Adlige Abstammung", "Akademiker", "Athletisch", "gut aussehend", "gelassen", "Makellos", "gläubig", "gerecht", "berühmt", "auserwählt"};
	final String[] WEAKNESSLIST = {"", "Angst", "Habgier", "Sturheit", "schüchtern", "Arroganz", "Einarmig", "Einbeinig", "blind", "fettleibig", "Gesucht", "aggressiv", "stumm", "Sprachfehler", "Pazifist", "depressiv", "emotionslos", "fanatisch"};
    final String[] HANDLIST = {"", "links", "rechts"}; 
    final Spell INITSPELL = new Spell("ecki", "ecki", "pateng");
    final String LEDER = "Leder";
    final String STOFF = "Stoff";
    final String EISEN = "Metall";
    final String STAB = "Stab";
    final String EINSCHWERT = "Einhandschwert";
    final String ZWEISCHWERT = "Zweihandschwert";
    final String EINAXT = "Einhandaxt";
    final String ZWAXT = "Zweihandaxt";
    final String FE = "Fechtwaffe";
    final String DO = "Dolch";
    final String B = "Bogen";
    final String A = "Armbrust";
    final String EINSK = "Einhandstreitkolben";
    final String ZWEISK = "Zweihandstreitkolben";
    final String PILUM = "Lanze";
    //final Weapon INITWEAPON = new Weapon();
    //final Armor INITARMOR = new Armor();
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
	String[] listOfSpells = {"hallo", "hier", "hirt", "bla", "blubb", "blubb"};
	Spell[] completeSpells = {INITSPELL, INITSPELL, INITSPELL, INITSPELL, INITSPELL, INITSPELL};
	String[] meleeList = {"", "", "", "", "", "", "", "", "", ""};
	String[] rangeList = {"", "", "" };
	String[] armorTypeList = {"", "", ""};
	
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
				"Sprache:   " + this.Language + "<p/>"+
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
	
	public void exportAsHTML(){
		JOptionPane.showMessageDialog(null, "Diese Funktion wurde noch nicht implementiert");
		System.out.println("Wurde als HTML exportiert");
	}
	
	public void setStats(){
		//button commands:
		final String SHOW = "SHOW";
		final String NEXT = "NEXT";
		final String PREVIOUS = "PREVIOUS";
		final String HTML = "HTML";
		final String QUIT = "QUIT";
		final String TEXT = "<html>Herzlich Willkommen zum Charaktergenerator 3.00.<p/> Dieses Programm ist angepasst auf die Version 3.0 des Amuntalon-Regelwerkes.<p/> Dieses Programm dient nur der Ergänzung und kann das Regelwerk nicht ersetzen. <p/> Es ist deshalb angeraten, das Regelbuch griffbereit zu halten.<p/><p/>" +
				"LICENSE: <p/> Dieses Programm wurde unter der GNU General Public License Version 3 veröffentlicht</html>";
		final String ENDE = "<html> Sie sind glücklich nun am Ende angelangt.<p/> Um Ihren Charakterbogen zu betrachten, klicken Sie auf Anzeigen.<p/>ZUm Speichern bitte anschließend auf 'als html speichern' gehen <p/> Vielen Dank, dass Sie sich für den CharakterGenerator entschieden haben.<p/><p/>" +
				"LICENSE: <p/> Dieses Programm wurde unter der GNU General Public License Version 3 veröffentlicht</html>";
		
		//creating window
		JFrame window = new JFrame("Charakterbogengenerator");
		JPanel steps = new JPanel(new CardLayout());
		JLabel empty = new JLabel("");
		
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
		//intro: informations on program/licence
		JPanel intro = new JPanel();
		JLabel text = new JLabel(TEXT);
		intro.add(text);
		
		//step1: name, race, etc to look
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
		
		JComboBox fightingHand = new JComboBox(HANDLIST);
		fightingHand.setActionCommand("HAND");
		fightingHand.addActionListener(new XmlActionListener(this, fightingHand));
		
		JLabel lo = new JLabel("Aussehen:");
		JTextField look = new JTextField(20);
		look.setActionCommand("LOOK");
		look.addActionListener(new XmlActionListener(this, look));
		
		JButton getstep1 = new JButton("Auswahl übernehmen");
		getstep1.setActionCommand("STEP1");
		getstep1.addActionListener(new XmlActionListener(this, language));
		step1.setLayout(new GridLayout(11,2));
		
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
		step1.add(lo);
		step1.add(look);
		step1.add(new JLabel("Kampfhand: "));
		step1.add(fightingHand);
		step1.add(new JLabel(""));
		step1.add(getstep1);
		
		//step2: hp, energy, stats
		JPanel step2 = new JPanel();
		JTextField hp = new JTextField(20);
		hp.setActionCommand("HP");
		hp.addActionListener(new XmlActionListener(this, hp));
		
		JTextField energy = new JTextField(20);
		energy.setActionCommand("ENERGY");
		energy.addActionListener(new XmlActionListener(this, energy));
		
		
		
		JLabel cval = new JLabel("Charakterwerte:");
		
		JTextField inte = new JTextField(20);
		inte.setActionCommand("INT");
		inte.addActionListener(new XmlActionListener(this, inte));
		
		JTextField chari = new JTextField(20);
		chari.setActionCommand("CHARI");
		chari.addActionListener(new XmlActionListener(this, chari));
		
		JTextField gesch = new JTextField(20);
		gesch.setActionCommand("GESCH");
		gesch.addActionListener(new XmlActionListener(this, gesch));
		
		JTextField schnell = new JTextField(20);
		schnell.setActionCommand("SCHNELL");
		schnell.addActionListener(new XmlActionListener(this, schnell));
		
		JTextField kraft = new JTextField(20);
		kraft.setActionCommand("KRAFT");
		kraft.addActionListener(new XmlActionListener(this, kraft));
		
		JTextField ausd = new JTextField(20);
		ausd.setActionCommand("AUSD");
		ausd.addActionListener(new XmlActionListener(this, ausd));
		
		JTextField mut = new JTextField(20);
		mut.setActionCommand("MUT");
		mut.addActionListener(new XmlActionListener(this, mut));
		
		JTextField wachs = new JTextField(20);
		wachs.setActionCommand("WACHS");
		wachs.addActionListener(new XmlActionListener(this, wachs));
		
		JTextField intu = new JTextField(20);
		intu.setActionCommand("INTU");
		intu.addActionListener(new XmlActionListener(this, intu));
		
		step2.setLayout(new GridLayout(12,2));
		step2.add(new JLabel("Leben:"));
		step2.add(hp);
		step2.add(new JLabel("Energie:"));
		step2.add(energy);
		step2.add(new JLabel("Charakterwerte:")); 
		step2.add(empty);
		step2.add(new JLabel("Intelligenz:"));
		step2.add(inte);
		step2.add(new JLabel("Charisma:"));
		step2.add(chari);
		step2.add(new JLabel("Geschicklichkeit:"));
		step2.add(gesch);
		step2.add(new JLabel("Schnelligkeit:"));
		step2.add(schnell);
		step2.add(new JLabel("Kraft:"));
		step2.add(kraft);
		step2.add(new JLabel("Ausdauer:"));
		step2.add(ausd);
		step2.add(new JLabel("Mut"));
		step2.add(mut);
		step2.add(new JLabel("Wachsamkeit:"));
		step2.add(wachs);
		step2.add(new JLabel("Intuition"));
		step2.add(intu);
		
		//step3: abilities, strength, weakness, alignment
		JPanel step3 = new JPanel();
		
		JList abilities = new JList(ABILITYLIST);
		JScrollPane scrollabs = new JScrollPane(abilities);
		
		JComboBox strength = new JComboBox(STRENGTHLIST);
		strength.setActionCommand("STRENGTH");
		strength.addActionListener(new XmlActionListener(this, strength));
		
		JComboBox weakness = new JComboBox(WEAKNESSLIST);
		weakness.setActionCommand("WEAK");
		weakness.addActionListener(new XmlActionListener(this, weakness));
		
		JComboBox alignment = new JComboBox(ALIGNMENTLIST);
		alignment.setActionCommand("ALI");
		alignment.addActionListener(new XmlActionListener(this, alignment));
		
		JButton absdone = new JButton("Einträge übernehmen");
		absdone.setActionCommand("ABIL");
		absdone.addActionListener(new XmlActionListener(this, abilities));
		
		JLabel spell = new JLabel("Fähigkeiten (Wähle 4):");

		JList spells = new JList(this.listOfSpells);
		JScrollPane scrollspell = new JScrollPane(spells);
		
		JButton endstep4 = new JButton("Einträge übernehmen");
		endstep4.setActionCommand("SPELL");
		endstep4.addActionListener(new XmlActionListener(this, spells));
		
		step3.setLayout(new GridLayout(8,2));
		step3.add(new JLabel("Kenntnisse (wähle 3):"));
		step3.add(scrollabs);
		step3.add(new JLabel(""));
		step3.add(absdone);
		step3.add(new JLabel("Stärke:"));
		step3.add(strength);
		step3.add(new JLabel("Schwäche:"));
		step3.add(weakness);
		step3.add(new JLabel("Gesinnung:"));
		step3.add(alignment);
		step3.add(spell);
		step3.add(scrollspell);
		step3.add(new JLabel(""));
		step3.add(endstep4);
		
		
		//step5 weapons, armor, shields
		JPanel step5 = new JPanel();
		
		JComboBox melee = new JComboBox(meleeList);
		melee.setActionCommand("MELEE");
		melee.addActionListener(new XmlActionListener(this, melee));
		
		JComboBox range = new JComboBox(rangeList);
		range.setActionCommand("RAN");
		range.addActionListener(new XmlActionListener(this, range));
		
		JComboBox armor = new JComboBox(armorTypeList);
		armor.setActionCommand("ARM");
		armor.addActionListener(new XmlActionListener(this, armor));
		
		JTextField wille = new JTextField(5);
		wille.setActionCommand("wille");
		wille.addActionListener(new XmlActionListener(this, wille));
		
		JTextField konz = new JTextField(5);
		konz.setActionCommand("konz");
		konz.addActionListener(new XmlActionListener(this, konz));
		
		JTextField init = new JTextField(5);
		init.setActionCommand("init");
		init.addActionListener(new XmlActionListener(this, init));
		
		JTextField selbstb = new JTextField(5);
		selbstb.setActionCommand("selbstb");
		selbstb.addActionListener(new XmlActionListener(this, selbstb));
		
		JTextField gelenk = new JTextField(5);
		gelenk.setActionCommand("gelenk");
		gelenk.addActionListener(new XmlActionListener(this, gelenk));
		
		JTextField waffe = new JTextField(5);
		waffe.setActionCommand("waffe");
		waffe.addActionListener(new XmlActionListener(this, waffe));
		
		JTextField trag = new JTextField(5);
		trag.setActionCommand("trag");
		trag.addActionListener(new XmlActionListener(this, trag));
		
		JTextField reisev = new JTextField(5);
		reisev.setActionCommand("reisev");
		reisev.addActionListener(new XmlActionListener(this, reisev));
		
		JTextField regen = new JTextField(5);
		regen.setActionCommand("reg");
		regen.addActionListener(new XmlActionListener(this, regen));
		
		JTextField immun = new JTextField(5);
		immun.setActionCommand("immun");
		immun.addActionListener(new XmlActionListener(this, immun));
		
		JTextField glaube = new JTextField(5);
		glaube.setActionCommand("glaube");
		glaube.addActionListener(new XmlActionListener(this, glaube));
		
		JTextField glück = new JTextField(5);
		glück.setActionCommand("glück");
		glück.addActionListener(new XmlActionListener(this, glück));
		
		step5.setLayout(new GridLayout(16,2));
		
		step5.add(new JLabel("Nahkampfwaffe: "));
		step5.add(melee);
		step5.add(new JLabel("Fernkampfwaffe: "));
		step5.add(range);
		step5.add(new JLabel("Rüstungsart: "));
		step5.add(armor);
		step5.add(new JLabel("Charaktereigenschaften:"));
		step5.add(new JLabel(""));
		step5.add(new JLabel("Willenskraft:"));
		step5.add(wille);
		step5.add(new JLabel("Konzentration:"));
		step5.add(konz);
		step5.add(new JLabel("Initiative:"));
		step5.add(init);
		step5.add(new JLabel("Selbstbeherrschung:"));
		step5.add(selbstb);
		step5.add(new JLabel("Gelenkigkeit:"));
		step5.add(gelenk);
		step5.add(new JLabel("Waffenkunde:"));
		step5.add(waffe);
		step5.add(new JLabel("Tragkraft:"));
		step5.add(trag);
		step5.add(new JLabel("Reisegeschwindigkeit:"));
		step5.add(reisev);
		step5.add(new JLabel("Regeneration:"));
		step5.add(regen);
		step5.add(new JLabel("Immunsystem:"));
		step5.add(immun);
		step5.add(new JLabel("Glaube:"));
		step5.add(glaube);
		step5.add(new JLabel("Glück:"));
		step5.add(glück);
		
		
		//last
		JPanel last = new JPanel();
		last.add(new JLabel(ENDE));
		
		steps.add(intro);
		steps.add(step1);
		steps.add(step2);
		steps.add(step3);
		steps.add(step5);
		steps.add(last);
		
		
		//assembling the windows
		Container pane = window.getContentPane();
		pane.add(steps, BorderLayout.CENTER);
		pane.add(buttons, BorderLayout.PAGE_END);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800,600);
		window.setVisible(true);
	}
	
	
	

	public void setSpellList(CharacterSheet charsheet){
		//initialize
		Spell[] list = {new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut"), new Spell("hallo", "hier", "hut"),new Spell("hallo", "hier", "hut")};
		//constant strings 
		final String INT = "Intelligenzprobe";
		final String CHAR = "Charismaprobe";
		final String WACH = "Wachsamkeitsprobe";
		final String INTU = "Intuitionsprobe";
		final String WILL = "Willenskraftprobe";
		final String KRAFT = "Kraftprobe";
		final String GESCH = "Geschicklichkeitsprobe";
		final String KONZ = "Konzentrationsprobe";
		final String SCHNELL = "Schnelligkeitsprobe";
		final String AUS = "Ausdauerprobe";
		final String MUT = "Mutprobe";
		
		String arch = charsheet.Archetype;
		System.out.println(arch);
		if (arch.equals("Magier")){
			list[0] = new Spell("Feuerball", INT, "3W6 Schaden, für 2 Runden 1W6 Schaden/Runde");
			list[1] = new Spell("Wirbelwind", INT, "alle Gegner 10 Jard nach hinten, 1W6+2 Schaden");
			list[2] = new Spell("Blitzschlag", INT, "trifft bis zu drei Gegner, einzeln jeweils 2W6 Schaden");
			list[3] = new Spell("Eispfeil", INT, "2W6 Schaden, 2 Runden lang eingefroren");
			list[4] = new Spell("Telekinese", INT+", 1 Energie/ Runde", "1W6+5 Schaden/Runde");
			list[5] = new Spell("Astrales Wissen", INT, "steigert den Intelligenzwert um 1W6 für drei Runden");
			charsheet.Talents[0] = "Schreiben";
			charsheet.Talents[1] = "Astralsicht";
			charsheet.armorTypeList[1] = STOFF;
			charsheet.meleeList[1]=STAB;
			charsheet.SpecialItems[0]="Papier oder Tagebuch";
			charsheet.SpecialItems[1]="Tintenfass und Feder";
			charsheet.SpecialItems[2]="Zauberbuch";
			charsheet.SpecialItems[3]="Magiersiegel";
			
		}else if (arch.equals("Beschwörer")){
			list[0] = new Spell("Bannkreis",INT, "Untote, Dämonen, Elementare für 2 Runden gebannt");
			list[1] = new Spell("Nachtschatten beschwören", INT +", "+ CHAR, "beschwört Nachtschatten mit 2W6+3 Angriff, 2W6 Block, 15HP und der Fähigkeit, Spieler um 1W6+5 zu heilen");
			list[2] = new Spell("Golem beschwören", INT + ", "+ CHAR, "Golem mit 2W6+3 Angriff, Block 3W6+2, 45 HP. Alle Gegner greifen Golem an");
			list[3] = new Spell("Gefallenen Krieger beschwören", INT, "beschwört untoten Krieger mit 25HP");
			list[4] = new Spell("Dämon der Pein beschwören", INT + ", "+ CHAR, "beschwört Dämon der Pein mit 2W6+7 magisch, 1W6+4 Block, 15 HP");
			list[5] = new Spell("Nymphe beschwören", INT, "beschwört eine Nymphe mit Block 1W6+5 und 15HP. Kann einzelne Spieler um 2W6+9 heilen");
			charsheet.Talents[0] = "Schreiben";
			charsheet.Talents[1]= "Astralsicht";
			charsheet.armorTypeList[1] = STOFF;
			charsheet.meleeList[1]=STAB;
			
			//still to complete
			charsheet.Armor[1].Name="Kapuze";
			charsheet.Armor[1].Sort="Kopf";
			
		}else if (arch.equals("Druide")){
			list[0] = new Spell("Sprache der Wölfe", INT+ ", "+ CHAR, "Spieler spielt Wolf mit 2W6+6 Nahkampfangriff, 2W6+3 Block, 20HP");
			list[1] = new Spell("Sprache der Hirsche", INT, "Spieler spielt Hirsch mit 2W6+2 Nahkampfangriff, 3W6+3 Block, 40HP. Alle Gegner greifen Hirsch an");
			list[2] = new Spell("Sprache der Einhörner", INT + ", "+ CHAR, "Spieler spielt EInhorn mit 2W6+3 Block, 15HP, kann einzelne Ziele um 3W6 heilen");
			list[3] = new Spell("Heilkraut", INT, "Erzeugt Heilkraut, das um 2W6+4 heilt, Wunden versorgt und tierische Gifte stoppt");
			list[4] = new Spell("Wurzeln schlagen", INT, "Gegner 3 Runden lang kampfunfähig");
			list[5] = new Spell("Dornenranken", INT + ", "+ "1 Energie/ Runde", "Gegner festgesetzt, 1W6+4 Schaden");
			charsheet.Talents[0] = "Tiersprache";
			charsheet.Talents[1] = "Astrologie";
			charsheet.armorTypeList[1] = STOFF;
			charsheet.armorTypeList[2] = LEDER;
			charsheet.meleeList[1]=STAB;
			
		}else if (arch.equals("Nekromant")){
			charsheet.Talents[0] = "Astralsicht";
			charsheet.Talents[1] = "Schreiben";
			charsheet.armorTypeList[1] = STOFF;
			charsheet.meleeList[1]=STAB;
		    list[0] = new Spell("Ruf der Schädel", INT+ ", 1 Energie/ Runde", "beschwört 1W6 Schädel, die jeweils 1 Schaden/Runde einem Gegner zufügen.");
			list[1] = new Spell("Skelettwächter rufen", INT, "beschwört zwei Skelettwächter mit 2W6+5 Angriff, 2W6+4 Block. Zerfallen nach drei Runden");
			list[2] = new Spell("Schrei des Lich", INT + ", "+ INTU, "beschwört Lich mit (1W6)W6 Direktschaden. Zerfällt nach zwei Runden und fügt dem Nekromanten 2W6+4 Schaden zu");
			list[3] = new Spell("Opferung", INT, "Entbindet alle Dämonen, die einem nahen Gegner jeweils 2W6+2 Schaden zufügen");
			list[4] = new Spell("Blutsband", INT, "Nekromant bindet zwei Gegner gleicher Art aneinander. Der höhere beider Lebenswerte gilt für beide.");
			list[5] = new Spell("Schrecken verbreiten", INT + ", "+ CHAR, "Jeder Gegner muss Mutprobe bestehen. Bei Nichtbestehen Flucht.");
			}else if (arch.equals("Schamane")){
				charsheet.armorTypeList[1] = STOFF;
				charsheet.armorTypeList[2] = LEDER;
				charsheet.meleeList[1]=STAB;
				charsheet.Talents[0] = "Astralsicht";
				charsheet.Talents[1] = "Außerkörperliche Erfahrung";
			    list[0] = new Spell("Totem der Kriegskunst", INT+ ", "+ "1 Energie/ Runde", "Nahkampf-Archetypen +3 Kraft und Angriffswert");
			list[1] = new Spell("Totem des Wissens", INT + ", "+ "1 Energie/Runde", "Zauberkundige Archetypen +2 Intelligenz und Fähigkeitsschaden");
			list[2] = new Spell("Totem der singenden Pfeile", INT +", "+"1 Energie/Runde", "Fernkampf-Archetypen +3 Angriff und Geschicklichkeit");
			list[3] = new Spell("Bindung ins Jenseits",INT +", "+ AUS+", " + MUT, "kürzlich gefallener Spieler kann wiederbelebt werden, Hälfte des Intelligenzwertes des Schamanen als HP");
			list[4] = new Spell("Zorn der Ahnen", INT, "Gegner 2W6+4 Schaden");
			list[5] = new Spell("Segnung der Anderswelt", AUS + ", bis zu 5 Energie", "heilt einen Spieler um (Anzahl der Energie) W6");
		
			}else if (arch.equals("Hexendoktor")){
				charsheet.armorTypeList[1] = STOFF;
				charsheet.armorTypeList[2] = LEDER;
				charsheet.meleeList[1]=STAB;
				charsheet.Talents[0] = "Astralsicht";
			charsheet.Talents[1] = "Wahrsagen";
		    list[0] = new Spell("Voodoofluch", INT, "verringert für 3 Runden lang den Angriffswert um 1W6+2");
			list[1] = new Spell("Böses Mojo", INT + ", "+ INTU, "Der Zauberkundige Gegner kann für 3 Runden lang keine Fähigkeiten einsetzen");
			list[2] = new Spell("Voodoopuppe", INT+ ", 1 Energie/ Runde", "Gegner erhält jede Runde 3W6+2 Schaden. Hexendoktor kann währenddessen nicht angreifen oder andere Fähigkeiten einsetzen");
			list[3] = new Spell("Fluch der Knochen", INT, "Blockwert des Gegners für 2 Runden um 3 verringert");
			list[4] = new Spell("Ruf der Voodoomächte", INT + ", " + WACH + ", 2 Energie/ Spieler", "Jeder Spieler, für den Energie gezahlt wurde, erhält keinen Schaden, jeweils ein Gegner erhält 1W6+2 Schaden");
			list[5] = new Spell("Zombiefluch", INT, "Ein Gegner wird für zwei Runden zum Zombie, dieser greift willkürlich die Feinde der Spieler an");
		
			}else if (arch.equals("Arkanist")){
				charsheet.armorTypeList[1] = STOFF;
				charsheet.meleeList[1]=STAB;
				charsheet.Talents[0] = "Astralsicht";
			charsheet.Talents[1] = "Schreiben";
		    list[0] = new Spell("Astraler Blitz", INT + ", bis zu 3 Energie", "Für jeden Energiepunkt 1W6+1 Schaden");
			list[1] = new Spell("Astralwelle", INT, "Wirft einen Gegner 10 Jard zurück und fügt ihm 2W6+3 Schaden zu");
			list[2] = new Spell("Zeitkrümmung", INT + ", "+ WACH+ ", "+ "2 Energie + 1 Energie/ weitere Spieler", "wiederholt die Kampfhandlung des letzten Spielers oder eines Spielers davor");
			list[3] = new Spell("Astralenergie", INT + ", 1 Energie/ Spieler", "regeneriert 2W6 Energie bei (Anzahl aufgewandter Energie) Spielern");
			list[4] = new Spell("Astrale Brillanz", INT , "steigert für 2 Runden Intelligenzwert eines befreundetet Ziels um 1W6 und +3 Fähigkeitsschaden");
			list[5] = new Spell("Astrale Streeung", INT, "Die nächste Fähigkeit betrifft alle Ziele");
			
			//still to complete
			charsheet.Armor[1].Name="Kapuze";
			charsheet.Armor[1].Sort="Kopf";
			
			}else if (arch.equals("Krieger")){
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=EISEN;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=ZWEISCHWERT;
			charsheet.meleeList[3]=PILUM;
			charsheet.meleeList[4]=EINAXT;
			charsheet.meleeList[5]=FE;
				charsheet.Talents[0] = "Waffenkenntnis";
			charsheet.Talents[1] = "Strategie";
		    list[0] = new Spell("Verwunden", KRAFT, "1W6+4 Schaden, drei Runden lang 1W6 Schaden und zwei Runden Aufmerksamkeit auf Krieger");
			list[1] = new Spell("Verspotten", AUS, "Aufmerksamkeit aller Gegner für 2 Runden");
			list[2] = new Spell("Stich", KRAFT+ ", "+GESCH, "2W6+4 Schaden, 5 Jard nach hinten gestoßen");
			list[3] = new Spell("Spöttischer Hieb", KRAFT + ", "+SCHNELL, "2W6+2 Schaden und 2 Runden Aufmerksamkeit");
			list[4] = new Spell("Entwaffnen",KRAFT + ", "+GESCH+", "+SCHNELL, "Gegner entwaffnet");
			list[5] = new Spell("Kriegsschrei", AUS, "Angriff/ Block +2 für 2 Runden");
		}else if (arch.equals("Ritter")){
			charsheet.Talents[0] = "Reiten";
			charsheet.Talents[1] = "Etikette";
		    list[0] = new Spell("Gesegneter Hieb", KRAFT, "2W6 Schaden, heilt um 1W6");
			list[1] = new Spell("Göttliches Band", AUS, "kann Schaden auf den Ritter übertragen, hält 2 Runden");
			list[2] = new Spell("Gelübde", AUS, "heilt um 2W6 und entfernt alle negativen Effekte");
			list[3] = new Spell("Gesalbte Rüstung", AUS, "der nächste Schaden auf den Ritter wird halbiert");
			list[4] = new Spell("Göttliche Waffe", KRAFT, "Der Ritter heilt sich um den nächsten Schaden, den er zufügt");
			list[5] = new Spell("Kreuzhieb", KRAFT, "2W6+2 Schaden, Untote sterben sofort");
		}else if (arch.equals("Baphosritter")){
			charsheet.Talents[0] = "Angstaura";
			charsheet.Talents[1] = "Strategie";
		    list[0] = new Spell("Klinge des Baphos", INT, "normaler Angriff, der Baphosritter heilt sich um den Schaden, den er zufügt");
			list[1] = new Spell("Packendes Eis", INT, "2W6 Schaden, 3 Runden festgesetzt");
			list[2] = new Spell("Griff des Todes", INT + ", "+ KRAFT, "Gegner sofort in Nahkampfreichweite");
			list[3] = new Spell("Rune des Todes", INT+", bis zu 5 Energie/ Runde", "alle Gegner erhalten (Anzahl Energie)+2 Schaden/Runde");
			list[4] = new Spell("Schattenschwert", INT +", "+ KRAFT, "normale Angriffe fügen nochmals 1W6 Fähigkeitsschaden zu");
			list[5] = new Spell("Untoten rufen", INT, "ruft für 3 Runden einen Untoten mit 2W6+4 Angriff, 2W6+2 Block, 15 HP");
		}else if (arch.equals("Hüter")){
			charsheet.Talents[0] = "Waffenkenntnis";
			charsheet.Talents[1] = "Strategie";
		    list[0] = new Spell("Schildhieb", KRAFT, "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}else if (arch.equals("Magier")){
			charsheet.Talents[0] = "";
			charsheet.Talents[1] = "";
		    list[0] = new Spell("", "", "");
			list[1] = new Spell("", "", "");
			list[2] = new Spell("", "", "");
			list[3] = new Spell("", "", "");
			list[4] = new Spell("", "", "");
			list[5] = new Spell("", "", "");
		}
		//*/
		
		for (int i=0; i<6; i++){
		charsheet.listOfSpells[i] = list[i].Name;
		charsheet.completeSpells[i] = list[i];
		}
	}
	public void raceMod(CharacterSheet charsheet){
		String race = charsheet.Race;
		
		if(race.equals("Amazone")){
			charsheet.Stats[4]+=1;
		}else if(race.equals("Amunier")){
			charsheet.Stats[1]+=1;
		}else if(race.equals("Bergzwerg")){
			charsheet.Stats[4]+=1;
		}else if(race.equals("Dathure")){
			charsheet.Stats[0]+=1;
		}else if(race.equals("Elf")){
			charsheet.Stats[3]+=1;
		}else if(race.equals("Gnom")){
			charsheet.Stats[0]+=1;
		}else if(race.equals("Grimmtaure")){
			charsheet.Stats[5]+=1;
		}else if(race.equals("Halbelf")){
			charsheet.Stats[2]+=1;
		}else if(race.equals("Hügelzwerg")){
			charsheet.Stats[4]+=1;
		}else if(race.equals("Kobold")){
			charsheet.Stats[0]+=1;
		}else if(race.equals("Minotaur")){
			charsheet.Stats[4]+=1;
		}else if(race.equals("Nordländer")){
			charsheet.Stats[5]+=1;
		}else if(race.equals("Ork")){
			charsheet.Stats[4]+=1;
		}else if(race.equals("Taravellaner")){
			charsheet.Stats[0]+=2;
		}else if(race.equals("Scantare")){
			charsheet.Stats[2]+=2;
		}else if(race.equals("Schattenelf")){
			charsheet.Stats[0]+=1;
		}else if(race.equals("Talonier")){
			charsheet.Stats[5]+=1;
		}else if(race.equals("Trinide")){
			charsheet.Stats[0]+=2;
		}else if(race.equals("Wanure")){
			charsheet.Stats[5]+=1;
		}else if(race.equals("Zentaur")){
			charsheet.Stats[3]+=2;
		}
	}
	public void throwError(String source){
		JOptionPane.showMessageDialog(null, "FEHLER!   Sie haben vergessen, das Feld "+source+" zu bearbeiten!");	
	}
  	}
