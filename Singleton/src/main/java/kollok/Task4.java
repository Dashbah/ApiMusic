package kollok;

import java.io.IOException;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {

        // ok
        FastStudentNamesWriter writer1 = new FastStudentNamesWriter();
        FastStudentNamesWriter writer2 = new FastStudentNamesWriter();

        // ok
        List<String> firstGroupStudentNames = List.of(
                "Виталя",
                "Игорь",
                "Катя",
                "Влад",
                "Влад",
                "Влад",
                "Влад"
        );

        List<String> secondGroupStudentNames = List.of(
                "Георгий",
                "Кеша",
                "Мухтар",
                "Мухтар",
                "Мухтар",
                "Мухтар",
                "Мухтар",
                "Виктор"
        );

        // исключение надо ловить
        try {
            writer1.writeInParallel(firstGroupStudentNames);
        } catch (IOException e) {
            // do smth
        }
        try {
            writer2.writeInParallel(secondGroupStudentNames);
        } catch (IOException e) {
            // do smth
        }

        System.out.println(FastStudentNamesWriter.getOutput());
    }
}
