package GenStack;

public class FullStackException extends RuntimeException
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


// no-argument constructor

  public FullStackException()
  {
      this( "Stack is full" );
 } // end no-argument FullStackException constructor


  // one-argument constructor

  public FullStackException( String exception )
   {
    super( exception );
  } // end one-argument FullStackException constructor

} // end class FullStackException
