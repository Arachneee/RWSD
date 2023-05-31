package chapter2.src.main.java;

import java.util.Map;

public class GroupBank <T>
{
    private final Map<T, Double> groupBank;

    public GroupBank(Map<T, Double> groupBank) {
        this.groupBank = groupBank;
    }
    public void showHistogram(){
        for(T key: groupBank.keySet())
        {
            StringBuffer sb = new StringBuffer();

            int legth = key.toString().length();

            sb.append(key.toString());

            for(int l=0;l<15-legth;l++)
                sb.append(" ");

            sb.append(" | ");

            int count = (int) Math.round(groupBank.get(key)/100);

            if (count <0)
            {
                for(int i=0;i<(30+count);i++)
                    sb.append(" ");
                for(int i=0;i<(-count);i++)
                    sb.append("-");
            } else {
                for(int i=0;i<30;i++)
                    sb.append(" ");
                for(int i=0;i<count;i++)
                    sb.append("+");
            }

            System.out.println(sb.toString());
        }

    }
}
