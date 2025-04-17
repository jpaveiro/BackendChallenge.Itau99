package br.com.jpaveiro.itau99backendchallenge.daos;

import br.com.jpaveiro.itau99backendchallenge.contracts.DAOContract;
import br.com.jpaveiro.itau99backendchallenge.models.domain.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class TransacaoDAO implements DAOContract<Transacao> {
    private final List<Transacao> transacoes;

    public TransacaoDAO() {
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void adicionar(Transacao model) {
        this.transacoes.add(model);
    }

    @Override
    public void apagarTodos() {
        this.transacoes.clear();
    }

    @Override
    public Stream<Transacao> listarTodos() {
        return transacoes.stream();
    }

    @Override
    public Stream<Transacao> listarTodosQue(Condicao<Transacao> condicao) {
        return this.transacoes.stream()
                .filter(condicao::testar);
    }

    @Override
    public List<Transacao> listarTodosQueList(Condicao<Transacao> condicao) {
        return this.transacoes.stream()
                .filter(condicao::testar)
                .collect(Collectors.toList());
    }
}
