import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.awt.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.awt.event.KeyListener;

public class ScoreTable {

    public static enigma.console.Console cn = Enigma.getConsole("HIGH SCORE", 120, 28, 20);

    public ScoreTable(int end, int score) throws IOException, InterruptedException {
        consoleClear(cn);
        drawSquare();
        Sort(end, score);

    }


    public void consoleClear(Console cn) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 120; j++) {
                cn.getTextWindow().output(j, i, ' ');
            }
            System.out.println();
        }
    }

    public void Sort(int end, int score) throws IOException, InterruptedException {
        String filePath = "/Users/sudenurkomur/Desktop/percyAdventure/Percy_Adventure/Adsız/Percy_Adventure/src/players.txt";

        File dosya = new File(filePath);
        Scanner sr = new Scanner(dosya);
        int lineCount = 0;
        while (sr.hasNextLine()) {
            String satir = sr.nextLine();
            lineCount++;
        }
        TextAttributes orange = new TextAttributes(Color.orange);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int[] id = new int[lineCount]; // ID'leri saklamak için bir dizi oluşturuyoruz
            String[] name = new String [lineCount];
            String[] surname= new String[lineCount];
            int i = 0;
            int studentId;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if(i != 0) {
                    name[i] = parts[0].trim(); //İsim
                    surname[i] = parts[1].trim(); // Soyisim
                    studentId  = Integer.parseInt(parts[2].trim()); // ID
                    id[i] = studentId;
                }
                i++;
            }
            System.out.println();
            // InsertionSort sınıfını kullanarak ID'leri sırala
            int[] numbers =new int[id.length-1];
            for(int m=1;m<id.length;m++) {
                numbers[m-1]=id[m];
            }
            String[] name_new =new String[id.length-1];
            for(int m=1;m<id.length;m++) {
                name_new[m-1]=name[m];
            }
            String[] surname_new =new String[id.length-1];
            for(int m=1;m<id.length;m++) {
                surname_new[m-1]=surname[m];
            }

            if (end == 0) { // high score basıldıysa direk
                InsertionSort compare = new InsertionSort();
                compare.Sort(numbers, name_new, surname_new);
                for (int m = 1; m < lineCount-1; m++) {
                    cn.getTextWindow().setCursorPosition(31, 6 + m);
                    cn.getTextWindow().output(numbers[m] + " " + name_new[m] + " " + surname_new[m]);
                }
                Thread.sleep(5000);
                Map map =new Map(60,60);
                map.callMap();

            } else if (end == 1) { // oyun bitti isim alınacak

                cn.getTextWindow().setCursorPosition(70, 5);
                cn.getTextWindow().output("PLEASE ENTER YOUR NAME: ");
                Scanner scanner = new Scanner(System.in);
                String namePlayer = scanner.nextLine();
                cn.getTextWindow().setCursorPosition(70, 6);
                cn.getTextWindow().output("PLEASE ENTER YOUR SURNAME: ");
                String surnamePlayer = scanner.nextLine();
                String metin = namePlayer + "," + surnamePlayer + "," + score;
                Path dosyaYoluNesnesi = Paths.get(filePath);
                try {
                    Files.write(dosyaYoluNesnesi, (metin + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.err.println("Dosyaya yazma hatası: " + e.getMessage());
                }
                Thread.sleep(100);

                InsertionSort compare = new InsertionSort();
                compare.Sort(numbers, name_new, surname_new);
                for (int m = 0; m < lineCount-1; m++) {
                        cn.getTextWindow().setCursorPosition(31, 6 + m);
                        cn.getTextWindow().output(numbers[m] + " " + name_new[m] + " " + surname_new[m],orange);
                }
                ScoreTable scoreSort =new ScoreTable(3,0);
                Thread.sleep(5000);
                EndMenu endMenu=new EndMenu();
                endMenu.callEnd(2,"lila");

            }
            else if (end == 3) { // high score basıldıysa direk
                InsertionSort compare = new InsertionSort();
                compare.Sort(numbers, name_new, surname_new);
                for (int m = 0; m < lineCount-1; m++) {
                    cn.getTextWindow().setCursorPosition(31, 6 + m);
                    cn.getTextWindow().output(numbers[m] + " " + name_new[m] + " " + surname_new[m]);
                }
                Thread.sleep(5000);

            }

        }
    }
    public void drawSquare() {

        int counter = 0;
        for (int i = 0; i < 44; i = i + 2) {
            TextAttributes cyan = new TextAttributes(Color.WHITE, Color.WHITE);
            cn.getTextWindow().setCursorPosition(19 + i, 3);
            char tilda = '~';
            cn.getTextWindow().output(tilda + " ", cyan);

        }

        for (int i = 0; i < 20; i++) {
            TextAttributes cyan = new TextAttributes(Color.WHITE, Color.WHITE);
            cn.getTextWindow().setCursorPosition(19, 3 + i);
            char tilda = '~';
            cn.getTextWindow().output(tilda + " ", cyan);
            counter++;
        }

        for (int i = 0; i < 42; i++) {
            TextAttributes cyan = new TextAttributes(Color.WHITE, Color.WHITE);
            cn.getTextWindow().setCursorPosition(19 + i, 3 + counter);
            char tilda = '~';
            cn.getTextWindow().output(tilda + " ", cyan);
        }

        for (int i = 0; i < 20; i++) {
            TextAttributes cyan = new TextAttributes(Color.WHITE, Color.WHITE);
            cn.getTextWindow().setCursorPosition(61, 4 + i);
            char tilda = '~';
            cn.getTextWindow().output(tilda + " ", cyan);

        }
    }
}

