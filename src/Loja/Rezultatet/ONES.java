package Loja.Rezultatet;

public class ONES {

    private int shuma=0;

    public ONES(int[] rezultatiRoll){
         for(int i = 0; i<rezultatiRoll.length; i++){
             if(rezultatiRoll[i]==1){
                 shuma+=rezultatiRoll[i];
             }
         }
    }

    public int getShuma() {
        return shuma;
    }
}
