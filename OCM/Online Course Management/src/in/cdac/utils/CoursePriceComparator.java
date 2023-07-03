package in.cdac.utils;

import java.util.Comparator;

import in.cdac.domain.Course;

public class CoursePriceComparator implements Comparator<Course>{
	@Override
	public int compare(Course c1, Course c2) {
		return (int) (c1.getCoursePrice()-c2.getCoursePrice());
	}
}
