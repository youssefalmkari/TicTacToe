package space.personal.youssefalmkari.tictactoe

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import space.personal.youssefalmkari.tictactoe.activity.HelloKotlin

/**
 * Primary View
 */
class MainActivity : AppCompatActivity() {

    /**
     * What happens when Activity is Created
     * -------------------------------------
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { view ->
            HelloKotlin().displayMessage(view)
        }
    }
}
