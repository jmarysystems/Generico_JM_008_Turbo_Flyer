/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google_original;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author NewUser
 */
public class Atualizar_Data_Modificacao_Arquivo {
    
    public static void listar_arquivos_de_pasta_especifica_no_root(String nome_pasta) throws IOException {
 
        List<File> googleRootFolders = GetSubFolders.getGoogleSubFolders(null);
        for (File folder : googleRootFolders) {
 
            if( folder.getName().trim().toUpperCase().equals( nome_pasta.trim().toUpperCase() ) ){
                
                System.out.println("Folder ID: " + folder.getId() + " --- Name: " + folder.getName());
                listar_arquivos_de_subPasta_do_root_pelo_id( folder.getId() );
            }
        }
    }
    
    public static void listar_pastas_de_outra_pasta_do_root_pelo_id(String id_pasta) throws IOException {
 
        List<File> googleRootFolders = GetSubFolders.getGoogleSubFolders(id_pasta);
        for (File folder : googleRootFolders) {
 
            System.out.println("Folder ID: " + folder.getId() + " --- Name: " + folder.getName());
        }
    }
    
    public static void listar_arquivos_de_subPasta_do_root_pelo_id(String id_pasta) throws IOException {
 
        List<File> googleSubArquivosDeFolder = GetSubFolders.getGoogleSubFile(id_pasta);
        for (File file : googleSubArquivosDeFolder) {
 
            System.out.println("Folder ID: " + file.getId() + " --- Name: " + file.getName());
        }
    }
    
    private static File updateModifiedDate(String fileId) {
        try {
            
            Drive driveService = GoogleDriveUtils.getDriveService();
           
            //return driveService.files().touch(fileId).execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
        return null;
    }  
    
}
