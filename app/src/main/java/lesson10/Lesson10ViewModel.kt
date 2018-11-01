package lesson10

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.bumptech.glide.Glide
import android.databinding.BindingAdapter
import android.widget.ImageView

class Lesson10ViewModel(val key: String) : ViewModel() {
    private lateinit var person: Lesson10UserProfileDto
    val name = ObservableField<String>()
    val surname = ObservableField<String>()
    val age = ObservableField<String>()
    val gender = ObservableField<String>()
    val image = ObservableField<String>()

    init {
        when (key) {
            Lesson10Fragment.MALE_ID -> {
                person = getMaleData()
                name.set(person.name)
                surname.set(person.surname)
                age.set(person.age.toString())
                gender.set(getGenderByID(person.gender))
                image.set(person.image)
            }
            Lesson10Fragment.FEMALE_ID -> {
                person = getFemaleData()
                name.set(person.name)
                surname.set(person.surname)
                age.set(person.age.toString())
                gender.set(getGenderByID(person.gender))
                image.set(person.image)
            }
        }
    }

    //var imageUrl = image.get()//"https://files.adme.ru/files/news/part_78/786110/9719810-0_ecec6_5ae1203e_XXXL-650-32e9147584-1484579097.jpg"

    companion object {
        @BindingAdapter("bind:src")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) {
            if (imageUrl == null) {
                //view.setImageURI(null)
            } else {
                Glide.with(view).load(imageUrl).into(view)
//                Glide.with(view.context)
//                        .load(imageUrl)
//                        .into(view)
//            view.setImageURI(Uri.parse(imageUri))
            }
        }
    }


    fun getMaleData() = Lesson10UserProfileDto("Max", "Jonson", 17, Lesson10Gender.MALE, "https://avatars.mds.yandex.net/get-pdb/776003/0557429a-131d-497b-af40-d4417d60323c/s1200")
    fun getFemaleData() = Lesson10UserProfileDto("Mary", "Parker", 20, Lesson10Gender.FEMALE, "https://files.adme.ru/files/news/part_78/786110/9719810-0_ecec6_5ae1203e_XXXL-650-32e9147584-1484579097.jpg")

    data class Lesson10UserProfileDto(
            var name: String,
            var surname: String,
            var age: Int,
            var gender: Lesson10Gender,
            var image: String
    )

    enum class Lesson10Gender {
        MALE,
        FEMALE
    }

    fun getGenderByID(gender: Lesson10Gender) = when (gender) {
        Lesson10Gender.MALE -> "Male"
        Lesson10Gender.FEMALE -> "Female"
    }
}