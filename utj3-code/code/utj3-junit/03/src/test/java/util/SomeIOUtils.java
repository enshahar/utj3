/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.IOUtils.bufferedReaderOn;

class SomeIOUtils {
   @Test
   void createsBufferedReaderOnFile(@TempDir Path tempDir) throws IOException {
      var path = tempDir.resolve("SomeIOUtils.test.txt");
      Files.write(path, List.of("a", "b"), StandardCharsets.UTF_8);

      var reader = bufferedReaderOn(path.toString());

      var result = reader.lines().toList();
      assertEquals(List.of("a", "b"), result);
   }

   @Test
   void rethrowsExceptionsAsUnchecked() {
      assertThrows(RuntimeException.class, () ->
         bufferedReaderOn("nonexistentFilename.txt"));
   }
}
