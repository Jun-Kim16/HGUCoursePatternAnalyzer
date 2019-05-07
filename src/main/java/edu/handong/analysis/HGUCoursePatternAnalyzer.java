package edu.handong.analysis;

import java.util.Vector;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		Student[] nameLines = new Student[lines.length];
		Student[] students = new Student[this.numOfStudents];
		
		for(int i=0; i < lines.length; i++) {
			nameLines[i]= new Student(lines[i].split(",")[1].trim());
		}
		
		int i=0;
		for(Student name : nameLines) {
			if(!studentExist(students, name)) {
				students[i] = name;
				i++;
			}
			if(i==this.numOfStudents)
				break;
		}
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student){
		
		Vector<String> vector = new Vector<String>(students.length);
		for(Student stu : students) {
			if(stu!=null) vector.addElement(stu.getName());
		}
		if(vector.contains(student.getName()))
			return true;
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		Course[] courseLines = new Course[lines.length];
		Course[] courses = new Course[this.numOfCourses];
		
		for(int i=0; i < lines.length; i++) {
			courseLines[i]=new Course(lines[i].split(",")[2].trim());
		}
		
		
		int i=0;
		for(Course cname : courseLines) {
			
			if(!courseExist(courses, cname)) {
				courses[i] = cname;
			i++;
			}
			
			if(i==this.numOfCourses)
				break;
		}

		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course){
		Vector<String> vector = new Vector<String>(courses.length);
		
		for(Course cous : courses) {
			if(cous!=null) vector.addElement(cous.getCourseName());
		}
		if(vector.contains(course.getCourseName()))
			return true;
		return false;
	}
}
