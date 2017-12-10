package com.gaoyan.maileke.ui.zhihu.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gaoyan.maileke.R;
import com.gaoyan.maileke.base.RootFragment;
import com.gaoyan.maileke.model.bean.CommentBean;
import com.gaoyan.maileke.presenter.zhihu.CommentPresenter;
import com.gaoyan.maileke.base.contract.zhihu.CommentContract;
import com.gaoyan.maileke.ui.zhihu.adapter.CommentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by codeest on 16/8/18.
 */

public class CommentFragment extends RootFragment<CommentPresenter> implements CommentContract.View {

    @BindView(R.id.view_main)
    RecyclerView rvCommentList;

    CommentAdapter mAdapter;
    List<CommentBean.CommentsBean> mList;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_comment;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        Bundle bundle = getArguments();
        stateLoading();
        mPresenter.getCommentData(bundle.getInt("id"),bundle.getInt("kind"));
        rvCommentList.setVisibility(View.INVISIBLE);
        mList = new ArrayList<>();
        mAdapter = new CommentAdapter(mContext,mList);
        rvCommentList.setLayoutManager(new LinearLayoutManager(mContext));
        rvCommentList.setAdapter(mAdapter);
    }

    @Override
    public void showContent(CommentBean commentBean) {
        rvCommentList.setVisibility(View.VISIBLE);
        mList.clear();
        mList.addAll(commentBean.getComments());
        mAdapter.notifyDataSetChanged();
    }
}
