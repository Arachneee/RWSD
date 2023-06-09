package main.java;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankStatementCSVParser implements BankStatementParser
{
    final int EXPECTED_ATTRIBUTES_LENGTH = 3;
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public BankTransaction parseFrom(final String line){
        final String[] columns = line.split(",");

        final BankStatementValidator bankStatementValidator = new BankStatementValidator(columns[2], columns[0],columns[1]);
        final Notification notification = bankStatementValidator.validate();
        if(notification.hasErrors())
            System.out.println(notification.getErrors().toString());


        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final Double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date,amount,description);
    }
    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();

        for(final String line:lines)
        {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }

}
