package com.gaoyan.maileke.base.contract.main;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.WelcomeBean;

/**
 * Created by codeest on 16/8/15.
 */

public interface WelcomeContract {

    interface View extends BaseView {

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}
