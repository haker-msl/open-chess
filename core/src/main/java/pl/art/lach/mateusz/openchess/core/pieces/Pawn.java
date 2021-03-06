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

import pl.art.lach.mateusz.openchess.core.Color;
import pl.art.lach.mateusz.openchess.core.board.Field;

/**
 * @author: Mateusz Sławomir Lach 
 */
class Pawn extends Piece {
    
    private static final char EMPTY_SYMBOL = '\0';

    Pawn(final Color color) {
        super(1, EMPTY_SYMBOL, color);
        getStrategies().add(getStrategyFactory().getPawnStrategy());
    }

    boolean wasShiftedByTwoFields(Field from, Field to) {
        int fromNumber = from.getNumber().ordinal();
        int toNumber = to.getNumber().ordinal();
        return Math.abs(fromNumber - toNumber) == 2;
    }

}
