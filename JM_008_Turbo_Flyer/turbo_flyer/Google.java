/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo_flyer;

import com.google.api.services.drive.model.File;
import google_original.CreateFolder;
import google_original.GetSubFolders;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author NewUser
 */
public class Google {
    
    public static boolean verificar_se_uma_pasta_existe_no_root(String nome_pasta) throws IOException {        
        boolean retorno = false; 
        List<File> googleRootFolders = GetSubFolders.getGoogleSubFolders(null);
        for (File folder : googleRootFolders) { 
            if( folder.getName().trim().toUpperCase().equals( nome_pasta.trim().toUpperCase() ) ){                
                retorno = true;
            }
        }        
        return retorno;
    }
    
    public static String verificar_se_uma_pasta_existe_no_root_e_pegar_sua_id(String nome_pasta) throws IOException {        
        String retorno = null; 
        List<File> googleRootFolders = GetSubFolders.getGoogleSubFolders(null);
        for (File folder : googleRootFolders) { 
            if( folder.getName().trim().toUpperCase().equals( nome_pasta.trim().toUpperCase() ) ){                
                retorno = folder.getId();
            }
        }        
        return retorno;
    }
    
    public static boolean verificar_se_uma_pasta_existe_dentro_de_outra(String id_da_pasta_a_procurar, String nome_pasta_procurada) throws IOException {        
        boolean retorno = false; 
        List<File> googleRootFolders = GetSubFolders.getGoogleSubFolders( id_da_pasta_a_procurar );
        for (File folder : googleRootFolders) { 
            if( folder.getName().trim().toUpperCase().equals( nome_pasta_procurada.trim().toUpperCase() ) ){                
                retorno = true;
            }
        }        
        return retorno;
    }
    
    public static String verificar_se_uma_pasta_existe_dentro_de_outra_e_pegar_sua_id(String id_da_pasta_a_procurar, String nome_pasta_procurada) throws IOException {        
        String retorno = null; 
        List<File> googleRootFolders = GetSubFolders.getGoogleSubFolders( id_da_pasta_a_procurar );
        for (File folder : googleRootFolders) { 
            if( folder.getName().trim().toUpperCase().equals( nome_pasta_procurada.trim().toUpperCase() ) ){                
                retorno = folder.getId();
            }
        }        
        return retorno;
    }
            
    public static String criar_uma_pasta_no_root(String nome_pasta) throws IOException {      
        
        File folder = CreateFolder.createGoogleFolder(null, nome_pasta);   
        
        return folder.getId();
    }
    
    public static String criar_uma_pasta_dentro_de_outra_pasta(String id_da_pasta_onde_criar, String nome_pasta_a_ser_criada) throws IOException {      
        
        File folder = CreateFolder.createGoogleFolder( id_da_pasta_onde_criar, nome_pasta_a_ser_criada);   
        
        return folder.getId();
    }
    
}
