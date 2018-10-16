package lesson7

import com.google.gson.annotations.SerializedName

data class Owl(
        @SerializedName("picture")
        var pic: String,
        var name: String,
        var age: Int
)