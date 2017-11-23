package test;
 class Things{
	 protected String name;
	 protected static String descritption;
	 protected static int numOfThings = 0;
	 
	 public Things(String n) {
		 numOfThings++;
		 this.name =n;
	 }
	
}
public class StaticLambdaOsv {

	public static void main(String[] args) {
		Things thing1 = new Things(null);
		Things thing2 = new Things("Dobby");
		
		thing1.name = "Sally";
		Things.descritption = "ALL THE THINGS!";
		System.out.println(Things.descritption);
		
		
		
		System.out.println(Things.numOfThings);
		System.out.println(thing1.name);
		System.out.println(thing2.name);
	
	}
}


