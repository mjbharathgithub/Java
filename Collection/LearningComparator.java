import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	String name,dep;
	int age,score;
	
	public Student(String name,String dep,int age,int score) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.dep=dep;
		this.age=age;
		this.score=score;
	}
}

	public class LearningComparator   {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> list = new ArrayList<>(Arrays.asList(new Student("Joseph", "EEE", 21,9),new Student("Bharath", "ECE", 23,8)));
		
		//System.out.println(list);
//		list.forEach(ele->System.out.println(ele.name+" "+ele.dep+" "+ele.age+" "+ele.score));
//		System.out.println();
//		list.sort((a,b)->a.name.compareTo(b.name));
//		list.forEach(ele->System.out.println(ele.name+" "+ele.dep+" "+ele.age+" "+ele.score));
//		System.out.println();
//		list.sort((a,b)->a.age-b.age);
//		list.forEach(ele->System.out.println(ele.name+" "+ele.dep+" "+ele.age+" "+ele.score));
//		
		Comparator<Student> compByAgeComparator=new Comparator<Student>() {
			public int compare(Student obj1,Student obj2) {
				return obj1.age<obj2.age?1:-1;
			}

			
		};
		list.sort(compByAgeComparator);
		list.forEach(ele->System.out.println(ele.name+" "+ele.dep+" "+ele.age+" "+ele.score));
		
		
		

	}

}
