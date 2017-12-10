package com.gaoyan.maileke.base.contract.vtex;

import com.gaoyan.maileke.base.BasePresenter;
import com.gaoyan.maileke.base.BaseView;
import com.gaoyan.maileke.model.bean.NodeBean;
import com.gaoyan.maileke.model.bean.NodeListBean;

import java.util.List;

/**
 * Created by codeest on 16/12/23.
 */

public interface NodeContract {

    interface View extends BaseView {

        void showContent(List<NodeListBean> mList);

        void showTopInfo(NodeBean mTopInfo);
    }

    interface Presenter extends BasePresenter<View> {

        void getContent(String node_name);

        void getTopInfo(String node_name);
    }
}
