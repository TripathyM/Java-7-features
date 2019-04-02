import java.io.IOException;
import java.sql.SQLException;

public class CatchMultipleExceptions {

  public void catchMultipleExceptions() {
    try {
      if (1 == 1) {
        throw new IOException();
      }
      throw new SQLException();
    } catch (IOException | SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * This examples's try block could throw either FirstException or SecondException.
   * Suppose you want to specify these exception types in the throws clause of the rethrowException method declaration.
   * In releases prior to Java SE 7, you cannot do so. Because the exception parameter of the catch clause, e, is type Exception,
   * and the catch block rethrows the exception parameter e, you can only specify the exception type Exception in the throws clause
   * of the rethrowException method declaration.
   *
   * However, in Java SE 7, you can specify the exception types FirstException and SecondException in the throws clause in the rethrowException method declaration.
   * The Java SE 7 compiler can determine that the exception thrown by the statement throw e must have come from the try block,
   * and the only exceptions thrown by the try block can be FirstException and SecondException
   *
   * Also, you cannot only throw a single exception,i.e. you can't just have FirstException in the throws list
   *
   * In detail, in Java SE 7 and later, when you declare one or more exception types in a catch clause, and rethrow
   * the exception handled by this catch block, the compiler verifies that the type of the rethrown exception meets the
   * following conditions:
   *
   * 1. The try block is able to throw it.
   * 2. There are no other preceding catch blocks that can handle it.
   * 3. It is a subtype or supertype of one of the catch clause's exception parameters.
   * @param exceptionName
   * @throws FirstException
   * @throws SecondException
   */
  public void rethrowException(String exceptionName) throws FirstException, SecondException {
    try {
      if (exceptionName.equals("First")) {
        throw new FirstException();
      } else {
        throw new SecondException();
      }
    } catch (Exception e) {
      throw e;
    }
  }


  /**
   * In continuation to above, this analysis is disabled if the catch parameter is assigned to another value in the catch block.
   * However, if the catch parameter is assigned to another value, you must specify the exception type Exception in the throws
   * clause of the method declaration.
   *
   * For example, See the commented line below in the catch block
   * @param exceptionName
   * @throws FirstException
   * @throws SecondException
   */
  public void rethrowExceptionWithAssignedException(String exceptionName) throws FirstException, SecondException {
    try {
      if (exceptionName.equals("First")) {
        throw new FirstException();
      } else {
        throw new SecondException();
      }
    } catch (Exception e) {
      Exception a = e;
      // throw a; // This line fails to compile
      throw e;
    }
  }

  private class FirstException extends Exception {
  }

  private class SecondException extends Exception {
  }
}
