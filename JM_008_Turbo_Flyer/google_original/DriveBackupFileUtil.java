package google_original;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.IOException;

/**
 * @author Martin Styk
 * @version 14.10.2017
 */
public class DriveBackupFileUtil {

    //private static final String LOG_TAG = DriveBackupFileUtil.class.getSimpleName();

    //public static final String BACKUP_DB_FOLDER = "FuelUp_backup";
    public static final String BACKUP_DB_FILE_NAME = "fuelup_backup.json";
    private static final String[] SCOPES = {DriveScopes.DRIVE};

    public static String getBackupFileId(Drive service, String folderId) throws IOException {
        if (folderId == null) {
            return null;
        }

        FileList jsonFile = service.files().list()
                .setQ("\'" + folderId + "\' in parents and name = \'" + BACKUP_DB_FILE_NAME + "\'")
                .setPageSize(1)
                .setFields("files(id)")
                .execute();

        if (jsonFile.getFiles() == null) {
            return null;
        } else if (jsonFile.getFiles().size() != 1) {
            //Log.e(LOG_TAG, "There are more files " + BACKUP_DB_FILE_NAME + " in your FuelUp folder on Google Drive.");
            // TODO handle this with message
            return null;
        }
        return jsonFile.getFiles().get(0).getId();
    }

    public static String getBackupFolderId( String BACKUP_DB_FOLDER ) throws IOException {
        
        Drive driveService = GoogleDriveUtils.getDriveService();
        
        FileList fuelUpFolder = driveService.files().list()
                .setQ("\'root\' in parents and name = \'"+ BACKUP_DB_FOLDER +"\'")
                .setPageSize(1)
                .setFields("files(id)")
                .execute();
        
        for (File folder : fuelUpFolder.getFiles() ) {
            
            System.out.println( "\n");
            System.out.println( folder.getCreatedTime() );
            System.out.println( folder.getId());
            System.out.println( folder.getModifiedByMeTime());
            System.out.println( folder.getWebViewLink());
            System.out.println( folder.getName());
            System.out.println( folder.getMimeType());
            System.out.println( "\n");
        }
        
        if (fuelUpFolder.getFiles() == null) {
            return null;
        } else if (fuelUpFolder.getFiles().size() != 1) {
            //Log.e(LOG_TAG, "There are more folders " + BACKUP_DB_FOLDER + " on your Google Drive Account.");
            // TODO handle this with message
            return null;
        }

        return fuelUpFolder.getFiles().get(0).getId();
    }
}