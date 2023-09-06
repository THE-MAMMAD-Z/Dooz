import java.io.*;
import java.util.Scanner;

public class SCOREBOARD  {

    File file = new File("C:\\Users\\pc\\Desktop\\scoreboard\\scoreboard.txt");


    public void showjadval(){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line = bufferedReader.readLine();

            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void addjadval(String esm , int bord) throws FileNotFoundException {

        boolean gj = true ;
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();
            if(lineFromFile.contains(esm)) {
                gj = false ;
                break;
            }
        }

        if(gj==true) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))) {
                bufferedWriter.write(esm + "=======" + bord);
                bufferedWriter.newLine();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

            //String[] spell = esm.split("=======");

            try {
                Scanner sc = new Scanner(file);
                StringBuffer buffer = new StringBuffer();
                while (sc.hasNextLine()) {
                    buffer.append(sc.nextLine()+System.lineSeparator());
                }
                String fileContents = buffer.toString();
                //System.out.println("Contents of the file: "+fileContents);
                sc.close();
               // int bb = Integer.parseInt(spell[1]);
                String oldLine = esm + "=======" + 1 ;
                String newLine = esm + "=======" + 2 ;
                fileContents = fileContents.replaceAll(oldLine, newLine);
                FileWriter writer = new FileWriter(file);
                //System.out.println("");
                //System.out.println("new data: "+fileContents);
                writer.write(fileContents);
                writer.flush();
            }

            catch (IOException e){
                System.out.println(e.getMessage());
            }

        }

    }

}
