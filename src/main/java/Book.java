
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Book {

    int bookId;
    String title;
    String author;
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
        System.out.println();
    }

    static void Add_book() {
        System.out.print("Enter book id : ");
        Scanner sc = new Scanner(System.in);
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

    }

    static boolean found;

    static void serach() {
        found = false;
        System.out.print("Enter book id : ");
        Scanner sc = new Scanner(System.in);
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

        System.out.print("Enter book id: ");
        Scanner sc = new Scanner(System.in);
        int bookid = sc.nextInt();

        for (int i = 0; i < num.size(); i++) {
            if (num.get(i).bookId == bookid) {
                found = true;

                if (num.get(i).available) {
                    num.get(i).available = false;
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
                found = false;

                if(num.get(i).available==false){
                    num.get(i).available=true;
                    System.out.println("Book return successfully!");
                }else{
                    System.out.println("Book not issue");
                }
            }
        }if(found){
            System.out.println("Book not found ");
        }
    }


    static ArrayList<Book> num = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("==================== LIBRARY MANAGEMENT SYSTEM ====================");
            System.out.println("1.Add Book ");
            System.out.println("2.Display Book ");
            System.out.println("3.Search Book ");
            System.out.println("4.issue Book ");
            System.out.println("5.Return Book ");
            System.out.println("6.Exit");
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
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}



