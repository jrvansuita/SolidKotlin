/**
 * Dependency Inversion Principle
 *
 * Depend upon abstractions, not your own implementation.
 *
 */
class DependencyInversion {

    /* ❌ Violation Example  */
    // The message is being formatted inside send method

    class EmailService {
        fun send(message: String) {
            val formattedMessage = "Email: ${message.uppercase()}"
            println("Sending formatted message: $formattedMessage")
        }
    }

    /* ✅ Correct Example */
    // The message is being formatted outside send method. You just inverted the formatting dependency.

    class EmailService2 {
        fun send(message: String, formatter: (String) -> String) {
            val formattedMessage = formatter.invoke(message)
            println("Sending formatted message: $formattedMessage")
        }
    }
}