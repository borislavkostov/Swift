
package Exception;


public class DALException extends Exception {
    private static final String message="Error in DataAccessLayer.With getting or setting data";
    public DALException() {
    }
    public DALException(String message,Throwable throwException)
      {
         super(message,throwException);
      }
}
