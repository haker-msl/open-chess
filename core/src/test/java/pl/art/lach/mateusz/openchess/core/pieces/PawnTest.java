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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceMoveStrategy;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.MoveStrategyFactory;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class PawnTest extends PieceTest {
    
    private Pawn whitePawn = new Pawn(Color.WHITE);
    
    private Pawn blackPawn = new Pawn(Color.WHITE);

    @Test
    public void wasShiftedByTwoFieldsTest() {
        
        Field from = Field.getEmptyField(Field.Letter._A, Field.Number._7);
        Field to = Field.getEmptyField(Field.Letter._A, Field.Number._5);
        
        assertTrue(whitePawn.wasShiftedByTwoFields(from, to));
    }
    
    @Test
    public void wasntShiftedByTwoFieldsTest() {
        
        Field from = Field.getEmptyField(Field.Letter._A, Field.Number._7);
        Field to = Field.getEmptyField(Field.Letter._A, Field.Number._6);
        
        assertFalse(whitePawn.wasShiftedByTwoFields(from, to));
    }

    
    @Test
    public void pawnValueTest() {
        
        assertEquals(1, whitePawn.getValue());
    }
    
    @Test
    public void pawnShouldUseOneStrategyTest() {
        PieceMoveStrategy pawnStrategy = new MoveStrategyFactory().getPawnStrategy();
        Field field = Field.getEmptyField(Field.Letter._A, Field.Number._2);
        assertContainsAllFieldsAsStrategy(whitePawn, pawnStrategy, field);
        assertContainsAllFieldsAsStrategy(blackPawn, pawnStrategy, field);
    }
}
