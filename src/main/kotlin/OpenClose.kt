/**
 * Open-Closed Principle
 * Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.
 */
class OpenClose {

    class MySqlConnection(val uri: String)

    /* ❌ Violation Example  */
    // Closed to work only with MySqlConnection

    class DataBase {
        private val connection = MySqlConnection("any")

        fun connect() {
            println("Connect to Database using ${connection.uri}")
        }
    }

    open class Connection(val uri: String)

    /* ✅ Correct Example */
    //Now we can inject any Connection we want, It can be MySql, Firebird, Oracle, Sql Server, etc...

    open class DataBase2(private val connection: Connection) {

        fun connect() {
            println("Connect to Database using ${connection.uri}")
        }
    }

}
