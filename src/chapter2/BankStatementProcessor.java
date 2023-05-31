package chapter2;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount()
    {
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions)
        {
            total += bankTransaction.getAmount();
        }
        return total;
    }
    public double calculateTotalForCategory (final String category)
    {
        double total = 0;
        for(final BankTransaction bankTransaction:bankTransactions)
        {
            if (bankTransaction.getDescription().equals(category))
            {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}