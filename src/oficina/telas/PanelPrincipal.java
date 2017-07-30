package oficina.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PanelPrincipal extends javax.swing.JPanel {

    private Image image;
    private final Principal formulario;

    public PanelPrincipal(Principal formulario) {
        this.formulario = formulario;
        this.initialize();
        formulario.setLocationRelativeTo(null);
    }

    public void formularioFechando(JFrame formulario) {
        formCadastroUsuarios = null;
    }

    private Orcamento formCadastroUsuarios = null;

    protected void initialize() {
        this.image = this.getImage("wood.png");
        this.setLayout(new BorderLayout());
    }

    public Image getImage(String path) {
        URL imageURL = getClass().getResource(path);
        if (imageURL == null) {
            return null;
        }
        return new ImageIcon(imageURL).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dDesktop = this.getSize();
        double width = dDesktop.getWidth();
        double height = dDesktop.getHeight();
        Image background = new ImageIcon(this.image.getScaledInstance(
                (int) width, (int) height, 1)).getImage();
        g.drawImage(background, 0, 0, this);
        initComponents();
    }

    public static void main(String[] args) {
        Principal frame = new Principal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PanelPrincipal(frame));
        frame.setSize(900, 500);
        frame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoNovoOrcamento = new javax.swing.JButton();
        botaoNovaOS = new javax.swing.JButton();
        botaoNovoCliente = new javax.swing.JButton();
        botaoConsultarProdutos = new javax.swing.JButton();
        botaoConsultarCliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1024, 600));
        setMinimumSize(new java.awt.Dimension(1024, 600));
        setPreferredSize(new java.awt.Dimension(1024, 600));

        botaoNovoOrcamento.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoNovoOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/novo.png"))); // NOI18N
        botaoNovoOrcamento.setText("Novo Orçamento");
        botaoNovoOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoOrcamentoActionPerformed(evt);
            }
        });

        botaoNovaOS.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoNovaOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/novo.png"))); // NOI18N
        botaoNovaOS.setText("Nova Ordem de Serviço");
        botaoNovaOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovaOSActionPerformed(evt);
            }
        });

        botaoNovoCliente.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/novo.png"))); // NOI18N
        botaoNovoCliente.setText("Novo Cliente");
        botaoNovoCliente.setToolTipText("");
        botaoNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoClienteActionPerformed(evt);
            }
        });

        botaoConsultarProdutos.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoConsultarProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/consultar.png"))); // NOI18N
        botaoConsultarProdutos.setText("Consultar Produtos");
        botaoConsultarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarProdutosbotaoConsultarProdutoActionPerformed(evt);
            }
        });

        botaoConsultarCliente.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        botaoConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficina/telas/icones/consultar.png"))); // NOI18N
        botaoConsultarCliente.setText("Consultar Clientes");
        botaoConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarClientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel1.setText("Ordens de Serviço ativas:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Status", "Data", "Placa", "Moto", "Cliente", "Valor Total", "Editar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        labelTitulo.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        labelTitulo.setText("FUCHINA MOTO PEÇAS EIRELI M.E.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(botaoNovoOrcamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoNovaOS, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoNovoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoConsultarProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoConsultarCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovoOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoNovaOS, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovoOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoOrcamentoActionPerformed
        if (formCadastroUsuarios == null) {
            formCadastroUsuarios = new Orcamento(formulario);
            formCadastroUsuarios.setVisible(true);
        }
        //Novo_Orcamento form = new Novo_Orcamento();
        //form.setVisible(true);
    }//GEN-LAST:event_botaoNovoOrcamentoActionPerformed

    private void botaoNovaOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaOSActionPerformed
        OrdemDeServico form = new OrdemDeServico();
        form.setVisible(true);
    }//GEN-LAST:event_botaoNovaOSActionPerformed

    private void botaoNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoClienteActionPerformed
        Cadastro_Cliente form = new Cadastro_Cliente();
        //Se é cliente, desabilita os botoes nao usados
        form.setVisible(true);
    }//GEN-LAST:event_botaoNovoClienteActionPerformed

    private void botaoConsultarProdutosbotaoConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarProdutosbotaoConsultarProdutoActionPerformed
        Consultar form1 = new Consultar();
        //Puxar a tabela de produtos do BD
        form1.setVisible(true);
    }//GEN-LAST:event_botaoConsultarProdutosbotaoConsultarProdutoActionPerformed

    private void botaoConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarClientesActionPerformed
        Consultar form = new Consultar();
        //Puxar a tabela de clientes do BD
        form.setVisible(true);
    }//GEN-LAST:event_botaoConsultarClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConsultarCliente;
    private javax.swing.JButton botaoConsultarProdutos;
    private javax.swing.JButton botaoNovaOS;
    private javax.swing.JButton botaoNovoCliente;
    private javax.swing.JButton botaoNovoOrcamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
