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
public class Weapon {
	
	 String Name;
     int Break;
     int Attack;
     int Distance;
     int Block;
     int Value;
     String Material;
     
     public Weapon(String Name, int Break, int Attack, int Distance, int Block, int Value, String Material){
    	 this.Name = Name;
    	 this.Break = Break;
    	 this.Attack = Attack;
    	 this.Distance = Distance;
    	 this.Block = Block;
    	 this.Value = Value;
    	 this.Material = Material;
     }
	

}
