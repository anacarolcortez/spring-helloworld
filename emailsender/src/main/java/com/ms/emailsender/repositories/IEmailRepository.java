package com.ms.emailsender.repositories;

import com.ms.emailsender.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailRepository extends JpaRepository<EmailModel, Long> {
// O JpaRepository traz o contrato de todos os métodos de um CRUD, para que o service o implemente.
// O service é utiliado pelo controller, quem faz o meio de campo com as rotas
}
