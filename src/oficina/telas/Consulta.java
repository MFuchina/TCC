package oficina.telas;

import java.util.ArrayList;
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
import oficina.persistencia.MotoDAO;
import oficina.persistencia.OrcamentoDAO;
import oficina.persistencia.OsDAO;
import oficina.persistencia.ProdutoDAO;
import oficina.persistencia.ServicoDAO;

public class Consulta extends javax.swing.JFrame {

    private final boolean modoOs;

    public Consulta(Estados modo, boolean modoOs) {
        this.tipo = modo.name();
        this.modoOs = modoOs;
        initComponents();
        //modoConsMoto, modoConsCliente, modoConsPdto, modoConsServico, modoConsOS, modoConsOrcamento;
        this.setLocationRelativeTo(null);
        switch (tipo) {
            case "modoConsCliente":
                this.listaClientes = clienteDAO.carregaClientes();
                if (listaClientes != null) {
                    carregaClientes();
                }
                break;
            case "modoConsMoto":
                btnNovo.setText("Nova");

                break;
            case "modoConsPdto":

                break;
            case "modoConsServico":

                break;
            case "modoConsOS":
                btnNovo.setText("Nova");

                break;
            case "modoConsOrcamento":

                break;
        }

    }

    private final String tipo;
    private ClienteDAO clienteDAO = new ClienteDAO();
    private MotoDAO motoDAO = new MotoDAO();
    private OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
    private OsDAO osDAO = new OsDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private ServicoDAO servicoDAO = new ServicoDAO();
    private ArrayList<ClienteDTO> listaClientes;
    private ArrayList<MotoDTO> listaMotos;
    private ArrayList<ProdutoDTO> listaProdutos;
    private ArrayList<ServicoDTO> listaServicos;
    private ArrayList<OsDTO> listaOS;
    private ArrayList<OrcamentoDTO> listaOrcamentos;

    public void carregaClientes() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF/CNPJ");
        modelo.addColumn("Telefone");

        for (ClienteDTO c : listaClientes) {
            modelo.addRow(c.getLinhaTabela());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(11, 134, 195));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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

        btnVoltar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/001-cancel.png"))); // NOI18N
        btnVoltar.setText("Cancelar");
        btnVoltar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 0)));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnNovo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar)
                            .addGap(26, 26, 26)
                            .addComponent(btnRemover)
                            .addGap(30, 30, 30)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if (modoOs) {
            ListaDeMotos lista = new ListaDeMotos(this, true);
            lista.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnContinuarActionPerformed


    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int linhaSelecionada;
        switch (tipo) {
            case "modoConsCliente":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    if (clienteDAO.removeCliente(codigo)) {
                        Mensagens.msgInfo("O cliente foi removido com sucesso!");
                        Consulta consulta = new Consulta(Estados.modoConsCliente, false);
                        consulta.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    Mensagens.msgAviso("Selecione um cliente a ser removido!");
                }
                break;
            case "modoConsMoto":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    if (motoDAO.removeMoto(codigo)) {
                        Mensagens.msgInfo("A moto foi removida com sucesso!");
                        Consulta consulta = new Consulta(Estados.modoConsMoto, false);
                        consulta.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    Mensagens.msgAviso("Selecione uma moto a ser removida!");
                }
                break;
            case "modoConsPdto":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    if (produtoDAO.removeProduto(codigo)) {
                        Mensagens.msgInfo("O produto foi removido com sucesso!");
                        Consulta consulta = new Consulta(Estados.modoConsPdto, false);
                        consulta.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    Mensagens.msgAviso("Selecione um produto a ser removido!");
                }
                break;
            case "modoConsServico":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    if (servicoDAO.removeServico(codigo)) {
                        Mensagens.msgInfo("O serviço foi removido com sucesso!");
                        Consulta consulta = new Consulta(Estados.modoConsServico, false);
                        consulta.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    Mensagens.msgAviso("Selecione um serviço a ser removido!");
                }
                break;
            case "modoConsOS":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    if (osDAO.removeOS(codigo)) {
                        Mensagens.msgInfo("A ordem de serviço foi removida com sucesso!");
                        Consulta consulta = new Consulta(Estados.modoConsOS, false);
                        consulta.setVisible(true);
                        this.setVisible(false);
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
                        Consulta consulta = new Consulta(Estados.modoConsOrcamento, false);
                        consulta.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    Mensagens.msgAviso("Selecione um orçamento a ser removido!");
                }
                break;
        }


    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        switch (tipo) {
            case "modoConsCliente":
                Cadastro cadastro = new Cadastro(true, new ClienteDTO());
                cadastro.setVisible(true);
                this.setVisible(false);
                break;
            case "modoConsMoto":
                Moto moto = new Moto(true, new MotoDTO(), 1);
                moto.setVisible(true);
                this.setVisible(false);
                break;
            case "modoConsPdto":
                Produto p = new Produto(true, new ProdutoDTO());
                p.setVisible(true);
                this.setVisible(false);
                break;
            case "modoConsServico":
                Servico s = new Servico(true, new ServicoDTO());
                s.setVisible(true);
                this.setVisible(false);
                break;
            case "modoConsOS":
                OrdemDeServico os = new OrdemDeServico(new OsDTO());
                os.setVisible(true);
                this.setVisible(false);
                break;
            case "modoConsOrcamento":
                Orcamento o = new Orcamento(true, new OrcamentoDTO());
                o.setVisible(true);
                this.setVisible(false);
                break;
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linhaSelecionada;
        switch (tipo) {
            case "modoConsCliente":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    ClienteDTO cliente = clienteDAO.puxaCliente(codigo);
                    Cadastro cadastro = new Cadastro(false, cliente);
                    cadastro.setVisible(true);
                    this.setVisible(false);
                } else {
                    Mensagens.msgAviso("Selecione um cliente a ser alterado!");
                }
                break;
            case "modoConsMoto":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    MotoDTO moto = motoDAO.puxaMoto(codigo);
                    Moto m = new Moto(false, moto, moto.getCod_dono());
                    m.setVisible(true);
                    this.setVisible(false);
                } else {
                    Mensagens.msgAviso("Selecione uma moto a ser alterada!");
                }
                break;
            case "modoConsPdto":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    ProdutoDTO produto = produtoDAO.puxaProduto(codigo);
                    Produto p = new Produto(false, produto);
                    p.setVisible(true);
                    this.setVisible(false);
                } else {
                    Mensagens.msgAviso("Selecione um cliente a ser alterado!");
                }
                break;
            case "modoConsServico":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    ServicoDTO servico = servicoDAO.puxaServico(codigo);
                    Servico s = new Servico(false, servico);
                    s.setVisible(true);
                    this.setVisible(false);
                } else {
                    Mensagens.msgAviso("Selecione um cliente a ser alterado!");
                }
                break;
            case "modoConsOS":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    OsDTO OrdemServico = osDAO.puxaOs(codigo);
                    OrdemDeServico os = new OrdemDeServico(OrdemServico);
                    os.setVisible(true);
                    this.setVisible(false);
                } else {
                    Mensagens.msgAviso("Selecione uma ordem de serviço a ser alterada!");
                }
                break;
            case "modoConsOrcamento":
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada > -1) {
                    Integer codigo = (Integer) tabela.getValueAt(linhaSelecionada, 0);
                    OrcamentoDTO orcamento = orcamentoDAO.puxaOrcamento(codigo);
                    Orcamento o = new Orcamento(false, orcamento);
                    o.setVisible(true);
                    this.setVisible(false);
                } else {
                    Mensagens.msgAviso("Selecione um cliente a ser alterado!");
                }
                break;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
