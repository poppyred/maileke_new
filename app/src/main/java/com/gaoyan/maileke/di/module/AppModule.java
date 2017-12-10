package com.gaoyan.maileke.di.module;

import com.gaoyan.maileke.app.App;
import com.gaoyan.maileke.model.DataManager;
import com.gaoyan.maileke.model.db.DBHelper;
import com.gaoyan.maileke.model.db.RealmHelper;
import com.gaoyan.maileke.model.http.HttpHelper;
import com.gaoyan.maileke.model.http.RetrofitHelper;
import com.gaoyan.maileke.model.prefs.ImplPreferencesHelper;
import com.gaoyan.maileke.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DBHelper DBHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, DBHelper, preferencesHelper);
    }
}
