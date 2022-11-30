import java.util.HashMap;
public class Checker {
    public MonthlyReport monthlyReport;
    public YearlyReport yearlyReport;

   public static HashMap<Integer, Integer> sumExpenseOnMonth = new HashMap<>();
    public static HashMap<Integer, Integer> sumInComeOnMonth = new HashMap<>();
    public static HashMap<Integer, Integer> expenseYear = new HashMap<>();
    public static HashMap<Integer, Integer> inComeYear = new HashMap<>();
    public static HashMap<Integer, HashMap<String, Integer>> sumExpenseMonth = new HashMap<>();
    public static HashMap<Integer, HashMap<String, Integer>> sumInComeMonth = new HashMap<>();

    public Checker(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }

    public void dataYearExpense() {
        for (YearSave yearSave : yearlyReport.yearSaves) {
            if (yearSave.isExpense) {
                expenseYear.put(yearSave.month, expenseYear.getOrDefault(yearSave.month, 0) +
                        (yearSave.amount));
            }
        }
    }
    public void dataYearInCome() {
        for (YearSave yearSave : yearlyReport.yearSaves) {
            if (!yearSave.isExpense) {
                inComeYear.put(yearSave.month, inComeYear.getOrDefault(yearSave.month, 0) +
                        (yearSave.amount));
            }
        }
    }


    public void dataSumExpenseMonth() {
        for (MonthSave monthsSave : monthlyReport.monthsSaves) {
            if (monthsSave.isExpense) {
                if (!sumExpenseMonth.containsKey(monthsSave.month)) {
                    sumExpenseMonth.put(monthsSave.month, new HashMap<>());
                }
                HashMap<String, Integer> nameToSum = sumExpenseMonth.get(monthsSave.month);
                nameToSum.put(monthsSave.itemName, nameToSum.getOrDefault(monthsSave.itemName, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
        }
    public void dataSumInComeMonth() {
            for (MonthSave monthsSave : monthlyReport.monthsSaves) {
                if (!monthsSave.isExpense) {
                    if (!sumInComeMonth.containsKey(monthsSave.month)) {
                        sumInComeMonth.put(monthsSave.month, new HashMap<>());
                    }
                    HashMap<String, Integer> nameToSumMonth = sumInComeMonth.get(monthsSave.month);
                    nameToSumMonth.put(monthsSave.itemName, nameToSumMonth.getOrDefault(monthsSave.itemName, 0) +
                            (monthsSave.quantity * monthsSave.sumOfOne));
                }
            }
    }
    public void check() {
            for (MonthSave monthsSave : monthlyReport.monthsSaves) {
                if (monthsSave.isExpense) {
                    sumExpenseOnMonth.put(monthsSave.month, sumExpenseOnMonth.getOrDefault(monthsSave.month, 0) +
                            (monthsSave.quantity * monthsSave.sumOfOne));
                } else {
                    sumInComeOnMonth.put(monthsSave.month, sumInComeOnMonth.getOrDefault(monthsSave.month, 0) +
                            (monthsSave.quantity * monthsSave.sumOfOne));
                }
            }
        for (Integer sum : sumExpenseOnMonth.keySet()) {
            if (sumExpenseOnMonth.get(sum).equals(expenseYear.get(sum))) {
                System.out.println("Отчёт по расходам " + sum + " сошёлся.");
            } else {
                System.out.println("Отчёт по расходам " + sum + " не сошёлся.");
            }
        }
        for (Integer sum : sumInComeOnMonth.keySet()) {
            if (sumInComeOnMonth.get(sum).equals(inComeYear.get(sum))) {
                System.out.println("Отчёт по доходам за " + sum + " сошёлся.");
            } else {
                System.out.println("Отчёт за " + sum + " доходам не сошёлся.");
            }
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

    }
    public void checkInformYear() {
        int inCome;
        int sumExpense = 0;
        int sumInCome = 0;
        System.out.println("За 2021 год прибыль составила:");
        for (Integer sum: expenseYear.keySet()) {
           inCome =  inComeYear.get(sum) - expenseYear.get(sum);
           sumExpense += expenseYear.get(sum);
           sumInCome += inComeYear.get(sum);
            System.out.println("за " + sum + " месяц - " + inCome + ".");
        }
        System.out.println("Средний расход за все месяцы в году составил: " + (sumExpense/expenseYear.size()) + ".");
        System.out.println("Средний доход за все месяцы в году составил: " + (sumInCome/inComeYear.size()) + ".");

    }
    }