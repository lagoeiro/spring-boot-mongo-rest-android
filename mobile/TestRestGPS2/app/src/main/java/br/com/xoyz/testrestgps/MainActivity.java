package br.com.xoyz.testrestgps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.xoyz.testrestgps.entity.Check;
import br.com.xoyz.testrestgps.listview.EndlessScrollListener;
import br.com.xoyz.testrestgps.listview.ListAdapter;

public class MainActivity extends AppCompatActivity {

    private ListAdapter mAdapter;
    public static final int MAX_ROWS = 20;
    public static final String CHECK = "Check";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = (ListView) findViewById(R.id.list);

        // create some dummy data here
        List<Check> objects = new ArrayList<Check>();

        mAdapter = new ListAdapter(this, objects);
        list.setAdapter(mAdapter);
        list.setOnScrollListener(new EndlessScrollListener(MAX_ROWS, mAdapter));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Check check = (Check)parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, CheckDetailsActivity.class);
                intent.putExtra(CHECK, check);
                startActivity(intent);
            }
        });

    }


}
