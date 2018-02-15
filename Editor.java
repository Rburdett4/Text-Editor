/**
 * This is an implementation of an editor.
 */

public class Editor implements Ed
{
    /*
     *  The first string in the sequence, possible an empty string.
     */
    private String first;
    /*
     *  The second string in the sequence, possible an empty string.
     */
    private String rest;
    /**
     * Initializes the Editor with an empty body.
     */
    public Editor() 
    {
        first = "";
        rest = "";
    }
    
    public Editor( String beginning, String end ) 
    {
        first = beginning;
        rest = end;
    }
    /**
     * Returns the first string in the sequence
     */
    public String getFirst() { return first; }
    /**
     * Returns the second string in the sequence
     */
    public String getRest() { return rest; }
    
    /**
     * Returns an Editor representing the current editor after pressing the right arrow
     */
    public Ed rightArrow() 
    {
        if(this.getRest().length() == 0)
            return new Editor(this.getFirst(), "");
        if(this.getRest().length() == 1)
            return new Editor(this.getFirst() + this.getRest().substring(0,1), "");
        return new Editor( this.getFirst() + this.getRest().substring(0,1), this.getRest().substring(1));
    }
    /**
     * Returns an Editor representing the current editor after pressing the right arrow
     */
    public Ed leftArrow() 
    {
        if(this.getFirst().length() == 0)
            return new Editor("", this.getRest());
        if(this.getRest().length() == 0)
            return new Editor("", this.getFirst());
        if(this.getRest().length() == 1)
            return new Editor("", this.getFirst() + this.getRest());
        return new Editor(this.getFirst().substring(0, this.getFirst().length() - 1), this.getFirst().substring(this.getFirst().length() - 1) + this.getRest());
    }
      
    /**
     * Returns an Editor representing the current editor after pressing backspace
     */
    public Ed backspace() 
    {
        if(this.getFirst().length() == 0)
            return new Editor("", this.getRest());
        return new Editor(this.getFirst().substring(0, this.getFirst().length() - 1), this.getRest());
    }
    
    /**
     * Returns an Editor representing the current editor after pressing delete
     */
    public Ed delete() 
    {
        if(this.getRest().length() == 0)
            return new Editor(this.getFirst(), "");
        return new Editor(this.getFirst(), this.getRest().substring(1));
    }
     
    /**
     * Returns an Editor representing the current editor after inserting a character
     * @param c The character to insert
     */
    public Ed insertString(String c)
    {
        return new Editor(first + c, rest);
    }
        
    /**
     * Returns an Editor representing the current editor after pressing the home key
     */
    public Ed homeKey() 
    {
        return new Editor("", this.getFirst() + this.getRest());
    }
       
    /**
     * Returns an Editor representing the current editor after pressing the end key
     */
    public Ed endKey()
    {
        return new Editor(this.getFirst() + this.getRest(), "");
    }
          
    /**
     * Returns the Editor as a string in form "&lt;first&gt;|&lt;rest&gt;"
     */
    public String toString() { return first + "|" + rest; }
    
    public static void main( String [] args )
    {
        Ed bothSides = new Editor( "big", "dog" );  
        Ed rightSide = new Editor( "", "dog" );
        Ed leftSide = new Editor( "big", "" );
        Ed neitherSide = new Editor( "", "" );
        System.out.println( bothSides + "   after rightArrow   " + bothSides.rightArrow() );
        System.out.println( rightSide + "   after rightArrow   " + rightSide.rightArrow() );
        System.out.println( leftSide + "   after rightArrow   " + leftSide.rightArrow()  );
        System.out.println( neitherSide + "   after rightArrow   " + neitherSide.rightArrow()  );
    }
}