package Loja.Rezultatet;

public class THREES {
    private int shuma=0;

    public THREES(int[] rezultatiRoll){
        for(int i = 0; i<rezultatiRoll.length; i++){
            if(rezultatiRoll[i]==3){
                shuma+=rezultatiRoll[i];
            }
        }
    }

    public int getShuma() {
        return shuma;
    }
}