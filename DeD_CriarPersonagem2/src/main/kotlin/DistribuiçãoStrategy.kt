package org.example  // Certifique-se de usar o pacote correto

interface DistribuicaoStrategy {
    fun distribuirPontos(pontosDisponiveis: Int): Map<String, Int>
}

