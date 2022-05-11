package com.twofaces.dash.di

import android.content.Context
import androidx.room.Room
import com.twofaces.dash.data.db.TaskDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideTaskDatabaseInstance(
        @ApplicationContext context: Context,
        callback: TaskDatabase.RoomCallBack
    ) = Room.databaseBuilder(context, TaskDatabase::class.java, "task_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideTaskDaoInstance(taskDatabase: TaskDatabase) = taskDatabase.getTaskDao()

}
