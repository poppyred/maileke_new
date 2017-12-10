package com.gaoyan.maileke.presenter.zhihu;

import com.gaoyan.maileke.base.RxPresenter;
import com.gaoyan.maileke.model.DataManager;
import com.gaoyan.maileke.model.bean.SectionListBean;
import com.gaoyan.maileke.base.contract.zhihu.SectionContract;
import com.gaoyan.maileke.util.RxUtil;
import com.gaoyan.maileke.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by codeest on 16/8/12.
 */

public class SectionPresenter extends RxPresenter<SectionContract.View> implements SectionContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public SectionPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getSectionData() {
        addSubscribe(mDataManager.fetchSectionListInfo()
                .compose(RxUtil.<SectionListBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<SectionListBean>(mView) {
                    @Override
                    public void onNext(SectionListBean sectionListBean) {
                        mView.showContent(sectionListBean);
                    }
                })
        );
    }
}
