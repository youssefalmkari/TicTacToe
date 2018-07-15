package space.personal.youssefalmkari.tictactoe

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TableLayout
import android.widget.TextView

/**
 * Primary View
 */
class MainActivity : AppCompatActivity() {

    /**
     * Holds the TableLayout View
     */
    var tableLayout: TableLayout? = null
    /**
     * Displays who's turn it is
     */
    var turnTextView: TextView? = null
    /**
     * Represents a 3x3 matrix simulating the Board
     */
    var gameBoard: Array<CharArray> = Array(3) { CharArray(3) }
    /**
     * Value of current turn
     */
    var turn = 'X'


    /**
     * What happens when Activity is Created
     * -------------------------------------
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Toolbar
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // Floating Action Button
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            HelloKotlin("Get ready for a fun game of Tic Tac Toe")
                    .displayKotlinMessage(view)
        }
    }

    /**
     * Inflate the Menu; this adds items to the action bar if it is
     * present.
     * ------------------------------------------------------------
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /**
     * Handle action bar item clicks here. The action bar will
     * automatically handle clicks on th Home/Up button, so long
     * as you specify a parent activity in AndroidManifest.xml.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }


}
