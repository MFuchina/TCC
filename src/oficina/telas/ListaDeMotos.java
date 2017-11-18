package oficina.telas;

import javax.swing.JFrame;
import oficina.util.Mensagens;
import oficina.modelo.MotoDTO;
import oficina.persistencia.MotoDAO;

public class ListaDeMotos extends javax.swing.JFrame {

    private final MotoDAO motoDAO = new MotoDAO();
    private Moto novaMoto = null;
    private MotoDTO motoDTO = null;
    private final int codigoDono;
    private final Orcamento orcamento;

    public ListaDeMotos(int codigo, Orcamento orcamento) {
        this.codigoDono = codigo;
        this.orcamento = orcamento;
        initComponents();
        carregaLista();
        if (selecao.getItemCount() == 0) {
            botaoEditar.setEnabled(false);
            botaoRemover.setEnabled(false);
            botaoNovaMoto.setEnabled(true);
        } else {
            botaoEditar.setEnabled(true);
            botaoRemover.setEnabled(true);
            botaoNovaMoto.setEnabled(true);
        }
        //selecao.getSelectedItem();
        this.setLocationRelativeTo(null);
    }

    public void carregaLista() {
        selecao.removeAllItems();
        for (MotoDTO motoo : motoDAO.carregaMotos(codigoDono)) {
            selecao.addItem("Cód.Moto: " + motoo.getCod_moto() + " " + "Modelo: " + motoo.getModelo() + " Placa: " + motoo.getPlaca());
        }
    }

    public void telaFechando(JFrame tela) {
        novaMoto = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        selecao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        botaoNovaMoto = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoContinuar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de motos");
        setMaximumSize(new java.awt.Dimension(428, 263));
        setMinimumSize(new java.awt.Dimension(428, 263));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(11, 134, 195));

        selecao.setToolTipText("Selecione uma moto.");

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Selecione uma moto:");

        botaoNovaMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/001-plus.png"))); // NOI18N
        botaoNovaMoto.setToolTipText("Adicionar nova moto.");
        botaoNovaMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovaMotoActionPerformed(evt);
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

        botaoContinuar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        botaoContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/forward.png"))); // NOI18N
        botaoContinuar.setText("Continuar");
        botaoContinuar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 51), null));
        botaoContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoContinuarActionPerformed(evt);
            }
        });

        botaoEditar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        botaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/002-edit.png"))); // NOI18N
        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoRemover.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        botaoRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/001-cancel.png"))); // NOI18N
        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoEditar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(botaoNovaMoto)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNovaMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoEditar)
                        .addComponent(botaoRemover)))
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selecao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void botaoNovaMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaMotoActionPerformed
        //botaoNovaMoto.setEnabled(false);
        if (novaMoto == null) {
            novaMoto = new Moto(true, new MotoDTO(), codigoDono, null, this);
            novaMoto.setVisible(true);
            this.setVisible(false);
        } else {
            novaMoto.requestFocus();
            novaMoto.setVisible(true);
            this.setVisible(false);
        }
        if (novaMoto == null) {
            this.setVisible(true);
        }
        carregaLista();
    }//GEN-LAST:event_botaoNovaMotoActionPerformed

    private MotoDTO moto;

    public MotoDTO getMoto() {
        return moto;
    }

    private void botaoContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoContinuarActionPerformed
        if (selecao.getItemCount() != 0) {
            String[] codMoto = selecao.getSelectedItem().toString().split(" ");

            for (MotoDTO motoO : motoDAO.carregaMotos(codigoDono)) {
                if (motoO.getCod_moto() == Integer.valueOf(codMoto[1])) {
                    if (orcamento != null) {
                        orcamento.mostraMoto(motoO);
                    } else {
                        moto = motoO;
                    }
                    break;
                }
            }
            this.dispose();
        } else {
            Mensagens.msgAviso("Selecione uma moto antes de continuar.");
        }
    }//GEN-LAST:event_botaoContinuarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        //String codMoto = (String) selecao.getSelectedItem();
        //botaoNovaMoto.setEnabled(false);
        if (!selecao.getSelectedItem().toString().equals("")) {
            if (novaMoto == null) {
                String[] codMoto = selecao.getSelectedItem().toString().split(" ");
                for (MotoDTO motoo : motoDAO.carregaMotos(codigoDono)) {
                    if (motoo.getCod_moto() == Integer.valueOf(codMoto[1])) {
                        motoDTO = motoo;
                        break;
                    }
                }
                novaMoto = new Moto(false, motoDTO, codigoDono, null, this);
                novaMoto.setVisible(true);
            } else {
                novaMoto.requestFocus();
                novaMoto.setVisible(true);
            }
        } else {
            Mensagens.msgAviso("Selecione a moto a ser alterada.");
        }

        carregaLista();
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if (!selecao.getSelectedItem().toString().equals("")) {
            String[] codMoto = selecao.getSelectedItem().toString().split(" ");
            if (motoDAO.removeMoto(Integer.valueOf(codMoto[1]))) {
                Mensagens.msgInfo("Moto removida com sucesso.");
                carregaLista();
            }
        } else {
            Mensagens.msgAviso("Selecione a moto a ser removida");
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoContinuar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoNovaMoto;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selecao;
    // End of variables declaration//GEN-END:variables
}
