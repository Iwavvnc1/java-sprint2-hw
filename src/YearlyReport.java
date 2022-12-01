import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {

    public ArrayList<YearRecord> yearSaves = new ArrayList<>();
    public HashMap<Integer, Integer> expenseYear = new HashMap<>();
    public HashMap<Integer, Integer> inComeYear = new HashMap<>();

    public void loadFile(Integer year, String path) {
        String content = readFileContents(path);
        if (content != null) {
            String[] lines = content.split("\r?\n");

            for (int i = 1; i < lines.length; i++) {
                String line = lines[i];
                String[] parts = line.split(",");
                int month = Integer.parseInt(parts[0]);
                int amount = Integer.parseInt(parts[1]);
                boolean isExpense = Boolean.parseBoolean(parts[2]);
                YearRecord yearSave = new YearRecord(month, amount, isExpense, year);
                yearSaves.add(yearSave);
            }
        }
    }
    public String readFileContents(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории, либо еще не создан.");
            return null;
        }
    }

}