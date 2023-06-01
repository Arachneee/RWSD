package main.java;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankGroupParse
{
    final private List<BankTransaction> bankTransactions;

    public BankGroupParse(List<BankTransaction> bankTransactions)
    {
        this.bankTransactions = bankTransactions;
    }
    public List<BankTransaction> getBankTransactions()
    {
        return bankTransactions;
    }

    public GroupBank setBankGroupByMonth()
    {
        Map<Month, Double> groupBank = new HashMap<>();
        for(BankTransaction bankTransaction:bankTransactions)
        {
            Month month = bankTransaction.getDate().getMonth();
            groupBank.put(month,groupBank.getOrDefault(month, (double) 0)+bankTransaction.getAmount());
        }
        return new GroupBank(groupBank);
    }
    public GroupBank setBankGroupByDescription()
    {
        Map<String, Double> groupBank = new HashMap<>();
        for(BankTransaction bankTransaction:bankTransactions)
        {
            String description = bankTransaction.getDescription();
            groupBank.put(description,groupBank.getOrDefault(description, (double) 0)+bankTransaction.getAmount());
        }
        return new GroupBank(groupBank);
    }
}
