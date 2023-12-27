package com.berktavli.contactsapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "persons")
data class Persons(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id") @NotNull var person_id: Int,
    @ColumnInfo(name = "person_name") @NotNull var person_name: String,
    @ColumnInfo(name = "person_phone") @NotNull var person_phone: String
) : Serializable {
}


//Kotlin'de "data class" veri sınıfları oluşturmak için kullanılırken,
//"Serializable" arayüzü, nesnelerin serileştirilip (veri akışına veya disk üzerine yazılabilir hale getirilip) saklanmasına veya iletilmesine olanak tanır.