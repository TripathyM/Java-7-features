public class UnderscoreInNumericLiterals {

/**
 * In Java SE 7 and later, any number of underscore characters (_) can appear anywhere between digits in a numerical literal.
 * This feature enables you, for example, to separate groups of digits in numeric literals, which can improve the readability of your code.
 * This is only for improving readability of code. If you sysout the number with underscores, the underscores do not appear in the output
 * */
 static void underscoreInNumericLiterals() {
  long creditCardNumber = 1234_5678_9012_3456L;
  System.out.println("Credit card Num: " + creditCardNumber);
 }
}