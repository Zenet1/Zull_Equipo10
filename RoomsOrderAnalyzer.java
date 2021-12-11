
public class RoomsOrderAnalyzer {
    private String[] KeysArray;
    private String[][] RoomsArray;
    private int Index;

    public RoomsOrderAnalyzer(String[] KeysArray, String[][] RoomsArray) {
        this.KeysArray = KeysArray;
        this.RoomsArray = RoomsArray;
    }

    public boolean findExistentRoom(String room, boolean exist) {
        for (int Index2 = 0; Index2 != KeysArray.length; Index2++) {
            if (room.equalsIgnoreCase(RoomsArray[Index2][0]) || room.equalsIgnoreCase("null")) {
                exist = true;
            }
        }
        if (exist == false) {
            System.out.println("No todas los cuartos han sido definidos, en este caso " + room);
            return false;
        }
        return true;
    }

    public boolean allRoomsHaveExits() {
        for (Index = 0; Index != KeysArray.length; Index++) {
            for (int y = 1; y != 5; y++) {
                if (findExistentRoom(RoomsArray[Index][y], false) == false) {
                    return false;

                }
            }

        }
        return true;
    }

    public boolean roomsTogether(int Index2, boolean exist, String room, String roombound) {
        for (int z = 0; z != KeysArray.length; z++) {
            if (room.equalsIgnoreCase(RoomsArray[z][0])) {
                switch (Index2) {
                    case 1:
                        if (roombound.equalsIgnoreCase(RoomsArray[z][2])) {
                            exist = true;
                            break;
                        }
                    case 2:
                        if (roombound.equalsIgnoreCase(RoomsArray[z][1])) {
                            exist = true;
                            break;
                        }
                    case 3:
                        if (roombound.equalsIgnoreCase(RoomsArray[z][4])) {
                            exist = true;
                            break;
                        }
                    case 4:
                        if (roombound.equalsIgnoreCase(RoomsArray[z][3])) {
                            exist = true;
                            break;
                        }
                }
            }
        }
        if (exist == false) {
            System.out.println(
                    "Algunos cuartos no están bien ordenados sus adyacentes, en este caso los cuartos "
                            + RoomsArray[Index][Index2] + " y " + RoomsArray[Index][0]);
            return false;
        }
        return true;
    }

    public boolean coordinatedExits() {
        for (Index = 0; Index != KeysArray.length; Index++) {
            for (int Index2 = 1; Index2 != 5; Index2++) {
                if (RoomsArray[Index][Index2].equalsIgnoreCase("null")) {
                } else {
                    if (roomsTogether(Index2, false, RoomsArray[Index][Index2],
                            RoomsArray[Index][0]) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean Analyze() {
        if (allRoomsHaveExits() && coordinatedExits()) {
            return true;
        }
        return false;
    }
}
