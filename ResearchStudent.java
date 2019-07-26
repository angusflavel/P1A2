//ResearchStudent is a sub-class of the Student super class.
//A Research Student is allowed to work up to the maximum amount of hours in a week (24hrs * 7 = 168),
//as opposed to a Student who can only work up to 20hrs per week.
public class ResearchStudent extends Student {

	//Constructor
	public ResearchStudent(String ID, String studentName, String studentProgram) {
		
		//This inherits traits from the Super Student class.
		super(ID, studentName, studentProgram);
	}

	@Override
	public String[] printStudentDetails() {
		
		//This overrides the printStudentDetails method from the Super Student class.
		return super.printStudentDetails();
	}

	@Override
	//addJob checks for whether the job applied for is within the weekly time constraint.
	//If true, the application will be successful. If false, the application will be unsuccessful.
	public boolean addJob(double jobHours) {

		//168 hours is the maximum amount of hours in a week.
		if (super.getWorkingHours() + jobHours > 168) {
			
			return false;
		} 
		else {

			return true;
		}
	}

}
