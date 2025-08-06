package org.woxtube.woxtube.testUtil

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertSame
import org.woxtube.woxtube.WoxTubeDatabase
import org.woxtube.woxtube.database.AppDatabase

class TestDatabase {
    companion object {
        fun createReplacingWoxTubeDatabase(): AppDatabase {
            val database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                AppDatabase::class.java
            )
                .allowMainThreadQueries()
                .build()

            val databaseField = WoxTubeDatabase::class.java.getDeclaredField("databaseInstance")
            databaseField.isAccessible = true
            databaseField.set(WoxTubeDatabase::class, database)

            assertSame(
                "Mocking database failed!",
                database,
                WoxTubeDatabase.getInstance(ApplicationProvider.getApplicationContext())
            )

            return database
        }
    }
}
