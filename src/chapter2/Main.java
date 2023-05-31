package chapter2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main
{
    private static final String RESOURCES = "src/main/resources/";
    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final String fileName = args[0];
        final Path path = Path.of(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFormCSV(lines);

        System.out.println("The total for all transactions is " + calcu);
    }

}
