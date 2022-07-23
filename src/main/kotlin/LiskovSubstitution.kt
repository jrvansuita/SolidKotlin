/**
 * Liskov Substitution Principle
 *
 * All classes deriving from the base class should behave in the same manner as the superclass.
 * If we decide to replace the base class with the derived one, it should not break the existing functionality.
 *
 */
class LiskovSubstitution {

    interface Animal {
        fun walk()
        fun fly()
    }

    /* ❌ Violation Example  */
    //Dog and Duck are animals, but Dog can't fly! You shouldn't break fly implementation this way.

    class Dog : Animal {
        override fun walk() = println("The dog is walking")
        override fun fly() = throw RuntimeException("The dog is not able to fly!")
    }

    class Goose : Animal {
        override fun walk() = println("The goose is walking")
        override fun fly() = println("The goose is flying")
    }


    /* ✅ Correct Example */
    //Cat is not a fowl, so it doesn't fly. This way you do not break fly implementation.

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