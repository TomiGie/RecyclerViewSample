package jp.itnav.tomigie.recyclerviewsample;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private LayoutInflater      mLayoutInflater;
    private ArrayList<String>   mDataList;
    private Context             mContext;


    public RecyclerViewAdapter(Context context, ArrayList<String> dataList) {
        super();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = dataList;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {
        final String data = mDataList.get(position);
        holder.text.setText(data);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // カードをクリックした時の処理
                Toast.makeText(mContext, data + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView        text;
        CardView        cardView;
        RecyclerView    recyclerView;

        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.cardArticleTitle);
            cardView = (CardView) v.findViewById(R.id.cardView);
            recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        }
    }
}