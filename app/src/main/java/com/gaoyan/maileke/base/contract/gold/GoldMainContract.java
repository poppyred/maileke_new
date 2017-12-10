package com.gaoyan.maileke.base.contract.gold;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.GoldManagerBean;
import com.gaoyan.maileke.model.bean.GoldManagerItemBean;

import java.util.List;

/**
 * Created by codeest on 16/11/28.
 */

public interface GoldMainContract {

    interface View extends BaseView {

        void updateTab(List<GoldManagerItemBean> mList);

        void jumpToManager(GoldManagerBean mBean);
    }

    interface Presenter extends BasePresenter<View> {

        void initManagerList();

        void setManagerList();
    }
}
