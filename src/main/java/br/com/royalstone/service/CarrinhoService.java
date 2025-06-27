package br.com.royalstone.service;

import br.com.royalstone.model.ItemCarrinho;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@SessionScope // Garante que este serviço seja único por sessão do usuário
public class CarrinhoService {

    private List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(ItemCarrinho novoItem) {
        // Verifica se o item já existe no carrinho
        Optional<ItemCarrinho> itemExistente = itens.stream()
                .filter(item -> item.getJoiaId().equals(novoItem.getJoiaId()))
                .findFirst();

        if (itemExistente.isPresent()) {
            itemExistente.get().aumentarQuantidade(novoItem.getQuantidade());
        } else {
            itens.add(novoItem);
        }
    }

    public void removerItem(Long joiaId) {
        itens.removeIf(item -> item.getJoiaId().equals(joiaId));
    }

    public List<ItemCarrinho> getItens() {
        return new ArrayList<>(itens); // Retorna uma cópia para evitar modificações externas
    }

    public BigDecimal getTotalCarrinho() {
        return itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void limparCarrinho() {
        itens.clear();
    }
}