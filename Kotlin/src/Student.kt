
// Extension fun of Student
fun Student.printAge() = "${this.age ?: 0} years"


// Class Student
class Student(val name: String? = null,
              val surname: String? = null,
              val age: Int? = null,
              val phone: String? = null,
              val address: String? = null) {
    // Properties
    /*
    private var surname: String? = null
    private var age: Int = 0
    private var phone: String? = ""
    private var address: String? = ""
    */

    private val mStudentsNames = listOf(null, "David", "Juan", "Luis", null, "Lucia", "Paula", "Óliver", "Claudia")


    fun printTestStudentsData() {
        println(mStudentsNames.map { it })
        println(mStudentsNames.mapNotNull { it })

        val students = mStudentsNames.map {
            mapStudentName(it)
        }

        // Return Students count with available phone
        println(students.count { !it.phone.isNullOrBlank() })

        //println(students.filter { it.name?.contains("a", true) ?: false }.map { it.name })
        println(students.mapNotNull {
            /*
            if (it.name?.contains("a", true) == true) {
                it.name
            }
            else {
                null
            }
            */

            when(it.name?.contains("a", true)) {
                true -> {
                    it.name
                }

                else -> {
                    null
                }
            }
        })
    }

    private fun mapStudentName(name: String?) = name?.let {
        Student(it)
    } ?: run {
        val student = Student("Ángel", phone = "666666666")
        print(student)
        student
    }


    private fun getAge() = printAge()

}









