
public class RoomsOrderAnalyzer {
    private String[] KeysArrangement;
    private String[][] RoomsArrangement;
    private int Index;

    public RoomsOrderAnalyzer(String[] KeysArrangement, String[][] RoomsArrangement) {
        this.KeysArrangement = KeysArrangement;
        this.RoomsArrangement = RoomsArrangement;
    }

    public boolean FindExistentRoom(String room, boolean exist) {
        for (int Index2 = 0; Index2 != KeysArrangement.length; Index2++) {
            if (room.equalsIgnoreCase(RoomsArrangement[Index2][0]) || room.equalsIgnoreCase("null")) {
                exist = true;
            }
        }
        if (exist == false) {
            System.out.println("No todas los cuartos han sido definidos, en este caso " + room);
            return false;
        }
        return true;
    }

    public boolean AllRoomsHaveExits() {
        for (Index = 0; Index != KeysArrangement.length; Index++) {
            for (int y = 1; y != 5; y++) {
                if (FindExistentRoom(RoomsArrangement[Index][y], false) == false) {
                    return false;

                }
            }

        }
        return true;
    }

    public boolean RoomsTogether(int Index2, boolean exist, String room, String roombound) {
        for (int z = 0; z != KeysArrangement.length; z++) {
            if (room.equalsIgnoreCase(RoomsArrangement[z][0])) {
                switch (Index2) {
                    case 1:
                        if (roombound.equalsIgnoreCase(RoomsArrangement[z][2])) {
                            exist = true;
                            break;
                        }
                    case 2:
                        if (roombound.equalsIgnoreCase(RoomsArrangement[z][1])) {
                            exist = true;
                            break;
                        }
                    case 3:
                        if (roombound.equalsIgnoreCase(RoomsArrangement[z][4])) {
                            exist = true;
                            break;
                        }
                    case 4:
                        if (roombound.equalsIgnoreCase(RoomsArrangement[z][3])) {
                            exist = true;
                            break;
                        }
                }
            }
        }
        if (exist == false) {
            System.out.println(
                    "Algunos cuartos no están bien ordenados sus adyacentes, en este caso los cuartos "
                            + RoomsArrangement[Index][Index2] + " y " + RoomsArrangement[Index][0]);
            return false;
        }
        return true;
    }

    public boolean CoordinatedExits() {
        for (Index = 0; Index != KeysArrangement.length; Index++) {
            for (int Index2 = 1; Index2 != 5; Index2++) {
                if (RoomsArrangement[Index][Index2].equalsIgnoreCase("null")) {
                } else {
                    if (RoomsTogether(Index2, false, RoomsArrangement[Index][Index2],
                            RoomsArrangement[Index][0]) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean Analyze() {
        if (AllRoomsHaveExits() && CoordinatedExits()) {
            return true;
        }
        return false;
    }
}
