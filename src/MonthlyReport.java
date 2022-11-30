import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
    public ArrayList<MonthSave> monthsSaves = new ArrayList<>();

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
                MonthSave monthSave = new MonthSave(itemName, isExpense, quantity, sumOfOne, month);
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