package com.berktavli.contactsapp.data.entity

import java.io.Serializable

data class Persons(var person_id : Int , var person_name : String, var person_phone : String ) : Serializable {
}


//Kotlin'de "data class" veri sınıfları oluşturmak için kullanılırken,
//"Serializable" arayüzü, nesnelerin serileştirilip (veri akışına veya disk üzerine yazılabilir hale getirilip) saklanmasına veya iletilmesine olanak tanır.