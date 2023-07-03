package in.cdac.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import in.cdac.domain.Course;
import in.cdac.domain.Student;
import in.cdac.test.CourseTest;
import in.cdac.utils.CourseHoursComparator;
import in.cdac.utils.CourseIdComparator;
import in.cdac.utils.CourseNameComparator;
import in.cdac.utils.CoursePriceComparator;
import in.cdac.utils.InstructorNameComparator;
enum CourseManagement{
	EXIT,ADDCOURSE,ADDSTUDENT,FINDCOURSE,REMOVECOURSE,REMOVESTUDENT,PRINTCOURSE,PRINTSTUDENT
}
enum CompareCourse{
	EXIT,COURSEID,COURSENAME,COURSEHOURS,INSTRUCTORNAME,COURSEPRICE
}
public class Program {
	private static Scanner sc = new Scanner(System.in);

	private static void acceptRecord(int[] courseid) {
		if (courseid != null) {
			System.out.print("Enter course id	:	");
			courseid[0] = sc.nextInt();
		}
	}
	private static void addRecord(int[] studentid) {
		if (studentid != null) {
			System.out.print("Enter student id	:	");
			studentid[0] = sc.nextInt();
		}
	}	
	private static void acceptRecord(Course course) {
		System.out.println("Enter course name:");
		sc.nextLine();
		course.setCourseName(sc.nextLine());
		System.out.println("Enter course id:");
		course.setCourseId(sc.nextInt());
		System.out.println("Enter instructor name:");
		sc.nextLine();
		course.setInstructorName(sc.nextLine());
		System.out.println("Enter course hours:");
		course.setCourseHours(sc.nextInt());
		System.out.println("Enter course price:");
		course.setCoursePrice(sc.nextFloat());
	}
	private static void acceptData(Student student) {
		System.out.println("Enter student id:");
		student.setStudentId(sc.nextInt());
		System.out.println("Enter student name:");
		sc.nextLine();
		student.setStudentName(sc.nextLine());
		System.out.println("Enter student email id:");
		student.setStudentEmail(sc.nextLine());
		System.out.println("Enter student contact number:");
		student.setStudentContactNumber(sc.nextLong());
	}
	private static void printRecord(Course course1) {
		if (course1 != null)
			System.out.println(course1.toString());
		else
			System.out.println("Course not found.");
	}

	private static void printRecord(boolean removedStatus) {
		if (removedStatus)
			System.out.println("Course is removed");
		else
			System.out.println("Course not found.");
	}

	public static CourseManagement menuList() throws Exception{
		System.out.println("Welcome to Online Course Management");
		System.out.println("===================================");
		System.out.println("0.Exit");
		System.out.println("1.Add Course(s)");
		System.out.println("2.Add Student(s)");
		System.out.println("3.Find Course");
		System.out.println("4.Remove Course");
		System.out.println("5.Remove Student");
		System.out.println("6.Print Course[sorted]");
		System.out.println("7.Print Students");
		System.out.print("Enter choice	:	");
		int choice = sc.nextInt();
		return CourseManagement.values()[choice];
	}
	public static CompareCourse subMenuList( ) throws Exception{
		System.out.println("=============================");
		System.out.println("0.Exit");
		System.out.println("1.Compare By Course id");
		System.out.println("2.Compare By Course name");
		System.out.println("3.Compare By Course Hours");
		System.out.println("4.Compare By Instructor name");
		System.out.println("5.Compare By Course price");
		System.out.print("Enter choice	:	");
		int choice=sc.nextInt();
		return CompareCourse.values()[choice];
	}
	@SuppressWarnings("incomplete-switch")
	public static void main(String[] args) {
		CourseManagement choice;		//enum type 
		Course course = null;			//Course class reference
		int[] courseid = new int[1];	//For pass by reference
		int[] studentid= new int[1];	//For pass by reference
		CourseTest test = new CourseTest();
		test.setCourseTest(new ArrayList<>());	//for setting up the Array list of course type
		try {
			while ((choice = Program.menuList()) != CourseManagement.EXIT) {
				switch (choice) {
				case ADDCOURSE:
					course = new Course();
					Program.acceptRecord(course);
					test.addCourse(course);
					break;
				case ADDSTUDENT:
					Student student = new Student();
					Program.acceptData(student);
					course.addStudent(student);
					break;
				case FINDCOURSE:
					Program.acceptRecord( courseid );
					Course course1 = test.findCourse( courseid[ 0 ] );
					Program.printRecord( course1 );
					break;
				case REMOVECOURSE:
					Program.acceptRecord( courseid );
					boolean removedStatus = test.removeCourse( courseid[ 0 ] );
					Program.printRecord( removedStatus );
					break;
				case REMOVESTUDENT:
					Program.addRecord( studentid );
					course.removeStudent(studentid[0]);
					break;
				case PRINTCOURSE:
					CompareCourse choice1;
					while( ( choice1 = Program.subMenuList( ) ) != CompareCourse.EXIT){
						Comparator<Course> comparator = null;
						switch( choice1 ) {
						case COURSEID:
							comparator = new CourseIdComparator();
							break;
						case COURSENAME:
							comparator = new CourseNameComparator();
							break;
						case COURSEHOURS:
							comparator = new CourseHoursComparator();
							break;
						case INSTRUCTORNAME:
							comparator = new InstructorNameComparator();
							break;
						case COURSEPRICE:
							comparator = new CoursePriceComparator();
							break;
						}
					test.printCourse(comparator);
					}
				case PRINTSTUDENT:
					course.displayStudents();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Enter the valid choice! ");
			
		}
	}
}
