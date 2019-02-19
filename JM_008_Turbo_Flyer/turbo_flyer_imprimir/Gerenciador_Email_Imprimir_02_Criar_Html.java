/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbo_flyer_imprimir;

import br.com.jmary.utilidades.Arquivo_Ou_Pasta;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import turbo_flyer_excel.Gerenciador_Email_Excel_Modelo;

/**
 *
 * @author Ana
 */
public class Gerenciador_Email_Imprimir_02_Criar_Html { 
    
    int x = 1;
    int y = 1;
    
    private String arq_html = "";
    
    String arq   = System.getProperty("user.home") + "\\" + "JMarySystems_Print";
    String arqPS = "JMarySystems_PrintPS_";
    String pasta_temp = "";
    
    String pagina = "";
    File retorno; 
    
    int numeroPagina = 0;
        
    public Gerenciador_Email_Imprimir_02_Criar_Html( String pagina2, int qtdLinha2, int numeroPagina2, int qtd_linhas_por_pg ) {  
        
        pagina       = pagina2;    
        numeroPagina = numeroPagina2;
        dataHoje();
        qtsPagias(qtdLinha2, qtd_linhas_por_pg);
        htmlInicio();
        dadosDaLoja();        
    }
    
    public File getFile() {  
    
       synchronized(this) {  
           
           verificar_se_arq_existe(); 
       }    
       // Agora o diretório está vazio, restando apenas deletá-lo.  
       return retorno;  
    } 
    
    public void verificar_se_arq_existe(){  
        synchronized(this) {  
            if ( new File( arq ).exists() == false ) { x++;
    
                if ( Arquivo_Ou_Pasta.criarPasta( System.getProperty("user.home"), "JMarySystems_Print" ) == true ) {
                    
                    synchronized(this) {
                        
                        verificar_se_arqPS_existe();
                    }
                }
                else{
                    
                    verificar_se_arq_existe();
                }
            }    
            else{
                
                synchronized(this) {
                    
                    verificar_se_arqPS_existe();
                }
            }
        }  
    }
    
    public void verificar_se_arqPS_existe(){  
        synchronized(this){  
            
            pasta_temp = arqPS + y;
            
            synchronized(this) {
                
                if ( new File( arq + "\\" + pasta_temp ).exists() == false ) { 
                    
                    if ( Arquivo_Ou_Pasta.criarPasta( arq, pasta_temp ) == true ) {
                    
                        synchronized(this) {
                        
                            verificar_se_arq_html_existe();
                        }
                    }
                    else{
                    
                        verificar_se_arqPS_existe();
                    }               
                }    
                else{ 
                
                    y++;                
                    verificar_se_arqPS_existe();
                }   
            }
        }  
    } 
    
    public void verificar_se_arq_html_existe(){  
        synchronized(this) {  
                    
            arq_html = arq + "\\" + pasta_temp + "\\" + "z" + x + ".html";
            
            synchronized(this) {
                
                if ( new File( arq_html ).exists() == false ) { 
                    
                    String arquivoASerC = html_inicio + dadosDaLoja + pagina + html_fim;
    
                    if ( Arquivo_Ou_Pasta.criar_Arquivo_Iso_Boo( arq_html, arquivoASerC ) == true ) {
                    
                        synchronized(this) {
                         
                            retorno = new File( arq_html );
                            
                            System.out.println(arquivoASerC);
                        }
                    }
                    else{
                    
                        verificar_se_arq_html_existe();
                    }                
                }    
                else{ 
                
                    x++;                
                    verificar_se_arq_html_existe();
                }   
            }
        }  
    } 
    
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
    String        dataHoje;
    String        html_inicio;
    String        dadosDaLoja;
    int           qtdPaginas = 0;
    String        html_fim         = "</body> </html>";
    
    private void dataHoje(){  
        synchronized ( this ) { try{
                
            GregorianCalendar gc       = new GregorianCalendar();
            Date dataHojeC             = gc.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            dataHoje                   = formatter.format( dataHojeC );      
        } catch( Exception e){} }
    }
    
    private void htmlInicio(){
        synchronized ( this ){ try{ StringBuilder sb = new StringBuilder();
        
            Class<Gerenciador_Email_Excel_Modelo> clazz_Entrada_Excel = Gerenciador_Email_Excel_Modelo.class;

            try{ 
                sb.append( 
                        "<html>" 
                        + "<head> <title> HOME </title>"
                        + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
                );
            } catch( Exception e ){}
            /*
            try{ 
                sb.append( 
                        "<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\""+ clazz_Entrada_Excel.getResource("estrutura.css") +"\" />"
                );
            } catch( Exception e ){}  
            */
            try{ 
                sb.append( 
                    "</head>"
                    + "<body "
                        + "style=\" "
                            + "width: 100%; height: 100%;"
                            + "padding-left:  0px;\n"  +
                              "padding-right: 0px;\n"  +
                              "padding-top:   0px;\n"  +
                              "padding-bottom:0px;\n"  +
                            
                              "margin-left:   0px;\n" +
                              "margin-right:  0px;\n"  +
                              "margin-top:    0px;\n"  +
                              "margin-bottom: 5px; "
                        + "font-family: Arial, Helvetica, sans-serif; font-size: 10px; color: black; "
                        + "line-height: 0.5;"
                        +"\""    
                    + ">"    
                );
            } catch( Exception e ){} 
            
            html_inicio = sb.toString();
            
        } catch( Exception e ){} }  
    }
    
    private void dadosDaLoja(){
        
        /*GESTOR DE COMPRAS - GBARBOSA - PRESIDENTE KENNEDY - B141
            List<Estabelecimento> XXGbdescricaosetor = null;
            String enderecoLoja="";
            try {                
                
                try{ 
                    DAOGenericoJPA DAOGenericoJPAXX = new DAOGenericoJPA(Estabelecimento.class, JPAUtil.em());
                                        
                    XXGbdescricaosetor = (List<Estabelecimento>) DAOGenericoJPAXX.getBeansCom_1_Parametro(Estabelecimento.class, 
                            "SELECT * FROM SCHEMAJMARY.ESTABELECIMENTO WHERE NOME_FANTASIA = ?", "B141" );
                }catch( Exception e ){ }
                
                String rbusca = ""; try{ rbusca = XXGbdescricaosetor.get(0).getNomeFantasia(); }catch( Exception e ){}
                
                if( !rbusca.equals("") ){                    
                    enderecoLoja = XXGbdescricaosetor.get(0).getRazaoSocial();
                }
                
            }catch( Exception e ){}
            GESTOR DE COMPRAS - GBARBOSA - PRESIDENTE KENNEDY - B141*/
        
        Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
        
        synchronized ( this ){ try{ StringBuilder sb = new StringBuilder();
            sb.append(                    
                    "<table WIDTH=100% style=\"padding: 0; margin: 0;\" >"
                    
                        + "<tr>"
                    
                            + "<td>"
                    
                                +"<img src='" + clazzHome.getResource("logocangaco2.png").toString() + "'" + " width=\"84\" height=\"55\" border=\"0\" ALIGN=BOTTOM title=\"JMARY\" >"                                            
                    
                            + "</td>"
                    
                            + "<td style=\"font-size: 14px;\" >"

                                + "<b>&nbsp;&nbsp;&nbsp;&nbsp;"+ "RELATÓRIO:&nbsp;USUÁRIOS&nbsp;DO&nbsp;SISTEMA" +"</b>"                                          
                    
                            + "</td>"
                    
                            + "<td align='right' >"
                                
                                +"<div>"
                                    +"<table>"
                                        +"<tbody>"
                                            +"<tr>"
                                                +"<td align='center' style=\"font-size: 10px;\" >"
                                                    + "" +  dataHoje +"<hr noshade=\"noshade\" size=\"1\">" + "<b>&nbsp;&nbsp;&nbsp;" +  "Pag. "+ numeroPagina + " / " + qtdPaginas + "</b>" 
                                                + "</td>"
                                            +"</tr>"
                                        +"</tbody>"
                                    +"</table>"
                                +"</div>"
                    
                            + "</td>"
                    
                        + "</tr>"
                    
                    + "</table>"
                    
                    + "<HR SIZE=1 WIDTH=100% NOSHADE >" +
                    
                    "<table style=\"padding: 0; margin: 0;\" >"
                    
                        + "<tr>"
                    
                            + "<td style=\"font-size: 10px;\" >"
                                  +"&nbsp;&nbsp;&nbsp;<b> RAZÃO&nbsp;SOCIAL/NOME&nbsp;FANTASIA: </b>&nbsp;JMarySystems&nbsp;Informática" 
                            + "</td>"
                    
                            + "<td style=\"font-size: 10px;\" >"                                
                                + "&nbsp;" + ""                    
                            + "</td>"
                    
                        + "</tr>"
                                                                
                    + "</table>" +
                    
                    "<HR SIZE=1 WIDTH=100% NOSHADE >" 
            );
            
            dadosDaLoja = sb.toString();
            
        } catch( Exception e ){} }
    }
    
    private void qtsPagias(int qtdLinha2, int qtd_linhas_por_pg2){
        synchronized ( this ){ try{ 
            
            int count = 0;
            
            if( qtdLinha2 > 0 ){  
                for( int L_i=0; L_i < qtdLinha2; L_i++ ){ count++;
                
                    int td = qtdLinha2 - 1;
                    if( count == qtd_linhas_por_pg2 || L_i == td ){
                        count = 0;
                        
                        qtdPaginas++;  
                        //System.out.println( "qtdPaginas: "+qtdPaginas +" - qtdLinhas: "+qtdLinha2 );
                    }
                }
            }
        } catch( Exception e ){} }  
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /******************Executar Teste*************************************  
     * @param args************************
    public static void main(String[] args) {            
          
        ControleThread_Print t1 = new ControleThread_Print(13); 
        
        t1.setName("ControleThread_Print");   
        
        t1.start();  
    }
    /******************Executar Teste*************************************/
    
}
