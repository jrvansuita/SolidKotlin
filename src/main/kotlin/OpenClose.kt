import model.Connection
import model.MySqlConnection

/**
 * Open-Closed Principle
 * Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.
 */
class OpenClose {

    /* ❌ Violation Example  */
    // Will to work only with MySqlConnection

    class DataBase {
        private val connection = MySqlConnection("any")

        fun connect() = println("Connect to Database using ${connection.uri}")
    }

    /* ✅ Correct Example */
    //Extending and provide any implementation of Connection. It can be MySql, Firebird, Oracle, Sql Server, etc...

    open class DataBase2(private val connection: Connection) {
        fun connect()  = println("Connect to Database using ${connection.uri}")
    }
}
