import java.util.HashMap;
public class Checker {
    public MonthlyReport monthlyReport;
    public YearlyReport yearlyReport;

    public Checker(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }
    public void check() {

            int i = 0;
        for (Integer sum : monthlyReport.sumExpenseOnMonth.keySet()) {
            if (!monthlyReport.sumExpenseOnMonth.get(sum).equals(yearlyReport.expenseYear.get(sum))) {
                System.out.println("Отчёт по расходам за " + sum + " месяц не сошёлся.");
            } else {
                i++;
            }
            if (i > 2) {
                System.out.println("Отчёты по расходам сошлись.");
            }
        }
        int  j = 0;
        for (Integer sum : monthlyReport.sumInComeOnMonth.keySet()) {
            if (!monthlyReport.sumInComeOnMonth.get(sum).equals(yearlyReport.inComeYear.get(sum))) {
                System.out.println("Отчёт по доходам за " + sum + " месяц не сошёлся.");
            } else {
                j++;
            }
        }
        if (j > 2) {
            System.out.println("Отчёты до доходам сошлись.");
        }
    }

    public boolean checkReportMonth() {
        if (monthlyReport.monthsSaves.size() == 0) {
            System.out.println("Сначало считайте месячные отчёты, затем выберите действие:");
            return false;
        }
        return true;
    }

    public boolean checkReportYear() {
        if (yearlyReport.yearSaves.size() == 0) {
            System.out.println("Сначало считайте годовой отчёт, затем выберите действие:");
            return false;
        }
        return true;
    }
    public boolean checkSelectMonth() {
            if (monthlyReport.monthsSaves.size() != 0) {
                System.out.println("Отчёты уже считаны.");
                return false;
            }
            return true;
        }
    public boolean checkSelectYear() {
        if (yearlyReport.yearSaves.size() != 0) {
            System.out.println("Отчёты уже считаны.");
            return false;
        }
        return true;
    }


    public void checkInformMonth() {

        for (Integer sum : monthlyReport.sumInComeMonth.keySet()) {
            int inCome = 0;
            String nameInCome = null;
            int expense = 0;
            String nameExpense = null;
            System.out.println("За " + sum + " месяц:");
            HashMap<String, Integer> nameToSumInCome = monthlyReport.sumInComeMonth.get(sum);
            HashMap<String, Integer> nameToSumExpanse = monthlyReport.sumExpenseMonth.get(sum);
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
        System.out.println("За " + yearlyReport.yearSaves.get(0).year + " год прибыль составила:");
        for (Integer sum: yearlyReport.expenseYear.keySet()) {
           inCome =  yearlyReport.inComeYear.get(sum) - yearlyReport.expenseYear.get(sum);
           sumExpense += yearlyReport.expenseYear.get(sum);
           sumInCome += yearlyReport.inComeYear.get(sum);
            System.out.println("за " + sum + " месяц - " + inCome + ".");
        }
        System.out.println("Средний расход за все месяцы в году составил: " + (sumExpense/yearlyReport.expenseYear.size()) + ".");
        System.out.println("Средний доход за все месяцы в году составил: " + (sumInCome/yearlyReport.inComeYear.size()) + ".");

    }
    }