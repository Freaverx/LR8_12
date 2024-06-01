import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WordFilter {
    public static void main(String[] args) throws IOException {
        // Чтение исходного файла
        File inputFile = new File("input.txt");
        List<String> lines = Files.readAllLines(inputFile.toPath());

        // Создание списка для хранения слов, начинающихся с согласных букв
        List<String> consonantWords = new ArrayList<>();

        // Перебор строк и выделение слов
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.matches("[бвгджзклмнпрстфхцчшщ]+.*")) {
                    consonantWords.add(word);
                }
            }
        }

        // Запись в новый файл
        Path outputFile = new File("output.txt").toPath();
        Files.write(outputFile, consonantWords);

        // Вывод количества слов в каждой строке
        for (int i = 0; i < lines.size(); i++) {
            System.out.printf("Строка %d содержит %d слов, начинающихся с согласных букв\n", i + 1, consonantWords.subList(i * lines.size(), (i + 1) * lines.size).size());
        }
    }
}