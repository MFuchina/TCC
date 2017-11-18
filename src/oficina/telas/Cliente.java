package oficina.telas;

import oficina.util.Mensagens;
import oficina.util.Validacao;
import oficina.modelo.ClienteDTO;
import oficina.modelo.MotoDTO;
import oficina.persistencia.ClienteDAO;

public class Cliente extends javax.swing.JFrame {

    private final boolean modoInclusao;
    private final ClienteDTO cliente;
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private Principal formularioPrincipal = null;
    private ListaDeMotos listaMotos = null;
    private Consulta c = null;
    private Moto moto = null;

    public Cliente(boolean modoInclusao, ClienteDTO cliente, Principal formPrincipal, Consulta c) {
        this.c = c;
        this.formularioPrincipal = formPrincipal;
        this.modoInclusao = modoInclusao;
        this.cliente = cliente;
        initComponents();
        this.setLocationRelativeTo(null);
        if (modoInclusao == false) {
            codigo.setText(String.valueOf(cliente.getCodigo()));
            nome.setText(cliente.getNome());
            if (cliente.getSexo().equalsIgnoreCase("M")) {
                radioMasc.setSelected(true);
                radioFem.setSelected(false);
                radioOutro.setSelected(false);
            } else if (cliente.getSexo().equalsIgnoreCase("F")) {
                radioMasc.setSelected(false);
                radioFem.setSelected(true);
                radioOutro.setSelected(false);
            } else {
                radioMasc.setSelected(false);
                radioFem.setSelected(false);
                radioOutro.setSelected(true);
            }
            cpf.setText(String.valueOf(cliente.getCPF_CNPJ()));
            email.setText(cliente.getEmail());
            telefone.setText(String.valueOf(cliente.getTelefone()));
        } else {
            btnListaMotos.setEnabled(false);
            codigo.setText(clienteDAO.retornaUltimoCodigo());
        }
    }

    public boolean cadastraOuAlteraCliente() {
        boolean aux = false, valido;
        String mensagem;
        if ((radioFem.isSelected() || radioMasc.isSelected()) || radioOutro.isSelected()) {
            if (radioOutro.isSelected()) {
                valido = Validacao.validaCNPJ(cpf.getText());
                mensagem = "Esse CNPJ já está cadastrado.";
                valido = true;
            } else {
                valido = Validacao.validaCPF(cpf.getText());
                mensagem = "Esse CPF já está cadastrado.";
                valido = true;
            }
            if (valido) {
                if (Validacao.validaCampo(nome, "nome do cliente")
                        && Validacao.validaCampo(email, "email do cliente")
                        && Validacao.validaCampo(telefone, "telefone do cliente")) {
                    if (modoInclusao) {
                        if (clienteDAO.verificaDispon(cpf.getText(), Integer.valueOf(codigo.getText()))) {
                            Mensagens.msgAviso(mensagem);
                        } else {
                            cliente.setCodigo(Integer.valueOf(codigo.getText()));
                            cliente.setNome(nome.getText());
                            cliente.setCPF_CNPJ(cpf.getText());
                            cliente.setEmail(email.getText());
                            cliente.setTelefone(telefone.getText());
                            if (radioFem.isSelected()) {
                                cliente.setSexo("F");
                            } else if (radioMasc.isSelected()) {
                                cliente.setSexo("M");
                            } else if (radioOutro.isSelected()) {
                                cliente.setSexo("O");
                            }
                            if (clienteDAO.cadastraCliente(cliente)) {
                                aux = true;
                                moto = new Moto(true, new MotoDTO(), Integer.valueOf(codigo.getText()), this, null);
                                moto.setVisible(true);
                                if (c != null) {
                                    c.montaTabela();
                                }
                            }
                        }
                    } else {
                        cliente.setCodigo(Integer.valueOf(codigo.getText()));
                        cliente.setNome(nome.getText());
                        cliente.setCPF_CNPJ(cpf.getText());
                        cliente.setEmail(email.getText());
                        cliente.setTelefone(telefone.getText());
                        if (radioFem.isSelected()) {
                            cliente.setSexo("F");
                        } else if (radioMasc.isSelected()) {
                            cliente.setSexo("M");
                        } else if (radioOutro.isSelected()) {
                            cliente.setSexo("O");
                        }
                        aux = clienteDAO.alteraCliente(cliente);
                        if (aux) {
                            Mensagens.msgInfo("Cliente alterado com sucesso.");
                            if (c != null) {
                                c.montaTabela();
                            }
                        }
                    }
                }
            }
        } else {
            Mensagens.msgAviso("Preencha corretamente todos os campos.");
        }
        return aux;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botaoContinuar = new javax.swing.JButton();
        telefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        radioFem = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        radioOutro = new javax.swing.JRadioButton();
        radioMasc = new javax.swing.JRadioButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnListaMotos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente - SIGOMM");
        setMaximumSize(new java.awt.Dimension(501, 458));
        setMinimumSize(new java.awt.Dimension(501, 458));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(11, 134, 195));

        botaoContinuar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        botaoContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/002-checked.png"))); // NOI18N
        botaoContinuar.setText("Continuar");
        botaoContinuar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 0), null));
        botaoContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoContinuarActionPerformed(evt);
            }
        });

        telefone.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        telefone.setToolTipText("Informe o número de telefone do cliente.");
        telefone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Telefone: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("E-mail:");

        email.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        email.setToolTipText("Informe o e-mail do cliente.");
        email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cpf.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        cpf.setToolTipText("Digite o CPF ou CNPJ do cliente.");
        cpf.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("CPF/CNPJ: ");

        radioFem.setBackground(new java.awt.Color(11, 134, 195));
        radioFem.setFont(new java.awt.Font("Maiandra GD", 0, 15)); // NOI18N
        radioFem.setForeground(new java.awt.Color(240, 240, 240));
        radioFem.setText("Feminino");
        radioFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Sexo:");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Nome: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Código:");

        codigo.setEditable(false);
        codigo.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        codigo.setToolTipText("O código é criado automaticamente.");

        nome.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        nome.setToolTipText("Insira o nome do cliente a ser criado.");
        nome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        radioOutro.setBackground(new java.awt.Color(11, 134, 195));
        radioOutro.setFont(new java.awt.Font("Maiandra GD", 0, 15)); // NOI18N
        radioOutro.setForeground(new java.awt.Color(240, 240, 240));
        radioOutro.setText("Outro");
        radioOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOutroActionPerformed(evt);
            }
        });

        radioMasc.setBackground(new java.awt.Color(11, 134, 195));
        radioMasc.setFont(new java.awt.Font("Maiandra GD", 0, 15)); // NOI18N
        radioMasc.setForeground(new java.awt.Color(240, 240, 240));
        radioMasc.setText("Masculino");
        radioMasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMascActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Moto(s):");

        btnListaMotos.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        btnListaMotos.setText("Listar Motos");
        btnListaMotos.setToolTipText("");
        btnListaMotos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(11, 134, 195)));
        btnListaMotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaMotosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioFem)
                                .addGap(16, 16, 16)
                                .addComponent(radioMasc)
                                .addGap(18, 18, 18)
                                .addComponent(radioOutro))
                            .addComponent(btnListaMotos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnListaMotos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioFem)
                        .addComponent(radioMasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioOutro)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
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

    private void botaoContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoContinuarActionPerformed
        if (cadastraOuAlteraCliente()) {
            if (c == null) {
                formularioPrincipal.telaFechando("Cliente", "");
            } else {
                c.telaFechando(this);
            }
            this.dispose();
        }
    }//GEN-LAST:event_botaoContinuarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        if (c == null) {
            formularioPrincipal.telaFechando("Cliente", "");
        } else {
            c.telaFechando(this);
        }
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void radioFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFemActionPerformed
        if (radioOutro.isSelected() || radioMasc.isSelected()) {
            radioMasc.setSelected(false);
            radioOutro.setSelected(false);
        }
    }//GEN-LAST:event_radioFemActionPerformed

    private void radioMascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMascActionPerformed
        if (radioOutro.isSelected() || radioFem.isSelected()) {
            radioFem.setSelected(false);
            radioOutro.setSelected(false);
        }
    }//GEN-LAST:event_radioMascActionPerformed

    private void radioOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOutroActionPerformed
        if (radioFem.isSelected() || radioMasc.isSelected()) {
            radioMasc.setSelected(false);
            radioFem.setSelected(false);
        }
    }//GEN-LAST:event_radioOutroActionPerformed

    private void btnListaMotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaMotosActionPerformed
        listaMotos = new ListaDeMotos(/*null, true,*/ cliente.getCodigo(), null);
        listaMotos.setVisible(true);
    }//GEN-LAST:event_btnListaMotosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (c == null) {
            formularioPrincipal.telaFechando("Cliente", "");
        } else {
            c.telaFechando(this);
        }
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoContinuar;
    private javax.swing.JButton btnListaMotos;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nome;
    private javax.swing.JRadioButton radioFem;
    private javax.swing.JRadioButton radioMasc;
    private javax.swing.JRadioButton radioOutro;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}
