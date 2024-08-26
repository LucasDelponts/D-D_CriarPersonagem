package org.example

class Elfo : Raca {
    override fun aplicarBonus(pontos: MutableMap<String, Int>) {
        pontos["destreza"] = pontos["destreza"]!! + 2
        pontos["inteligencia"] = pontos["inteligencia"]!! + 1
    }
}
