
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
    }

    static void Add_book() {
        System.out.print("Enter book id : ");
        Scanner sc = new Scanner(System.in);
        int book_id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter book title : ");
        String title = sc.nextLine();
        System.out.print("Enter author name : ");
        String author = sc.nextLine();
        Book b = new Book(book_id, title, author);
        num.add(b);

    }
   static boolean found ;
    static void serach (){
        found=false;
        System.out.print("Enter book id : ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        for( int i =0;i<num.size();i++){
            if(num.get(i).bookId==id) {
                num.get(i).Display_Details();
                found = true;
            }
        }if(!found){
            System.out.println("Book Not Found");
        }
    }

    static ArrayList<Book> num = new ArrayList<>();

    public static void main(String[] args) {

        Add_book();
        for(int i =0;i< num.size();i++) {
            num.get(i).Display_Details();
        }
            serach();




    }
}



