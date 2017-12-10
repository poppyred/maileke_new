package com.gaoyan.maileke.base.contract.gank;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.GankItemBean;

import java.util.List;

/**
 * Created by codeest on 16/8/19.
 */

public interface GirlContract {

    interface View extends BaseView {

        void showContent(List<GankItemBean> list);

        void showMoreContent(List<GankItemBean> list);
    }

    interface Presenter extends BasePresenter<View> {

        void getGirlData();

        void getMoreGirlData();

    }
}
