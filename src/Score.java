import enigma.core.Enigma;

import java.io.*;

public class Score {

    public static enigma.console.Console cn = Enigma.getConsole("HIGH SCORE", 120, 28, 20);


    public Score() throws FileNotFoundException {


    }

    public int calculateScore(int sum , int points){

        sum = sum + points;

        return sum;
    }




}

