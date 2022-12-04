import java.util.HashMap;
public class ReportManager {
    YearlyReport yearlyReport = new YearlyReport();
    MonthlyReport monthlyReport = new MonthlyReport();
    Checker checker = new Checker(monthlyReport, yearlyReport);
    public void selectReportMonth() {
           monthlyReport.monthsSaves.clear();
        for (int i = 1; i < 13; i++) {
                monthlyReport.loadFile(i, "resources/m.20210" + i + ".csv");
            }
            System.out.println("Месячные отчёты считаны.");
        }
    public void selectReportYear() {
        yearlyReport.yearSaves.clear();
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
                Checker checker = new Checker(monthlyReport, yearlyReport);
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
        monthlyReport.sumExpenseMonth.clear();
        for (MonthRecord monthsSave : monthlyReport.monthsSaves) {
            if (monthsSave.isExpense) {
                if (!monthlyReport.sumExpenseMonth.containsKey(monthsSave.month)) {
                    monthlyReport.sumExpenseMonth.put(monthsSave.month, new HashMap<>());
                }
                HashMap<String, Integer> nameToSum = monthlyReport.sumExpenseMonth.get(monthsSave.month);
                nameToSum.put(monthsSave.itemName, nameToSum.getOrDefault(monthsSave.itemName, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
    }
    public void dataSumInComeMonth() {
        monthlyReport.sumInComeMonth.clear();
        for (MonthRecord monthsSave : monthlyReport.monthsSaves) {
            if (!monthsSave.isExpense) {
                if (!monthlyReport.sumInComeMonth.containsKey(monthsSave.month)) {
                    monthlyReport.sumInComeMonth.put(monthsSave.month, new HashMap<>());
                }
                HashMap<String, Integer> nameToSumMonth = monthlyReport.sumInComeMonth.get(monthsSave.month);
                nameToSumMonth.put(monthsSave.itemName, nameToSumMonth.getOrDefault(monthsSave.itemName, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
    }
    public void dataSumInComeOnMonth() {
        monthlyReport.sumInComeOnMonth.clear();
        for (MonthRecord monthsSave : monthlyReport.monthsSaves) {
            if (!monthsSave.isExpense) {
                monthlyReport.sumInComeOnMonth.put(monthsSave.month, monthlyReport.sumInComeOnMonth.getOrDefault(monthsSave.month, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
    }
    public void dataSumExpenseOnMonth() {
        monthlyReport.sumExpenseOnMonth.clear();
        for (MonthRecord monthsSave : monthlyReport.monthsSaves) {
            if (monthsSave.isExpense) {
                monthlyReport.sumExpenseOnMonth.put(monthsSave.month, monthlyReport.sumExpenseOnMonth.getOrDefault(monthsSave.month, 0) +
                        (monthsSave.quantity * monthsSave.sumOfOne));
            }
        }
    }
    public void dataYearExpense() {
        yearlyReport.expenseYear.clear();
        for (YearRecord yearSave : yearlyReport.yearSaves) {
            if (yearSave.isExpense) {
                yearlyReport.expenseYear.put(yearSave.month, yearlyReport.expenseYear.getOrDefault(yearSave.month, 0) +
                        (yearSave.amount));
            }
        }
    }
    public void dataYearInCome() {
        yearlyReport.inComeYear.clear();
        for (YearRecord yearSave : yearlyReport.yearSaves) {
            if (!yearSave.isExpense) {
                yearlyReport.inComeYear.put(yearSave.month, yearlyReport.inComeYear.getOrDefault(yearSave.month, 0) +
                        (yearSave.amount));
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
}