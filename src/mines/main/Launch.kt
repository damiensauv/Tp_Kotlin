package mines.main

import mines.objects.Board

fun main(args: Array<String>) {
	val b : Board = Board(5, 5)
	b.initBoard();
	println(b.toString());
}