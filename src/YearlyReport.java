import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class YearlyReport {
    public static ArrayList<YearRecord> yearSaves = new ArrayList<>();
    public static HashMap<Integer, Integer> expenseYear = new HashMap<>();
    public static HashMap<Integer, Integer> inComeYear = new HashMap<>();

    public void loadFile(Integer year, String path) {
        List<String> lines = readFileContents(path);
        if (lines != null) {
            for (String line : lines) {
                String[] parts = line.split(",");
                if (!parts[0].equals("month")) {
                    YearRecord yearSave = new YearRecord(
                            Integer.parseInt(parts[0]),
                            Integer.parseInt(parts[1]),
                            Boolean.parseBoolean(parts[2]),
                            year);
                    yearSaves.add(yearSave);
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