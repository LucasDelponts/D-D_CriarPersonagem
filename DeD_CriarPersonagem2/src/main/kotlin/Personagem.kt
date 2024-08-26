package org.example

class Personagem(
    var forca: Int,
    var destreza: Int,
    var constituicao: Int,
    var inteligencia: Int,
    var sabedoria: Int,
    var carisma: Int
) {
    val pontosDeVida: Int
        get() = 10 + calcularModificadorConstituicao()

    private fun calcularModificadorConstituicao(): Int {
        return (constituicao - 10) / 2
    }
}
