import java.io.FileReader;
import java.io.IOException;

public class wctool1 {

    public static void main(String[] args) {
        int arguments = args.length;

        if (arguments == 0) {
            System.out.println("Enter Arguments.");
            return;
        }

        if (arguments == 1) {
            try {
                FileStats file = new FileStats(args[0]);
                System.out.println(file.getSize() + " " + file.getLines() + " " + file.getWords() + " " + args[0]);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
            return;
        }

        try {
            FileStats file = new FileStats(args[1]);

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
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}


class File{

    String fr;
    FileReader file;
    File(String fr) throws Exception {
        this.fr = fr;
        try{
            this.file = new FileReader(fr);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    
    int lines () throws Exception{
        int i,count=0;
        while((i=file.read())!=-1){
            if ((char)i=='\n') 
                count++;
            }
        return count;
    }
    
    int words () throws Exception{
        int i,count=0;
        while((i=file.read())!=-1){
            if ((char)i==' ') 
                count++;
            }
        return count;
    }
    
    int size() {
        return (int) new java.io.File(fr).length();
    }

}
