/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbo_flyer_imprimir;

import br.com.jmary.utilidades.JOPM;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Ana
 */
public class Gerenciador_Email_Imprimir_01_Controle extends Thread { 
    
    public JTable tbPesquisa;
    List<File> lista_Arquivos = new ArrayList();
    
    int qtd_linhas_por_pg = 18;
            
    public Gerenciador_Email_Imprimir_01_Controle( JTable tbPesquisa2 ){   
        tbPesquisa = tbPesquisa2;
    } 
                
    @Override
    public void run(){  
        synchronized ( this ) {
                        
            htmlMeio();    
        }  
    }  
    
    private void htmlMeio(){    synchronized ( this ){ try{ 
                        
        int count = 0;
        
        String        inicioTabela    = "<DIV align=\"center\"><CENTER>" + "<table width='100%' border=\"1\">";
        StringBuilder cabecalholinhas = new StringBuilder();
        StringBuilder linhas          = new StringBuilder();
        String        fimTabela       = "</table>" + "</CENTER></DIV>";
        String        pagina          = "";
        int           numeroPagina    = 0;
                
        if( tbPesquisa.getModel().getRowCount() > 0 ){  
        
            cabecalholinhas.append( "<tr>" );
            for( int L_i=0; L_i < tbPesquisa.getRowCount(); L_i++ ){ count++;
                
                for( int C_i=0; C_i <tbPesquisa.getColumnCount(); C_i++ ){
                    
                    String str = tbPesquisa.getColumnName(C_i);
                    if(str.trim().equals("ACESSO AO SISTEMA")){
                        str = "ACESSO";
                    }
                    else if( str.trim().equals("DATA CADASTRO") ){
                        str = "CADASTRO";
                    }
                    else if( str.trim().equals("DATA ÚLTIMA ALTERACAO") ){
                        str = "ALTERAÇÃO";
                    }
                    else if( str.trim().equals("DATA ULTIMA ALTERACAO SENHA") ){
                        str = "ULT. ALT.";
                    }
                    else if( str.trim().equals("USUÁRIO QUE CADASTROU") ){
                        str = "US. CAD.";
                    }
                    else if( str.trim().equals("ULTIMO USUÁRIO QUE ALTEROU") ){
                        str = "US. ALT.";
                    }
                    else if( str.trim().equals("CÓDIGOAUX") ){
                        str = "CÓDIGO AUX.";
                    }
                    
                    cabecalholinhas.append( "<td align='center' style=\"font-size: 10px;\" >" + "<b>" + str  + "<b>" + "</td>" );                     
                }
                break;
            }
            cabecalholinhas.append( "</tr>" );
            
            
        }             

        if( tbPesquisa.getModel().getRowCount() > 0 ){           
            for( int L_i=0; L_i < tbPesquisa.getModel().getRowCount(); L_i++ ){ count++;
                
                linhas.append( "<tr>" );
                for( int C_i=0; C_i < tbPesquisa.getColumnCount(); C_i++ ){
                    
                    String str = String.valueOf( tbPesquisa.getValueAt(L_i, C_i) );
                    if( str.equals("null") ){ str=""; }
                    
                    String strn = tbPesquisa.getColumnName(C_i);
                    
                    if( strn.trim().equals("LOGIN") ){
                        
                        linhas.append( "<td align='left' NOWRAP='NOWRAP' style=\"font-size: 10px;\"  >" + str  + "</td>" );
                    }
                    else if( strn.trim().equals("CADASTRO") ){
                        
                    }
                    else if( strn.trim().equals("EMAIL") ){
                        
                        linhas.append( "<td align='left'  NOWRAP='NOWRAP' style=\"font-size: 10px;\" >" + str  + "</td>" );                        
                    }
                    else{
                        
                        linhas.append( "<td align='center'  NOWRAP='NOWRAP' style=\"font-size: 10px;\" >" + str  + "</td>" );                        
                    }
                } 
                linhas.append( "</tr>" );
                
                int td = tbPesquisa.getModel().getRowCount() - 1;
                if( count == qtd_linhas_por_pg || L_i == td ){
                    numeroPagina++;
                    String cabecalho_todas_as_linhas = cabecalholinhas.toString();
                    String todas_as_linhas = linhas.toString();
                    
                    count = 0;
                    linhas      = new StringBuilder();
                    
                    pagina = inicioTabela + cabecalho_todas_as_linhas + todas_as_linhas + fimTabela;
                    
                    try { Thread.sleep( 15 ); } catch( Exception e ){}  
                    int qtdLinhas = tbPesquisa.getModel().getRowCount();
                    Gerenciador_Email_Imprimir_02_Criar_Html Criar_Arquivo_retornando = new Gerenciador_Email_Imprimir_02_Criar_Html( pagina, qtdLinhas, numeroPagina, qtd_linhas_por_pg );
                    
                    File f = Criar_Arquivo_retornando.getFile();
                    System.out.println( f.toURI().toURL() +" - "+qtdLinhas );
                    try { Thread.sleep( 15 ); } catch( Exception e ){}
                    
                    lista_Arquivos.add( f );
                }
            }
        }
        
        ////////////////////////////////////////////////////////////////////////
        new Thread() {   @Override public void run() { try { Thread.sleep( 1 );
                    
                    Gerenciador_Email_Imprimir_03_Imprimindo t1 = new Gerenciador_Email_Imprimir_03_Imprimindo( lista_Arquivos );
                    t1.setName("O3_Imprimir_Aquivos_Html");
                    t1.start();                   
                } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "eventoBotaoImprimir(), \n" + e.getMessage() + "\n", this.getClass().getSimpleName() ); } } }.start();
        ////////////////////////////////////////////////////////////////////////
            
        } catch( Exception e ){} }        
    }
                                            
    /******************Executar Teste*************************************  
     * @param args************************
    public static void main(String[] args) {            
          
        ControleThread_Print t1 = new ControleThread_Print(13); 
        
        t1.setName("ControleThread_Print");   
        
        t1.start();  
    }
    /******************Executar Teste*************************************/
    
}