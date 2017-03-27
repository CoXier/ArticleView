package com.hackerli.article;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.hackerli.library.ArticleAdapter;
import com.hackerli.library.ArticleView;
import com.hackerli.library.itemdrag.SimpleItemTouchHelperCallback;
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;

public class MainActivity extends AppCompatActivity implements ArticleAdapter.WordLongClickListener {
    ArticleView mArticleView;
    ArticleAdapter mAdapter;
    ItemTouchHelper mItemTouchHelper;

    String s = "Nothing succeeds like confidence.When you are truly confident,it radiates from you like sunlight,and attracts success to you like a magnet.\n"
            + "It's important to believe in yourself.Believe that you can do it under any circumstances,because if you believe you can,then you really will.The belief keeps you searching for answers,which means that pretty soon you will get them.\n"
            + "Good Luck";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArticleView = (ArticleView) findViewById(R.id.article_view);
        mAdapter = new ArticleAdapter(s);
        mAdapter.setWordLongClickListener(this);
        mArticleView.setAdapter(mAdapter);
        mArticleView.setLayoutManager(new FlowLayoutManager());

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mArticleView);
    }

    @Override
    public void onClick(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
