import java.util.Scanner;

public class MagicSquare {

    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
          String a;
        do {
            int squares[][] = new int[3][3];
            int count=1;
            for (int i = 0; i < 3; i++) {
                for (int y =0; y < 3; y++) {
                    System.out.println("Enter Number" + count);
                    squares[i][y] = Integer.parseInt(sc.nextLine());
                    count++;
                }
            }

            for (int i = 0; i < 3; i++) {
                System.out.println(squares[i][0]+" "+squares[i][1]+" "+squares[i][2]);
            }
            boolean magic[] = checkMagicSquare(squares);
            System.out.println("Is it a magic square " + magic[0]);
            System.out.println("Is it a LoShu magic square " + magic[1]);

            System.out.println("Do you wish to exit?(Y/N)");
             a=sc.nextLine();
        }while (a.equals("Y") || a.equals("y"));
    }


    public static boolean[] checkMagicSquare(int squares[][]){
        int sum[]=new int[6];
        int val=0;
         boolean[] magic= {true,true};
        for(int i=0;i<3;i++){
            int total1=0;
            int total2=0;
            for (int j=0;j<3;j++){
                total1+=squares[i][j];
                total2+=squares[j][i];
                if(squares[i][j]>10){
                    magic[1]=false;
                }
            }
            sum[val]=total1;
            val++;
            sum[val]=total2;
            val++;

        }

        for(int i=0;i<6;i++){
            if(sum[0]!=sum[i]){
                // if not a magic square.. not a Lo Shu magic square
                magic[0]=false;
                magic[1]=false;
            }
        }
            return magic;
    }
}
