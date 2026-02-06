package com.bnp.tictactoe.presentation.mappers

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.bnp.tictactoe.domain.models.GameBoard
import com.bnp.tictactoe.fullBoard
import com.bnp.tictactoe.fullBoardMapped
import com.bnp.tictactoe.presentation.BoardItem
import org.junit.Test

class UiBoardMapperTest {

    @Test
    fun `map game board from a full board to ui board`() {
        val board = fullBoard()
        print("board before: ${board}\n")

        val uiBoard = board.toBoardUi()
        assertThat(uiBoard.boardListItem.size).isEqualTo(9)
        assertThat(uiBoard.boardListItem[0]).isEqualTo(BoardItem(1, 'O'))
        assertThat(uiBoard.boardListItem[4]).isEqualTo(BoardItem(5, 'O'))
        assertThat(uiBoard.boardListItem[8]).isEqualTo(BoardItem(9, 'X'))
        assertThat(uiBoard).isEqualTo(fullBoardMapped())
    }

    @Test
    fun `map game board from an empty board to ui board`() {
        val board = GameBoard(
            4, 4
        )

        val uiBoard = board.toBoardUi()
        assertThat(uiBoard.boardListItem.size).isEqualTo(16)
        assertThat(uiBoard.boardListItem[0]).isEqualTo(BoardItem(1, null))
        assertThat(uiBoard.boardListItem[15]).isEqualTo(BoardItem(16, null))
    }

}