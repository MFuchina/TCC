package oficina.telas;

import javax.swing.SpinnerNumberModel;
import oficina.util.Mensagens;
import oficina.modelo.ProdutoDTO;
import oficina.modelo.ServicoDTO;
import oficina.persistencia.ProdutoDAO;
import oficina.persistencia.ServicoDAO;
import oficina.util.Validacao;

public class SelecaoItem extends javax.swing.JDialog {

    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final ServicoDAO servicoDAO = new ServicoDAO();
    private final Orcamento orcamento;
    private boolean ePdto;
    private final EditaOrcamento editaOrcamento;

    public boolean ePdto() {
        return ePdto;
    }

    public SelecaoItem(java.awt.Frame parent, boolean modal, EditaOrcamento eo, Orcamento orcamento) {
        super(parent, modal);
        this.orcamento = orcamento;
        this.editaOrcamento = eo;
        initComponents();
        this.setLocationRelativeTo(null);
        btnContinuar.setEnabled(false);
        caixaPreco.setEnabled(false);
        caixaQnt.setModel(new SpinnerNumberModel(1, 1, 100, 1));
    }

    ProdutoDTO p;
    ServicoDTO s;

    public void carregaLista(boolean eProduto) {
        if (eProduto) {
            selecao.removeAllItems();
            for (ProdutoDTO pdto : produtoDAO.carregaProdutos()) {
                selecao.addItem("Cód: " + pdto.getCod() + "  " + "Nome: " + pdto.getNome() + "  Preço: " + pdto.getPrecoUnit());
                p = pdto;
            }
        } else {
            selecao.removeAllItems();
            for (ServicoDTO serv : servicoDAO.carregaServicos()) {
                selecao.addItem("Cód: " + serv.getCod() + "  " + "Nome: " + serv.getNome());
                s = serv;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rProduto = new javax.swing.JRadioButton();
        rServico = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        selecao = new javax.swing.JComboBox<>();
        btnContinuar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelQnt = new javax.swing.JLabel();
        caixaQnt = new javax.swing.JSpinner();
        labelPreco = new javax.swing.JLabel();
        caixaPreco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleção de Produto/Serviço");
        setMaximumSize(new java.awt.Dimension(395, 383));
        setMinimumSize(new java.awt.Dimension(395, 383));

        jPanel1.setBackground(new java.awt.Color(11, 134, 195));
        jPanel1.setMaximumSize(new java.awt.Dimension(471, 383));
        jPanel1.setMinimumSize(new java.awt.Dimension(471, 383));

        rProduto.setBackground(new java.awt.Color(11, 134, 195));
        rProduto.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        rProduto.setText("Produto");
        rProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rProdutoActionPerformed(evt);
            }
        });

        rServico.setBackground(new java.awt.Color(11, 134, 195));
        rServico.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        rServico.setText("Serviço");
        rServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rServicoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Selecione");

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

        labelQnt.setBackground(new java.awt.Color(11, 134, 195));
        labelQnt.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        labelQnt.setForeground(new java.awt.Color(240, 240, 240));
        labelQnt.setText("Quantidade:");
        labelQnt.setEnabled(false);

        caixaQnt.setEnabled(false);

        labelPreco.setBackground(new java.awt.Color(11, 134, 195));
        labelPreco.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        labelPreco.setForeground(new java.awt.Color(240, 240, 240));
        labelPreco.setText("Preço:");
        labelPreco.setEnabled(false);

        caixaPreco.setToolTipText("Digite o preço do serviço.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selecao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelQnt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(caixaQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelPreco)
                                .addGap(18, 18, 18)
                                .addComponent(caixaPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(rProduto)
                        .addGap(71, 71, 71)
                        .addComponent(rServico)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rServico)
                    .addComponent(rProduto))
                .addGap(33, 33, 33)
                .addComponent(selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQnt)
                    .addComponent(caixaQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if (rProduto.isSelected() || rServico.isSelected()) {
            if (selecao.getSelectedIndex() == -1) {
                Mensagens.msgAviso("Selecione um item antes de continuar");
            } else {
                String[] cod = selecao.getSelectedItem().toString().split(" ");
                if (rProduto.isSelected()) {
                    ePdto = true;
                    for (ProdutoDTO pdto : produtoDAO.carregaProdutos()) {
                        if (pdto.getCod() == Integer.valueOf(cod[1])) {
                            int qnt = Integer.valueOf(caixaQnt.getValue().toString());
                            pdto.setQnt(qnt);
                            pdto.setPreco(qnt * (pdto.getPrecoUnit()));
                            if (orcamento != null) {
                                orcamento.setProdutoDTO(pdto);
                            } else {
                                editaOrcamento.setProdutoDTO(pdto);
                            }
                            break;
                        }
                    }
                    this.dispose();
                } else {
                    if (caixaPreco.getText().isEmpty()) {
                        Mensagens.msgAviso(caixaPreco.getToolTipText());
                    } else {
                        if (Validacao.validaFloat(caixaPreco, 1, 9999)) {
                            ePdto = false;
                            for (ServicoDTO servico : servicoDAO.carregaServicos()) {
                                if (servico.getCod() == Integer.valueOf(cod[1])) {
                                    servico.setPreco(Float.valueOf(caixaPreco.getText()));
                                    if (orcamento != null) {
                                        orcamento.setServicoDTO(servico);
                                    } else {
                                        editaOrcamento.setServicoDTO(servico);
                                    }
                                    this.dispose();
                                    break;
                                }
                            }
                        } else {
                            Mensagens.msgAviso("Preço inválido.");
                        }
                    }
                }
            }
        } else {
            Mensagens.msgAviso("Selecione um produto ou serviço antes de continuar.");
        }
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void rProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rProdutoActionPerformed
        if (rProduto.isSelected()) {
            btnContinuar.setEnabled(true);
            labelPreco.setEnabled(true);
            carregaLista(true);
            caixaPreco.setEnabled(false);
            rServico.setSelected(false);
            labelQnt.setEnabled(true);
            caixaQnt.setEnabled(true);
        }
    }//GEN-LAST:event_rProdutoActionPerformed

    private void rServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rServicoActionPerformed
        if (rServico.isSelected()) {
            btnContinuar.setEnabled(true);
            labelQnt.setEnabled(false);
            carregaLista(false);
            caixaQnt.setEnabled(false);
            rProduto.setSelected(false);
            labelPreco.setEnabled(true);
            caixaPreco.setEnabled(true);
        }
    }//GEN-LAST:event_rServicoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JTextField caixaPreco;
    private javax.swing.JSpinner caixaQnt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelQnt;
    private javax.swing.JRadioButton rProduto;
    private javax.swing.JRadioButton rServico;
    private javax.swing.JComboBox<String> selecao;
    // End of variables declaration//GEN-END:variables
}
