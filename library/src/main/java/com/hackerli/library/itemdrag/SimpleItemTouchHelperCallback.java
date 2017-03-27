package com.hackerli.library.itemdrag;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.hackerli.library.ArticleAdapter;

/**
 * Created by CoXier on 17-3-27.
 */

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private static final String TAG = "TouchHelperCallback";

    private ArticleAdapter mAdapter;

    public SimpleItemTouchHelperCallback(ArticleAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.DOWN | ItemTouchHelper.UP|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Log.d(TAG,"onMove");
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }
}
