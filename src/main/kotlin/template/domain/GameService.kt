package template.domain

import template.model.NumberBasket

class GameService {
    fun plusTwoNumber(numberBasket: NumberBasket): Int {
        return numberBasket.getNumbers().sum()
    }

    fun getExpression(numberBasket: NumberBasket): String {
        return numberBasket.getNumbers().joinToString(separator = " + ")
    }
}