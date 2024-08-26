package org.example

class Humano : Raca {
    override fun aplicarBonus(pontos: MutableMap<String, Int>) {
        pontos.keys.forEach { atributo ->
            pontos[atributo] = pontos[atributo]!! + 1
        }
    }
}
