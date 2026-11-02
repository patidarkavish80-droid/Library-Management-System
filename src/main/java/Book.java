
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Book {

    int bookId;
    String title;
    String author;
    Student issuedToStudent;
    boolean available = true;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void Display_Details() {
        System.out.println("BOOK ID : " + bookId);
        System.out.println("TITLE : " + title);
        System.out.println("AUTHOR : " + author);
        System.out.println("AVAILABLE : " + available);
        if (!available && issuedToStudent != null) {
            System.out.println("Issued To: " + issuedToStudent.studentID);
            System.out.println("Student Name: " + issuedToStudent.name);
        }
        System.out.println();
    }

    static void Add_book() {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book id : ");
        int book_id = sc.nextInt();
        for (int i=0;i<num.size();i++){
            if(num.get(i).bookId==book_id){
                found = true;
            }
        }
        if(found){
            System.out.println("Book ID already exists!");
            return;
        }
        sc.nextLine();
        System.out.print("Enter book title : ");
        String title = sc.nextLine();
        System.out.print("Enter author name : ");
        String author = sc.nextLine();
        Book b = new Book(book_id, title, author);
        num.add(b);
        System.out.println("Add book successful");

    }

    static boolean found;

    static void serach() {
        found = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book id : ");
        int id = sc.nextInt();
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).bookId == id) {
                num.get(i).Display_Details();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book Not Found");
        }
    }
    static void issue_book() {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book id: ");
        int bookid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student id :");
        String StudentId = sc.nextLine();
        Student student = null;

        for (int i = 0; i < Student.details.size(); i++) {
            if (Student.details.get(i).studentID.equals(StudentId)) {
                student = Student.details.get(i);
                break;
            }
        }
        if (student == null) {
            System.out.println("Student Not Found");
            return;
        }
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).bookId == bookid) {
                found = true;

                if (num.get(i).available) {
                    num.get(i).available = false;
                    num.get(i).issuedToStudent = student;
                System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book already issued!");
                }

                break;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }
    static void return_book(){
        System.out.print("Enter book id : ");
        Scanner sc = new Scanner(System.in);
        int bookid = sc.nextInt();
        for (int i =0;i<num.size();i++){
            if(num.get(i).bookId==bookid){
                found = true;
                if(num.get(i).available==false) {
                    num.get(i).available=true;
                    num.get(i).issuedToStudent=null;

                    System.out.println("Book return successfully!");
                }else{
                    System.out.println("Book not issue");
                }
            }
        }if(!found){
            System.out.println("Book not found ");
        }
    }
    static void Total_Book(){

        System.out.println("Total Books : "+num.size());
    }
    static void Book_Status(){
        int count_available=0;
        int count_issue=0;
        for( int i=0;i<num.size();i++){
            if(num.get(i).available==true){
                count_available++;
            }else {
                count_issue++;
            }
        }
        System.out.println("Available Count : "+count_available);
        System.out.println("Issue Count : "+count_issue);

    }
    static void delete_book(){
        found=true;
        System.out.print("Enter book id : ");
        Scanner sc = new Scanner(System.in);
        int bookid = sc.nextInt();
        for (int i=0;i< num.size();i++){
            if(num.get(i).bookId==bookid){
                num.remove(i);
                System.out.println("Delete book successful!!");
                found=false;
            }
        }if(found){
            System.out.println("Book Not Found");
        }
    }



    static ArrayList<Book> num = new ArrayList<>();

    public static void main(String[] args) {
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
                    Add_book();
                    break;
                case 2:
                    for (int i = 0; i < num.size(); i++) {
                        num.get(i).Display_Details();
                    }
                    break;
                case 3:
                    serach();
                    break;
                case 4:
                    issue_book();
                    break;
                case 5 :
                    return_book();
                    break;
                case 6:
                    Total_Book();
                    break;
                case 7:
                    Book_Status();
                    break;
                case 8:
                    delete_book();
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
                    break;
                case 13:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}



