package pl.art.lach.mateusz.openchess.core.pieces.strategies;

import java.util.Set;

import org.junit.Test;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Board;
import pl.art.lach.mateusz.openchess.core.board.Field;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class BishopStrategyTest {
    
    private final PieceMoveStrategy bishopStrategy = new BishopStrategy();

    @Test
    public void bishopFieldsInRangeTest_C4() {
        Field fieldC4 = Field.getEmptyField(Letter._C, Number._4);
        Board board = Board.getEmptyBoard();
        final Set<Field> fields = bishopStrategy.getAllFieldsInRange(board, fieldC4, Color.WHITE);
        
        Field fieldB5 = Field.getEmptyField(Letter._B, Number._5);
        Field fieldA6 = Field.getEmptyField(Letter._A, Number._6);
        
        Field fieldD5 = Field.getEmptyField(Letter._D, Number._5);
        Field fieldE6 = Field.getEmptyField(Letter._E, Number._6);
        Field fieldF7 = Field.getEmptyField(Letter._F, Number._7);
        Field fieldG8 = Field.getEmptyField(Letter._G, Number._8);
        
        Field fieldB3 = Field.getEmptyField(Letter._B, Number._3);
        Field fieldA2 = Field.getEmptyField(Letter._A, Number._2);
        
        Field fieldD3 = Field.getEmptyField(Letter._D, Number._3);
        Field fieldE2 = Field.getEmptyField(Letter._E, Number._2);
        Field fieldF1 = Field.getEmptyField(Letter._F, Number._1);
        
        assertThat(fields, hasItems(fieldB5, fieldA6));
        assertThat(fields, hasItems(fieldD5, fieldE6, fieldF7, fieldG8));
        assertThat(fields, hasItems(fieldB3, fieldA2));
        assertThat(fields, hasItems(fieldD3, fieldE2, fieldF1));
        
     }

}
