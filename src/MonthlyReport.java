import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MonthlyReport {
    public static ArrayList<MonthRecord> monthsSaves = new ArrayList<>();
    public static HashMap<Integer, Integer> sumExpenseOnMonth = new HashMap<>();
    public static HashMap<Integer, Integer> sumInComeOnMonth = new HashMap<>();
    public static HashMap<Integer, HashMap<String, Integer>> sumExpenseMonth = new HashMap<>();
    public static HashMap<Integer, HashMap<String, Integer>> sumInComeMonth = new HashMap<>();
    public void loadFile(Integer month, String path) {
        List<String> lines = readFileContents(path);
        if (lines != null) {

            for (String line : lines) {
                String[] parts = line.split(",");
                if (!parts[0].equals("item_name")) {
                    MonthRecord monthSave = new MonthRecord(
                            parts[0],
                            Boolean.parseBoolean(parts[1]),
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]),
                            month);
                    monthsSaves.add(monthSave);
                }
            }
        }
    }
    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}