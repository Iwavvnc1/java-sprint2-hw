import java.util.HashMap;
public class Checker {

    public void check() {
        int i = 0;
        for (Integer sum : MonthlyReport.sumExpenseOnMonth.keySet()) {
            if (MonthlyReport.sumExpenseOnMonth.get(sum).equals(YearlyReport.expenseYear.get(sum))) {
                i++;
            } else {
                System.out.println("Отчёт по расходам за " + sum + " месяц не сошёлся.");
            }
        }
            if (i > (MonthlyReport.sumExpenseOnMonth.size() - 1)) {
                System.out.println("Отчёты по расходам сошлись.");
            }
         i = 0;
        for (Integer sum : MonthlyReport.sumInComeOnMonth.keySet()) {
            if (MonthlyReport.sumInComeOnMonth.get(sum).equals(YearlyReport.inComeYear.get(sum))) {
                i++;
            } else {
                System.out.println("Отчёт по доходам за " + sum + " месяц не сошёлся.");
            }
        }
        if (i > (MonthlyReport.sumInComeOnMonth.size() - 1)) {
            System.out.println("Отчёты до доходам сошлись.");
        }
    }
    public void checkInformMonth() {
        for (Integer sum : MonthlyReport.sumInComeMonth.keySet()) {
            int inCome = 0;
            String nameInCome = null;
            int expense = 0;
            String nameExpense = null;
            System.out.println("За " + sum + " месяц:");
            HashMap<String, Integer> nameToSumInCome = MonthlyReport.sumInComeMonth.get(sum);
            HashMap<String, Integer> nameToSumExpanse = MonthlyReport.sumExpenseMonth.get(sum);
            for (String name : nameToSumInCome.keySet()) {
                if (inCome < nameToSumInCome.get(name)) {
                    inCome = nameToSumInCome.get(name);
                    nameInCome = name;
                }
            }
            System.out.println("Cамый прибыльный товар - " + nameInCome + ", на сумму - " + inCome + ".");
            for (String name : nameToSumExpanse.keySet()) {
                if (expense < nameToSumExpanse.get(name)) {
                    expense = nameToSumExpanse.get(name);
                    nameExpense = name;
                }
            }
            System.out.println("Самая большая трата - " + nameExpense + ", на сумму - " + expense + ".");
        }
    }
    public void checkInformYear() {
        int inCome;
        int sumExpense = 0;
        int sumInCome = 0;
        System.out.println("За " + YearlyReport.yearSaves.get(0).year + " год прибыль составила:");
        for (Integer sum : YearlyReport.expenseYear.keySet()) {
            inCome = YearlyReport.inComeYear.get(sum) - YearlyReport.expenseYear.get(sum);
            sumExpense += YearlyReport.expenseYear.get(sum);
            sumInCome += YearlyReport.inComeYear.get(sum);
            System.out.println("за " + sum + " месяц - " + inCome + ".");
        }
        System.out.println("Средний расход за все месяцы в году составил: " + (sumExpense / YearlyReport.expenseYear.size()) + ".");
        System.out.println("Средний доход за все месяцы в году составил: " + (sumInCome / YearlyReport.inComeYear.size()) + ".");
    }
}