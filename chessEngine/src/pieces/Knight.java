package pieces;
import board.Move;
import board.Tile;
import board.Board;
import board.BoardUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author AndrewBlackwell
 * @version 2.16.2023
 */

import chessEngine.Team;

public class Knight extends Piece
{
    private final static int[] POSSIBLE_MOVESET 
    = { -17, -15, -10, -6, 6, 10, 15, 17 };

    Knight(final int piecePosition, final Team pieceTeam)
    {
        super(piecePosition, pieceTeam);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board)
    {
        int possibleDestinationPosition;
        final List<Move> legalMoves = new ArrayList<>();
        for(final int currentMoveOffset : POSSIBLE_MOVESET) 
        {
            possibleDestinationPosition 
            = this.piecePosition + currentMoveOffset;
            if(BoardUtils.isValidTile(possibleDestinationPosition))
            {
                if(isFirstColumnExclusion(this.piecePosition, currentMoveOffset)
                    || isSecondColumnExclusion(this.piecePosition, currentMoveOffset)
                    || isSeventhColumnExclusion(this.piecePosition, currentMoveOffset)
                    || isEightColumnExclusion(this.piecePosition, currentMoveOffset))
                {
                    continue;
                }
                final Tile possibleDestinationTile 
                = board.getTile(possibleDestinationPosition);

                if(!possibleDestinationTile.isEmpty())
                {
                    legalMoves.add(new Move());
                }
                else
                {
                    final Piece pieceAtDestination = possibleDestinationTile.getPiece();
                    final Team pieceTeam = pieceAtDestination.getPieceTeam();
                    if (this.pieceTeam != pieceTeam)
                    {
                        legalMoves.add(new Move());
                    }
                }
            }
        }

        return Collections.unmodifiableList(legalMoves);
    }

    private static boolean isFirstColumnExclusion(final int currentMove, final int candidateOffset)
    {
        return BoardUtils.FIRST_COLUMN[currentMove] 
            && ((candidateOffset == -17) 
                || (candidateOffset == -10) 
                || (candidateOffset == 6) 
                || (candidateOffset == 15));
    }

    private static boolean isSecondColumnExclusion(final int currentMove, final int candidateOffset)
    {
        return BoardUtils.SECOND_COLUMN[currentMove] 
            && ((candidateOffset == -10)|| (candidateOffset == 6));
    }

    private static boolean isSeventhColumnExclusion(final int currentMove, final int candidateOffset)
    {
        return BoardUtils.SEVENTH_COLUMN[currentMove] 
            && ((candidateOffset == -6 ) 
                || (candidateOffset == 10));
    }

    private static boolean isEightColumnExclusion(final int currentMove, final int candidateOffset)
    {
        return BoardUtils.EIGTH_COLUMN[currentMove] 
            && ((candidateOffset == -15 ) 
                || (candidateOffset == -6)
                || (candidateOffset == 10)
                || (candidateOffset == 17));
    }
}
