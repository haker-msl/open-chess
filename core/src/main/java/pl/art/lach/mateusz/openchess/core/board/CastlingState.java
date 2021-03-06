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
package pl.art.lach.mateusz.openchess.core.board;

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field.Letter;
import pl.art.lach.mateusz.openchess.core.board.Field.Number;

/**
 * @author: Mateusz Sławomir Lach 
 */
final class CastlingState {

    private final boolean leftRookWasMoved;
    
    private final boolean rightRookWasMoved;
    
    private final boolean kingWasMoved;
    
    private CastlingState(boolean leftRookMotioned, boolean rightRookMotioned, boolean kingMotioned) {
        this.leftRookWasMoved = leftRookMotioned;
        this.rightRookWasMoved = rightRookMotioned;
        this.kingWasMoved = kingMotioned;
    }
    
    static CastlingState getInitialState() {
        return new CastlingState(false, false, false);
    }
    
    CastlingState setLeftRookMotioned() {
        return new CastlingState(true, rightRookWasMoved, kingWasMoved);
    }

    CastlingState setRightRookMoved() {
        return new CastlingState(leftRookWasMoved, true, kingWasMoved);
    }
    
    CastlingState setKingMoved() {
        return new CastlingState(leftRookWasMoved, rightRookWasMoved, true);
    }
    
    boolean isRightCastlingPossible(final Board board, final Color color) {
        if (Color.WHITE == color 
                && isKingOrRookRelocated(board, Letter._H, Number._1, Letter._E, Number._1)) {
            return false;
        } else if (Color.BLACK == color 
                && isKingOrRookRelocated(board, Letter._H, Number._8, Letter._E, Number._8)) {
            return false;
        } 
        return !rightRookWasMoved && !kingWasMoved;
    }
    
    boolean isLeftCastlingPossible(final Board board, final Color color) {
        if (Color.WHITE == color 
                && isKingOrRookRelocated(board, Letter._A, Number._1, Letter._E, Number._1)) {
            return false;
        } else if (Color.BLACK == color 
                && isKingOrRookRelocated(board, Letter._H, Number._8, Letter._E, Number._8)) {
            return false;
        } 
        return !leftRookWasMoved && !kingWasMoved;
    }

    private boolean isKingOrRookRelocated(Board board, Letter rookLetter, 
            Number rookNumber, Letter kingLetter, Number kingNumber) {
        return board.getField(rookLetter, rookNumber).isEmpty()
               || board.getField(kingLetter, kingNumber).isEmpty();
    }
    
    
}
