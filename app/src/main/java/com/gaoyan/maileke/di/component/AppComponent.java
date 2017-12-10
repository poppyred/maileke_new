package com.gaoyan.maileke.di.component;

import com.gaoyan.maileke.app.App;
import com.gaoyan.maileke.di.module.AppModule;
import com.gaoyan.maileke.di.module.HttpModule;
import com.gaoyan.maileke.model.DataManager;
import com.gaoyan.maileke.model.db.RealmHelper;
import com.gaoyan.maileke.model.http.RetrofitHelper;
import com.gaoyan.maileke.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
