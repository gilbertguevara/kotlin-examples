class SealedClasses {
    sealed class UIState {
        data object Loading : UIState()
        data class Success(val data: String) : UIState()
        data class Error(val exception: Exception) : UIState()
    }

    private fun updateUI(state: UIState) {
        when (state) {
            is UIState.Loading -> showLoadingIndicator()
            is UIState.Success -> showData(state.data)
            is UIState.Error -> showError(state.exception)
        }
    }

    private fun showLoadingIndicator() {
        println("Loading...")
    }

    private fun showData(data: String) {
        println("Data: $data")
    }

    private fun showError(exception: Exception) {
        println("Error: $exception")
    }

    fun test() {
        updateUI(UIState.Loading)
        updateUI(UIState.Error(IllegalStateException("Illegal state")))
        updateUI(UIState.Success("Some data"))
    }
}

fun main() {
    SealedClasses().test()
}