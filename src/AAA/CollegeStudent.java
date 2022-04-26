package AAA;

import java.util.HashMap;

public class CollegeStudent extends Student {
	
	//HashMap m = new HashMap();
	private String major;
	
	
	public CollegeStudent()
	{
		
	}
	public CollegeStudent(String name,int StudentID,String major)
	{
		super(name,StudentID);
		this.major = major;
	}
	
	
	public void doHomeWork()
	{
		//super.doHomeWork();
		System.out.println("College Student do homework....1 more hour");
	}
	
}
