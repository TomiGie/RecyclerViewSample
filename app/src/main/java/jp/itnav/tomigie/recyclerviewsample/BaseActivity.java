package jp.itnav.tomigie.recyclerviewsample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.util.ArrayList;

/**
 * 各Activityに継承させるためのクラス
 * (各Activityで共通する処理をこのクラスのメソッドでまとめているだけ）
 */
public abstract class BaseActivity extends ActionBarActivity implements View.OnClickListener {

    /**
     * 仮データ生成メソッド
     * @param dataSize
     * @return Stringデータ
     */
    protected ArrayList<String> getDataList(int dataSize) {
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 1; i <= dataSize; i++) {
            dataList.add("card" + i);
        }
        return dataList;
    }

    protected void startNewActivity(Class<Activity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}