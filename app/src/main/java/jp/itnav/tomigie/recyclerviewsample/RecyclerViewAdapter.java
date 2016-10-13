package jp.itnav.tomigie.recyclerviewsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private LocationInfo[] mLocationInfo;
    private Context mContext;


    public RecyclerViewAdapter(Context context, LocationInfo[] locationInfo) {
        super();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mLocationInfo = locationInfo;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // RecyclerViewで表示するレイアウト(今回はitem.xml)を指定する
        int layoutId = R.layout.item;
        View v = mLayoutInflater.inflate(layoutId, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {
        // 場所の情報を持つLocationInfoを、LocationInfoの配列(mLocationInfo)から
        // position(カードの位置)を使ってとりだす
        final LocationInfo locationInfo = mLocationInfo[position];

        // 地名と画像リソースIDを取得
        final String title = locationInfo.getTimei();
        final int image = locationInfo.getImageResourceId();

        // holder変数に、アイテム(item.xmlのレイアウト)の情報が含まれているので、
        // holderからTextViewとImageViewを指定して、タイトルと画像をセットする
        holder.itemTitle.setText(title);
        holder.itemImage.setImageResource(image);

        // アイテムをタップした時
        holder.listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // カードをクリックした時の処理
                Toast.makeText(mContext, title + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // Constantsで登録されている場所の個数を取得
        return Constants.getLocationsLength();
    }

    //
    // ViewHolderはRecyclerViewに表示させたいアイテムのViewの情報を設定する
    //
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        FrameLayout listItemView;

        public ViewHolder(View v) {
            super(v);
            // ここでViewIDと変数を紐付ける
            itemTitle = (TextView) v.findViewById(R.id.list_item_Title);
            itemImage = (ImageView) v.findViewById(R.id.list_item_Image);
            listItemView = (FrameLayout) v.findViewById(R.id.list_item);
        }
    }
}