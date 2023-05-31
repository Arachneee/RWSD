package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;


public class BankStatementAnalyzer
{
    private static final String RESOURCES = "src\\chapter2\\src\\main\\resources\\";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(final String... args) throws IOException
    {

        final String fileName = "test1.csv";

        final Path path = Paths.get(RESOURCES+fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFormCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);


    }
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor)
    {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for Salary is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
