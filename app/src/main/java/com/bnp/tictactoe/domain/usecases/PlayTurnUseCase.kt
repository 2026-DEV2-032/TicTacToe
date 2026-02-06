package com.bnp.tictactoe.domain.usecases

import com.bnp.tictactoe.domain.models.GameBoard
import com.bnp.tictactoe.domain.models.GameState
import com.bnp.tictactoe.domain.models.Player
import com.bnp.tictactoe.domain.rules.checkWinner

//rules ... if the winner is the first to align X on a larger board or the player which has the most number of combination set on a full board
//flexibility to change the
class PlayTurnUseCase() {

    operator fun invoke(board: GameBoard, x: Int, y: Int, player: Player): GameState {
        if (!board.isValidCell(x, y)) {
            return GameState(board = board, currentPlayer = player)
        }

        val newBord = board.takeCell(x, y, player.character)
        val checkWinner = checkWinner(board, player, x, y)
        val isBoardFull = board.isFull()
        val switchPlayer = player.switch()

        return GameState(
            board = newBord,
            currentPlayer = if (checkWinner == null) switchPlayer else player,
            isBoardFull = if (checkWinner == null) isBoardFull else false,
            winner = checkWinner
        )

    }
}
