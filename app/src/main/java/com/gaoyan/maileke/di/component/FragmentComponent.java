package com.gaoyan.maileke.di.component;

import android.app.Activity;

import com.gaoyan.maileke.di.scope.FragmentScope;
import com.gaoyan.maileke.di.module.FragmentModule;
import com.gaoyan.maileke.ui.gank.fragment.GirlFragment;
import com.gaoyan.maileke.ui.gank.fragment.TechFragment;
import com.gaoyan.maileke.ui.gold.fragment.GoldMainFragment;
import com.gaoyan.maileke.ui.gold.fragment.GoldPagerFragment;
import com.gaoyan.maileke.ui.main.fragment.LikeFragment;
import com.gaoyan.maileke.ui.main.fragment.SettingFragment;
import com.gaoyan.maileke.ui.vtex.fragment.VtexPagerFragment;
import com.gaoyan.maileke.ui.wechat.fragment.WechatMainFragment;
import com.gaoyan.maileke.ui.zhihu.fragment.CommentFragment;
import com.gaoyan.maileke.ui.zhihu.fragment.DailyFragment;
import com.gaoyan.maileke.ui.zhihu.fragment.HotFragment;
import com.gaoyan.maileke.ui.zhihu.fragment.SectionFragment;
import com.gaoyan.maileke.ui.zhihu.fragment.ThemeFragment;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(DailyFragment dailyFragment);

    void inject(ThemeFragment themeFragment);

    void inject(SectionFragment sectionFragment);

    void inject(HotFragment hotFragment);

    void inject(CommentFragment longCommentFragment);

    void inject(TechFragment techFragment);

    void inject(GirlFragment girlFragment);

    void inject(LikeFragment likeFragment);

    void inject(WechatMainFragment wechatMainFragment);

    void inject(SettingFragment settingFragment);

    void inject(GoldMainFragment goldMainFragment);

    void inject(GoldPagerFragment goldPagerFragment);

    void inject(VtexPagerFragment vtexPagerFragment);
}
