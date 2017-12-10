package com.gaoyan.maileke.di.component;

import android.app.Activity;

import com.gaoyan.maileke.di.scope.ActivityScope;
import com.gaoyan.maileke.di.module.ActivityModule;
import com.gaoyan.maileke.ui.main.activity.MainActivity;
import com.gaoyan.maileke.ui.main.activity.WelcomeActivity;
import com.gaoyan.maileke.ui.vtex.activity.NodeListActivity;
import com.gaoyan.maileke.ui.vtex.activity.RepliesActivity;
import com.gaoyan.maileke.ui.zhihu.activity.SectionActivity;
import com.gaoyan.maileke.ui.zhihu.activity.ThemeActivity;
import com.gaoyan.maileke.ui.zhihu.activity.ZhihuDetailActivity;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);

    void inject(ZhihuDetailActivity zhihuDetailActivity);

    void inject(ThemeActivity themeActivity);

    void inject(SectionActivity sectionActivity);

    void inject(RepliesActivity repliesActivity);

    void inject(NodeListActivity nodeListActivity);
}
