package Loja.Rezultatet;

public class LITTLES {
    private int shuma=0;

    public LITTLES(int[] rezultatiRoll){

        int nr6=0, nr5=0, nr4=0, nr3=0, nr2=0, nr1=0;

        for(int i = 0; i<rezultatiRoll.length; i++){
            switch(rezultatiRoll[i]){
                case 1: if (nr1==0){nr1 = rezultatiRoll[i];}
                    break;
                case 2: if (nr2==0){nr2 = rezultatiRoll[i];}
                    break;
                case 3: if (nr3==0){nr3 = rezultatiRoll[i];}
                    break;
                case 4: if (nr4==0){nr4 = rezultatiRoll[i];}
                    break;
                case 5: if (nr5==0){nr5 = rezultatiRoll[i];}
                    break;
                case 6: if (nr6==0){nr6 = rezultatiRoll[i];}
                    break;
            }
        }

        if((nr3!=0)&&(nr4!=0)){
            if((nr1!=0)&&(nr2!=0)){
                shuma = 30;
            }
            else if ((nr6!=0)&&(nr5!=0)){
                shuma = 30;
            }
            else if ((nr2!=0)&&(nr5!=0)){
                shuma = 30;
            }
        }
    }

    public int getShuma() {
        return shuma;
    }
}