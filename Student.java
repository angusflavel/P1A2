public class Student {

	private String ID, studentName, studentProgram, employer, jobTitle;
	private double workingHours;

	public Student(String ID, String studentName, String studentProgram) {
		this.ID = ID;
		this.studentName = studentName;
		this.studentProgram = studentProgram;

		this.employer = " ";
		this.jobTitle = " ";
		this.workingHours = 0.0;
	}

	public String[] printStudentDetails() {

		String[] studentDetails = { this.ID, this.studentName, this.studentProgram, this.employer, this.jobTitle,
				String.valueOf(this.workingHours) };
		return studentDetails;
	}

	public boolean addJob(double hours) {

		if ((this.workingHours + hours) > 20) {
			return false;
		} else {
			return true;
		}
	}

	public String getID() {
		return ID;
	}
	
	public double getWorkingHours() {
		return workingHours;
	}

	public void setJobTitle(String jobTitle) {
		if (this.jobTitle.equals(" ")) {
			this.jobTitle = jobTitle;
		} else {
			this.jobTitle += ", " + jobTitle;
		}
	}

	public void setEmployer(String employer) {
		if (this.employer.equals(" ")) {
			this.employer = employer;
		} else {
			this.employer += ", " + employer;
		}
	}

	public void setWorkingHours(double hours) {
		if (this.workingHours == 0.0) {
			this.workingHours = hours;
		} else {
			this.workingHours += hours;
		}
	}
}