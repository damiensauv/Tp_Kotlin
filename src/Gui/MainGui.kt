package Gui

import java.awt.Dimension
import java.awt.EventQueue
import java.awt.GridLayout
import java.awt.event.MouseListener
import java.awt.event.MouseAdapter
import com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener
import java.awt.event.MouseEvent
import com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener
import javax.swing.*


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
       val but = JButton(i.toString())
        but.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {

                if ( SwingUtilities.isLeftMouseButton(e) ){
                    System.out.println("Left")
                }
                if ( SwingUtilities.isRightMouseButton(e) ){
                    System.out.println("Rigth")
                }

            }
        })

        buttonPanel.add(but)
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