package barqsoft.footballscores;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import barqsoft.footballscores.service.myFetchService;

/**
 * Created by ishan on 13/10/15.
 */
public class WidgetService extends IntentService {


    private static final String TAG = "WidgetService";

    public WidgetService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "IN service");

        String[] selectionArgs = new String[1];
        selectionArgs[0] = "398";
        Cursor cursor = getContentResolver().query(DatabaseContract.scores_table.buildScoreWithLeague(), DatabaseContract.scores_table.getAllProjections(),null, selectionArgs, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Log.d(TAG, Score.getScore(cursor).toString());
            cursor.moveToNext();
        }
        cursor.close();

    }
}
