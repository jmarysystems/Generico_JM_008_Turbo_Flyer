package turbo_flyer_imprimir;

import br.com.jmary.utilidades.JOPM;
import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class Gerenciador_Email_Imprimir_04_Impressora {
    
    String nome_Impressora = "";
    
    public Gerenciador_Email_Imprimir_04_Impressora( String nome_Impressora2 ) {
        
        nome_Impressora = nome_Impressora2;
    }
                          
    public PrinterJob Impressora() { PrinterJob pJob = null;
        PrintService impressoraPadrao = null;
    
        try{
                        
            PrintService []services = PrinterJob.lookupPrintServices();
            
            if ( services.length > 0 ) { 
                
                pJob = PrinterJob.getPrinterJob();
                
                int c = 0;
                
                for( int i = 0; i < services.length; i++ ) { c = i; c += 1;
                    
                    if( services[i].getName().trim().equals( nome_Impressora ) ) {
                        
                        try { pJob.setPrintService( services[ i ] ); } catch ( Exception e ) {}  
                    }
                    else{
                        
                        if( c == services.length ){
                            impressoraPadrao = PrintServiceLookup.lookupDefaultPrintService();
                            
                            try { pJob.setPrintService( impressoraPadrao ); } catch ( Exception e ) {}  
                            
                            /*
                            //////////////////////
                            System.out.println("Usuarios_Do_Sistema_Imprimir_04_Impressora Padrao: " + impressoraPadrao.getName() );
                            try {
                                
                                Attribute[] attrs = impressoraPadrao.getAttributes().toArray();
                                for (int j=0; j<attrs.length; j++) {
                                    String attrName = attrs[j].getName();
                                    String attrValue = attrs[j].toString();
                                    System.out.println("Found attribute: " + attrName + " with value: " + attrValue);
                                }
                            } catch ( Exception e ) {}
                            //////////////////////
                            */        
                        }
                    }
                }
            }
            else{
                
                JOPM JOPM = new JOPM( 2, "PrintService Impressora(), \n"+ "Nenhuma Impressora Instalada ou Localizada" + "\n", this.getClass().getSimpleName() );
            }
            
        } catch( Exception e ){ JOPM JOPM = new JOPM( 2, "PrintService Impressora(), \n"+ e.getMessage() + "\n", this.getClass().getSimpleName() ); }
                
        return pJob;
    }
}