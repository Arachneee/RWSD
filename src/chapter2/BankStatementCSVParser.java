package chapter2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankStatementCSVParser
{
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private BankTransaction pareFormCSV(final String line)
    {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final Double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date,amount,description);
    }

    public List<BankTransaction> parseLinesFormCSV(final List<String> lines)
    {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line:lines)
        {
            bankTransactions.add(pareFormCSV(line));
        }
        return bankTransactions;
    }

}
