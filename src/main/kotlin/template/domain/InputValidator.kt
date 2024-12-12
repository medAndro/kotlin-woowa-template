package template.domain

import template.resources.Messages.*

class InputValidator {
    fun validateInteger(input: String): Int {
        require(input.isNotBlank()) { EMPTY_INPUT.errorMessage() }
        return input.toIntOrNull() ?: throw IllegalArgumentException(NOT_INTEGER.errorMessage())
    }

    // 샘플 코드 모음
    private fun validateSplitInputText(input: String): List<String> {
        val splitInput = input.split(',')
        require(splitInput.all { element ->
            element.startsWith('[') && element.endsWith(']') && element.count { it == '-' } == 1
        }) { "각 입력은 대괄호로 시작하고 끝나야 하며 -를 1개 포함해야 합니다." }
        return splitInput
    }

    fun validateYN(input: String): Boolean {
        if (input.uppercase() == "Y") return true
        if (input.uppercase() == "N") return false

        throw IllegalArgumentException("Y혹은 N만 입력 가능합니다.")
    }

    // pair 사용
    private fun parseInputToMap(input: List<String>): Map<String, String> {
        val pairs =
            input.map { it.removeSurrounding("[", "]") }.map { it.split('-').let { parts -> parts[0] to parts[1] } }
        val keys = pairs.map { it.first }
        require(keys.size == keys.distinct().size) { "key는 중복될 수 없습니다." }

        return pairs.toMap()
    }

    fun validatePassword(password: String) {
        require(password.length >= 8) { "비밀번호는 8자 이상이어야 합니다" }
        require(password.any { it.isDigit() }) { "비밀번호는 숫자를 포함해야 합니다" }
        require(password.any { it.isUpperCase() }) { "비밀번호는 대문자를 포함해야 합니다" }
    }

    fun validateNames(input: List<String>) {
        require(input.size >= 2) { "전체 리스트는 2개 이상이여야 합니다" }
        require(input.size <= 5) { "전체 리스트는 5개 이상이여야 합니다" }
        require(input.size == input.distinct().size) { "리스트의 원소는 중복될 수 없습니다." }

        // 방법 1: all을 사용한 단일 검증
        require(input.all {
            it.isNotBlank() && it.length >= 2 && it.length <= 4
        }) { "이름 형식이 올바르지 않습니다" }

        // 방법 2: any 사용 (부정 조건)
        require(!input.any {
            it.isBlank() || it.length < 2 || it.length > 4
        }) { "이름 형식이 올바르지 않습니다" }

        // 방법 3: none 사용
        require(input.none {
            it.isBlank() || it.length < 2 || it.length > 4
        }) { "이름 형식이 올바르지 않습니다" }
    }
}