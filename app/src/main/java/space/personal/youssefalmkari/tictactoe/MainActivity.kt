package space.personal.youssefalmkari.tictactoe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

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
