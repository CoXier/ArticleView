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
    private List<String> mWordList;
    private int mFontColor;
    private float mFontSize;

    private static int WORD = 0;
    private static int NEW_LINE = 1;
    private static int SPACE = 2;

    private WordLongClickListener mWordLongClickListener;

    public ArticleAdapter(List<String> wordList) {
        this.mWordList = wordList;

    }

    public ArticleAdapter(String input) {
        this(Utils.parse(input));
    }

    @Override
    public WordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == WORD || viewType == SPACE) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word_layout, parent, false);
        } else {
            v = new View(parent.getContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 10);
            v.setLayoutParams(params);
        }
        return new WordHolder(v, viewType);

    }

    @Override
    public void onBindViewHolder(final WordHolder holder, int position) {
        if (getItemViewType(position) != NEW_LINE) {
            String word = mWordList.get(position);
            holder.mTextView.setText(word);
            if (getItemViewType(position) != SPACE)
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (mWordLongClickListener != null)
                            mWordLongClickListener.onClick(holder);
                        return false;
                    }
                });
        }
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mWordList.get(position).equals("\n")) return NEW_LINE;
        else if (mWordList.get(position).equals("  ")) return SPACE;
        return WORD;
    }

    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mWordList,fromPosition,toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public void setWordLongClickListener(WordLongClickListener wordLongClickListener) {
        mWordLongClickListener = wordLongClickListener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        mFontColor = ((ArticleView) recyclerView).getFontColor();
        mFontSize = ((ArticleView) recyclerView).getFontSize();
        super.onAttachedToRecyclerView(recyclerView);
    }

    public List<String> getWordList() {
        return mWordList;
    }

    class WordHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        WordHolder(View itemView, int viewType) {
            super(itemView);
            if (viewType == NEW_LINE) return;
            mTextView = (TextView) itemView.findViewById(R.id.tv_word);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(30, 5, 0, 5);
            mTextView.setLayoutParams(params);
            mTextView.setTextSize(mFontSize);
            mTextView.setTextColor(mFontColor);
        }
    }

    public interface WordLongClickListener {
        void onClick(RecyclerView.ViewHolder viewHolder);
    }
}
