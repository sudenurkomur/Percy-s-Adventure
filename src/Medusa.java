import java.util.Random;

public class Medusa extends Enemy{


    public Medusa(String name, int type, int damage, int locationX, int locationY) {
        super(name, type, damage, locationX, locationY);
    }


    public void generateRandom(int[][] numbers) throws InterruptedException {

        Random rnd =new Random();

        boolean flag=true;

        while(flag){
            int randomNumberY = rnd.nextInt(26);
            int randomNumberX = rnd.nextInt(59);
            if(numbers[randomNumberY][randomNumberX] == 0 && numbers[randomNumberY-1][randomNumberX] == 0 && numbers[randomNumberY+1][randomNumberX] == 0 && numbers[randomNumberY][randomNumberX-1] == 0 && numbers[randomNumberY][randomNumberX + 1] == 0){
                numbers[randomNumberY][randomNumberX] = 10;
                flag=false;
            }
        }
    }

    public void deleteRandomMedusa(int[][] numbers) throws InterruptedException {

        boolean flag=true;

        while(flag){
            for(int i=0; i<numbers.length;i++){
                for(int m=0;m< numbers.length;m++){
                    if(numbers[i][m]==10){
                        numbers[i][m]=0;
                        flag=false;
                    }
                }
            }
        }

    }

    @Override
    public void act() {

    }
}
