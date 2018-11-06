package mines.main

import mines.objects.Board
import java.util.Scanner

fun main(args: Array<String>) {
	val b : Board = Board(8, 8)
	
	while(!b.isWin() || !b.isLost()) {
		b.toString()
		println()
		
		println("Quelle case à ouvrir ?")
		
		val sc = Scanner(System.`in`)
		
		print("X : ")
		val inputX : kotlin.Int = sc.nextInt()
		if(inputX < 0 || inputX > b.sizeX) {
			break
		}
		
		print("Y : ")
		val inputY : kotlin.Int = sc.nextInt()
		if(inputY < 0 || inputY > b.sizeY) {
			break
		}
		
		println()
		b.clickCellule(inputX, inputY)
		
		if(b.isWin()) {
			println("Bravo !")
			
			println()
			println()
			b.toString()
			break;
		} else if(b.isLost()) {
			println("Perdu !")
			
			println()
			println()
			b.toString()	
			break;
		}
	}
}