package com.gaoyan.maileke.base.contract.zhihu;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.SectionListBean;

/**
 * Created by codeest on 16/8/12.
 */

public interface SectionContract {

    interface View extends BaseView {

        void showContent(SectionListBean sectionListBean);

    }

    interface Presenter extends BasePresenter<View> {

        void getSectionData();
    }
}
