package com.gaoyan.maileke.base.contract.main;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.VersionBean;

/**
 * Created by codeest on 16/10/17.
 */

public interface SettingContract {

    interface View extends BaseView {

        void showUpdateDialog(VersionBean bean);

    }

    interface  Presenter extends BasePresenter<SettingContract.View> {

        void checkVersion(String currentVersion);

        void setNightModeState(boolean b);

        void setNoImageState(boolean b);

        void setAutoCacheState(boolean b);

        boolean getNightModeState();

        boolean getNoImageState();

        boolean getAutoCacheState();
    }
}
