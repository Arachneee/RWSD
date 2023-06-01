package chapter2.src.main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


public class BankStatementAnalyzer
{
    private static final String RESOURCES = "src\\chapter2\\src\\main\\resources\\";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES+fileName);
        final List<String> lines = Files.readAllLines(path);
        final LocalDate from = LocalDate.of(2017,1,15);
        final LocalDate to = LocalDate.of(2017,2,15);

        final BankGroupParse bankTransactions = new BankGroupParse(bankStatementParser.parseLinesFrom(lines));
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions.getBankTransactions());

        collectSummary(bankStatementProcessor,from,to);


        final GroupBank<Month> groupBankMonth = bankTransactions.setBankGroupByMonth();
        final GroupBank<String> groupBankDescription = bankTransactions.setBankGroupByDescription();

        collectHistogram(groupBankMonth, groupBankDescription);

        //chapter3
        //final List<BankTransaction> transactions = bankStatementProcessor.findTransactions(new BankTransactionIsInFebruaryAndExpensive());
        final List<BankTransaction> transactions
                = bankStatementProcessor.findTransactions(bankTransaction ->
                                                            bankTransaction.getDate().getMonth() == Month.FEBRUARY
                                                            && bankTransaction.getAmount() >= 1_000);

    }
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor,LocalDate from, LocalDate to)
    {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for Salary is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out.println("The MAX for Salary during " + from +"~" + to + " is \n" + bankStatementProcessor.findMaxBankTransaction(from,to));
        System.out.println("The MIN for Salary during " + from +"~" + to + " is \n" + bankStatementProcessor.findMinBankTransaction(from,to));
    }
    private static void collectHistogram(GroupBank... groupBanks)
    {
        for(GroupBank groupBank:groupBanks)
        {
            groupBank.showHistogram();
            System.out.println("\n\n");
        }
    }

}
