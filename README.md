# [Solid](https://simple.wikipedia.org/wiki/SOLID_(object-oriented_design)) Principles using Kotlin

S.O.L.I.D. an acronym of a group of five good principles in object-oriented programming.
Here are some classes I've implemented to study every SOLID principle using Kotlin. 

- **S** ingle Responsibility Principle (known as SRP)
- **O** pen/Closed Principle
- **L** iskov’s Substitution Principle
- **I** nterface Segregation Principle
- **D** ependency Inversion Principle


> *This is my pont-of-view, my understanding about the principles. It's my personal study shared on github.*

-------

### Study

- [**S**ingle Responsibility ](/src/main/kotlin/SingleResponsibility.kt)
```kotlin
//A class should have only one reason to exists and responsible for one thing.
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
```
- [**O**pen–Closed ](/src/main/kotlin/OpenClose.kt)
```kotlin
//Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.
class OpenClose {

    /* ❌ Violation Example  */
    // Will to work only with MySqlConnection

    class DataBase {
        private val connection = MySqlConnection("any")
        
        fun connect() = println("Connect to Database using ${connection.uri}")
    }
    
    /* ✅ Correct Example */
    //Extending and provide any implementation of Connection. It can be MySql, Firebird, Oracle, Sql Server, etc...

    open class DataBase(private val connection: Connection) {
        fun connect()  = println("Connect to Database using ${connection.uri}")
    }
}
```
- [**L**iskov Substitution ](/src/main/kotlin/LiskovSubstitution.kt)
```kotlin
// All classes deriving from the base class should behave in the same manner as the superclass.
// If we decide to replace the base class with the derived one, it should not break the existing functionality.
 class LiskovSubstitution {

    interface Animal {
        fun walk()
        fun fly()
    }

    /* ❌ Violation Example  */
    //Dog and Goose are animals, but Dog can't fly! Will break fly implementation.

    class Dog : Animal {
        override fun walk() = println("The dog is walking")
        override fun fly() = throw RuntimeException("The dog is not able to fly!")
    }

    class Goose : Animal {
        override fun walk() = println("The goose is walking")
        override fun fly() = println("The goose is flying")
    }

    /* ✅ Correct Example */
    //Cat is not a fowl, so it doesn't fly. Won't break fly implementation.

    interface Animals {
        fun walk()
    }

    interface Fowls : Animals {
        fun fly()
    }

    class Cat : Animals {
        override fun walk() = println("The cat is walking")
    }

    class Duck : Fowls {
        override fun walk() = println("The duck is walking")
        override fun fly() = println("The duck is flying")
    }
}
 ```
 - [**I**nterface Segregation ](/src/main/kotlin/InterfaceSegregation.kt)
 ```kotlin
 //Many client-specific interfaces are better than one general-purpose interface
 
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
 ```
  - [**D**ependency Inversion  ](/src/main/kotlin/DependencyInversion.kt)
```kotlin
//Depend upon abstractions, not your own implementation.
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

    class EmailService {
        fun send(message: String, formatter: (String) -> String) {
            val formattedMessage = formatter.invoke(message)
            println("Sending formatted message: $formattedMessage")
        }
    }
}
```


### References
- Raj Suvariya [@medium.com](https://medium.com/mindorks/solid-principles-explained-with-examples-79d1ce114ace)
- Vijay Mishra [@medium.com](https://medium.com/the-android-caf%C3%A9/solid-principles-the-kotlin-way-ff717c0d60da)
- Samuel Oloruntoba [@digitalocean.com/community](https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design)


  
  
