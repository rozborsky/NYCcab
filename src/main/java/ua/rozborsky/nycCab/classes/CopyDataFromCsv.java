package ua.rozborsky.nycCab.classes;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by roman on 18.03.2017.
 */

@Component
public class CopyDataFromCsv {
    public void make(String sourceFileName, String destinationFileName, int rows) {
        try(BufferedReader br = new BufferedReader(new FileReader( sourceFileName ));
            PrintWriter pw =  new PrintWriter(new FileWriter( destinationFileName ))) {

            String line;
            while (((line = br.readLine()) != null) && rows != 0) {
                pw.println(line);
                rows--;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
