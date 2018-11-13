package Gui

import mines.objects.Board
import java.awt.Color
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.GridLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.*
import javax.swing.JOptionPane
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel




class MainGui(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(800, 800)
        setLocationRelativeTo(null)
    }
}

private fun updateGui(board: Board, table: Array<Array<CellGui?>?>) {

    val mines = board.mines

    for (x in 0 until 10) {
        for (y in 0 until 10) {
            if (mines[x]?.get(y)!!.visible && mines[x]?.get(y)!!.toPrint != "*") {
                table.get(x)?.get(y)?.button?.text = mines[x]?.get(y)?.toPrint
                table.get(x)?.get(y)?.button?.background = Color.WHITE
            } else if (mines[x]?.get(y)!!.flag) {
                table.get(x)?.get(y)?.button?.background = Color.GREEN
            } else if (mines[x]?.get(y)!!.toPrint == "*" && board.isLost()) {
                table.get(x)?.get(y)?.button?.background = Color.RED
            }
        }
    }
}

private fun dialog(msg: String, frame: MainGui) {

    val options1 = arrayOf<Any>("Rejouer", "Quittez")

    val panel = JPanel()
    panel.add(JLabel("$msg voulez-vous recommencez ?"))

    val result = JOptionPane.showOptionDialog(
        null, panel, "Enter a Number",
        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        options1, null
    )

    if (result == JOptionPane.YES_OPTION) {
        frame.dispose()
        createAndShowGUI()
    } else if (result == JOptionPane.NO_OPTION) {
        System.exit(0);
    }
}

private fun createAndShowGUI() {

    val frame = MainGui("Simple")
    val buttonPanel = JPanel()
    val containerPanel = JPanel()
    val board = Board(10, 10)
    buttonPanel.layout = GridLayout(10, 10)

    val table: Array<Array<CellGui?>?>
    var tableX: Array<CellGui?>
    table = arrayOfNulls(10)

    val mines = board.mines

    // Init the gris of Game
    for (x in 0 until 10) {
        tableX = arrayOfNulls(10)

        for (y in 0 until 10) {
            val cg = CellGui()

            cg.cellule = mines[x]?.get(y)!!

            val but = JButton("")
            but.addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(e: MouseEvent?) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        board.clickCellule(x, y)
                        updateGui(board, table)

                        if (board.isWin()) {
                            dialog("Gagnée", frame)
                        } else if (board.isLost()) {
                            dialog("Perdu", frame)
                        }
                    }
                    if (SwingUtilities.isRightMouseButton(e)) {
                        board.flagCellule(x, y)
                        updateGui(board, table)
                    }
                }
            })

            cg.button = but
            tableX[y] = cg
        }

        table[x] = tableX
    }

    for (x in 0 until 10) {
        for (y in 0 until 10) {
            buttonPanel.add(table.get(x)?.get(y)?.button)
        }
    }

    buttonPanel.preferredSize = Dimension(800, 800)
    containerPanel.add(buttonPanel)

    frame.contentPane.add(containerPanel)
    frame.pack()
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}