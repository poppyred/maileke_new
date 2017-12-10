package com.gaoyan.maileke.model.http;

import com.gaoyan.maileke.model.bean.CommentBean;
import com.gaoyan.maileke.model.bean.DailyBeforeListBean;
import com.gaoyan.maileke.model.bean.DailyListBean;
import com.gaoyan.maileke.model.bean.DetailExtraBean;
import com.gaoyan.maileke.model.bean.GankItemBean;
import com.gaoyan.maileke.model.bean.GankSearchItemBean;
import com.gaoyan.maileke.model.bean.GoldListBean;
import com.gaoyan.maileke.model.bean.HotListBean;
import com.gaoyan.maileke.model.bean.NodeBean;
import com.gaoyan.maileke.model.bean.NodeListBean;
import com.gaoyan.maileke.model.bean.RepliesListBean;
import com.gaoyan.maileke.model.bean.SectionChildListBean;
import com.gaoyan.maileke.model.bean.SectionListBean;
import com.gaoyan.maileke.model.bean.ThemeChildListBean;
import com.gaoyan.maileke.model.bean.ThemeListBean;
import com.gaoyan.maileke.model.bean.VersionBean;
import com.gaoyan.maileke.model.bean.WXItemBean;
import com.gaoyan.maileke.model.bean.WelcomeBean;
import com.gaoyan.maileke.model.bean.ZhihuDetailBean;
import com.gaoyan.maileke.model.http.response.GankHttpResponse;
import com.gaoyan.maileke.model.http.response.GoldHttpResponse;
import com.gaoyan.maileke.model.http.response.MyHttpResponse;
import com.gaoyan.maileke.model.http.response.WXHttpResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper {

    Flowable<DailyListBean> fetchDailyListInfo();

    Flowable<DailyBeforeListBean> fetchDailyBeforeListInfo(String date);

    Flowable<ThemeListBean> fetchDailyThemeListInfo();

    Flowable<ThemeChildListBean> fetchThemeChildListInfo(int id);

    Flowable<SectionListBean> fetchSectionListInfo();

    Flowable<SectionChildListBean> fetchSectionChildListInfo(int id);

    Flowable<ZhihuDetailBean> fetchDetailInfo(int id);

    Flowable<DetailExtraBean> fetchDetailExtraInfo(int id);

    Flowable<WelcomeBean> fetchWelcomeInfo(String res);

    Flowable<CommentBean> fetchLongCommentInfo(int id);

    Flowable<CommentBean> fetchShortCommentInfo(int id);

    Flowable<HotListBean> fetchHotListInfo();

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page);

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page);

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num);

    Flowable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query, String type, int num, int page);

    Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page);

    Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word);

    Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo();

    Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldList(String type, int num, int page);

    Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldHotList(String type, String dataTime, int limit);

    Flowable<NodeBean> fetchNodeInfo(String name);

    Flowable<List<NodeListBean>> fetchTopicList(String name);

    Flowable<List<NodeListBean>> fetchTopicInfo(String id);

    Flowable<List<RepliesListBean>> fetchRepliesList(String id);
}
