package session3practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class mainperson1 {

	public static void main(String[] args) {
		person1 user1=new person1("mahsa","email1",20);
		person1 user2=new person1("Kimia","email2",25);
		person1 user3=new person1("Atefe","email3",26);
		person1 user5=new person1("Amir","email5",32);
		person1 user6=new person1("Ahmad","email6",37);
		person1 user7=new person1("Amir","email7",35);
		person1 user8=new person1("Ahmad","email12",37);
		
	//by using generic List<Person1>, we determine the type List persons------------------------------------------
	//simple method for filling List persons-----------------------------------------------
		List<person1> persons=new ArrayList<>();
		persons.add(user1);
		persons.add(user2);
		persons.add(user3);
		persons.add(user5);
		persons.add(user6);
		persons.add(user7);
		persons.add(user8);
		System.out.println("first version  "+ persons);
	
		
		//another method for creating List---------------------------------------------
		String[] personsArray={"Ali","Alireza","Ahmad"};
		List<String> personss=Arrays.asList(personsArray);
		System.out.println("second version   "+personss);
	    
		
		//we can use methods in List and collection-------------------------------------------------------
		
		System.out.println("size list first version"+persons.size());
		
		//creating sublist---------------------------------------------------------------
		List<person1> childs=persons.subList(1, 3);
		System.out.println("chils is "+childs);
		//adding and removing ----------------------------------------------------------
		person1 user4=new person1("Zahra","email4",30);
		persons.add(user4);
		System.out.println("adding user 4 is done "+ persons);
		
		persons.removeIf(person1 -> person1.getName()=="mahsa");
		System.out.println("removing mahsa is done "+ persons);
		
		//remove if------------------------------------------------------
		persons.removeIf(person1 ->person1.getAge()==25);
		System.out.println("person with age 25 is removed"+ persons);
		
		//finding element in list by equal // equal is sensitive to capital and small
		for(person1 target:persons) {
			if (target.getName().equals("Zahra")) {
				System.out.println("your list has Zahra");
			}
		}
		//finding element in list by contains--------------------------------------------
		int j=0;
		for (person1 target : persons) {	
			if(target.getName().equals("Amir")) {
				j++;
			}
		}
		System.out.println("the name amir appers "+ j+" times");
			
		//------------------------------------------------------------------------------------
		//finding element in list version2
		//int w=0;
		// person1 targetsearch=new person1("Ahmad"," ",0);
		//for(person1 p:persons){
		//	if(p.contains(targetsearch)) {
		//	 w++;	
		//	 }
		//}
		//System.out.println(w);-----------------------------------------------------------------
		
		person1 targetsearch=new person1("Ahmad"," ",0);
		if(persons.contains(targetsearch)) {
			System.out.println("we found Ahmad");
		}
		//if i want to find how many ahmads are in list persons???--------------------------------------------
		
		System.out.println("user4 index in list is "+ persons.lastIndexOf(user4));
		
		
		//using iterators-----------------------------------------------------
		
		List<person1> sublist= new ArrayList<>();
		for (Iterator<person1> iterator = persons.iterator(); iterator.hasNext();) {
			person1 userr = (person1) iterator.next();
			userr.setName(userr.getName().toUpperCase());
			if(userr.getAge()>35) {
				sublist.add(userr);
			}
		}
			System.out.println(persons);
			System.out.println("persons are old: "+ sublist);
		
		//compare list version1 by writing directly sort list persons by age------------------------------------------
			
			Collections.sort(persons, new Comparator<person1>() {
				@Override
				public int compare(person1 o1, person1 o2) {
					return o1.getAge()-o2.getAge();
				}
				
			});
			System.out.println("sorted list persons based on age version1  "+ persons);
			
		///sorting by name  compareTo is a  method for comparing string
			Collections.sort(persons, new Comparator<person1>() {
				@Override
				public int compare(person1 o1, person1 o2) {
					return o1.getName().compareTo(o2.getName());
				}
				
			});
			System.out.println("sorted list persons based on name version1  "+ persons);
				
		///if we want compare based on age 	
			persons.sort(Comparator.comparing(person1::getAge));
	        System.out.println("sorted list persons based on age version2 " + persons);
	    ///if we want compare based on name
	        persons.sort(Comparator.comparing(person1::getName));
	        System.out.println("sorted list persons based on  name version2" + persons);
	        
	    ///
	        
}
}



