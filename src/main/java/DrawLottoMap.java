import java.util.ArrayList;
import java.util.List;

public class DrawLottoMap {
    public static  void  drawLottoFiveMap(){
        List<Integer[]> lottoMap = new ArrayList<Integer[]>();

        int columnCounter = 89;

        while(columnCounter >= 0){

            lottoMap.add(new Integer[columnCounter]);
            columnCounter--;

        }
        for(int n = 0; n < lottoMap.size(); n++) {
            if( n < 9) {
                System.out.print("0" + (n + 1) + " : num of possible pairs:" + lottoMap.get(n).length + " - ");
            }else {
                if(lottoMap.get(n).length < 10) {
                    System.out.print(n + 1 + " : num of possible pairs:0" + lottoMap.get(n).length + " - ");
                }else{
                    System.out.print(n + 1 + " : num of possible pairs:" + lottoMap.get(n).length + " - ");

                }
            }
            for (int i = 0; i < lottoMap.get(n).length; i++) {
                System.out.print(" " + lottoMap.get(n)[i] + " ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        DrawLottoMap.drawLottoFiveMap();
    }
}