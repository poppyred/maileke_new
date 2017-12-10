package com.gaoyan.maileke.presenter.zhihu;

import com.gaoyan.maileke.base.RxPresenter;
import com.gaoyan.maileke.model.DataManager;
import com.gaoyan.maileke.model.bean.SectionChildListBean;
import com.gaoyan.maileke.base.contract.zhihu.SectionChildContract;
import com.gaoyan.maileke.util.RxUtil;
import com.gaoyan.maileke.widget.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;

/**
 * Created by codeest on 16/8/28.
 */

public class SectionChildPresenter extends RxPresenter<SectionChildContract.View> implements SectionChildContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public SectionChildPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getThemeChildData(int id) {
        addSubscribe(mDataManager.fetchSectionChildListInfo(id)
                .compose(RxUtil.<SectionChildListBean>rxSchedulerHelper())
                .map(new Function<SectionChildListBean, SectionChildListBean>() {
                    @Override
                    public SectionChildListBean apply(SectionChildListBean sectionChildListBean) {
                        List<SectionChildListBean.StoriesBean> list = sectionChildListBean.getStories();
                        for(SectionChildListBean.StoriesBean item : list) {
                            item.setReadState(mDataManager.queryNewsId(item.getId()));
                        }
                        return sectionChildListBean;
                    }
                })
                .subscribeWith(new CommonSubscriber<SectionChildListBean>(mView) {
                    @Override
                    public void onNext(SectionChildListBean sectionChildListBean) {
                        mView.showContent(sectionChildListBean);
                    }
                })
        );
    }

    @Override
    public void insertReadToDB(int id) {
        mDataManager.insertNewsId(id);
    }
}
