package oficina.telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oficina.Util.Estados;
import oficina.modelo.ClienteDTO;
import oficina.modelo.OrcamentoDTO;
import oficina.modelo.OsDTO;
import oficina.modelo.ProdutoDTO;
import oficina.modelo.ServicoDTO;

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

create table ordem_servico(
	cod_os int auto_increment primary key,
    data_os date,
    cod_cliente int not null,
    cod_moto int not null,
    status_os enum ('NI', 'I', 'C') not null,
    valorTotal_os float,
    -- qnt_pdto int not null,
    foreign key (cod_cliente) references cliente (cod_cliente),
    foreign key (cod_moto) references moto (cod_moto)
);

create table orcamento(
	cod_orcamento int auto_increment primary key,
    data_orcamento date,
    cod_cliente int not null,
    cod_moto int not null,
	-- qnt_pdto int not null,
    valorTotal_orcamento float,
    foreign key (cod_cliente) references cliente (cod_cliente),
    foreign key (cod_moto) references moto (cod_moto)
	
);

INSERT INTO GERENTE VALUES ('admin', 'admin', 0);

insert into cliente (nome, CPF_CNPJ, email, telefone, sexo) values ('Yuri', 1, 'email', 11, 'M');

update  gerente set senha= '123' where user = 'admin';
update gerente set senha= 'admin' where user = 'admin';

-- SELECT MAX(cod_cliente) FROM cliente;

select modelo, placa from moto where cod_dono = 11;

select * from gerente;

select * from cliente;

select * from produto;

select * from servico;

select * from moto;
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private Login login;

    private Consulta c;
    private Consulta consultaProduto = null;
    private Consulta consultaOrcamento = null;
    private Consulta consultaOs = null;
    private Consulta consultaServico = null;
    private Consulta consultaCliente = null;
    private Consulta consultaMoto = null;

    private Orcamento orcamento = null;
    private OrdemDeServico ordemServico = null;
    private Cliente cadastro = null;
    private Produto novoPdto = null;
    private Servico novoServ = null;

    public void telaFechando(JFrame tela, String tipo) {
        switch (String.valueOf(tela.getClass())) {
            case "class oficina.telas.Orcamento":
                orcamento = null;
                break;
            case "class oficina.telas.Cliente":
                cadastro = null;
                break;
            case "class oficina.telas.Produto":
                novoPdto = null;
                break;
            case "class oficina.telas.Servico":
                novoServ = null;
                break;
            case "class oficina.telas.OrdemDeServico":
                ordemServico = null;
                break;
            case "class oficina.telas.Moto":
                System.out.println("Moto");
                break;
            case "class oficina.telas.Consulta":
                switch (tipo) {
                    case "modoConsPdto":
                        consultaProduto = null;
                        break;
                    case "modoConsMoto":
                        consultaMoto = null;
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
            consultaCliente = new Consulta(Estados.modoConsCliente, this, consultaCliente, false, null);
            consultaCliente.setVisible(true);
        } else {
            consultaCliente.requestFocus();
            consultaCliente.setVisible(true);
        }
    }

    public void consultarProduto() {
        if (consultaProduto == null) {
            consultaProduto = new Consulta(Estados.modoConsPdto, this, consultaProduto, false, null);
            //Puxar a tabela de produtos do BD
            consultaProduto.setVisible(true);
        } else {
            consultaProduto.requestFocus();
            consultaProduto.setVisible(true);
        }
    }

    public void consultarOrcamento() {
        if (consultaOrcamento == null) {
            consultaOrcamento = new Consulta(Estados.modoConsOrcamento, this, consultaOrcamento, false, null);
            consultaOrcamento.setVisible(true);
        } else {
            consultaOrcamento.requestFocus();
            consultaOrcamento.setVisible(true);
        }
    }

    public void consultarOs() {
        if (consultaOs == null) {
            consultaOs = new Consulta(Estados.modoConsOS, this, consultaOs, false, null);
            consultaOs.setVisible(true);
        } else {
            consultaOs.requestFocus();
            consultaOs.setVisible(true);
        }
    }

    public void consultarServico() {
        if (consultaServico == null) {
            consultaServico = new Consulta(Estados.modoConsServico, this, consultaServico, false, null);
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
            orcamento = new Orcamento(true, new OrcamentoDTO(), this, null);
            orcamento.setVisible(true);
        } else {
            orcamento.requestFocus();
            orcamento.setVisible(true);
        }
    }

    public void novaOs() {
        if (ordemServico == null) {
            ordemServico = new OrdemDeServico(true, new OsDTO(), this, null);
            ordemServico.setVisible(true);
        } else {
            ordemServico.requestFocus();
            ordemServico.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaOrdemServico = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnEditar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        botaoNovoOrcamento = new javax.swing.JButton();
        botaoNovaOS = new javax.swing.JButton();
        botaoNovoCliente = new javax.swing.JButton();
        botaoConsultarProdutos = new javax.swing.JButton();
        botaoConsultarCliente = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuOrcamento = new javax.swing.JMenu();
        menuNovoOrcamento = new javax.swing.JMenuItem();
        menuConsultarOrcamento = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        menuOrdemServico = new javax.swing.JMenu();
        menuNovaOS = new javax.swing.JMenuItem();
        menuConsultarOS = new javax.swing.JMenuItem();
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
        menuConfiguracao = new javax.swing.JMenu();
        menuAlteraLogin = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fuchina Moto Peças - SIGOMM");
        setMaximumSize(new java.awt.Dimension(977, 616));
        setMinimumSize(new java.awt.Dimension(977, 616));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(11, 134, 195));

        labelTitulo.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        labelTitulo.setText("FUCHINA MOTO PEÇAS EIRELI M.E.");

        tabelaOrdemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Status", "Data", "Placa", "Moto", "Cliente", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaOrdemServico.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaOrdemServico);
        if (tabelaOrdemServico.getColumnModel().getColumnCount() > 0) {
            tabelaOrdemServico.getColumnModel().getColumn(0).setResizable(false);
            tabelaOrdemServico.getColumnModel().getColumn(1).setResizable(false);
            tabelaOrdemServico.getColumnModel().getColumn(2).setResizable(false);
            tabelaOrdemServico.getColumnModel().getColumn(3).setResizable(false);
            tabelaOrdemServico.getColumnModel().getColumn(4).setResizable(false);
            tabelaOrdemServico.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel1.setText("Ordens de Serviço ativas:");

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));

        btnEditar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/002-edit.png"))); // NOI18N
        btnEditar.setText("Editar");

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

        botaoNovaOS.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoNovaOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/011-note.png"))); // NOI18N
        botaoNovaOS.setText("Nova Ordem de Serviço");
        botaoNovaOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovaOSActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(botaoNovoOrcamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoNovaOS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoNovoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoConsultarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoConsultarProdutos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoNovoOrcamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botaoConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botaoConsultarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botaoNovaOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoNovoCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(792, 792, 792)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuOrcamento.add(menuSair);

        barraMenu.add(menuOrcamento);

        menuOrdemServico.setText("Ordem de Serviço");

        menuNovaOS.setText("Nova OS...");
        menuNovaOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovaOSActionPerformed(evt);
            }
        });
        menuOrdemServico.add(menuNovaOS);

        menuConsultarOS.setText("Consultar OS...");
        menuConsultarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarOSActionPerformed(evt);
            }
        });
        menuOrdemServico.add(menuConsultarOS);

        barraMenu.add(menuOrdemServico);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void menuNovaOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovaOSActionPerformed
        novaOs();
    }//GEN-LAST:event_menuNovaOSActionPerformed

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

    private void botaoNovaOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaOSActionPerformed
        novaOs();
    }//GEN-LAST:event_botaoNovaOSActionPerformed

    private void botaoNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoClienteActionPerformed
        novoCliente();
    }//GEN-LAST:event_botaoNovoClienteActionPerformed

    private void botaoConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarClienteActionPerformed
        consultarCliente();
    }//GEN-LAST:event_botaoConsultarClienteActionPerformed

    private void botaoConsultarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarProdutosActionPerformed
        consultarProduto();
    }//GEN-LAST:event_botaoConsultarProdutosActionPerformed

    private void menuConsultarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarOSActionPerformed
        consultarOs();
    }//GEN-LAST:event_menuConsultarOSActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botaoConsultarCliente;
    private javax.swing.JButton botaoConsultarProdutos;
    private javax.swing.JButton botaoNovaOS;
    private javax.swing.JButton botaoNovoCliente;
    private javax.swing.JButton botaoNovoOrcamento;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JMenuItem menuAlteraLogin;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuConfiguracao;
    private javax.swing.JMenuItem menuConsultarCliente;
    private javax.swing.JMenu menuConsultarEstoque;
    private javax.swing.JMenuItem menuConsultarOS;
    private javax.swing.JMenuItem menuConsultarOrcamento;
    private javax.swing.JMenuItem menuConsultarProduto;
    private javax.swing.JMenuItem menuConsultarServico;
    private javax.swing.JMenu menuEstoque;
    private javax.swing.JMenuItem menuNovaOS;
    private javax.swing.JMenuItem menuNovoCliente;
    private javax.swing.JMenu menuNovoEstoque;
    private javax.swing.JMenuItem menuNovoOrcamento;
    private javax.swing.JMenuItem menuNovoProduto;
    private javax.swing.JMenuItem menuNovoServico;
    private javax.swing.JMenu menuOrcamento;
    private javax.swing.JMenu menuOrdemServico;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JTable tabelaOrdemServico;
    // End of variables declaration//GEN-END:variables
}
