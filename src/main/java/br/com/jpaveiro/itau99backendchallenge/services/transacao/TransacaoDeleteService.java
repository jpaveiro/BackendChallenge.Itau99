package br.com.jpaveiro.itau99backendchallenge.services.transacao;

import br.com.jpaveiro.itau99backendchallenge.dao.TransacaoDAO;
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
