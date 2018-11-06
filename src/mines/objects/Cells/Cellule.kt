package mines.objects.Cells

abstract class Cellule {
	abstract var posX : kotlin.Int
	abstract var posY : kotlin.Int
	abstract var toPrint : kotlin.String
}

data class Vide (
	override var posX : kotlin.Int,
	override var posY : kotlin.Int,
	override var toPrint : kotlin.String = " "
) : Cellule()

data class Nombre (
	override var posX : kotlin.Int,
	override var posY : kotlin.Int,
	override var toPrint : kotlin.String
) : Cellule()

data class Mine (
	override var posX : kotlin.Int,
	override var posY : kotlin.Int,
	override var toPrint : kotlin.String = "*"
) : Cellule()