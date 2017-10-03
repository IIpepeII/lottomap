import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawLottoArray {

   private  List<Integer[]> lottoArray;
   private List<Integer[]> resultArray = new ArrayList<Integer[]>();


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
            for(int i = n+1; i < drawNumbers.length; i++){
                if(drawNumbers[n] < drawNumbers[i]) {
                    this.lottoArray.get(drawNumbers[n] - 1)[(drawNumbers[i] - drawNumbers[n])-1]++;
                }else if(drawNumbers[n] > drawNumbers [i] ){
                    this.lottoArray.get(drawNumbers[i] - 1)[(drawNumbers[n] - drawNumbers[i])-1]++;
                }
            }
        }
    }

    public void resultFiller(){
        int max = findMax();
        this.resultArray.addAll(fillByCompareValuesByMax(max));
    }

    private int findMax(){

        int max = 0;
        for(Integer[] arr : this.lottoArray){
            Integer[] tempArray = arr.clone();
            Arrays.sort(tempArray);
            if(tempArray.length > 0) {
                if(tempArray[tempArray.length - 1] > max) {
                    max = tempArray[tempArray.length - 1];
                }
            }
        }
        return max;
    }

    private List<Integer[]> fillByCompareValuesByMax(int max){
        List<Integer[]> resultArray = new ArrayList<Integer[]>();
        for(Integer[] arr : this.lottoArray){
            int valueByIndex = 0;
            for(Integer number : arr) {
                valueByIndex++;
                int indexOfArr = this.lottoArray.indexOf(arr);
                if(number == max){
                    Integer[] result = new Integer[2];
                    result[0] = indexOfArr+1;
                    result[1] = valueByIndex + indexOfArr+1;
                    resultArray.add(result);
                }
            }
        }
        return resultArray;
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

    public void resultArraySTDOUT(){

        for(Integer[] resultList : this.resultArray){
            System.out.println("Pair of " + resultList[0] + " and " + resultList[1] );
        }
    }

    public static void logic(){

        DrawLottoArray lottoArray = new DrawLottoArray();
        lottoArray.makeLottoFiveArray();
        lottoArray.mFOPLogic();
        lottoArray.resultFiller();
        lottoArray.resultArraySTDOUT();
    }

    public static void main(String[] args) {
        logic();
    }
}