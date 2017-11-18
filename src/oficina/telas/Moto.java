package oficina.telas;

import oficina.util.Mensagens;
import oficina.util.Validacao;
import oficina.modelo.MotoDTO;
import oficina.persistencia.MotoDAO;

public class Moto extends javax.swing.JFrame {

    private final MotoDTO moto;
    private final MotoDAO m = new MotoDAO();
    private final boolean modoInclusao;
    private final int codDono;
    private final Cliente cliente;
    private final ListaDeMotos listaMotos;

    public Moto(boolean modoInclusao, MotoDTO moto, int codDono, Cliente cliente, ListaDeMotos listaMotos) {
        this.codDono = codDono;
        this.moto = moto;
        this.modoInclusao = modoInclusao;
        this.cliente = cliente;
        this.listaMotos = listaMotos;
        initComponents();
        this.setLocationRelativeTo(null);
        if (modoInclusao == false) {
            cod.setText(String.valueOf(moto.getCod_moto()));
            placa.setText(moto.getPlaca());
            chassi.setText(moto.getChassi());
            cor.setText(moto.getCor());
            anoFabr.setText(String.valueOf(moto.getAno_Fabr()));
            anoModelo.setText(String.valueOf(moto.getAno_modelo()));
            modelo.setText(moto.getModelo());
            marca.setText(moto.getMarca());
        }else{
            cod.setText(m.retornaUltimoCodigo());
        }
    }

    public boolean CadastraAlteraMoto() {
        boolean aux = false;
        if (Validacao.validaCampo(placa, "placa da moto")
                && Validacao.validaCampo(marca, "marca da moto") && Validacao.validaCampo(chassi, "chassi da moto")
                && Validacao.validaCampo(modelo, "modelo da moto") && Validacao.validaCampo(cor, "cor da moto")
                && Validacao.validaInteiro(anoFabr) && Validacao.validaInteiro(anoModelo)) {
            if (modoInclusao) {
                if (m.verificaDispon(placa.getText(), Integer.valueOf(cod.getText()))) {
                    Mensagens.msgAviso("Essa moto já está cadastrada.");
                } else {
                    moto.setCod_moto(Integer.valueOf(cod.getText()));
                    moto.setAno_Fabr(Integer.valueOf(anoFabr.getText()));
                    moto.setMarca(marca.getText());
                    moto.setAno_modelo(Integer.valueOf(anoModelo.getText()));
                    moto.setChassi(chassi.getText());
                    moto.setCod_dono(codDono);
                    moto.setCor(cor.getText());
                    moto.setPlaca(placa.getText());
                    moto.setModelo(modelo.getText());
                    aux = m.cadastraMoto(moto);
                }
            } else {
                moto.setCod_moto(Integer.valueOf(cod.getText()));
                moto.setAno_Fabr(Integer.valueOf(anoFabr.getText()));
                moto.setMarca(marca.getText());
                moto.setAno_modelo(Integer.valueOf(anoModelo.getText()));
                moto.setChassi(chassi.getText());
                moto.setCod_dono(codDono);
                moto.setCor(cor.getText());
                moto.setPlaca(placa.getText());
                moto.setModelo(modelo.getText());
                aux = m.alteraMoto(moto);
            }
        }
        if (modoInclusao && aux && (cliente != null)) {
            Mensagens.msgInfo("Cliente adicionado com sucesso.");
        } else if (!modoInclusao && aux) {
            Mensagens.msgInfo("Moto alterada com sucesso.");
        } else if (modoInclusao && aux) {
            Mensagens.msgInfo("Moto adicionada com sucesso.");
        }
        return aux;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cod = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        placa = new javax.swing.JTextField();
        chassi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        marca = new javax.swing.JTextField();
        modelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cor = new javax.swing.JTextField();
        anoFabr = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        anoModelo = new javax.swing.JTextField();
        botaoSalvarMoto = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Moto  - SIGOMM");
        setMaximumSize(new java.awt.Dimension(391, 485));
        setMinimumSize(new java.awt.Dimension(391, 485));

        jPanel1.setBackground(new java.awt.Color(11, 134, 195));

        cod.setEditable(false);
        cod.setToolTipText("O código da moto é gerado automaticamente.");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Código da moto:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Placa:");

        placa.setToolTipText("Informe a placa da moto.");

        chassi.setToolTipText("Informe o chassi da moto.");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Chassi: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Marca:");

        marca.setToolTipText("Digite a marca da moto.");

        modelo.setToolTipText("Informe o modelo da moto.");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Modelo:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Cor:");

        cor.setToolTipText("Informe a cor da moto.");

        anoFabr.setToolTipText("Informe o ano de fabricação da moto.");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Ano de fabricação:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Ano do modelo:");

        anoModelo.setToolTipText("Informe o ano do modelo da moto.");

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
                        .addGap(155, 155, 155)
                        .addComponent(botaoSalvarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chassi, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(anoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(anoFabr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(11, 11, 11)))
                            .addComponent(jLabel8))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(placa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(chassi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(anoFabr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(anoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if (Mensagens.msgConf("Deseja mesmo sair? Os dados da moto serão perdidos.")) {
            this.dispose();
            if (cliente != null) {
                cliente.dispose();
            }
            listaMotos.telaFechando(this);
            this.dispose();
        }
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarMotoActionPerformed
        if (CadastraAlteraMoto()) {
            if (cliente != null) {
                cliente.dispose();
            } else if(listaMotos != null){
                listaMotos.carregaLista();
                listaMotos.telaFechando(this);
                this.dispose();
            }
        }
    }//GEN-LAST:event_botaoSalvarMotoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoFabr;
    private javax.swing.JTextField anoModelo;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvarMoto;
    private javax.swing.JTextField chassi;
    private javax.swing.JTextField cod;
    private javax.swing.JTextField cor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField modelo;
    private javax.swing.JTextField placa;
    // End of variables declaration//GEN-END:variables
}
