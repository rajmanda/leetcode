package transpose.two.dimensional.array;

public class Test {


    public static void print2DArray(int[][] twoDArray) {
        // Print 2DArray
        for (int i = 0; i < twoDArray[0].length; i++) {
            for (int j = 0; j < twoDArray[1].length; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("---");
    }

    public static void main(String[] args) {
        int[][] twoDArray = new int[3][3];

        // Populate 2DArray
        int count = 0;
        for (int i = 0; i < twoDArray[0].length; i++) {
            for (int j = 0; j < twoDArray[1].length; j++) {
                twoDArray[i][j] = ++count;
            }
        }
        print2DArray(twoDArray);

        Solution transposeSolution = new Solution();
        int[][] matrix = transposeSolution.transpose(twoDArray);
        print2DArray(matrix);
    }
}

