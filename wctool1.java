import java.io.FileReader;
import java.io.IOException;

public class wctool1 {

    public static void main(String[] args) {
        int arguments = args.length;

        if (arguments == 0) {
            System.out.println("Enter Arguments.");
            return;
        }

        try{
            FileStats file = new FileStats(args[arguments == 1 ? 0 : 1]);

            if (arguments == 1) {
                System.out.println(file.getSize() + " " + file.getLines() + " " + file.getWords() + " " + args[0]);
            } else {
            switch (args[0]) {  
                case "-w":
                    System.out.println(file.getWords() + " " + args[1]);
                    break;
                case "-l":
                    System.out.println(file.getLines() + " " + args[1]);
                    break;
                case "-c":
                    System.out.println(file.getSize() + " " + args[1]);
                    break;
                default:
                    System.out.println("Unexpected option: " + args[0]);
                    break;
                }   
            } 
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }   catch (Exception e){
            System.out.println("Error " +e.getMessage());
        }
    }        

}

class FileStats{

    String fr;
    FileReader file;
    FileStats(String fr) throws Exception {
        this.fr = fr;
        try{
            this.file = new FileReader(fr);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    
    int getLines () throws Exception{
        int i,count=0;
        while((i=file.read())!=-1){
            if ((char)i=='\n') 
                count++;
            }
        return count;
    }
    
    int getWords () throws Exception{
        int i,count=0;
        while((i=file.read())!=-1){
            if ((char)i==' ') 
                count++;
            }
        return count;
    }
    
    int getSize() {
        return (int) new java.io.File(fr).length();
    }

}
