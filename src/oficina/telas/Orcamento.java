package oficina.telas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import oficina.util.Estados;
import oficina.util.Mensagens;
import oficina.modelo.MotoDTO;
import oficina.modelo.OrcamentoDTO;
import oficina.modelo.ProdutoDTO;
import oficina.modelo.ServicoDTO;
import oficina.persistencia.ClienteDAO;
import oficina.persistencia.OrcamentoDAO;

public class Orcamento extends javax.swing.JFrame {

    private final boolean modoInclusao;
    private int codCliente;

    private final OrcamentoDTO orcamento;

    private final OrcamentoDAO o = new OrcamentoDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();

    private ListaDeMotos listaMotos;
    private final Principal formularioPrincipal;
    private Consulta consulta = null;

    private ProdutoDTO produtoDTO = new ProdutoDTO();
    private ServicoDTO servicoDTO = new ServicoDTO();
    private final ArrayList<String> lista = new ArrayList<>();

    public ArrayList<String> getLista() {
        return lista;
    }

    float total = (float) 0.0;

    public void setProdutoDTO(ProdutoDTO pdto) {
        produtoDTO = pdto;
    }

    public void setServicoDTO(ServicoDTO servico) {
        servicoDTO = servico;
    }

    public void mostraCliente(int codigoCliente) {
        codCliente = codigoCliente;
        textCliente.setText(clienteDAO.puxaNomeCliente(codigoCliente));
        btnProcurarMoto.setEnabled(true);
    }

    public void mostraMoto(MotoDTO moto) {
        textMoto.setText(moto.getModelo() + " " + moto.getAno_Fabr() + " - " + moto.getCor() + " Placa: " + moto.getPlaca());
    }

    public Orcamento(boolean modoInclusao, OrcamentoDTO orcamento, Principal formPrincipal, Consulta c) {
        this.consulta = c;
        this.formularioPrincipal = formPrincipal;
        this.orcamento = orcamento;
        this.modoInclusao = modoInclusao;
        initComponents();
        this.setLocationRelativeTo(null);
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        data.setText(formatarDate.format(date));
        btnProcurarMoto.setEnabled(false);
        if (modoInclusao == false) {
            cod.setText(String.valueOf(orcamento.getCod_Orcamento()));
        } else {
            cod.setText(o.retornaUltimoCodigo());
        }
        criaTabela();
    }

    DefaultTableModel modelo;

    public void criaTabela() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("Qnt.");
        modelo.addColumn("Descrição");
        modelo.addColumn("Preço Unit.");
        modelo.addColumn("Preço Total");
    }

    public void adicionaProduto() {
        if (produtoDTO != null) {
            if (!produtoDTO.getNome().equals("")) {
                String aux = String.valueOf(produtoDTO.getQnt() + ";" + produtoDTO.getNome() + ";" + produtoDTO.getPrecoUnit() + ";" + produtoDTO.getPreco());
                String[] oi = aux.split(";");
                modelo.addRow(oi);
            }
        }
    }

    private void adicionaServico() {
        if (servicoDTO != null) {
            if (!servicoDTO.getNome().equals("")) {
                String aux = String.valueOf("" + ";" + servicoDTO.getNome() + ";" + "" + ";" + servicoDTO.getPreco());
                String[] oi = aux.split(";");
                modelo.addRow(oi);
                total = total + (servicoDTO.getPreco());
                textTotal.setText(String.valueOf(total));
            }
        }
    }

    public boolean removeItem(int i) {
        if (modelo.getValueAt(i, 1).equals("Mão de obra") || modelo.getValueAt(i,1).equals("Revisão")) {
            total = total - Float.valueOf(String.valueOf(modelo.getValueAt(i, 3)));
            textTotal.setText(String.valueOf(total));
            modelo.removeRow(i);
        } else {
            int novaQnt = Integer.valueOf(String.valueOf(modelo.getValueAt(i, 0))) - 1;
            float novoValor = Float.valueOf(String.valueOf(modelo.getValueAt(i, 3))) - Float.valueOf(String.valueOf(modelo.getValueAt(i, 2)));
            modelo.setValueAt(novaQnt, i, 0);
            modelo.setValueAt(novoValor, i, 3);
            total = total - Float.valueOf(String.valueOf(modelo.getValueAt(i, 2)));
            textTotal.setText(String.valueOf(total));
        }
        return true;
    }

    public void colocaNaTabela(boolean ePdto) {
        if (ePdto) {
            boolean achou = false;
            if (modelo.getRowCount() != 0) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (modelo.getValueAt(i, 1).equals(produtoDTO.getNome())) {
                        int novaQnt = produtoDTO.getQnt() + Integer.valueOf(String.valueOf(modelo.getValueAt(i, 0)));
                        float novoValor = produtoDTO.getPreco() + Float.valueOf(String.valueOf(modelo.getValueAt(i, 3)));
                        modelo.setValueAt(novaQnt, i, 0);
                        modelo.setValueAt(novoValor, i, 3);
                        achou = true;
                        break;
                    }
                }
                if (!achou) {
                    adicionaProduto();
                }
            } else {
                adicionaProduto();
            }
            total = total + ((produtoDTO.getQnt()) * produtoDTO.getPrecoUnit());
            textTotal.setText(String.valueOf(total));
        } else {
            boolean achou = false;
            if (modelo.getRowCount() != 0) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (modelo.getValueAt(i, 1).equals(servicoDTO.getNome())) {
                        float novoValor = servicoDTO.getPreco();
                        total = total - Float.valueOf(String.valueOf(modelo.getValueAt(i, 3)));
                        modelo.setValueAt(novoValor, i, 3);
                        total = total + (servicoDTO.getPreco());
                        textTotal.setText(String.valueOf(total));
                        achou = true;
                        break;
                    }
                }
                if (!achou) {
                    adicionaServico();
                }
            } else {
                adicionaServico();
            }
        }
        carrega();
    }

    public void carrega() {
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

        tabela.getColumnModel().getColumn(0).setPreferredWidth(64);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(280);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(110);

        tabela.setAutoResizeMode(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textMoto = new javax.swing.JTextField();
        textCliente = new javax.swing.JTextField();
        btnProcurarCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        novo = new javax.swing.JButton();
        btnProcurarMoto = new javax.swing.JButton();
        btnGerarOS = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orçamento - SIGOMM");
        setMaximumSize(new java.awt.Dimension(630, 630));
        setMinimumSize(new java.awt.Dimension(630, 630));
        setPreferredSize(new java.awt.Dimension(630, 630));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(630, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 630));

        cod.setEditable(false);
        cod.setToolTipText("O código é gerado automaticamente.");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel1.setText("Orçamento nº:");

        data.setEditable(false);
        data.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel3.setText("Data:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel5.setText("Moto:");

        textMoto.setEditable(false);
        textMoto.setToolTipText("Selecione a moto do cliente.");

        textCliente.setEditable(false);
        textCliente.setToolTipText("Selecione o nome do cliente.");

        btnProcurarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/003-profile-1.png"))); // NOI18N
        btnProcurarCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 111, 153)));
        btnProcurarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarClienteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 3, 18)); // NOI18N
        jLabel7.setText("VALOR TOTAL:");

        textTotal.setEditable(false);
        textTotal.setToolTipText("Valor total em reais.");

        botaoSalvar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        botaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/002-checked.png"))); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 51), null));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
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

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Quantidade", "Descrição", "Preço Unit.", "Preço Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setFocusable(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(3).setResizable(false);
        }

        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/001-plus.png"))); // NOI18N
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });

        btnProcurarMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/motorbike.png"))); // NOI18N
        btnProcurarMoto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 111, 153)));
        btnProcurarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarMotoActionPerformed(evt);
            }
        });

        btnGerarOS.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        btnGerarOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/011-note.png"))); // NOI18N
        btnGerarOS.setText("Gerar O.S.");
        btnGerarOS.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 111, 153)));
        btnGerarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarOSActionPerformed(evt);
            }
        });

        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/004-error.png"))); // NOI18N
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(textMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnProcurarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(textCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnProcurarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(novo)))
                        .addGap(41, 41, 41))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnGerarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(textCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnProcurarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProcurarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(textMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(novo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarClienteActionPerformed
        consulta = new Consulta(Estados.modoConsCliente, null, consulta, true, this);
        consulta.setVisible(true);
        textMoto.setText("");
    }//GEN-LAST:event_btnProcurarClienteActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        if (textCliente.getText().isEmpty()) {
            Mensagens.msgAviso(textCliente.getToolTipText());
        } else if (textMoto.getText().isEmpty()) {
            Mensagens.msgAviso(textMoto.getToolTipText());
        } else {
            boolean tem = true;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 1).equals("")) {
                    Mensagens.msgErro("Não existem itens listados no orçamento.");
                    modelo.removeRow(i);
                    tem = false;
                    break;
                }
            }
            if (tem) {
                //Salva no BD
                if (consulta == null) {
                    formularioPrincipal.telaFechando(this, "");
                } else {
                    consulta.telaFechando(this);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if (consulta == null) {
            formularioPrincipal.telaFechando(this, "");
        } else {
            consulta.telaFechando(this);
        }
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        SelecaoItem s = new SelecaoItem(this, true, this);
        s.setVisible(true);
        if (s.ePdto()) {
            colocaNaTabela(true);
        } else {
            colocaNaTabela(false);
        }
    }//GEN-LAST:event_novoActionPerformed

    private void btnGerarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGerarOSActionPerformed

    private void btnProcurarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarMotoActionPerformed
        listaMotos = new ListaDeMotos(/*null, true,*/codCliente, this, null);
        listaMotos.setVisible(true);
    }//GEN-LAST:event_btnProcurarMotoActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        int linhaSelecionada;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada > -1) {
            if (modelo.getRowCount() != 0) { 
                if (modelo.getValueAt(linhaSelecionada, 0).toString().equals("1")) {
                        total = total - Float.valueOf(String.valueOf(modelo.getValueAt(linhaSelecionada, 3)));
                        textTotal.setText(String.valueOf(total));
                        modelo.removeRow(linhaSelecionada);
                        carrega();
                    } else {
                        if (removeItem(linhaSelecionada)) {
                            carrega();
                        }
                    }
            } else {
                Mensagens.msgAviso("A tabela está vazia.");
            }
        } else {
            Mensagens.msgAviso("Selecione um item a ser removido!");
        }
    }//GEN-LAST:event_removeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton btnGerarOS;
    private javax.swing.JButton btnProcurarCliente;
    private javax.swing.JButton btnProcurarMoto;
    private javax.swing.JTextField cod;
    private javax.swing.JTextField data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton novo;
    private javax.swing.JButton remove;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField textCliente;
    private javax.swing.JTextField textMoto;
    private javax.swing.JTextField textTotal;
    // End of variables declaration//GEN-END:variables
}
