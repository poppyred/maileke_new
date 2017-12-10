package com.gaoyan.maileke.presenter.zhihu;

import com.gaoyan.maileke.app.Constants;
import com.gaoyan.maileke.base.RxPresenter;
import com.gaoyan.maileke.model.DataManager;
import com.gaoyan.maileke.model.bean.DetailExtraBean;
import com.gaoyan.maileke.model.bean.RealmLikeBean;
import com.gaoyan.maileke.model.bean.ZhihuDetailBean;
import com.gaoyan.maileke.base.contract.zhihu.ZhihuDetailContract;
import com.gaoyan.maileke.util.RxUtil;
import com.gaoyan.maileke.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by codeest on 16/8/13.
 */

public class ZhihuDetailPresenter extends RxPresenter<ZhihuDetailContract.View> implements ZhihuDetailContract.Presenter{

    private DataManager mDataManager;
    private ZhihuDetailBean mData;

    @Inject
    public ZhihuDetailPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getDetailData(int id) {
        addSubscribe(mDataManager.fetchDetailInfo(id)
                .compose(RxUtil.<ZhihuDetailBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<ZhihuDetailBean>(mView) {
                    @Override
                    public void onNext(ZhihuDetailBean zhihuDetailBean) {
                        mData = zhihuDetailBean;
                        mView.showContent(zhihuDetailBean);
                    }
                })
        );
    }

    @Override
    public void getExtraData(int id) {
        addSubscribe(mDataManager.fetchDetailExtraInfo(id)
                .compose(RxUtil.<DetailExtraBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<DetailExtraBean>(mView, "加载额外信息失败ヽ(≧Д≦)ノ") {
                    @Override
                    public void onNext(DetailExtraBean detailExtraBean) {
                        mView.showExtraInfo(detailExtraBean);
                    }
                })
        );
    }

    @Override
    public void insertLikeData() {
        if (mData != null) {
            RealmLikeBean bean = new RealmLikeBean();
            bean.setId(String.valueOf(mData.getId()));
            bean.setImage(mData.getImage());
            bean.setTitle(mData.getTitle());
            bean.setType(Constants.TYPE_ZHIHU);
            bean.setTime(System.currentTimeMillis());
            mDataManager.insertLikeBean(bean);
        } else {
            mView.showErrorMsg("操作失败");
        }
    }

    @Override
    public void deleteLikeData() {
        if (mData != null) {
            mDataManager.deleteLikeBean(String.valueOf(mData.getId()));
        } else {
            mView.showErrorMsg("操作失败");
        }
    }

    @Override
    public void queryLikeData(int id) {
        mView.setLikeButtonState(mDataManager.queryLikeId(String.valueOf(id)));
    }

    @Override
    public boolean getNoImageState() {
        return mDataManager.getNoImageState();
    }

    @Override
    public boolean getAutoCacheState() {
        return mDataManager.getAutoCacheState();
    }
}
