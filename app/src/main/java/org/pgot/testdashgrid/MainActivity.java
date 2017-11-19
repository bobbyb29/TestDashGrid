package org.pgot.testdashgrid;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;

    String players[] = {"Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone"};

    String teams[]   = {"SEA","PHI","NYG","MIN",
            "DET","WAS","DAL","PIT","IND",
            "TEN","CHI","ATL","CLE","LAR"};

    //calculated and concatenated
    String footers[] = {"10-0","10-0","10-0","10-0","10-0",
            "10-0","10-0","10-0","10-0","10-0",
            "10-0","10-0","10-0"};

    //pulled from the database
    String tiebreaker[] = {"99","99","99","99","99",
            "99","99","99","","99",
            "99","99","99"};

    TableLayout tl;
    TableRow tr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_main_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tl = (TableLayout) findViewById(R.id.myTable);
        addHeaders();
        addData();
        addFooter();
        addTieBreaker();
    }

    private void addTieBreaker() {
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        for(int p=0;  p < players.length; p++) {
            /** Creating a TextView to add the footers row **/
            TextView footerTV = new TextView(this);
            footerTV.setText(tiebreaker[p]);
            footerTV.setTextColor(Color.GRAY);
            footerTV.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
            footerTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            footerTV.setPadding(5, 5, 5, 0);
            tr.addView(footerTV);  // Adding textView to tablerow.
        }

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

    }

    private void addFooter() {
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        for(int p=0;  p < players.length; p++) {
            /** Creating a TextView to add the footers row **/
            TextView footerTV = new TextView(this);
            footerTV.setText(footers[p]);
            footerTV.setTextColor(Color.GRAY);
            footerTV.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
            footerTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            footerTV.setPadding(5, 5, 5, 0);
            tr.addView(footerTV);  // Adding textView to tablerow.
        }

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

    }

    /** This function add the headers to the table **/
    private void addHeaders() {
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));


        for(int p=0;  p < players.length; p++) {
            /** Creating a TextView to add to the row **/
            TextView playerTV = new TextView(this);
            playerTV.setText(players[p]);
            playerTV.setTextColor(Color.GRAY);
            playerTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            playerTV.setPadding(5, 5, 5, 0);
            tr.addView(playerTV);  // Adding textView to tablerow.
        }

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
    }

    /** This function add the data to the table **/
    public void addData(){

        for (int i=0; i < teams.length; i++)
        {
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));


            for(int t=0;  t < players.length; t++) {
                /** Creating a team icon image to add to the row **/
                ImageView teamIcon = new ImageView(this);

                switch (teams[i]) {
                    case "SEA":
                        teamIcon.setImageResource(R.mipmap.ic_seahawks);
                        break;
                    case "PHI":
                        teamIcon.setImageResource(R.mipmap.ic_eagles);
                        break;
                    case "NYG":
                        teamIcon.setImageResource(R.mipmap.ic_giants);
                        break;
                    case "DAL":
                        teamIcon.setImageResource(R.mipmap.ic_cowboys);
                        break;
                    case "CHI":
                        teamIcon.setImageResource(R.mipmap.ic_bears);
                        break;
                    case "PIT":
                        teamIcon.setImageResource(R.mipmap.ic_steelers);
                        break;
                    case "CLE":
                        teamIcon.setImageResource(R.mipmap.ic_browns);
                        break;
                    case "LAR":
                        teamIcon.setImageResource(R.mipmap.ic_rams);
                        break;
                    case "ATL":
                        teamIcon.setImageResource(R.mipmap.ic_falcons);
                        break;
                    case "IND":
                        teamIcon.setImageResource(R.mipmap.ic_colts);
                        break;
                    case "TEN":
                        teamIcon.setImageResource(R.mipmap.ic_titans);
                        break;
                    case "MIN":
                        teamIcon.setImageResource(R.mipmap.ic_vikings);
                        break;
                    case "DET":
                        teamIcon.setImageResource(R.mipmap.ic_lions);
                        break;
                    case "WAS":
                        teamIcon.setImageResource(R.mipmap.ic_redskins);
                        break;
                    default:
                        teamIcon.setImageResource(R.mipmap.ic_launcher);
                        break;
                }

                // set this for shared preferences
                teamIcon.setBackgroundColor(Color.YELLOW);

                teamIcon.setPadding(5, 5, 5, 5);
                tr.addView(teamIcon);  // Adding textView to tablerow.
            }

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }
}
