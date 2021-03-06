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

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.PieceMoveStrategy;
import pl.art.lach.mateusz.openchess.core.pieces.strategies.MoveStrategyFactory;

/**
 * @author: Mateusz Sławomir Lach 
 */
public class KingTest extends PieceTest {

    private King whiteKing = new King(Color.WHITE);

    private King blackKing = new King(Color.BLACK);
    
    
    @Test
    public void kingValueTest() {
        assertEquals(100, whiteKing.getValue());
    }
    
    @Test
    public void kingSymbolTest() {
        assertEquals('K', whiteKing.getSymbol());
    }
    
    @Test
    public void kingShouldUseOneStrategyTest() {
        PieceMoveStrategy kingStrategy = new MoveStrategyFactory().getKingStrategy();
        Field field = Field.getEmptyField(Field.Letter._E, Field.Number._1);
        assertContainsAllFieldsAsStrategy(whiteKing, kingStrategy, field);
        assertContainsAllFieldsAsStrategy(blackKing, kingStrategy, field);
    }
}
