package oficina.telas;

import javax.swing.SpinnerNumberModel;
import oficina.util.Mensagens;
import oficina.modelo.ProdutoDTO;
import oficina.modelo.ServicoDTO;
import oficina.persistencia.ProdutoDAO;
import oficina.persistencia.ServicoDAO;

public class SelecaoItem extends javax.swing.JDialog {

    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final ServicoDAO servicoDAO = new ServicoDAO();
    private final Orcamento orcamento;

    public SelecaoItem(java.awt.Frame parent, boolean modal, Orcamento orcamento) {
        super(parent, modal);
        this.orcamento = orcamento;
        initComponents();
        this.setLocationRelativeTo(null);
        btnContinuar.setEnabled(false);
        caixaQnt.setModel(new SpinnerNumberModel(1, 1, 100, 1));
    }

    public void carregaLista(boolean eProduto) {
        if (eProduto) {
            selecao.removeAllItems();
            for (ProdutoDTO pdto : produtoDAO.carregaProdutos()) {
                selecao.addItem("Cód.Produto: " + pdto.getCod() + " " + "Nome: " + pdto.getNome());
            }
        } else {
            selecao.removeAllItems();
            for (ServicoDTO serv : servicoDAO.carregaServicos()) {
                selecao.addItem("Cód.Serviço: " + serv.getCod() + " " + "Nome: " + serv.getNome());
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
        botaoCarregar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelQnt = new javax.swing.JLabel();
        caixaQnt = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleção de Produto/Serviço");

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

        botaoCarregar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        botaoCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/update.png"))); // NOI18N
        botaoCarregar.setText("Carregar");
        botaoCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCarregarActionPerformed(evt);
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

        labelQnt.setBackground(new java.awt.Color(11, 134, 195));
        labelQnt.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        labelQnt.setForeground(new java.awt.Color(240, 240, 240));
        labelQnt.setText("Quantidade:");
        labelQnt.setEnabled(false);

        caixaQnt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rProduto)
                                .addGap(18, 18, 18)
                                .addComponent(rServico)
                                .addGap(18, 18, 18)
                                .addComponent(botaoCarregar))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(selecao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(labelQnt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caixaQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rProduto)
                    .addComponent(rServico)
                    .addComponent(botaoCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQnt))
                .addGap(61, 61, 61)
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

    private void botaoCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCarregarActionPerformed
        btnContinuar.setEnabled(true);
        labelQnt.setEnabled(false);
        caixaQnt.setEnabled(false);
        if (rProduto.isSelected() || rServico.isSelected()) {
            if (rProduto.isSelected()) {
                carregaLista(true);
                labelQnt.setEnabled(true);
                caixaQnt.setEnabled(true);
            } else {
                carregaLista(false);
            }
        } else {
            Mensagens.msgAviso("Selecione produto ou serviço.");
            btnContinuar.setEnabled(false);
        }
    }//GEN-LAST:event_botaoCarregarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if (selecao.getSelectedIndex() == -1) {
            Mensagens.msgAviso("Selecione um item antes de continuar");
        } else {
            String[] cod = selecao.getSelectedItem().toString().split(" ");
            if (rProduto.isSelected()) {
                for (ProdutoDTO pdto : produtoDAO.carregaProdutos()) {
                    if (pdto.getCod() == Integer.valueOf(cod[1])) {
                        int qnt = Integer.valueOf(caixaQnt.getValue().toString());
                        pdto.setQnt(qnt);
                        pdto.setPreco(qnt*(pdto.getPrecoUnit()));
                        orcamento.setProdutoDTO(pdto);
                        orcamento.setServicoDTO(null);
                        break;
                    }
                }
            } else {
                for (ServicoDTO servico : servicoDAO.carregaServicos()) {
                    if (servico.getCod() == Integer.valueOf(cod[1])) {
                        orcamento.setProdutoDTO(null);
                        orcamento.setServicoDTO(servico);
                        break;
                    }
                }
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void rProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rProdutoActionPerformed
        if (rProduto.isSelected()) {
            rServico.setSelected(false);
        }
    }//GEN-LAST:event_rProdutoActionPerformed

    private void rServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rServicoActionPerformed
        if (rServico.isSelected()) {
            rProduto.setSelected(false);
        }
    }//GEN-LAST:event_rServicoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoCarregar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JSpinner caixaQnt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelQnt;
    private javax.swing.JRadioButton rProduto;
    private javax.swing.JRadioButton rServico;
    private javax.swing.JComboBox<String> selecao;
    // End of variables declaration//GEN-END:variables
}
