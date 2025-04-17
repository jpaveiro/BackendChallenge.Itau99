package br.com.jpaveiro.itau99backendchallenge.usecases.transacao;

import br.com.jpaveiro.itau99backendchallenge.daos.TransacaoDAO;
import org.springframework.stereotype.Service;

@Service
public class TransacaoDeleteService {
    private final TransacaoDAO dao;

    public TransacaoDeleteService(final TransacaoDAO dao) {
        this.dao = dao;
    }

    public void executar() {
        dao.apagarTodos();
    }
}
