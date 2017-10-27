package oficina.telas;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import oficina.Util.Estados;
import oficina.Util.Mensagens;
import oficina.modelo.ClienteDTO;
import oficina.modelo.MotoDTO;
import oficina.modelo.OrcamentoDTO;
import oficina.modelo.OsDTO;
import oficina.modelo.ProdutoDTO;
import oficina.modelo.ServicoDTO;
import oficina.persistencia.ClienteDAO;
import oficina.persistencia.OrcamentoDAO;
import oficina.persistencia.OsDAO;
import oficina.persistencia.ProdutoDAO;
import oficina.persistencia.ServicoDAO;

public class Consulta extends javax.swing.JFrame {

    //Tipo de consulta a ser realizada
    private final String tipo;
    private int cod;

    public int getCod() {
        return cod;
    }

    //DAO's
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
    private final OsDAO osDAO = new OsDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final ServicoDAO servicoDAO = new ServicoDAO();

    //Array Lists dos objetos
    private ArrayList<ClienteDTO> listaClientes;
    private ArrayList<MotoDTO> listaMotos;
    private ArrayList<ProdutoDTO> listaProdutos;
    private ArrayList<ServicoDTO> listaServicos;
    private ArrayList<OsDTO> listaOs;
    private ArrayList<OrcamentoDTO> listaOrcamentos;

    private final Principal telaPrincipal;
    private Login login;

    private Consulta c;
    private Cliente novoCliente = null;
    private Orcamento novoOrcamento = null;
    private Orcamento orcamento = null;
    private OrdemDeServico novaOrdemServico = null;
    private Produto novoProduto = null;
    private Servico novoServico = null;
    private final boolean botaoOrcamento;

    private final ProdutoDTO pdto = new ProdutoDTO();
    private final ServicoDTO sdto = new ServicoDTO();

    public Consulta(Estados modo, Principal formPrincipal, Consulta c, boolean botaoOrcamento, Orcamento orc) {
        this.botaoOrcamento = botaoOrcamento;
        this.c = c;
        this.telaPrincipal = formPrincipal;
        this.tipo = modo.name();
        this.orcamento = orc;
        initComponents();
        this.setLocationRelativeTo(null);
        montaTabela();
        if (botaoOrcamento) {
            btnEditar.setEnabled(false);
            btnNovo.setEnabled(false);
            btnRemover.setEnabled(false);
        }
    }

    public void telaFechando(JFrame tela) {
        switch (String.valueOf(tela.getClass())) {
            case "class oficina.telas.Orcamento":
                novoOrcamento = null;
                break;
            case "class oficina.telas.Cliente":
                novoCliente = null;
                break;
            case "class oficina.telas.Produto":
                novoProduto = null;
                break;
            case "class oficina.telas.Servico":
                novoServico = null;
                break;
            case "class oficina.telas.OrdemDeServico":
                novaOrdemServico = null;
                break;
        }
    }

    public String getEstado() {
        return tipo;
    }

    public void montaTabela() {
        switch (tipo) {
            case "modoConsCliente":
                this.listaClientes = clienteDAO.carregaClientes();
                if (listaClientes != null) {
                    carrega();
                }
                break;
            case "modoConsPdto":
                this.listaProdutos = produtoDAO.carregaProdutos();
                if (listaProdutos != null) {
                    carrega();
                }
                break;
            case "modoConsServico":
                this.listaServicos = servicoDAO.carregaServicos();
                if (listaServicos != null) {
                    carrega();
                }
                break;
            case "modoConsOS":
                btnNovo.setText("Nova");
                this.listaOs = osDAO.carregaOs();
                if (listaOs != null) {
                    carrega();
                }
                break;
            case "modoConsOrcamento":
                this.listaOrcamentos = orcamentoDAO.carregaOrcamento();
                if (listaOrcamentos != null) {
                    carrega();
                }
                break;
        }
    }

    public void carrega() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        switch (tipo) {
            case "modoConsCliente":
                this.setTitle("Consulta de clientes - SIGOMM");
                modelo.addColumn("Código");
                modelo.addColumn("Nome");
                modelo.addColumn("CPF/CNPJ");
                modelo.addColumn("Telefone");
                for (ClienteDTO clientes : listaClientes) {
                    modelo.addRow(clientes.getLinhaTabela());
                }
                break;
            case "modoConsMoto":
                this.setTitle("Consulta de motos - SIGOMM");
                modelo.addColumn("Código");
                modelo.addColumn("Placa");
                modelo.addColumn("Modelo");
                modelo.addColumn("Cor");
                for (MotoDTO motos : listaMotos) {
                    modelo.addRow(motos.getLinhaTabela());
                }
                break;
            case "modoConsPdto":
                this.setTitle("Consulta de produtos - SIGOMM");
                modelo.addColumn("Código");
                modelo.addColumn("Nome");
                modelo.addColumn("Marca");
                modelo.addColumn("Preço");
                for (ProdutoDTO produtos : listaProdutos) {
                    modelo.addRow(produtos.getLinhaTabela());
                }
                break;
            case "modoConsServico":
                this.setTitle("Consulta de serviços - SIGOMM");
                modelo.addColumn("Código");
                modelo.addColumn("Nome");
                modelo.addColumn("Preço");
                modelo.addColumn("Descrição");
                for (ServicoDTO servicos : listaServicos) {
                    modelo.addRow(servicos.getLinhaTabela());
                }
                break;
            case "modoConsOS":
                this.setTitle("Consulta de Ordens de serviços - SIGOMM");
                modelo.addColumn("Código");
                modelo.addColumn("Data");
                modelo.addColumn("Status");
                modelo.addColumn("Valor Total");
                for (OsDTO os : listaOs) {
                    modelo.addRow(os.getLinhaTabela());
                }
                break;
            case "modoConsOrcamento":
                this.setTitle("Consulta de orçamentos - SIGOMM");
                modelo.addColumn("Código");
                modelo.addColumn("Data");
                modelo.addColumn("Cliente");
                modelo.addColumn("Valor Total");
                for (OrcamentoDTO orcamentos : listaOrcamentos) {
                    modelo.addRow(orcamentos.getLinhaTabela());
                }
                break;
        }

        tabela.setModel(modelo);
        tabela.setAutoResizeMode(0);

        DefaultTableCellRenderer alinhamentoCentro = new DefaultTableCellRenderer();
        DefaultTableCellRenderer alinhamentoDireita = new DefaultTableCellRenderer();
        alinhamentoCentro.setHorizontalAlignment(SwingConstants.CENTER);
        alinhamentoDireita.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(alinhamentoCentro);
        tabela.getColumnModel().getColumn(1).setCellRenderer(alinhamentoCentro);
        tabela.getColumnModel().getColumn(2).setCellRenderer(alinhamentoCentro);
        tabela.getColumnModel().getColumn(3).setCellRenderer(alinhamentoDireita);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(240);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(151);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(151);

        tabela.setAutoResizeMode(0);
    }

    //Métodos de inserção:
    public void novoCliente() {
        if (novoCliente == null) {
            novoCliente = new Cliente(true, new ClienteDTO(), null, this);
            novoCliente.setVisible(true);
        } else {
            novoCliente.requestFocus();
            novoCliente.setVisible(true);
        }
        if (!novoCliente.isActive()) {
            carrega();
        }
    }

    public void novoProduto() {
        login = new Login(this, true);
        if (login.criaLogin()) {
            if (novoProduto == null) {
                novoProduto = new Produto(true, new ProdutoDTO(), null, this);
                novoProduto.setVisible(true);
            } else {
                novoProduto.requestFocus();
                novoProduto.setVisible(true);
            }
        }
    }

    public void novoServico() {
        login = new Login(this, true);
        if (login.criaLogin()) {
            if (novoServico == null) {
                novoServico = new Servico(true, new ServicoDTO(), null, this);
                novoServico.setVisible(true);
            } else {
                novoServico.requestFocus();
                novoServico.setVisible(true);
            }
        }
    }

    public void novoOrcamento() {
        if (novoOrcamento == null) {
            novoOrcamento = new Orcamento(true, new OrcamentoDTO(), null, this);
            novoOrcamento.setVisible(true);
        } else {
            novoOrcamento.requestFocus();
            novoOrcamento.setVisible(true);
        }
    }

    public void novaOs() {
        if (novaOrdemServico == null) {
            novaOrdemServico = new OrdemDeServico(true, new OsDTO(), null, this);
            novaOrdemServico.setVisible(true);
        } else {
            novaOrdemServico.requestFocus();
            novaOrdemServico.setVisible(true);
        }
    }

    //Método de exclusão:
    public void remove() {
        int linhaSelecionada;
        switch (tipo) {
            case "modoConsCliente":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    if (clienteDAO.removeCliente(codigo)) {
                        Mensagens.msgInfo("O cliente foi removido com sucesso!");
                        montaTabela();
                        //this.dispose();
                    }
                } else {
                    Mensagens.msgAviso("Selecione um cliente a ser removido!");
                }
                break;
            case "modoConsPdto":
                login = new Login(this, true);
                if (login.criaLogin()) {
                    linhaSelecionada = tabela.getSelectedRow();
                    if (linhaSelecionada > -1) {
                        Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                        if (produtoDAO.removeProduto(codigo)) {
                            Mensagens.msgInfo("O produto foi removido com sucesso!");
                            montaTabela();
                            //this.setVisible(false);
                        }
                    } else {
                        Mensagens.msgAviso("Selecione um produto a ser removido!");
                    }
                }
                break;
            case "modoConsServico":
                login = new Login(this, true);
                if (login.criaLogin()) {
                    linhaSelecionada = tabela.getSelectedRow();
                    if (linhaSelecionada > -1) {
                        Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                        if (servicoDAO.removeServico(codigo)) {
                            Mensagens.msgInfo("O serviço foi removido com sucesso!");
                            montaTabela();
                            //this.setVisible(false);
                        }
                    } else {
                        Mensagens.msgAviso("Selecione um serviço a ser removido!");
                    }
                }
                break;
            case "modoConsOS":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    if (osDAO.removeOS(codigo)) {
                        Mensagens.msgInfo("A ordem de serviço foi removida com sucesso!");
                        montaTabela();
                        //this.setVisible(false);
                    }
                } else {
                    Mensagens.msgAviso("Selecione uma ordem de serviço a ser removida!");
                }
                break;
            case "modoConsOrcamento":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    if (orcamentoDAO.removeOrcamento(codigo)) {
                        Mensagens.msgInfo("O orçamento foi removido com sucesso!");
                        montaTabela();
                        //this.setVisible(false);
                    }
                } else {
                    Mensagens.msgAviso("Selecione um orçamento a ser removido!");
                }
                break;
        }
    }

    public void edita() {
        int linhaSelecionada;
        switch (tipo) {
            case "modoConsCliente":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    ClienteDTO cliente = clienteDAO.puxaCliente(codigo);
                    if (novoCliente == null) {
                        novoCliente = new Cliente(false, cliente, null, this);
                        novoCliente.setVisible(true);
                        //this.setVisible(false);
                        montaTabela();
                    } else {
                        novoCliente.requestFocus();
                        novoCliente.setVisible(true);
                    }
                } else {
                    Mensagens.msgAviso("Selecione um cliente a ser alterado!");
                }
                break;
            case "modoConsPdto":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    ProdutoDTO produto = produtoDAO.puxaProduto(codigo);
                    login = new Login(this, true);
                    if (login.criaLogin()) {
                        if (novoProduto == null) {
                            novoProduto = new Produto(false, produto, null, this);
                            novoProduto.setVisible(true);
                            // this.setVisible(false);
                            montaTabela();
                        } else {
                            novoProduto.requestFocus();
                            novoProduto.setVisible(true);
                        }
                    }
                } else {
                    Mensagens.msgAviso("Selecione um produto a ser alterado!");
                }
                break;
            case "modoConsServico":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    ServicoDTO servico = servicoDAO.puxaServico(codigo);
                    login = new Login(this, true);
                    if (login.criaLogin()) {
                        if (novoServico == null) {
                            novoServico = new Servico(false, servico, null, this);
                            novoServico.setVisible(true);
                            //this.setVisible(false);
                            montaTabela();
                        } else {
                            novoServico.requestFocus();
                            novoServico.setVisible(true);
                        }
                    }
                } else {
                    Mensagens.msgAviso("Selecione um serviço a ser alterado!");
                }
                break;
            case "modoConsOS":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    OsDTO OrdemServico = osDAO.puxaOs(codigo);
                    if (novaOrdemServico == null) {
                        novaOrdemServico = new OrdemDeServico(false, OrdemServico, null, this);
                        novaOrdemServico.setVisible(true);
                        //this.setVisible(false);
                        montaTabela();
                    } else {
                        novaOrdemServico.requestFocus();
                        novaOrdemServico.setVisible(true);
                    }
                } else {
                    Mensagens.msgAviso("Selecione uma ordem de serviço a ser alterada!");
                }
                break;
            case "modoConsOrcamento":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    OrcamentoDTO orcamento = orcamentoDAO.puxaOrcamento(codigo);
                    if (novoOrcamento == null) {
                        novoOrcamento = new Orcamento(false, orcamento, null, this);
                        novoOrcamento.setVisible(true);
                        //this.setVisible(false);
                        montaTabela();
                    } else {
                        novoOrcamento.requestFocus();
                        novoOrcamento.setVisible(true);
                    }
                } else {
                    Mensagens.msgAviso("Selecione um orçamento a ser alterado!");
                }
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta - SIGOMM");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(11, 134, 195));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        btnEditar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/002-edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/004-error.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/001-plus.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnContinuar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/forward.png"))); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 0)));
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/001-cancel.png"))); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 0), null));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addGap(269, 269, 269)
                        .addComponent(btnNovo)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

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

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if (botaoOrcamento) {
            int linhaSelecionada = tabela.getSelectedRow();
            int codigo;
            if (linhaSelecionada > -1) {
                codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                orcamento.mostraCliente(codigo);
                this.dispose();
            } else {
                Mensagens.msgAviso("Selecione um cliente antes de continuar!");
            }
        } else if (c == null && telaPrincipal != null) {
            telaPrincipal.telaFechando(this, "");
        } else if (telaPrincipal == null && c != null) {
            c.telaFechando(this);
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (Mensagens.msgConf("Deseja mesmo excluir?")) {
            remove();
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        switch (tipo) {
            case "modoConsCliente":
                novoCliente();
                break;
            case "modoConsPdto":
                novoProduto();
                break;
            case "modoConsServico":
                novoServico();
                break;
            case "modoConsOS":
                novaOs();
                break;
            case "modoConsOrcamento":
                novoOrcamento();
                break;
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        edita();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.c = null;
    }//GEN-LAST:event_formWindowClosing

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if (c != null) {
            c.telaFechando(this);
        } else {
            telaPrincipal.telaFechando(this, "");
        }
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
