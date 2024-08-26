package org.example

fun main() {
    println("")
    println("================== DUNGEONS & DRAGONS ===================")
    println("")
    println("==== SEJA BEM VINDO AO MENU DE CRIAÇÃO DE PERSONAGEM ====")
    println("Você Deve Selecionar o Número para Escolher a Raça que Deseja:")
    println("1 = Humano")
    println("2 = Elfo")
    println("3 = Anão")
    print("Faça sua Escolha: ")

    val escolha = readLine()?.toIntOrNull() ?: return println("Escolha Indisponivel")

    val bonusRacial: Raca = when (escolha) {
        1 -> Humano()
        2 -> Elfo()
        3 -> Anao()
        else -> return println("Opção de Raça Indisponivel")
    }

    val personagem = Personagem(
        forca = 8,
        destreza = 8,
        constituicao = 8,
        inteligencia = 8,
        sabedoria = 8,
        carisma = 8
    )

    println("======== Atributos iniciais do personagem ========")
    println("")
    println("Força: ${personagem.forca}")
    println("Destreza: ${personagem.destreza}")
    println("Constituição: ${personagem.constituicao}")
    println("Inteligência: ${personagem.inteligencia}")
    println("Sabedoria: ${personagem.sabedoria}")
    println("Carisma: ${personagem.carisma}")

    val distribuidor = DistribuicaoPersonalizada()
    val pontosDistribuidos = distribuidor.distribuirPontos(27)

    // Aplicar bônus racial
    val pontos = pontosDistribuidos.toMutableMap()
    bonusRacial.aplicarBonus(pontos)

    personagem.apply {
        forca = pontos["forca"]!!
        destreza = pontos["destreza"]!!
        constituicao = pontos["constituicao"]!!
        inteligencia = pontos["inteligencia"]!!
        sabedoria = pontos["sabedoria"]!!
        carisma = pontos["carisma"]!!
    }

    println("===== Personagem =====")
    println("")
    println("Força: ${personagem.forca}")
    println("Destreza: ${personagem.destreza}")
    println("Constituição: ${personagem.constituicao}")
    println("Inteligência: ${personagem.inteligencia}")
    println("Sabedoria: ${personagem.sabedoria}")
    println("Carisma: ${personagem.carisma}")

    println("\nPontos de Vida: ${personagem.pontosDeVida}")
}
