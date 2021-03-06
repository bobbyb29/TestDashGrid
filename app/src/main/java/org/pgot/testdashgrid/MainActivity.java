package org.pgot.testdashgrid;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class MainActivity extends AppCompatActivity {

    private Bitmap bitmap;

    String players[] = {"Google", "Windows", "iPhone", "Nokia", "Samsung",
            "Google", "Windows", "iPhone", "Nokia", "Samsung",
            "Google", "Windows", "iPhone"};

    List<String> uid = new ArrayList<String>();
    List<String> tno = new ArrayList<String>();

    String teams[] = {"SEA", "PHI", "NYG", "MIN",
            "DET", "WAS", "DAL", "PIT", "IND",
            "TEN", "CHI", "ATL", "CLE", "LAR"};

    //calculated and concatenated
    String footers[] = {"10-0", "10-0"};

    //pulled from the database
    String tiebreaker[] = {"99", "99"};

    TableLayout tl;
    TableRow tr;

    ArrayList picklist = new ArrayList<>();
    private int k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_main_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tl = (TableLayout) findViewById(R.id.myTable);

        // take the array to the database
        new JSONParse().execute();
        //addHeaders();
        //addData();
        //addFooter();
        //addTieBreaker();
    }

    class JSONParse extends AsyncTask<Void, Void, ArrayList> {

        private String URL = "http://www.bab-c.com:88/picksandbets/football/test.php";


        @Override
        protected ArrayList doInBackground(Void... params) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(URL);
            System.out.println("jsonstring output: " + jsonStr);

            // Parse
            JSONObject json = null;
            try {
                json = new JSONObject(jsonStr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jArray = null;
            try {
                jArray = json.getJSONArray("userids");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < jArray.length(); i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                JSONObject e = null;
                try {
                    e = jArray.getJSONObject(i);
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
                JSONObject jObject = null;
                try {
                    jObject = new JSONObject(String.valueOf(e));
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }

                try {
                    map.put("username", jObject.getString("username"));
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
                try {
                    map.put("teamini", jObject.getString("teamini"));
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
                picklist.add(map);
            }

            return picklist;
        }

        @TargetApi(Build.VERSION_CODES.N)
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected void onPostExecute(ArrayList arrayList) {
            super.onPostExecute(arrayList);

            //CONVERT THE JSON OBJECT TO ARRAY
            JSONArray arr = new JSONArray(picklist);

            for (int i = 0; i < arr.length(); i++) {
                try {
                    uid.add(arr.getJSONObject(i).getString("username"));
                    tno.add(arr.getJSONObject(i).getString("teamini"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Set<Object> uniqueSetU = uid.stream().collect(Collectors.toSet());
            System.out.println(uniqueSetU);


            //Set<String> uniqueSetU = new HashSet<String>(uid);
           // for (String temp : uniqueSetU) {
           //     System.out.println(temp + ":" + Collections.frequency(uid, temp));
           // }
            //Count team no with frequency
            Set<String> uniqueSetT = new HashSet<String>(tno);
            for (String temp1 : uniqueSetT) {
                System.out.println(temp1 + ":" + Collections.frequency(tno, temp1));
            }
            addHeaders(uniqueSetU);
            System.out.println("userids:" + uid + uid.size());
            System.out.println("teamini:" + tno + tno.size());
            System.out.println("unique set U" + uniqueSetU);
        }

    }


    private void addTieBreaker() {
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        for (int p = 0; p < tiebreaker.length; p++) {
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

        for (int p = 0; p < players.length; p++) {
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

    // This function add the headers to the table

    private void addHeaders(Set<Object> uniqueSetU) {

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        for (Iterator<Object> it = uniqueSetU.iterator(); it.hasNext(); ) {
            Object f = it.next();

            /** Creating a TextView to add to the row **/
            TextView playerTV = new TextView(this);
            playerTV.setText((CharSequence) f);
            playerTV.setTextColor(Color.GRAY);
            playerTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            playerTV.setPadding(5, 5, 5, 0);
            tr.addView(playerTV);  // Adding textView to tablerow.
        }

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        for (int x = 0; x < 3; x++) {
        addData(x); }

    }

    /**
     * This function add the data to the table
     *
     *  */
    public void addData(int t) {

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

            // this is for the number of colunms
            for (; t < 6; t = t + 3) {
                /** Creating a team icon image to add to the row **/
                ImageView teamIcon = new ImageView(this);

                switch (tno.get(t)) {
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
                    case "CIN":
                        teamIcon.setImageResource(R.mipmap.ic_bengals);
                        break;
                    default:
                        teamIcon.setImageResource(R.mipmap.ic_launcher);
                        break;
                }

                // set this for shared preferences
                teamIcon.setBackgroundColor(Color.YELLOW);
                teamIcon.setPadding(5, 5, 5, 5);
                tr.addView(teamIcon);  // Adding textView to tablerow.}
            }
            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

    }
}

