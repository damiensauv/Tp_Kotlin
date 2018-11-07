package Gui

import java.awt.Dimension
import java.awt.EventQueue
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
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

private fun createAndShowGUI() {

    val frame = MainGui("Simple")

    val buttonPanel = JPanel()
    val containerPanel = JPanel()
    buttonPanel.layout = GridLayout(10, 10)

    for (i in 0..99) {
        buttonPanel.add(JButton(""))
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