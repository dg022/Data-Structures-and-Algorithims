
public interface DictionaryADT 
{
    public int insert (Record pair) throws DictionaryException;

    public void remove (String config) throws DictionaryException;

    public int get (String config);

    public int numElements();
}
