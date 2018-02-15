/**
 * Write the same functionality using a single string and the position of the cursor.
 */
public class Editor2 implements Ed
{
    private String m_entry;
    private int m_position;

    public Editor2(String beginning, String end)
    {
        m_entry = beginning + end;
        m_position = beginning.length();
    }

    public Editor2(String entry, int position)
    {
        m_entry = entry;
        m_position = position;
    }

    public String getFirst()
    {
        return m_entry.substring(0, m_position);
    }

    public String getRest()
    {
        return m_entry.substring(m_position);
    }

    public Ed rightArrow()
    {
        if(m_position < m_entry.length())
            m_position ++;
        return new Editor2(m_entry, m_position);
    }

    public Ed leftArrow()
    {
        if(m_position > 0)
            m_position --;
        return new Editor2(m_entry, m_position);
    }

    public Ed backspace()
    {
        if(m_position == 0)
        {
            return new Editor2(m_entry, m_position);
        }
        if(m_position == 1)
        {
            return new Editor2(this.getRest(), m_position - 1);
        }
        return new Editor2(this.getFirst().substring(0, m_position - 1) + this.getRest(), m_position -1);
    }

    public Ed delete()
    {
        if(m_position == m_entry.length())
            return new Editor2(m_entry, m_position);
        if(m_position == 0)
        {
            return new Editor2(this.getRest().substring(1), m_position);
        }
        if(m_position == m_entry.length() - 1)
            return new Editor2(this.getFirst(), m_position);
        return new Editor2(this.getFirst() + this.getRest().substring(1), m_position);
    }

    public Ed insertString(String c)
    {
        m_entry = this.getFirst() + c + this.getRest();
        m_position = this.getFirst().length()  + c.length();
        return new Editor2(m_entry, m_position);
    }

    public Ed homeKey()
    {
        return new Editor2(m_entry, 0);
    }

    public Ed endKey()
    {
        return new Editor2(m_entry, m_entry.length());
    }

    public String toString()
    {
        return this.m_entry.substring(0, m_position) + "|" + this.m_entry.substring(m_position + 1, m_entry.length());
    }
}
