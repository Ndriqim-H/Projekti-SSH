package Loja.Rezultatet;

public class CHANCE {

    private int shuma=0;

    public CHANCE(int[] rezultatiRoll){
        for(int i = 0; i<rezultatiRoll.length; i++){
            shuma+=rezultatiRoll[i];
        }
    }

    public int getShuma() {
        return shuma;
    }
}
