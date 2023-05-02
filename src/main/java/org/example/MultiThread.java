package org.example;
import java.util.Random;
public class MultiThread extends Thread {
    int[] galtonBoardBins;
    Random rand = new Random();
    public MultiThread(int[] galtonBoardBins) {
        this.galtonBoardBins = galtonBoardBins;
    }

    @Override
    public void run() {
        int currentIndex = 0;
        for (int i = 0; i < galtonBoardBins.length - 1; i++) {
            currentIndex += rand.nextInt(2);
        }
        synchronized (galtonBoardBins) {
            galtonBoardBins[currentIndex] += 1;

        }

    }
}
