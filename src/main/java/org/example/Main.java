package org.example;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main {

    public static void main(String[] args) {

        GaltonBoard galtonBoard = new GaltonBoard();
        CmdLineParser cmdLineParser = new CmdLineParser(galtonBoard);
        try {
            cmdLineParser.parseArgument(args);
            galtonBoard.start();

        } catch (CmdLineException e) {
            System.out.println(e.getMessage());

        }
        }
    }
