package Loja.Rezultatet;

public class YAHTZEE {

    private int shuma=0;
    private int count=0;

    public YAHTZEE(int[] rezultatiRoll){
        for(int i = 1; i<rezultatiRoll.length; i++){
            if(rezultatiRoll[i-1]==rezultatiRoll[i]){
                count++;
            }
        }
        if (count == 4){
            shuma = 50;
        }
    }

    public int getShuma() {
        return shuma;
    }
}
