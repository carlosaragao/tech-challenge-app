package br.com.fiap.techfood.core.port.output

import br.com.fiap.techfood.core.domain.Client
import br.com.fiap.techfood.core.domain.vo.ClientVO

interface ClientOutputPort {
    fun persist(client: Client): Client
    fun findClientByCpf(clientCPF: String): Client?
    fun findByCpf(clientCPF: String): ClientVO?
}