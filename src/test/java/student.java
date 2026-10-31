import java.util.ArrayList;
import java.util.Scanner;
class Student {
    int studentID;
    String name;
    String email;

    Student(int studentID, String name, String email) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
    }

    void Display_Students() {
        System.out.println("Student Id : " + studentID);
        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
    }

    static void Add_Student() {
        boolean found = false;
        System.out.print("Enter student id :");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        for(int i=0;i<details.size();i++){
            if(details.get(i).studentID==id){
                found =true;
            }
        }if(found){
            System.out.println("Student already exist");
            return ;
        }
        sc.nextLine();
        System.out.print("Enter name : ");
        String name = sc.nextLine();
        System.out.print("Enter email : ");
        String email = sc.nextLine();
        Student s = new Student(id, name, email);
        details.add(s);

    }

    static void Search_student() {
        boolean found = false;
        System.out.print("Enter student id :");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        for (int i = 0; i < details.size(); i++) {
            if (details.get(i).studentID == id) {
                details.get(i).Display_Students();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found");
        }
    }
    static void Delete_student(){
        boolean found = false;
        System.out.print("Enter student id :");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        for (int i = 0; i < details.size(); i++) {
            if (details.get(i).studentID == id) {
                details.remove(i);
                System.out.println("delete successful");
                found= true;
            }
        }if(!found){
            System.out.println("Student Not Found");
        }
    }static void Display_Student(){
        for (int i = 0; i < details.size(); i++) {
            details.get(i).Display_Students();
        }

    }

    static ArrayList<Student> details = new ArrayList<>();
    public static void main(String[] args) {

    }
}
