import java.util.*

fun main () {
    //testStudents()
    //testTeachers()

    testSubjects()
}


private fun testStudents() {
    Student().printTestStudentsData()
}

private fun testTeachers() {
    Teacher().printTestTeacherData()
}


private fun testSubjects() {
    val students = listOf(Student("David"),
                          Student("Óliver"),
                          Student("Ángel"),
                          Student("Sara"),
                          Student("María"),
                          Student("Miguel"),
                          Student("Luis"),
                          Student("Juan"),
                          Student("Marta"),
                          Student("Lucia"))

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

    val subjects = listOf(Subject("iOS",
                                  Date(),
                                  listOf(teachers.random()),
                                  students.filter { it.name?.contains("a", true) ?: false }),
                          Subject("Android",
                                  Date(),
                                  listOf(teachers.random()),
                                  students.filter { it.name?.contains("e", true) ?: false }),
                          Subject("Java",
                                  Date(),
                                  listOf(teachers.random()),
                                  students.filter { it.name?.contains("i", true) ?: false }),
                          Subject("Bases de datos",
                                  Date(),
                                  listOf(teachers.random()),
                                  students.filter { it.name?.contains("i", true) ?: false }),
                          Subject("Web",
                                  Date(),
                                  listOf(teachers.random()),
                                  students.filter { it.name?.contains("u", true) ?: false }))

    println(subjects.map { it.name })
    println()

    // Print:
    // Student Name
    // Student subjects count
    // Student subjects name
    students.forEach { student ->
        println("Student: ${student.name}")

        subjects.filter { subject ->
            subject.students.contains(student)
        }.apply {
            println("Total Subjects: ${count()}")
            println("Subjects: ${map { it.name }}")
            println()
        }
    }

    // Print:
    // Teacher Name
    // Teacher subjects count
    // Teacher subjects name
    teachers.forEach { teacher ->
        println("Teacher: ${teacher.name}")

        subjects.filter { subject ->
            subject.teachers.contains(teacher)
        }.apply {
            println("Total Subjects: ${count()}")
            println("Subjects: ${map { it.name }}")
            println()
        }
    }

    // Print:
    // Teacher Name
    // Teacher students count
    // Teacher students name
    teachers.forEach { teacher ->
        println("Teacher: ${teacher.name}")

        subjects.filter { subject ->
            subject.teachers.contains(teacher)
        }.apply {
            val studentsTeacher = students.mapNotNull { student ->
               when (any { it.students.contains(student) }) {
                   true -> student
                   else -> null
               }
            }

            println("Total Students: ${studentsTeacher.count()}")
            println("Students: ${studentsTeacher.map { it.name }}")
            println()
        }
    }

    // Print:
    // Subject Name
    // Subject students count
    // Subject students name
    subjects.forEach { subject ->
        println("Subject: ${subject.name}")
        println("Total Students: ${subject.students.count()}")
        println("Students: ${subject.students.map { it.name }}")
        println()
    }

    // Print:
    // Subject Name
    // Subject teacher count
    // Subject teacher name
    subjects.forEach { subject ->
        println("Subject: ${subject.name}")
        println("Total Teachers: ${subject.teachers.count()}")
        println("Teachers: ${subject.teachers.map { it.name }}")
        println()
    }

    // Print:
    // 1.- Subjects with same number of Students
    subjects.mapNotNull { subject ->
        subjects.filter { (it.students.count() == subject.students.count()) && (it.name != subject.name) }
    }.apply {
        val subjectsName = mapNotNull {
            it.joinToString {  subject ->
                subject.name
            }.run {
                if (!isNullOrBlank()) this else null
            }
        }

        println("Subjects with same number of Students: $subjectsName")
        println()
    }

    // 2.- Students in more that one Subject
    students.mapNotNull { student ->
        val subjectsStudent = subjects.filter { it.students.contains(student) }
        if (subjectsStudent.count() > 1) {
            student.name
        }
        else {
            null
        }
    }.apply {
        println("Students in more that one Subject: $this")
        println()
    }

    // 3.- Teacher in more that one Subject
    teachers.mapNotNull { teacher ->
        val subjectsTeacher = subjects.filter { it.teachers.contains(teacher) }
        if (subjectsTeacher.count() > 1) {
            teacher.name
        }
        else {
            null
        }
    }.apply {
        println("Teacher in more that one Subject: $this")
        println()
    }

    // 4.- Students with same Teacher in different Subjects


    // 5.- Teacher with same Students in different Subjects


}












/*subjects.mapNotNull { subject ->
    subjects.filter { (it.students.count() == subject.students.count()) && (it.name != subject.name) }
}.apply {
    println("Asignaturas con mismo número de estudiantes: $this")
}*/
