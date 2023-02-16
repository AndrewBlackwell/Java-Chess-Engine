package board;

public class BoardUtils
{
    public static final boolean[] FIRST_COLUMN = null;
    public static final boolean[] SECOND_COLUMN = null;
    public static final boolean[] SEVENTH_COLUMN = null;
    public static final boolean[] EIGTH_COLUMN = null;

    private BoardUtils()
    {
        throw new RuntimeException("You cannot instantiate this class!!!");
    }

    public static boolean isValidTile(int position)
    {
        return position >= 0 && position < 64;
    }

}
