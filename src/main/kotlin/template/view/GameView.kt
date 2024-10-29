package template.view

import camp.nextstep.edu.missionutils.Console
import template.resources.Messages

class GameView {
    // Input Views
    fun readLine(): String {
        return Console.readLine()
    }

    // Output Views
    fun showBlankLine() {
        println()
    }

    fun showMessage(message: String) {
        println(message)
    }

    fun showGameStart() {
        println(Messages.GAME_START)
    }

    companion object {
        fun showFormattedError(errorMessage: String) {
            println(Messages.ERROR_FORMAT.format(errorMessage))
        }
    }
}