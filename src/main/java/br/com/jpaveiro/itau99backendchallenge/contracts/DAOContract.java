package br.com.jpaveiro.itau99backendchallenge.contracts;

import java.util.stream.Stream;

public interface DAOContract<M> {
    void adicionar(M model);
    Stream<M> listarTodos();
    Stream<M> listarTodosQue(Condicao<M> condicao);

    @FunctionalInterface
    interface Condicao<M> {
        boolean testar(M modelo);
    }
}
