package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Database access object to access the Inventory database
 */
@Dao
interface ItemDao {

    @Query("select * from item where id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("select * from item order by name asc")
    fun getItems(): Flow<List<Item>>


    // Specify the conflict strategy as IGNORE, when the user tries to add an
    // existing Item into the database.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)
}