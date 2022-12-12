package Loja.Rezultatet;

public class FOURS {
    private int shuma=0;

    public FOURS(int[] rezultatiRoll){
        for(int i = 0; i<rezultatiRoll.length; i++){
            if(rezultatiRoll[i]==4){
                shuma+=rezultatiRoll[i];
            }
        }
    }

    public int getShuma() {
        return shuma;
    }
}
