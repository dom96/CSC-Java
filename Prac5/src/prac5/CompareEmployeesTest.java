package prac5;

import java.util.List;

import prac5.Csc2001BinarySearchTree;

 //inserting 10 hourly employees into a Binary Search Tree. The hourly employees are compared based on
 //the outlined criteria.
public class CompareEmployeesTest{
	public static void traverseAndShow(Csc2001BinarySearchTree<HourlyEmployee> testTree) {
        List<HourlyEmployee> testList = testTree.toList();
        HourlyEmployee prevItem = testList.get(0);

        // Traverse ordered list and display any value that
        // is out of order.
        for (HourlyEmployee thisItem : testList) {
            System.out.println(thisItem);
            if (prevItem.compareTo(thisItem) >0) {
                System.out.println("*** FAILED, value is "
                        + thisItem);
            }
            prevItem = thisItem;
        }
	}
 
	public static void main(String args[]){
 

		Csc2001BinarySearchTree<HourlyEmployee> employeetree = new Csc2001BinarySearchTree<HourlyEmployee>();
		// Create 10 new HourlyEmployees
		HourlyEmployee emp1 = new HourlyEmployee("Joe", 20, 6.0);
		HourlyEmployee emp2 = new HourlyEmployee("Al", 30, 4.0);
		HourlyEmployee emp3 = new HourlyEmployee("Maire", 15, 5.5);
		HourlyEmployee emp4 = new HourlyEmployee("Xavier", 12, 5.5);
		HourlyEmployee emp5 = new HourlyEmployee("Alice", 17, 6.0);
		HourlyEmployee emp6 = new HourlyEmployee("Adam", 18, 6.0);
		HourlyEmployee emp7 = new HourlyEmployee("Ken", 27, 5);
		HourlyEmployee emp8 = new HourlyEmployee("Zandra",30, 4.5 );
		HourlyEmployee emp9 = new HourlyEmployee("Rian", 30, 4.5);
		HourlyEmployee emp10 = new HourlyEmployee("Michael", 17, 6.0);
	
		// add them to the Binary Search Tree
		employeetree.insertNode(emp1);
		employeetree.insertNode(emp2);
		employeetree.insertNode(emp3);
		employeetree.insertNode(emp4);
		employeetree.insertNode(emp5);
		employeetree.insertNode(emp6);
		employeetree.insertNode(emp7);
		employeetree.insertNode(emp8);
		employeetree.insertNode(emp9);
		employeetree.insertNode(emp10);
		

		traverseAndShow(employeetree);
		
		
 
	}
}	
