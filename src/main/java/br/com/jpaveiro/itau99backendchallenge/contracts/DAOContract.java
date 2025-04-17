package br.com.jpaveiro.itau99backendchallenge.contracts;

import java.util.List;
import java.util.stream.Stream;

public interface DAOContract<M> {
    void adicionar(M model);
    void apagarTodos();
    Stream<M> listarTodos();
    Stream<M> listarTodosQue(Condicao<M> condicao);
    List<M> listarTodosQueList(Condicao<M> condicao);

    @FunctionalInterface
    interface Condicao<M> {
        boolean testar(M modelo);
    }
}
