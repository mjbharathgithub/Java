// In Java, an inner class is a class that is declared inside another class. Inner classes can access the members (including private members) of the outer class. Inner classes are used to logically group classes that are only used in one place, increase encapsulation, and can lead to more readable and maintainable code.

// Types of Inner Classes in Java
// Member Inner Class
// Static Nested Class
// Local Inner Class
// Anonymous Inner Class
// Let's explore each type in detail with examples:

// 1. Member Inner Class
// A member inner class is defined within a class and is treated as a member of that class.

// Example:

public class OuterClass {
    private String outerField = "Outer field";

    class InnerClass {
        void display() {
            System.out.println("Accessing: " + outerField);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}

// 2. Static Nested Class
// A static nested class is a static class defined inside another class. It cannot access non-static members of the outer class.

// Example:

public class OuterClass {
    private static String staticOuterField = "Static Outer field";

    static class StaticNestedClass {
        void display() {
            System.out.println("Accessing: " + staticOuterField);
        }
    }

    public static void main(String[] args) {
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        nested.display();
    }
}

// 3. Local Inner Class
// A local inner class is defined within a method of the outer class. It is local to that method and can access the method's local variables and parameters, provided they are final or effectively final.

// Example:

public class OuterClass {
    void methodWithInnerClass() {
        String localVar = "Local variable";

        class LocalInnerClass {
            void display() {
                System.out.println("Accessing: " + localVar);
            }
        }

        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.methodWithInnerClass();
    }
}

// 4. Anonymous Inner Class
// An anonymous inner class is an inner class without a name. It is used to instantiate objects with certain "extras" such as method overrides, without having to actually subclass a class.

// Example:

interface Greeting {
    void greet();
}

public class OuterClass {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            public void greet() {
                System.out.println("Hello from Anonymous Inner Class");
            }
        };
        greeting.greet();
    }
}
// Summary
// Member Inner Class: Defined inside a class, acts as a member.
// Static Nested Class: Defined inside a class with the static keyword, does not have access to instance members of the outer class.
// Local Inner Class: Defined within a method, local to that method.
// Anonymous Inner Class: Defined without a name, used for instantiating and often overriding methods on the fly.
// Inner classes provide a way to logically group classes that are only used in one place, which increases encapsulation and makes the code more readable and maintainable.
