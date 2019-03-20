
/* **** JAVA sample *****
class FirsSamples {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
*/

// Properties declaration
private var mUserName = ""
private var mUserSurname: String? = null

private val mUserNames = listOf("David", "Juan", "Luis", "Lucia", "Paula", "Óliver", "Claudia")


fun main() {
    initUser("Juan",
             "Garcia")

    //printUser()
    printUserNames()
}


private fun initUser(name: String = "David", surname: String? = null) {
    mUserName = name
    mUserSurname = surname
}

private fun printUser() {
    val message = if (mUserSurname?.length ?: 0 > 0) {
        // mUserSurname not null and length > 0
        // (mUserSurname?.length ?: 0) > 0
        "$mUserName $mUserSurname"
    }
    else {
        // mUserSurname is null or length = 0
        mUserName
    }

    println("Hello, $message!")
}

private fun printUserNames() {
    mUserNames.forEachIndexed { index, name ->
        println("$index $name")
    }

    println(mUserNames.first { name ->
        name.startsWith("l", true) })

    println(mUserNames.count { it.contains("l", true) })

    println(mUserNames.all { it.startsWith("l", true) })

    println(mUserNames.any { it.startsWith("l", true) })

    println(mUserNames.filter { it.contains("l", true) })

    println(mUserNames.sortedBy { it.length })

    println(mUserNames.map { it.length })
}