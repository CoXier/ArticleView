package com.hackerli.library;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by CoXier on 17-3-27.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.WordHolder> {
    private List<String> wordList;
    private int mFontColor;
    private float mFontSize;

    public ArticleAdapter(List<String> wordList) {
        this.wordList = wordList;

    }

    public ArticleAdapter(String input){
        this(Utils.parse(input));
    }

    @Override
    public WordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word_layout, parent, false);
        return new WordHolder(v);
    }

    @Override
    public void onBindViewHolder(WordHolder holder, int position) {
        String word = wordList.get(position);
        holder.mTextView.setText(word);
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(wordList,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        mFontColor = ((ArticleView)recyclerView).getFontColor();
        mFontSize = ((ArticleView)recyclerView).getFontSize();
        super.onAttachedToRecyclerView(recyclerView);
    }

    class WordHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;

        WordHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_word);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(30,5,0,5);
            mTextView.setLayoutParams(params);
            mTextView.setTextSize(mFontSize);
            mTextView.setTextColor(mFontColor);
        }
    }
}
