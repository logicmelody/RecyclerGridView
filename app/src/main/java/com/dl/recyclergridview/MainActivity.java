package com.dl.recyclergridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mGridView;
    private RecyclerView.LayoutManager mLayourManager;
    private GridViewAdapter mGridViewAdapter;
    private List<String> mDatas = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        int i = 0;
    }

    private void initialize() {
        findViews();
        initDatas();
        initGridView();
    }

    private void findViews() {
        mGridView = (RecyclerView) findViewById(R.id.recycler_grid_view);
    }

    private void initDatas() {
        for (int i = 0 ; i < 15 ; i++) {
            mDatas.add("This is " + i);
        }
    }

    private void initGridView() {
        mLayourManager = new GridLayoutManager(this, 3);
        mGridViewAdapter = new GridViewAdapter(this, mDatas);
        mGridView.setLayoutManager(mLayourManager);
        mGridView.setAdapter(mGridViewAdapter);
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
