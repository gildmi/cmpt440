public class TM {
  // A constant for the tape blank.
  private final char B = 0;

  /*
   * A String containing the char for each accepting
   * state, in any order.
   */
  private final String accepting = "\7";

  // Initial state
  private final int initial = 1;

  // a^nb^nc^n delta function
  private final char[][] delta = {
    {1,'a',2,'X','R'}, // delta(q1,a) = (q2,X,R)
    {1,B,7,B,'R'},     // etc.
    {2,'a',2,'a','R'},
    {2,'Y',2,'Y','R'},
    {2,'b',3,'Y','R'},
    {3,'b',3,'b','R'},
    {3,'Z',3,'Z','R'},
    {3,'c',4,'Z','L'},
    {4,'a',4,'a','L'},
    {4,'b',4,'b','L'},
    {4,'Z',4,'Z','L'},
    {4,'Y',4,'Y','L'},
    {4,'X',5,'X','R'},
    {5,'a',2,'X','R'},
    {5,'Y',6,'Y','R'},
    {6,'Y',6,'Y','R'},
    {6,'Z',6,'Z','R'},
    {6,B,7,B,'R'}
  };

  /*
   * The TM's current tape and head position.  We always
   * maintain 0 <= head < tape.length(), adding blanks
   * to the front or rear of the tape as necessary.
   */
  private String tape;
  private int head;

  // Varibale to store current state
  private char state;


  /**
   * Find the move for the given state and symbol.  
   * @param state current state
   * @param symbol symbol at current head position
   * @return the 5-element char[] from the delta table
   */
  char[] lookupMove(char state, char symbol) {
    for(int i = 0; i<delta.length; i++) {
      char[] move = delta[i];
      if (move[0]==state && move[1]==symbol) return move;
    }
    return null;
  }      

void executeMove(char newstate, char symbol, char dir) {

  // write on the tape
  tape = tape.substring(0,head) + symbol + 
            tape.substring(head+1);

  // move the head, maintaining the invariant
  // 0 <= head < tape.length()

  if (dir=='L') {
    if (head==0) tape = B + tape; else head -= 1;
  }
  else {
    head += 1;
    if (head==tape.length()) tape += B;
  }

  // go to the next state
  state = newstate;

} 

public boolean accepts(String s) {
  return accepts(s, false);
}

public boolean accepts(String s, Boolean debug) {
  state = initial;
  head = 0;
  tape = s;
  
  if (debug) {
    System.out.println("Initial state: " + initial + ", head at " + head + ", with tape: " + tape);
  }

  // establish 0 <= head < tape.length()
  if (head==tape.length()) {
    tape += B; 
    if (debug) {
      System.out.println("Extended tape");
    }
  }

  while (true) {
    if (accepting.indexOf(state)!=-1) return true;
    char[] move = lookupMove(state,tape.charAt(head));
    if (move==null) {
      if (debug) {
      System.out.println("Move: " + move);
    }
      return false;
    }
    if (debug) {
      System.out.println("Move: from state q" + Integer.toString(move[0]) + " given symbol " + move[1] + " move to state q" + Integer.toString(move[2]) + " write " + move[3] + " to tape and move tape head " + move[4]);
    }
    executeMove(move[2],move[3],move[4]);
  }
}

}