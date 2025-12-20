package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

    private static final String LOG_FILE = "workflow.log";

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {

            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            writer.write("[" + timeStamp + "] " + message + "\n");

        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }
}

