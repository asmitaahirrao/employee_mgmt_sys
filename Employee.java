package employee;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;

public class Employee {

    public static void main(String[] args) {
     try{
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/employee","abc","abc");  
            Statement s = c.createStatement();
            int ch=0;
            Scanner sc = new Scanner(System.in);
            while(ch !=5)
            {
                System.out.println("                                    Welcome to Employee Registration System...");
                System.out.println("Opeartions you can perform..");
                System.out.println("1. View data"); 
                System.out.println("2. Insert data"); 
                System.out.println("3. Update data"); 
                System.out.println("4. Delete data"); 
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");
                ch = sc.nextInt();
                switch(ch)
                {
                    case 1 :
                    {
                        ResultSet rs = s.executeQuery("Select * from employees");
                        System.out.println("EMP_ID      "+"EMP_NAME      "+"MOBILE_NO       "+"MAIL_ID      ");
                        while(rs.next())
                        {
                            System.out.println(" ");
                            System.out.print(rs.getInt(1));
                            System.out.print("           "+rs.getString(2));
                            System.out.print("        "+rs.getInt(3));
                            System.out.println("      "+rs.getString(4));
                        }
                        System.out.println("Data fetched successfully...");
                        break;
                    }
                    case 2:
                    {
                        /*Scanner sc1 = new Scanner(System.in);
                        System.out.println("Enter the values to be inserted: ");
                        System.out.print("Employee ID: ");
                        Integer emp_id = sc1.nextInt();
                        Scanner sc2 = new Scanner(System.in);
                        System.out.print("Employee name: ");
                        String emp_name = sc2.nextLine();
                        Scanner sc3 = new Scanner(System.in);
                        System.out.print("Mobile no.: ");
                        Integer mob_no = sc3.nextInt();
                        Scanner sc4 = new Scanner(System.in);
                        System.out.print("Mail ID: ");
                        String mail_id = sc4.nextLine();
                        int i  = s.executeUpdate("insert into employees(EMP_ID, EMP_NAME, MOBILE_NO, MAIL_ID) values(emp_id, emp_name, mob_no, mail_id)");*/
                        ResultSet rs = s.executeQuery("Select * from employees");
                        System.out.println("EMP_ID      "+"EMP_NAME      "+"MOBILE_NO       "+"MAIL_ID      ");
                        while(rs.next())
                        {
                            System.out.println(" ");
                            System.out.print(rs.getInt(1));
                            System.out.print("           "+rs.getString(2));
                            System.out.print("        "+rs.getInt(3));
                            System.out.println("      "+rs.getString(4));
                        }
                        System.out.println("Data inserted successfully...");
                        break;
                    }
                    case 3:
                    {
                        int i  = s.executeUpdate("update employees set MOBILE_NO = 1243568709 where EMP_NAME = 'Ashley' ");
                        ResultSet rs = s.executeQuery("Select * from employees");
                        System.out.println("EMP_ID      "+"EMP_NAME      "+"MOBILE_NO       "+"MAIL_ID      ");
                        while(rs.next())
                        {
                            System.out.println(" ");
                            System.out.print(rs.getInt(1));
                            System.out.print("           "+rs.getString(2));
                            System.out.print("        "+rs.getInt(3));
                            System.out.println("      "+rs.getString(4));
                        }
                        System.out.println("Data updated successfully...");
                        break;
                    }
                    case 4:
                    {
                        int i  = s.executeUpdate("Delete from employees where EMP_ID = 6");
                        ResultSet rs = s.executeQuery("Select * from employees");
                        System.out.println("EMP_ID      "+"EMP_NAME      "+"MOBILE_NO       "+"MAIL_ID      ");
                        while(rs.next())
                        {
                            System.out.println(" ");
                            System.out.print(rs.getInt(1));
                            System.out.print("           "+rs.getString(2));
                            System.out.print("        "+rs.getInt(3));
                            System.out.println("      "+rs.getString(4));
                        }
                        System.out.println("Data deleted successfully...");
                        break;
                    }
                    case 5:
                    {
                        if (ch==5)
                        System.out.println("Exited successfully...");
                        break;
                    }
                }
            }
     }
     catch(Exception e)
     {
        System.out.println(e);
     }
    }
}
