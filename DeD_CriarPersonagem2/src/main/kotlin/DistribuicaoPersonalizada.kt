package org.example

class DistribuicaoPersonalizada : DistribuicaoStrategy {

    override fun distribuirPontos(pontosDisponiveis: Int): Map<String, Int> {
        val atributos = mutableMapOf(
            "forca" to 8,
            "destreza" to 8,
            "constituicao" to 8,
            "inteligencia" to 8,
            "sabedoria" to 8,
            "carisma" to 8
        )

        var pontosRestantes = pontosDisponiveis

        while (pontosRestantes > 0) {
            println("\n==================== Atributos Disponíveis ====================")
            atributos.forEach { (key, value) ->
                println("${key.capitalize()}: $value")
            }
            println("Pontos restantes: $pontosRestantes")
            println("\nEscolha o atributo para aumentar:")
            println("1 = Força")
            println("2 = Destreza")
            println("3 = Constituição")
            println("4 = Inteligência")
            println("5 = Sabedoria")
            println("6 = Carisma")
            print("Faça sua escolha: ")

            val escolha = readLine()?.toIntOrNull() ?: continue

            val atributo = when (escolha) {
                1 -> "forca"
                2 -> "destreza"
                3 -> "constituicao"
                4 -> "inteligencia"
                5 -> "sabedoria"
                6 -> "carisma"
                else -> continue
            }

            println("Qual valor deseja adicionar ao atributo $atributo? (Valor atual: ${atributos[atributo]})")
            val valorAdicional = readLine()?.toIntOrNull() ?: continue

            val custo = calcularCusto(atributos[atributo]!!, atributos[atributo]!! + valorAdicional)
            if (custo <= pontosRestantes) {
                atributos[atributo] = atributos[atributo]!! + valorAdicional
                pontosRestantes -= custo
            } else {
                println("Pontos insuficientes para aumentar o atributo $atributo para $valorAdicional. Custo necessário: $custo")
            }
        }

        return atributos
    }

    private fun calcularCusto(valorAtual: Int, valorNovo: Int): Int {
        var custo = 0
        for (i in valorAtual until valorNovo) {
            custo += if (i < 15) 1 else 2
        }
        return custo
    }
}