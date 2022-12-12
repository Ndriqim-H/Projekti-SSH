package Loja.Rezultatet;

public class TWOS {

    private int shuma=0;

    public TWOS(int[] rezultatiRoll){
        for(int i = 0; i<rezultatiRoll.length; i++){
            if(rezultatiRoll[i]==2){
                shuma+=rezultatiRoll[i];
            }
        }
    }

    public int getShuma() {
        return shuma;
    }
}
