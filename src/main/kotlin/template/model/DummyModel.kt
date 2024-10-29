package template.model

data class DummyModel(
    val name: String,
    var distance: Int = 0
) {
    fun moveForward() {
        distance += 1
    }
}