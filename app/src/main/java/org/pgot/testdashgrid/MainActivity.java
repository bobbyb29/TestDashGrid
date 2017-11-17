package org.pgot.testdashgrid;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;
    String companies[] = {"Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung",
            "Google","Windows","iPhone","Nokia","Samsung"};
    String os[]       =  {"Android","Mango","iOS","Symbian","Bada",
            "Android","Mango","iOS","Symbian","Bada",
            "Android","Mango","iOS","Symbian","Bada"};

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
    }



    /** This function add the headers to the table **/
    private void addHeaders() {
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
        TextView companyTV = new TextView(this);
        companyTV.setText("Keeno");
        companyTV.setTextColor(Color.GRAY);
        companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        companyTV.setPadding(5, 5, 5, 0);
        tr.addView(companyTV);  // Adding textView to tablerow.

        /** Creating another textview **/
        TextView valueTV = new TextView(this);
        valueTV.setText("Vash");
        valueTV.setTextColor(Color.GRAY);
        valueTV.setPadding(5, 5, 5, 0);
        valueTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(valueTV); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView valueTV1 = new TextView(this);
        valueTV1.setText("Bally");
        valueTV1.setTextColor(Color.GRAY);
        valueTV1.setPadding(5, 5, 5, 0);
        valueTV1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(valueTV1); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView valueTV2 = new TextView(this);
        valueTV2.setText("Tomlin");
        valueTV2.setTextColor(Color.GRAY);
        valueTV2.setPadding(5, 5, 5, 0);
        valueTV2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(valueTV2); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
    }

    /** This function add the data to the table **/
    public void addData(){

        for (int i = 0; i < companies.length; i++)
        {
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            /** Creating a TextView to add to the row **/
            TextView companyTV = new TextView(this);
            companyTV.setText(companies[i]);
            companyTV.setTextColor(Color.RED);
            companyTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            companyTV.setPadding(5, 5, 5, 5);
            tr.addView(companyTV);  // Adding textView to tablerow.

            /** Creating a TextView to add to the row **/
            TextView companyTV1 = new TextView(this);
            companyTV1.setText(companies[i]);
            companyTV1.setTextColor(Color.RED);
            companyTV1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            companyTV1.setPadding(5, 5, 5, 5);
            tr.addView(companyTV1);  // Adding textView to tablerow.

            /** Creating a TextView to add to the row **/
            TextView companyTV2 = new TextView(this);
            companyTV2.setText(companies[i]);
            companyTV2.setTextColor(Color.RED);
            companyTV2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            companyTV2.setPadding(5, 5, 5, 5);
            tr.addView(companyTV2);  // Adding textView to tablerow.

            /** Creating a TextView to add to the row **/
            TextView companyTV3 = new TextView(this);
            companyTV3.setText(companies[i]);
            companyTV3.setTextColor(Color.RED);
            companyTV3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            companyTV3.setPadding(5, 5, 5, 5);
            tr.addView(companyTV3);  // Adding textView to tablerow.

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }



    }




}
