package template.domain

import template.model.DummyModel

class GameService {
    fun findWinnerNames(dummyModels: List<DummyModel>): List<String> {
        val maxDistance = dummyModels.maxOf { it.distance }
        val winners = dummyModels.filter { it.distance == maxDistance }

        return winners.map { it.name }
    }

    companion object {
        private const val MAX_RANDOM = 9
    }
}