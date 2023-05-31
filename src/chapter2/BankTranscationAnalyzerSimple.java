package chapter2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class BankTranscationAnalyzerSimple
{
    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String... args) throws IOException
    {
        final Path path = Path.of(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for(final String line: lines)
        {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }


}