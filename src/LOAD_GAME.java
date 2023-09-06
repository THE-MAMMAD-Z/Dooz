import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LOAD_GAME {

    String[] savegame ;
    String sname ;

    public String[] getSavegame() {
        return savegame;
    }

    public String getSname() {
        return sname;
    }

    public ArrayList<String> loadgame(String file){

        String number ;
        ArrayList numbers = new ArrayList<>();

        try{
            BufferedReader behkon = new BufferedReader(new FileReader(file));
            String line;

            while((line = behkon.readLine()) != null){
                numbers.add(line);
                //numbers = behkon.readLine();
            }
            this.sname = file;

        }catch (FileNotFoundException e) {
            System.out.println("file peyda nashod");;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numbers ;

    }

}
