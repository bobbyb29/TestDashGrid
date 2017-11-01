package org.pgot.testdashgrid;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;


public class MainActivity extends AppCompatActivity {
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_main_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TableLayout stk = (TableLayout) findViewById(R.id.myTable);

        TableRow tbrow0 = new TableRow(this);

        TextView tv0r0 = new TextView(this);
        tv0r0.setText("Bally ");
        tv0r0.setBackgroundColor(WHITE);
        tv0r0.setTextColor(BLACK);
        tbrow0.addView(tv0r0);

        TextView tv1r0 = new TextView(this);
        tv1r0.setText("Vash ");
        tv1r0.setBackgroundColor(WHITE);
        tv1r0.setTextColor(BLACK);
        tbrow0.addView(tv1r0);

        TextView tv2r0 = new TextView(this);
        tv2r0.setText("Keeno ");
        tv2r0.setBackgroundColor(WHITE);
        tv2r0.setTextColor(BLACK);
        tbrow0.addView(tv2r0);

        TextView tv3r0 = new TextView(this);
        tv3r0.setText("Tomlin ");
        tv3r0.setBackgroundColor(WHITE);
        tv3r0.setTextColor(BLACK);
        tbrow0.addView(tv3r0);

        TextView tv4r0 = new TextView(this);
        tv4r0.setText("Tomlin ");
        tv4r0.setBackgroundColor(WHITE);
        tv4r0.setTextColor(BLACK);
        tbrow0.addView(tv4r0);

        TextView tv5r0 = new TextView(this);
        tv5r0.setText("Tomlin ");
        tv5r0.setBackgroundColor(WHITE);
        tv5r0.setTextColor(BLACK);
        tbrow0.addView(tv5r0);

        TextView tv6r0 = new TextView(this);
        tv6r0.setText("Tomlin ");
        tv6r0.setBackgroundColor(WHITE);
        tv6r0.setTextColor(BLACK);
        tbrow0.addView(tv6r0);

        TextView tv7r0 = new TextView(this);
        tv7r0.setText("Tomlin ");
        tv7r0.setBackgroundColor(WHITE);
        tv7r0.setTextColor(BLACK);
        tbrow0.addView(tv7r0);

        TextView tv8r0 = new TextView(this);
        tv8r0.setText("Tomlin ");
        tv8r0.setBackgroundColor(WHITE);
        tv8r0.setTextColor(BLACK);
        tbrow0.addView(tv8r0);

        TextView tv9r0 = new TextView(this);
        tv9r0.setText("Tomlin ");
        tv9r0.setBackgroundColor(WHITE);
        tv9r0.setTextColor(BLACK);
        tbrow0.addView(tv9r0);

        TextView tv10r0 = new TextView(this);
        tv10r0.setText("Tomlin ");
        tv10r0.setBackgroundColor(WHITE);
        tv10r0.setTextColor(BLACK);
        tbrow0.addView(tv10r0);

        TextView tv11r0 = new TextView(this);
        tv11r0.setText("Tomlin ");
        tv11r0.setBackgroundColor(WHITE);
        tv11r0.setTextColor(BLACK);
        tbrow0.addView(tv11r0);


        tbrow0.setBackgroundResource(R.color.colorPrimaryDark);

        //Row x is the row of cells containing the win-loss records for eeach userid
        TableRow tbrowx = new TableRow(this);
        TextView tv0rx = new TextView(this);
        tv0rx.setText("10-0 ");
        tbrowx.addView(tv0rx);

        //Row y is the row of cells the tie-break for eeach userid if they so choose
        TableRow tbrowy = new TableRow(this);
        TextView tv0ry = new TextView(this);
        tv0ry.setText("56 ");
        tbrowy.addView(tv0ry);

        // this section runs only once outside the for loop
        stk.addView(tbrow0);
        stk.addView(tbrowx);
        stk.addView(tbrowy);

    }


}
