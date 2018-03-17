package javaprac;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample1 {

    private static final String FILENAME = "/Users/mayurkadu/IdeaProjects/Test/src/javaprac/test.txt";

    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }//end finally

        try {
            try(BufferedReader br1 = new BufferedReader(new FileReader(FILENAME))){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
