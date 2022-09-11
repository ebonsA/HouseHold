
public class GradeBook {
	
	private String courseName;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void displayMesssage() {
		System.out.printf("Welcome to the Grade book for \n%s!\n", getCourseName());
	}

}
