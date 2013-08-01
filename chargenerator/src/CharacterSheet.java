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
import java.io.*;

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
	Weapon Melee2;
	Weapon Range;
	Armor[] Armor;
	Spell[] Spells;
	String Language;
	String Alignment;
	String Hand;
	String Religion;
	String[] listOfSpells = {"hallo", "hier", "hirt", "bla", "blubb", "blubb"};
	Spell[] completeSpells = {INITSPELL, INITSPELL, INITSPELL, INITSPELL, INITSPELL, INITSPELL};
	String[] meleeList = {"", "", "", "", "", "", "", "", "", "", ""};
	String[] rangeList = {"", "", "" };
	String[] armorTypeList = {"", "", ""};
	String space = ""; //space String for any purpose
	DefaultComboBoxModel model = new DefaultComboBoxModel(meleeList);
	int statpoints=230;
	
	/*initializes Character Sheet*/
	public CharacterSheet(int Hitpoints, int Energy, int Age, String Name, String Race, String Archetype,	String Look, String[] Abilities, String[] Talents, String Strength,	String Weakness, int[] Stats, int[] Skills,	int[] Money, String Gender,	String Culture,	String[] Bag, int Level, String[] SpecialItems, Weapon Melee,Weapon Melee2,  Weapon Range, Armor[] Armor, Spell[] Spells, String Language, String Religion, String Hand, String Alignment ){
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
		this.Melee2=Melee2;
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
		JPanel buttons = new JPanel(new FlowLayout());
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		f.setSize( 800, 600 );
		//Layout
		f.setLayout(new GridLayout());
		
		String Sheet = this.output(1); 
		JLabel l = new JLabel (Sheet);
		
		JLabel sav = new JLabel("Bitte beim Speichern auch die Endung .html angeben");
		
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
		f.add(new JScrollPane(l));
		
		buttons.add(end);
		buttons.add(xml);
		buttons.add(sav);
		f.add(buttons);
		f.setVisible ( true );
		
	}
	
	public void exportAsHTML(){
		JFrame frame = new JFrame("Als HTML speichern");
		Writer write = null;
		JFileChooser save = new JFileChooser();
		save.setMultiSelectionEnabled(false);
		save.showSaveDialog(frame);
		File file = save.getSelectedFile();
		String text=this.output(0);
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
	
	public void setStats(){
		//button commands:
		final String SHOW = "SHOW";
		final String NEXT = "NEXT";
		final String PREVIOUS = "PREVIOUS";
		final String QUIT = "QUIT";
		final String TEXT = "<html>Herzlich Willkommen zum Charaktergenerator 3.00.<p/> Dieses Programm ist angepasst auf die Version 3.0 des Amuntalon-Regelwerkes.<p/> Dieses Programm dient nur der Ergänzung und kann das Regelwerk nicht ersetzen. <p/> Es ist deshalb angeraten, das Regelbuch griffbereit zu halten.<p/><p/>" +
				"LICENSE: <p/> Dieses Programm wurde unter der GNU General Public License Version 3 veröffentlicht</html>";
		final String ENDE = "<html> Sie sind glücklich nun am Ende angelangt.<p/> Um Ihren Charakterbogen zu betrachten, klicken Sie auf Anzeigen.<p/>ZUm Speichern bitte anschließend auf 'als html speichern' gehen <p/> Vielen Dank, dass Sie sich für den CharakterGenerator entschieden haben.<p/><p/>" +
				"LICENSE: <p/> Dieses Programm wurde unter der GNU General Public License Version 3 veröffentlicht</html>";
		
		//creating window
		JFrame window = new JFrame("Charakterbogengenerator");
		JPanel steps = new JPanel(new CardLayout());
		String help = "zur Auswahl mehrerer Punkte Strg+*klick*. Anschließend auf `Auswahl übernehmen`";
		
		//Buttons
		XmlActionListener listener = new XmlActionListener(this, steps, window);
		
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
		language.setToolTipText(help);
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
		JLabel textpoints = new JLabel("Sie können insgesamt maximal "+String.valueOf(statpoints)+" Punkte vergeben.");
		JTextField hp = new JTextField(20);
		hp.setActionCommand("HP");
		hp.addActionListener(new XmlActionListener(this, hp));
		
		JTextField energy = new JTextField(20);
		energy.setActionCommand("ENERGY");
		energy.addActionListener(new XmlActionListener(this, energy));
		
		
		
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
		
		step2.setLayout(new GridLayout(13,2));
		
		step2.add(new JLabel(""));
		step2.add(textpoints);
		step2.add(new JLabel("Leben:"));
		step2.add(hp);
		step2.add(new JLabel("Energie: (maximal 18 Punkte)"));
		step2.add(energy);
		step2.add(new JLabel("Charakterwerte:")); 
		step2.add(new JLabel("jeweils 8 bis 25 Punkte"));
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
		abilities.setToolTipText(help);
		JComboBox strength = new JComboBox(STRENGTHLIST);
		strength.setActionCommand("STRENGTH");
		strength.addActionListener(new XmlActionListener(this, strength));
		
		JComboBox weakness = new JComboBox(WEAKNESSLIST);
		weakness.setActionCommand("WEAK");
		weakness.addActionListener(new XmlActionListener(this, weakness));
		
		JComboBox alignment = new JComboBox(ALIGNMENTLIST);
		alignment.setActionCommand("ALI");
		alignment.addActionListener(new XmlActionListener(this, alignment));
		
		JButton absdone = new JButton("Auswahl übernehmen");
		absdone.setActionCommand("ABIL");
		absdone.addActionListener(new XmlActionListener(this, abilities));
		
		JLabel spell = new JLabel("Fähigkeiten (Wähle 4):");

		JList spells = new JList(this.listOfSpells);
		spells.setToolTipText(help);
		JScrollPane scrollspell = new JScrollPane(spells);
		
		JPanel step5 = new JPanel();
		JComboBox melee = new JComboBox(this.meleeList);
		JComboBox range = new JComboBox(this.rangeList);
		JComboBox armor = new JComboBox(this.armorTypeList);
		
		JButton endstep4 = new JButton("Auswahl übernehmen");
		endstep4.setActionCommand("SPELL");
		endstep4.addActionListener(new XmlActionListener(this, spells, melee, range, armor));
		
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
	
		melee.setActionCommand("MELEE");
		melee.addActionListener(new XmlActionListener(this, melee));
		
		range.setActionCommand("RAN");
		range.addActionListener(new XmlActionListener(this, range));
		
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
		step5.add(new JLabel("insgesamt 20 Punkte"));
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
		final String KRAFT = "Kraftprobe";
		final String GESCH = "Geschicklichkeitsprobe";
		final String SCHNELL = "Schnelligkeitsprobe";
		final String AUS = "Ausdauerprobe";
		final String MUT = "Mutprobe";
		
		String arch = charsheet.Archetype;
		
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
			charsheet.Energy+=3;
			charsheet.Stats[1]+=1;
			charsheet.Stats[8]+=1;
			charsheet.Stats[7]+=1;
			
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
			charsheet.Energy+=3;
		    charsheet.Stats[0]+=1;
		    charsheet.Stats[5]+=1;
			
			//still to complete
			charsheet.Armor[1].Name="Kapuze";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
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
			charsheet.model= new DefaultComboBoxModel(charsheet.meleeList);
			charsheet.SpecialItems[0]="Tieramulett";
			charsheet.SpecialItems[1]="Ritualmesser";
			charsheet.Stats[0]+=1;
			charsheet.Stats[7]+=1;
			charsheet.Energy+=3;
		
		}else if (arch.equals("Nekromant")){
			charsheet.Talents[0] = "Astralsicht";
			charsheet.Talents[1] = "Schreiben";
			charsheet.armorTypeList[1] = STOFF;
			charsheet.meleeList[1]=STAB;
		    charsheet.SpecialItems[0]="Zauber-/ Beschwörungsbuch";
		    charsheet.SpecialItems[1]="Papiere";
		    charsheet.SpecialItems[2]="Tintenfass und Federn";
			charsheet.Stats[0]+=1;
			charsheet.Stats[1]+=1;
			charsheet.Energy+=3;
		
		    list[0] = new Spell("Ruf der Schädel", INT+ ", 1 Energie/ Runde", "beschwört 1W6 Schädel, die jeweils 1 Schaden/Runde einem Gegner zufügen.");
			list[1] = new Spell("Skelettwächter rufen", INT, "beschwört zwei Skelettwächter mit 2W6+5 Angriff, 2W6+4 Block. Zerfallen nach drei Runden");
			list[2] = new Spell("Schrei des Lich", INT + ", "+ INTU, "beschwört Lich mit (1W6)W6 Direktschaden. Zerfällt nach zwei Runden und fügt dem Nekromanten 2W6+4 Schaden zu");
			list[3] = new Spell("Opferung", INT, "Entbindet alle Dämonen, die einem nahen Gegner jeweils 2W6+2 Schaden zufügen");
			list[4] = new Spell("Blutsband", INT, "Nekromant bindet zwei Gegner gleicher Art aneinander. Der höhere beider Lebenswerte gilt für beide.");
			list[5] = new Spell("Schrecken verbreiten", INT + ", "+ CHAR, "Jeder Gegner muss Mutprobe bestehen. Bei Nichtbestehen Flucht.");
			//
			charsheet.Armor[1].Name="Kapuze";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
		}else if (arch.equals("Schamane")){
				charsheet.armorTypeList[1] = STOFF;
				charsheet.armorTypeList[2] = LEDER;
				charsheet.meleeList[1]=STAB;
				charsheet.Talents[0] = "Astralsicht";
				charsheet.Talents[1] = "Außerkörperliche Erfahrung";
				charsheet.SpecialItems[0]="Schutzamulett";
				charsheet.SpecialItems[1]="Totemidol";
				charsheet.Stats[0]+=1;
				charsheet.Stats[5]+=1;
				charsheet.Energy+=3;
			
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
			charsheet.SpecialItems[0]="Voodoopuppe";
			charsheet.SpecialItems[1]="Zauberschriften";
			charsheet.SpecialItems[2]="Tikimaske";	
			charsheet.Stats[0]+=1;
			charsheet.Stats[8]+=1;
			charsheet.Energy+=3;
		
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
			charsheet.SpecialItems[0]="Tintenfass und Feder";
			charsheet.SpecialItems[1]="Zauberbuch";
			charsheet.SpecialItems[2]="Tagebuch";
			charsheet.SpecialItems[3]="Astralkristall";
			charsheet.Stats[0]+=1;
			charsheet.Stats[7]+=1;
			charsheet.Energy+=3;
		
		    list[0] = new Spell("Astraler Blitz", INT + ", bis zu 3 Energie", "Für jeden Energiepunkt 1W6+1 Schaden");
			list[1] = new Spell("Astralwelle", INT, "Wirft einen Gegner 10 Jard zurück und fügt ihm 2W6+3 Schaden zu");
			list[2] = new Spell("Zeitkrümmung", INT + ", "+ WACH+ ", "+ "2 Energie + 1 Energie/ weitere Spieler", "wiederholt die Kampfhandlung des letzten Spielers oder eines Spielers davor");
			list[3] = new Spell("Astralenergie", INT + ", 1 Energie/ Spieler", "regeneriert 2W6 Energie bei (Anzahl aufgewandter Energie) Spielern");
			list[4] = new Spell("Astrale Brillanz", INT , "steigert für 2 Runden Intelligenzwert eines befreundetet Ziels um 1W6 und +3 Fähigkeitsschaden");
			list[5] = new Spell("Astrale Streeung", INT, "Die nächste Fähigkeit betrifft alle Ziele");
			
			//still to complete
			charsheet.Armor[1].Name="Spitzhut";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			}else if (arch.equals("Krieger")){
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=EISEN;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=ZWEISCHWERT;
			charsheet.meleeList[3]=PILUM;
			charsheet.meleeList[4]=EINAXT;
			charsheet.meleeList[5]=FE;
			charsheet.setArchSpec(charsheet);
			charsheet.Talents[1] = "Strategie";
			charsheet.SpecialItems[0]="Einfacher Waffenrock";
			charsheet.SpecialItems[1]="Waffen- und Rüstungspolitur";
			charsheet.SpecialItems[2]="Akademieabzeichen";
			charsheet.Stats[2]+=1;
			charsheet.Stats[4]+=1;
		
		    list[0] = new Spell("Verwunden", KRAFT, "1W6+4 Schaden, drei Runden lang 1W6 Schaden und zwei Runden Aufmerksamkeit auf Krieger");
			list[1] = new Spell("Verspotten", AUS, "Aufmerksamkeit aller Gegner für 2 Runden");
			list[2] = new Spell("Stich", KRAFT+ ", "+GESCH, "2W6+4 Schaden, 5 Jard nach hinten gestoßen");
			list[3] = new Spell("Spöttischer Hieb", KRAFT + ", "+SCHNELL, "2W6+2 Schaden und 2 Runden Aufmerksamkeit");
			list[4] = new Spell("Entwaffnen",KRAFT + ", "+GESCH+", "+SCHNELL, "Gegner entwaffnet");
			list[5] = new Spell("Kriegsschrei", AUS, "Angriff/ Block +2 für 2 Runden");
//
			charsheet.Melee2.Name="Rundschild";
			charsheet.Melee2.Attack="-";
			charsheet.Melee2.Break=2;
			charsheet.Melee2.Material="Holz";
			charsheet.Melee2.Block="2W6+3";
			
			
			}else if (arch.equals("Ritter")){
			charsheet.armorTypeList[1]=EISEN;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=PILUM;
			charsheet.meleeList[3]=EINSK;
			charsheet.meleeList[4]=FE;
			charsheet.Talents[0] = "Reiten";
			charsheet.Talents[1] = "Etikette";
			charsheet.SpecialItems[0]="Verzierter Waffenrock";
			charsheet.SpecialItems[1]="Waffen- und Rüstungspolitur";
			charsheet.SpecialItems[2]="Adelsurkunde";
			charsheet.SpecialItems[3]="Leichtes Ross";
			charsheet.Stats[4]+=1;
			charsheet.Stats[5]+=1;
		
		    list[0] = new Spell("Gesegneter Hieb", KRAFT, "2W6 Schaden, heilt um 1W6");
			list[1] = new Spell("Göttliches Band", AUS, "kann Schaden auf den Ritter übertragen, hält 2 Runden");
			list[2] = new Spell("Gelübde", AUS, "heilt um 2W6 und entfernt alle negativen Effekte");
			list[3] = new Spell("Gesalbte Rüstung", AUS, "der nächste Schaden auf den Ritter wird halbiert");
			list[4] = new Spell("Göttliche Waffe", KRAFT, "Der Ritter heilt sich um den nächsten Schaden, den er zufügt");
			list[5] = new Spell("Kreuzhieb", KRAFT, "2W6+2 Schaden, Untote sterben sofort");
			//
			charsheet.Melee2.Name="Rundschild";
			charsheet.Melee2.Attack="-";
			charsheet.Melee2.Break=2;
			charsheet.Melee2.Material="Holz";
			charsheet.Melee2.Block="2W6+3";
			
			}else if (arch.equals("Baphosritter")){
			charsheet.Talents[0] = "Angstaura";
			charsheet.Talents[1] = "Strategie";
			charsheet.armorTypeList[1]=EISEN;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=EINAXT;
			charsheet.meleeList[3]=EINSK;
			charsheet.SpecialItems[0]="Waffen- und Rüstungspolitur";
			charsheet.SpecialItems[1]="Baphosfeder";
			charsheet.Stats[0]+=1;
			charsheet.Stats[4]+=1;
			
		    list[0] = new Spell("Klinge des Baphos", INT, "normaler Angriff, der Baphosritter heilt sich um den Schaden, den er zufügt");
			list[1] = new Spell("Packendes Eis", INT, "2W6 Schaden, 3 Runden festgesetzt");
			list[2] = new Spell("Griff des Todes", INT + ", "+ KRAFT, "Gegner sofort in Nahkampfreichweite");
			list[3] = new Spell("Rune des Todes", INT+", bis zu 5 Energie/ Runde", "alle Gegner erhalten (Anzahl Energie)+2 Schaden/Runde");
			list[4] = new Spell("Schattenschwert", INT +", "+ KRAFT, "normale Angriffe fügen nochmals 1W6 Fähigkeitsschaden zu");
			list[5] = new Spell("Untoten rufen", INT, "ruft für 3 Runden einen Untoten mit 2W6+4 Angriff, 2W6+2 Block, 15 HP");
			//
			charsheet.Melee2.Name="Rundschild";
			charsheet.Melee2.Attack="-";
			charsheet.Melee2.Break=2;
			charsheet.Melee2.Material="Holz";
			charsheet.Melee2.Block="2W6+3";
			
			
			}else if (arch.equals("Hüter")){
			charsheet.setArchSpec(charsheet);
			charsheet.Talents[1] = "Strategie";
			charsheet.armorTypeList[1]=EISEN;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=EINAXT;
			charsheet.meleeList[3]=PILUM;
			charsheet.SpecialItems[0]="Waffen- und Rüstungspolitur";
			charsheet.SpecialItems[1]="Fernrohr";
			charsheet.SpecialItems[2]="Einfacher Waffenrock";
			charsheet.SpecialItems[3]="Akademieabzeichen";
			charsheet.Stats[4]+=1;
			charsheet.Stats[7]+=1;
		    list[0] = new Spell("Schildhieb", KRAFT, "nomaler Angriff, Blockwert des Schildes dient als Angriff. Aufmerksamkeit für 2 Runden");
			list[1] = new Spell("Wachruf", WACH, "Block- und Schutzwert alle befreundeten Ziele +2 für 2 Runden");
			list[2] = new Spell("Zurückdrängen", KRAFT, "Alle Gegner vor Hüter 1W6+4 Schaden, 5 Jards zurückgedrängt");
			list[3] = new Spell("Parieren", WACH, "beim nächsten Angriff gilt der Angriffswert der Waffe als Blockwert mit Bonus +2");
			list[4] = new Spell("Wachsames Auge", WACH, "Alle befreundeten Ziele für 3 Runden +3 Wachsamkeit und Intuition");
			list[5] = new Spell("Zum Feind machen", KRAFT, "Aufmerksamkeit aller Gegner für 2 Runden");
			//
			charsheet.Melee2.Name="Rundschild";
			charsheet.Melee2.Attack="-";
			charsheet.Melee2.Break=2;
			charsheet.Melee2.Material="Holz";
			charsheet.Melee2.Block="2W6+3";
			
		
		}else if (arch.equals("Berserker")){
			charsheet.Talents[0] = "Erste Hilfe";
			charsheet.Talents[1] = "Raufen";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.meleeList[1]=ZWEISCHWERT;
			charsheet.meleeList[2]=ZWAXT;
			charsheet.SpecialItems[0]="Runenamulett";
			charsheet.SpecialItems[1]="Wetzstein";
			charsheet.SpecialItems[2]="Verbände";
			charsheet.Stats[4]+=1;
			charsheet.Stats[5]+=1;
		    list[0] = new Spell("Sturmangriff", SCHNELL, "Berserker gelangt in Nahkampfreichweite und fügt Gegner 1W6+3 Schaden zu");
			list[1] = new Spell("Blutrausch", KRAFT+", 1 Energie/ Runde", "+1 Angriff/ Runde (Maximum +3)");
			list[2] = new Spell("Kriegszorn", AUS, "+2 Angriff für alle befreundeten Ziele");
			list[3] = new Spell("Niederschmettern", KRAFT, "Alle nahen Gegner 5 Jard nach hinten");
			list[4] = new Spell("Klingenflug", KRAFT, "Fernkampfangriff mit Nahkampfwaffe, Reichweite doppelter Kraftwert -5");
			list[5] = new Spell("Wutausbruch", AUS, "Angriff +2, Block -4 für 2 Runden");
			
			//
			charsheet.Melee2.Name="Rundschild";
			charsheet.Melee2.Attack="-";
			charsheet.Melee2.Break=2;
			charsheet.Melee2.Material="Holz";
			charsheet.Melee2.Block="2W6+3";
			
		
		}else if (arch.equals("Waffenmeister")){
			charsheet.Talents[0] = "Schmieden";
			charsheet.Talents[1] = "Strategie";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.armorTypeList[2]=LEDER;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=EINAXT;
			charsheet.meleeList[3]=PILUM;
			charsheet.meleeList[4]=ZWAXT;
			charsheet.meleeList[5]=EINSK;
			charsheet.meleeList[6]=ZWEISK;
			charsheet.meleeList[7]=ZWEISCHWERT;
			charsheet.meleeList[8]=FE;
			charsheet.meleeList[9]=DO;
			charsheet.meleeList[10]=STAB;
			charsheet.rangeList[1]=B;
			charsheet.rangeList[2]=A;
			charsheet.SpecialItems[0]="Waffen- und Rüstungspolitur";
			charsheet.SpecialItems[1]="Wetzstein";
			charsheet.SpecialItems[2]="Schmiedehammer";
			charsheet.SpecialItems[3]="Akademieabzeichen";
			charsheet.SpecialItems[4]="Schmiedezange";
			charsheet.Stats[4]+=1;
			charsheet.Stats[2]+=1;
		    list[0] = new Spell("Speerstoß", KRAFT + ", Lanze/ Stab", "+3 Angriff für Stangenwaffe");
			list[1] = new Spell("Klingenhieb", KRAFT+ ", Klingenwaffe", "Klingenwaffe +2 Angriff");
			list[2] = new Spell("Wuchtschlag", KRAFT+ ", Wuchtwaffe", "Wuchtwaffe +2 Angriff");
			list[3] = new Spell("fliegender Pfeil", GESCH + ", Fernkampfwaffe", "Munition +2 Angriff und +1W6+3 Reichweite");
			list[4] = new Spell("Schleuderwaffe", KRAFT + ", "+ GESCH, "Fernkampfangriff mit Nahkampfwaffe, Reichweite doppelter Kraftwert");
			list[5] = new Spell("Klingenwirbel", GESCH, "Alle Gegner in der Nähe 1W6+2 Schaden");
			
		}else if (arch.equals("Duellant")){
			charsheet.Talents[0] = "Parierwaffe";
			charsheet.Talents[1] = "Etikette";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.armorTypeList[2]=LEDER;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=EINAXT;
			charsheet.meleeList[3]=FE;
			charsheet.SpecialItems[0]="Waffen- und Rüstungspolitur";
			charsheet.SpecialItems[1]="Taschentuch";
			charsheet.SpecialItems[2]="Besteckset";
			charsheet.Stats[4]+=1;
			charsheet.Stats[2]+=1;
		    list[0] = new Spell("Herausforderung", GESCH, "Aufmerksamkeit des Gegners für 3 Runden");
			list[1] = new Spell("Kreuzblock", KRAFT, "nächster Angriff wird mit beiden Waffen geblockt");
			list[2] = new Spell("Waffenwechsel", GESCH, "tauscht Schild- und Angriffswaffe");
			list[3] = new Spell("Zweifachhieb", GESCH, "Nach dem Angriff mit der Hauptwaffe erfolgt direkt ein Angriff mit der Schildwaffe");
			list[4] = new Spell("Doppelschlag", KRAFT, "Angriff mit beiden Waffen zeitgleich, addierter Angriffswert");
			list[5] = new Spell("Desarmieren", GESCH, "Gegner entwaffnet");
			
			}else if (arch.equals("Späher")){
			charsheet.Talents[0] = "Schnitzen";
			charsheet.Talents[1] = "Schleichen";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.meleeList[1]=DO;
			charsheet.rangeList[1]=B;
			charsheet.rangeList[2]=A;
			charsheet.SpecialItems[0]="Holzöl";
			charsheet.SpecialItems[1]="Bogensehnen";
			charsheet.SpecialItems[2]="Holzmesser";
			charsheet.SpecialItems[3]="Fernrohr";
			charsheet.Stats[2]+=1;
			charsheet.Stats[7]+=1;
		    list[0] = new Spell("Mailenschuss", GESCH, "Reichweite +2W6 mal 3 für 2 Runden");
			list[1] = new Spell("Pfeilregen", GESCH+ ", 1 Pfeil/ getroffener Gegner", "Alle Gegner in Reichweite -40 Jard 2W6 Schaden");
			list[2] = new Spell("Zielen", GESCH, "für 3 Runden Geschicklichkeit +3");
			list[3] = new Spell("Kopfschuss", GESCH, "normaler Angriff, nur Kopfrüstung zählt");
			list[4] = new Spell("Salve", GESCH +", bis zu 5 Pfeile", "fügt 2W6+2+(Anzahl Pfeile) Schaden zu");
			list[5] = new Spell("Dreifachpfeil", GESCH + ", bis zu 3 Pfeile", "1W6+ ((Anzahl Pfeile) mal 3) Schaden");
			
			}else if (arch.equals("Jäger")){
			charsheet.Talents[0] = "Kürschnern";
			charsheet.Talents[1] = "Abrichten";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.meleeList[1]=DO;
			charsheet.meleeList[2]=PILUM;
			charsheet.rangeList[1]=B;
			charsheet.rangeList[2]=A;
			charsheet.SpecialItems[0]="Netz";
			charsheet.SpecialItems[1]="Kürschnermesser";
			charsheet.SpecialItems[2]="Jagdhorn";
			charsheet.SpecialItems[3]="10 Jard langes Seil";
			charsheet.setArchSpec(charsheet);
			charsheet.Stats[2]+=1;
			charsheet.Stats[7]+=1;
		    list[0] = new Spell("Sehnenschuss", GESCH, "1W6 Schaden, 2 Runden festgesetzt");
			list[1] = new Spell("Schlingenfalle", SCHNELL + ", " +GESCH, "Gegner 2 Runden festgesetzt und für 2 Runden 1W6 Schaden/Runde");
			list[2] = new Spell("Fass!", CHAR, "Jagdtier für 4 Runden +2 Angriff und Block");
			list[3] = new Spell("Jagdfanfare", AUS, "Alle befreundeten Ziele für 2 Runden +2 Ausdauer, Geschicklichkeit, Angriff");
			list[4] = new Spell("Netzfalle", GESCH, "Gegner 5 Runden festgesetzt");
			list[5] = new Spell("Widerhakenpfeil", GESCH, "Angriffswert der Munition +2");
			
		}else if (arch.equals("Waldläufer")){
			charsheet.Talents[0] = "Kräuterkunde";
			charsheet.Talents[1] = "Tierkunde";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=STOFF;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=PILUM;
			charsheet.rangeList[1]=B;
			charsheet.SpecialItems[0]="Tierpfeife";
			charsheet.SpecialItems[1]="Jagdhorn";
			charsheet.SpecialItems[2]="Zelt";
			charsheet.Stats[2]+=1;
			charsheet.Stats[7]+=1;
		    list[0] = new Spell("Gift neutralisieren", GESCH, "neutralisiert tierische Gifte sofort, bei pflanzlichen und tierischen Giften ist Verwendung von Kräutern erforderlich");
			list[1] = new Spell("Überlebenstaktik", GESCH+", 1 Energie/ Runde", "kann weder gefeselt, gelähmt, betäubt, geblendet oder unbeweglich gemacht werden");
			list[2] = new Spell("Betäubungspfeil", GESCH, "Gegner für 2 Runden betäubt");
			list[3] = new Spell("Florabewahrer", GESCH, "Fernkampfangriffe +3 Angriff, +4 Schaden");
			list[4] = new Spell("Faunahüter", GESCH, "Nahkampfangriffe +3 Angriff, +4 Schaden");
			list[5] = new Spell("Schmetterpfeil", GESCH + ", "+ KRAFT, "3W6 Schaden und REichweite +2W6 mal 3");
			
			}else if (arch.equals("Pirat")){
			charsheet.Talents[0] = "Seefahrt";
			charsheet.Talents[1] = "Navigation";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=STOFF;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=EINAXT;
			charsheet.meleeList[3]=FE;
			charsheet.SpecialItems[0]="Kaperbrief";
			charsheet.SpecialItems[1]="Aleusamulett";
			charsheet.SpecialItems[2]="Fernrohr";
			charsheet.SpecialItems[3]="Kompass";
			charsheet.SpecialItems[4]="Karte";
			charsheet.Stats[4]+=1;
			charsheet.Stats[2]+=1;
		    list[0] = new Spell("Entern", KRAFT, "Alle befreundeten Ziele für 2 Runden +3 Angriff");
			list[1] = new Spell("Kapern", GESCH, "Alle feindlichen Ziele -3 Block für 2 Runden");
			list[2] = new Spell("Einschüchtern", KRAFT, "Alle feindlichen Ziele -3 Angriff für 2 Runden");
			list[3] = new Spell("Überfallen", GESCH, "Alle befreundeten Ziele für eine Runde +5 Fähigkeitsschaden");
			list[4] = new Spell("Marodieren", KRAFT, "Alle feindlichen Ziele für 2 Runden Schutzwert -2");
			list[5] = new Spell("Ausfallschritt", KRAFT, "1W6+5 Schaden, entwaffnet");
			
			//
			charsheet.Melee2.Name="Rundschild";
			charsheet.Melee2.Attack="-";
			charsheet.Melee2.Break=2;
			charsheet.Melee2.Material="Holz";
			charsheet.Melee2.Block="2W6+3";
			
			
		}else if (arch.equals("Dieb")){
			charsheet.Talents[0] = "Schleichen";
			charsheet.Talents[1] = "Stehlen";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=STOFF;
			charsheet.meleeList[1]=FE;
			charsheet.meleeList[2]=DO;
			charsheet.SpecialItems[0]="Dietrich";
			charsheet.SpecialItems[1]="Enterhaken";
			charsheet.SpecialItems[2]="15 Jard langes Seil";
			charsheet.Stats[2]+=1;
			charsheet.Stats[3]+=1;
		    list[0] = new Spell("Hinterhältiger Stich", SCHNELL, "2W6+5 Schaden");
			list[1] = new Spell("Rauchbombe", GESCH, "Dieb verliert sämtliche Aufmerksamkeit");
			list[2] = new Spell("Schattentarnung", GESCH + ", "+ SCHNELL, "Dieb ist nicht angreifbar, bei Angriff aus der Tarnung heraus verdoppelt sich der ausgewürfelte Angriffswert");
			list[3] = new Spell("Schattenschlag", GESCH, "Wird aus der Schattentarnung heraus angegriffen, so wird der gegnerische Block um 3, sein Schutzwert um 2 verringert");
			list[4] = new Spell("Ausweichen", GESCH + ", "+ SCHNELL, "Dieb erhält für zwei Runden keinen Schaden durch Angriffe/ Fähigkeiten");
			list[5] = new Spell("Aus den Schatten", SCHNELL, "normaler Angriff aus der Schattentarnung, der Dieb gelangt danach allerdings wieder in Schattentarnung");
			
			//
			charsheet.Armor[1].Name="Ledermaske";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Leder";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
			}else if (arch.equals("Assassine")){
			charsheet.Talents[0] = "Giftherstellung";
			charsheet.Talents[1] = "Schleichen";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=STOFF;
			charsheet.meleeList[1]=FE;
			charsheet.meleeList[2]=DO;
			charsheet.rangeList[1]=B;
			charsheet.SpecialItems[0]="Enterhaken";
			charsheet.SpecialItems[1]="Giftfläschchen";
			charsheet.SpecialItems[2]="20 Jard langes Seil";
			charsheet.Stats[2]+=1;
			charsheet.Stats[7]+=1;
		    list[0] = new Spell("Wurfmesser", GESCH, "Fernkampfangriff mit der Nahkampfwaffe, Reichweite = doppelter Geschicklichkeitswert");
			list[1] = new Spell("Leichtes Waffengift", INTU, "Angriffswert der vergifteten Waffe +4, getroffene Gegner für 3 Runden 1W6 Schaden/ Runde");
			list[2] = new Spell("Auflauern", WACH, "gelangt unbemerkt hinter Ziel. Wurf 1W6. bei 5 oder 6 kann direkt nochmals eine Aktion durchgeführt werden");
			list[3] = new Spell("Attentat", GESCH, "Wenn der Assassine von hinten angreift, so erhöht sich der Angriffswert um 2W6+2");
			list[4] = new Spell("Scharfschütze", WACH, "erhöht für einen Fernkampfangriff die Reichweite um 2W6 mal 4 und den Waffenschaden um 2");
			list[5] = new Spell("Heckenschütze", GESCH, "1W6 + (Angriffswert der Munition) Schaden (nach Auflauern 2W6 + Munitionsangriffswert)");
			
			//
			charsheet.Armor[1].Name="Kapuze";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
		}else if (arch.equals("Gaukler")){
			charsheet.Talents[0] = "Narretei";
			charsheet.Talents[1] = "Feuer entzünden";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=STOFF;
			charsheet.meleeList[1]=FE;
			charsheet.meleeList[2]=DO;
			charsheet.SpecialItems[0]="6 Jonglierbälle";
			charsheet.SpecialItems[1]="2 Fackeln";
			charsheet.SpecialItems[2]="Flasche mit Öl";
			charsheet.SpecialItems[3]="Zunderzeug";
			charsheet.Stats[2]+=1;
		    list[0] = new Spell("Flickflack", GESCH, "Der nächste Angriff auf den Gaukler zeigt keine Wirkung, alle anderen dieser Runde Angriff -3");
			list[1] = new Spell("Salto Mortale", GESCH + ", "+ MUT, "eine Runde lang keinen Schaden durch ANgriffe/ Fähigkeiten. Ein Gegner 3W6 + 2 Schaden");
			list[2] = new Spell("Feueratem", GESCH, "Alle Gegner vor dem Gaukler 2W6+1 Schaden");
			list[3] = new Spell("Tödlicher Tanz", GESCH + ", "+ SCHNELL, "Alle Gegner um den Gaukler 1W6+3 Schaden");
			list[4] = new Spell("Wilde Jonglage", GESCH, "1W6 Gegner sind für 2 Runden abgelenkt: können nicht angreifen, aber angegriffen werden. Gaukler ist ebenfalls 2 Runden abgelenkt");
			list[5] = new Spell("Beeindruckender Abgang", GESCH+ ", 1 Energie/Runde", "nach jeden Einsatz einer Fähigkeit entgeht er dem nächsten Angriff eines Gegners");
			
			//
			charsheet.Armor[1].Name="Kapuze";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
		}else if (arch.equals("Scharlatan")){
			charsheet.Talents[0] = "Magiedilettant";
			charsheet.Talents[1] = "Astralsicht";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.armorTypeList[2]=LEDER;
			charsheet.meleeList[1]=STAB;
			charsheet.SpecialItems[0]="kleines Zauberbuch";
			charsheet.SpecialItems[1]="Lupe";
			charsheet.SpecialItems[2]="magische Schriften";
			charsheet.Stats[0]+=1;
		    list[0] = new Spell("Doppelgänger", INT, "für 2 Runden keinen Schaden durch gegnerische Angriffe/ Fähigkeiten");
			list[1] = new Spell("Trugbild", INT, "1W6 Gegner setzen für eine Runde aus");
			list[2] = new Spell("Funkenflug", INT, "1W6 Gegner jeweils 1W6+4 Schaden");
			list[3] = new Spell("Magische Rezitation", INT + ", " + INTU, "Alle Gegner setzen eine Runde lang aus. Bei Probenwerten >40 Mutprobe der Gegner, bei Nichtbestehen Flucht. Bei Patzer eine Runde Aufmerksamkeit aller Gegner");
			list[4] = new Spell("Feuerillusion", INT, "Gegner so lange kampfunfähig, bis er angegriffen wird");
			list[5] = new Spell("Frostzauber", INT, "Gegner für 3 Runden festgesetzt");
			
			
		}else if (arch.equals("Hexenjäger")){
			charsheet.Talents[0] = "Schleichen";
			charsheet.Talents[1] = "Astralsicht";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=STOFF;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=FE;
            charsheet.rangeList[1]=B;
            charsheet.rangeList[2]=A;
			charsheet.SpecialItems[0]="Schutzsymbol";
			charsheet.SpecialItems[1]="Kirchensiegel";
			charsheet.SpecialItems[2]="15 Jard langes Seil";
			charsheet.Stats[7]+=1;
		    list[0] = new Spell("Spezialisierung: Hexenjagd", WACH, "Angriff +3 gegen Zauberkundige, Zauberschaden auf Hexenjäger -4");
			list[1] = new Spell("Spezialisierung: Dämonenjagd", WACH, "Angriff +3 gegen Dämonen, Flüche haben keine Wirkung");
			list[2] = new Spell("Spezialisierung: Monsterjagd", INTU, "Angriff +3 gegen Bestien, Schutzwert +2 gegen Bestien");
			list[3] = new Spell("Spezialisierung: Geisterjagd", INTU, "Angriff und Block +3 gegen Untote");
			list[4] = new Spell("Tri-Schlag", GESCH, "normaler Angriff, allerdings auf drei Gegner mit demselben Angriffswert");
			list[5] = new Spell("Flexibilität im Kampf", INTU, "ermöglicht den Wechsel der aktiven Spezialisierung");
			
			//
			charsheet.Armor[1].Name="Filzhut";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
			
		}else if (arch.equals("Alchemist")){
			charsheet.Talents[0] = "Schreiben";
			charsheet.Talents[1] = "Alchemie";
			charsheet.armorTypeList[1]=LEDER;
			charsheet.armorTypeList[2]=STOFF;
			charsheet.meleeList[1]=STAB;
			charsheet.meleeList[2]=DO;
			charsheet.meleeList[3]=FE;
			charsheet.SpecialItems[0]="Fläschchen";
			charsheet.SpecialItems[1]="Alchemistenwerkzeug";
			charsheet.SpecialItems[2]="Zutatenvorrat";
			charsheet.SpecialItems[3]="Alchemistenbücher";
			charsheet.Stats[0]+=1;
			list[0] = new Spell("Einfacher Heiltrank", INT, "heilt um 1W6+6");
			list[1] = new Spell("Flammentrank", INT, "für drei Runden 1W6+2 Schaden/ Runde");
			list[2] = new Spell("Krafttrank", INT, "Kraft und Ausdauer +4, Block +2");
			list[3] = new Spell("Regenpulver", GESCH, "Alle Gegner 1W6 Schaden");
			list[4] = new Spell("Sulfidtrank", INT, "Gegner kann zwei Runden lang weder angreifen noch angegriffen werden");
			list[5] = new Spell("Verbindung", INT + ", "+ GESCH, "kombiniert zwei Mittel miteinander");
			
			//
			charsheet.Armor[1].Name="Barett";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
		}else if (arch.equals("Drachenjäger")){
			charsheet.Talents[0] = "Drachenkunde";
			charsheet.Talents[1] = "Strategie";
			charsheet.armorTypeList[1]=EISEN;
			charsheet.armorTypeList[2]=LEDER;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=ZWEISCHWERT;
			charsheet.meleeList[3]=PILUM;
			charsheet.meleeList[4]=EINAXT;
			charsheet.meleeList[5]=ZWAXT;
			charsheet.meleeList[6]=EINSK;
			charsheet.meleeList[7]=ZWEISK;
			charsheet.rangeList[1]=A;
			charsheet.SpecialItems[0]="Waffen- und Rüstungspolitur";
			charsheet.SpecialItems[1]="Fernrohr";
			charsheet.SpecialItems[2]="Wetzstein";
			charsheet.SpecialItems[3]="Drachenzahnamulett";
			charsheet.Stats[2]+=1;
			list[0] = new Spell("Köpfen", KRAFT, "normaler Nahkampfangriff, allerdings zählt nur Kopfrüstung");
			list[1] = new Spell("Durchschlagender Schuss", GESCH, "normaler Fernkampfangriff, Schutzwert wird ignoriert");
			list[2] = new Spell("Wunden reißen", KRAFT, "2W6+2 Schaden, für 2 Runden 1W6+2 Schaden/ Runde");
			list[3] = new Spell("Schuppen spalten", KRAFT, "Block- und Schutzwert für 3 Runden -2");
			list[4] = new Spell("Schwachpunkt treffen", KRAFT, "2W6+3 Schaden. Wenn danach HP<=15 ist der Gegner sofort tot");
			list[5] = new Spell("Longinusschuss", GESCH, "Munition gegen Drachen und Bestien +3 Angriff");
			
			//
			charsheet.Melee2.Name="Rundschild";
			charsheet.Melee2.Attack="-";
			charsheet.Melee2.Material="Holz";
			charsheet.Melee2.Break=2;
			charsheet.Melee2.Block="2W6+3";
			
		}else if (arch.equals("Kleriker")){
			charsheet.Talents[0] = "Schreiben";
			charsheet.Talents[1] = "Erste Hilfe";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.meleeList[1]=EINSK;
			charsheet.meleeList[2]=STAB;
			charsheet.SpecialItems[0]="Weihwasserfläschchen";
			charsheet.SpecialItems[1]="Grammat";
			charsheet.SpecialItems[2]="Heiliges Amulett";
			charsheet.SpecialItems[3]="Verbände";
			charsheet.SpecialItems[4]="Tinte und Feder";
			charsheet.Stats[0]+=1;
			list[0] = new Spell("Segnung der Götter", INT, "Lebenspunkte aller befreundeten Spieler +1W6+6 für diesen Kampf (nur einmal einsetzbar)");
			list[1] = new Spell("Götterspeer", INT, "Waffe Angriff +4 (gegen Dämonen und Untote +5)");
			list[2] = new Spell("Heil bringen", INT, "heilt um 3W6+3 und entfernt alle negativen Effekte");
			list[3] = new Spell("Geheiligte Erde", INT, "Alle befreundeten Ziele für 3 Runden um 2W6 geheilt, alle Gegner für 3 Runden 2W6 Schaden");
			list[4] = new Spell("Quell des Lebens", INT, "Belebt einen Charakter wieder und stellt 5W6 HP wieder her");
			list[5] = new Spell("Heiliges Schild", INT+", 1 Energie/ Runde", "Wird der Kleriker Ziel eines Angriffs oder einer Fähigkeit, werden alle befreundeten Ziele um 1W6+2 geheilt");
			
			//
			charsheet.Armor[1].Name="Barett";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
			
		}else if (arch.equals("Hohepriester")){
			charsheet.Talents[0] = "Erste Hilfe";
			charsheet.Talents[1] = "Schreiben";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.meleeList[1]=STAB;
			charsheet.SpecialItems[0]="Grammat";
			charsheet.SpecialItems[1]="Weihwasserfläschchen";
			charsheet.SpecialItems[2]="Heiliges Amulett";
			charsheet.SpecialItems[3]="Verbände";
			charsheet.SpecialItems[4]="Tinte und Feder";
			for (int i=0; i<charsheet.Stats.length; i++){
			   charsheet.Stats[i]+=1;
			}
		    list[0] = new Spell("Gebet der Vita", AUS, "Alle gefallenen Kameraden wiederbelebt mit 4W6 HP");
			list[1] = new Spell("Gebet der Ariasa", CHAR, "Alle befreundeten Ziele um 3W6+3 geheilt");
			list[2] = new Spell("Gebet des Maradur", INT, "Alle befreundeten Ziele um 2W6+2 geheilt, 1W6 Energie wiederhergestellt");
			list[3] = new Spell("Gebet des Baphos", GESCH, "Alle feindlichen Ziele 2W6+3 Schaden");
			list[4] = new Spell("Gebet des Thoran", MUT, "Lebenspunkte aller befreundeten Ziele +2W6 (nur einmal anwendbar)");
			list[5] = new Spell("Gebet des Rohmos", WACH, "Alle befreundeten Ziele um 2W6 geheilt, alle feindlichen Ziele 1W6+4 Schaden");
			
			//
			charsheet.Armor[1].Name="Barett";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
		}else if (arch.equals("Inquisitor")){
			charsheet.Talents[0] = "Schreiben";
			charsheet.Talents[1] = "Astralsicht";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.armorTypeList[2]=LEDER;
			charsheet.meleeList[1]=EINSCHWERT;
			charsheet.meleeList[2]=EINSK;
			charsheet.meleeList[3]=PILUM;
			charsheet.SpecialItems[0]="Grammat";
			charsheet.SpecialItems[1]="Heiliges Amulett";
			charsheet.SpecialItems[2]="Weihwasserfläschchen";
			charsheet.SpecialItems[3]="Pergament";
			charsheet.SpecialItems[4]="Tinte und Feder";
			charsheet.Stats[0]+=1;
			list[0] = new Spell("Weihe", INT, "gegnerische Fähigkeiten -6 Schaden für 4 Runden");
			list[1] = new Spell("Exorzismus", INT, "Untoter oder Dämon Angriff und Block -3, HP -1W6+3; Schutzwert -2");
			list[2] = new Spell("Bannbrecher", INT, "Ein befreundetes Ziel wird von absolut allen negativen Effekten befreit");
			list[3] = new Spell("Vergeltung", KRAFT + ", "+ INT+ ", 1 Energie/ Runde", "Erhält der Inquisitor Schaden, fügt er denselben Schaden zu. Hält 3 Runden ");
			list[4] = new Spell("Läuternde Flammen", INT, "Alle Gegner 2W6+2 Schaden (Dämonen, Untote, Zauberkundige 3W6), alle befreundete Ziele um 1W6+3 geheilt, gegnerische Fähigkeiten für 2 Runden -3 Schaden ");
			list[5] = new Spell("Fluchfessel", INT, "Gegner ist 3 Runden lang nicht in der Lage, Fähigkeiten einzusetzen");
			
			//
			charsheet.Armor[1].Name="Barett";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
			
			
		}else if (arch.equals("Arzt")){
			charsheet.Talents[0] = "Schreiben";
			charsheet.Talents[1] = "Erste Hilfe";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.meleeList[1]=DO;
			charsheet.meleeList[2]=STAB;
			charsheet.SpecialItems[0]="Pergament";
			charsheet.SpecialItems[1]="Arztwerkzeuggürtel";
			charsheet.SpecialItems[2]="Lupe";
			charsheet.SpecialItems[3]="Feder und Tinte";
			charsheet.SpecialItems[4]="Verbände";
			charsheet.Stats[0]+=1;
			list[0] = new Spell("Reanimieren", INT, "Belebt einen toten Charakter mit vollständgen HP wieder");
			list[1] = new Spell("Wohltuende Salbe", INT, "Heilt ein befreundetes Ziel um 2W6+5 ODER ein befreundetes Ziel erhält für 2 Runden +3 Angriff");
			list[2] = new Spell("Wunden verbinden", GESCH, "heilt um 2W6+2 ODER entfernt einen negativen Effekt");
			list[3] = new Spell("Desinfizieren", INT, "Entfernt einen Zauber und heilt um 1W6+4 ODER entfernt ein tierisches/ pflanzliches Gift und heilt um 1W6+4");
			list[4] = new Spell("Aderlass", GESCH, "Entfernt alle negativen Effekte und fügt dabei 1W6+3 Schaden zu ODER fügt 2W6+4 Schaden zu");
			list[5] = new Spell("Beschleunigte Heilung", INT, "Der Arzt zahlt bis zu 5 Energie ODER das Ziel zahlt bs zu 5 Energie. Heilt um (Anzahl Energie) W6");
			
			//
			charsheet.Armor[1].Name="Barett";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
					
					
					
		}else if (arch.equals("Barde")){
			charsheet.Talents[0] = "Bardenwissen";
			charsheet.Talents[1] = "Musizieren";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.meleeList[1]=DO;
			charsheet.meleeList[2]=FE;
			charsheet.setArchSpec(charsheet);
	
			charsheet.Stats[1]+=1;
			list[0] = new Spell("Motivierende Ballade", INT + ", "+ CHAR, "Die Moral aller befreundeten Ziele wird für diesen Kampf um 10 erhöht");
			list[1] = new Spell("Kriegslied", CHAR, "Angriffswert aller befreundeten Ziele +2");
			list[2] = new Spell("Belagerungslied", CHAR, "Blockwert aller befreundeten Ziele +2");
			list[3] = new Spell("Angsteinflößender Klang", INT, "Angriffswert alles feindlichen Ziele -3 für 2 Runden");
			list[4] = new Spell("Amuntalonische Hymne", CHAR + ", "+ INT, "Intelligenz, Kraft, Geschicklichkeit aller befreundeten Ziele +3 für 3 Runden");
			list[5] = new Spell("Ohrenbetäubender Lärm", INT, "Alle Gegner 2W6+2, alle befreundeten Ziele 6 Schaden");
			
			//
			charsheet.Armor[1].Name="Filzhut";
			charsheet.Armor[1].Sort="Kopf";
			charsheet.Armor[1].Material="Stoff";
			charsheet.Armor[1].Break="-";
			charsheet.Armor[1].Protection=1;
			
		}else if (arch.equals("Vampir")){
			charsheet.Talents[0] = "Angstaura";
			charsheet.Talents[1] = "Vampirgestalt";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.meleeList[1]=DO;
			charsheet.meleeList[2]=FE;
			charsheet.SpecialItems[0]="Blutphiole";
			charsheet.SpecialItems[1]="Clansiegelring";
			charsheet.Stats[0]+=2;
			charsheet.Stats[2]+=2;
			charsheet.Stats[3]+=1;
		    list[0] = new Spell("Blut saugen", GESCH, "fügt 2W6+1 Schaden zu, heilt Charakter um 1W6+3, generiert einen Blutpunkt");
			list[1] = new Spell("Blutmeister", GESCH +", 4 Blutpunkte", "Ein Gegner erleidet 3W6+3 Schaden");
			list[2] = new Spell("Biss", GESCH, "Angriff/ Block des Gegners -1, generiert einen Blutpunkt");
			list[3] = new Spell("Lebensentzug", INT, "alle feindlichen Ziele 2W6 Schaden, generiert einen Blutpunkt");
			list[4] = new Spell("Blutbad", INT + ", n Blutpunkte, "+ GESCH, "Ein Gegner erhält 2W6+n Schaden");
			list[5] = new Spell("Leichenblässe", INT+ ", 5 Blutpunkte", "stellt alle HP des Charakters wieder her");
			
			//
			charsheet.Armor[1].Name="Umhang";
			charsheet.Armor[1].Sort="Sonstige";
			charsheet.Armor[1].Break="4/8/12";
			charsheet.Armor[1].Protection=1;
			charsheet.Armor[1].Material=STOFF;
			
			
		}else if (arch.equals("Werwolf")){
			charsheet.Talents[0] = "Angstaura";
			charsheet.Talents[1] = "Werwolfgestalt";
			charsheet.armorTypeList[1]=STOFF;
			charsheet.armorTypeList[2]=LEDER;
			charsheet.meleeList[1]=ZWEISCHWERT;
			charsheet.meleeList[2]=ZWAXT;
			charsheet.meleeList[3]=ZWEISK;
			charsheet.SpecialItems[0]="Rudeltattoo";
			charsheet.SpecialItems[1]="Wolfszahnamulett";
			charsheet.Stats[4]+=2;
			charsheet.Stats[2]+=2;
			charsheet.Stats[7]+=1;
		    list[0] = new Spell("Krallenhieb", KRAFT, "Würfle mit 5W6. Ein feindliches Ziel erhält Schaden in Höhe der geraden Zahlen und eine Wolfswunde");
			list[1] = new Spell("Zerfleischen", GESCH, "Würfle mit 5W6. Ein feindliches Ziel erhält Schaden in Höhe der ungeraden Zahlen und eine Wolfswunde");
			list[2] = new Spell("Wolfsgeheul", WACH, "Für jede Wolfswunde auf ihnen erhalten feindliche Ziele für 3 Runden -1 Angriff");
			list[3] = new Spell("Scharfe Klauen", KRAFT, "erfolgreiche normale Angriffe fügen Wolfswunden zu");
			list[4] = new Spell("Fleisch reißen", KRAFT + ", "+ GESCH, "Ein feindliches Ziel mit 3 Wolfswunden erhält 4W6+2 Schaden. Wolfswunden verschwinden");
			list[5] = new Spell("Beißen", KRAFT, "2W6+2 Schaden und eine Wolfswunde");
		}
				
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
	
	public void setArchSpec(CharacterSheet charsheet){
		String arch = charsheet.Archetype;
		
		JFrame window2 = new JFrame("Sonderarchetypen");
		JLabel hunter = new JLabel("Sie haben den Archetyp Jäger gewählt. Wählen Sie nun ihr Tier");
	    JLabel warrior = new JLabel("Sie haben den Archetyp Krieger gewählt. Wählen Sie nun ihre bevorzugte Waffenkenntnis");
		JLabel guardian = new JLabel("Sie haben den Archetyp Hüter gewählt. Wählen Sie nun ihre bevorzugte Waffenkenntis");
		JLabel bard = new JLabel("Sie haben den Archetypen Barde gewählt. Wählen Sie nun ihr bevorzugtes Instrument");
		
		final String[] pets = {"Jagdhund", "Jagdfalke", "Luchs"};
		final String[] guardianWeapons = {ZWEISCHWERT, ZWAXT, STAB, EINSK, ZWEISK, FE, DO};
		final String[] warriorWeapons = {ZWAXT, STAB, EINSK, ZWEISK, DO};
		final String[] Instruments = {"Laute", "Harfe", "Schalmei", "Taschenpfeife", "Trommeln", "Trompete"};
	
		
		window2.setLayout(new FlowLayout());
		if (arch.equals("Jäger")){
			window2.add(hunter);
			JComboBox choose = new JComboBox(pets);
			choose.setActionCommand("SPECH");
			choose.addActionListener(new XmlActionListener(charsheet, choose, window2));
			window2.add(choose);
			window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window2.setSize(800,600);
			window2.setVisible(true);
		}else if (arch.equals("Krieger")){
			window2.add(warrior);
			JComboBox choose = new JComboBox(warriorWeapons);
			choose.setActionCommand("SPECW");
			choose.addActionListener(new XmlActionListener(charsheet, choose, window2));
			window2.add(choose);
			window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window2.setSize(800,600);
			window2.setVisible(true);
		}else if (arch.equals("Hüter")){
			window2.add(guardian);
			JComboBox choose = new JComboBox(guardianWeapons);
			choose.setActionCommand("SPECG");
			choose.addActionListener(new XmlActionListener(charsheet, choose, window2));
			window2.add(choose);
			window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window2.setSize(800,600);
			window2.setVisible(true);
		}else if (arch.equals("Barde")){
			window2.add(bard);
			JComboBox choose = new JComboBox(Instruments);
			choose.setActionCommand("SPECB");
			choose.addActionListener(new XmlActionListener(charsheet, choose, window2));
			window2.add(choose);
			window2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window2.setSize(800,600);
			window2.setVisible(true);
			}
		
		}
	public void setVampWereDuel(CharacterSheet charsheet){
		String arch = charsheet.Archetype;
		final String[] vampabil = {"Wandgang", "Astralsicht", "Betören", "Schreiben", "Schleichen", "Hypnose", "Etikette"};
		final String[] wereabil = {"Wittern", "Tiersprache", "Wandgang", "Raufen", "Schleichen", "Tierkunde"};
	final String[] vampweakness = {"Keine Reflexion", "Blutgier", "Depression", "Blutphobie"};
	final String[] wereweakness = {"Instinktgetrieben", "Zwiegespalten", "Wolfsbann"};
	final String[] vampstrength = {"Neutralisierender Biss", "Knoblauchimmunität", "Sonnenlichtimmunität", "Kalter Hunger"};
	final String[] werestrength = {"Neutralisierender Biss", "Silberimmunität", "Mondlichtimmunität", "Unterdrückter Zorn"};
		
		JFrame window3 = new JFrame("Sonderarchetypen");
		JPanel stuff = new JPanel();
	JLabel text = new JLabel("Sie haben den besonderen Archetypen "+ arch+" gewählt. Bitte nehmen Sie nun weitere Auswahlen vor:");
	JComboBox duel = new JComboBox(charsheet.meleeList);
	duel.setActionCommand("MELEE2");
	duel.addActionListener(new XmlActionListener(charsheet, duel));
	
	JList vab = new JList(vampabil);
	JScrollPane scrollvab = new JScrollPane(vab);
	JButton vabilities = new JButton("Auswahl speichern");
	vabilities.setActionCommand("ABIL");
	vabilities.addActionListener(new XmlActionListener(charsheet, vab));
	
	JList wab = new JList(wereabil);
	JScrollPane scrollwab = new JScrollPane(wab);
	JButton wabilities = new JButton("Auswahl speichern");
	wabilities.setActionCommand("ABIL");
	wabilities.addActionListener(new XmlActionListener(charsheet, wab));
	
	JComboBox vstrength = new JComboBox(vampstrength);
	vstrength.setActionCommand("VSTRENGTH");
	vstrength.addActionListener(new XmlActionListener(charsheet, vstrength));
	
	JComboBox vweak = new JComboBox(vampweakness);
	vweak.setActionCommand("VWEAK");
	vweak.addActionListener(new XmlActionListener(charsheet, vweak));
	
	JComboBox wweak = new JComboBox(wereweakness);
	wweak.setActionCommand("WWEAK");
	wweak.addActionListener(new XmlActionListener(charsheet, wweak));
	
	
	JComboBox wstrength = new JComboBox(werestrength);
	wstrength.setActionCommand("WSTRENGTH");
	wstrength.addActionListener(new XmlActionListener(charsheet, wstrength));
	
	JButton close = new JButton("OK");
	close.setActionCommand("close");
	close.addActionListener(new XmlActionListener(this, window3));
	
	
	
	if(arch.equals("Duellant")){
		window3.setLayout(new GridLayout(2,1));
		stuff.setLayout(new GridLayout(2,2));
		window3.add(text);
		
	stuff.add(new JLabel("Schildwaffe:"));
	stuff.add(duel);
	stuff.add(new JLabel(""));
	stuff.add(close);
	window3.add(stuff);
	window3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	window3.setSize(800,600);
	window3.setVisible(true);
	
	}else if(arch.equals("Vampir")){
		window3.setLayout(new GridLayout(2,1));
		stuff.setLayout(new GridLayout(5,2));
		window3.add(text);
		
		
		stuff.add(new JLabel("Kenntnisse: (wähle 3)"));
		stuff.add(scrollvab);
		stuff.add(new JLabel(""));
		stuff.add(vabilities);
		stuff.add(new JLabel("Stärke:"));
		stuff.add(vstrength);
		stuff.add(new JLabel("Schwäche:"));
		stuff.add(vweak);
		stuff.add(new JLabel(""));
		stuff.add(close);
		window3.add(stuff);
		window3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window3.setSize(800,600);
		window3.setVisible(true);
		
	}else if(arch.equals("Werwolf")){
		window3.setLayout(new GridLayout(2,1));
		stuff.setLayout(new GridLayout(5,2));
		window3.add(text);
		
		stuff.add(new JLabel("Kenntnisse: (wähle 3)"));
		stuff.add(scrollwab);
		stuff.add(new JLabel(""));
		stuff.add(wabilities);
		stuff.add(new JLabel("Stärke:"));
		stuff.add(wstrength);
		stuff.add(new JLabel("Schwäche:"));
		stuff.add(wweak);
		stuff.add(new JLabel(""));
		stuff.add(close);
		window3.add(stuff);
		window3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window3.setSize(800,600);
		window3.setVisible(true);
		
	}
	}
	
	public String output(int i){
		String erg="";
		String texto="";
		String texta="";
		String textu="";
		String rohtext = "<html><table border=1><tr><td>Name</td><td>"+ this.Name+"</td></tr><tr><td>Rasse</td><td>"+
   this.Race+"</td></tr><tr><td>Kultur</td><td>"
+ this.Culture +"</td></tr><tr><td>Archetyp</td><td>"
+this.Archetype+"</td></tr><tr><td>Religion</td><td>"
+this.Religion+"</td></tr><tr><td>Geschlecht</td><td>"+
this.Gender+"</td></tr><tr><td>Alter</td><td>"+
String.valueOf(this.Age)+"</td></tr><tr><td>Sprache</td><td>"+
this.Language+"</td></tr><tr><td>Kampfhand</td><td>"+
this.Hand+"</td></tr></table><table border=1><tr><td>Aussehen</td> <td>"+
this.Look+"</td></tr></table><table border=1><tr><td>Leben</td> <td>"
+String.valueOf(this.Hitpoints)+"</td><td>Energie</td><td>"+
String.valueOf(this.Energy)+"</td></tr></table><table><tr><td><table border=1> <th>Charakterwerte</th> <tr><td>Intelligenz</td><td>"+
String.valueOf(this.Stats[0])+"</td></tr><tr><td>Charisma</td><td>"+
String.valueOf(this.Stats[1])+"</td></tr><tr><td>Geschicklichkeit</td><td>"+
String.valueOf(this.Stats[2])+"</td></tr><tr><td>Schnelligkeit</td><td>"+
String.valueOf(this.Stats[3])+"</td></tr><tr><td>Kraft</td><td>"+
String.valueOf(this.Stats[4])+"</td></tr><tr><td>Ausdauer</td><td>"+
String.valueOf(this.Stats[5])+"</td></tr><tr><td>Mut</td><td>"+
String.valueOf(this.Stats[6])+"</td></tr><tr><td>Wachsamkeit</td><td>"+
String.valueOf(this.Stats[7])+"</td></tr><tr><td>Intuition</td><td>"+
String.valueOf(this.Stats[8])+"</td></tr></table></td><td><table border=1><th>Klassentalente</th><tr><td>"+
this.Talents[0]+"</td></tr><tr><td>"+this.Talents[1]+"</td></tr></table><table border=1><th>Kenntnisse</th><tr><td>"+
this.Abilities[0]+"</td></tr><tr><td>"+this.Abilities[1]+"</td></tr><tr><td>"+this.Abilities[2]+"</td></tr></table></td><td><table border=1><th>Stärke</th><tr><td>"+
this.Strength+"</td></tr></table><table border=1><th>Schwäche</th><tr><td>"+this.Weakness+"</td></tr></table><table border=1><th>Gesinnung</th><tr><td>"+
this.Alignment+"</td></tr></table></td></tr></table><h3>Nahkampfwaffen</h3><table border=1> <th> Name</th><th>Material</th><th>Angriffswert</th><th>Blockwert</th><th>Bruchfaktor</th><tr><td>"+
this.Melee.Name+"</td><td>"+this.Melee.Material+ "</td><td>"+this.Melee.Attack+"</td><td>"+this.Melee.Block+"</td><td>"+String.valueOf(this.Melee.Break)+"</td></tr><tr><td>"+
this.Melee2.Name+"</td><td>"+this.Melee2.Material+"</td><td>"+this.Melee2.Attack+"</td><td>"+this.Melee2.Block+"</td><td>"+String.valueOf(this.Melee2.Break)+"</td></tr></table><table><tr><td><h3>Fernkampfwaffen</h3><table border=1><th>Name</th><th>Reichweite</th><th>Genauigkeit</th><tr><td>"+
this.Range.Name+"</td><td>"+this.Range.Distance+"</td><td>"+String.valueOf(this.Range.Break)+"</td></tr></table></td><td><h3>Munition</h3><table border=1><th>Name</th><th>Angriff</th><tr><td>"+
this.Range.AmmoName +"</td><td>"+this.Range.Attack+"</td></tr></table></td></tr></table><h3>Fähigkeiten</h3><table border=1><th>Name</th><th>Voraussetzung</th><th>Wirkung</th><tr><td>"+
this.Spells[0].Name + "</td><td>"+ this.Spells[0].Prerequisites+"</td><td>"+this.Spells[0].Effect+"</td></tr><tr><td>"+
this.Spells[1].Name + "</td><td>"+ this.Spells[1].Prerequisites+"</td><td>"+this.Spells[1].Effect+"</td></tr><tr><td>"+
this.Spells[2].Name + "</td><td>"+ this.Spells[2].Prerequisites+"</td><td>"+this.Spells[2].Effect+"</td></tr><tr><td>"+
this.Spells[3].Name + "</td><td>"+ this.Spells[3].Prerequisites+"</td><td>"+this.Spells[3].Effect+"</td></tr></table><h3>Rüstung</h3><table border=1><th>Name</th><th>Rüstungsart</th><th>Schutzwert</th><th>Rissfaktor</th><tr><td>"+
this.Armor[0].Name + "</td><td>"+this.Armor[0].Sort+"</td><td>"+String.valueOf(this.Armor[0].Protection)+"</td><td>"+this.Armor[0].Break+"</td></tr><tr><td>"+
this.Armor[1].Name + "</td><td>"+this.Armor[1].Sort+"</td><td>"+String.valueOf(this.Armor[1].Protection)+"</td><td>"+this.Armor[1].Break+"</td></tr><table><table border=1><tr><td>Gesamtschutzwert</td><td>"+
String.valueOf(this.Armor[0].Break+ this.Armor[1].Break)+"</td></tr></table><table><th>Charaktereigenschaften</th><th> Moral</th><th>Ränge</th><tr><td><table border=1><tr><td>Willenskraft</td><td>"+
String.valueOf(this.Skills[0])+"</td><td> Tragkraft</td><td>"+
String.valueOf(this.Skills[6])+"</td></tr><tr><td>Konzentration</td><td>"+
String.valueOf(this.Skills[1])+"</td><td>Reisegeschwindigkeit</td><td>"+
String.valueOf(this.Skills[7])+"</td></tr><tr><td>Initiative</td><td>"+
String.valueOf(this.Skills[2])+"</td><td>Regeneration</td><td>"+
String.valueOf(this.Skills[8])+"</td></tr><tr><td>Selbstbeherrschung</td><td>"+
String.valueOf(this.Skills[3])+"</td><td>Imunsystem</td><td>"+
String.valueOf(this.Skills[9])+"</td></tr><tr><td>Gelenkigkeit</td><td>"+
String.valueOf(this.Skills[4])+"</td><td>Glaube</td><td>"+
String.valueOf(this.Skills[10])+"</td></tr><tr><td>Waffenkunde</td><td>"+
String.valueOf(this.Skills[5])+"</td><td>Glaube</td><td>"+
String.valueOf(this.Skills[11])+"</td></tr></table></td><td><table border=1><tr><td>90</td><td>+5</td><td></td></tr><tr><td>80</td><td>+4</td><td></td></tr><tr><td>70</td><td>+3</td><td></td></tr><tr><td>60</td><td>+2</td><td></td></tr><tr><td>50</td><td>+0</td><td>50</td></tr><tr><td>40</td><td>-2</td><td></td></tr><tr><td>30</td><td>-3</td><td></td></tr><tr><td>20</td><td>-4</td><td></td></tr><tr><td>10</td><td>-5</td><td></td></tr></table></td><td><table border=1, cellspacing=30%><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr></table></td></tr></table><h3>Besondere Besitztümer</h3><table border=1><tr><td>"+
this.SpecialItems[0]+"</td><td>"+
this.SpecialItems[1]+"</td><td>"+this.SpecialItems[2]+"</td></tr><tr><td>"+this.SpecialItems[3]+"</td><td>"+this.SpecialItems[4]+"</td><td>"+this.SpecialItems[5]+"</td></tr></table><h3>Beutel</h3><table border=1, cellspacing=200%><tr><td></td><td></td></tr></table></html>";
	
		if(i==0){
		texta=rohtext.replaceAll("ä", "&auml");
		texto=texta.replaceAll("ö", "&ouml");
		textu=texto.replaceAll("ü", "&uuml");
		erg=textu.replaceAll("ß", "&szlig");
		}else{
			erg = rohtext;
		}
		return erg;	
	}
	
  	}
