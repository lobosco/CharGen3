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
public class Armor {
	
	String Name;
    String Sort;
    String Material;
    int Protection;
    String Break;
    
    public Armor(String Name, String Sort, String Material, int Protection, String Break){
    	this.Name = Name;
    	this.Sort = Sort;
    	this.Material = Material;
    	this.Protection = Protection;
    	this.Break = Break;
    }
    

}
