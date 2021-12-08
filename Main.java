public class Main {
    public static void main(String[] args) {
        Lectorarchivo Probar = new Lectorarchivo();
        String[][] Arreglo = Probar.comprobar("Prueba.txt");
        for(int x=0;x!=Arreglo.length;x++){
        System.out.println(Arreglo[x][0]+"->"+Arreglo[x][1]+","+Arreglo[x][2]+","+Arreglo[x][3]+","+Arreglo[x][4]);
        }
    }
    
}
