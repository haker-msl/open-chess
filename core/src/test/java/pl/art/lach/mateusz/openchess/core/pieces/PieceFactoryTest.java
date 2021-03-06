/*
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pl.art.lach.mateusz.openchess.core.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class PieceFactoryTest {
    
    private PieceFactory pieceFactory = new PieceFactory();

    @Test
    public void createPawnWhiteTest() {
        Piece pawn = pieceFactory.getPawnInstance(Color.WHITE);
        assertTrue(pawn instanceof Piece);
        assertEquals(1, pawn.getValue());
        assertEquals(Color.WHITE, pawn.getColor());
    }
    
    @Test
    public void createPawnBlackTest() {
        Piece pawn = pieceFactory.getPawnInstance(Color.BLACK);
        assertTrue(pawn instanceof Piece);
        assertEquals(1, pawn.getValue());
        assertEquals(Color.BLACK, pawn.getColor());
    }
    
    @Test
    public void createKingWhiteTest() {
        Piece king = pieceFactory.getKingInstance(Color.WHITE);
        assertEquals(100, king.getValue());
        assertEquals(Color.WHITE, king.getColor());
    }
    
    @Test
    public void createKingBlackTest() {
        Piece king = pieceFactory.getKingInstance(Color.BLACK);
        assertEquals(100, king.getValue());
        assertEquals(Color.BLACK, king.getColor());
    }
    
    @Test
    public void createRookBlackTest() {
        Piece rook = pieceFactory.getRookInstance(Color.BLACK);
        assertEquals(5, rook.getValue());
        assertEquals(Color.BLACK, rook.getColor());
    }
    
    @Test
    public void createRookWhiteTest() {
        Piece rook = pieceFactory.getRookInstance(Color.WHITE);
        assertEquals(5, rook.getValue());
        assertEquals(Color.WHITE, rook.getColor());
    }
}
