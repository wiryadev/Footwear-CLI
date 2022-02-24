package utils

object Validation {

    internal fun validate(input: String?, block: (String) -> Unit): Boolean {
        return input?.let { data ->
            if (data.isNotEmpty()) {
                validate(block, data)
            } else {
                false
            }
        } ?: false
    }

    private fun validate(block: (String) -> Unit, data: String): Boolean {
        return try {
            block.invoke(data)
            true
        } catch (e: Exception) {
            false
        }
    }

}