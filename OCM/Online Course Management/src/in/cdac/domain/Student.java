package in.cdac.domain;

public class Student implements Comparable<Student>{
	private int studentId;
	private String studentName;
	private String studentEmail;
	private long studentContactNumber;
	public Student() {
	
	}
	public Student(int studentId, String studentName, String studentEmail, long studentContactNumber) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentContactNumber = studentContactNumber;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public long getStudentContactNumber() {
		return studentContactNumber;
	}
	public void setStudentContactNumber(long studentContactNumber) {
		this.studentContactNumber = studentContactNumber;
	}
	@Override
	public int compareTo(Student other) {
		return this.studentId - other.studentId;
	}
	@Override
	public String toString() {
		return String.format("%-10d%-20s%-20s%-10ld", this.studentId, this.studentName, this.studentEmail, this.studentContactNumber);
				
	}
}
