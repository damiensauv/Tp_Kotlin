package mines.main

import mines.objects.Board
import java.util.Scanner

fun main(args: Array<String>) {
	val b : Board = Board(12, 12)
	b.toString()
	println()
	
	while(!b.isWin() || !b.isLost()) {
		println("Quelle case à ouvrir ?")
		
		val sc = Scanner(System.`in`)
		
		print("X : ")
		val inputX : kotlin.Int = sc.nextInt()
		if(inputX < 0 || inputX > 7) {
			break
		}
		
		print("Y : ")
		val inputY : kotlin.Int = sc.nextInt()
		if(inputY < 0 || inputY > 7) {
			break
		}
		
		println()
		//b.clickCellule(inputX, inputY)
		
		if(b.isWin()) {
			println("Bravo !")
			break;
		} else if(b.isLost()) {
			println("Perdu !")
			break;
		}
	}
}