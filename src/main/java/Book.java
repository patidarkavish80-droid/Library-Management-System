
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    static void Add_book() throws IOException {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book id : ");
        int book_id = sc.nextInt();
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).bookId == book_id) {
                found = true;
            }
        }
        if (found) {
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

    }


    static boolean found;

    static void search(){
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

    static void return_book() {
        found = false;
        System.out.print("Enter book id : ");
        Scanner sc = new Scanner(System.in);
        int bookid = sc.nextInt();
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).bookId == bookid) {
                found = true;
                if (num.get(i).available == false) {
                    num.get(i).available = true;
                    num.get(i).issuedToStudent = null;

                    System.out.println("Book return successfully!");
                } else {
                    System.out.println("Book not issue");
                }
            }
        }
        if (!found) {
            System.out.println("Book not found ");
        }
    }

    static void Total_Book() {

        System.out.println("Total Books : " + num.size());
    }

    static void Book_Status() {
        int count_available = 0;
        int count_issue = 0;
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).available == true) {
                count_available++;
            } else {
                count_issue++;
            }
        }
        System.out.println("Available Count : " + count_available);
        System.out.println("Issue Count : " + count_issue);

    }

    static void delete_book() {
        found = true;
        System.out.print("Enter book id : ");
        Scanner sc = new Scanner(System.in);
        int bookid = sc.nextInt();
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).bookId == bookid) {
                num.remove(i);
                System.out.println("Delete book successful!!");
                found = false;
                break;
            }
        }
        if (found) {
            System.out.println("Book Not Found");
        }
    }
    static ArrayList<Book> num = new ArrayList<>();
    public static void main (String[] args) {
    }
}




