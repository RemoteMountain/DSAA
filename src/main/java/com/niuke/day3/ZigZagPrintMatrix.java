package com.niuke.day3;

public class ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] m) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = m.length - 1;
        int endC = m[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1) {
            printLevel(m, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            fromUp = !fromUp;
        }

    }

    private static void printLevel(int[][] m, int aR, int aC, int bR, int bC, boolean fromUp) {
        if (fromUp) {
            while (aR != bR + 1) {
                System.out.println(m[aR++][aC--]);
            }
        }else {
            while (bC != aC+1){
                System.out.println(m[bR--][bC++]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }
}
