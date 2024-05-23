package br.com.fiap.techfood.app.adapter.input.web.client

import br.com.fiap.techfood.app.adapter.input.web.client.dto.ClientRequest
import br.com.fiap.techfood.app.adapter.input.web.client.dto.ClientResponse
import br.com.fiap.techfood.app.adapter.input.web.client.mapper.toClientResponse
import br.com.fiap.techfood.core.port.input.ClientInputPort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clients")
class ClientResource(
    private val clientInput: ClientInputPort
) {

    @PostMapping
    fun create(@RequestBody request: ClientRequest): ClientResponse =
        clientInput.create(request.cpf, request.name, request.email)
            .toClientResponse()

    @GetMapping("/cpf/{cpf}")
    fun get(@PathVariable cpf: String): ClientResponse {
        val client = clientInput.getClientByCpf(cpf)
        return client.toClientResponse()
    }
}
