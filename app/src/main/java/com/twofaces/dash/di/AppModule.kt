package com.twofaces.dash.di

import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @TaskApplicationScope
    @Provides
    @Singleton
    fun providesCoroutineScope() = CoroutineScope(SupervisorJob() + Dispatchers.IO)

}


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class TaskApplicationScope
