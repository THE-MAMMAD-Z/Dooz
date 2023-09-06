import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


class asli{
    public static void main(String[] args) throws IOException {
        bazi BAZI = new bazi();
        BAZI.GAME();
    }

}


public class bazi {

    SCOREBOARD scoreboard = new SCOREBOARD();
    public bazi() {
    }

    String p1 ; String p2;
        String sname ;
        String[] savegame ;
        ArrayList maingame = new ArrayList<>();


         /*try {

            FileWriter neveshtan = new FileWriter(file,true);
            String matn = "saberere kale sexi";
            neveshtan.write(matn);
            neveshtan.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*try{
            FileReader khondan = new FileReader(poshe);
            int ch = khondan.read();
            int i = 0 ;

            while(i != 0){
                System.out.println((char)ch);
                khondan.read();
                i++;

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(poshe))) {

            String line = bufferedReader.readLine();

            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/





    public void GAME() throws IOException {

        LOAD_GAME lGame = new LOAD_GAME();
        SAVE_GAME sGmae = new SAVE_GAME();
        HISTORY history = new HISTORY();
        SCOREBOARD scoreboard1 = new SCOREBOARD();
        String[] nit = new String[10];
        nit[1] = " "; nit[2] = " ";nit[3] = " ";nit[4] = " ";nit[5] = " ";nit[6] = " ";nit[7] = " ";
        nit[8] = " ";nit[9] = " ";

        Scanner fg = new Scanner(System.in);

        boolean opp = true ;
        while(opp){
            System.out.println("chikar konim ?  ");
            Scanner v = new Scanner(System.in);
            String vorodi = v.nextLine();
            String[] spell = vorodi.split(" ");
            int tt = spell.length;

            if(tt!=3 && tt!=2 && tt!=1){
                System.out.println("tedad input kam ya ziad ast");

        }else if(Objects.equals(spell[0],"/start")   || Objects.equals(spell[0],"/load")  ){
                int dor = 1 ;

                boolean gstart = true;

                ArrayList<String> player1 = new ArrayList<>();
                ArrayList<String> player2 = new ArrayList<>();
                String savename = "";

                if(Objects.equals(spell[0],"/load")  ){
                    //maingame = this.loadgame(spell[1] + ".txt");
                    maingame = lGame.loadgame(spell[1] + ".txt");

                    if(maingame.size() == 0){
                        System.out.println("in bazi vojod nadarad");
                        gstart = false ;
                    }
                    else if(Objects.equals(maingame.get(maingame.size() - 1),"payan")){
                        System.out.println("bazi be etmam reside ast:)");
                        gstart = false ;

                    }else {
                        savename = spell[0] ;
                        savename += ".txt";
                        dor = maingame.size() -1 ;

                        for(int i=0 ; i<dor ;i++){
                            ///////
                            if(i%2 == 0){/////////////
                                player1.add(String.valueOf(maingame.get(i)));
                            }else{
                                player2.add(String.valueOf(maingame.get(i)));
                            }
                        }
                    }

                    }else{

                    maingame = new ArrayList<>();
                    p1 = spell[1];
                    p2 = spell[2];
                    savename = "";
                  //  String GAMENAME = DateTimeFormatter.ofPattern("yyyy-mm-dd HH-mm-ss").format(LocalDateTime.now());
                  //  GAMENAME = GAMENAME.replace(' ','-');
                    String GAMENAME = spell[1] + "--VS--" + spell[2] ;
                    savename += GAMENAME + ".txt";
                    this.sname = savename ;
                    //this.savegame(maingame,this.sname);
                    SAVE_GAME.savegame(maingame,this.sname);
                }

                while(gstart){

                    String currennt ;

                    if(dor%2 == 0){
                        currennt = p2 ;
                    }else{
                        currennt = p1 ;
                    }
                    System.out.println("nobat " + currennt);


                String xvb = fg.nextLine();
                String[] qw = xvb.split(" ");

                if((Objects.equals(qw[0],"/put"))&&(qw[1]!=null)&&(qw[1].length() == 1 )){
                    String answer = qw[1];

                    if((!answer.equals("1")) && (!answer.equals("2")) && (!answer.equals("3")) && (!answer.equals("4")) && (!answer.equals("5")) && (!answer.equals("6")) && (!answer.equals("7")) && (!answer.equals("8")) && (!answer.equals("9")) ){
                        System.out.println("wrong number");
                    }
                    else if(maingame.contains(qw[1])){
                        System.out.println("tekrari vared kardi");
                    }else{
                        maingame.add(answer);
                        if(maingame.size() %2 != 0){ ////////
                            player1.add(answer);
                            nit[Integer.parseInt(answer)]= "0";
                        }else{
                            player2.add(answer);
                            nit[Integer.parseInt(answer)]= "$";
                        }


                        System.out.println(" "+nit[7]+" | "+nit[8]+" | "+ nit[9]+" " +"\n"+"___|___|___" + "\n"
                                + " "+nit[4] + " | "+ nit[5] +" | "+nit[6] +" "+"\n"
                                + "___|___|___"+"\n" + " "+nit[1] + " | "+ nit[2] +" | "+nit[3] +" "+"\n"+"   |   |"   );


                        if(
                           ((player1.contains("1")) && (player1.contains("7")) && (player1.contains("4"))) || ((player1.contains("1")) && (player1.contains("2")) && (player1.contains("3"))) || ((player1.contains("4")) && (player1.contains("7")) && (player1.contains("1"))) || ((player1.contains("5")) && (player1.contains("8")) && (player1.contains("2"))) || ((player1.contains("5")) && (player1.contains("7")) && (player1.contains("3"))) || ((player1.contains("6")) && (player1.contains("3")) && (player1.contains("9"))) || ((player1.contains("5")) && (player1.contains("6")) && (player1.contains("4"))) || ((player1.contains("7")) && (player1.contains("8")) && (player1.contains("9"))) ){
                            System.out.println(p1 + " bord");
                            maingame.add("payan");
                           // this.savegame(maingame,this.sname);
                            SAVE_GAME.savegame(maingame,this.sname);
                            history.addhistory(spell[1],maingame,1);
                            history.addhistory(spell[2],maingame,2);
                            scoreboard.addjadval(spell[1],1);
                            gstart = false ;

                        }else if(
                                ((player2.contains("1")) && (player2.contains("7")) && (player2.contains("4"))) || ((player2.contains("1")) && (player2.contains("2")) && (player2.contains("3"))) || ((player2.contains("4")) && (player2.contains("7")) && (player2.contains("1"))) || ((player2.contains("5")) && (player2.contains("8")) && (player2.contains("2"))) || ((player2.contains("5")) && (player2.contains("7")) && (player2.contains("3"))) || ((player2.contains("6")) && (player2.contains("3")) && (player2.contains("9"))) || ((player2.contains("5")) && (player2.contains("6")) && (player2.contains("4"))) || ((player2.contains("7")) && (player2.contains("8")) && (player2.contains("9"))) ){

                            System.out.println(p2 + " bord");
                            maingame.add("payan");
                           // this.savegame(maingame,this.sname);
                            SAVE_GAME.savegame(maingame,this.sname);
                            history.addhistory(spell[2],maingame,1);
                            history.addhistory(spell[1],maingame,2);
                            scoreboard.addjadval(spell[2],1);
                            gstart = false ;

                        }else if(maingame.size() == 9){
                            System.out.println("mosavi");
                            maingame.add("payan");
                            //this.savegame(maingame,this.sname);
                            SAVE_GAME.savegame(maingame,this.sname);
                            history.addhistory(spell[1],maingame,3);
                            history.addhistory(spell[2],maingame,3);
                            gstart = false ;
                        }
                        else{
                            System.out.println("nafar bad");
                            dor++;
                        }

                    }

                }else if(Objects.equals(qw[0],"/save")  ){

                   // this.savegame(maingame,this.sname);
                    SAVE_GAME.savegame(maingame,this.sname);
                    System.out.println("bazi save shod");
                    System.out.println(this.sname);
                    gstart = false ;

                }else{
                    System.out.println("eshtebah zadi");
                }


                }

                }else if(Objects.equals(spell[0],"/exit")){
                opp = false ;
            }else if(Objects.equals(spell[0],"/scoreboard")){
                 scoreboard.showjadval();
            }else if (Objects.equals(spell[0],"/history")){

                String ozv = "C:\\Users\\pc\\Desktop\\history\\" + spell[1] +".txt";
                File poshe = new File(ozv);

                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(poshe))) {

                    String line = bufferedReader.readLine();

                    while(line != null){
                        System.out.println(line);
                        line = bufferedReader.readLine();
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }else if (Objects.equals(spell[0],"/replay")){



                String ozv = "C:\\Users\\pc\\Desktop\\programs\\dooz\\" + spell[1] + ".txt";
                File poshe = new File(ozv);

                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(poshe))) {

                    String line = bufferedReader.readLine();

                    while(line != null){
                        System.out.println(line);
                        line = bufferedReader.readLine();
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }



            }else{
                System.out.println("nadarim hamchin chizi");
            }
            }
    }
    }




