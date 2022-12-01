import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    public ArrayList<MonthRecord> monthsSaves = new ArrayList<>();
    public HashMap<Integer, Integer> sumExpenseOnMonth = new HashMap<>();
    public HashMap<Integer, Integer> sumInComeOnMonth = new HashMap<>();
    public HashMap<Integer, HashMap<String, Integer>> sumExpenseMonth = new HashMap<>();
    public HashMap<Integer, HashMap<String, Integer>> sumInComeMonth = new HashMap<>();

    public void loadFile(Integer month, String path) {
        String content = readFileContents(path);
        if (content != null) {
            String[] lines = content.split("\r?\n");
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i];
                String[] parts = line.split(",");
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int sumOfOne = Integer.parseInt(parts[3]);
                MonthRecord monthSave = new MonthRecord(itemName, isExpense, quantity, sumOfOne, month);
                monthsSaves.add(monthSave);
            }
        }
    }
    public String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно файл не находится в нужной директории, либо еще не создан");
            return null;


        }
    }

}