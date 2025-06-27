package br.com.royalstone.config; // Certifique-se que o pacote está correto!

import br.com.royalstone.enums.CorMineral;
import br.com.royalstone.model.Joia;
import br.com.royalstone.model.MineralMetalico;
import br.com.royalstone.model.MineralPrecioso;
import br.com.royalstone.repository.JoiaRepository;
import br.com.royalstone.repository.MineralMetalicoRepository;
import br.com.royalstone.repository.MineralPreciosoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader {

    private final JoiaRepository joiaRepository;
    private final MineralMetalicoRepository mineralMetalicoRepository;
    private final MineralPreciosoRepository mineralPreciosoRepository;

    public DataLoader(JoiaRepository joiaRepository, 
                      MineralMetalicoRepository mineralMetalicoRepository, 
                      MineralPreciosoRepository mineralPreciosoRepository) {
        this.joiaRepository = joiaRepository;
        this.mineralMetalicoRepository = mineralMetalicoRepository;
        this.mineralPreciosoRepository = mineralPreciosoRepository;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            // Verifica se já existem dados para evitar duplicidade em cada restart
            if (joiaRepository.count() == 0 && mineralPreciosoRepository.count() == 0 && mineralMetalicoRepository.count() == 0) {
                System.out.println("Carregando dados iniciais de joias...");

                // 1. Criar e salvar Minerais Metálicos
                MineralMetalico ouro18k = new MineralMetalico("Ouro 18K", 0.75, new BigDecimal("250.00"), 1000);
                MineralMetalico prata925 = new MineralMetalico("Prata 925", 0.925, new BigDecimal("5.00"), 5000);
                MineralMetalico ouroBranco = new MineralMetalico("Ouro Branco 18K", 0.75, new BigDecimal("270.00"), 800); // Novo metal
                
                ouro18k = mineralMetalicoRepository.save(ouro18k);
                prata925 = mineralMetalicoRepository.save(prata925);
                ouroBranco = mineralMetalicoRepository.save(ouroBranco); // Salvando o novo metal
                System.out.println("Minerais Metálicos salvos.");

                // 2. Criar e salvar Minerais Preciosos
                MineralPrecioso diamante = new MineralPrecioso("Diamante", "Carbono", CorMineral.TRANSPARENTE, 10, 0.5f, 1500.00);
                diamante.setPesoQuilates(new BigDecimal("0.5"));
                diamante.setPrecoPorQuilate(new BigDecimal("5000.00"));
                diamante.setLapidacao("Brilhante");
                diamante.setCertificado("GIA-D123");
                diamante.setRefinamento("Limpo");

                MineralPrecioso esmeralda = new MineralPrecioso("Esmeralda", "Berilo", CorMineral.VERDE, 8, 1.2f, 1200.00);
                esmeralda.setPesoQuilates(new BigDecimal("1.2"));
                esmeralda.setPrecoPorQuilate(new BigDecimal("3000.00"));
                esmeralda.setLapidacao("Gota");
                esmeralda.setCertificado("GRS-E456");
                esmeralda.setRefinamento("Oiled");

                // Novos minerais preciosos
                MineralPrecioso rubi = new MineralPrecioso("Rubi", "Óxido de Alumínio", CorMineral.VERMELHO, 9, 0.8f, 1800.00);
                rubi.setPesoQuilates(new BigDecimal("0.8"));
                rubi.setPrecoPorQuilate(new BigDecimal("4500.00"));
                rubi.setLapidacao("Oval");
                rubi.setCertificado("AGL-R789");
                rubi.setRefinamento("Heated");
                
                MineralPrecioso safira = new MineralPrecioso("Safira", "Óxido de Alumínio", CorMineral.AZUL, 9, 1.0f, 1000.00);
                safira.setPesoQuilates(new BigDecimal("1.0"));
                safira.setPrecoPorQuilate(new BigDecimal("3500.00"));
                safira.setLapidacao("Cushion");
                safira.setCertificado("GIA-S001");
                safira.setRefinamento("No Heat");

                diamante = mineralPreciosoRepository.save(diamante);
                esmeralda = mineralPreciosoRepository.save(esmeralda);
                rubi = mineralPreciosoRepository.save(rubi); // Salvando o novo rubi
                safira = mineralPreciosoRepository.save(safira); // Salvando a nova safira
                System.out.println("Minerais Preciosos salvos.");

                // 3. Criar e salvar Joias
                Joia anelDiamante = new Joia();
                anelDiamante.setNome("Anel Solitário de Diamante");
                anelDiamante.setDescricao("Anel clássico de noivado com diamante brilhante em ouro 18K.");
                anelDiamante.setPreco(new BigDecimal("6250.00"));
                anelDiamante.setEstoque(3);
                anelDiamante.setImagemUrl("https://images.unsplash.com/photo-1683245597322-79659ee86fb3?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
                anelDiamante.setMineralPrecioso(diamante);
                anelDiamante.setMineralMetalico(ouro18k);
                joiaRepository.save(anelDiamante);

                Joia brincoEsmeralda = new Joia();
                brincoEsmeralda.setNome("Brincos Gota de Esmeralda");
                brincoEsmeralda.setDescricao("Elegantes brincos de gota com esmeraldas naturais e prata 925.");
                brincoEsmeralda.setPreco(new BigDecimal("3800.00"));
                brincoEsmeralda.setEstoque(2);
                brincoEsmeralda.setImagemUrl("https://images.unsplash.com/photo-1662434921965-3b71f180c6f4?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
                brincoEsmeralda.setMineralPrecioso(esmeralda);
                brincoEsmeralda.setMineralMetalico(prata925);
                joiaRepository.save(brincoEsmeralda);

                // --- NOVAS JOIAS ---

                Joia colarRubi = new Joia();
                colarRubi.setNome("Colar de Rubi com Ouro Branco");
                colarRubi.setDescricao("Colar deslumbrante com rubi central e detalhes em ouro branco 18K.");
                colarRubi.setPreco(new BigDecimal("8500.00"));
                colarRubi.setEstoque(1); // Item exclusivo
                colarRubi.setImagemUrl("https://images.unsplash.com/photo-1741886422087-204620c77a85?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"); // Exemplo de URL de rubi
                colarRubi.setMineralPrecioso(rubi);
                colarRubi.setMineralMetalico(ouroBranco); // Usando o novo metal
                joiaRepository.save(colarRubi);

                Joia pulseiraSafira = new Joia();
                pulseiraSafira.setNome("Pulseira de Safira e Prata");
                pulseiraSafira.setDescricao("Pulseira elegante com safiras lapidadas em prata 925.");
                pulseiraSafira.setPreco(new BigDecimal("4200.00"));
                pulseiraSafira.setEstoque(4);
                pulseiraSafira.setImagemUrl("https://images.unsplash.com/photo-1743127187686-e6145b08658b?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"); // Exemplo de URL para safira
                pulseiraSafira.setMineralPrecioso(safira);
                pulseiraSafira.setMineralMetalico(prata925);
                joiaRepository.save(pulseiraSafira);

                Joia brincoDiamanteOuroBranco = new Joia();
                brincoDiamanteOuroBranco.setNome("Brincos Ponto de Luz Diamante");
                brincoDiamanteOuroBranco.setDescricao("Clássicos brincos ponto de luz com diamantes pequenos em ouro branco.");
                brincoDiamanteOuroBranco.setPreco(new BigDecimal("2100.00"));
                brincoDiamanteOuroBranco.setEstoque(7);
                brincoDiamanteOuroBranco.setImagemUrl("https://images.unsplash.com/photo-1599380295175-ce4e2d4d9b4b?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"); // Outra imagem de exemplo
                brincoDiamanteOuroBranco.setMineralPrecioso(diamante); // Reutilizando diamante
                brincoDiamanteOuroBranco.setMineralMetalico(ouroBranco); // Usando ouro branco
                joiaRepository.save(brincoDiamanteOuroBranco);

                System.out.println("Joias salvas.");
            } else {
                System.out.println("Dados de joias já existem no banco. Pulando carregamento inicial.");
            }
        };
    }
}