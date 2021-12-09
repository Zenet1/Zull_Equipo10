import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Lectorarchivo {

    public String[][] comprobar(String DocumentoALeer) {
        ArrayList<String> jsonArr = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(DocumentoALeer));
            JSONObject jsonObject = (JSONObject) obj;
            String[] a = (((((jsonObject.keySet()).toString()).replace(" ", "")).replace("[", "")).replace("]", ""))
                    .split(",");
            String[][] arreglo = new String[a.length][5];
            for (int x = 0; x != a.length; x++) {
                arreglo[x][0] = a[x];
                String[] parts = (((((jsonObject.get(a[x]).toString()).replace("[", "")).replace("]", "").replace('"',
                        ' ')).replace(" ", ""))).split(",");
                arreglo[x][1] = parts[0];
                arreglo[x][2] = parts[1];
                arreglo[x][3] = parts[2];
                arreglo[x][4] = parts[3];
            }
            return (arreglo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
