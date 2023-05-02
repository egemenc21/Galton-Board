package org.example;
import org.kohsuke.args4j.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GaltonBoard extends Main{
    @Option(name = "-numThread",required = true)
    private static int threads = 1000;
    @Option(name = "-numBins", required = true)
    private static int bins = 10;

    private static int sumOfBinValues = 0;
    public void start(){
        int[] galtonBoardBins = new int[bins];
        ReleaseTheBalls(galtonBoardBins,threads);
        for (int i = 0; i < galtonBoardBins.length; i++) {
            System.out.println(i + "\t" + galtonBoardBins[i]);
            sumOfBinValues += galtonBoardBins[i];

        }
        System.out.println("Number of requested & total threads:  " + threads);
        System.out.println("Sum of bin values: " + sumOfBinValues);

        if (Arrays.stream(galtonBoardBins).sum() == sumOfBinValues) {
            System.out.println("Nice work! Both of them are equal!");
        } else {
            System.out.println("The number of threads and sum of the bin values are not equal!");
        }
    }
     void ReleaseTheBalls(int[]galtonBoardBins,int n){
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            MultiThread newThread = new MultiThread(galtonBoardBins);
            threadList.add(newThread);
            newThread.start();
        }
        try{
            for (int i = 0; i < threadList.size(); i++) {
                threadList.get(i).join();
            }
        }catch(Exception exception){
            System.out.println(exception);
        }
    }
}
