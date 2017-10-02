import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawLottoArray {

    List<Integer[]> lottoArray;


    public void makeLottoFiveArray(){
        List<Integer[]> lottoArray = new ArrayList<Integer[]>();

        int columnCounter = 89;

        while(columnCounter >= 0){

            lottoArray.add(new Integer[columnCounter]);
            columnCounter--;
        }

        for(Integer[] arr : lottoArray){
            Arrays.fill(arr,0);
        }

        this.lottoArray = lottoArray;
    }

    public void mFOPLogic(){

        //System.out.println(draw.getDrawnNumbers());

        Integer[] drawNumbers = new Integer[]{90,89,1,2,3};

        for(int n = 0; n < drawNumbers.length; n++){
            int counter = 0;
            for(int i = n+1; i < drawNumbers.length; i++){
                if(drawNumbers[n] < drawNumbers[i]) {
                    this.lottoArray.get(drawNumbers[n] - 1)[(drawNumbers[i] - drawNumbers[n])-1]++;
                }else if(drawNumbers[n] > drawNumbers [i] ){
                    this.lottoArray.get(drawNumbers[i] - 1)[(drawNumbers[n] - drawNumbers[i])-1]++;
                }
                counter++;
                System.out.println(counter);
            }
        }
    }


    public void lottoArraySTDOUT(){
        for(int n = 0; n < this.lottoArray.size(); n++) {
            if( n < 9) {
                System.out.print("0" + (n + 1) + " : num of possible pairs:" + this.lottoArray.get(n).length + " - ");
            }else {
                if(this.lottoArray.get(n).length < 10) {
                    System.out.print(n + 1 + " : num of possible pairs:0" + this.lottoArray.get(n).length + " - ");
                }else{
                    System.out.print(n + 1 + " : num of possible pairs:" + this.lottoArray.get(n).length + " - ");

                }
            }
            for (int i = 0; i < this.lottoArray.get(n).length; i++) {
                System.out.print(" " + this.lottoArray.get(n)[i] + " ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {

        DrawLottoArray lottoArray = new DrawLottoArray();

        lottoArray.makeLottoFiveArray();
        lottoArray.mFOPLogic();
        lottoArray.lottoArraySTDOUT();
    }
}