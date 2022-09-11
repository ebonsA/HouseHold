import java.util.Scanner;

public class GradeBookTest {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			GradeBook myGradeBook = new GradeBook();
			
			System.out.printf("Initial course Name is ", myGradeBook.getCourseName());
			System.out.println();
			
			System.out.println("Please enter course: ");
			String theName = input.nextLine();
			myGradeBook.setCourseName(theName);
			System.out.println();
			
			myGradeBook.displayMesssage();
			
		
		}
	}

}
