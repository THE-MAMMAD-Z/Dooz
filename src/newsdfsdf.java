import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class newsdfsdf {


    public static void svegame(String playername , ArrayList<String> adad, int sit) throws IOException {


        int size = file.length();
        String klo = "";
        int mot = file.indexOf(".");

        for(int i=mot ; i<size ; i++) {
            klo += file.charAt(i);
        }

        if((klo.equals(".txt"))){
            FileWriter benevis = new FileWriter(file);


//            for(String hop : numbers){
//                benevis.write(hop+System.lineSeparator());
//            }


            benevis.close();
        }else{
            System.out.println("EROR DAD");
        }
    }

}
