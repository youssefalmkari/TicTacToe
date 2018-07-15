package space.personal.youssefalmkari.tictactoe

import android.support.design.widget.Snackbar
import android.view.View

/**
 * Kotlin Class
 */
class HelloKotlin(private var message: String) {

    constructor() : this("Hello Kotlin!!!")

    /**
     * Shows Snack Bar for a specific view
     */
    fun displayKotlinMessage(view: View) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }
}