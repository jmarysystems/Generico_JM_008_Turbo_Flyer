/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbo_flyer_menu_e_submenu;

import br.com.jmary.home.Home;
import br.com.jmary.utilidades.Exportando;
import turbo_flyer.Gerenciador_Email_02_Cadastrar_Visualizar;

/**
 *
 * @author ana
 */
public class Gerenciador_Email_Submenu_01 extends javax.swing.JPanel {

    Home Home;
        
    public Gerenciador_Email_Submenu_01( Home Home2 ) {
        Home = Home2;
        
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btExercicios5 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();

        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        jToolBar2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setPreferredSize(new java.awt.Dimension(658, 71));

        jSeparator11.setSeparatorSize(new java.awt.Dimension(12, 0));
        jToolBar2.add(jSeparator11);

        btExercicios5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/foguete.png"))); // NOI18N
        btExercicios5.setText("Turbo Flyer");
        btExercicios5.setFocusable(false);
        btExercicios5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExercicios5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExercicios5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btExercicios5MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btExercicios5MousePressed(evt);
            }
        });
        jToolBar2.add(btExercicios5);

        jSeparator8.setSeparatorSize(new java.awt.Dimension(12, 0));
        jToolBar2.add(jSeparator8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    Exportando Exportando;
    private void btExercicios5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExercicios5MousePressed
        /*
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );

            Home.ControleTabs.AddTabsAoHome("EmailZap Índice", "livroTp.gif", new Gerenciador_Email_01_Indice(Home) ); 

        } catch( Exception e ){ } } }.start();
        */
        new Thread() {   @Override public void run() { try { 
            Exportando = new Exportando("ABRINDO...");
            Exportando.setVisible(true);Exportando.pbg.setMinimum(0);
            Exportando.pbg.setMaximum( 100 );
            Exportando.pbg.setValue( 50 );
            
            //Home.ControleTabs.removerTabSelecionado();
            Home.ControleTabs.AddTabsAoHome("Turbo Flyer", "livroTp.gif", 
                    new Gerenciador_Email_02_Cadastrar_Visualizar(Home, Home.tabHome, "Cadastrando...") );
            
            //Tabela Tabela = new Tabela("Cleilson-Henrique");
            //Home.ControleTabs.AddTabsAoHome("Cadastrar/Visualizar Controle de Acesso", "livroTp.gif", Tabela );

            Exportando.fechar();
        } catch( Exception e ){ Exportando.fechar(); e.printStackTrace(); } } }.start();
    }//GEN-LAST:event_btExercicios5MousePressed

    private void btExercicios5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExercicios5MouseEntered
        Home.tocarSon.tocar( 51 );
    }//GEN-LAST:event_btExercicios5MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExercicios5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
