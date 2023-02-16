package board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import pieces.Piece;

/**
 * 
 * @author AndrewBlackwell
 * @version 2.16.2023
 */

public abstract class Tile
{
    protected final int position;

    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE 
    = createAllPossibleEmptyTiles();

    private Tile(int position)
    {
        this.position = position;
    }

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles()
    {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i =0; i < 64; i++)
        {
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return Collections.unmodifiableMap(emptyTileMap);
    }

    public static Tile createTile(int position, final Piece piece)
    {
        return piece != null ? new OccupiedTile(position, piece) 
            : EMPTY_TILES_CACHE.get(position);
    }

    public abstract boolean isEmpty();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile
    {
        private EmptyTile(final int pos)
        {
            super(pos);
        }

        @Override
        public boolean isEmpty()
        {
            return false;
        }

        @Override
        public Piece getPiece()
        {
            return null;
        }
    }

    public static final class OccupiedTile extends Tile
    {
        private final Piece pieceOnTile;

        private OccupiedTile(int position, Piece pieceOnTile)
        {
            super(position);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isEmpty()
        {
            return true;
        }

        @Override
        public Piece getPiece()
        {
            return this.pieceOnTile;
        }

    }

}
