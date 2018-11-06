package mines.objects

import mines.objects.Cells.Cellule
import mines.objects.Cells.Mine
import mines.objects.Cells.Nombre
import mines.objects.Cells.Vide

data class Board(val sizeX: kotlin.Int, val sizeY: kotlin.Int) {			
	
	var mines: Array<Array<Cellule?>?> = this.initBoard()
	
	/**
	 * initBoard() : initialise le plateau en créant des sizeX * sizeY cellules.
	 * Celles-ci peuvent être des mines, des cellules vides ou des cellules chiffres
	 */
	
	fun initBoard(): Array<Array<Cellule?>?> {
		var tableX : Array<Cellule?>
		var table : Array<Array<Cellule?>?>
				
		table = arrayOfNulls<Array<Cellule?>>(this.sizeX)
		
		for(x in 0..this.sizeX-1) {
			tableX = arrayOfNulls<Cellule>(this.sizeY)
			for (y in 0..this.sizeY-1) {
				val random = (1..4).random();
				when {
					// Random = 1 -> Nombre
					random in 1..3 -> tableX.set(y, Nombre(x, y, "0"))
					// Random = 2 -> Mine
					else -> tableX.set(y, Mine(x, y))
				}
			}
			table.set(x, tableX)
		}
		
		mines = table
		
		for(x in 0..this.sizeX - 1) {
			for(y in 0..this.sizeY - 1) {
				if(mines.get(x)?.get(y)?.toPrint == "0") {
					computeVoisins(x, y)
				}
			}
		}
		
		return table;
	}
	
	/**
	 * computeVoisins(posX : int, posY : int) : calcule le nombre de mines sur les cases
	 * voisines d'une Cellule de type Nombre
	 *
	 * Exemple (X = case étudiée, M = mine, C = cellule)
	 *
	 * M C M
	 * M X C
	 * C C M --> computeVoisins = 4
	 */
	fun computeVoisins(posX : kotlin.Int, posY : kotlin.Int) {
		var nbMines : kotlin.Int = 0;
		
		for(x in posX-1..posX+1) {
			for(y in posY-1..posY+1) {
				if(x < 0 || x >= this.sizeX || y < 0 || y >= this.sizeY) {
					continue
				} else {
					if(mines.get(x)?.get(y)?.toPrint == "*") {
						nbMines++
					}
				}
			}
		} 
		
		if(nbMines == 0) {
			mines.get(posX)?.set(posY, Vide(posX, posY))
		} else {
			mines.get(posX)?.set(posY, Nombre(posX, posY, nbMines.toString()))
		}
	}
	
	/**
	 * toString() : réécriture de la fonction toString
	 * Affiche une copie du plateau
	 */
	override fun toString() : String {
		for(posX in 0..this.sizeX-1) {
			for(posY in 0..this.sizeY - 1) {
				print("|")
				print(mines.get(posX)?.get(posY)?.toPrint)	
				print("|")
			}
			println()
		}
		return "";
	}
}