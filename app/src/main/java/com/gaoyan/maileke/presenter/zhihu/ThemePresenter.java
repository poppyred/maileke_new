package com.gaoyan.maileke.presenter.zhihu;

import com.gaoyan.maileke.base.RxPresenter;
import com.gaoyan.maileke.model.DataManager;
import com.gaoyan.maileke.model.bean.ThemeListBean;
import com.gaoyan.maileke.base.contract.zhihu.ThemeContract;
import com.gaoyan.maileke.util.RxUtil;
import com.gaoyan.maileke.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * Created by codeest on 16/8/12.
 */

public class ThemePresenter extends RxPresenter<ThemeContract.View> implements ThemeContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public ThemePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getThemeData() {
        mDataManager.fetchDailyThemeListInfo()
                .compose(RxUtil.<ThemeListBean>rxSchedulerHelper())
                .subscribe(new CommonSubscriber<ThemeListBean>(mView) {
                    @Override
                    public void onNext(ThemeListBean themeListBean) {
                        mView.showContent(themeListBean);
                    }
                });
    }
}
