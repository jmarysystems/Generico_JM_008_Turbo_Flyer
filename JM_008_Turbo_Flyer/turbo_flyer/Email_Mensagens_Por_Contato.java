/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo_flyer;

import br.com.jmary.home.Home;
import br.com.jmary.home.imagens.Imagens_Internas;
import br.com.jmary.utilidades.Arquivo_Ou_Pasta;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.http.GenericUrl;
import com.google.api.services.drive.Drive;
import emojis.EmojisX;
import emojis.MenuPop;
import static google_original.CreateGoogleFile.createGoogleFile;
import google_original.GetSubFolders;
import google_original.GoogleDriveUtils;
import home_controle_menus_norte.imagens.Imagens_Menu_Norte;
import java.awt.Component;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLEditorKit;
import turbo_flyer_imagens.Imagens_EmailZap;

/**
 *
 * @author NewUser
 */
public class Email_Mensagens_Por_Contato extends javax.swing.JPanel {   

    JPanel p;
    Gerenciador_Email_02_Cadastrar_Visualizar Gerenciador_Email_02_Cadastrar_Visualizar;
    String email_remetente = "";
    String email_destinatario = "";
    public String nome_deste_contato = "";
    String nome_flutuante_deste_contato = "";
    Home Home;

    /*
    String id_planilha_google = "https://sheets.googleapis.com/v4/spreadsheets/1Xg_DN-bpMxV-enFFWEkHN5i1gFsZheAFdleayvIg4HU/values/A:F?key=AIzaSyBwiMCywJRFQHuuksWdhqwjOrR5mDaWJYs";
    String id_0_formulario = "1FAIpQLSf4t0XzKjmHYjdYKDDuWfeFW2X-n26YXwJYWWs09HM-gdVg7Q";
    String id_1_formulario_email_de = "1447976386";
    String id_2_formulario_email_para = "961770478";
    String id_3_formulario_mensagem = "667627016";
    String id_4_formulario_imagem = "1282825158";    
    
    String id_planilha_google_status_de = "https://sheets.googleapis.com/v4/spreadsheets/1Tpo7HNute1vIqTtCLkSHr6UxmygXfMU0RylQ3zBm_iI/values/A:B?key=AIzaSyBwiMCywJRFQHuuksWdhqwjOrR5mDaWJYs";
    String id_1_formulario_status_de = "1FAIpQLSfkhjfxN1I24xNtls2EidRAs709QMahsV1BR3thOq_qOuk7SA";
    String id_1_formulario_status_email_de = "1813851603";
    */
    /**
     * Creates new form Email_Mensagens_Por_Contato
     * @param Home2
     * @param email_destinatario2
     * @param Gerenciador_Email_02_Cadastrar_Visualizar2
     * @param nome_deste_contato2
     */
    public Email_Mensagens_Por_Contato( Home Home2, String email_destinatario2, 
            Gerenciador_Email_02_Cadastrar_Visualizar Gerenciador_Email_02_Cadastrar_Visualizar2, String nome_deste_contato2
            /*
                String id_planilha_google2,
                String id_0_formulario2,
                String id_1_formulario_email_de2,
                String id_2_formulario_email_para2,
                String id_3_formulario_mensagem2,
                String id_4_formulario_imagem2,
                        
                String id_planilha_google_status_de2,
                String id_1_formulario_status_de2,
                String id_1_formulario_status_email_de2 
            */
            ) { //String tokenbot, String grupobot
        initComponents();
                        
        p = jPanel1;
                        
        jpPrincipal.setLayout(new BoxLayout( jpPrincipal, BoxLayout.PAGE_AXIS));
        jpPrincipal.setAlignmentY(Component.TOP_ALIGNMENT); //.TOP_ALIGNMENT
        
        //jEditorPane1 = new javax.swing.JEditorPane();
        jEditorPane1.setEditorKit(new HTMLEditorKit());
        jEditorPane1.setContentType("text/html;charset=UTF-8"); //"text/plain" -- "text/html;charset=ISO-8859-1" --  "text/html;charset=UTF-8"  -- "text/javascript"
        
        Gerenciador_Email_02_Cadastrar_Visualizar = Gerenciador_Email_02_Cadastrar_Visualizar2;
        email_remetente = Gerenciador_Email_02_Cadastrar_Visualizar.tf_email.getText().trim().toUpperCase();
        email_destinatario = email_destinatario2;
        nome_deste_contato = nome_deste_contato2;
        nome_flutuante_deste_contato = nome_deste_contato2;
        Home = Home2;
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        id_planilha_google = id_planilha_google2;
        id_0_formulario = id_0_formulario2;
        id_1_formulario_email_de = id_1_formulario_email_de2;
        id_2_formulario_email_para = id_2_formulario_email_para2;
        id_3_formulario_mensagem = id_3_formulario_mensagem2;
        id_4_formulario_imagem = id_4_formulario_imagem2;    
    
        id_planilha_google_status_de = id_planilha_google_status_de2;
        id_1_formulario_status_de = id_1_formulario_status_de2;
        id_1_formulario_status_email_de = id_1_formulario_status_email_de2;
        */
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
                        
        icons_online_offline(); 
        
        new Thread() {   @Override public void run() { try { 
                
            try { atualizar_properties_ultima_linha_lida(false); } catch( Exception e ){ }
            try { mostrar_mensagens_iniciais(); } catch( Exception e ){ }
            try { continuar = true; full_ler_mensagem_bot(); } catch( Exception e ){ }
            
            emojis();
        } catch( Exception e ){ } } }.start(); 
                
        new Thread() {   @Override public void run() { try { 
                
            _2_google_inicial();
            
        } catch( Exception e ){ } } }.start();   

    }
    
    public void emojis(){
        try {  
            
            BufferedImage bufImg = null;
            ImageIcon     icon   = null;
            Image         image  = null;
            int widith = 32;
            int height = 40;
            try {
                
                bufImg = ImageIO.read(EmojisX.class.getResource("0001.png") ); 
                icon   = new ImageIcon(bufImg);
                image  = icon.getImage();
                jLabel2.setIcon(new ImageIcon(image.getScaledInstance(widith, height, Image.SCALE_DEFAULT)));
                jLabel2.revalidate();
            } catch (Exception e) {}

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }

    public void mensagem2(String nome_remetenteR, String email_remetenteR, boolean lado, boolean som){
                
        mensagem22(nome_remetenteR, email_remetenteR, lado, som);
    }
    
    public void mensagem22(String nome_remetenteR, String email_remetenteR, boolean lado, boolean som){
             
        try{      
                String html  = "";
                String html2 = "";
                try {                   
            
                    html2 = email_remetenteR.replace(">", ">\n");
                    html  = html2.replace("<", "\n<");
                } catch (Exception e) {}
                
                StringBuilder sb_Geral = new StringBuilder();
                
                StringTokenizer st1 = new StringTokenizer(html, "\n" );
                System.out.println( "******************************************************************************** " );                
                for (int i = 0; st1.hasMoreTokens(); i++) {
                    
                    String imagem_um_nome_fim = null;
                    String rowstring = ""; try{ rowstring = st1.nextToken(); }catch( Exception e ){}   
                    System.out.println( rowstring );
                    
                    if( rowstring.trim().contains( "<img src=" )){       
                        //System.out.println( "rowstring - " + rowstring );
                        //sb.append( rowstring + "\n");  
                        String list_str_1[] = null; try { list_str_1 = rowstring.split("\""); } catch (Exception e) {}
                        if( list_str_1 != null ){
                                                        
                            if( list_str_1[1].trim().contains( "emojis" ) ){ 
                                
                                String list_str_2[] = null; try { list_str_2 = list_str_1[1].trim().split("/"); } catch (Exception e) {}
                                for( int j = 0; j < list_str_2.length; j++ ){
                                    
                                    imagem_um_nome_fim = list_str_2[j];
                                }
                                
                                StringBuilder sb = new StringBuilder();
                                for( int t = 0; t < list_str_2.length; t++ ){
                                                                
                                    if( t == 1 ){
                                        
                                        String imgsrc = ClassLoader.getSystemResource("emojis/" + imagem_um_nome_fim ).toString();
                                        sb.append( imgsrc );
                                        //System.out.println( imgsrc );
                                        
                                        String img = "<img src='" + imgsrc + "' width=30 height=30></img>";  
                                        sb_Geral.append( img );
                                        //System.out.println( img );
                                    }
                                    else{
                                        
                                        sb.append( list_str_2[t] );
                                    }
                                }
                                
                                //System.out.println( sb.toString() );                               
                            }                            
                                                        
                            //String imgsrc = ClassLoader.getSystemResource("emojis/" + imagem_um_nome_fim ).toString();
                            //String imgsrc = "../EMOJIS/" + str_emoji + ".png";
                            //String img = "<img src='" + imgsrc + "' width=30 height=30></img>";                                
                            //System.out.println( img );
                        }
                    }
                    else{
                        
                        sb_Geral.append( rowstring );
                    }
                }    
                //System.out.println( sb_Geral.toString() );
                System.out.println( "******************************************************************************** " );
                
            mensagemJP(nome_remetenteR, sb_Geral.toString(), lado, som);
            
        } catch( Exception e ){}
    }
    
    public int quantidade_de_mensagem = 0;
    private void mensagemJP(String nome_remetenteR, String mensagem_assunto, boolean lado, boolean som){
        try{ 
            
            if( lado == true ){
                
                String conteudo = "<table> " + 
                                       "<tr> <td>" + nome_remetenteR + "</td> </tr>" +                                       
                                       "<tr> <td bgcolor='#FFFACD' style='padding: 10; margin: 0; background-color:#FFFACD;'>" + mensagem_assunto   + "</td> </tr>" +    
                                "</table>";
                
                JLabel lb2 = new JLabel( "<html>" + conteudo ); 
                ImageIcon icon = new ImageIcon( Imagens_Menu_Norte.class.getResource("foguetemenu.png") );
                lb2.setIcon(icon);
                lb2.setHorizontalAlignment(SwingConstants.RIGHT);
                JLabel lb3 = new JLabel( "<html>" + "<br><p></p>" );
                
                jpPrincipal.add(lb2);
                jpPrincipal.add(lb3);

                this.validate();     
                rolar_JScrollPane();
                
            }
            else{
                                
                //new Thread() {   @Override public void run() { try { Thread.sleep( 1 );
                    if( som == true ){
                        quantidade_de_mensagem++;
                        Gerenciador_Email_02_Cadastrar_Visualizar.alterar_nome_JTabbedPane_chegou_mensagem( nome_deste_contato, quantidade_de_mensagem, getIcon() );
                        
                        Home.tocarSon.tocar( 52 );
                        mensagem_no_SystemTray( mensagem_assunto ); //  "Nova mensagem recebida"
                    }
                //} catch( Exception e ){ } } }.start(); 

                String conteudo = "<table> " + 
                                       "<tr> <td>" + nome_deste_contato + " - " + nome_remetenteR + "</td> </tr>" +                                       
                                       "<tr> <td bgcolor='#F0FFFF' style='padding: 10; margin: 0; background-color:#F0FFFF;'>" + mensagem_assunto   + "</td> </tr>" +    
                                "</table>";
                
                JLabel lb2 = new JLabel( "<html>" + conteudo );
                ImageIcon icon = new ImageIcon( Imagens_Menu_Norte.class.getResource("foguetemenucontra.png") );
                lb2.setIcon(icon);
                lb2.setHorizontalAlignment(SwingConstants.LEFT);
                
                JLabel lb3 = new JLabel( "<html>" + "<br><p></p>" );
                
                jpPrincipal.add(lb2);
                jpPrincipal.add(lb3);

                this.validate();
                rolar_JScrollPane();
            }
            
        } catch( Exception e ){}
    }
    
    public void mensagemHTML2(String nome_remetenteR, String endereco, boolean lado, boolean som){
                
        try{
            System.out.println( endereco + " - mensagemHTML(String nome_remetenteR, String endereco, boolean lado, boolean som)" );
            //new Thread() {   @Override public void run() { try { Thread.sleep( 1 );
                    if( som == true ){
                        quantidade_de_mensagem++;
                        Gerenciador_Email_02_Cadastrar_Visualizar.alterar_nome_JTabbedPane_chegou_mensagem( nome_deste_contato, quantidade_de_mensagem, getIcon() );
                        
                        Home.tocarSon.tocar( 52 );
                        mensagem_no_SystemTray( "" ); //  "Nova mensagem recebida"
                    }
                //} catch( Exception e ){ } } }.start(); 
                
                String conteudo2 = "<table> " + 
                                       "<tr> <td>" + nome_deste_contato + " - " + nome_remetenteR + "</td> </tr>" +       
                                "</table>";
                              
                //JLabel lb2 = new JLabel( "<html>" + conteudo2 );
                JLabel lb2 = new JLabel();
                URL u = new File(endereco).toURI().toURL();
                Path p = Paths.get(u.toURI());
                lb2.setText( new String(Files.readAllBytes(p) ) );
                ImageIcon icon = new ImageIcon( Imagens_Menu_Norte.class.getResource("foguetemenucontra.png") );
                lb2.setIcon(icon);
                lb2.setHorizontalAlignment(SwingConstants.LEFT);
                
                JLabel lb3 = new JLabel( "<html>" + "<br><p></p>" );
                
                jpPrincipal.add(lb2);
                jpPrincipal.add(lb3);

                this.validate();
                rolar_JScrollPane();
                
                /*
                JEditorPane pane = new javax.swing.JTextPane();
                pane.setBackground(new java.awt.Color(245, 245, 245));
                //pane.addHyperlinkListener(new Hyperactive());
                pane.setContentType("text/html");
                pane.setEditable(false);
                pane.setEditorKit( new HTMLEditorKit() ) ; 
                pane.setOpaque(true);
                pane.setPage( new File(endereco).toURI().toURL() );                
                pane.validate();
                
                                                
                JLabel lb2 = new JLabel();
                ImageIcon icon = new ImageIcon( Imagens_Menu_Norte.class.getResource("foguetemenucontra.png") );
                lb2.setIcon(icon);

                JLabel lb3 = new JLabel( "<html>" + "<br><p></p>" );
                
                JPanel p = new JPanel( new BorderLayout() );
                p.add( lb1, BorderLayout.NORTH );
                p.add( lb2, BorderLayout.WEST );
                p.add( pane, BorderLayout.CENTER );
                                
                jpPrincipal.add( p );
                jpPrincipal.add( lb3 );

                this.validate();
                rolar_JScrollPane();
                */
        }
        catch(Exception e ){}
    }
    
    private void mensagemJPANTERIOR(String nome_remetenteR, String mensagem_assunto, boolean lado, boolean som){
        try{ 
            
            if( lado == true ){
                
                String conteudo = "<table> " + 
                                       "<tr> <td>" + nome_remetenteR + "</td> </tr>" +                                       
                                       "<tr> <td bgcolor='#FFFACD' style='padding: 10; margin: 0; background-color:#FFFACD;'>" + mensagem_assunto   + "</td> </tr>" +    
                                "</table>";
                
                JLabel lb2 = new JLabel( "<html>" + conteudo );
                ImageIcon icon = new ImageIcon( Imagens_Menu_Norte.class.getResource("foguetemenu.png") );
                lb2.setIcon(icon);
                lb2.setHorizontalAlignment(SwingConstants.RIGHT);
                JLabel lb3 = new JLabel( "<html>" + "<br><p></p>" );
                
                jpPrincipal.add(lb2);
                jpPrincipal.add(lb3);

                this.validate();     
                rolar_JScrollPane();
                
            }
            else{
                                
                //new Thread() {   @Override public void run() { try { Thread.sleep( 1 );
                    if( som == true ){
                        quantidade_de_mensagem++;
                        Gerenciador_Email_02_Cadastrar_Visualizar.alterar_nome_JTabbedPane_chegou_mensagem( nome_deste_contato, quantidade_de_mensagem, getIcon() );
                        
                        Home.tocarSon.tocar( 52 );
                        mensagem_no_SystemTray( mensagem_assunto ); //  "Nova mensagem recebida"
                    }
                //} catch( Exception e ){ } } }.start(); 

                String conteudo = "<table> " + 
                                       "<tr> <td>" + nome_deste_contato + " - " + nome_remetenteR + "</td> </tr>" +                                       
                                       "<tr> <td bgcolor='#F0FFFF' style='padding: 10; margin: 0; background-color:#F0FFFF;'>" + mensagem_assunto   + "</td> </tr>" +    
                                "</table>";
                
                JLabel lb2 = new JLabel( "<html>" + conteudo );
                ImageIcon icon = new ImageIcon( Imagens_Menu_Norte.class.getResource("foguetemenucontra.png") );
                lb2.setIcon(icon);
                lb2.setHorizontalAlignment(SwingConstants.LEFT);
                
                JLabel lb3 = new JLabel( "<html>" + "<br><p></p>" );
                
                jpPrincipal.add(lb2);
                jpPrincipal.add(lb3);

                this.validate();
                rolar_JScrollPane();
            }
            
        } catch( Exception e ){}
    }
    
    private void rolar_JScrollPane(){
        //window.revalidate(); //Update the scrollbar size
        JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
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
        jLabel1 = new javax.swing.JLabel();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jpPrincipal = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(300, 174));

        jLabel1.setBackground(new java.awt.Color(233, 233, 245));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(">>");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jEditorPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jEditorPane1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jEditorPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEditorPane1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jEditorPane1KeyReleased(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emojis/001.png"))); // NOI18N
        jLabel2.setToolTipText("Inserir Emojis");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jEditorPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jEditorPane1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jpPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jpPrincipalMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    String html_a_enviar = "";
    String html_a_local = "";
    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        if(!jEditorPane1.getText().trim().equals("")){
            new Thread() {   @Override public void run() { try {
                String dataCadastro = "";
                String assunto = "";                
                try {

                    ////////dd.MM.yyyy HH:mm:ss/////////////EEEE, d MMMM yyyy HH:mm:ss
                    Calendar calendar = Calendar.getInstance();
                    java.util.Date now = calendar.getTime();
                    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

                    DateFormat dfmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                    try{ dataCadastro = dfmt.format(currentTimestamp);  }catch(Exception e){}
                    ////////dd.MM.yyyy HH:mm:ss/////////////EEEE, d MMMM yyyy HH:mm:ss
                    
                    String assunto0 = jEditorPane1.getText().trim();
                    String assunto1 = assunto0.replace("<p style=\"margin-top: 0\">", "");
                    String assunto2 = assunto1.replace("</p>", "");
                    String assunto3 = assunto2.replace("<body>", "");
                    String assunto4 = assunto3.replace("<html>", "");
                    String assunto5 = assunto4.replace("</body>", "");
                    String assunto6 = assunto5.replace("</html>", "");
                    String assunto7 = assunto6.replace("<head>", "");
                    String assunto8 = assunto7.replace("</head>", "");

                    StringBuilder sb = new StringBuilder();
                    String separador0 = System.getProperty("line.separator");
                    StringTokenizer st1 = new StringTokenizer(assunto8, separador0 );
                    //System.out.println( "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx " + separador0);
                    for (int i = 0; st1.hasMoreTokens(); i++) {
                    
                        String rowstring = ""; try{ rowstring = st1.nextToken(); }catch( Exception e ){}
                        //System.out.println( "rowstring - " + rowstring );
                        if( !rowstring.trim().equals("") ){
                            
                            sb.append( rowstring + "\n");
                            /*
                            if( !rowstring.trim().equals("<br>") ){
                                sb.append( rowstring );
                                sb.append( "<br>" );
                            }   
                            */
                        }
                    }
                    //System.out.println( "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx " + separador0);
                    assunto = sb.toString().trim();
                                        
                    html_a_enviar = "<html> \n" 
                                + "<body> \n" 
                                    + assunto    + "\n"                                                   
                                + "</body> \n" 
                                + "</html> \n";
                    
                    //jEditorPane1.setEditorKit(new HTMLEditorKit());
                    //jEditorPane1.setContentType("text/html;charset=UTF-8");
                    jEditorPane1.setText("");
                    //System.out.println( html_a_enviar );

                } catch (Exception ex) {}

                //

                //String separador0 = System.getProperty("line.separator");
                //String n0 = assunto.replaceAll(separador0, "<p>");
                mensagem2("      Você - " + dataCadastro, html_a_enviar, true, false);
                
                new Thread() {   @Override public void run() { try {
                    try {
                        criar_arquivo(html_a_enviar);
                    } catch (Exception ex) {}
                } catch( Exception e ){  } } }.start();
                //mensagem2("      Você - " + dataCadastro, n0, true, false);
                /*
                String separador1 = System.getProperty("line.separator");
                String n1 = assunto.replaceAll(separador1, "<p>");
                String n2 = n1.replaceAll("\t", "<p>");
                String assunto_alvo = n2.replaceAll("\n", "<p>");

                String assunto_alvoX = "";
                char c[] = assunto.toCharArray();
                for( int i = 0; i < c.length; i++ ){

                    int ch = assunto.codePointAt(i);
                    String str = String.valueOf(ch);
                    assunto_alvoX = assunto_alvoX += str + "__";
                    //System.out.println( "char c[] - " + c[i] + " - " + ch );
                }
                */
                try{
                    /*
                    String USER_AGENT = "Mozilla/5.0";
                    String GET_URL = "https://docs.google.com/forms/d/e/" + id_0_formulario + "/formResponse?"
                    + "entry." + id_1_formulario_email_de + "=" + email_remetente
                    + "&entry." + id_2_formulario_email_para + "=" + email_destinatario
                    + "&entry." + id_3_formulario_mensagem + "=" + assunto_alvoX
                    + "&entry." + id_4_formulario_imagem + "=" + "";

                    HttpURLConnection con = (HttpURLConnection) new URL(GET_URL).openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    int responseCode = con.getResponseCode();
                    */
                    //if (responseCode == HttpURLConnection.HTTP_OK) { // success
                        /*
                        BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    */
                    //System.out.println("Mensagem enviada.");

                    //lbStatus.setText("Mensagem enviada.");
                    //}

            } catch( Exception e ){  }

        } catch( Exception e ){  } } }.start();
        }
    }//GEN-LAST:event_jLabel1MousePressed

    private void criar_arquivo(String html) {                                     
        /*new Thread() {   @Override public void run() {*/ try {
            
        String nome_criar_pasta_mensagem = null;
                
        //System.out.println( "ID = criar_pasta_deste_destinatario_no_remetente - " + id_criar_pasta_deste_destinatario_no_remetente );
        ////////dd.MM.yyyy HH:mm:ss/////////////EEEE, d MMMM yyyy HH:mm:ss
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

        DateFormat dfmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try{ nome_criar_pasta_mensagem = dfmt.format(currentTimestamp);  }catch(Exception e){}
        ////////dd.MM.yyyy HH:mm:ss/////////////EEEE, d MMMM yyyy HH:mm:ss
                
        String data = nome_criar_pasta_mensagem.trim().toUpperCase().replace("/", "__");
        String minuto = data.trim().toUpperCase().replace(":", "_");
        String segundo = minuto.trim().toUpperCase().replace(".", "_");    
        
        String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
        String email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
        String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
        String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");
        String remetente_e_destinatario = email_REMETENTE + "-" + email_DESTINATARIO + "-";
        
        Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo", "MENSAGENS_RECEBIDAS" );
        Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS", email_REMETENTE ); 
        Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE, email_DESTINATARIO ); 
        Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO, "NAO_ENVIADO" ); 
        Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO + "\\NAO_ENVIADO", segundo ); //minuto
                                    
        String destino = System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO + "\\NAO_ENVIADO\\" + segundo; //minuto
        String arquivoASerCriadoXX = destino + "\\" + remetente_e_destinatario + ".html";
        File file_x = Arquivo_Ou_Pasta.criar_Arquivo_Iso_Boo_Tipo_UTFISO_Ret_F( arquivoASerCriadoXX, html, "UTF-8" );    
        
        criar_html_e_enviar( segundo, file_x, destino, remetente_e_destinatario );
        
    } catch( Exception e ){  } //} }.start();
    }
    
    private void criar_html_e_enviar( String segundo, File file_x, String destino, String remetente_e_destinatario ) {                                     
        /*new Thread() {   @Override public void run() {*/ try {           
            
            String google_id_da_pasta_deste_destinatario_no_remetente_email = 
                    google_id_da_pasta_deste_destinatario_mensagens_recebidas;
            
            String google_nome_da_pasta_deste_destinatario_no_remetente_email = email_remetente;   
                        
            String id_criar_pasta_deste_destinatario_no_remetente = pasta_deste_destinatario_no_remetente(
                    google_id_da_pasta_deste_destinatario_no_remetente_email, google_nome_da_pasta_deste_destinatario_no_remetente_email
            );
                        
            if( id_criar_pasta_deste_destinatario_no_remetente != null ){
                                  
                String id_criar_pasta_mensagem = pasta_deste_destinatario_no_remetente(
                    id_criar_pasta_deste_destinatario_no_remetente, segundo
                );
                
                if( id_criar_pasta_mensagem != null ){                     
                                                            
                    com.google.api.services.drive.model.File googleFile = createGoogleFile(
                            id_criar_pasta_mensagem, "text/plain", remetente_e_destinatario + ".html", file_x); //minuto
                                                                                
                    try{
                        List<com.google.api.services.drive.model.File> googleRootFolders = GetSubFolders.getGoogleSubFolders( id_criar_pasta_deste_destinatario_no_remetente );
                        for (com.google.api.services.drive.model.File folder : googleRootFolders) { 
                            if( folder.getId().trim().toUpperCase().equals( id_criar_pasta_mensagem.trim().toUpperCase() ) ){     
                                                                
                                String data1 = folder.getCreatedTime().toString();
                                String data2 = data1.replace(":", "_");
                                String data3 = data2.replace(".", "_");
                                String data4 = data3.replace("T", "_");
                                String data5 = data4.replace("Z", "");
                                String data6 = data5.replace("-", "_");
                                
                                String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
                                String email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
                                String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
                                String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");

                                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo", "MENSAGENS_RECEBIDAS" );
                                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS", email_REMETENTE );
                                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE, email_DESTINATARIO ); 
                                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO, data6 );
                                String destino2 = System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO + "\\" + data6;
                                
                                Arquivo_Ou_Pasta.copiarArquivoNovoNome( file_x, destino2, remetente_e_destinatario + ".html" );
                                System.out.println( "String data0 = googleFile.getCreatedTime().toString();" + " - " + data6 );
                                //String list_str_1[] = null; try { list_str_1 = data5.split("_"); } catch (Exception e) {}
                                //for( int j = 0; j < list_str_1.length; j++ ){
                                //System.out.println( "String - " + j + " - " + list_str_1[j] );
                                //}
                                //String nome_data_hora_mensagem = list_str_1[1]+"/"+list_str_1[2]+"/"+list_str_1[2]+" " +
                                //                     list_str_1[3]+"/"+list_str_1[4]+"/"+list_str_1[5];
                                
                                Arquivo_Ou_Pasta.deletar(file_x);
                                Arquivo_Ou_Pasta.deletar(new File(destino));
                            }
                        }                           
                    }catch(Exception e ){e.printStackTrace();}
                    
                    ////////////////////////////////////////////////////////////////
                    //String list_str_1[] = null; try { list_str_1 = data5.split("_"); } catch (Exception e) {}
                    //for( int j = 0; j < list_str_1.length; j++ ){
                        //System.out.println( "String - " + j + " - " + list_str_1[j] );
                    //}
                    //String nome_data_hora_criada_pasta = list_str_1[1]+"/"+list_str_1[2]+"/"+list_str_1[2]+" " +
                    //                                 list_str_1[3]+"/"+list_str_1[4]+"/"+list_str_1[5];
                    //////////////////////////////////////////////////////////////// 
                }
            }
            
        } catch( Exception e ){  } //} }.start();
    }
    
    public String pasta_deste_destinatario_no_remetente(String onde_id, String nome){
        String retorno = null;
        try {  
            
            try {
                        
                if( Google.verificar_se_uma_pasta_existe_dentro_de_outra( onde_id, nome ) == true ){
                
                    retorno = Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id( onde_id, nome );
                }
                else{
                    
                    retorno = Google.criar_uma_pasta_dentro_de_outra_pasta( onde_id, nome );
                    
                }
            } catch( Exception e ){ }

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
        
        return retorno;
    }
    
    private void jpPrincipalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPrincipalMouseMoved
        alterar_nome_JTabbedPane_leu_mensagem2();
    }//GEN-LAST:event_jpPrincipalMouseMoved

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed

        try { 
            JOptionPane.showMessageDialog(Home, new MenuPop( this ));
            //JDialog dialog = new JDialog();
            //dialog.add( new MenuPop() );
            //dialog.setModal(true);
            //Class<Imagens_Dos_Exercicios> clazzHome = Imagens_Dos_Exercicios.class;
            //JOptionPane pane = new JOptionPane( new ImageIcon( clazzHome.getResource(icon)) );
            /*
            JOptionPane pane = new JOptionPane(Home, new MenuPop() );
            final JDialog dialog = new MenuPop().createDialog( Home, "" ); 
            dialog.setModal(true);
            Timer timer = new Timer(2 * 1000, new ActionListener() {  
                @Override
                public void actionPerformed(ActionEvent ev) {  
                    dialog.dispose();   
                }  
            });  
            timer.setRepeats(false);  
            timer.start();  
            dialog.show();  
            timer.stop(); 
            */
        } catch(Exception e){e.printStackTrace();}       
        
    }//GEN-LAST:event_jLabel2MousePressed

    String anterior = "";
    public void inserir_emoji( String str_emoji ) {                                     
        
        try {
            String assunto = "";
            
            try {
                //System.out.println( jEditorPane1.getText().trim() );

                String assunto0 = jEditorPane1.getText().trim();
                String assunto1 = assunto0.replace("<p style=\"margin-top: 0\">", "");
                String assunto2 = assunto1.replace("</p>", "");
                String assunto3 = assunto2.replace("<body>", "");
                String assunto4 = assunto3.replace("<html>", "");
                String assunto5 = assunto4.replace("</body>", "");
                String assunto6 = assunto5.replace("</html>", "");
                String assunto7 = assunto6.replace("<head>", "");
                String assunto8 = assunto7.replace("</head>", "");
                
                StringBuilder sb = new StringBuilder();
                String separador0 = System.getProperty("line.separator");
                StringTokenizer st1 = new StringTokenizer(assunto8, separador0 );
                //System.out.println( "******************************************************************************** " + separador0);
                for (int i = 0; st1.hasMoreTokens(); i++) {
                    
                    String rowstring = ""; try{ rowstring = st1.nextToken(); }catch( Exception e ){}
                    //System.out.println( "rowstring - " + rowstring );
                    if( !rowstring.trim().equals("") ){
                        /*
                        if( !rowstring.trim().equals("<br>") ){
                            sb.append( rowstring );
                        } 
                        */
                        sb.append( rowstring + "\n" );
                    }
                }
                //System.out.println( "******************************************************************************** " + separador0);
                
                //String n0 = assunto2.trim().replaceAll(separador0, "<br>");
                assunto = sb.toString().trim();
                
                jEditorPane1.setText("");
                //System.out.println( assunto );
            } catch (Exception ex) {}
            
            String assuntoX = "";
            try {
                
                String imgsrc = ClassLoader.getSystemResource("emojis/" + str_emoji + ".png" ).toString();
                //String imgsrc = "../EMOJIS/" + str_emoji + ".png";
                String img = "<img src='" + imgsrc + "' width=30 height=30></img>";
                
                assuntoX ="<html>"    + "\n"
                        + "<body>"    + "\n"
                            + assunto + "\n"
                            + img     + "\n"
                        + "</body>"   + "\n" 
                        + "</html>";
                jEditorPane1.setText( assuntoX );
                //jEditorPane1.repaint();
                
                anterior = "emoji";
                //System.out.println(assuntoX);
            } catch (Exception ex) {}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void jEditorPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEditorPane1KeyPressed
        try{
            
            if (evt.getKeyCode() == KeyEvent.VK_ENTER ) {
                String assunto = "";
                
                //System.out.println( jEditorPane1.getText().trim() );

                String assunto0 = jEditorPane1.getText().trim();
                String assunto1 = assunto0.replace("<p style=\"margin-top: 0\">", "");
                String assunto2 = assunto1.replace("</p>", "");
                String assunto3 = assunto2.replace("<body>", "");
                String assunto4 = assunto3.replace("<html>", "");
                String assunto5 = assunto4.replace("</body>", "");
                String assunto6 = assunto5.replace("</html>", "");
                String assunto7 = assunto6.replace("<head>", "");
                String assunto8 = assunto7.replace("</head>", "");
                
                StringBuilder sb = new StringBuilder();
                String separador0 = System.getProperty("line.separator");
                StringTokenizer st1 = new StringTokenizer(assunto8, separador0 );
                //System.out.println( "******************************************************************************** " + separador0);
                for (int i = 0; st1.hasMoreTokens(); i++) {
                    
                    String rowstring = ""; try{ rowstring = st1.nextToken(); }catch( Exception e ){}
                    //System.out.println( "rowstring - " + rowstring );
                    if( !rowstring.trim().equals("") ){
                        
                        sb.append( rowstring + "\n");                        
                    }
                }
                //System.out.println( "******************************************************************************** " + separador0);
                
                assunto = sb.toString().trim();
                
                String assuntoX = "<html>"     + "\n" +
                                  "<body>"     + "\n" +
                                      assunto  + "\n" +
                                      " <br> " + "\n" +
                                  "</body>"    + "\n" + 
                                  "</html>";
                
                jEditorPane1.setText( assuntoX );
                
                //System.out.println(assuntoX);
                
                anterior = "enter";
            }
            else {
                anterior = "letras";
            }
        } catch( Exception e ){}        
    }//GEN-LAST:event_jEditorPane1KeyPressed

    private void jEditorPane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEditorPane1KeyReleased
        
    }//GEN-LAST:event_jEditorPane1KeyReleased

    public ImageIcon iconAtual;
    public ImageIcon iconOffiline;
    public ImageIcon iconOnline;
    public ImageIcon iconfoquete;
    public ImageIcon iconlivro;
    private void icons_online_offline(){
        try {
        
            ImageIcon iconInicioOffiline = new ImageIcon( Imagens_EmailZap.class.getResource("offiline.png") );           
            
            Image img = iconInicioOffiline.getImage();
            Image newimg = img.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
            iconOffiline = new ImageIcon(newimg);
            
            ImageIcon iconInicioOnline = new ImageIcon( Imagens_EmailZap.class.getResource("online.png") );
            
            Image img2 = iconInicioOnline.getImage();
            Image newimg2 = img2.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
            iconOnline = new ImageIcon(newimg2);
            
            iconfoquete = new ImageIcon( Imagens_Menu_Norte.class.getResource("foguetemenucontra.png") );
            
            iconlivro = new ImageIcon( Imagens_Internas.class.getResource("livroTp.gif") );
            
        } catch( Exception e ){  } 
    }
    
    public boolean status_do_usuario = false;
    public ImageIcon getIcon(){
        ImageIcon retorno = iconlivro;
        try {
            
            if( status_do_usuario == false ){
                
                retorno = iconOffiline;
            }
            else{
                
                retorno = iconOnline;
            }
        } catch( Exception e ){  }
        
        return retorno;
    }
            
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    public String google_nome_da_pasta_deste_destinatario = null;
    public String google_id_da_pasta_deste_destinatario = null;
    public void _2_google_inicial(){
        try {  
            google_nome_da_pasta_deste_destinatario = email_destinatario.trim().toUpperCase();
            
            if( Google.verificar_se_uma_pasta_existe_dentro_de_outra(
                    Gerenciador_Email_02_Cadastrar_Visualizar.google_id_da_pasta_root, google_nome_da_pasta_deste_destinatario ) == true ){
                
                google_id_da_pasta_deste_destinatario = Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(
                        Gerenciador_Email_02_Cadastrar_Visualizar.google_id_da_pasta_root, google_nome_da_pasta_deste_destinatario );
            }
            else{
                /*
                google_id_da_pasta_deste_destinatario = Google.criar_uma_pasta_dentro_de_outra_pasta(
                        Gerenciador_Email_02_Cadastrar_Visualizar.google_id_da_pasta_root, google_nome_da_pasta_deste_destinatario );
                */
            }
            
            _4_google_inicial();

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    public String google_nome_da_pasta_deste_destinatario_mensagens_recebidas = "MENSAGENS_RECEBIDAS";
    public String google_id_da_pasta_deste_destinatario_mensagens_recebidas = null;
    public void _4_google_inicial(){
        try {  
            
            try {
                if( Google.verificar_se_uma_pasta_existe_dentro_de_outra(
                        google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_destinatario_mensagens_recebidas ) == true ){
                
                    google_id_da_pasta_deste_destinatario_mensagens_recebidas = Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(
                            google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_destinatario_mensagens_recebidas );
                }
                else{
                    /*
                    google_id_da_pasta_deste_destinatario_mensagens_recebidas = Google.criar_uma_pasta_dentro_de_outra_pasta(
                            google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_destinatario_mensagens_recebidas );
                    */
                }
            } catch( Exception e ){ }
                        
            try {
                
               _5_google_inicial();
            } catch( Exception e ){ }

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    public String google_nome_da_pasta_deste_destinatario_status = "STATUS";
    public String google_id_da_pasta_deste_destinatario_status = null;
    public void _5_google_inicial(){
        try {  
            
            try {
                if( Google.verificar_se_uma_pasta_existe_dentro_de_outra(
                        google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_destinatario_status ) == true ){
                
                    google_id_da_pasta_deste_destinatario_status = Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(
                            google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_destinatario_status );
                }
                else{
                    /*
                    google_id_da_pasta_deste_destinatario_status = Google.criar_uma_pasta_dentro_de_outra_pasta(
                            google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_destinatario_status );
                    */
                }
            } catch( Exception e ){ }
            
            try {
                
                _6_google_inicial();
            } catch( Exception e ){ }

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    public String google_nome_da_pasta_deste_remetente_foto_perfil = "FOTO_PERFIL";
    public String google_id_da_pasta_deste_remetente_foto_perfil = null;
    public void _6_google_inicial(){
        try {  
            
            try {
                if( Google.verificar_se_uma_pasta_existe_dentro_de_outra(
                        google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_remetente_foto_perfil ) == true ){
                
                    google_id_da_pasta_deste_remetente_foto_perfil = Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(
                            google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_remetente_foto_perfil );
                }
                else{
                    
                    google_id_da_pasta_deste_remetente_foto_perfil = Google.criar_uma_pasta_dentro_de_outra_pasta(
                            google_id_da_pasta_deste_destinatario, google_nome_da_pasta_deste_remetente_foto_perfil );
                    
                }
            } catch( Exception e ){ }
            
            if( google_id_da_pasta_deste_destinatario != null ){
                
                try {
                    
                    verificar_se_este_contato_esta_online();
                } catch( Exception e ){ }
            }
            else{
                try {
                    
                    Thread.sleep( 60000 );
                    _2_google_inicial();
                } catch( Exception e ){ }
            }

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    String status = "";
    int contadorXX = 0;
    public void verificar_se_este_contato_esta_online(){ //System.out.println( "public void ler_mensagem(){" );       
        /*new Thread() {   @Override public void run() {*/   
            
        do{             
            //System.out.println("\nverificar_se_este_contato_esta_online(): "  );
            try {
 
                String id = null;  
                com.google.api.services.drive.model.File file_y = null;
                Thread.sleep( 5000 );
                try {
                                       
                    List<com.google.api.services.drive.model.File> list = new ArrayList<com.google.api.services.drive.model.File>();
                    list = GetSubFolders.getGoogleSubFile( google_id_da_pasta_deste_destinatario_status );
                    
                    for (com.google.api.services.drive.model.File file : list) {                            
                                       
                        file_y = file;
                        id = file.getId();
                    }
                } catch (Exception ex) {}
                
                if( id !=  null ){
                    
                    contadorXX = 0;
                    
                    String data = file_y.getName().trim().toUpperCase().replace("__", "/");
                    String minuto = data.trim().toUpperCase().replace("_", ":");
                    try { status_ultima_data( minuto ); } catch( Exception e ){ } 
                    //System.out.println( email_destinatario + " - " + file_y.getName() );
                }
                else{
                    
                    contadorXX++;
                    if( contadorXX > 4 ){
                        contadorXX = 0;
                    
                        //try { status_ultima_data( "" ); } catch( Exception e ){ } 
                        System.out.println( email_destinatario +" else{: " + contadorXX );
                        
                        status_do_usuario = false;
                        alterar_nome_JTabbedPane_Status_online();
                        lbStatus.setText( nome_deste_contato.toUpperCase() + " ESTÁ OFFLINE " + ultima_data_status.replace(".TXT", "") );
                    
                        ultima_data_status = "";
                        penultima_data_status = "";
                    }
                }
                /*
                try{ 
                    String USER_AGENT = "Mozilla/5.0";
                    String GET_URL = id_planilha_google_status_de;
                
                    HttpURLConnection con = (HttpURLConnection) new URL(GET_URL).openConnection();
                    con.setRequestMethod("GET");
	            con.setRequestProperty("User-Agent", USER_AGENT);
	            int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) { // success
                       BufferedReader in = new BufferedReader(new InputStreamReader(
	               con.getInputStream()));
		       String inputLine;
		       StringBuffer response = new StringBuffer();

		        while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
                        }
		        in.close();
                        status = response.toString();
                        
                        try { status_ultima_data( status ); } catch( Exception e ){ } 
                    }
                    else{
                        
                        status_do_usuario = false;
                        alterar_nome_JTabbedPane_Status_online();
                        lbStatus.setText( "VOCÊ ESTÁ OFFLINE - STATUS" );  
                    }
                    
                } catch( Exception e ){ 
                    
                    status_do_usuario = false;
                    alterar_nome_JTabbedPane_Status_online();
                    lbStatus.setText( "VOCÊ ESTÁ OFFLINE - STATUS" );  
                } 
                */

            } catch (Exception e) { 
                //System.out.println( "public void full_ler_mensagem_bot(){ - ERRO - \n" + e.getMessage() );    
                //e.printStackTrace(); 
            } finally {}     
        }while( true );
    }
    
    String ultima_data_status = "";
    String penultima_data_status = "";
    String ante_penultima_data_status = "";
    //boolean ontwo = false;
    int contador = 0;
    private void status_ultima_data(final String json) { try {

        contador++;
        
        switch(contador){
            
            case 1: 
                ultima_data_status = json.trim();
                break;
            case 2: 
                penultima_data_status = json.trim();
                break;
            case 3: 
                contador = 0;
                ante_penultima_data_status = json.trim();
                
                if( !ultima_data_status.trim().equalsIgnoreCase( penultima_data_status.trim() ) ){
                    
                    status_do_usuario = true;
                    alterar_nome_JTabbedPane_Status_online();
                    lbStatus.setText( nome_deste_contato.toUpperCase() + " ESTÁ ONLINE " + ultima_data_status.replace(".TXT", "") );
                    
                    ultima_data_status = "";
                    penultima_data_status = "";
                }
                else if( !ultima_data_status.trim().equalsIgnoreCase( ante_penultima_data_status.trim() ) ){
                    
                    status_do_usuario = true;
                    alterar_nome_JTabbedPane_Status_online();
                    lbStatus.setText( nome_deste_contato.toUpperCase() + " ESTÁ ONLINE " + ultima_data_status.replace(".TXT", "") );
                    
                    ultima_data_status = "";
                    penultima_data_status = "";
                }
                else{
                    
                    status_do_usuario = false;
                    alterar_nome_JTabbedPane_Status_online();
                    lbStatus.setText( nome_deste_contato.toUpperCase() + " ESTÁ OFFLINE " + ultima_data_status.replace(".TXT", "") );
                    
                    ultima_data_status = "";
                    penultima_data_status = "";
                }
                break;    
        }
                
        //if(ontwo == false){   
            
            //ontwo = true;
        
            //ultima_data_status = json.trim();
            //Thread.sleep( 20000 );
            /*
            String separacao_1[] = json.split("],");
            int ultimo = separacao_1.length - 1;  //////////// 1
            String str = null; try{ str = separacao_1[ ultimo ]; } catch( Exception e ){}
            if( str != null ){
            
                String separacao_2[] = str.split(",");
                String data = separacao_2[0].replace("\"", "").replace("[", "");
                String mensagem = data.replaceAll("\"    ]  ]}", "\"");   
            
                ultima_data_status = mensagem.trim();
                System.out.println( email_remetente + " - " + ultima_data_status + "ultima_data_status - AGUARDANDO 25 SEGUNDOS");
                Thread.sleep( 25000 );
            }  
            */
        //}
        //else{
            
            //ontwo = false;
            /*
            penultima_data_status = json.trim();
            if( !ultima_data_status.trim().equalsIgnoreCase( penultima_data_status.trim() ) ){
                
                status_do_usuario = true;
                alterar_nome_JTabbedPane_Status_online();
                lbStatus.setText( "ONLINE - ÚLTIMA VERIFICAÇÃO: " + ultima_data_status );
                    
                ultima_data_status = "";
                penultima_data_status = "";
            }
            else{
                
                status_do_usuario = false;
                alterar_nome_JTabbedPane_Status_online();
                lbStatus.setText( "OFFLINE - ÚLTIMA VERIFICAÇÃO: " + ultima_data_status );
                    
                ultima_data_status = "";
                penultima_data_status = "";
            }
            */
            
            /*
            String separacao_1[] = json.split("],");
            int ultimo = separacao_1.length - 1;  
            String str = null; try{ str = separacao_1[ ultimo ]; } catch( Exception e ){}
            if( str != null ){
            
                String separacao_2[] = str.split(",");
                String data = separacao_2[0].replace("\"", "").replace("[", "");
                String mensagem = data.replaceAll("\"    ]  ]}", "\"");   
            
                penultima_data_status = mensagem.trim();
                
                if( !ultima_data_status.trim().equalsIgnoreCase( penultima_data_status.trim() ) ){

                    status_do_usuario = true;
                    alterar_nome_JTabbedPane_Status_online();
                    lbStatus.setText( "ONLINE - ÚLTIMA VERIFICAÇÃO: " + ultima_data_status );
                    
                    ultima_data_status = "";
                    penultima_data_status = "";
                    
                    System.out.println( email_remetente + " - " + ultima_data_status + " - ON - ultima_data_status - ontwo == true ------- " + penultima_data_status + " - penultima_data_status");
                }
                else{

                    status_do_usuario = false;
                    alterar_nome_JTabbedPane_Status_online();
                    lbStatus.setText( "OFFLINE - ÚLTIMA VERIFICAÇÃO: " + ultima_data_status );
                    
                    ultima_data_status = "";
                    penultima_data_status = "";
                    
                    System.out.println( email_remetente + " - " + ultima_data_status + " - OFF - ultima_data_status - ontwo == true ------- " + penultima_data_status + " - penultima_data_status");
                }
            } 
            */
        //}
    } catch( Exception e ){} }
    
    private void status_penultima_data22(final String json) { try {

        //System.out.println("\n***********************************************************************");
        
        String separacao_1[] = json.split("],");
        int ultimo = separacao_1.length - 1; //////////// 2
        String str = null; try{ str = separacao_1[ ultimo ]; } catch( Exception e ){}
        if( str != null ){
            
            String separacao_2[] = str.split(",");
            String data = separacao_2[0].replace("\"", "").replace("[", "");
            String mensagem = data.replaceAll("\"    ]  ]}", "\"");   
            
            penultima_data_status = mensagem.trim();
                      
            subtrair_datas22();
        }        
        //System.out.println("***********************************************************************\n");
    } catch( Exception e ){} }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
    private void subtrair_datas22() { try {

        if( !penultima_data_status.equals("") ){
                    
            if( !ultima_data_status.equals("") ){
                try {
                    DateTimeFormatter dfmtFull2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    
                    LocalTime  start = LocalTime .parse(penultima_data_status,dfmtFull2);
                    LocalTime  end = LocalTime .parse(ultima_data_status,dfmtFull2);

                    long thirty = Duration.between(end, start).getSeconds();                    

                    long valor = 0;
                    
                    if( thirty < 0 ){
                        
                        valor = ( thirty * -1 );
                    }
                    else{
                        
                        valor = thirty;
                    }
                        
                    if( valor < 60 ){
                            
                        status_do_usuario = true;
                        alterar_nome_JTabbedPane_Status_online();
                        lbStatus.setText( "ONLINE - ÚLTIMA VERIFICAÇÃO: " + ultima_data_status );
                        System.out.println( penultima_data_status + " - penultima_data_status - " + ultima_data_status + " - ultima_data_status - " + valor + " segundos)" );
                    }
                    else{                            
                            
                        status_do_usuario = false;
                        alterar_nome_JTabbedPane_Status_online();
                        lbStatus.setText( "OFFILINE DESDE: " + ultima_data_status + " *" );
                        System.out.println( email_destinatario+ " - " + penultima_data_status + " - penultima_data_status - " + ultima_data_status + " - ultima_data_status - " + valor + " segundos" + " *" );
                    }
                } catch( Exception e ){ e.printStackTrace(); }    
            }
            else{
                status_do_usuario = false;
                lbStatus.setText( "OFFILINE DESDE: " + ultima_data_status + " **" ); 
                alterar_nome_JTabbedPane_Status_online();          
                System.out.println( email_destinatario+ " - " + penultima_data_status + " - penultima_data_status - " + ultima_data_status + " - ultima_data_status " + " **" );
            }
        }
        else{
            status_do_usuario = false;
            lbStatus.setText( "OFFILINE DESDE: " + ultima_data_status + " ***" ); 
            alterar_nome_JTabbedPane_Status_online();     
            System.out.println( email_destinatario+ " - " + penultima_data_status + " - penultima_data_status - " + ultima_data_status + " - ultima_data_status " + " ***" );
        }
    } catch( Exception e ){} }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpPrincipal;
    public javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
    
    String arquivoASerCriado = "";
    private void atualizar_properties_ultima_linha_lida(boolean atualizar){
        /*new Thread() {   @Override public void run() {*/ try { //email_remetente
            
            String arquivo_properties = email_destinatario.trim().toUpperCase().replace("@", "_");
            String email_DESTINATARIO = arquivo_properties.trim().toUpperCase().replace(".", "_");
            Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\", "00_Externo" );  
            Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo", "LEITURAS_M" );
                
            String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
            String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");
            Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\LEITURAS_M", email_REMETENTE ); 
            arquivoASerCriado = System.getProperty("user.dir") + "\\00_Externo\\LEITURAS_M\\" + email_REMETENTE + "\\" + email_DESTINATARIO;
            
            Properties properties = new Properties();                                   
            FileInputStream in = new FileInputStream( arquivoASerCriado + ".properties" ); 
            properties.loadFromXML(in);
            in.close();
            
            Arquivo_Ou_Pasta.deletar( new File( arquivoASerCriado + ".properties" ) );
            
            Properties properties_zero = new Properties();
            String value = "";
            try{
                for(Enumeration elms = properties.propertyNames(); elms.hasMoreElements();){   
                    
                    if( atualizar == true ){
                        String prop = (String)elms.nextElement();
                        value = properties.getProperty(prop);
                        int v = Integer.parseInt( value.trim() );
                        
                        int x = v+=1;
                        int anterior = x;
                        
                        proxima_mensagem_a_ler = anterior;                 
                        properties_zero.put("ultimo", String.valueOf( anterior ) );
                        System.out.println("true - atualizar_properties(boolean atualizar){ - prop: " + prop + " - value: " + anterior + " - proxima_mensagem_a_ler - " + proxima_mensagem_a_ler);        
                    }
                    else{
                        String prop = (String)elms.nextElement();
                        value = properties.getProperty(prop);
                        int v = Integer.parseInt( value.trim() );       
                    
                        proxima_mensagem_a_ler = v;                 
                        properties_zero.put("ultimo", String.valueOf( v ) );
                        System.out.println("false - atualizar_properties(boolean atualizar){ - prop: " + prop + " - value: " + v + " - proxima_mensagem_a_ler - " + proxima_mensagem_a_ler );  
                    }
                }
            } catch( Exception e ){ 
                System.out.println("for(Enumeration elms = properties.propertyNames(); elms.hasMoreElements();){");      
                e.printStackTrace();
            }           
                                   
            FileOutputStream out = new FileOutputStream( arquivoASerCriado + ".properties" );
            properties_zero.storeToXML(out, "updated", "UTF-8"); 
            out.flush();
            out.close();
                         
        } catch( Exception e ){ 
            try{
                Properties properties_zero = new Properties();
                properties_zero.put("ultimo", "1");                       
                FileOutputStream out = new FileOutputStream( arquivoASerCriado + ".properties" );
                properties_zero.storeToXML(out, "updated", "UTF-8"); 
                out.flush();
                out.close();
            } catch( Exception ee ){ }
        } //} }.start();   
    }
            
    boolean continuar = false;
    String google_id_da_pasta_deste_remetente_dentro_do_destinatario = null;
    public void full_ler_mensagem_bot(){ //System.out.println( "public void ler_mensagem(){" );       
        /*new Thread() {   @Override public void run() {*/   
            
        do{ 
            try{ Thread.sleep( 10000 ); } catch (Exception e) {}
            if( continuar == true ){
                continuar = false;
                
                try {
                
                    if( google_id_da_pasta_deste_remetente_dentro_do_destinatario != null ){
                    
                        try{
                            
                            full_ler_mensagem_bot_2();
                        } catch (Exception e) {}
                    } 
                    else if( Gerenciador_Email_02_Cadastrar_Visualizar.google_id_da_pasta_deste_remetente_mensagens_recebidas != null ){
                    
                        try{
                            
                            if( Google.verificar_se_uma_pasta_existe_dentro_de_outra(
                                Gerenciador_Email_02_Cadastrar_Visualizar.google_id_da_pasta_deste_remetente_mensagens_recebidas, 
                                email_destinatario.trim().toUpperCase() ) == true ){
                
                                google_id_da_pasta_deste_remetente_dentro_do_destinatario = 
                                    Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(
                                            Gerenciador_Email_02_Cadastrar_Visualizar.google_id_da_pasta_deste_remetente_mensagens_recebidas, 
                                            email_destinatario.trim().toUpperCase() );
                                                                                  
                            }
                        } catch (Exception e) {}
                        
                        continuar = true;
                    }
                    else{
                        
                        continuar = true;
                    }
  
                } catch (Exception e) { 
                    //System.out.println( "public void full_ler_mensagem_bot(){ - ERRO - \n" + e.getMessage() );    
                    //e.printStackTrace(); 
                } finally {}    
            } 
        }while( true );
    }
    
    private void full_ler_mensagem_bot_2() { try {
        
        System.out.println( "INICANDO - full_ler_mensagem_bot_2" );
        
        List<com.google.api.services.drive.model.File> lista_de_pastas_no_drive = null;
        
        try{ 
            
            lista_de_pastas_no_drive = GetSubFolders.getGoogleSubFolders( google_id_da_pasta_deste_remetente_dentro_do_destinatario );          
        }catch(Exception e){}
        
        if( lista_de_pastas_no_drive != null ){
        
            for( int i = 0; i < lista_de_pastas_no_drive.size(); i++ ){
                
                
                String nome_criar_pasta_mensagem = null;        
                try{ /*
                    String data_da_pasta_criada_no_drive = null;        
                    DateTime d1 = lista_de_pastas_no_drive.get(i).getCreatedTime();
                    System.out.println( "Data de Criação da pasta - " + d1 ); 
                    
                    DateFormat dfmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                    try{ data_da_pasta_criada_no_drive = dfmt.format( d1 );  }catch(Exception e){}
                    
                    String data = data_da_pasta_criada_no_drive.trim().toUpperCase().replace("/", "__");
                    String minuto = data.trim().toUpperCase().replace(":", "_");                    
                    System.out.println( "Data de Criação da pasta - " + minuto );
                    */
                    String data1 = lista_de_pastas_no_drive.get(i).getCreatedTime().toString().replace("-", "_");
                    String data2 = data1.replace(":", "_");
                    String data3 = data2.replace(".", "_");
                    String data4 = data3.replace("T", "_");
                    String data5 = data4.replace("Z", "");
                    
                    nome_criar_pasta_mensagem = data5;
                }catch(Exception e){}
                
                                          
                //System.out.println( "ID = criar_pasta_deste_destinatario_no_remetente - " + id_criar_pasta_deste_destinatario_no_remetente );
                //Calendar calendar = Calendar.getInstance();
                //java.util.Date now = calendar.getTime();
                //java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

               //DateFormat dfmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
               //try{ nome_criar_pasta_mensagem = dfmt.format(currentTimestamp);  }catch(Exception e){}
                
                //String data = nome_criar_pasta_mensagem.trim().toUpperCase().replace("/", "__");
                //String minuto = data.trim().toUpperCase().replace(":", "_");
                
                String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
                String email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
                String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
                String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");
                String remetente_e_destinatario = email_REMETENTE + "-" + email_DESTINATARIO + "-";

                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo", "MENSAGENS_RECEBIDAS" );
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS", email_REMETENTE ); 
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE, email_DESTINATARIO ); 
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO, nome_criar_pasta_mensagem ); 
            
                String pasta_criada_local = System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO + "\\" + nome_criar_pasta_mensagem;
            
                //System.out.println( "full_ler_mensagem_bot_2() - \n" + list.get(i).getName() ); 
                List<com.google.api.services.drive.model.File> lista_de_arquivos = null;
                try{ 
                    lista_de_arquivos = GetSubFolders.getGoogleSubFile( lista_de_pastas_no_drive.get(i).getId() );
                }catch(Exception e){}
                System.out.println( "PASTA - " + lista_de_pastas_no_drive.get(i).getName() + " - " + lista_de_pastas_no_drive.get(i).getId() ); 

                if( lista_de_arquivos != null ){
                
                    full_ler_mensagem_bot_3( lista_de_arquivos, pasta_criada_local, lista_de_pastas_no_drive.get(i).getId() );
                }
                else{
                
                    Arquivo_Ou_Pasta.deletar_Todos_Arquivos_da_Pasta( new File(pasta_criada_local) );
                    break;
                }
            }        
        }
        
    } catch( Exception e ){
    } finally { continuar = true;} 
}
    
    String pasta_criada_local_r = null;
    private void full_ler_mensagem_bot_3(List<com.google.api.services.drive.model.File> lista_de_arquivos, 
        String pasta_criada_local, String id_da_pasta_no_drive) { try {
            
            pasta_criada_local_r = null;
            System.out.println( "INICANDO - full_ler_mensagem_bot_3" );
                        
        try{
            Drive driveService = GoogleDriveUtils.getDriveService();
            
            for( int j = 0; j < lista_de_arquivos.size(); j++ ){
                System.out.println( "ARQUIVO - " + "j: " + j + " - " + lista_de_arquivos.get(j).getName() + " - " + lista_de_arquivos.get(j).getId() ); 
            
                String fileId = lista_de_arquivos.get(j).getId();//"0BwwA4oUTeiV1UVNwOHItT0xfa2M";
                //OutputStream outputStream = new ByteArrayOutputStream();
                //driveService.files().get(fileId).executeMediaAndDownloadTo(outputStream);
                
                File file = new File( pasta_criada_local + "\\" + lista_de_arquivos.get(j).getName() );
                InputStream inputStream = driveService.files().get(fileId).executeMediaAsInputStream();
                OutputStream outputStream = new FileOutputStream( file );
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = inputStream.read( bytes)) != -1 ) {
               
                    outputStream.write( bytes, 0, read );
                }             
                try{ outputStream.flush(); outputStream.close(); }catch(Exception e){}
                
                driveService.files().delete( fileId ).execute(); 
                /*
                try{
                        
                    String htmlRecebida = convertStreamToString(inputStream);
                    System.out.println( "htmlRecebida - " + htmlRecebida ); 
                        
                    inputStream.close();
                }catch(Exception e){}
                */
            }
            
            driveService.files().delete( id_da_pasta_no_drive ).execute(); 
            
            pasta_criada_local_r = pasta_criada_local;
            new Thread() {   @Override public void run() { try {
                
                mostrar_arquivo_html_recebido( pasta_criada_local_r );
                
            } catch( Exception e ){ } } }.start();
            
        } catch( Exception e ){ 
            Arquivo_Ou_Pasta.deletar_Todos_Arquivos_da_Pasta( new File(pasta_criada_local) );
            e.printStackTrace(); 
        } 
        
    } catch( Exception e ){}
}
    
    private void mostrar_arquivo_html_recebido( String pasta_criada_local ){
        try {
            
            File diretorio = new File( pasta_criada_local ); 
                
            if ( diretorio.isDirectory()  ) {
                    
                File[] listaDosArquivos = diretorio.listFiles();
                    
                if ( listaDosArquivos != null ) { 
                        
                    for (int i=0; i < listaDosArquivos.length; i++) {
                            
                        File f = new File( listaDosArquivos[i].getName() );
                            
                        filtrarTipoArquivos( diretorio, f );
                    }                        
                }                    
            }
            else{ /*System.out.println( pasta );*/ }
            
        } catch( Exception e ){}
    }
    
    private void filtrarTipoArquivos( File diretorio, File arquivo ){
        
        try{  
            
            String f = diretorio.getPath() + System.getProperty("file.separator") + arquivo.getPath();
             
            //System.out.println( "filtrarTipoArquivos - HTML - " + f );
                  
            //mensagemHTML( diretorio.getName(), f, false, true );
            
            File file = new File( f );
            
            if ( file.isFile() == true ) {
                
                String extencao = f.substring( f.lastIndexOf('.') + 1 );   
                
                if( extencao.equalsIgnoreCase( "html" ) ){
                    
                    //System.out.println( "filtrarTipoArquivos - HTML - " + arquivo.getName() ); 
                    
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bR = new BufferedReader( new FileReader( file ) );
                    String linha;
		    while( (linha = bR.readLine()) != null){

                        //System.out.println( linha );
                        sb.append( linha );
		    }
                    
                    String data1 = diretorio.getName();
                    String data2 = data1.replace(":", "_");
                    String data3 = data2.replace(".", "_");
                    String data4 = data3.replace("T", "_");
                    String data5 = data4.replace("Z", "");
                    
                    String list_str_1[] = null; try { list_str_1 = data5.split("_"); } catch (Exception e) {}
                    for( int j = 0; j < list_str_1.length; j++ ){
                        System.out.println( "String - " + j + " - " + list_str_1[j] );
                    }
                    String nome_data_hora_mensagem = list_str_1[2]+"/"+list_str_1[1]+"/"+list_str_1[0]+" " +
                                                     list_str_1[3]+":"+list_str_1[4]+":"+list_str_1[5];
                    
                    mensagem2( nome_data_hora_mensagem, sb.toString(), false, true );
                }
            }
                        
        } catch( Exception e ){ System.out.println( "Zero - Diretórios - Home - filtrarTipoArquivos( File diretório, File arquivo )" ); }
    }
    
    private String convertStreamToString(InputStream is) throws IOException {
        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }
            return sb.toString();
        } else {        
            return "";
        }
    }
    
    /** Downloads a file using either resumable or direct media download. */
private static void downloadFile(boolean useDirectDownload, com.google.api.services.drive.model.File uploadedFile) {
    try{
        
        String DIR_FOR_DOWNLOADS = System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS" ;
      
        Drive driveService = GoogleDriveUtils.getDriveService();
        // create parent directory (if necessary)
        java.io.File parentDir = new java.io.File(DIR_FOR_DOWNLOADS);
        if (!parentDir.exists() && !parentDir.mkdirs()) { 
            throw new IOException("Unable to create parent directory");
        }
        
        OutputStream out = new FileOutputStream(new java.io.File( parentDir, uploadedFile.getId() ) );

        MediaHttpDownloader downloader = 
                new MediaHttpDownloader( driveService.getRequestFactory().getTransport(), driveService.getRequestFactory().getInitializer());
        
        downloader.setDirectDownloadEnabled(useDirectDownload);
        //downloader.setProgressListener(new FileDownloadProgressListener());
        downloader.download(new GenericUrl( uploadedFile.getWebContentLink() ), out);
    
    } catch( Exception e ){ e.printStackTrace();} 
}
    
    int proxima_mensagem_a_ler = 1;
    private void full_ler_mensagem_bot_1(final String json) { try {

        //System.out.println("\n***********************************************************************");
        
        String separacao_1[] = json.split("],");
        String str = null; try{ str = separacao_1[ proxima_mensagem_a_ler ]; } catch( Exception e ){}
        if( str != null ){
            
            try { atualizar_properties_ultima_linha_lida(true); } catch( Exception e ){ }
            full_ler_mensagem_bot_2( str );
        }
        
        /*
        String separacao_1[] = json.split("],");
        String v = null; try{ v = separacao_1[proxima_mensagem_a_ler]; } catch (Exception e) {}
        if( v != null ){
            
            System.out.println(proxima_mensagem_a_ler + " - ** proxima_mensagem_a_ler - " + proxima_mensagem_a_ler + " - separacao_1.length - " + separacao_1.length + " - " + separacao_1[proxima_mensagem_a_ler] );
            full_ler_mensagem_bot_2( separacao_1[proxima_mensagem_a_ler] );
            try { atualizar_properties(true); } catch( Exception e ){ }
        }
        */
        
        /*
        for( int i = 1; i < separacao_1.length; i++ ){
            
            System.out.println(i + " - ** proxima_mensagem_a_ler - " + proxima_mensagem_a_ler + " - separacao_1.length - " + separacao_1.length + " - " + separacao_1[i] );

            if( i == proxima_mensagem_a_ler ){
                
                try { atualizar_properties(true); } catch( Exception e ){ }
                full_ler_mensagem_bot_2( separacao_1[i] );
            }
        }
        */
        
        //System.out.println("***********************************************************************\n");
    } catch( Exception e ){} }
    
    private void full_ler_mensagem_bot_2(String json) { try {

        String separacao_1[] = json.split(",");
        
        String data = separacao_1[0].replace("\"", "").replace("[", "");
        String de_email = separacao_1[1].replace("\"", "");
        String para_email = separacao_1[2].replace("\"", "");
        String mensagem = separacao_1[3].replaceAll("\"    ]  ]}", "\"");
        
        String str[] = null; try{ str = mensagem.split("\""); } catch( Exception e ){}
        
        if( str != null ){
        
            if( !de_email.trim().equalsIgnoreCase( email_remetente.trim() )  ){
                
                StringBuilder sb = new StringBuilder();
            
                String strX[] = str[1].split( "__" );                
                for( int i = 0; i < strX.length; i++ ){
                    
                    int x = Integer.parseInt( strX[i] );
                    if( x == 10 ){
                 
                        sb.append("<p>");
                    }
                    else{
                        
                        char c = (char) x;                    
                        sb.append(c);
                    }
                }
                
                mensagem2( data, sb.toString(), false, true );
            }       
        }
    } catch( Exception e ){} }
    
    private void mostrar_mensagens_iniciais() { try {
        
        String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
        String email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
        String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
        String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");

        String destino = System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO; 
        File diretorio = new File( destino ); 
        File[] pasta_da_msg_recebida = diretorio.listFiles(); 
        if ( pasta_da_msg_recebida != null ) { 
            
            for (int j=0; j < pasta_da_msg_recebida.length; j++) {
                
                if ( pasta_da_msg_recebida[j].isDirectory()  ) {
                    
                    String namePasta = pasta_da_msg_recebida[j].getName().trim().toUpperCase();
                    System.out.println( "namePasta - " + namePasta );
                    if ( namePasta.equalsIgnoreCase( "EMOJIS" ) ) {
                        
                    }
                    else if ( namePasta.equalsIgnoreCase( "NAO_ENVIADO" ) ) {
                        /*
                        Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo", "MENSAGENS_RECEBIDAS" );
                        Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS", namePasta ); 
                        String destino2 = System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + namePasta; // NAO_ENVIADO\\
                        
                        File[] listaDosArquivos2 = new File( destino2 ).listFiles();
                        if ( listaDosArquivos2 != null ) { 
                            
                            Arquivo_Ou_Pasta.copiarArquivoNovoNome( listaDosArquivos2[j], destino2, "eu" + ".html" );
                            Arquivo_Ou_Pasta.deletar(listaDosArquivos2[j]);
                        }
                         
                        Arquivo_Ou_Pasta.deletar( pasta_da_msg_recebida[j] );
                        */
                    }
                    else{       
                            
                        String msg_local = System.getProperty("user.dir") + "\\00_Externo\\MENSAGENS_RECEBIDAS\\" + email_REMETENTE + "\\" + email_DESTINATARIO + "\\" + pasta_da_msg_recebida[j].getName().trim();     
                        mostrar_arquivo_html__iniciais_1( msg_local );
                        
                        /*
                        File[] listaDosArquivos2 = pasta_da_msg_recebida[j].listFiles();
                        for (int f=0; f < listaDosArquivos2.length; f++) {
                            
                            File fileS = listaDosArquivos2[f]; 
                            String nome_Arquivo = fileS.getName().trim().toUpperCase();
                            System.out.println( "nome_Arquivo - " + nome_Arquivo );
                            
                            if ( nome_Arquivo.equalsIgnoreCase( "EU.HTML" ) ) {
                                System.out.println( "nome_Arquivo - " + "EU" );
                                
                                String ff = pasta_da_msg_recebida[j].getPath() + System.getProperty("file.separator") + fileS.getPath();
                                String extencao = ff.substring( ff.lastIndexOf('.') + 1 ); 
                                
                                if ( extencao.equalsIgnoreCase( "html" ) ) {
                                    
                                    StringBuilder sb = new StringBuilder();
                                    BufferedReader bR = new BufferedReader( new FileReader( fileS ) );
                                    String linha;
		                    while( (linha = bR.readLine()) != null){
                                        sb.append( linha );
		                    }
                    
                                    System.out.println( sb.toString() );
                                    
                                    String list_str_1[] = null; try { list_str_1 = pasta_da_msg_recebida[j].getName().split("_"); } catch (Exception e) {}
                                    String nome_data_hora_mensagem = list_str_1[1]+"/"+list_str_1[2]+"/"+list_str_1[2]+" " +
                                                     list_str_1[3]+"/"+list_str_1[4]+"/"+list_str_1[5];
                                    
                                    mensagem2("      Você - " + nome_data_hora_mensagem, sb.toString(), true, false);
                                }
                            }
                        }   
                        */
                    }
                }
            }
        }
        
    } catch( Exception e ){} }
    
    private void mostrar_arquivo_html__iniciais_1( String pasta_criada_local ){
        try {
            
            File diretorio = new File( pasta_criada_local ); 
                
            if ( diretorio.isDirectory()  ) {
                    
                File[] listaDosArquivos = diretorio.listFiles();
                    
                if ( listaDosArquivos != null ) { 
                        
                    for (int i=0; i < listaDosArquivos.length; i++) {
                            
                        File f = new File( listaDosArquivos[i].getName() );
                            
                        filtrarTipoArquivos__iniciais_2( diretorio, f );
                    }                        
                }                    
            }
            else{ /*System.out.println( pasta );*/ }
            
        } catch( Exception e ){}
    }
    
    private void filtrarTipoArquivos__iniciais_2( File diretorio, File arquivo ){
        
        try{  
            
            String f = diretorio.getPath() + System.getProperty("file.separator") + arquivo.getPath();
             
            //System.out.println( "filtrarTipoArquivos - HTML - " + f );
                  
            //mensagemHTML( diretorio.getName(), f, false, true );
            
            File file = new File( f );
            
            if ( file.isFile() == true ) {
                
                String extencao = f.substring( f.lastIndexOf('.') + 1 );   
                
                if( extencao.equalsIgnoreCase( "html" ) ){
                    
                    //System.out.println( "filtrarTipoArquivos - HTML - " + arquivo.getName() ); 
                    
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bR = new BufferedReader( new FileReader( file ) );
                    String linha;
		    while( (linha = bR.readLine()) != null){

                        //System.out.println( linha );
                        sb.append( linha );
		    }
                    
                    String data1 = diretorio.getName();
                    String data2 = data1.replace(":", "_");
                    String data3 = data2.replace(".", "_");
                    String data4 = data3.replace("T", "_");
                    String data5 = data4.replace("Z", "");
                    
                    String list_str_1[] = null; try { list_str_1 = data5.split("_"); } catch (Exception e) {}
                    for( int j = 0; j < list_str_1.length; j++ ){
                        System.out.println( "String - " + j + " - " + list_str_1[j] );
                    }
                    String nome_data_hora_mensagem = list_str_1[2]+"/"+list_str_1[1]+"/"+list_str_1[0]+" " +
                                                     list_str_1[3]+":"+list_str_1[4]+":"+list_str_1[5];
                    
                    String nome_email_destinatario = email_destinatario.trim().toUpperCase().replace("@", "_");
                    String email_DESTINATARIO = nome_email_destinatario.trim().toUpperCase().replace(".", "_");
                    String arquivo_properties2 = email_remetente.trim().toUpperCase().replace("@", "_");
                    String email_REMETENTE = arquivo_properties2.trim().toUpperCase().replace(".", "_");
                    
                    String remetente_e_destinatario = email_REMETENTE    + "-" + email_DESTINATARIO + "-";
                    String destinatario_e_remetente = email_DESTINATARIO + "-" + email_REMETENTE + "-";
                    
                    if ( arquivo.getName().equalsIgnoreCase( remetente_e_destinatario + ".HTML" ) ) {
                        
                        mensagem2("      Você - " + nome_data_hora_mensagem, sb.toString(), true, false);
                    }
                    else if ( arquivo.getName().equalsIgnoreCase( destinatario_e_remetente + ".HTML" ) ) {
                        
                        mensagem2( nome_data_hora_mensagem, sb.toString(), false, false );
                    }
                }
            }
                        
        } catch( Exception e ){ System.out.println( "Zero - Diretórios - Home - filtrarTipoArquivos( File diretório, File arquivo )" ); }
    }
            
    private void mostrar_mensagens_iniciais2() { try {
        
        try{ 
            /*
            String USER_AGENT = "Mozilla/5.0";
            String GET_URL = id_planilha_google;
                
            HttpURLConnection con = (HttpURLConnection) new URL(GET_URL).openConnection();
            con.setRequestMethod("GET");
	    con.setRequestProperty("User-Agent", USER_AGENT);
	    int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
	            con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
                }
		in.close();
                mostrar_mensagem_parte_1( response.toString() );
                //System.out.println("Mensagem enviada.");
            }
              */      
        } catch( Exception e ){  }       
        
    } catch( Exception e ){} }
    
    private void mostrar_mensagem_parte_1(String json) { try {

        String separacao_1[] = json.split("],");
        for( int i = 1; i < separacao_1.length; i++ ){
            
            mostrar_mensagem_parte_2( separacao_1[i], i );
        }     
    } catch( Exception e ){} }
    
    private void mostrar_mensagem_parte_2( String json, int i_R ) { try {

        String separacao_1[] = json.split(",");
        
        String data = separacao_1[0].replace("\"", "").replace("[", "");
        String de_email = separacao_1[1].replace("\"", "");
        String para_email = separacao_1[2].replace("\"", "");
        String mensagem = separacao_1[3].replaceAll("\"    ]  ]}", "\"");
        
        String str[] = null; try{ str = mensagem.split("\""); } catch( Exception e ){}
        
        if( str != null ){
        
            if( de_email.trim().equalsIgnoreCase( email_remetente.trim() )  ){
                
                StringBuilder sb = new StringBuilder();            
                String strX[] = str[1].split( "__" );                
                for( int i = 0; i < strX.length; i++ ){                    
                    int x = Integer.parseInt( strX[i] );
                    if( x == 10 ){                 
                        sb.append("<p>");
                    }
                    else{                        
                        char c = (char) x;                    
                        sb.append(c);
                    }
                }
            
                if( i_R >= proxima_mensagem_a_ler ){
                    
                    try { atualizar_properties_ultima_linha_lida(true); } catch( Exception e ){ }
                    mensagem2("      Você - " + data, sb.toString(), true, true );
                    //System.out.println( "INICIAL i_R: " + i_R + " - proxima_mensagem_a_ler - " + proxima_mensagem_a_ler + "      Você - " + data + " - " + de_email + " - " + para_email + " - " + mensagem);
                }
                else{
                    
                    mensagem2("      Você - " + data, sb.toString(), true, false );
                    //System.out.println( "INICIAL i_R: " + i_R + " - proxima_mensagem_a_ler - " + proxima_mensagem_a_ler + "      Você - " + data + " - " + de_email + " - " + para_email + " - " + mensagem);
                }
            }
            else{
                
                StringBuilder sb = new StringBuilder();            
                String strX[] = str[1].split( "__" );                
                for( int i = 0; i < strX.length; i++ ){                    
                    int x = Integer.parseInt( strX[i] );
                    if( x == 10 ){                 
                        sb.append("<p>");
                    }
                    else{                        
                        char c = (char) x;                    
                        sb.append(c);
                    }
                }
                    
                if( i_R >= proxima_mensagem_a_ler ){
                    
                    try { atualizar_properties_ultima_linha_lida(true); } catch( Exception e ){ }
                    mensagem2( data, sb.toString(), false, true );
                    //System.out.println( "INICIAL i_R: " + i_R + " - proxima_mensagem_a_ler - " + proxima_mensagem_a_ler + " - " + data + " - " + de_email + " - " + para_email + " - " + mensagem);
                }
                else{
                    
                    mensagem2( data, sb.toString(), false, false );
                    //System.out.println( "INICIAL i_R: " + i_R + " - proxima_mensagem_a_ler - " + proxima_mensagem_a_ler + " - " + data + " - " + de_email + " - " + para_email + " - " + mensagem);
                }
            }        
        }
    } catch( Exception e ){} }
            
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    private void mensagem_no_SystemTray(String mensagem) { try {
        
        
        if (SystemTray.isSupported()) {
            
            if (Home.tray_Icone_JM != null) {
                
                String dados = "Nova mensagem recebida!!!"; // mensagem.replaceAll("<p>", "");
            
////////////////AQUI A MENSAGEM DE ALERTA QUE IMPORTA ////////////////////////////////////////////////////////////////            
                Home.tray_Icone_JM.displayMessage("Mensagem Turbo Flyer de: " + nome_deste_contato, dados, TrayIcon.MessageType.INFO );
////////////////AQUI A MENSAGEM DE ALERTA QUE IMPORTA ////////////////////////////////////////////////////////////////
            }

        }
    } catch( Exception e ){} }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
    boolean seMovimentando = false;
    private void alterar_nome_JTabbedPane_leu_mensagem2(){

        if( seMovimentando == false ){
            
            seMovimentando = true;
            try { Gerenciador_Email_02_Cadastrar_Visualizar.alterar_nome_JTabbedPane_leu_mensagem( nome_deste_contato, this, getIcon() ); } catch( Exception e ){ } 
            
            try {
                Thread.sleep( 1000 );
                seMovimentando = false;
            } catch( Exception e ){ } 
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public void alterar_nome_JTabbedPane_Status_online() { /*new Thread() {   @Override public void run() {*/ try { 
        
        try { Gerenciador_Email_02_Cadastrar_Visualizar.alterar_nome_JTabbedPane_Status_online( nome_deste_contato, getIcon() ); } catch( Exception e ){ } 
            
    } catch( Exception e ){ } /*} }.start();*/ }
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
}