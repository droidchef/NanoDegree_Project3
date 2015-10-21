package barqsoft.footballscores;

import android.database.Cursor;

/**
 * Created by ishan on 17/10/15.
 */
public class Score {

    private String date;
    private String time;
    private String homeTeam;
    private String awayTeam;
    private int leagueName;
    private String homeGoals;
    private String awayGoals;
    private int matchId;
    private int matchDay;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(int leagueName) {
        this.leagueName = leagueName;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(int matchDay) {
        this.matchDay = matchDay;
    }

    public static Score getScore(Cursor cursor) {

        Score score = new Score();
        score.setLeagueName(cursor.getInt(0));
        score.setDate(cursor.getString(1));
        score.setTime(cursor.getString(2));
        score.setHomeTeam(cursor.getString(3));
        score.setAwayTeam(cursor.getString(4));
        score.setHomeGoals(cursor.getString(5));
        score.setAwayGoals(cursor.getString(6));
        score.setMatchId(cursor.getInt(7));
        score.setMatchDay(cursor.getInt(8));
        return score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", leagueName=" + leagueName +
                ", homeGoals='" + homeGoals + '\'' +
                ", awayGoals='" + awayGoals + '\'' +
                ", matchId=" + matchId +
                ", matchDay=" + matchDay +
                '}';
    }
}
