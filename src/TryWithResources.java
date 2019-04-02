import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The try-with-resources statement is a try statement that declares one or more resources.
 * A resource is as an object that must be closed after the program is finished with it.
 * The try-with-resources statement ensures that each resource is closed at the end of the statement.
 * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable,
 * can be used as a resource. Earlier we used to close the resource in the finally block
 */
public class TryWithResources {
  static String readFirstLineFromFile(String path) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      return br.readLine();
    }
  }

  static void tryWithMultipleResources() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("some-path"));
         BufferedWriter bw = Files.newBufferedWriter(Paths.get("path"), Charset.forName("US-ASCII"))
    ) {
      // some operation
    }
  }
}
