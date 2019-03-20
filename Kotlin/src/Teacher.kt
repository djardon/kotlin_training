
// Enum declaration
enum class TeacherType {
    INTERN, EXTERN
}

// Extension fun of TeacherType
fun TeacherType.salary() = when (this) {
    TeacherType.INTERN -> {
        1_800
    }

    TeacherType.EXTERN -> {
        2_000
    }
}

// Class Teacher
class Teacher(val name: String? = null,
              val surname: String? = null,
              val email: String? = null,
              val type: TeacherType = TeacherType.EXTERN) {

    fun printTestTeacherData() {
        // Create default teacher list
        val teachers = listOf(Teacher("David",
                                      "Jardón",
                                      "d.jardon@gmail.com",
                                      TeacherType.EXTERN),
                              Teacher("Jaime",
                                      type = TeacherType.INTERN),
                              Teacher("Pedro",
                                      type = TeacherType.INTERN),
                              Teacher("Dani",
                                      type = TeacherType.INTERN),
                              Teacher("Sergio",
                                      type = TeacherType.EXTERN),
                              Teacher("Carlos",
                                      type = TeacherType.EXTERN))

        // Print teacher with 2000 up salary
        println(teachers.mapNotNull {
            if (it.type.salary() >= 2_000) {
                it.name
            }
            else {
                null
            }
        })
    }
}