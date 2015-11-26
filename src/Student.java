import java.util.Scanner;

public class Student 
{
	public Scanner scan = new Scanner(System.in);
	final static int APWEIGHT = 8;
	final static int HONORSWEIGHT = 5;
	final static int MAXCLASSES = 8;
	final static int MINCLASSES = 4;
	private String name;
	private int numClass = -1;
	private Class[] classList;
	private double GPA = 0;
	private double weightedGPA = 0;
	
	public Student()
	{
		setName();
	}
	
	
	public void setName()
	{
		System.out.println("Enter your name");
		name = scan.nextLine();
	}
	
	public String getName()
	{
		return name;
	}
	
	public Class[] getClassList()
	{
		return classList;
	}
	
	public void setClasses()
	{	
		while (numClass < MINCLASSES || numClass > MAXCLASSES)
		{
			System.out.println("Enter the number of classes that you will be taking");
			System.out.println("Must be greater than or equal to " + MINCLASSES);
			System.out.println("Must be less than or equal to " + MAXCLASSES);
			numClass = scan.nextInt();
			if (numClass < MINCLASSES || numClass > MAXCLASSES)
			{
				System.out.println("Invalid number of classes; try again");
			}
			else
			{
				System.out.println("You will be taking " + numClass + " classes this year");
			}
			
		}
		
		classList = new Class[numClass];
		
		for (int i = 0; i < numClass; i++)
		{
			System.out.println("Setting class number " + (i+1));
			
			classList[i] = new Class();
		}
	}
	
	public void calculateGPA()
	{
		for (int i = 0; i < numClass; i++)
		{
			GPA += classList[i].getGrade();
		}
		
		GPA /= numClass;
		System.out.println("GPA calulated");
	}
	
	public double getGPA()
	{
		return GPA;
	}
	
	public void calculateWeightedGPA()
	{
		for (int i = 0; i < numClass; i++)
		{
			if (classList[i].isAP())
			{
				weightedGPA+= (classList[i].getGrade() + APWEIGHT);
			}
			else
			{
				if (classList[i].isHonors())
				{
					weightedGPA+= (classList[i].getGrade() + HONORSWEIGHT);
				}
				else
				{
					weightedGPA += classList[i].getGrade();
				}
			}	
		}
		weightedGPA /= numClass;
		
		System.out.println("Weighted GPA calulated");
	}
	
	public double getWeightedGPA()
	{
		return weightedGPA;
	}
	
	public String toString()
	{
		String str = "******************************************";
		str += "\n*GPA info for " + name;
		
		for (int i = 0; i < classList.length; i++)
		{
			str += classList[i].toString();
		}
		str += "\n*Unweighted GPA: " + GPA;
		str += "\n*Weighted GPA: " + weightedGPA;
		str+= "\n******************************************"; 
		return str;
	}

}