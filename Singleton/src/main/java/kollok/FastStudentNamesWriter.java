package kollok;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

class FastStudentNamesWriter {

    public static String output = "";

    // synchronized???? zochem
    public static String getOutput() {
        return output;
    }

    public void writeInParallel(List<String> studentNames) throws IOException {
        for (String studentName : studentNames) {
            output += studentName + "\n";
        }
    }
}