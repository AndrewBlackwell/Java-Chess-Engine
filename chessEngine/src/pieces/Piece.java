package pieces;

import chessEngine.Team;
import board.Move;
import board.Board;
import java.util.List;

/**
 * 
 * @author AndrewBlackwell
 * @version 2.16.2023
 */
public abstract class Piece
{
    protected final int piecePosition;
    protected final Team pieceTeam;

    Piece(final int piecePosition, final Team pieceTeam)
    {
        this.piecePosition = piecePosition;
        this.pieceTeam = pieceTeam;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);

    public Team getPieceTeam()
    {
        return this.pieceTeam;
    }
}
