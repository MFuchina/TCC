package oficina.telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /*public void validaNovoPrincipal() {
        if (!form_principal.isActive()) {
            form_principal = new Principal();
            form_principal.setVisible(true);
        }
    }*/
    public void formularioFechando(JFrame formulario) {
        formCadastroUsuarios = null;
    }

    private Orcamento formCadastroUsuarios = null;

    /*public void abrirPrincipal() {
        /*if (novo_princ == null) {
            novo_princ = new Principal();
            novo_princ.setVisible(true);
        }
        if (!princip.isActive()) {
            princip.setLocationRelativeTo(this);
        } else {
            princip.setExtendedState(JFrame.NORMAL);
            princip.toFront();
        }
        princip.setVisible(true);
    }*/
    //private Principal novoPrincipal = null;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraMenu = new javax.swing.JMenuBar();
        menuOrcamento = new javax.swing.JMenu();
        menuNovoOrcamento = new javax.swing.JMenuItem();
        menuConsultarOrcamento = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        menuOrdemServico = new javax.swing.JMenu();
        menuNovaOS = new javax.swing.JMenuItem();
        menuConsultarOS = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        menuNovoCliente = new javax.swing.JMenuItem();
        menuConsultarCliente = new javax.swing.JMenuItem();
        menuEstoque = new javax.swing.JMenu();
        menuNovoEstoque = new javax.swing.JMenu();
        menuNovoProduto = new javax.swing.JMenuItem();
        menuNovoServico = new javax.swing.JMenuItem();
        menuConsultarEstoque = new javax.swing.JMenu();
        menuConsultarProduto = new javax.swing.JMenuItem();
        menuConsultarServico = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fuchina Moto Peças");
        setBackground(new java.awt.Color(255, 255, 0));
        setMaximumSize(new java.awt.Dimension(1024, 600));
        setMinimumSize(new java.awt.Dimension(1024, 600));
        setPreferredSize(new java.awt.Dimension(1024, 600));
        setResizable(false);

        menuOrcamento.setText("Orçamento");

        menuNovoOrcamento.setText("Novo Orçamento...");
        menuNovoOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoOrcamentoActionPerformed(evt);
            }
        });
        menuOrcamento.add(menuNovoOrcamento);

        menuConsultarOrcamento.setText("Consultar Orçamento...");
        menuConsultarOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarOrcamentoActionPerformed(evt);
            }
        });
        menuOrcamento.add(menuConsultarOrcamento);
        menuOrcamento.add(jSeparator1);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuOrcamento.add(menuSair);

        barraMenu.add(menuOrcamento);

        menuOrdemServico.setText("Ordem de Serviço");

        menuNovaOS.setText("Nova OS...");
        menuNovaOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovaOSActionPerformed(evt);
            }
        });
        menuOrdemServico.add(menuNovaOS);

        menuConsultarOS.setText("Consultar OS...");
        menuOrdemServico.add(menuConsultarOS);

        barraMenu.add(menuOrdemServico);

        menuCliente.setText("Cliente");

        menuNovoCliente.setText("Novo Cliente...");
        menuCliente.add(menuNovoCliente);

        menuConsultarCliente.setText("Consultar Cliente...");
        menuCliente.add(menuConsultarCliente);

        barraMenu.add(menuCliente);

        menuEstoque.setText("Estoque");
        menuEstoque.setToolTipText("");

        menuNovoEstoque.setText("Novo");

        menuNovoProduto.setText("Produto...");
        menuNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoProdutoActionPerformed(evt);
            }
        });
        menuNovoEstoque.add(menuNovoProduto);

        menuNovoServico.setText("Serviço...");
        menuNovoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoServicoActionPerformed(evt);
            }
        });
        menuNovoEstoque.add(menuNovoServico);

        menuEstoque.add(menuNovoEstoque);

        menuConsultarEstoque.setText("Consultar");

        menuConsultarProduto.setText("Produto...");
        menuConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarProdutoActionPerformed(evt);
            }
        });
        menuConsultarEstoque.add(menuConsultarProduto);

        menuConsultarServico.setText("Serviço...");
        menuConsultarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarServicoActionPerformed(evt);
            }
        });
        menuConsultarEstoque.add(menuConsultarServico);

        menuEstoque.add(menuConsultarEstoque);

        barraMenu.add(menuEstoque);

        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        barraMenu.add(menuSobre);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1807, 1039));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovoOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoOrcamentoActionPerformed
        //Novo_Orcamento form = new Novo_Orcamento();
        //form.setVisible(true);
    }//GEN-LAST:event_menuNovoOrcamentoActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuConsultarOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarOrcamentoActionPerformed
        Consultar form = new Consultar();
        //Puxar a tabela de orçamentos do BD
        form.setVisible(true);
    }//GEN-LAST:event_menuConsultarOrcamentoActionPerformed

    private void menuNovaOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovaOSActionPerformed
        OrdemDeServico form = new OrdemDeServico();
        form.setVisible(true);
    }//GEN-LAST:event_menuNovaOSActionPerformed

    private void menuNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoProdutoActionPerformed
        if (Login.criaLogin()) {
            Produto novoPdto = new Produto();
            novoPdto.setVisible(true);
        }
    }//GEN-LAST:event_menuNovoProdutoActionPerformed

    private void menuNovoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoServicoActionPerformed
        if (Login.criaLogin()) {
            Servico novoServ = new Servico();
            novoServ.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_menuNovoServicoActionPerformed

    private void menuConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarProdutoActionPerformed
        Consultar form = new Consultar();
        //Puxar a tabela de produtos do BD
        form.setVisible(true);
    }//GEN-LAST:event_menuConsultarProdutoActionPerformed

    private void menuConsultarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarServicoActionPerformed
        Consultar form = new Consultar();
        //Puxar a tabela de serviços do BD
        form.setVisible(true);
    }//GEN-LAST:event_menuConsultarServicoActionPerformed

    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
        JOptionPane.showMessageDialog(null, "   Esse trabalho de conclusão de curso foi desenvolvido em 2017 pelos alunos:\n"
                + "                     Matheus Nascimento Fuchina e Nathália Fernanda Tiedt\nna disciplina de Projeto e "
                + "Desenvolvimento de Sistemas do Instituto Federal\nCatarinense - Campus Blumenau.", "TCC", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menuSobreMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenuItem menuConsultarCliente;
    private javax.swing.JMenu menuConsultarEstoque;
    private javax.swing.JMenuItem menuConsultarOS;
    private javax.swing.JMenuItem menuConsultarOrcamento;
    private javax.swing.JMenuItem menuConsultarProduto;
    private javax.swing.JMenuItem menuConsultarServico;
    private javax.swing.JMenu menuEstoque;
    private javax.swing.JMenuItem menuNovaOS;
    private javax.swing.JMenuItem menuNovoCliente;
    private javax.swing.JMenu menuNovoEstoque;
    private javax.swing.JMenuItem menuNovoOrcamento;
    private javax.swing.JMenuItem menuNovoProduto;
    private javax.swing.JMenuItem menuNovoServico;
    private javax.swing.JMenu menuOrcamento;
    private javax.swing.JMenu menuOrdemServico;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenu menuSobre;
    // End of variables declaration//GEN-END:variables

}
