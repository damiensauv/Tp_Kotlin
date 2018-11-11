package Gui

import mines.objects.Board
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.GridLayout
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities


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

private fun createAndShowGUI() {

    val frame = MainGui("Simple")
    val buttonPanel = JPanel()
    val containerPanel = JPanel()
    val board: Board = Board(10, 10)
    buttonPanel.layout = GridLayout(10, 10)

    var table: Array<Array<CellGui?>?>
    var tableX: Array<CellGui?>
    table = arrayOfNulls(10)

    val mines = board.mines

    // Init the gris of Game
    for (x in 0 until 10) {
        tableX = arrayOfNulls<CellGui>(10)

        for (y in 0 until 10) {
            val cg: CellGui = CellGui()

            cg.cellule  = mines[x]?.get(y)!!

            val but = JButton("")
            but.addMouseListener(object : MouseAdapter() {
                override fun mouseClicked(e: MouseEvent?) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        System.out.println("Left")
                        val b: JButton = e?.source as JButton

                    }
                    if (SwingUtilities.isRightMouseButton(e)) {
                        System.out.println("Rigth")
                    }
                }})

            cg.button = but
            tableX[y] = cg
        }

        table[x] = tableX
    }

    for (x in 0 until 10){
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