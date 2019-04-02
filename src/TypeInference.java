import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You can replace the type arguments required to invoke the constructor of a generic class with an empty set of type parameters (<>)
 * as long as the compiler can infer the type arguments from the context.
 * This pair of angle brackets is informally called the diamond.
 *
 * https://docs.oracle.com/javase/7/docs/technotes/guides/language/type-inference-generic-instance-creation.html
 */
public class TypeInference {

  public static void typeInference() {
    Map<String, List<String>> myMap = new HashMap<String, List<String>>(); // Earlier version

    Map<String, List<String>> myMapJava7 = new HashMap<>(); // With Java 7, rewrite will.

    // Note that specifying diamond is still necessary. Without diamond, warning is still shown
    Map<String, List<String>> warnMap = new HashMap(); // unchecked conversion warning
  }

}
