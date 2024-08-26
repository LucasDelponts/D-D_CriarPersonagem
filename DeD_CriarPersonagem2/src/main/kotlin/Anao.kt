package org.example

class Anao : Raca {
    override fun aplicarBonus(pontos: MutableMap<String, Int>) {
        pontos["constituicao"] = pontos["constituicao"]!! + 2
    }
}