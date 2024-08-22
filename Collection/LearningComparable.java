import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class LearningComparable implements Comparable<LearningComparable>{
	String name,dep;
	int age,score;
	
	public LearningComparable(String name,String dep,int age,int score) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.dep=dep;
		this.age=age;
		this.score=score;
	}
	

	@Override
	public int compareTo(LearningComparable o) {
		
		return this.score-o.score;
	
				}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<LearningComparable> list = new ArrayList<>(Arrays.asList(new LearningComparable("JK", "EEE", 21, 9),new LearningComparable("JB", "EE", 21, 8)));
		list.forEach(ele->System.out.println(ele.name+" "+ele.age+" "+ele.dep+" "+ele.score));
		
		Collections.sort(list);
		list.forEach(ele->System.out.println(ele.name+" "+ele.age+" "+ele.dep+" "+ele.score));
		
	}

}
