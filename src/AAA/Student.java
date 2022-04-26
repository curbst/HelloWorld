package AAA;

import java.util.HashMap;

public  class Student {
	private String name;
	private int StudentID;

	public Student()
	{
		
	}
	
	public void doHomeWork()
	{
		System.out.println("Student do homework....1 hour");
	}
	
	public void setName(String name) {
		if(name.equals("Pig")) {
			System.out.println("ERROR Name");
			return;
		}
		
		this.name=name;
	}
	public Student(String name,int StudentID)
	{
		this.name=name;
		this.StudentID = StudentID;

	}
	
	public void ShowName()
	{
		System.out.println("name="+name);
	}


}
