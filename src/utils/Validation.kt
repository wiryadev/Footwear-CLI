package utils

object Validation {

    internal fun validate(input: String?, block: (String) -> Boolean): Boolean {
        return input?.let { data ->
            if (data.isNotEmpty()) {
                validate(block, data)
            } else {
                false
            }
        } ?: false
    }

    private fun validate(block: (String) -> Boolean, data: String): Boolean {
        return try {
            block.invoke(data)
        } catch (e: Exception) {
            false
        }
    }

}