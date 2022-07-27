import model.User

/**
 * Single-Responsibility Principle
 * A class should have only one reason to exists and responsible for one thing.
 */
class SingleResponsibility {

    /* ❌ Violation Example  */
    //This class handles way too much

    class SessionHandler {
        fun startSession(user: User) = println("Starting ${user.name} session with ${user.id} id.")

        fun activateUserAccount(user: User) = println("Activating ${user.name}.")

        fun checkAccessRights(user: User) = println("Checking ${user.name} access.")
    }

    /* ✅ Correct Example */
    //Now we can clearly see that each class is responsible for exactly one thing

    class Session {
        fun start(user: User) = println("Starting ${user.name} session with ${user.id} id.")
    }

    class UserAccount {
        fun activate(user: User)  = println("Activating ${user.name}.")
    }

    class AccessRights {
        fun check(user: User) = println("Checking ${user.name} access.")
    }
}