package template

import template.controller.GameController

fun main() {
    val game = GameController.create()
    game.gameStart()
}
