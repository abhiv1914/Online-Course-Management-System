package in.cdac.utils;

import java.util.Comparator;

import in.cdac.domain.Course;

public class InstructorNameComparator implements Comparator<Course>{
	@Override
	public int compare(Course c1, Course c2) {
		return c1.getInstructorName().compareTo(c2.getInstructorName());
	}
}
