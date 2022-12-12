package Loja.Rezultatet;

public class SIXES {
    private int shuma=0;

    public SIXES(int[] rezultatiRoll){
        for(int i = 0; i<rezultatiRoll.length; i++){
            if(rezultatiRoll[i]==6){
                shuma+=rezultatiRoll[i];
            }
        }
    }

    public int getShuma() {
        return shuma;
    }
}
