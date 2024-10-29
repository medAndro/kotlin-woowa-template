package template.domain

import template.resources.Messages
import template.view.GameView

class InputValidator {
    fun commaStringValidate(input: String) {
        require(input.isNotBlank()) {
            GameView.showFormattedError(Messages.ERROR_EMPTY_INPUT)
            Messages.ERROR_EMPTY_INPUT
        }
        val elements = input.split(",")
        require(elements.size == elements.distinct().size) { Messages.ERROR_DUPLICATE_NAME }
    }

    fun numberValidate(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT }
        require(input.length < 9) { Messages.ERROR_OVERSIZE_TRY_COUNT }
        val number = runCatching { input.toInt() }
            .getOrElse { throw IllegalArgumentException(Messages.ERROR_NOT_POSITIVE) }
        require(number > 0) { Messages.ERROR_NOT_POSITIVE }
    }
}