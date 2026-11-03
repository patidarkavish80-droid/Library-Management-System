import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
class Student {
    String studentID;
    String name;
    String email;

    Student(String studentID, String name, String email) {
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
        String id = sc.nextLine();
        for(int i=0;i<details.size();i++){
            if(details.get(i).studentID.equals(id)){
                found =true;
                }
            }if(found){
            System.out.println("Student already exist");
            return ;
        }
        System.out.print("Enter name : ");
        String name = sc.nextLine();
        System.out.print("Enter email : ");
        String email = sc.nextLine();
        Student s = new Student(id, name, email);
        details.add(s);
        try{FileWriter w = new FileWriter("student.txt",true);
            w.write(s.studentID+";"+s.name+";"+s.email+"\n");
            w.close();
            System.out.println("Student add successful");
        } catch (IOException e) {
            System.out.println("Error saving book");
        }

    }

    static void Search_student() {
        boolean found = false;
        System.out.print("Enter student id :");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        for (int i = 0; i < details.size(); i++) {
            if (details.get(i).studentID.equals( id)) {
                details.get(i).Display_Students();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found");
            return;
        }
    }
    static void Delete_student(){
        boolean found = false;
        System.out.print("Enter student id :");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        for (int i = 0; i < details.size(); i++) {
            if (details.get(i).studentID.equals(id)) {
                details.remove(i);
                System.out.println("delete successful");
                found= true;
                break;
            }
        }if(!found){
            System.out.println("Student Not Found");
        }
    }static void Display_Student(){
        for (int i = 0; i < details.size(); i++) {
            details.get(i).Display_Students();
        }

    }static void loading(){
      try {
          BufferedReader bf = new BufferedReader(new FileReader("student.txt"));
          String line;
          while ((line = bf.readLine())!=null) {

              if (line.isBlank()) {
                  continue;
              }
              String[] data = line.split(";");
              String Studentid =data[0];
              String name = data[1];
              String email = data[2];

              Student s = new Student(Studentid, name, email);
              details.add(s);
          }
          bf.close();
      }catch (IOException e){
          System.out.println("Error loading ");
      }


    }

    static ArrayList<Student> details = new ArrayList<>();
    public static void main(String[] args) throws IOException {





    }
}
