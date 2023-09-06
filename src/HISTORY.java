import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HISTORY {


         void findfile(String name, File file) {
           String S = null;
            File[] list = file.listFiles();
            if(list!=null)
                for (File fil : list) {
                    if (fil.isDirectory()) {
                        findfile(name,fil);
                        S = "false";
                    }
                    else if (name.equalsIgnoreCase(fil.getName())) {
                        S = "true" ;
                    }
                }
             System.out.println(S); ;
        }

/*public String history(String plrname) throws FileNotFoundException {


    File file = new File("C:\\Users\\ZAFERANI\\Desktop\\dooz");
    boolean gj = true ;
//    final Scanner scanner = new Scanner(file);
//    while (scanner.hasNextLine()) {
//        final String lineFromFile = scanner.nextLine();
//        if(lineFromFile.contains(plrname)) {
//            gj = false ;
//            break;
//        }
//    }

    if(HISTORY.findfile(plrname,file)==true){


        for(int i=0 ; i<10 ; i++){


            File fie = new File("C:\\Users\\ZAFERANI\\Desktop\\dooz" + plrname );


        }



    }else{

    }

    return "file";
}*/


    public void addhistory(String playername , ArrayList<String> adad,int sit) throws IOException {
//        File file = new File("C:\\Users\\ZAFERANI\\Desktop\\history");
//     if((HISTORY.findfile(playername + ".txt",file)) == true ){
         File filee = new File("C:\\Users\\pc\\Desktop\\history\\"+playername + ".txt");



         try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filee,true))){
             for (String s : adad) {
                 bufferedWriter.write(s);
                 bufferedWriter.newLine();

             }
             bufferedWriter.newLine();

             if(sit==1){
                 bufferedWriter.write("victory");
                 bufferedWriter.newLine();
             }else if(sit==2){
                 bufferedWriter.write("lost");
                 bufferedWriter.newLine();
             }else{
                 bufferedWriter.write("draw");
                 bufferedWriter.newLine();
             }

bufferedWriter.write("====================");
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

//}else{



     }

    public static void svegame(String file , ArrayList<String> adad,int sit) throws IOException {


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
            for (String s : adad) {
                benevis.write(s);
                benevis.write("\n");
            }
            if(sit==1){
                benevis.write("victory");
                benevis.write("\n");
            }else if(sit==2){
                benevis.write("lost");
                benevis.write("\n");
            }else{
                benevis.write("draw");
                benevis.write("\n");
            }
            benevis.close();
        }else{
            System.out.println("EROR DAD");
        }
    }


    }






