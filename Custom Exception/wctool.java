import java.io.FileReader;
import java.io.IOException;

public class wctool {

    public static void main(String[] args) {
        int arguments = args.length;

        try{      

            if (arguments == 0)  {
                throw new NoArgumentsException("No arguments provided. Please provide Argument: ");
            }
        
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

        } catch (NoArgumentsException e){
            System.out.println("Custom Error; " +e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error " +e.getMessage());
        }
    }        

    static class NoArgumentsException extends Exception {
        public NoArgumentsException(String message) {
            super(message);
        }
    }

}

class FileStats{

    private String fr;
    private FileReader file;
    
    public FileStats(String fr) throws IOException {
        this.fr = fr;
        this.file = new FileReader(fr);
    }

    
    public int getLines() throws IOException{
        int i,count=0;
        while((i = file.read()) != -1){
            if ((char)i == '\n') 
                count++;
            }
        return count;
    }
    
    public int getWords () throws IOException{
        int i,count=0;
        while((i=file.read())!=-1){
            if ((char)i == ' ') 
                count++;
            }
        return count;
    }

    public int getSize() {
        return (int) new java.io.File(fr).length();
    }
}