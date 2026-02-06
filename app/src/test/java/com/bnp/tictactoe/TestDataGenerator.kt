package com.bnp.tictactoe

import com.bnp.tictactoe.domain.models.GameBoard
import com.bnp.tictactoe.presentation.BoardItem
import com.bnp.tictactoe.presentation.UiGameBoard

fun middleOfTheGameBoard(): GameBoard {
    return GameBoard(
        3, 3, arrayOf(
            arrayOf(null, null, null),
            arrayOf(null, 'X', 'O'),
            arrayOf('O', 'X', null)
        )
    )
}

fun firstCellFreePositionBoard(): GameBoard {
    return GameBoard(
        3, 3,
        arrayOf(
            arrayOf(null, 'O', 'X'),
            arrayOf('O', 'X', 'O'),
            arrayOf('O', 'O', 'X')
        )
    )
}

fun secondCellFreePositionBoard(): GameBoard {
    return GameBoard(
        3, 3,
        arrayOf(
            arrayOf('X', null, 'X'),
            arrayOf(null, null, null),
            arrayOf(null, null, null)
        )
    )
}

fun fullBoard(): GameBoard {
    return GameBoard(
        3, 3, arrayOf(
            arrayOf('O', 'O', 'X'),
            arrayOf('X', 'O', 'O'),
            arrayOf('X', 'O', 'X')
        )
    )
}

fun fullBoardMapped(): UiGameBoard {
    return UiGameBoard(
        listOf(
            BoardItem(1, 'O'),
            BoardItem(2, 'O'),
            BoardItem(3, 'X'),
            BoardItem(4, 'X'),
            BoardItem(5, 'O'),
            BoardItem(6, 'O'),
            BoardItem(7, 'X'),
            BoardItem(8, 'O'),
            BoardItem(9, 'X'),
        )
    )
}

fun emptyBoard(): GameBoard {
    return GameBoard(
    )
}