import java.sql.*;  
import java.lang.*;
import java.util.*;

public class CRUD	
{  
	public static void main(String args[])
	{  

		
		try
		{  
			  
		Class.forName("org.mariadb.jdbc.Driver");  

		Connection con=DriverManager.getConnection(  
		"jdbc:mariadb://localhost:3306/PPA25","root","");  
			
			
		Statement stmt=con.createStatement(); 

		
			
		Scanner sobj=new Scanner(System.in);
		
		int Operation=1;

		System.out.println();
		System.out.println("Please enter your operation:");		
		System.out.println();

			while(Operation!=0)
			{
				
				System.out.println("1:Insert student data into student table");
				System.out.println("2:Update student data into student table");
				System.out.println("3:Delete student data from student table");
				System.out.println("4:Get a list of all student");
				System.out.println("5:Get one student information depending on the student id filter");
				System.out.println("0:Exit the application");
				System.out.println();

				Operation=sobj.nextInt();
			
				
				switch(Operation)
				{
				case 1:
					stmt.executeUpdate("insert into student(student_no,student_name,student_dob,student_doj) values(5,'Komal','1994-04-14','2021-10-22')");
					
				break;

				case 2: 
					stmt.executeUpdate("update student set student_dob='2002-03-13' where student_name='Neha'");
					break;
	
				case 3:
					stmt.executeUpdate("Delete from student where student_no=2");
					break;

				case 4:
					ResultSet rs=stmt.executeQuery("select * from student");  
					while(rs.next())
					{  
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getDate(3)+"  "+rs.getDate(4));  
					} 
					System.out.println();
					break;

				case 5:
					ResultSet rs2=stmt.executeQuery("select * from student where student_no=3");  
			
					while(rs2.next())
					{  
						System.out.println(rs2.getInt(1)+"  "+rs2.getString(2)+"   "+rs2.getDate(3)+"  "+rs2.getDate(4));  
					} 
					System.out.println();
					break;
	
				default:
					System.out.println("------Thanks for using the application--------");	
					break;
				}

			}
			
			con.close();    
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
		 
		
		
	}
 
}  

		
	

