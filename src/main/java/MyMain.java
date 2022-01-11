public class MyMain {

    // Returns the number of odd numbers in mat
    public static int countOdds(int[][] mat) {
        int count = 0;
        for(int[] rowArr: mat) {
            for(int x: rowArr) {
                if(Math.abs(x)%2==1) {
                    count++;
                }
            }
        }
        return count;
    }

    // Returns the largest value in mat
    public static int findLargest(int[][] mat) {
        int max = mat[0][0];
        for(int[] rowArr: mat) {
            for(int x: rowArr) {
                if(x>max) {
                    max = x;
                }
            }
        }
        return max;
    }

    // Write a method that "left-shifts" each row in a 2D array.
    // This means that for each row, all the numbers should be
    // shifted to the left by 1, with wraparound (the first value
    // should wrap around to the last entry in the row)
    public static int[][] leftShift(int[][] mat) {
        int[][] shifted = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            int first = mat[i][0];
            for (int j = 0; j < mat[0].length; j++) {
                if(j+1==mat[0].length) {
                    shifted[i][mat[0].length-1] = first;
                }
                else {
                    shifted[i][j] = mat[i][j + 1];
                }
            }
        }
        return shifted;
    }

    // Creates a new array list of size arraySize x arraySize
    // where each value is each to the sum of its row and col indexes
    public static int[][] arrayBuilder(int arraySize) {
        int[][] newArray = new int[arraySize][arraySize];
        for (int row = 0; row < newArray.length; row++) {
            for (int col = 0; col < newArray[0].length; col++) {
                newArray[row][col] = row+col;
            }
        }
        return newArray;
    }

    // Methods for the homework:

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) {
        double sum = 0;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                sum+=mat[row][col];
            }
        }
        return sum/(mat.length*mat[0].length);
    }

    // Returns the median of the 2D array mat
    // Remember that the array is sorted!
    public static double median(double[][] mat) {
        int numberOfElements = mat.length*mat[0].length;
        if(numberOfElements%2==0) {//if total number of elements are even
            int checkmark = (numberOfElements/2)-1;
            int increment = 0;
            double lower = 0;
            double higher = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if(increment==checkmark) {
                        lower = mat[i][j];
                    }
                    if(increment==checkmark+1){
                        higher = mat[i][j];
                        return (lower+higher)/2;
                    }
                    increment++;
                }
            }

        }
        else{//if total number of elements are odd
            int checkmark = numberOfElements/2;
            int increment = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if(increment==checkmark) {
                        return mat[i][j];
                    }
                    increment++;
                }
            }
        }
        return -1;
    }


    // Returns the mode of the 2D array mat
    // Remember that the array is sorted!
    public static double mode(double[][] mat) {
        double[] modeArr = new double[mat.length*mat[0].length];
        int increment = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                modeArr[increment] = mat[i][j];
                increment++;
            }
        }
        int recordIncrements = Integer.MIN_VALUE;
        int recordIndex = 0;
        for (int i = 0; i < modeArr.length-1; i++) {
            if(modeArr[i]==modeArr[i+1]) {
                int increments = 0;
                for (int j = i; j < modeArr.length-1; j++) {
                    if(modeArr[j]!=modeArr[j+1]) {
                        if(increments>recordIncrements) {
                            recordIndex = j;
                        }
                        break;
                    }
                    increments++;
                }
            }
        }
        return modeArr[recordIndex];
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
    }
}
