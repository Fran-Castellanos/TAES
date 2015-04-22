package juego.taes.domainmodel.Data;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import juego.taes.domainmodel.Data.Example.DatabaseHelperExample;


/**
 * Created by alienware18 on 9-8-13.
 */
public class DatabaseManager {


    private DatabaseHelperExample databaseHelperExample = null;

    //gets a helper once one is created ensures it doesnt create a new one
    public DatabaseHelperExample getHelper(Context context)
    {
        if (databaseHelperExample == null) {
            databaseHelperExample =
                    OpenHelperManager.getHelper(context, DatabaseHelperExample.class);
        }
        return databaseHelperExample;
    }

    //releases the helper once usages has ended
    public void releaseHelper(DatabaseHelperExample helper)
    {
        if (databaseHelperExample != null) {
            OpenHelperManager.releaseHelper();
            databaseHelperExample = null;
        }
    }

}
