package Src;

import java.io.File;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ReadFile {
    public String[] getJsonKeys(JSONObject jsonObject) {
        String Keys = (jsonObject.keySet()).toString();
        Keys = Keys.replace(" ", "");
        Keys = Keys.replace("[", "");
        Keys = Keys.replace("]", "");
        String[] KeysArray = Keys.split(",");
        return KeysArray;
    }

    public String[] generateAdjacentRoomsArrrangement(JSONObject jsonObject, String[] KeysArray, int index) {
        String AdjacentRooms = jsonObject.get(KeysArray[index]).toString();
        AdjacentRooms = AdjacentRooms.replace("[", "");
        AdjacentRooms = AdjacentRooms.replace("]", "");
        AdjacentRooms = AdjacentRooms.replace('"', ' ');
        AdjacentRooms = AdjacentRooms.replace(" ", "");
        String[] AdjacentRoomsArray = AdjacentRooms.split(",");
        return AdjacentRoomsArray;
    }

    public String[][] setRoomArragment(String[] KeysArray, JSONObject jsonObject, String[][] RoomsArray) {
        int index = 0;
        String[] AdjacentRoomsArray;
        try {
            for (index = 0; index != KeysArray.length; index++) {
                AdjacentRoomsArray = generateAdjacentRoomsArrrangement(jsonObject, KeysArray, index);
                RoomsArray[index][0] = KeysArray[index];
                for (int column = 1; column != 5; column++) {
                    RoomsArray[index][column] = AdjacentRoomsArray[column - 1];
                }
            }
            return RoomsArray;
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("El cuarto " + RoomsArray[index][0]
                    + " no tiene bien definido sus 4 cuartos adyacentes, verificalo y vuelve a correr");
            System.exit(0);
        }
        return RoomsArray;
    }

    public JSONObject getJsonProperities(String Doc) {
        JSONObject jsonObject = null;
        try {
            JSONParser parser = new JSONParser();
            Object ObjectToAnalyze = parser.parse(new FileReader(Doc));
            jsonObject = (JSONObject) ObjectToAnalyze;
        } catch (Exception e) {
            System.out.println("El archivo JSON no está en el formato correcto");
            System.exit(0);
        }
        return jsonObject;

    }

    public boolean docExist(String DocToRead) {
        File archivo = new File(DocToRead);
        if (!archivo.exists()) {
            System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
            return false;
        }
        return true;
    }

    public String[][] getArrayRooms(String DocToRead) {
        docExist(DocToRead);
        JSONObject jsonObject = getJsonProperities(DocToRead);
        String[] KeysArrangement = getJsonKeys(jsonObject);
        String[][] RoomsArrangement = new String[KeysArrangement.length][5];
        RoomsArrangement = setRoomArragment(KeysArrangement, jsonObject, RoomsArrangement);
        RoomsOrderAnalyzer Analyzer = new RoomsOrderAnalyzer(KeysArrangement, RoomsArrangement);
        if (Analyzer.Analyze() == false) {
            System.exit(0);
        }
        return (RoomsArrangement);
    }
}
