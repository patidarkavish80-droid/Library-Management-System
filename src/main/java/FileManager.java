import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
   public  static void loadBooks() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] data = line.split(",");
                if (data.length < 4) {
                    continue;
                }

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                boolean availability = Boolean.parseBoolean(data[3]);
                String studentid = "";

                if (data.length >= 5) {
                    studentid = data[4];
                }

                Book b = new Book(id, title, author);
                b.available = availability;
                if (!studentid.isEmpty()) {
                    for (int j = 0; j < Student.details.size(); j++) {
                        if (Student.details.get(j).studentID.equals(studentid)) {
                            b.issuedToStudent = Student.details.get(j);
                            break;
                        }
                    }
                }
                Book.num.add(b);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error loading books!");
        }
    }public static void saveBooks() {
        try {
            FileWriter f = new FileWriter("books.txt");
            for(int i=0;i<Book.num.size();i++) {
                String studentid="";
                if(Book.num.get(i).issuedToStudent!=null){
                    studentid=Book.num.get(i).issuedToStudent.studentID;
                }
                f.write(Book.num.get(i).bookId+","+Book.num.get(i).title+","+Book.num.get(i).author+","+Book.num.get(i).available+","+studentid+"\n");
            }
            f.close();
        } catch (Exception e) {
            System.out.println("Error saving book!");
        }
    }
}
