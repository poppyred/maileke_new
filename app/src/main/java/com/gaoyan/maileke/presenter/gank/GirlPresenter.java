package com.gaoyan.maileke.presenter.gank;

import com.gaoyan.maileke.base.RxPresenter;
import com.gaoyan.maileke.model.DataManager;
import com.gaoyan.maileke.model.bean.GankItemBean;
import com.gaoyan.maileke.model.http.response.GankHttpResponse;
import com.gaoyan.maileke.base.contract.gank.GirlContract;
import com.gaoyan.maileke.util.RxUtil;
import com.gaoyan.maileke.widget.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by codeest on 16/8/19.
 */

public class GirlPresenter extends RxPresenter<GirlContract.View> implements GirlContract.Presenter{

    private DataManager mDataManager;

    public static final int NUM_OF_PAGE = 20;

    private int currentPage = 1;

    @Inject
    public GirlPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getGirlData() {
        currentPage = 1;
        addSubscribe(mDataManager.fetchGirlList(NUM_OF_PAGE,currentPage)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(mView) {
                    @Override
                    public void onNext(List<GankItemBean> gankItemBeen) {
                        mView.showContent(gankItemBeen);
                    }
                })
        );
    }

    @Override
    public void getMoreGirlData() {
        addSubscribe(mDataManager.fetchGirlList(NUM_OF_PAGE,++currentPage)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(mView, false) {
                    @Override
                    public void onNext(List<GankItemBean> gankItemBeen) {
                        mView.showMoreContent(gankItemBeen);
                    }
                })
        );
    }
}
