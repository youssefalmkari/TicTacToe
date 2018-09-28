package space.personal.youssefalmkari.tictactoe

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
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

    // Holds the TableLayout View
    private var tableLayout: TableLayout? = null

    // Displays who's turn it is
    var turnTextView: TextView? = null

    // Represents a 3x3 matrix simulating the Board
    private var gameBoard: Array<CharArray> = Array(3) { CharArray(3) }

    // Value of current turn
    var turn: Char = 'X'


    /**
     * What happens when Activity is Created
     * -------------------------------------
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        turnTextView = findViewById(R.id.turnTextView)
        tableLayout = findViewById(R.id.table_layout)

        // New Game
        startNewGame(true)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Floating Action Button
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            HelloKotlin("Get ready for a fun game of Tic Tac Toe").displayKotlinMessage(view)
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
     * -----------------
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
                }
            }

        }
    }

    /**
     * What happens when Board Cell is clicked
     * ---------------------------------------
     */
    private fun cellClickListener(row: Int, column: Int) {
        ((tableLayout?.getChildAt(row) as TableRow)
                .getChildAt(column) as TextView).text = turn.toString()

        gameBoard[row][column] = turn

        turn = if ('X' == turn) 'O' else 'X'
        turnTextView?.text = String.format(getString(R.string.turn), turn)

        checkGameStatus()
    }

    /**
     * Checks if Game Board is full
     * ----------------------------
     */
    private fun isBoardFull(gameBoard: Array<CharArray>): Boolean {

        // Row
        for (i in 0 until gameBoard.size) {
            // Column
            for (j in 0 until gameBoard[i].size) {
                // A cell is empty
                if (gameBoard[i][j] == ' ')
                    return false
            }
        }

        // All Cells in Board are filled
        return true
    }

    /**
     * Checks if there is a winner
     * ---------------------------
     */
    private fun isWinner(gameBoard: Array<CharArray>, w: Char): Boolean {
        for (i in 0 until gameBoard.size) {

            // Horizontal
            if (gameBoard[i][0] == w && gameBoard[i][1] == w && gameBoard[i][2] == w) {
                return true
            }

            // Vertical
            if (gameBoard[0][i] == w && gameBoard[1][i] == w && gameBoard[2][i] == w) {
                return true
            }

            // Diagonal
            if (gameBoard[0][0] == w && gameBoard[1][1] == w && gameBoard[2][2] == w
                    || gameBoard[0][2] == w && gameBoard[1][1] == w && gameBoard[2][0] == w) {
                return true
            }
        }

        return false
    }

    /**
     * Checks current game status
     * --------------------------
     */
    private fun checkGameStatus() {
        println("INSIDE checkGameStatus")
        var state: String? = null

        if (isWinner(gameBoard, 'X')) { // X won
            state = String.format(resources.getString(R.string.winner), 'X')
            println("X is Winner - STATE: $state")
        } else if (isWinner(gameBoard, 'O')) { // O won
            state = String.format(resources.getString(R.string.winner), 'O')
            println("O is Winner - STATE: $state")
        } else { // Draw
            if (isBoardFull(gameBoard)) {
                state = resources.getString(R.string.draw)
                println("DRAW - STATE: $state")
            }
        }

        println("STATE after all conditions: $state")
        if (state != null) {
            turnTextView?.text = state
            val builder = AlertDialog.Builder(this)
            builder.setMessage(state)
            builder.setPositiveButton(android.R.string.ok,
                    { dialog, id -> startNewGame(false) })
            val dialog = builder.create()
            dialog.show()
        }
    }
}
