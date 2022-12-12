package Loja.Rezultatet;

public class TWOPAIR {

    private int shuma = 0;
    private int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
    private int count = 0;
    private int[] checkPairs = new int[6];

    public TWOPAIR(int[] rezultatiRoll){

        for(int i = 0; i<rezultatiRoll.length; i++){
                switch(rezultatiRoll[i]){
                    case 1: count1++; break;
                    case 2: count2++; break;
                    case 3: count3++; break;
                    case 4: count4++; break;
                    case 5: count5++; break;
                    case 6: count6++; break;
                }
        }
        for(int k = 0; k<6; k++){
            switch(k){
                case 0: checkPairs[k]=count1; break;
                case 1: checkPairs[k]=count2; break;
                case 2: checkPairs[k]=count3; break;
                case 3: checkPairs[k]=count4; break;
                case 4: checkPairs[k]=count5; break;
                case 5: checkPairs[k]=count6; break;
            }
        }

        for(int j = 0; j<checkPairs.length; j++){
            if(checkPairs[j]==2){
                count++;
            }
            if(count==2){
                shuma=15;
                break;
            }
        }
    }


    public int getShuma() {
        return shuma;
    }
}
