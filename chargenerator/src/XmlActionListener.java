import java.awt.event.*;

public class XmlActionListener implements ActionListener {
//initialisation of charsheet
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
	
     CharacterSheet charsheet = new CharacterSheet(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,ar);
//declaration
	XmlActionListener(CharacterSheet charsheet){
	this.charsheet = charsheet;
}
//performance of action
	public void actionPerformed(ActionEvent e){
		charsheet.exportAsXML();
	}
}
