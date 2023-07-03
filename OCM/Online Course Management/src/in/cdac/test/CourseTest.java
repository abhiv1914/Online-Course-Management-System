package in.cdac.test;
import java.util.Comparator;
import java.util.List;

import in.cdac.domain.Course;
import in.cdac.domain.Student;

public class CourseTest {
	private List<Course> courseList;
	public void setCourseTest( List<Course> courseList) {
		this.courseList=courseList;
	}

	public void addCourse(Course course) {
		if (this.courseList != null) {
			this.courseList.add(course);
			System.out.println("Course is added successfully.");
		}
	}

	public void printCourse(Comparator<Course> comparator) {
		if (this.courseList != null) {
			this.courseList.sort(comparator);
			this.courseList.forEach(System.out::println);
		}
	}

	public Course findCourse(int courseid) {
		if (this.courseList != null) {
			Course key = new Course();
			key.setCourseId(courseid);
			if (this.courseList.contains(key)) {
				int index = this.courseList.indexOf(key);
				Course value = this.courseList.get(index);
				return value;
			}
		}
		return null;
	}

	public boolean removeCourse(int courseid) {
		if (this.courseList != null) {
			Course key = new Course();
			key.setCourseId(courseid);
			if (this.courseList.contains(key)) {
				this.courseList.remove(key);
				return true;
			}
		}
		return false;
	}
}