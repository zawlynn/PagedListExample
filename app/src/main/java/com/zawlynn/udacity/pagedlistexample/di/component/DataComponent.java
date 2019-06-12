package com.zawlynn.udacity.pagedlistexample.di.component;

import com.zawlynn.udacity.pagedlistexample.di.module.ApplicationContextModule;
import com.zawlynn.udacity.pagedlistexample.di.module.RetrofitModule;
import com.zawlynn.udacity.pagedlistexample.di.module.RoomModule;
import com.zawlynn.udacity.pagedlistexample.ui.main.viewmodel.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationContextModule.class, RoomModule.class, RetrofitModule.class})
public interface DataComponent {
    void inject(MainActivityViewModel viewModel);
}
