/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turbo_flyer_imprimir;

import br.com.jmary.utilidades.JOPM;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.List;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrintQuality;
import javax.print.attribute.standard.Sides;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author Ana
 */
public class Gerenciador_Email_Imprimir_03_Imprimindo extends Thread { 
    
    List<File> lista_Arquivos;
    
    int count = 0;
    
    //////////////////////////////////
    PrinterJob  PrinterJob = null;
    JEditorPane htmlPanePrincipal = new JEditorPane();
    /////////////////////////////////
    
    public Gerenciador_Email_Imprimir_03_Imprimindo( List<File> lista_Arquivos2  ){   
        lista_Arquivos = lista_Arquivos2;

    } 

    @Override
    public void run(){  
        synchronized ( this ) {
            
            impressora();  
        }  
    }  
    
    public void impressora(){  
        synchronized(this) { 
            
            Gerenciador_Email_Imprimir_04_Impressora Impressora = new Gerenciador_Email_Imprimir_04_Impressora( "" );
            
            PrinterJob = Impressora.Impressora();
            
            if ( PrinterJob != null ) { 
                
                synchronized(this) {
                    
                    setar_PrinterJob();
                }
            } 
        }  
    }
    
    public void setar_PrinterJob(){  
        synchronized(this) { 
            
            synchronized(this) {
                                
                PrinterJob.setCopies( 1 );
            }
            
            synchronized(this) {
                
                setar_JEditorPane();
            }
        }  
    }
    
    public void setar_JEditorPane(){  
        synchronized(this) { 
            
            htmlPanePrincipal.setEditorKit(new HTMLEditorKit());            
            htmlPanePrincipal.setContentType("text/html;charset=UTF-8");
            
            int tmHorizontal = 837; int tmVertical = 555;
            htmlPanePrincipal.setSize( tmHorizontal, tmVertical ); 
            
            try { 
            do{    
                
                PrinterJob.setJobName( "JM - " + count  ); 
                synchronized(this) {
                
                    synchronized(this) {
                                             
                        try{ htmlPanePrincipal.setPage( lista_Arquivos.get( count ).toURI().toURL() ); } catch( Exception e ){ e.printStackTrace(); }
                        Thread.sleep( 100 );
                    }
                
                    synchronized(this) {
                    
                        Thread.sleep( 100 );
                        gerar_PS();
                    }
                }
                
                try { Thread.sleep( 5000 ); } catch( Exception e ){}
                count+=1;
                
            }while(count < lista_Arquivos.size());            
            } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "setar_JEditorPane(), \n"+ e.getMessage() + "\n", this.getClass().getSimpleName() ); }
            
        }  
    }
    
    public void gerar_PS(){ 
        synchronized(this) { 
                
            //Imprimir SetConf = new Imprimir( PrinterJob, htmlPanePrincipal, lista_Arquivos.get(0).getName() ); 
            PropriedadesDaImpressão(); 
            try { Thread.sleep( 300 ); } catch( Exception e ){}
            imprimirComPropriedadesEConfigurações(); 
            //TestPreview TestPreview = new TestPreview(htmlPanePrincipal);
        }  
    }
    
    protected void PropriedadesDaImpressão() {
        try{               
            numeroDeCopias =  1;        
            lados = Sides.ONE_SIDED;
            cor = Chromaticity.COLOR;
            nomeDoUsuario = "JMary - Systems, jmarysystems@gmail.com";
            papel = MediaSizeName.ISO_A4;                                 
            //impressora = "Doro PDF Writer";        
            perguntarQualImpressora = false;
            orientacaoDoPapel = OrientationRequested.LANDSCAPE;             
        
            tamanhoPapelHorizontal = 842;
            tamanhoPapelVertical = 595;        
            margemSuperior = 20;
            margemEsquerda = 10;
            tmPapelMenosMargemDireita = tamanhoPapelHorizontal - 5; 
            tmPapelMenosMargemInferior = tamanhoPapelVertical - 20;
       
            //jeditorPane.setContentType( "text/html;charset=UTF-8" );
            //jeditorPane.setEditable(false);
            //int tmHorizontal = (int) tmPapelMenosMargemDireita; int tmVertical = (int) tmPapelMenosMargemInferior;
            //jeditorPane.setSize( tmHorizontal, tmVertical );      
            //url = jeditorPane.getPage();            
        } catch( Exception e ) { }
    }
        
    public void imprimirComPropriedadesEConfigurações() { 
        /*
        javax.print.attribute.HashPrintRequestAttributeSet aset = new javax.print.attribute.HashPrintRequestAttributeSet();
        //aset.add(new Destination(new java.net.URI("file:e:/temp/out.ps")));
        //aset.add(new MediaPrintableArea(xmargin, ymargin, w - 2*xmargin, h - 2*ymargin, MediaPrintableArea.INCH));
        aset.add( MediaSizeName.ISO_A4 ); 
        aset.add( OrientationRequested.LANDSCAPE ); 
        aset.add( Chromaticity.COLOR ); 
        aset.add( Sides.ONE_SIDED ); 
        aset.add( PrintQuality.NORMAL ); 
    
        Printable pTable = new Print( tp, PrinterJob, aset ); 
    
        Paper papertamanhoDoPapelEMargens;
        double margemSuperior, margemEsquerda, tmPapelMenosMargemDireita, tmPapelMenosMargemInferior, tamanhoPapelHorizontal, tamanhoPapelVertical;
        tamanhoPapelHorizontal     = 842;
        tamanhoPapelVertical       = 595;        
        margemSuperior             = 25;
        margemEsquerda             = 10;
        tmPapelMenosMargemDireita  = tamanhoPapelHorizontal - 5; 
        tmPapelMenosMargemInferior = tamanhoPapelVertical   - 40;
    
        PageFormat pFormat = PrinterJob.getPageFormat( aset ); // pJob.pageDialog(aset);  
        papertamanhoDoPapelEMargens = new Paper(); papertamanhoDoPapelEMargens.setSize( tamanhoPapelHorizontal, tamanhoPapelVertical ); 
        papertamanhoDoPapelEMargens.setImageableArea( margemEsquerda, margemSuperior, tmPapelMenosMargemDireita, tmPapelMenosMargemInferior ); pFormat.setPaper( papertamanhoDoPapelEMargens ); 
        PrinterJob.defaultPage( pFormat );
        */
        
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet(); 
        //aset.add(new Destination(new java.net.URI("file:e:/temp/out.ps")));
        //aset.add(new MediaPrintableArea(xmargin, ymargin, w - 2*xmargin, h - 2*ymargin, MediaPrintableArea.INCH));
        aset.add( MediaSizeName.ISO_A4 ); 
        aset.add( OrientationRequested.LANDSCAPE ); 
        aset.add( Chromaticity.COLOR ); 
        aset.add( Sides.ONE_SIDED ); 
        aset.add( PrintQuality.NORMAL ); 
                
        PageFormat pFormat = PrinterJob.getPageFormat( aset ); // pJob.pageDialog(aset);  
        papertamanhoDoPapelEMargens = new Paper(); papertamanhoDoPapelEMargens.setSize( tamanhoPapelHorizontal, tamanhoPapelVertical ); 
        papertamanhoDoPapelEMargens.setImageableArea( margemEsquerda, margemSuperior, tmPapelMenosMargemDireita, tmPapelMenosMargemInferior ); pFormat.setPaper( papertamanhoDoPapelEMargens ); 
        PrinterJob.defaultPage( pFormat ); 
        
        synchronized(this) {
            
            synchronized(this) {
                Printable pTable  = new Gerenciador_Email_Imprimir_05_PrintX_JM( htmlPanePrincipal, PrinterJob, aset );    
                
                PrinterJob.setPrintable( pTable, pFormat );
            }
            try {  
            
                synchronized(this) {

                    PrinterJob.print( aset );       
                    //TestPreview TestPreview = new TestPreview( htmlPanePrincipal );
                }
            
            } catch (Exception e) { e.printStackTrace(); JOPM JOPM = new JOPM( 2, "imprimirComPropriedadesEConfigurações( PrinterJob pJob, String NomeDoc ), \n"+ e.getMessage() + "\n", this.getClass().getSimpleName() );}

        }
    } 

    public static Paper papertamanhoDoPapelEMargens;
    public static double margemSuperior, margemEsquerda, tmPapelMenosMargemDireita, tmPapelMenosMargemInferior, tamanhoPapelHorizontal, tamanhoPapelVertical;
    // PropriedadesDaImpressão
    //public static URL url;                                
    public MediaSizeName papel;
    public int numeroDeCopias;
    public static String impressora = "Doro PDF Writer";
    public Sides lados;
    public Chromaticity cor;
    public String nomeDoUsuario;
    public static boolean perguntarQualImpressora;
    public OrientationRequested orientacaoDoPapel; // PropriedadesDaImpressão  
                            
    /******************Executar Teste*************************************  
     * @param args************************
    public static void main(String[] args) {            
          
        ControleThread_Print t1 = new ControleThread_Print(13); 
        
        t1.setName("ControleThread_Print");   
        
        t1.start();  
    }
    /******************Executar Teste*************************************/
    
}
