package br.com.fiap.techfood.core.port.input

import br.com.fiap.techfood.core.domain.Client
import br.com.fiap.techfood.core.domain.vo.ClientVO

interface ClientInputPort {
    fun create(clientCpf: String, clientName: String, clientEmail: String): Client
    fun getClientByCpf(clientCpf: String): ClientVO
}