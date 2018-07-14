package space.personal.youssefalmkari.tictactoe.activity

import android.support.design.widget.Snackbar
import android.view.View

class HelloKotlin {

    fun displayMessage(view: View) {
        Snackbar.make(view, "HelloKotlin", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()


    }
}