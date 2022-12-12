package Loja.Rezultatet;

public class FULLHOUSE {

    private int shuma = 0;
    private int count = 0;
    private int countPairs = 0;

    private int[] pairCheck = new int[5];

    public FULLHOUSE(int[] rezultatiRoll){
        for(int i = 0; i < rezultatiRoll.length; i++){
            for(int j = i+1; j<rezultatiRoll.length; j++){
                if(rezultatiRoll[i]==rezultatiRoll[j]){
                    count++;
                }
            }
            pairCheck[i]=count;
        }

        for (int k = 0; k < pairCheck.length; k++){
            for(int o = k+1; o < pairCheck.length; o++){
                if(pairCheck[k]==2){
                    countPairs++;
                }
            }
            if((pairCheck[k]==3)&&(countPairs==2)){
                shuma = 25;
            }
        }
    }

    public int getShuma() {
        return shuma;
    }
}
