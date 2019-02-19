
package turbo_flyer;

import br.com.jmary.home.Home;
import br.com.jmary.home.controle_tab.ButtonTabComponent;
import br.com.jmary.home.imagens.Imagens_Internas;
import br.com.jmary.utilidades.Arquivo_Ou_Pasta;
import javax.swing.ImageIcon;
import br.com.jmary.utilidades.JOPM;
import br.com.jmary.utilidades.PopupMenu_Colar;
import br.com.jmary.utilidades.ValidarEmail;
import com.google.api.services.drive.Drive;
import google_original.Atualizar_Data_Modificacao_Arquivo;
import static google_original.CreateGoogleFile.createGoogleFile;
import google_original.GetSubFolders;
import google_original.GoogleDriveUtils;
import home_controle_menus_norte.imagens.Imagens_Menu_Norte;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import login_do_sistema.Login;
import usuarios_do_sistema_beans.UsuarioSistema;

/**
 *
 * @author AnaMariana
 */
public class Gerenciador_Email_02_Cadastrar_Visualizar extends javax.swing.JPanel {   
    
    Home Home;
    String status_cadastro;
    UsuarioSistema UsuarioSistema_Recebido;
    public JTabbedPane JTabbedPane_Recebido;
    PopupMenu_Colar PopupMenu_Colar;
    
    public Tabela Tabela;

    /** Creates new form SombraVendas
     * @param Home2
     * @param JTabbedPane_Recebido2
     * @param status_cadastro2 */
    public Gerenciador_Email_02_Cadastrar_Visualizar( Home Home2, JTabbedPane JTabbedPane_Recebido2, String status_cadastro2 ) {
        initComponents();
        
        Home = Home2;  
        status_cadastro = status_cadastro2;
        JTabbedPane_Recebido = JTabbedPane_Recebido2;
        
        Tabela = new Tabela("");
        
        _1_google_inicial();
                 
        setar_Dados_Tabela();
        
        setar_Dados_Iniciais();      
        
        //jp001.setVisible(false);
        //jp002.setVisible(false);
    }
    
    String nome = "";
    String email = "";
    int quantidade_de_contatos = 0;
    Email_Mensagens_Por_Contato Email_Mensagens_Por_Contato;
    public String nome_verdadeiro_do_tab_selecionado = "";
    private void setar_Dados_Iniciais(){
        /*new Thread() {   @Override public void run() {*/ try {  
            
//////////////////////////////////////////////////////////////////////////////////////////////            
            imgURL  = Imagens_Menu_Norte.class.getResource("seta_para_baixo.png");
            icon    = new ImageIcon( imgURL );  
            
            imgURL2  = Imagens_Menu_Norte.class.getResource("seta_para_cima.png");
            icon2   = new ImageIcon( imgURL2 ); 
//////////////////////////////////////////////////////////////////////////////////////////////
           
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
                String id_planilha_google = "";
                String id_0_formulario = "";
                String id_1_formulario_email_de = "";
                String id_2_formulario_email_para = "";
                String id_3_formulario_mensagem = "";
                String id_4_formulario_imagem = ""; 
                
                String id_planilha_google_status_de = "";
                String id_1_formulario_status_de = "";
                String id_1_formulario_status_email_de = "";
                */
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           //HashMap<String, Email_Mensagens_Por_Contato> hashMaps = new HashMap<String, Email_Mensagens_Por_Contato>();
           for(int i = 0; i< Tabela.tbPesquisa.getRowCount(); i++){ 
                              
               nome = "";
               email = "";
               
               for(int j = 0; j < Tabela.tbPesquisa.getColumnCount(); j++){
                   
                   if( j == 1 ){
                       
                       nome = (String) Tabela.tbPesquisa.getValueAt( i, j );                                              
                   }
                   else if( j == 2 ){
                       
                       email = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   
                   /*
                   else if( j == 3 ){
                       id_planilha_google = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   else if( j == 4 ){
                       id_0_formulario = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   else if( j == 5 ){
                       id_1_formulario_email_de = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   else if( j == 6 ){
                       id_2_formulario_email_para = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   else if( j == 7 ){
                       id_3_formulario_mensagem = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   else if( j == 8 ){
                       id_4_formulario_imagem = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   else if( j == 9 ){
                       id_planilha_google_status_de = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   else if( j == 10 ){
                       id_1_formulario_status_de = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   else if( j == 11 ){
                       id_1_formulario_status_email_de = (String) Tabela.tbPesquisa.getValueAt( i, j );
                   }
                   */
               }
                
                quantidade_de_contatos++;
                //String novo_nome = String.valueOf(quantidade_de_contatos) + " - " + nome;
                Email_Mensagens_Por_Contato = new Email_Mensagens_Por_Contato(Home, email.trim().toUpperCase(),this, nome
                        /*
                    id_planilha_google,
                    id_0_formulario,
                    id_1_formulario_email_de,
                    id_2_formulario_email_para,
                    id_3_formulario_mensagem,
                    id_4_formulario_imagem,
                        
                    id_planilha_google_status_de,
                    id_1_formulario_status_de,
                    id_1_formulario_status_email_de 
                        */
                );
               
                Home.ControleTabs.AddTabComControle(tabPessoas, 
                        "     " + nome + "       ", "livroTp.gif", 
                        Email_Mensagens_Por_Contato );
                
                setar_hashMap_Email_Mensagens_Por_Contato( email.trim().toUpperCase(), Email_Mensagens_Por_Contato );
               
                //new Thread() {   @Override public void run() { try { Thread.sleep( 1 );
                
                    //setar_Dados_Iniciais2( Email_Mensagens_Por_Contato, nome, email ); 
                //} catch( Exception e ){ } } }.start();     
           }
           
           tabPessoas.setSelectedIndex(0);
           
           tabPessoas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    //System.out.println("Aba Selecionada = " + tabPessoas.getSelectedIndex());
                    String nome = tabPessoas.getTitleAt( tabPessoas.getSelectedIndex() ).trim();
                    if( tabPessoas.getSelectedIndex() != 0 ){
                        
                        //String[] doisnomes = nome.split("-");
                        //nome_verdadeiro_do_tab_selecionado = doisnomes[0].trim() + " - " + doisnomes[1].trim();
                        nome_verdadeiro_do_tab_selecionado = nome;
                        //System.out.println("Aba Selecionada = " + nome_verdadeiro_do_tab_selecionado );
                    }
                    else{
                        
                        nome_verdadeiro_do_tab_selecionado = "Meus Dados";
                    }
                } catch( Exception ee ){ }
            }
            });          

        } catch( Exception e ){  } //} }.start();
    }   
    
    Map<String,Email_Mensagens_Por_Contato> hashMap = new HashMap<String,Email_Mensagens_Por_Contato>();
    private void setar_hashMap_Email_Mensagens_Por_Contato(String email, Email_Mensagens_Por_Contato Email_Mensagens_Por_Contato2){
        /*new Thread() {   @Override public void run() {*/ try {  
                                    
            hashMap.put(email, Email_Mensagens_Por_Contato2);
            System.out.println( "hashMap.put(email.trim(), Email_Mensagens_Por_Contato2); - " + email );

        } catch( Exception e ){  } //} }.start();
    }
    
    public boolean setar_Mensagem(String nome, String email, String dataCadastro, String mensagem, boolean posicao){
        boolean retorno = false;
        /*new Thread() {   @Override public void run() {*/ try {  
            //System.out.println( "public boolean setar_Mensagem( -  - email - " + email + " - " + mensagem );
            
            Email_Mensagens_Por_Contato Contato_Procurado = null; 
            
            try { 
                
                Contato_Procurado = hashMap.get(email.trim()); 
                
                hashMap.get(email.trim()).mensagem2( dataCadastro, mensagem, posicao, true); 
                
                retorno = true;
                
                //System.out.println( "public boolean setar_Mensagem( -  - email - " + email + " - Mensagem Recebida - " + mensagem );
                //System.out.println( "public boolean setar_Mensagem( -  - mensagem - OK " );
            } catch( Exception e ){ 
                retorno = false; 
                //System.out.println( "public boolean setar_Mensagem( -  - mensagem - EMAIL DIFERENTE " );
            }

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
        
        return retorno;
    }
    
    public boolean setar_Mensagem_se_igual_Textifield(String email){
        boolean retorno = false;
        try {  
            //System.out.println( "1 - setar_Mensagem_se_igual_Textifield - " );

            try { 
                
                //hashMap.get(email.trim()).mensagemTeste(); 
                
                retorno = true;
                
                //System.out.println( "2 - setar_Mensagem_se_igual_Textifield - " );
                //System.out.println( "public boolean setar_Mensagem( -  - email - " + email + " - Mensagem Recebida - " + mensagem );
                //System.out.println( "public boolean setar_Mensagem( -  - mensagem - OK " );
            } catch( Exception e ){ 
                retorno = false; 
                //System.out.println( "3 - erro - setar_Mensagem_se_igual_Textifield - " );
                //System.out.println( "public boolean setar_Mensagem( -  - mensagem - EMAIL DIFERENTE " );
            }

            //System.out.println( "4 - setar_Mensagem_se_igual_Textifield - " );
        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
        
        //System.out.println( "5 - setar_Mensagem_se_igual_Textifield - " );
        return retorno;
    }
    
    public boolean setar_Mensagem_Icone(String email, boolean status){
        boolean retorno = false;
        try {  
            
            try { 
                
                hashMap.get(email.trim()).status_do_usuario = status; 
                hashMap.get(email.trim()).alterar_nome_JTabbedPane_Status_online(); 
                
                retorno = true;

            } catch( Exception e ){ retorno = false; }

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
        
        return retorno;
    }
    
    String id_1_formulario_status_de = "";
    String id_1_formulario_status_email_de = "";
    private void setar_Dados_Tabela(){
        /*new Thread() {   @Override public void run() {*/ try { 
            
            jpDados.setLayout( new BorderLayout() );
            jpDados.add( Tabela , BorderLayout.CENTER );
            
            String email_Usuario_Logado = ""; 
            try{ email_Usuario_Logado = Login.Usuario_Logado.getEmailRecuperacao(); }catch( Exception e ){}                       
            
            if( !email_Usuario_Logado.equals("") ){    
                
                tf_email.setText(email_Usuario_Logado.trim().toUpperCase());
                
                String arquivo_properties = email_Usuario_Logado.trim().toUpperCase().replace("@", "_");
                String email_Logado = arquivo_properties.trim().toUpperCase().replace(".", "_");
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\", "00_Externo" );  
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo", "CONTATOS" );
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\CONTATOS", email_Logado );
                
                String pasta = System.getProperty("user.dir") + "\\" + "\\00_Externo\\CONTATOS\\" + email_Logado; 
                File diretorio = new File( pasta ); 
                
                File lista_de_arquivos[] = null; try{ lista_de_arquivos = diretorio.listFiles(); } catch( Exception e ){  }
                if ( lista_de_arquivos != null ) { 
                    
                    for (int j=0; j < lista_de_arquivos.length; j++) {
                
                        String arquivoASerCriado = System.getProperty("user.dir") + "\\" + "\\00_Externo\\CONTATOS\\" + email_Logado + "\\" + lista_de_arquivos[j].getName(); 
                        System.out.println( "arquivoASerCriado: " + arquivoASerCriado );    
                        
                        Properties properties = new Properties();                                   
                        FileInputStream in = null;
                        try{ 
                            in = new FileInputStream( arquivoASerCriado ); 
                            properties.loadFromXML(in);
                            in.close();
                     
                            String nome = "";
                            String email = "";
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            /*
                            String id_planilha_google = "";
                            String id_0_formulario = "";
                            String id_1_formulario_email_de = "";
                            String id_2_formulario_email_para = "";
                            String id_3_formulario_mensagem = "";
                            String id_4_formulario_imagem = "";
                            id_1_formulario_status_de = "";
                            
                            String id_planilha_google_status_de = "";                            
                            id_1_formulario_status_email_de = "";
                            */
                            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            for(Enumeration elms = properties.propertyNames(); elms.hasMoreElements();){
                                
                                String prop = (String)elms.nextElement();
                                String value = properties.getProperty(prop).trim();
                                
                                switch( prop ){
                                    case "nome": 
                                        nome = value;    
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "email": 
                                        email = value;   
                                        System.out.println( prop + " - " + value );
                                    break;
                                    
                                    /*
                                    case "id_planilha_google": 
                                        id_planilha_google = value;
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "id_0_formulario": 
                                        id_0_formulario = value;
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "id_1_formulario_email_de": 
                                        id_1_formulario_email_de = value;
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "id_2_formulario_email_para": 
                                        id_2_formulario_email_para = value;
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "id_3_formulario_mensagem": 
                                        id_3_formulario_mensagem = value;   
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "id_4_formulario_imagem": 
                                        id_4_formulario_imagem = value;   
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "id_planilha_google_status_de": 
                                        id_planilha_google_status_de = value;  
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "id_1_formulario_status_de": 
                                        id_1_formulario_status_de = value;  
                                        System.out.println( prop + " - " + value );
                                    break;
                                    case "id_1_formulario_status_email_de": 
                                        id_1_formulario_status_email_de = value;
                                        System.out.println( prop + " - " + value );
                                    break;
                                    */
                                }
                            }
                            /*
                            tf_Email1.setText( id_planilha_google_status_de );
                            tf_Email3.setText( id_1_formulario_status_de );
                            tf_Email2.setText( id_1_formulario_status_email_de );
                            */
                            
                            new Thread() {   @Override public void run() { try { 
                
                                informar_Status( id_1_formulario_status_de, id_1_formulario_status_email_de, tf_email.getText().trim() );
            
                            } catch( Exception e ){ } } }.start(); 
                            
                                    
                            Object[] rowData = new Object[] { new ImageIcon( Imagens_Menu_Norte.class.getResource("lixo2.png") ), 
                                nome, 
                                email
                                    /*
                                id_planilha_google,
                                id_0_formulario,
                                id_1_formulario_email_de,
                                id_2_formulario_email_para,
                                id_3_formulario_mensagem,
                                id_4_formulario_imagem,
                                id_planilha_google_status_de,
                                id_1_formulario_status_de,
                                id_1_formulario_status_email_de
                                    */
                            }; 
                            
                            Tabela.setar_linha_na_tabela( rowData );
                
                        } catch( Exception e ){  }
                    
                    }
                
                }
            }
            
        } catch( Exception e ){  } //} }.start();
    }  
    
    boolean uma_vez = false;
    //public String data_informar_Status = ""; 
    private void informar_Status(String id_1_formulario_status_de, String id_1_formulario_status_email_de, String email_remetente) {   
        if( uma_vez == false ){
            uma_vez = true;
        do{
            /*new Thread() {   @Override public void run() {*/ try { Thread.sleep( 20000 );      
                String USER_AGENT = "Mozilla/5.0";
                String GET_URL = "https://docs.google.com/forms/d/e/" + id_1_formulario_status_de + "/formResponse?"
                        + "entry." + id_1_formulario_status_email_de + "=" + email_remetente;
            
                HttpURLConnection con = (HttpURLConnection) new URL(GET_URL).openConnection();
                con.setRequestMethod("GET");
	        con.setRequestProperty("User-Agent", USER_AGENT);
	        int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {                                        
                    /*
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    String inputLine;
		    StringBuffer response = new StringBuffer();

		    while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
                    }
		    in.close();
                    */
                    
                    /*
                    java.util.Date dt = new java.util.Date (con.getDate());
                    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(dt.getTime());   
                    DateFormat dfmt = new SimpleDateFormat("HH:mm:ss");
                    DateFormat dfmtFull = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String dataCadastro = "";                     
                    try{ dataCadastro = dfmt.format(currentTimestamp);  }catch(Exception e){}
                    try{ data_informar_Status = dfmtFull.format(currentTimestamp);  }catch(Exception e){}
                    */
                    //subtrair_datas();
                }     
                else{
                    
                    //subtrair_datas();
                }
            } catch( Exception e ){ 
                
                //subtrair_datas();
            } //} }.start();
        }while( true );
        }
    } 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Pergunta = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tabPessoas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        JPOpcao_38 = new javax.swing.JPanel();
        tf_email = new javax.swing.JTextField();
        JPOpcao_37 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jpDados = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btSalvar1 = new javax.swing.JButton();
        JPOpcao_35 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jp5 = new javax.swing.JPanel();
        JPOpcao_45 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        JPOpcao_46 = new javax.swing.JPanel();
        tf_Senha1 = new javax.swing.JTextField();
        jp6 = new javax.swing.JPanel();
        JPOpcao_47 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        JPOpcao_48 = new javax.swing.JPanel();
        tf_Senha2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(857, 493));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1170, 1202));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Turbo Flyer - JMarySystems");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/seta_para_cima.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tabPessoas.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabPessoas.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        JPOpcao_38.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_38.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_38.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_38MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_38MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_38MousePressed(evt);
            }
        });

        tf_email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tf_email.setPreferredSize(new java.awt.Dimension(209, 25));
        tf_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_emailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tf_emailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tf_emailMouseExited(evt);
            }
        });
        tf_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_emailKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_38Layout = new javax.swing.GroupLayout(JPOpcao_38);
        JPOpcao_38.setLayout(JPOpcao_38Layout);
        JPOpcao_38Layout.setHorizontalGroup(
            JPOpcao_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_email, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_38Layout.setVerticalGroup(
            JPOpcao_38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_38Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JPOpcao_37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(153, 0, 153)));
        JPOpcao_37.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_37MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_37MousePressed(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel90.setText("Meu Email");

        jLabel91.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/usuarios.gif"))); // NOI18N
        jLabel91.setToolTipText("Selecionar Usuário");
        jLabel91.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel91MousePressed(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_37Layout = new javax.swing.GroupLayout(JPOpcao_37);
        JPOpcao_37.setLayout(JPOpcao_37Layout);
        JPOpcao_37Layout.setHorizontalGroup(
            JPOpcao_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_37Layout.createSequentialGroup()
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel91)
                .addContainerGap())
        );
        JPOpcao_37Layout.setVerticalGroup(
            JPOpcao_37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jpDadosLayout = new javax.swing.GroupLayout(jpDados);
        jpDados.setLayout(jpDadosLayout);
        jpDadosLayout.setHorizontalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpDadosLayout.setVerticalGroup(
            jpDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(JPOpcao_37, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPOpcao_38, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JPOpcao_37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPOpcao_38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Meus Dados", jPanel5);

        btSalvar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/livroTp.png"))); // NOI18N
        btSalvar1.setText("adicionar");
        btSalvar1.setPreferredSize(new java.awt.Dimension(185, 31));
        btSalvar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btSalvar1MousePressed(evt);
            }
        });

        JPOpcao_35.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(153, 0, 153)));
        JPOpcao_35.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_35MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_35MousePressed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("  Contatos:");

        jLabel89.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/usuarios.gif"))); // NOI18N
        jLabel89.setToolTipText("Selecionar Usuário");
        jLabel89.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel89MousePressed(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_35Layout = new javax.swing.GroupLayout(JPOpcao_35);
        JPOpcao_35.setLayout(JPOpcao_35Layout);
        JPOpcao_35Layout.setHorizontalGroup(
            JPOpcao_35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_35Layout.createSequentialGroup()
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel89)
                .addContainerGap())
        );
        JPOpcao_35Layout.setVerticalGroup(
            JPOpcao_35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPOpcao_45.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(153, 0, 153)));
        JPOpcao_45.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_45MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_45MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_45MousePressed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel93.setText("  Nome:");

        javax.swing.GroupLayout JPOpcao_45Layout = new javax.swing.GroupLayout(JPOpcao_45);
        JPOpcao_45.setLayout(JPOpcao_45Layout);
        JPOpcao_45Layout.setHorizontalGroup(
            JPOpcao_45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_45Layout.createSequentialGroup()
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        JPOpcao_45Layout.setVerticalGroup(
            JPOpcao_45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPOpcao_46.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_46.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_46.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_46MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_46MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_46MousePressed(evt);
            }
        });

        tf_Senha1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_Senha1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Senha1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tf_Senha1.setPreferredSize(new java.awt.Dimension(209, 25));
        tf_Senha1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_Senha1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tf_Senha1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tf_Senha1MouseExited(evt);
            }
        });
        tf_Senha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_Senha1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_46Layout = new javax.swing.GroupLayout(JPOpcao_46);
        JPOpcao_46.setLayout(JPOpcao_46Layout);
        JPOpcao_46Layout.setHorizontalGroup(
            JPOpcao_46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_Senha1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_46Layout.setVerticalGroup(
            JPOpcao_46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_46Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_Senha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jp5Layout = new javax.swing.GroupLayout(jp5);
        jp5.setLayout(jp5Layout);
        jp5Layout.setHorizontalGroup(
            jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JPOpcao_45, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(JPOpcao_46, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jp5Layout.setVerticalGroup(
            jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp5Layout.createSequentialGroup()
                .addComponent(JPOpcao_45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JPOpcao_46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPOpcao_47.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(153, 0, 153)));
        JPOpcao_47.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_47MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_47MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_47MousePressed(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel95.setText("  E-mail:");

        javax.swing.GroupLayout JPOpcao_47Layout = new javax.swing.GroupLayout(JPOpcao_47);
        JPOpcao_47.setLayout(JPOpcao_47Layout);
        JPOpcao_47Layout.setHorizontalGroup(
            JPOpcao_47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_47Layout.createSequentialGroup()
                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPOpcao_47Layout.setVerticalGroup(
            JPOpcao_47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPOpcao_48.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_48.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_48.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_48MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_48MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_48MousePressed(evt);
            }
        });

        tf_Senha2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_Senha2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_Senha2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tf_Senha2.setPreferredSize(new java.awt.Dimension(209, 25));
        tf_Senha2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_Senha2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tf_Senha2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tf_Senha2MouseExited(evt);
            }
        });
        tf_Senha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_Senha2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_48Layout = new javax.swing.GroupLayout(JPOpcao_48);
        JPOpcao_48.setLayout(JPOpcao_48Layout);
        JPOpcao_48Layout.setHorizontalGroup(
            JPOpcao_48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_Senha2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_48Layout.setVerticalGroup(
            JPOpcao_48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_48Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_Senha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jp6Layout = new javax.swing.GroupLayout(jp6);
        jp6.setLayout(jp6Layout);
        jp6Layout.setHorizontalGroup(
            jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JPOpcao_48, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(JPOpcao_47, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jp6Layout.setVerticalGroup(
            jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp6Layout.createSequentialGroup()
                .addComponent(JPOpcao_47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JPOpcao_48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JPOpcao_35, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JPOpcao_35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalvar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Adicionar Contato", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        tabPessoas.addTab("Meus Dados", jPanel1);

        javax.swing.GroupLayout PerguntaLayout = new javax.swing.GroupLayout(Pergunta);
        Pergunta.setLayout(PerguntaLayout);
        PerguntaLayout.setHorizontalGroup(
            PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPessoas)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PerguntaLayout.setVerticalGroup(
            PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerguntaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPessoas))
        );

        jTabbedPane1.addTab("Gerenciador de Mensagens", Pergunta);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   
    private URL       imgURL; 
    private ImageIcon icon;            
    private URL       imgURL2;
    private ImageIcon icon2;
    private boolean cimabaixo = true; 
    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        
        mostrar_Ocultar_Jp_Padrao_Tabela();
    }//GEN-LAST:event_jLabel3MousePressed

    private void mostrar_Ocultar_Jp_Padrao_Tabela() {                                     
        try{

            if( cimabaixo == false ){
                cimabaixo = true;
                
                jLabel3.setToolTipText( "Ocultar Submenu" );
                jLabel3.setIcon( icon2 );              
                
                //jp_Padrao_Tabela.setVisible(true);
            } else if( cimabaixo == true ){
                cimabaixo = false;
                                
                jLabel3.setToolTipText( "Mostrar Submenu" );
                jLabel3.setIcon( icon );  
                
                //jp_Padrao_Tabela.setVisible(false);
            }
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "tabJanelaSubmenu, \n"
                + e.getMessage() + "\n", "Alterar_Seta_Submenu" ); }       
    } 
    
    private void jLabel89MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel89MousePressed

    private void JPOpcao_35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_35MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_35MouseEntered

    private void JPOpcao_35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_35MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_35MouseExited

    private void JPOpcao_35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_35MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_35MousePressed

    private void btSalvar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvar1MousePressed
        
            //new Thread() {   @Override public void run() {
            try {
                //CreateFolder.criar_Pasta("JMARYSYSTEMS_00001111");
                //GetSubFolders.listar_folders_root();
                Atualizar_Data_Modificacao_Arquivo.listar_arquivos_de_pasta_especifica_no_root("Restaurante Pipo");
                //GetSubFoldersByName.listar_folders_rootByName("JMTRUE");
            
            String nome = ""; try { nome = tf_Senha1.getText().trim(); } catch( Exception e ){  }
            if( !nome.equals("") ){
            
            String email = ""; try { email = tf_Senha2.getText().trim(); } catch( Exception e ){  }
            
            if( !email.equals("") ){
            
            if( ValidarEmail.validar( email ) == true ){
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                /*
                String id_planilha_google = "https://sheets.googleapis.com/v4/spreadsheets/" + tf_Email4.getText().trim() + "/values/A:F?key=AIzaSyBwiMCywJRFQHuuksWdhqwjOrR5mDaWJYs";
                String id_0_formulario = tf_Email5.getText().trim();
                String id_1_formulario_email_de = tf_Email6.getText().trim();
                String id_2_formulario_email_para = tf_Email7.getText().trim();
                String id_3_formulario_mensagem = tf_Email9.getText().trim();
                String id_4_formulario_imagem = tf_Email8.getText().trim(); 
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                String id_planilha_google_status_de = "https://sheets.googleapis.com/v4/spreadsheets/" + tf_Email1.getText().trim() + "/values/A:B?key=AIzaSyBwiMCywJRFQHuuksWdhqwjOrR5mDaWJYs";
                String id_1_formulario_status_de = tf_Email3.getText().trim();
                String id_1_formulario_status_email_de = tf_Email2.getText().trim();
                */
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                
                Object[] rowData = new Object[] { new ImageIcon( Imagens_Menu_Norte.class.getResource("lixo2.png") ), 
                                nome, 
                                email
                            }; 
                Tabela.setar_linha_na_tabela( rowData );
                
                quantidade_de_contatos++;
                //String novo_nome = String.valueOf(quantidade_de_contatos) + " - " + nome;
                Email_Mensagens_Por_Contato = new Email_Mensagens_Por_Contato(Home, email.trim().toUpperCase(),this, nome );
               
                Home.ControleTabs.AddTabComControle(tabPessoas, 
                        "     " + nome + "       ", "livroTp.gif", 
                        Email_Mensagens_Por_Contato );
                tabPessoas.setSelectedIndex(0);
                
                setar_hashMap_Email_Mensagens_Por_Contato( email.trim().toUpperCase(), Email_Mensagens_Por_Contato );
                
                atualizar_properties( nome, email );
            }
            else{
            
            ValidarEmail.emailInvalido();
            tf_Senha2.requestFocus();
            }
            }
            else{
            
            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CADASTRO DE USUÁRIO\n"
            + "\n"
            + "\nSTATUS DO CADASTRO"
            + "\n"
            + "\nEMAIL NÃO INFORMADO\n"
            + "\n"
            + "\nOK PARA PROSSEGUIR"
            ,"Class: " + this.getClass().getName(),
            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
            }
            }
            else{
            
            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CADASTRO DE USUÁRIO\n"
            + "\n"
            + "\nSTATUS DO CADASTRO"
            + "\n"
            + "\nNOME NÃO INFORMADO\n"
            + "\n"
            + "\nOK PARA PROSSEGUIR"
            ,"Class: " + this.getClass().getName(),
            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
            }
            } catch( Exception e ){  } //} }.start();
    }//GEN-LAST:event_btSalvar1MousePressed
    
    private void atualizar_properties( String nome, String email
            /*
            String id_planilha_google,
                String id_0_formulario,
                String id_1_formulario_email_de,
                String id_2_formulario_email_para,
                String id_3_formulario_mensagem,
                String id_4_formulario_imagem,
                        
                String id_planilha_google_status_de,
                String id_1_formulario_status_de,
                String id_1_formulario_status_email_de
            */
    ){
        /*new Thread() {   @Override public void run() {*/ try { 
            
            String email_Usuario_Logado = ""; 
            try{ email_Usuario_Logado = Login.Usuario_Logado.getEmailRecuperacao(); }catch( Exception e ){}
            
            if( !email_Usuario_Logado.equals("") ){
                
                String arquivo_properties = email_Usuario_Logado.trim().toUpperCase().replace("@", "_");
                String email_Logado = arquivo_properties.trim().toUpperCase().replace(".", "_");
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\", "00_Externo" );
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo", "CONTATOS" );
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo\\CONTATOS", email_Logado );
                
                //String pasta = System.getProperty("user.dir") + "\\" + "\\00_Externo\\CONTATOS\\" + email_Logado; 
                //File diretorio = new File( pasta );
                
                //File lista_de_arquivos[] = null; try{ lista_de_arquivos = diretorio.listFiles(); } catch( Exception e ){  }
                //if ( lista_de_arquivos != null ) {
                    
                    //for (int j=0; j < lista_de_arquivos.length; j++) {
                
                        String arquivo_properties22 = email.trim().toUpperCase().replace("@", "_");
                        String email_contato = arquivo_properties22.trim().toUpperCase().replace(".", "_");
                        String arquivoASerCriado = System.getProperty("user.dir") + "\\00_Externo\\CONTATOS\\" + email_Logado + "\\" + email_contato + ".properties";
                        
                        Properties properties = new Properties();                                   
                        FileInputStream in = null;
                        try{ 
                            in = new FileInputStream( arquivoASerCriado ); 
                            properties.loadFromXML(in);
                            in.close();
                                        
                            Arquivo_Ou_Pasta.deletar( new File( arquivoASerCriado ) );  
                    
                            Properties propertiesX = new Properties();
                            /*
                            for(Enumeration elms = properties.propertyNames(); elms.hasMoreElements();){
                        
                                String prop = (String)elms.nextElement();
                                String value = properties.getProperty(prop);
                        
                                propertiesX.put(prop, value);
                            }
                            */                            
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            propertiesX.put("nome", nome);
                            propertiesX.put("email", email);
                            /*
                            propertiesX.put("id_planilha_google", id_planilha_google);
                            propertiesX.put("id_0_formulario", id_0_formulario);
                            propertiesX.put("id_1_formulario_email_de", id_1_formulario_email_de);
                            propertiesX.put("id_2_formulario_email_para", id_2_formulario_email_para);
                            propertiesX.put("id_3_formulario_mensagem", id_3_formulario_mensagem);
                            propertiesX.put("id_4_formulario_imagem", id_4_formulario_imagem);
                            propertiesX.put("id_planilha_google_status_de", id_planilha_google_status_de);
                            propertiesX.put("id_1_formulario_status_de", id_1_formulario_status_de);
                            propertiesX.put("id_1_formulario_status_email_de", id_1_formulario_status_email_de); 
                            */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
                            FileOutputStream out = new FileOutputStream( arquivoASerCriado );
                            propertiesX.storeToXML(out, "updated", "UTF-8"); 
                            out.flush();
                            out.close();
                       
                        } catch( Exception e ){ 
                            
                            Properties propertiesX = new Properties();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            propertiesX.put("nome", nome);
                            propertiesX.put("email", email);
                            /*
                            propertiesX.put("id_planilha_google", id_planilha_google);
                            propertiesX.put("id_0_formulario", id_0_formulario);
                            propertiesX.put("id_1_formulario_email_de", id_1_formulario_email_de);
                            propertiesX.put("id_2_formulario_email_para", id_2_formulario_email_para);
                            propertiesX.put("id_3_formulario_mensagem", id_3_formulario_mensagem);
                            propertiesX.put("id_4_formulario_imagem", id_4_formulario_imagem);
                            propertiesX.put("id_planilha_google_status_de", id_planilha_google_status_de);
                            propertiesX.put("id_1_formulario_status_de", id_1_formulario_status_de);
                            propertiesX.put("id_1_formulario_status_email_de", id_1_formulario_status_email_de); 
                            */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            FileOutputStream out = new FileOutputStream( arquivoASerCriado );
                            propertiesX.storeToXML(out, "updated", "UTF-8"); 
                            out.flush();
                            out.close();
                        }        
                    //}
                //}
            }                            
        } catch( Exception e ){  } //} }.start();   
    }
            
    private void JPOpcao_37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_37MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_37MouseEntered

    private void JPOpcao_37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_37MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_37MouseExited

    private void JPOpcao_37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_37MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_37MousePressed

    private void tf_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_emailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailMouseClicked

    private void tf_emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_emailMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailMouseEntered

    private void tf_emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_emailMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailMouseExited

    private void tf_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_emailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_emailKeyReleased

    private void JPOpcao_38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_38MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_38MouseEntered

    private void JPOpcao_38MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_38MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_38MouseExited

    private void JPOpcao_38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_38MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_38MousePressed

    private void jLabel91MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel91MousePressed

    private void JPOpcao_45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_45MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_45MouseEntered

    private void JPOpcao_45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_45MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_45MouseExited

    private void JPOpcao_45MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_45MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_45MousePressed

    private void tf_Senha1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_Senha1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Senha1MouseClicked

    private void tf_Senha1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_Senha1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Senha1MouseEntered

    private void tf_Senha1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_Senha1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Senha1MouseExited

    private void tf_Senha1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Senha1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Senha1KeyReleased

    private void JPOpcao_46MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_46MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_46MouseEntered

    private void JPOpcao_46MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_46MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_46MouseExited

    private void JPOpcao_46MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_46MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_46MousePressed

    private void JPOpcao_47MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_47MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_47MouseEntered

    private void JPOpcao_47MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_47MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_47MouseExited

    private void JPOpcao_47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_47MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_47MousePressed

    private void tf_Senha2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_Senha2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Senha2MouseClicked

    private void tf_Senha2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_Senha2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Senha2MouseEntered

    private void tf_Senha2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_Senha2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Senha2MouseExited

    private void tf_Senha2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Senha2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Senha2KeyReleased

    private void JPOpcao_48MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_48MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_48MouseEntered

    private void JPOpcao_48MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_48MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_48MouseExited

    private void JPOpcao_48MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_48MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_48MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPOpcao_35;
    private javax.swing.JPanel JPOpcao_37;
    private javax.swing.JPanel JPOpcao_38;
    private javax.swing.JPanel JPOpcao_45;
    private javax.swing.JPanel JPOpcao_46;
    private javax.swing.JPanel JPOpcao_47;
    private javax.swing.JPanel JPOpcao_48;
    private javax.swing.JPanel Pergunta;
    private javax.swing.JButton btSalvar1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel jp5;
    private javax.swing.JPanel jp6;
    private javax.swing.JPanel jpDados;
    public javax.swing.JTabbedPane tabPessoas;
    public javax.swing.JTextField tf_Senha1;
    public javax.swing.JTextField tf_Senha2;
    public javax.swing.JTextField tf_email;
    // End of variables declaration//GEN-END:variables
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public void alterar_nome_JTabbedPane_chegou_mensagem(String nome_verdadeiro_do_tab_procurado, int quantidade_de_mensagem, ImageIcon iconX) { /*new Thread() {   @Override public void run() {*/ try { 
        //void setSelectedComponent(Component c) 
        //void setSelectedIndex(int index) 
        //table.setFillsViewportHeight(true);
                
        if( nome_verdadeiro_do_tab_selecionado.equals( nome_verdadeiro_do_tab_procurado ) ){
                        
            //System.out.println("if = " + "Nome Tab Selecionado: " + nome_verdadeiro_do_tab_selecionado + " - Nome Tab procurado: " + nome_verdadeiro_do_tab_procurado);
            for (int i = 0; i < tabPessoas.getTabCount(); i++){
                
                String nometabX = "";
                String nometab = ""; 
                try{
                    nometab = tabPessoas.getTitleAt( i ).trim();
                    //System.out.println("if = " + "nome_verdadeiro_do_tab_procurado: " + nome_verdadeiro_do_tab_procurado + " - tabPessoas.getTitleAt( i ).trim(): " + nometab);
                    
                    if( nometab.contains("-") ){
                        String[] doisnomes = nometab.split("-");
                        nometabX = doisnomes[0].trim();                         
                    }
                    else{
                        nometabX = nometab;
                        //System.out.println("if = " + "nome_verdadeiro_do_tab_procurado: " + nome_verdadeiro_do_tab_procurado + " - nometabX: " + nometabX);
                    }
                } catch( Exception e ){ }
                                                                                
                if( nometabX.equals( nome_verdadeiro_do_tab_procurado ) ){
                    
                    //System.out.println( "if Tab encontrado -- nometab: " + nometab );
                    
                    tabPessoas.setTitleAt( i, "  " + nome_verdadeiro_do_tab_procurado + " - " + quantidade_de_mensagem );
                    
                    tabPessoas.setTabComponentAt( i, new ButtonTabComponent( tabPessoas, "  " + nome_verdadeiro_do_tab_procurado + " - " + quantidade_de_mensagem, iconX, Home ) ); 
                    break;
                }
            }
        }
        else{
            
            //System.out.println("else = " + "Nome Tab Selecionado: " + nome_verdadeiro_do_tab_selecionado + " - Nome Tab procurado: " + nome_verdadeiro_do_tab_procurado);
            for (int i = 0; i < tabPessoas.getTabCount(); i++){
                
                String nometabX = "";
                String nometab = ""; 
                try{
                    nometab = tabPessoas.getTitleAt( i ).trim();
                    //System.out.println("if = " + "nome_verdadeiro_do_tab_procurado: " + nome_verdadeiro_do_tab_procurado + " - tabPessoas.getTitleAt( i ).trim(): " + nometab);
                    
                    if( nometab.contains("-") ){
                        String[] doisnomes = nometab.split("-");
                        nometabX = doisnomes[0].trim();                            
                    }
                    else{
                        nometabX = nometab;
                        //System.out.println("if = " + "nome_verdadeiro_do_tab_procurado: " + nome_verdadeiro_do_tab_procurado + " - nometabX: " + nometabX);
                    }
                } catch( Exception e ){ }
                                                                                
                if( nometabX.equals( nome_verdadeiro_do_tab_procurado ) ){
                    
                    //System.out.println( "if Tab encontrado -- nometab: " + nometab );
                    
                    tabPessoas.setTitleAt( i, "  " + nome_verdadeiro_do_tab_procurado + " - " + quantidade_de_mensagem );
                    
                    tabPessoas.setTabComponentAt( i, new ButtonTabComponent( tabPessoas, "  " + nome_verdadeiro_do_tab_procurado + " - " + quantidade_de_mensagem, iconX, Home ) ); 
                    break;
                }
            }
        }
    } catch( Exception e ){ } /*} }.start();*/ }
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public void alterar_nome_JTabbedPane_leu_mensagem( String nome_verdadeiro_do_tab_procurado, Email_Mensagens_Por_Contato Email_Mensagens_Por_Contato, ImageIcon iconX ) { /*new Thread() {   @Override public void run() {*/ try { 
        
        String nometab_selecionado_que_leu_a_mensagem = ""; 
        if( nome_verdadeiro_do_tab_selecionado.contains("-") ){
    
            String[] doisnomes = nome_verdadeiro_do_tab_selecionado.split("-");
            nometab_selecionado_que_leu_a_mensagem = doisnomes[0].trim();  
        }  
        else{
            
            nometab_selecionado_que_leu_a_mensagem = nome_verdadeiro_do_tab_selecionado.trim();
        }
        
        if( nometab_selecionado_que_leu_a_mensagem.equals( nome_verdadeiro_do_tab_procurado ) ){
                        
            //System.out.println("if = " + "Nome Tab Selecionado: " + nome_verdadeiro_do_tab_selecionado + " - Nome Tab procurado: " + nome_verdadeiro_do_tab_procurado);
            for (int i = 0; i < tabPessoas.getTabCount(); i++){
                
                String nometabX = "";
                String nometab = ""; 
                try{
                    nometab = tabPessoas.getTitleAt( i ).trim();
                    //System.out.println("if = " + "nome_verdadeiro_do_tab_procurado: " + nome_verdadeiro_do_tab_procurado + " - tabPessoas.getTitleAt( i ).trim(): " + nometab);
                    
                    if( nometab.contains("-") ){
                        String[] doisnomes = nometab.split("-");
                        nometabX = doisnomes[0].trim();                         
                    }
                    else{
                        nometabX = nometab;
                        //System.out.println("if = " + "nome_verdadeiro_do_tab_procurado: " + nome_verdadeiro_do_tab_procurado + " - nometabX: " + nometabX);
                    }
                } catch( Exception e ){ }
                                                                                
                if( nometabX.equals( nome_verdadeiro_do_tab_procurado ) ){
                    
                    //System.out.println( "if Tab encontrado -- nometab: " + nometab );
                    
                    tabPessoas.setTitleAt( i, "     " + nome_verdadeiro_do_tab_procurado + "       "   );
                    
                    tabPessoas.setTabComponentAt( i, new ButtonTabComponent( tabPessoas, "     " + nome_verdadeiro_do_tab_procurado + "       ", iconX, Home ) ); 
                    Email_Mensagens_Por_Contato.quantidade_de_mensagem = 0;
                    break;
                }
            }
        }
    } catch( Exception e ){ } /*} }.start();*/ }
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public void alterar_nome_JTabbedPane_Status_online(String nome_verdadeiro_do_tab_procurado, ImageIcon iconX) { /*new Thread() {   @Override public void run() {*/ try { 
        
        //System.out.println("else = " + "Nome Tab Selecionado: " + nome_verdadeiro_do_tab_selecionado + " - Nome Tab procurado: " + nome_verdadeiro_do_tab_procurado);
            for (int i = 0; i < tabPessoas.getTabCount(); i++){
                
                String nometabX = "";
                String nometabOriginal = ""; 
                try{
                    nometabOriginal = tabPessoas.getTitleAt( i ).trim();
                    //System.out.println("if = " + "nome_verdadeiro_do_tab_procurado: " + nome_verdadeiro_do_tab_procurado + " - tabPessoas.getTitleAt( i ).trim(): " + nometab);
                    
                    if( nometabOriginal.contains("-") ){
                        String[] doisnomes = nometabOriginal.split("-");
                        nometabX = doisnomes[0].trim();                            
                    }
                    else{
                        nometabX = nometabOriginal;
                        //System.out.println("if = " + "nome_verdadeiro_do_tab_procurado: " + nome_verdadeiro_do_tab_procurado + " - nometabX: " + nometabX);
                    }
                } catch( Exception e ){ }
                                                                                
                if( nometabX.equals( nome_verdadeiro_do_tab_procurado ) ){
                    
                    //System.out.println( "if Tab encontrado -- nometab: " + nometab );
                    
                    tabPessoas.setTitleAt( i, "     " + nometabOriginal + "       " );
                    
                    tabPessoas.setTabComponentAt( i, new ButtonTabComponent( tabPessoas, "     " + nometabOriginal + "       ", iconX, Home ) ); 
                    break;
                }
            }
            
    } catch( Exception e ){ } /*} }.start();*/ }
////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
    public String google_nome_da_pasta_root = "Turbo_Flyer_Google";
    public String google_id_da_pasta_root = null;
    private void _1_google_inicial(){
        try {  
            
            if( Google.verificar_se_uma_pasta_existe_no_root( google_nome_da_pasta_root ) == true ){
                
                google_id_da_pasta_root = Google.verificar_se_uma_pasta_existe_no_root_e_pegar_sua_id( google_nome_da_pasta_root );
            }
            else{
                
                google_id_da_pasta_root = Google.criar_uma_pasta_no_root( google_nome_da_pasta_root );
            }
            
            //APÓS LOGIN NO GOOGLE
            _2_google_inicial();

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    public String google_nome_da_pasta_deste_remetente = null;
    public String google_id_da_pasta_deste_remetente = null;
    public void _2_google_inicial(){
        try {  
            
            String email_Usuario_Logado = ""; 
            try{ email_Usuario_Logado = Login.Usuario_Logado.getEmailRecuperacao().trim().toUpperCase(); }catch( Exception e ){}            
            if( !email_Usuario_Logado.equals("") ){
                
                //String arquivo_properties = email_Usuario_Logado.trim().toUpperCase().replace("@", "___");
                //google_nome_da_pasta_deste_usuario = arquivo_properties.trim().toUpperCase().replace(".", "__");
                google_nome_da_pasta_deste_remetente = email_Usuario_Logado;
            }
            
            if( Google.verificar_se_uma_pasta_existe_dentro_de_outra(google_id_da_pasta_root, google_nome_da_pasta_deste_remetente ) == true ){
                
                google_id_da_pasta_deste_remetente = Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(google_id_da_pasta_root, google_nome_da_pasta_deste_remetente );
            }
            else{
                
                google_id_da_pasta_deste_remetente = Google.criar_uma_pasta_dentro_de_outra_pasta(google_id_da_pasta_root, google_nome_da_pasta_deste_remetente );
            }
            
            _3_google_inicial();

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    public void _3_google_inicial(){
        try {  
            
            System.out.println( google_nome_da_pasta_root + " - " + google_nome_da_pasta_root + " - google_id_da_pasta_root - " + google_id_da_pasta_root );
            System.out.println(google_nome_da_pasta_deste_remetente + " - " + google_nome_da_pasta_deste_remetente + " - google_id_da_pasta_deste_usuario - " + google_id_da_pasta_deste_remetente );
            
            _4_google_inicial();
                    
        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    public String google_nome_da_pasta_deste_remetente_mensagens_recebidas = "MENSAGENS_RECEBIDAS";
    public String google_id_da_pasta_deste_remetente_mensagens_recebidas = null;
    public void _4_google_inicial(){
        try {  
            
            if( Google.verificar_se_uma_pasta_existe_dentro_de_outra(google_id_da_pasta_deste_remetente, google_nome_da_pasta_deste_remetente_mensagens_recebidas ) == true ){
                
                google_id_da_pasta_deste_remetente_mensagens_recebidas = Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(google_id_da_pasta_deste_remetente, google_nome_da_pasta_deste_remetente_mensagens_recebidas );
            }
            else{
                
                google_id_da_pasta_deste_remetente_mensagens_recebidas = Google.criar_uma_pasta_dentro_de_outra_pasta(google_id_da_pasta_deste_remetente, google_nome_da_pasta_deste_remetente_mensagens_recebidas );
            }
            
            _5_google_inicial();

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    public String google_nome_da_pasta_deste_remetente_status = "STATUS";
    public String google_id_da_pasta_deste_remetente_status = null;
    public void _5_google_inicial(){
        try {  
            
            if( Google.verificar_se_uma_pasta_existe_dentro_de_outra(google_id_da_pasta_deste_remetente, google_nome_da_pasta_deste_remetente_status ) == true ){
                
                google_id_da_pasta_deste_remetente_status = Google.verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(google_id_da_pasta_deste_remetente, google_nome_da_pasta_deste_remetente_status );
            }
            else{
                
                google_id_da_pasta_deste_remetente_status = Google.criar_uma_pasta_dentro_de_outra_pasta(google_id_da_pasta_deste_remetente, google_nome_da_pasta_deste_remetente_status );
            }
            
            new Thread() {   @Override public void run() { try { 

                try { 
                    String arquivoASerCriado = System.getProperty("user.dir") + "\\00_Externo\\STATUS";
                    Arquivo_Ou_Pasta.deletar_Todos_Arquivos_da_Pasta( new File( arquivoASerCriado ) );
                } catch( Exception e ){ }
                
                try { _6_google_inicial(); } catch( Exception e ){ }            
            } catch( Exception e ){ } } }.start();

        } catch( Exception e ){ e.printStackTrace();  } //} }.start();
    }
    
    public void _6_google_inicial(){ //System.out.println( "public void ler_mensagem(){" );       
        /*new Thread() {   @Override public void run() {*/   
            
        do{             
            
            try {
                String id = null;     
                com.google.api.services.drive.model.File updatedFile = null;
            
                Thread.sleep( 2000 );
                
                Drive driveService = GoogleDriveUtils.getDriveService();
                try {
                                       
                    List<com.google.api.services.drive.model.File> list = new ArrayList<com.google.api.services.drive.model.File>();
                    list = GetSubFolders.getGoogleSubFile( google_id_da_pasta_deste_remetente_status );
                    
                    for (com.google.api.services.drive.model.File file : list) {
                        
                        //System.out.println("Arquivo Deletado: " + file.getName() + " - " + file.getId() );               
                        id = file.getId();
                        updatedFile = file;
                        driveService.files().delete( file.getId() ).execute();                      
                    }
                } catch (Exception ex) {}
                
                String arquivoASerCriado = "";
                String dataCadastro = "";
                try {
                   ////////dd.MM.yyyy HH:mm:ss/////////////EEEE, d MMMM yyyy HH:mm:ss
                    Calendar calendar = Calendar.getInstance();
                    java.util.Date now = calendar.getTime();
                    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

                    DateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    try{ dataCadastro = dfmt.format(currentTimestamp);  }catch(Exception e){}
                    ////////dd.MM.yyyy HH:mm:ss/////////////EEEE, d MMMM yyyy HH:mm:ss
                } catch (Exception ex) {}
                
                String data = dataCadastro.trim().toUpperCase().replace("/", "__");
                String minuto = data.trim().toUpperCase().replace(":", "_");
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\", "00_Externo" );  
                Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.dir") + "\\00_Externo", "STATUS" );
                
                arquivoASerCriado = System.getProperty("user.dir") + "\\00_Externo\\STATUS\\" + minuto + ".txt";
                
                File file_x = Arquivo_Ou_Pasta.criar_Arquivo_Iso_Boo_Tipo_UTFISO_Ret_F( arquivoASerCriado, minuto, "UTF-8" );
                
                if( id == null ){
                    com.google.api.services.drive.model.File googleFile = createGoogleFile(
                            google_id_da_pasta_deste_remetente_status, "text/plain", minuto + ".txt", file_x);
                    
                    //System.out.println("Arquivo Criado: " + googleFile.getName() + " - " + googleFile.getId() );  
                }
                else{
                                        
                    com.google.api.services.drive.model.File updatedFileX = driveService.files().update(id, updatedFile).execute();
                    //System.out.println("Arquivo Atualizado: " + updatedFileX.getName() + " - " + updatedFileX.getId() );  
                }
                /*
                System.out.println("Created Google file!");
                System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
                System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
 
                System.out.println("Done!");
                */
            } catch (Exception e) { 
                //System.out.println( "public void full_ler_mensagem_bot(){ - ERRO - \n" + e.getMessage() );    
                //e.printStackTrace(); 
            } finally {}     
        }while( true );
    }
    
    String responsta = "";
    public void verificar_se_esta_online(){ //System.out.println( "public void ler_mensagem(){" );       
        /*new Thread() {   @Override public void run() {*/   
            
        do{ 
            try {

                Thread.sleep( 10000 );
                try{ 
                    String USER_AGENT = "Mozilla/5.0";
                    String GET_URL = "https://sheets.googleapis.com/v4/spreadsheets/1Xg_DN-bpMxV-enFFWEkHN5i1gFsZheAFdleayvIg4HU/values/A:F?key=AIzaSyBwiMCywJRFQHuuksWdhqwjOrR5mDaWJYs";
                
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
                        responsta = response.toString();
                        
                        try {  } catch( Exception e ){ } 
                    }
                    
                } catch( Exception e ){ 
                    
                    //lbStatus.setText( "VOCÊ ESTÁ OFFLINE" );
                    //System.out.println("NÃO CONECTADO - String GET_URL = id_planilha_google; - " + e.getMessage());
                } 

            } catch (Exception e) { 
                //System.out.println( "public void full_ler_mensagem_bot(){ - ERRO - \n" + e.getMessage() );    
                //e.printStackTrace(); 
            } finally {}     
        }while( true );
    }
    
}