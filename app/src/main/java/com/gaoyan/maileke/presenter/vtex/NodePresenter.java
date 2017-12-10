package com.gaoyan.maileke.presenter.vtex;

import com.gaoyan.maileke.base.RxPresenter;
import com.gaoyan.maileke.model.DataManager;
import com.gaoyan.maileke.model.bean.NodeBean;
import com.gaoyan.maileke.model.bean.NodeListBean;
import com.gaoyan.maileke.base.contract.vtex.NodeContract;
import com.gaoyan.maileke.util.RxUtil;
import com.gaoyan.maileke.widget.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by codeest on 16/12/23.
 */

public class NodePresenter extends RxPresenter<NodeContract.View> implements NodeContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public NodePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getContent(String node_name) {
        addSubscribe(mDataManager.fetchTopicList(node_name)
                .compose(RxUtil.<List<NodeListBean>>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<List<NodeListBean>>(mView) {
                    @Override
                    public void onNext(List<NodeListBean> nodeListBeen) {
                        mView.showContent(nodeListBeen);
                    }
                })
        );
    }

    @Override
    public void getTopInfo(String node_name) {
        addSubscribe(mDataManager.fetchNodeInfo(node_name)
                .compose(RxUtil.<NodeBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<NodeBean>(mView, false) {
                    @Override
                    public void onNext(NodeBean nodeBean) {
                        mView.showTopInfo(nodeBean);
                    }
                })
        );
    }
}
