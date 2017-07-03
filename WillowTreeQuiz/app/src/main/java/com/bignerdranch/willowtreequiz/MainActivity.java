package com.bignerdranch.willowtreequiz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestion;
    private boolean answers[] = {true, true, false, true, false};
    private String questions[] = {  "WillowTree has offices in Charlottesville, Durham and New York City",
                                    "WillowTree designs and develops mobile and web apps for the world's leading brands",
                                    "WillowTree is not a place for Makers",
                                    "At WillowTree we have lots of fun doing work we love",
                                    "WillowTree is not certified by Apple, Google and Microsoft"};
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion.setText(questions[counter]);
        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answers[counter] = false) {
                    Toast.makeText(MainActivity.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this,
                            R.string.correct_toast,
                            Toast.LENGTH_SHORT).show();
                }
                mNextButton.setVisibility(View.VISIBLE);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answers[counter] = true) {
                    Toast.makeText(MainActivity.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this,
                            R.string.correct_toast,
                            Toast.LENGTH_SHORT).show();
                }
                mNextButton.setVisibility(View.VISIBLE);
            }
        });
        mFalseButton = (Button)findViewById(R.id.false_button);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter++;
                if (counter < 5) {
                    mQuestion.setText(questions[counter]);
                }
                else{
                    Toast.makeText(MainActivity.this,
                            R.string.finished,
                            Toast.LENGTH_SHORT).show();
                }
                mNextButton.setVisibility(View.GONE);
            }
        });
        mNextButton = (Button)findViewById(R.id.next_button);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
