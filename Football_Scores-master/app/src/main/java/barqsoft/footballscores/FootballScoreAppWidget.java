package barqsoft.footballscores;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import barqsoft.footballscores.service.MyFetchService;

/**
 * Implementation of App Widget functionality.
 */
public class FootballScoreAppWidget extends AppWidgetProvider {

    private static final String TAG = "FSAppWidget";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context,appWidgetManager,appWidgetIds);
        // There may be multiple widgets active, so update all of them
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.football_score_app_widget);

        views.setTextViewText(R.id.home_team_name, "homeTeam");
        views.setTextViewText(R.id.away_team_name, "awayTeam");

        Log.d(TAG, "update called");
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetIds[0], views);

    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
        //context.startService(new Intent(context, WidgetService.class));
        Log.d("Widget", "Here");
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (intent.getAction().equals(MyFetchService.INTENT_SCORES_UPDATED)) {

            Bundle bundle = intent.getExtras();

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.football_score_app_widget);
            views.setTextViewText(R.id.home_team_name, bundle.getString("homeTeamName") + " vs " );
            views.setTextViewText(R.id.home_team_score, bundle.getString("homeTeamScore") + " - ");
            views.setTextViewText(R.id.away_team_name,  bundle.getString("awayTeamName"));
            views.setTextViewText(R.id.away_team_score, bundle.getString("awayTeamScore"));

            ComponentName widget = new ComponentName(context, FootballScoreAppWidget.class);

            AppWidgetManager.getInstance(context).updateAppWidget(widget, views);

        }


    }
}

