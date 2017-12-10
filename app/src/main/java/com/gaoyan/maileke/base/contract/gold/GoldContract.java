package com.gaoyan.maileke.base.contract.gold;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.GoldListBean;

import java.util.List;

/**
 * Created by codeest on 16/11/27.
 */

public interface GoldContract {

    interface View extends BaseView {

        void showContent(List<GoldListBean> goldListBean);

        void showMoreContent(List<GoldListBean> goldMoreListBean, int start, int end);
    }

    interface Presenter extends BasePresenter<View> {

        void getGoldData(String type);

        void getMoreGoldData();
    }
}
