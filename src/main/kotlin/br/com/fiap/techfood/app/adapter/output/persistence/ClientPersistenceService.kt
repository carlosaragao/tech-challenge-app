package br.com.fiap.techfood.app.adapter.output.persistence

import br.com.fiap.techfood.app.adapter.output.persistence.mapper.toClientVO
import br.com.fiap.techfood.app.adapter.output.persistence.mapper.toDomain
import br.com.fiap.techfood.app.adapter.output.persistence.mapper.toEntity
import br.com.fiap.techfood.app.adapter.output.persistence.repository.ClientRepository
import br.com.fiap.techfood.core.common.annotation.PersistenceAdapter
import br.com.fiap.techfood.core.domain.Client
import br.com.fiap.techfood.core.domain.vo.ClientVO
import br.com.fiap.techfood.core.port.output.ClientOutputPort

@PersistenceAdapter
class ClientPersistenceService(
    private val clientRepository: ClientRepository,
    ) : ClientOutputPort{

    override fun findClientByCpf(clientCpf: String): Client? {
        return clientRepository.findClientByCpf(clientCpf)?.toDomain()
    }

    override fun findByCpf(clientCpf: String): ClientVO? {
        return clientRepository.findClientByCpf(clientCpf)?.toClientVO()
    }

    override fun persist(client: Client): Client {
        val clientEntity = client.toEntity()
        val savedEntity = clientRepository.save(clientEntity)
        return savedEntity.toDomain()
    }
}