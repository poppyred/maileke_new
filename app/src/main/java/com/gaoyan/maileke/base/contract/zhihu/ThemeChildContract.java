package com.gaoyan.maileke.base.contract.zhihu;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.ThemeChildListBean;

/**
 * Created by codeest on 16/8/24.
 */

public interface ThemeChildContract {

    interface View extends BaseView {

        void showContent(ThemeChildListBean themeChildListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getThemeChildData(int id);

        void insertReadToDB(int id);
    }
}
