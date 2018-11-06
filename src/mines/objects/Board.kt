package mines.objects

import mines.objects.Cells.Cellule
import mines.objects.Cells.Mine
import mines.objects.Cells.Nombre
import mines.objects.Cells.Vide

data class Board(val sizeX: kotlin.Int, val sizeY: kotlin.Int) {			
	
	val mines: Array<Array<Cellule?>?> = this.initBoard()
	
	fun createMine(posX: kotlin.Int, posY: kotlin.Int) : Cellule {
		val mine : Cellule = Mine(posX, posY)
		return mine
	}
	
	fun createCell(posX: kotlin.Int, posY: kotlin.Int) : Cellule {
		val cellule : Cellule = Vide(posX, posY) 
		return cellule
	}
	
	fun createNombre(posX: kotlin.Int, posY: kotlin.Int) : Cellule {
		val nombre : Nombre = Nombre(posX, posY, "0")
		return nombre;
	}
	
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
				val random = (1..2).random();
				when {
					// Random = 1 -> Nombre
					random == 1 -> tableX.plusElement(Nombre(x, y, "0"))
					// Random = 2 -> Mine
					random == 2 -> tableX.plusElement(Mine(x, y))
				}
			}
			table.plusElement(tableX)
		}
		
		return table;
	}
	
	override fun toString() : String {
		val strLine : String = ""
		val strResult : String = ""
		
		for(posX in 0..this.sizeX-1) {
			for(posY in 0..this.sizeY-1) {
				strLine.plus("|");
				var c : Cellule? = mines.get(posX)?.get(posY)
				strLine.plus(c!!.toPrint)
				strLine.plus("|");
			}
			strLine.plus("\n")
			strResult.plus(strLine);
		}
		
		return strResult;
	}
	
	inline fun <reified L : Any, reified R : Any> isSubClassOf(): Boolean {
		return R::class.java.isAssignableFrom(L::class.java)
	}
	
	/*fun getCell(posX: kotlin.Int, posY: kotlin.Int) : Mine {
		
	}*/
}