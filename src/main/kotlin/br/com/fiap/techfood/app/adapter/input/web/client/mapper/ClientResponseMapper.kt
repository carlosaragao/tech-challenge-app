package br.com.fiap.techfood.app.adapter.input.web.client.mapper

import br.com.fiap.techfood.app.adapter.input.web.client.dto.ClientResponse
import br.com.fiap.techfood.core.domain.Client
import br.com.fiap.techfood.core.domain.vo.ClientVO

fun Client.toClientResponse(): ClientResponse =
    ClientResponse(
        cpf = this.cpf,
        name = this.name,
        email = this.email
    )

fun ClientVO.toClientResponse(): ClientResponse =
    ClientResponse(
        cpf,
        name,
        email
    )
