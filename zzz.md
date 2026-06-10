### anotações sobre o projeto

-- Criada as classes User.java, Client.java e definidos os seus atributos.
-- Utilizado de JPA/Hibernate para fazer o mapeamento do banco de dados através das classes criadas.
-- Model para o construtor e todos os métodos da class,
-- Service para as regras de negocio
-- Controller para as requisições HTTP
-- Repositorios para a camada de persistenica
-- MVC ne malandro

## Anotações utilizadas
-- @Entity - identifica a classe como uma entidade no banco de dados
-- @Table(name = 'clients') - mapeia a classe para a tabela clients no BD
-- @Id - marca a chave primária
-- @GeneratedValue(strategy = GenerateionType.IDENTITY) - instrui a criar o ID para cada novo registro
-- @Data @NoArgsConstructor - para gerar getters e setters com menos esforço, (importante importar o lombok)
-- @Column(unique = true) - foi usada no cpf, para garantir que não tenham dois iguais
-- @ManyToOne - para identificar que um vários pedidos podem pertencer a um cliente apenas
-- @JoinColumn(name="client_id") - indica que a coluna pedidos da tabela que irá guardar o ID do cliente
-- @OneToMany - indica que um cliente pode ter muitos pedidos
-- (mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true) - garante que tudo seja apagado junto com o registro do cliente
-- @Autowired - injeta o repositorio, serviços, na classe escolhida, conforme a construção
-- @PostMaping - endpoint para criar algo
-- @RestController - utiliza de requisições rest
-- @RequestMaping("/***") - url de caminho para o endpoint
