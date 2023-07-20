
import java.sql.*;
import java.util.Scanner;
import service.DBService;
import service.impl.DBServiceImpl;
import service.impl.DBServiceMock;

public class Main {

    public static void main(String[] args) throws SQLException
    {

        DBService dbService = new DBServiceImpl();
        do{
            System.out.println("-------- Student db ---------");
            System.out.println("Please select action:");
            System.out.println("1 - Look list of groups");
            System.out.println("2 - Look list of student by group number");
            System.out.println("3 - Look list of student where Last Name start with ...");
            System.out.println("0 - exit");

            Scanner sc = new Scanner(System.in);

            Integer action = sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.exit(-1);
                case 1:
                    dbService.getDistinctGroups().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Please enter number group in formant : GR-XX");
                    String groupNumber = sc.nextLine();
                    // todo: validate enter information
                    dbService.getStudentsByGroup(groupNumber).forEach(System.out::println);
                    break;
                case 3:
                System.out.println("Please enter first letter of last name ");
                String letter = sc.nextLine();
                dbService.getStudentsLastNameStartWith(letter).forEach(System.out::println);
                break;
                default:
                    System.out.println("Incorrect enter. Please try again!!!");
            }
        } while (true);
    }
}
