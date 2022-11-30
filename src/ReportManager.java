public class ReportManager {
    YearlyReport yearlyReport = new YearlyReport();
    MonthlyReport monthlyReport = new MonthlyReport();
    Checker checker = new Checker(monthlyReport, yearlyReport);

    public void selectReportMonth() {
        if (checker.checkSelectMonth()) {
            for (int i = 1; i < 13; i++) {
                monthlyReport.loadFile(i, "resources/m.20210" + i + ".csv");
            }
            System.out.println("Месячные отчёты считаны.");

        }
    }

    public void selectReportYear() {
        if (checker.checkSelectYear()) {
            for (int i = 2021; i < 2022; i++) {
                yearlyReport.loadFile(i, "resources/y." + i + ".csv");
            }
            System.out.println("Годовой отчёт считан.");

        }
    }

    public void selectChecker() {
        if (checker.checkReportMonth()) {
            if (checker.checkReportYear()) {

                checker.dataYearExpense();
                checker.dataYearInCome();
                checker.dataSumExpenseMonth();
                checker.dataSumInComeMonth();

                Checker checker = new Checker(monthlyReport, yearlyReport);
                checker.check();
            }
        }
    }

    public void informMonth() {
        if (checker.checkReportMonth()) {
            checker.checkInformMonth();
        }
    }
    public void informYear() {
        if (checker.checkReportYear()) {
            checker.checkInformYear();
        }
    }
}