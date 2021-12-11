import java.io.File;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Lectorarchivo {

    public String[] GetJsonKeys(JSONObject jsonObject) {
        String Keys = (jsonObject.keySet()).toString();
        Keys = Keys.replace(" ", "");
        Keys = Keys.replace("[", "");
        Keys = Keys.replace("]", "");
        String[] KeysArrangement = Keys.split(",");
        return KeysArrangement;
    }

    public String[] GenerateAdjacentRoomsArrrangement(JSONObject jsonObject, String[] KeysArrangement, int index) {
        String AdjacentRooms = jsonObject.get(KeysArrangement[index]).toString();
        AdjacentRooms = AdjacentRooms.replace("[", "");
        AdjacentRooms = AdjacentRooms.replace("]", "");
        AdjacentRooms = AdjacentRooms.replace('"', ' ');
        AdjacentRooms = AdjacentRooms.replace(" ", "");
        String[] AdjacentRoomsArrangement = AdjacentRooms.split(",");
        return AdjacentRoomsArrangement;
    }

    public String[][] setRoomArragment(String[] KeysArrangement, JSONObject jsonObject, String[][] RoomsArrangement) {
        int index = 0;
        String[] AdjacentRoomsArrangement;
        try {
            for (index = 0; index != KeysArrangement.length; index++) {
                AdjacentRoomsArrangement = GenerateAdjacentRoomsArrrangement(jsonObject, KeysArrangement, index);
                RoomsArrangement[index][0] = KeysArrangement[index];
                for (int column = 1; column != 5; column++) {
                    RoomsArrangement[index][column] = AdjacentRoomsArrangement[column - 1];
                }
            }
            return RoomsArrangement;
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("El cuarto " + RoomsArrangement[index][0]
                    + " no tiene bien definido sus 4 cuartos adyacentes, verificalo y vuelve a correr");
            System.exit(0);
        }
        return RoomsArrangement;
    }

    public JSONObject GetJsonProperities(String Doc) {
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

    public boolean DocExist(String DocumentoALeer) {
        File archivo = new File(DocumentoALeer);
        if (!archivo.exists()) {
            System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
            return false;
        }
        return true;
    }

    public String[][] comprobar(String DocumentoALeer) {
        DocExist(DocumentoALeer);
        JSONObject jsonObject = GetJsonProperities(DocumentoALeer);
        String[] KeysArrangement = GetJsonKeys(jsonObject);
        String[][] RoomsArrangement = new String[KeysArrangement.length][5];
        RoomsArrangement = setRoomArragment(KeysArrangement, jsonObject, RoomsArrangement);
        RoomsOrderAnalyzer Analyzer = new RoomsOrderAnalyzer(KeysArrangement, RoomsArrangement);
        if (Analyzer.Analyze() == false) {
            System.exit(0);
        }
        return (RoomsArrangement);
    }

}
