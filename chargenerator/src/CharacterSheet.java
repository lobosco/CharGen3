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
		JPanel buttons = new JPanel();
		//f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize( 800, 600 );
		//Layout
		//f.setLayout( new FlowLayout(FlowLayout.CENTER));
		
		String Sheet = "<html>  " +
				"Name:"+ this.Name + "<p/>"+
				"Rasse:" + this.Race + "<p/>"+
				"Archetyp:" + this.Archetype + "<p/>"+
				"Religion:" + this.Religion + "<p/>"+
				"Geschlecht" + this.Gender + "<p/>"+
				"Alter:" + String.valueOf(this.Age) + "<p/>"+
				"Aussehen" + this.Look + "<p/>"+
				"Kampfhand:" + this.Hand + "<p/>"+
				"Leben" + String.valueOf(this.Hitpoints) +"<p/>"+
				"Charakterwerte: <p/>"+
				"Intelligenz" + String.valueOf(this.Stats[1]) +"<p/>"+
				"Charisma" + String.valueOf(this.Stats[2]) +"<p/>"+
				"Geschicklichkeit" + String.valueOf(this.Stats[3]) +"<p/>"+
				"Schnelligkeit" + String.valueOf(this.Stats[4]) +"<p/>"+
				"Kraft" + String.valueOf(this.Stats[5]) +"<p/>"+
				"Ausdauer" + String.valueOf(this.Stats[6]) +"<p/>"+
				"Mut" + String.valueOf(this.Stats[7]) +"<p/>"+
				"Wachsamkeit" + String.valueOf(this.Stats[8]) +"<p/>"+
				"Intuition" + String.valueOf(this.Stats[9]) +"<p/>"+
				"Klassentalente:" + this.Talents[0] + this.Talents[1] + "<p/>"+
				"Kenntnisse:"+ this.Abilities[0] + this.Abilities[1] + this.Abilities[2] + "<p/>"+
				"Stärke:" + this.Strength + "<p/>"+
				"Schwäche:" + this.Weakness + "<p/>"+
				"Gesinnung" + this.Alignment + "<p/>"+
				"Nahkampfwaffe:" + this.Melee.Name + this.Melee.Material + String.valueOf(this.Melee.Attack) + String.valueOf(this.Melee.Block)+ String.valueOf(this.Melee.Break)+ "<p/>"+
				"Fähigkeiten:<p/>"+
				this.Spells[1].Name + this.Spells[1].Prerequisites + this.Spells[1].Effect+ "<p/>"+
				this.Spells[2].Name + this.Spells[2].Prerequisites + this.Spells[2].Effect+ "<p/>"+
				this.Spells[3].Name + this.Spells[3].Prerequisites + this.Spells[3].Effect+ "<p/>"+
				this.Spells[3].Name + this.Spells[3].Prerequisites + this.Spells[3].Effect+ "<p/>"+
				"Rüstung:" + this.Armor[1].Name + "<p/>"+
				"Moral" + String.valueOf(this.Level)+ "<p/>"+"</html>";
		JLabel l = new JLabel (Sheet);
		buttons.add(l);
		
		
		//Buttons
		JButton xml = new JButton ("Als XML speichern");
		xml.addActionListener( new XmlActionListener(this));
		
		JButton end = new JButton("Ohne Speichern beenden");
		
		ActionListener finish = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		end.addActionListener(finish);
		buttons.add(end);
		buttons.add(xml);
		f.getContentPane().add(buttons);
		f.pack();
		f.setVisible ( true );
		
	}
	
	public void mainmenu (){
        JFrame fi = new JFrame( "Willkommen" );
		fi.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		fi.setSize( 800, 600 );
		fi.setVisible ( true );
		fi.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel li = new JLabel( "Herzlich Willkommen zum Charaktergenerator 3.0" );
		JButton xml = new JButton("Als XML speichern");
		JButton bu = new JButton("Ohne Speichern beenden");
	
		xml.addActionListener(new XmlActionListener(this));
		
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		bu.addActionListener(al);
		fi.add(li);
		fi.add( bu );
		fi.add(xml);
	}
	public void exportAsXML(){
		System.out.println("Wurde als XML exportiert");
	}
	
	public void setStats(){
		
	}
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
