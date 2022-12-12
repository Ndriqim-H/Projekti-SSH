package sample;

import java.util.Random;

public class Dice {

    private int numSides;
    private int value;
    //Konstruktori per krijimin default te faqeve dhe vleres random te zarit
    public Dice(){
        setNumSides(0);
        value = 0;
    }
    //Konstruktori per percaktimin e faqeve te zarit
    public Dice (int sides){
        setNumSides(sides);
        value = 0;
    }
    //Percakton vleren random 1-6, 5 e ka tparapercaktume ne kontroller
    public int roll(){
        Random numri = new Random();
        value = numri.nextInt(getNumSides()) + 1;

        return getValue();
    }

    //E merr numrin e faqeve te zarit prej Controller.java
    public int getNumSides() {
        return numSides;
    }
    //E cakton numrin e faqeve
    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }
    //Kthen vleren / numrin random te zarit
    public int getValue() {
        return value;
    }
}
