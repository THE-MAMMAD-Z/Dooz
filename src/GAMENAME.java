import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GAMENAME {


public void esmbazi(String game){

    File file = new File("C:\\Users\\ZAFERANI\\Desktop\\dooz\\" + game + ".txt");

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


}
