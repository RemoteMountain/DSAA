package com.niuke.practice.basic.day7;


import java.util.Comparator;

public class BestArrange {

    public class Program {
        private int start;
        private int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
        return 0;
    }
}
