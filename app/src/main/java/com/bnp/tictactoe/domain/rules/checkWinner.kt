package com.bnp.tictactoe.domain.rules

import com.bnp.tictactoe.domain.models.GameBoard
import com.bnp.tictactoe.domain.models.Player


data class WinCombination(val positions: List<Pair<Int, Int>>)

fun checkWinner(board: GameBoard, player: Player, x: Int, y: Int): Player? {
    val listPositionPlayerOnTheBoard = board.boardCells.flatMapIndexed { index, row ->
        row.mapIndexed { index2, cell ->
            if (cell == player.character) {
                Pair(index, index2)
            } else null
        }
    }.filterNotNull()

    val listCombination = mutableListOf<WinCombination>()
    val horizontalPossibility1 = WinCombination(listOf(Pair(x - 1, y), Pair(x + 1, y)))
    if (isInBoundaries(horizontalPossibility1, board)) {
        listCombination.add(horizontalPossibility1)
    }
    val horizontalPossibility2 = WinCombination(listOf(Pair(x + 1, y), Pair(x + 2, y)))
    if (isInBoundaries(horizontalPossibility2, board)) {
        listCombination.add(horizontalPossibility2)
    }
    val horizontalPossibility3 = WinCombination(listOf(Pair(x - 1, y), Pair(x - 2, y)))
    if (isInBoundaries(horizontalPossibility3, board)) {
        listCombination.add(horizontalPossibility3)
    }
    val verticalPossibility1 = WinCombination(listOf(Pair(x, y - 1), Pair(x, y + 1)))
    if (isInBoundaries(verticalPossibility1, board)) {
        listCombination.add(verticalPossibility1)
    }
    val verticalPossibility2 = WinCombination(listOf(Pair(x, y - 1), Pair(x, y - 2)))
    if (isInBoundaries(verticalPossibility2, board)) {
        listCombination.add(verticalPossibility2)
    }
    val verticalPossibility3 = WinCombination(listOf(Pair(x, y + 1), Pair(x, y + 2)))
    if (isInBoundaries(verticalPossibility3, board)) {
        listCombination.add(verticalPossibility3)
    }

    val diagonalLeftRightPossibility1 =
        WinCombination(listOf(Pair(x - 1, y - 1), Pair(x + 1, y + 1)))
    if (isInBoundaries(diagonalLeftRightPossibility1, board)) {
        listCombination.add(diagonalLeftRightPossibility1)
    }
    val diagonalLeftRightPossibility2 =
        WinCombination(listOf(Pair(x - 1, y - 1), Pair(x - 2, y - 2)))
    if (isInBoundaries(diagonalLeftRightPossibility2, board)) {
        listCombination.add(diagonalLeftRightPossibility2)
    }
    val diagonalLeftRightPossibility3 =
        WinCombination(listOf(Pair(x + 1, y + 1), Pair(x + 2, y + 2)))
    if (isInBoundaries(diagonalLeftRightPossibility3, board)) {
        listCombination.add(diagonalLeftRightPossibility3)
    }
    val diagonalRightLeftPossibility1 =
        WinCombination(listOf(Pair(x + 1, y - 1), Pair(x - 1, y + 1)))
    if (isInBoundaries(diagonalRightLeftPossibility1, board)) {
        listCombination.add(diagonalRightLeftPossibility1)
    }
    val diagonalRightLeftPossibility2 =
        WinCombination(listOf(Pair(x - 1, y - 1), Pair(x - 2, y - 2)))
    if (isInBoundaries(diagonalRightLeftPossibility2, board)) {
        listCombination.add(diagonalRightLeftPossibility2)
    }
    val diagonalRightLeftPossibility3 =
        WinCombination(listOf(Pair(x - 1, y + 1), Pair(x - 2, y + 2)))
    if (isInBoundaries(diagonalRightLeftPossibility3, board)) {
        listCombination.add(diagonalRightLeftPossibility3)
    }
    println("listCombination: $listCombination")
    println("listPositionPlayerOnTheBoard : $listPositionPlayerOnTheBoard")
    listCombination.forEach { winCombination ->
        if (winCombination.positions[0] in listPositionPlayerOnTheBoard &&
            winCombination.positions[1] in listPositionPlayerOnTheBoard
        ) {
            println("***: $winCombination winner = ${player.character}")
            return player
        }
    }
    println("***: No winner")

    return null
}

fun isInBoundaries(positions: WinCombination, board: GameBoard): Boolean {
    val test = positions.positions.all { (x, y) ->
        x in 0 until board.numberOfColumns && y in 0 until board.numberOfLines
    }
    print("isInBoundaries: $test for $positions")
    return test

}