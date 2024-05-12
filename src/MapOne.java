import enigma.console.Console;

public class MapOne implements MapOneInterface {
    // MapOne sınıfının işlevleri buraya eklenecek

    public static enigma.console.Console cn;
    public static void MapOne(Console cn) {
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 120; j++) {
                cn.getTextWindow().output(j, i, ' ');
            }
            System.out.println();
        }



    }
}
