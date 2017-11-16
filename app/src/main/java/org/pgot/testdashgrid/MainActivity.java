package org.pgot.testdashgrid;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.ImageView;
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
        GridLayout gridLayout = null;
        TableRow tbrow0 = null;
        TableRow tbrowx = null;
        TableRow tbrowy = null;
        for (int l = 0; l <= 5; l++) {

            tbrow0 = new TableRow(this);
            TextView tv0r0 = new TextView(this);
            tv0r0.setText("Bally ");
            tv0r0.setBackgroundColor(WHITE);
            tv0r0.setTextColor(BLACK);
            tbrow0.addView(tv0r0);

            gridLayout = new GridLayout(this);
            int total = 8;
            int column = 1;
            int row = total / column;
            gridLayout.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
            gridLayout.setColumnCount(column);
            gridLayout.setRowCount(row + 1);

            for (int i = 0, c = 0, r = 0; i < total; i++, c++) {
                if (c == column) {
                    c = 0;
                    r++;
                }

                ImageView iv0r1 = new ImageView(this);
                iv0r1.setImageResource(R.mipmap.ic_49ers);
                GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                param.height = TableLayout.LayoutParams.WRAP_CONTENT;
                param.width = TableLayout.LayoutParams.WRAP_CONTENT;
                param.rightMargin = 5;
                param.topMargin = 5;
                param.setGravity(Gravity.CENTER);
                param.columnSpec = GridLayout.spec(c);
                param.rowSpec = GridLayout.spec(r);
                gridLayout.addView(iv0r1);
            }

            tbrow0.setBackgroundResource(R.color.colorPrimaryDark);

            //Row x is the row of cells containing the win-loss records for eeach userid
            tbrowx = new TableRow(this);
            TextView tv0rx = new TextView(this);
            tv0rx.setText("10-0 ");
            tbrowx.addView(tv0rx);

            //Row y is the row of cells the tie-break for eeach userid if they so choose
            tbrowy = new TableRow(this);
            TextView tv0ry = new TextView(this);
            tv0ry.setText("56 ");
            tbrowy.addView(tv0ry);


        // this section runs only once outside the for loop
        stk.addView(tbrow0);
        stk.addView(gridLayout);
        stk.addView(tbrowx);
        stk.addView(tbrowy);

        }

    }


}
