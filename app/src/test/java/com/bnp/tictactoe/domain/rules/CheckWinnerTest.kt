package com.bnp.tictactoe.domain.rules

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import com.bnp.tictactoe.domain.models.Player
import com.bnp.tictactoe.domain.usecases.PlayTurnUseCase
import com.bnp.tictactoe.firstCellFreePositionBoard
import com.bnp.tictactoe.secondCellFreePositionBoard
import org.junit.Test

class CheckWinnerTest {
    private lateinit var playTurnUseCase: PlayTurnUseCase


    //fun checkWinner(board: GameBoard, player: Player, x: Int, y: Int): Player? {
    @Test
    fun `when the x player fills the first cell row, the winner is x`() {
        val board = firstCellFreePositionBoard()
        print("board before: ${board}\n")
        val player = Player('X')
        playTurnUseCase = PlayTurnUseCase()
        val gameState = playTurnUseCase(board, 0, 0, player)
        print("board after: ${gameState.board}\n")
        assertThat(gameState.winner).isEqualTo(player)
    }

    @Test
    fun `when the x player fills not the last cell, the winner is null`() {
        val board = firstCellFreePositionBoard()
        print("board before: ${board}\n")
        val player = Player('X')
        playTurnUseCase = PlayTurnUseCase()
        val gameState = playTurnUseCase(board, 2, 2, player)
        print("board after: ${gameState.board}\n")
        assertThat(gameState.winner).isNull()
    }

    //@Test
    // TODO: need to refactor the test and the logic
    fun `when the x player fills the first row second column, the winner is x`() {
        val board = secondCellFreePositionBoard()
        print("board before: ${board}\n")
        val player = Player('X')
        playTurnUseCase = PlayTurnUseCase()
        val gameState = playTurnUseCase(board, 1, 0, player)
        print("board after: ${gameState.board}\n")
        assertThat(gameState.winner).isEqualTo(player)
    }

    //@Test
    // TODO: need to refactor the test and the logic
    fun `test isInBoundaries`() {
        val x = 1
        var y = 0
        var horizontalPossibility = WinCombination(listOf(Pair(x - 1, y), Pair(x + 1, y)))
        val board = secondCellFreePositionBoard()
        assertThat(isInBoundaries(horizontalPossibility, board)).isEqualTo(true)
        y = 1
        horizontalPossibility = WinCombination(listOf(Pair(x + 1, y), Pair(x + 2, y)))
        //if (isInBoundaries(horizontalPossibility, board)) {}
    }

}