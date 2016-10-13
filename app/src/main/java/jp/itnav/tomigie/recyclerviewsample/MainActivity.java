package jp.itnav.tomigie.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayouts();
    }

    public void setLayouts() {
        // RecyclerViewを定義する
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // RecyclerViewの表示の設定
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        // アイテムを表示させる情報をもつアダプターを生成
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, Constants.locations);

        // アダプターをRecyclerViewにセット
        mRecyclerView.setAdapter(adapter);
    }
}