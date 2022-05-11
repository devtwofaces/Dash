package com.twofaces.dash.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.twofaces.dash.data.TaskRepository
import com.twofaces.dash.data.db.entities.Task
import com.twofaces.dash.data.db.entities.TaskDao
import com.twofaces.dash.di.TaskApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    class RoomCallBack @Inject constructor(
        private val taskRepositoryProvider: Provider<TaskRepository>,
        @TaskApplicationScope private val coroutineScope: CoroutineScope
    ): RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            coroutineScope.launch {
                taskRepositoryProvider.get().deleteAll()
                taskRepositoryProvider.get().insert(Task("Push to Github Repo"))
                taskRepositoryProvider.get().insert(Task("Order Food"))
                taskRepositoryProvider.get().insert(Task("Buy Double mint"))
                taskRepositoryProvider.get().insert(Task("Take a walk!"))
            }
        }

    }

}