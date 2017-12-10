package com.gaoyan.maileke.base.contract.zhihu;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.HotListBean;

/**
 * Created by codeest on 16/8/12.
 */

public interface HotContract {

    interface View extends BaseView {

        void showContent(HotListBean hotListBean);
    }

    interface Presenter extends BasePresenter<View> {

        void getHotData();

        void insertReadToDB(int id);

    }
}
