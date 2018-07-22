package space.personal.youssefalmkari.tictactoe

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

/**
 * Primary View
 */
class MainActivity : AppCompatActivity() {

    /**
     * Holds the TableLayout View
     */
    private var tableLayout: TableLayout? = null
    /**
     * Displays who's turn it is
     */
    var turnTextView: TextView? = null
    /**
     * Represents a 3x3 matrix simulating the Board
     */
    private var gameBoard: Array<CharArray> = Array(3) { CharArray(3) }
    /**
     * Value of current turn
     */
    var turn: Char = 'X'


    /**
     * What happens when Activity is Created
     * -------------------------------------
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        turnTextView = findViewById(R.id.turnTextView) as TextView
        tableLayout = findViewById(R.id.table_layout) as TableLayout

        // New Game
        startNewGame(true)

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
     * ---------------------------------------------------------
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    /**
     * Begins a new game
     */
    private fun startNewGame(setClickListener: Boolean) {
        turn = 'X'
        turnTextView?.text = String.format(getString(R.string.turn), turn)

        // Row
        for (i in 0 until gameBoard.size) {
            // Column
            for (j in 0 until gameBoard[i].size) {
                gameBoard[i][j] = ' '
                val cell = (tableLayout?.getChildAt(i) as TableRow).getChildAt(j) as TextView
                cell.text = ""

                if (setClickListener) {
                    cell.setOnClickListener { cellClickListener(i, j) }
                    // Check if game has a winner
                }
            }
        }
    }

    /**
     * What happens when Board Cell is clicked
     */
    private fun cellClickListener(row: Int, column: Int) {
        gameBoard[row][column]
        ((tableLayout?.getChildAt(row) as TableRow)
                .getChildAt(column) as TextView).text = turn.toString()
        turn = if ('X' == turn) 'O' else 'X'
        turnTextView?.text = String.format(getString(R.string.turn), turn)
    }

    private fun isBoardFull(gameBoard: Array<CharArray>): Boolean {

        // Row
        for (i in 0 until gameBoard.size) {
            // Column
            for (j in 0 until gameBoard[i].size) {
                // A cell is empty
                if (gameBoard[i][j] == ' ') return false
            }
        }

        // All Cells in Board are filled
        return true
    }

    private fun isWinner(gameBoard: Array<CharArray>, w: Char): Boolean {
        return false
    }

    private fun checkGameStatus() {
        var state: String? = null
    }
}
