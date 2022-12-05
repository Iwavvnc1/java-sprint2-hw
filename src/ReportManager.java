import java.util.HashMap;
public class ReportManager {
    public YearlyReport yearlyReport = new YearlyReport();
    public MonthlyReport monthlyReport = new MonthlyReport();
    Checker checker = new Checker();
    public void selectReportMonth() {
           MonthlyReport.monthsSaves.clear();
        for (int i = 1; i < 13; i++) {
                monthlyReport.loadFile(i, "resources/m.20210" + i + ".csv");
            }
            System.out.println("Месячные отчёты считаны.");
        }
    public void selectReportYear() {
        YearlyReport.yearSaves.clear();
        for (int i = 2021; i < 2022; i++) {
            yearlyReport.loadFile(i, "resources/y." + i + ".csv");
        }
        System.out.println("Годовой отчёт считан.");
    }
    public void selectChecker() {
        dataSumInComeOnMonth();
        dataSumExpenseOnMonth();
        dataYearExpense();
        dataYearInCome();
        if (checkReportMonth()) {
            if (checkReportYear()) {
                checker.check();
            }
        }
    }
    public void informMonth() {
            dataSumExpenseMonth();
            dataSumInComeMonth();
            if (checkReportMonth()) {
                checker.checkInformMonth();
        }
    }
    public void informYear() {
        dataYearExpense();
        dataYearInCome();
        if (checkReportYear()) {
            checker.checkInformYear();

        }
    }
    public void dataSumExpenseMonth() {
        MonthlyReport.sumExpenseMonth.clear();
        for (MonthRecord monthsSave : MonthlyReport.monthsSaves) {
            if (monthsSave.isExpense) {
                if (!MonthlyReport.sumExpenseMonth.containsKey(monthsSave.month)) {
                    MonthlyReport.sumExpenseMonth.put(monthsSave.month, new HashMap<>());
                }
                HashMap<String, Integer> nameToSum = MonthlyReport.sumExpenseMonth.get(monthsSave.month);
                nameToSum.put(monthsSave.itemName, nameToSum.getOrDefault(monthsSave.itemName, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
    }
    public void dataSumInComeMonth() {
        MonthlyReport.sumInComeMonth.clear();
        for (MonthRecord monthsSave : MonthlyReport.monthsSaves) {
            if (!monthsSave.isExpense) {
                if (!MonthlyReport.sumInComeMonth.containsKey(monthsSave.month)) {
                    MonthlyReport.sumInComeMonth.put(monthsSave.month, new HashMap<>());
                }
                HashMap<String, Integer> nameToSumMonth = MonthlyReport.sumInComeMonth.get(monthsSave.month);
                nameToSumMonth.put(monthsSave.itemName, nameToSumMonth.getOrDefault(monthsSave.itemName, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
    }
    public void dataSumInComeOnMonth() {
        MonthlyReport.sumInComeOnMonth.clear();
        for (MonthRecord monthsSave : MonthlyReport.monthsSaves) {
            if (!monthsSave.isExpense) {
                MonthlyReport.sumInComeOnMonth.put(monthsSave.month, MonthlyReport.sumInComeOnMonth.getOrDefault(monthsSave.month, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
    }
    public void dataSumExpenseOnMonth() {
        MonthlyReport.sumExpenseOnMonth.clear();
        for (MonthRecord monthsSave : MonthlyReport.monthsSaves) {
            if (monthsSave.isExpense) {
                MonthlyReport.sumExpenseOnMonth.put(monthsSave.month, MonthlyReport.sumExpenseOnMonth.getOrDefault(monthsSave.month, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
    }
    public void dataYearExpense() {
        YearlyReport.expenseYear.clear();
        for (YearRecord yearSave : YearlyReport.yearSaves) {
            if (yearSave.isExpense) {
                YearlyReport.expenseYear.put(yearSave.month, YearlyReport.expenseYear.getOrDefault(yearSave.month, 0) +
                        (yearSave.amount));
            }
        }
    }
    public void dataYearInCome() {
        YearlyReport.inComeYear.clear();
        for (YearRecord yearSave : YearlyReport.yearSaves) {
            if (!yearSave.isExpense) {
                YearlyReport.inComeYear.put(yearSave.month, YearlyReport.inComeYear.getOrDefault(yearSave.month, 0) +
                        (yearSave.amount));
            }
        }
    }
    public boolean checkReportMonth() {
        if (MonthlyReport.monthsSaves.size() == 0) {
            System.out.println("Сначало считайте месячные отчёты, затем выберите действие:");
            return false;
        }
        return true;
    }
    public boolean checkReportYear() {
        if (YearlyReport.yearSaves.size() == 0) {
            System.out.println("Сначало считайте годовой отчёт, затем выберите действие:");
            return false;
        }
        return true;
    }
}