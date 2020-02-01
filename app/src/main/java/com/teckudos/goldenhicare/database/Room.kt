package com.teckudos.goldenhicare.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CategoryDao {

    @Query("select * from category")
    fun getVideos(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg videos: Category)
}

@Database(entities = [Category::class], version = 1, exportSchema = false)
abstract class GoldenHicareDatabase : RoomDatabase() {

    abstract val categoryDao: CategoryDao

    companion object {

        @Volatile
        private var INSTANCE: GoldenHicareDatabase? = null

        fun getInstance(context: Context): GoldenHicareDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GoldenHicareDatabase::class.java,
                        "golden_hicare_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

