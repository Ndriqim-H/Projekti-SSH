package Loja.Rezultatet;

public class FIVES {
    private int shuma=0;

    public FIVES(int[] rezultatiRoll){
        for(int i = 0; i<rezultatiRoll.length; i++){
            if(rezultatiRoll[i]==5){
                shuma+=rezultatiRoll[i];
            }
        }
    }

    public int getShuma() {
        return shuma;
    }
}