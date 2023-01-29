package com.andes.metamon.utils

import android.content.SharedPreferences
import com.andes.navigator.MainNavigator
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

sealed interface Injector {
    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface MainNavigatorInjector {
        fun mainNavigator(): MainNavigator
    }

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface SharedPreferencesInjector {
        fun sharedPreferences(): SharedPreferences
    }
}