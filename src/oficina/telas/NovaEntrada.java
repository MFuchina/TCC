package oficina.telas;

import java.text.SimpleDateFormat;
import java.util.Date;
import oficina.modelo.EntradaDTO;
import oficina.persistencia.GerenteDAO;
import oficina.util.Mensagens;
import oficina.util.Validacao;

public class NovaEntrada extends javax.swing.JDialog {

    public NovaEntrada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        dataSQL = formatarDate.format(date);
    }
    
    String dataSQL;
    private GerenteDAO g = new GerenteDAO();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rDinheiro = new javax.swing.JRadioButton();
        rCartao = new javax.swing.JRadioButton();
        rCheque = new javax.swing.JRadioButton();
        textValor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoSalvarMoto = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova entrada - SIGOMM");

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel1.setText("Nova Entrada");

        rDinheiro.setFont(new java.awt.Font("Maiandra GD", 0, 15)); // NOI18N
        rDinheiro.setText("Dinheiro");
        rDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rDinheiroActionPerformed(evt);
            }
        });

        rCartao.setFont(new java.awt.Font("Maiandra GD", 0, 15)); // NOI18N
        rCartao.setText("Cartão");
        rCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCartaoActionPerformed(evt);
            }
        });

        rCheque.setFont(new java.awt.Font("Maiandra GD", 0, 15)); // NOI18N
        rCheque.setText("Cheque");
        rCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rChequeActionPerformed(evt);
            }
        });

        textValor.setToolTipText("Informe o valor a ser adiconado.");
        textValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textValorKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        jLabel2.setText("Valor:");

        botaoSalvarMoto.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        botaoSalvarMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/002-checked.png"))); // NOI18N
        botaoSalvarMoto.setText("Salvar");
        botaoSalvarMoto.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 0), null));
        botaoSalvarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarMotoActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(rDinheiro)
                        .addGap(37, 37, 37)
                        .addComponent(rCartao)
                        .addGap(33, 33, 33)
                        .addComponent(rCheque))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoSalvarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rDinheiro)
                    .addComponent(rCartao)
                    .addComponent(rCheque))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rDinheiroActionPerformed
        if(rCartao.isSelected() || rCheque.isSelected()){
            rCartao.setSelected(false);
            rCheque.setSelected(false);
            rDinheiro.setSelected(true);
        }
    }//GEN-LAST:event_rDinheiroActionPerformed

    private void botaoSalvarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarMotoActionPerformed
        if (rCartao.isSelected() || rDinheiro.isSelected() || rCheque.isSelected()) {
            if(!textValor.getText().isEmpty() && Validacao.validaFloat(textValor, 0, 9999)){
                String tipo;
                if(rDinheiro.isSelected()){
                    tipo = "D";
                }else if(rCartao.isSelected()){
                    tipo = "C";
                }else{
                    tipo = "CQ";
                }
                EntradaDTO e = new EntradaDTO(Float.valueOf(textValor.getText()), tipo, dataSQL);
                if(g.salvaEntrada(e)){
                  Mensagens.msgInfo("Entrada adicionada com sucesso.");
                }
                this.dispose();
            }else{
                Mensagens.msgAviso("Informe corretamente o valor a ser adicionado.");
            }
        }else{
            Mensagens.msgAviso("Selecione um meio de pagamento (Dinheiro, Cartão ou Cheque).");
        }
    }//GEN-LAST:event_botaoSalvarMotoActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
            this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void rCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCartaoActionPerformed
        if(rDinheiro.isSelected() || rCheque.isSelected()){
            rCartao.setSelected(true);
            rCheque.setSelected(false);
            rDinheiro.setSelected(false);
        }
    }//GEN-LAST:event_rCartaoActionPerformed

    private void rChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rChequeActionPerformed
        if(rCartao.isSelected() || rDinheiro.isSelected()){
            rCartao.setSelected(false);
            rCheque.setSelected(true);
            rDinheiro.setSelected(false);
        }
    }//GEN-LAST:event_rChequeActionPerformed

    private void textValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValorKeyTyped
       String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }else {
            if (textValor.getText().length() == 10) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_textValorKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvarMoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rCartao;
    private javax.swing.JRadioButton rCheque;
    private javax.swing.JRadioButton rDinheiro;
    private javax.swing.JTextField textValor;
    // End of variables declaration//GEN-END:variables
}
