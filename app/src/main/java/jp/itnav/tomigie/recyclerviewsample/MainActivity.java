package jp.itnav.tomigie.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayouts();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.buttonLinear) {
            setLinearRecyclerView();
        }
        else if (id == R.id.buttonGrid) {
            setGridRecyclerView();
        }
        else if (id == R.id.buttonStaggered) {
            setStaggeredGridRecyclerView();
        }
    }

    public void setLayouts() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setLinearRecyclerView();
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new RecyclerViewAdapter(this, getDataList(20)));

        Button linear = (Button) findViewById(R.id.buttonLinear);
        Button grid = (Button) findViewById(R.id.buttonGrid);
        Button staggered = (Button) findViewById(R.id.buttonStaggered);
        linear.setOnClickListener(this);
        grid.setOnClickListener(this);
        staggered.setOnClickListener(this);
    }

    public void setLinearRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void setGridRecyclerView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    public void setStaggeredGridRecyclerView() {
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    }
}