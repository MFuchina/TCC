package oficina.telas;

import javax.swing.JOptionPane;
import oficina.util.Estados;
import oficina.modelo.ClienteDTO;
import oficina.modelo.OrcamentoDTO;
import oficina.modelo.ProdutoDTO;
import oficina.modelo.ServicoDTO;
import oficina.persistencia.GerenteDAO;
import oficina.util.Mensagens;

/*
DROP DATABASE if EXISTS Oficina;

CREATE DATABASE Oficina;

USE Oficina;

create table gerente(
	user varchar(60) not null,
    senha varchar(60) not null,
    primeira_ex int
);

create table cliente(
	cod_cliente int auto_increment primary key,
    nome varchar(60) not null,
    CPF_CNPJ varchar (14) not null,
    email varchar(60),
    telefone varchar (12),
    sexo enum ('M', 'F', 'O') not null
);

create table moto(
	cod_moto int auto_increment primary key,
    marca varchar(60) not null,
    modelo varchar(60) not null,
    chassi varchar(60),
    placa varchar(8) not null,
    cor varchar(60),
    ano_mod int,
    ano_fabr int,
    cod_dono int not null,
    foreign key (cod_dono) references cliente (cod_cliente)
);

create table produto(
	cod_pdto int auto_increment primary key,
    nome_pdto varchar(60) not null,
    marca_pdto varchar(60),
    preco_pdto float not null
);

create table servico(
	cod_servico int auto_increment primary key,
    nome_servico varchar(60) not null,
    preco_servico float not null,
    descricao_servico varchar(80)
);

create table orcamento(
	cod_orcamento int auto_increment primary key,
    data_orcamento date,
    cod_cliente int not null,
    cod_moto int not null,
    cod_lista int not null,
    valorTotal_orcamento float,
    foreign key (cod_cliente) references cliente (cod_cliente),
    foreign key (cod_moto) references moto (cod_moto),
	foreign key (cod_lista) references lista (cod_lista)
);

create table lista(
	cod_lista int auto_increment primary key,
    item varchar(500) not null,
    qnt varchar(100),
    preco varchar(5000),
    preco_total varchar(9000) not null
);

create table entrada(
	cod_entrada int auto_increment primary key,
	data_entrada date,
    valor float not null,
    tipo enum ('D', 'C', 'CQ') not null
);

INSERT INTO GERENTE VALUES ('admin', 'admin', 0);

insert into cliente (nome, CPF_CNPJ, email, telefone, sexo) values ('Yuri', 1, 'email', 11, 'M');
insert into cliente (nome, CPF_CNPJ, email, telefone, sexo) values ('Fulano', 2, '', 22, 'M');
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        gerenteDAO.verificaExecucao();
        this.setLocationRelativeTo(null);
    }

    private Login login;

    private Consulta consultaProduto = null;
    private Consulta consultaOrcamento = null;
    private Consulta consultaOs = null;
    private Consulta consultaServico = null;
    private Consulta consultaCliente = null;
    private Orcamento orcamento = null;
    private Cliente cadastro = null;
    private Produto novoPdto = null;
    private Servico novoServ = null;

    private final GerenteDAO gerenteDAO = new GerenteDAO();

    public void telaFechando(String tela, String tipo) {
        switch (tela) {
            case "Orcamento":
                orcamento = null;
                break;
            case "Cliente":
                cadastro = null;
                break;
            case "Produto":
                novoPdto = null;
                break;
            case "Servico":
                novoServ = null;
                break;
            case "Moto":
                System.out.println("Moto");
                break;
            case "Consulta":
                switch (tipo) {
                    case "modoConsPdto":
                        consultaProduto = null;
                        break;
                    case "modoConsCliente":
                        consultaCliente = null;
                        break;
                    case "modoConsServico":
                        consultaServico = null;
                        break;
                    case "modoConsOS":
                        consultaOs = null;
                        break;
                    case "modoConsOrcamento":
                        consultaOrcamento = null;
                        break;
                }
                break;
        }
    }

    //Métodos de consultas:
    public void consultarCliente() {
        if (consultaCliente == null) {
            consultaCliente = new Consulta(Estados.modoConsCliente, this, consultaCliente, false, null, null);
            consultaCliente.setVisible(true);
        } else {
            consultaCliente.requestFocus();
            consultaCliente.setVisible(true);
        }
    }

    public void consultarProduto() {
        if (consultaProduto == null) {
            consultaProduto = new Consulta(Estados.modoConsPdto, this, consultaProduto, false, null, null);
            //Puxar a tabela de produtos do BD
            consultaProduto.setVisible(true);
        } else {
            consultaProduto.requestFocus();
            consultaProduto.setVisible(true);
        }
    }

    public void consultarOrcamento() {
        if (consultaOrcamento == null) {
            consultaOrcamento = new Consulta(Estados.modoConsOrcamento, this, consultaOrcamento, false, null, null);
            consultaOrcamento.setVisible(true);
        } else {
            consultaOrcamento.requestFocus();
            consultaOrcamento.setVisible(true);
        }
    }

    public void consultarServico() {
        if (consultaServico == null) {
            consultaServico = new Consulta(Estados.modoConsServico, this, consultaServico, false, null, null);
            consultaServico.setVisible(true);
        } else {
            consultaServico.requestFocus();
            consultaServico.setVisible(true);
        }
    }

    //Métodos de inserção:
    public void novoCliente() {
        if (cadastro == null) {
            cadastro = new Cliente(true, new ClienteDTO(), this, null);
            cadastro.setVisible(true);
        } else {
            cadastro.requestFocus();
            cadastro.setVisible(true);
        }
    }

    public void novoProduto() {
        login = new Login(this, true);
        if (login.criaLogin()) {
            if (novoPdto == null) {
                novoPdto = new Produto(true, new ProdutoDTO(), this, null);
                novoPdto.setVisible(true);
            } else {
                novoPdto.requestFocus();
                novoPdto.setVisible(true);
            }
        }
    }

    public void novoServico() {
        login = new Login(this, true);
        if (login.criaLogin()) {
            if (novoServ == null) {
                novoServ = new Servico(true, new ServicoDTO(), this, null);
                novoServ.setVisible(true);
            } else {
                novoServ.requestFocus();
                novoServ.setVisible(true);
            }
        }
    }

    public void novoOrcamento() {
        if (orcamento == null) {
            orcamento = new Orcamento(new OrcamentoDTO(), this, null);
            orcamento.setVisible(true);
        } else {
            orcamento.requestFocus();
            orcamento.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        botaoNovoOrcamento = new javax.swing.JButton();
        botaoNovoCliente = new javax.swing.JButton();
        botaoConsultarProdutos = new javax.swing.JButton();
        botaoConsultarCliente = new javax.swing.JButton();
        btnConsultarServicos = new javax.swing.JButton();
        btnNovoProduto = new javax.swing.JButton();
        btnVisualizarEntradas = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnNovaEntrada = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuOrcamento = new javax.swing.JMenu();
        menuNovoOrcamento = new javax.swing.JMenuItem();
        menuConsultarOrcamento = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        menuNovoCliente = new javax.swing.JMenuItem();
        menuConsultarCliente = new javax.swing.JMenuItem();
        menuEstoque = new javax.swing.JMenu();
        menuNovoEstoque = new javax.swing.JMenu();
        menuNovoProduto = new javax.swing.JMenuItem();
        menuNovoServico = new javax.swing.JMenuItem();
        menuConsultarEstoque = new javax.swing.JMenu();
        menuConsultarProduto = new javax.swing.JMenuItem();
        menuConsultarServico = new javax.swing.JMenuItem();
        menuEntradas = new javax.swing.JMenu();
        menuNovaEntrada = new javax.swing.JMenuItem();
        menuVisualizarEntradas = new javax.swing.JMenuItem();
        menuConfiguracao = new javax.swing.JMenu();
        menuAlteraLogin = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fuchina Moto Peças - SIGOMM");
        setMaximumSize(new java.awt.Dimension(731, 489));
        setMinimumSize(new java.awt.Dimension(731, 489));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(11, 134, 195));

        labelTitulo.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 30)); // NOI18N
        labelTitulo.setText("FUCHINA MOTO PEÇAS EIRELI M.E.");

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.red, null, null));

        botaoNovoOrcamento.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoNovoOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/005-interface.png"))); // NOI18N
        botaoNovoOrcamento.setText("Novo Orçamento");
        botaoNovoOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoOrcamentoActionPerformed(evt);
            }
        });

        botaoNovoCliente.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/004-user.png"))); // NOI18N
        botaoNovoCliente.setText("Novo Cliente");
        botaoNovoCliente.setToolTipText("");
        botaoNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoClienteActionPerformed(evt);
            }
        });

        botaoConsultarProdutos.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoConsultarProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/002-shopping-2.png"))); // NOI18N
        botaoConsultarProdutos.setText("Consultar Produtos");
        botaoConsultarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarProdutosActionPerformed(evt);
            }
        });

        botaoConsultarCliente.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/003-profile-1.png"))); // NOI18N
        botaoConsultarCliente.setText("Consultar Clientes");
        botaoConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarClienteActionPerformed(evt);
            }
        });

        btnConsultarServicos.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        btnConsultarServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/003-search.png"))); // NOI18N
        btnConsultarServicos.setText("Consultar Serviços");
        btnConsultarServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarServicosActionPerformed(evt);
            }
        });

        btnNovoProduto.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        btnNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/009-shopping.png"))); // NOI18N
        btnNovoProduto.setText("Novo Produto");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        btnVisualizarEntradas.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        btnVisualizarEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/003-get-money.png"))); // NOI18N
        btnVisualizarEntradas.setText("Visualizar Entradas");
        btnVisualizarEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarEntradasActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/forward.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setToolTipText("");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovaEntrada.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        btnNovaEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/002-notes.png"))); // NOI18N
        btnNovaEntrada.setText("Nova Entrada");
        btnNovaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnNovoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoNovoCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoNovoOrcamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoConsultarProdutos)
                    .addComponent(btnConsultarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisualizarEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNovoOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConsultarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisualizarEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        menuOrcamento.setText("Orçamento");

        menuNovoOrcamento.setText("Novo Orçamento...");
        menuNovoOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoOrcamentoActionPerformed(evt);
            }
        });
        menuOrcamento.add(menuNovoOrcamento);

        menuConsultarOrcamento.setText("Consultar Orçamento...");
        menuConsultarOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarOrcamentoActionPerformed(evt);
            }
        });
        menuOrcamento.add(menuConsultarOrcamento);
        menuOrcamento.add(jSeparator2);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuOrcamento.add(menuSair);

        barraMenu.add(menuOrcamento);

        menuCliente.setText("Cliente");

        menuNovoCliente.setText("Novo Cliente...");
        menuNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoClienteActionPerformed(evt);
            }
        });
        menuCliente.add(menuNovoCliente);

        menuConsultarCliente.setText("Consultar Cliente...");
        menuConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarClienteActionPerformed(evt);
            }
        });
        menuCliente.add(menuConsultarCliente);

        barraMenu.add(menuCliente);

        menuEstoque.setText("Estoque");
        menuEstoque.setToolTipText("");

        menuNovoEstoque.setText("Novo");

        menuNovoProduto.setText("Produto...");
        menuNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoProdutoActionPerformed(evt);
            }
        });
        menuNovoEstoque.add(menuNovoProduto);

        menuNovoServico.setText("Serviço...");
        menuNovoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoServicoActionPerformed(evt);
            }
        });
        menuNovoEstoque.add(menuNovoServico);

        menuEstoque.add(menuNovoEstoque);

        menuConsultarEstoque.setText("Consultar");

        menuConsultarProduto.setText("Produto...");
        menuConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarProdutoActionPerformed(evt);
            }
        });
        menuConsultarEstoque.add(menuConsultarProduto);

        menuConsultarServico.setText("Serviço...");
        menuConsultarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarServicoActionPerformed(evt);
            }
        });
        menuConsultarEstoque.add(menuConsultarServico);

        menuEstoque.add(menuConsultarEstoque);

        barraMenu.add(menuEstoque);

        menuEntradas.setText("Entradas");

        menuNovaEntrada.setText("Nova Entrada...");
        menuNovaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovaEntradaActionPerformed(evt);
            }
        });
        menuEntradas.add(menuNovaEntrada);

        menuVisualizarEntradas.setText("Visualizar Entradas...");
        menuVisualizarEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVisualizarEntradasActionPerformed(evt);
            }
        });
        menuEntradas.add(menuVisualizarEntradas);

        barraMenu.add(menuEntradas);

        menuConfiguracao.setText("Configuração");

        menuAlteraLogin.setText("Alterar Login...");
        menuAlteraLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlteraLoginActionPerformed(evt);
            }
        });
        menuConfiguracao.add(menuAlteraLogin);

        barraMenu.add(menuConfiguracao);

        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        barraMenu.add(menuSobre);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovoOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoOrcamentoActionPerformed
        novoOrcamento();
    }//GEN-LAST:event_menuNovoOrcamentoActionPerformed

    private void menuConsultarOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarOrcamentoActionPerformed
        consultarOrcamento();
    }//GEN-LAST:event_menuConsultarOrcamentoActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoProdutoActionPerformed
        novoProduto();
    }//GEN-LAST:event_menuNovoProdutoActionPerformed

    private void menuNovoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoServicoActionPerformed
        novoServico();
    }//GEN-LAST:event_menuNovoServicoActionPerformed

    private void menuConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarProdutoActionPerformed
        consultarProduto();
    }//GEN-LAST:event_menuConsultarProdutoActionPerformed

    private void menuConsultarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarServicoActionPerformed
        consultarServico();
    }//GEN-LAST:event_menuConsultarServicoActionPerformed

    private void botaoNovoOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoOrcamentoActionPerformed
        novoOrcamento();
    }//GEN-LAST:event_botaoNovoOrcamentoActionPerformed

    private void botaoNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoClienteActionPerformed
        novoCliente();
    }//GEN-LAST:event_botaoNovoClienteActionPerformed

    private void botaoConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarClienteActionPerformed
        consultarCliente();
    }//GEN-LAST:event_botaoConsultarClienteActionPerformed

    private void botaoConsultarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarProdutosActionPerformed
        consultarProduto();
    }//GEN-LAST:event_botaoConsultarProdutosActionPerformed

    private void menuNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoClienteActionPerformed
        novoCliente();
    }//GEN-LAST:event_menuNovoClienteActionPerformed

    private void menuConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarClienteActionPerformed
        consultarCliente();
    }//GEN-LAST:event_menuConsultarClienteActionPerformed

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        JOptionPane.showMessageDialog(null, "       Esse trabalho de conclusão de curso foi desenvolvido em 2017 pelos alunos\n"
                + "Matheus Nascimento Fuchina e Nathália Fernanda Tiedt na disciplina de Projeto e\n"
                + "Desenvolvimento de Sistemas do Curso Técnico de Informática Integrado ao Ensino\n"
                + "Médio do Instituto Federal Catarinense - Campus Blumenau.", "Sobre - SIGOMM", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menuSobreMouseClicked

    AlteraLogin altLogin;

    private void menuAlteraLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlteraLoginActionPerformed
        login = new Login(this, true);
        if (login.criaLogin()) {
            altLogin = new AlteraLogin(this, true);
            altLogin.criaAlteraLogin();
        }

    }//GEN-LAST:event_menuAlteraLoginActionPerformed

    private void btnVisualizarEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarEntradasActionPerformed
        login = new Login(this, true);
        if (login.criaLogin()) {
            ConsultaEntrada ce = new ConsultaEntrada(this, true);
            ce.setVisible(true);
        }
    }//GEN-LAST:event_btnVisualizarEntradasActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if (Mensagens.msgConf("Deseja mesmo sair?")) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConsultarServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarServicosActionPerformed
        consultarServico();
    }//GEN-LAST:event_btnConsultarServicosActionPerformed

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        novoProduto();
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void menuNovaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovaEntradaActionPerformed
        NovaEntrada nova = new NovaEntrada(this, true);
        nova.setVisible(true);
    }//GEN-LAST:event_menuNovaEntradaActionPerformed

    private void btnNovaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaEntradaActionPerformed
        NovaEntrada nova = new NovaEntrada(this, true);
        nova.setVisible(true);
    }//GEN-LAST:event_btnNovaEntradaActionPerformed

    private void menuVisualizarEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVisualizarEntradasActionPerformed
        login = new Login(this, true);
        if (login.criaLogin()) {
            ConsultaEntrada ce = new ConsultaEntrada(this, true);
            ce.setVisible(true);
        }
    }//GEN-LAST:event_menuVisualizarEntradasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botaoConsultarCliente;
    private javax.swing.JButton botaoConsultarProdutos;
    private javax.swing.JButton botaoNovoCliente;
    private javax.swing.JButton botaoNovoOrcamento;
    private javax.swing.JButton btnConsultarServicos;
    private javax.swing.JButton btnNovaEntrada;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVisualizarEntradas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JMenuItem menuAlteraLogin;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuConfiguracao;
    private javax.swing.JMenuItem menuConsultarCliente;
    private javax.swing.JMenu menuConsultarEstoque;
    private javax.swing.JMenuItem menuConsultarOrcamento;
    private javax.swing.JMenuItem menuConsultarProduto;
    private javax.swing.JMenuItem menuConsultarServico;
    private javax.swing.JMenu menuEntradas;
    private javax.swing.JMenu menuEstoque;
    private javax.swing.JMenuItem menuNovaEntrada;
    private javax.swing.JMenuItem menuNovoCliente;
    private javax.swing.JMenu menuNovoEstoque;
    private javax.swing.JMenuItem menuNovoOrcamento;
    private javax.swing.JMenuItem menuNovoProduto;
    private javax.swing.JMenuItem menuNovoServico;
    private javax.swing.JMenu menuOrcamento;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenuItem menuVisualizarEntradas;
    // End of variables declaration//GEN-END:variables
}
