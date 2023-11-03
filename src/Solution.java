import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year < 2002) {
            throw new Exception("year must be more than 2001");
        }
        if (year > 2021) {
            throw new Exception("year must be less than 2022");
        }
        int n = year - 2002;
        double percent = 0;
        double yearSpend;
        double[] yYPercent = new double[21];
        yYPercent[0] = 1;
        for (int x = 1; x + 1 < yYPercent.length; x++) {
            yYPercent[x] = ((Constants.MOEX_RATE[x]) / Constants.MOEX_RATE[x - 1]);
        }
        double beginYear;
        double endYear = 1;
        double inflation;

        while ((endYear > 0)) {
            percent = percent + 0.005;
            inflation = 1;
            yearSpend = percent;
            endYear = 1;
            for (int x = n; ((x + 1 < Constants.INFLATION_RATE.length)); ) {
                yearSpend = yearSpend * inflation;
                beginYear = endYear - yearSpend;
                inflation = ((Constants.INFLATION_RATE[x]) / 100 + 1);
                endYear = beginYear * yYPercent[x];
                x++;
            }
        }
        if (percent > 0.99)
            System.out.println(String.format("%.1f", percent * 100));
        else {
            System.out.println(((String.format("%.1f", ((percent - 0.005) * 100)))));
        }
    }
}
