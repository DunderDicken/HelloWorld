public class FigureTest {

	public static void main (String[] args) {
		Figure[] figs = new Figure[4];

		figs[0] = new Rectangle(10,10,10,10);
		figs[1] = new Circle(10,10,10);
		figs[2] = new Rectangle(20,20,20,20);
		figs[3] = new Circle(20,20,20);

		for(Figure fig : figs) {
			System.out.println(fig.getTitle());
			fig.printOut();
		}
		
/*		for (int index=0; index < figs.length; index++) {

			// clean the following code into more readable forms
			// using polymorphism (use printOut)

			if (figs[index] instanceof Circle) {
				System.out.println("Circle:");
				System.out.println("   Diameter: " + ((Circle) figs[index]).diameter());
			} else {
			    System.out.println("Rectangle:");
			}			
	
			System.out.println("   Highest x: " + figs[index].maxX());
			System.out.println("   Highest y: " + figs[index].maxY());
			System.out.println("   Area: " + figs[index].area());
			System.out.println("   Perimeter: " + figs[index].perimeter());
		}*/
	}

}
