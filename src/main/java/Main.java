import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{
        Student.loading();
        Book.loadBooks();
        while (true) {
            System.out.println();
            System.out.println("==================== LIBRARY MANAGEMENT SYSTEM ====================");
            System.out.println("1.Add Book ");
            System.out.println("2.Display Book ");
            System.out.println("3.Search Book ");
            System.out.println("4.issue Book ");
            System.out.println("5.Return Book ");
            System.out.println("6.Total Books ");
            System.out.println("7.Book Status ");
            System.out.println("8.Delete Books ");
            System.out.println("9. Add Student ");
            System.out.println("10. Display Students");
            System.out.println("11. Search Student");
            System.out.println("12. Delete Student");
            System.out.println("13.Exit");
            System.out.println();
            System.out.print("Enter choice : ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    Book.Add_book();
                    Book.saveBooks();
                    break;
                case 2:
                    for (int i = 0; i < Book.num.size(); i++) {
                        Book.num.get(i).Display_Details();
                    }
                    break;
                case 3:
                    Book.serach();
                    break;
                case 4:
                    Book.issue_book();
                    Book.saveBooks();
                    break;
                case 5 :
                    Book.return_book();
                    Book.saveBooks();
                    break;
                case 6:
                    Book.Total_Book();
                    break;
                case 7:
                    Book.Book_Status();
                    break;
                case 8:
                    Book.delete_book();
                    Book.saveBooks();
                    break;
                case 9:
                    Student.Add_Student();
                    break;
                case 10:
                    Student.Display_Student();
                    break;
                case 11 :
                    Student.Search_student();
                    break;
                case 12:
                    Student.Delete_student();
                    Book.saveBooks();
                    break;
                case 13:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
