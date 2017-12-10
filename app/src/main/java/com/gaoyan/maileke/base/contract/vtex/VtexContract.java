package com.gaoyan.maileke.base.contract.vtex;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.TopicListBean;

import java.util.List;

/**
 * Created by codeest on 16/12/23.
 */

public interface VtexContract {

    interface View extends BaseView {

        void showContent(List<TopicListBean> mList);

    }

    interface Presenter extends BasePresenter<View> {

        void getContent(String type);

    }
}
