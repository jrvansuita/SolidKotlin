/**
 * Interface Segregation Principle
 *
 *  Many client-specific interfaces are better than one general-purpose interface
 *
 */

class InterfaceSegregation {

    /* ❌ Violation Example  */
    // An interface that handles a lot of responsibility is a violation of this principle

    interface Database {
        fun insert()
        fun update()
        fun updateById()
        fun delete()
        fun select()
        fun selectAll()
        fun selectById()
    }

    /* ✅ Correct Example */
    // Break this interface as much as need to distinct all the purposes

    interface ReadDatabase {
        fun select()
        fun selectAll()
        fun selectById()
    }

    interface WriteDatabase {
        fun insert()
        fun update()
        fun updateById()
        fun delete()
    }
}