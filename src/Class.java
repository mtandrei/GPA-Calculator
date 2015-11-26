import java.util.Scanner;

public class Class 
{
	public Scanner scan = new Scanner(System.in);
	private String name;
	private boolean honors;
	private boolean AP; 
	private double grade = -1;
	
	public Class()
	{
		this.setName();
		this.setClassType();
		this.setGrade();
	}
	
	public void setName()
	{
		System.out.println("Enter the name of this class");
		name = scan.nextLine();
		System.out.println("Name of the class: " + name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setGrade()
	{
		while (grade < 0 || grade > 100)
		{
			System.out.println("What was your unweighted grade in the class? (input must be from 0 to 100))");
			
			grade = scan.nextDouble();
			
			if (grade < 0 || grade > 100)
			{
				System.out.println("Error: invalid input; enter a valid grade");
			}
			else
			{
				System.out.println("Your grade for the class is: " + grade);
			}
			
		}	
	}
	
	public double getGrade()
	{
		return grade;
	}
	
	public void setClassType()
	{
		System.out.println("Enter the type of class (AP or Honors; any other input sets it to regular)");
		String str = scan.nextLine();
		if (str.equalsIgnoreCase("Honors"))
		{
			this.honors = true;
			System.out.println("This will be listed as an Honors class");
		}
		else
		{
			if (str.equalsIgnoreCase("AP"))
			{
				this.AP = true;
				System.out.println("This will be listed as an AP class");
			}
			else
			{
				System.out.println("This will be listed as a regular class");
			}
		}
	}
	
	public boolean isAP()
	{
		boolean temp = false;
		if (this.AP)
			temp = true;
		return temp;
	}
	
	public boolean isHonors()
	{
		boolean temp = false;
		if (this.honors)
			temp = true;
		return temp;
	}
	
	public String toString()
	{
		String str = ("\n*" + "Grade for " + this.getName() + ": " + this.getGrade());
		
		return str;
	}

}
