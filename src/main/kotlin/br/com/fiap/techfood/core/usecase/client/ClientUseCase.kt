package br.com.fiap.techfood.core.usecase.client

import br.com.fiap.techfood.core.common.annotation.UseCase
import br.com.fiap.techfood.core.common.exception.ClientAlreadyExistsException
import br.com.fiap.techfood.core.common.exception.ClientNotFoundException
import br.com.fiap.techfood.core.domain.Client
import br.com.fiap.techfood.core.domain.vo.ClientVO
import br.com.fiap.techfood.core.port.input.ClientInputPort
import br.com.fiap.techfood.core.port.output.ClientOutputPort

@UseCase
class ClientUseCase(
    private val clientOutput: ClientOutputPort
): ClientInputPort {
    override fun create(clientCPF: String, clientName: String, clientEmail: String): Client {
        val existingClient = clientOutput.findClientByCpf(clientCPF)
        if (existingClient != null) {
            throw ClientAlreadyExistsException()
        }

        val newClient = Client(clientCPF, clientName, clientEmail)
        return clientOutput.persist(newClient)
    }

    override fun getClientByCpf(clientCpf: String): ClientVO =
        clientOutput.findByCpf(clientCpf)?: throw ClientNotFoundException()


//    override fun getClientByCpf(clientCpf: String): ClientVO {
//        return clientOutput.findByCpf(clientCpf)?: throw ClientNotFoundException()
//    }
}