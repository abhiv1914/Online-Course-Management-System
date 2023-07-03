package in.cdac.domain;

import java.util.ArrayList;
import java.util.List;

public class Course implements Comparable<Course>{
		private int courseId;
		private String courseName;
		private String instructorName;
		private int courseHours;
		private float coursePrice;
		private List<Student> students=new ArrayList<>();
		public Course() {
			
		}
		public Course(int courseId, String courseName, String instructorName, int courseHours, float coursePrice) {
			super();
			this.courseId = courseId;
			this.courseName = courseName;
			this.instructorName = instructorName;
			this.courseHours = courseHours;
			this.coursePrice = coursePrice;
			
		}
		
		public int getCourseId() {
			return courseId;
		}

		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public String getInstructorName() {
			return instructorName;
		}

		public void setInstructorName(String instructorName) {
			this.instructorName = instructorName;
		}

		public int getCourseHours() {
			return courseHours;
		}

		public List<Student> getStudents() {
			return students;
		}
		public void setStudents(List<Student> students) {
			this.students = students;
		}
		public void setCourseHours(int courseHours) {
			this.courseHours = courseHours;
		}

		public float getCoursePrice() {
			return coursePrice;
		}

		public void setCoursePrice(float coursePrice) {
			this.coursePrice = coursePrice;
		}

		public void addStudent(Student student) {
			students.add(student);
			System.out.println("Student added successfully.");
		}

		public void removeStudent(int studentid) {
			if (this.students != null) {
				Student key = new Student();
				key.setStudentId(studentid);
				if (this.students.contains(key)) {
						students.remove(key);
					System.out.println("Student is removed.");
				}
			}
		}
		public void displayStudents() {
	        for (Student student : students) {  
	            System.out.println(student.getStudentName()+"       "+student.getStudentId()+"           "+student.getStudentContactNumber()+"         "+student.getStudentEmail());
	        }
	    }
		
		@Override
		public int compareTo(Course other) {
			return this.courseId - other.courseId;
		}
		@Override
		public String toString() {
			return String.format("%-10d%-20s%-20s%-5d%-10.2f", this.courseId, this.courseName, this.instructorName, this.courseHours, this.coursePrice);
	}
	
}


