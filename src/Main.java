import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportManager reportManager = new ReportManager();
        System.out.println("Здравствуйте, выберите действие: ");
        printMenu();
            int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput == 1) {
                reportManager.selectReportMonth();
            } else if (userInput == 2) {
                reportManager.selectReportYear();
            } else if (userInput == 3) {
                reportManager.selectChecker();
            } else if (userInput == 4) {
                reportManager.informMonth();
            } else if (userInput == 5) {
                reportManager.informYear();
            } else {
                System.out.println("Неверная команда, введите команду еще раз");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }
        public static void printMenu() {
        System.out.println("1 - Считать все месячные отчеты;");
        System.out.println("2 - Считать годовой отчет;");
        System.out.println("3 - Сверить отчеты;");
        System.out.println("4 - Вывести информацию о всех месячных отчетах;");
        System.out.println("5 - Вывести информацию о годовом отчете;");
        System.out.println("0 - Выход.");
    }
}
