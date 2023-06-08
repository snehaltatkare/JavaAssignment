import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;

public class librarycsv {
    private static String filename = "library.csv";

    private static void writedatatocsv(){
       try(BufferedWriter wr= new BufferedWriter(new FileWriter(filename))){
        wr.write("Book ID,Book Title,Author,Availability,Issue Date");
        wr.newLine();
        wr.write("101,HTML and CSS,Jon Duckett,Available,Null");
        wr.newLine();
        wr.write("102,JavaScript: The Good Parts,Douglas C,Available,Null");
        wr.newLine();
        wr.write("103,Learning Web Design,Jennifer N,CP2014,23-May-2023");
        wr.newLine();
        wr.write("104,Responsive Web Design,Ben Frain,EC3142,17-May-2023");
        wr.newLine();
        
       }catch (Exception e){
        e.printStackTrace();
       }
    }
    private static void readdatafromcsv() {
        try (BufferedReader re = new BufferedReader(new FileReader(filename))) {
            String line;
            re.readLine();
            while ((line = re.readLine()) != null) {
                String[] data = line.split(",");
                int Bookid = Integer.parseInt(data[0]);
                String BookTitle = data[1];
                String Author = data[2];
                String Avail = data[3];
                String Issuedate = data[4];
                
    
      System.out.println(" Book ID: " + Bookid + " Book Title: " + BookTitle + " Author: "+Author + "Availability:"+Avail+ "Issue Date:"+Issuedate);
        
                
               

            }
        } catch (Exception e) {
            System.err.println();
        }
    }
    public static void main(String[] args) {
    // writedatatocsv(); 
    readdatafromcsv();

    }
    
}

