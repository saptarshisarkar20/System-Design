package org.lld.creational.singleton.feb7;

class NonSingleton {
    NonSingleton() {
        System.out.println("const called 11");
    }
}

// THIS CLASS IS NOT THREAD SAFE
// when multiple threads try to create instance at once, it creates multiple instances
class Singleton_1 {
    private static Singleton_1 instance;

    private Singleton_1() {
        System.out.println("const called <non> thread safe singleton");
    }

    public static Singleton_1 getInstance() {
        if (instance == null)
            instance = new Singleton_1();
        return instance;
    }
}

// THREAD SAFE SINGLETON - DOUBLE LOCKING
// uses of double locking

/**
 * Thread-safe Singleton implementation using Double-Checked Locking.
 *
 * <p>Logic behind double-checked locking:</p>
 * <ul>
 *   <li><b>First check (outside synchronized block):</b>
 *       Quickly verifies if the instance is already created.
 *       If yes, it returns immediately without locking, improving performance.</li>
 *
 *   <li><b>Synchronized block:</b>
 *       Ensures only one thread can enter when the instance is not yet created.</li>
 *
 *   <li><b>Second check (inside synchronized block):</b>
 *       Prevents multiple threads that passed the first check from creating
 *       multiple instances. Only the first thread creates the object, others
 *       see it already initialized.</li>
 * </ul>
 *
 * <p>This approach combines:</p>
 * <ul>
 *   <li><b>Thread safety</b> – guaranteed by synchronization and the second check.</li>
 *   <li><b>Performance</b> – most calls avoid synchronization once the instance exists.</li>
 * </ul>
 *
 * <p>Note: The instance must be declared <code>volatile</code> to ensure
 * visibility of changes across threads.</p>
 */
class Singleton_2 {
    private static Singleton_2 instance;

    private Singleton_2() {
        System.out.println("const called thread <safe> singleton - DOUBLE LOCKING");

    }

    public static Singleton_2 getInstance() {
        if (instance == null) {
            synchronized (Singleton_2.class) {
                if (instance == null)
                    instance = new Singleton_2();
            }
        }
        return instance;
    }
}

// THREAD SAFE SINGLETON - EAGER INITIALIZATION
// use of Eager Initialization

/**
 * <p>Why "eager"? Because the instance is created immediately
 * when the class is loaded by the JVM, even before anyone calls
 * getInstance().</p>
 *
 * <p>Pros:</p>
 * <ul>
 *   <li>Simple and thread-safe (class loading is synchronized by JVM).</li>
 *   <li>No need for explicit synchronization in getInstance().</li>
 * </ul>
 *
 * <p>Cons:</p>
 * <ul>
 *   <li>Instance is created even if the application never uses it,
 *       which can waste resources.</li>
 * </ul>
 */
class Singleton_3 {
    //
    private static Singleton_3 instance = new Singleton_3();

    private Singleton_3() {
        System.out.println("const called thread safe singleton - EAGER INITIALIZATION");
    }

    public static Singleton_3 getInstance() {
        return instance;
    }
}


// THREAD SAFE - - Bill Pugh Singleton (Inner Static Helper Class)

/**
 * Bill Pugh Singleton Implementation
 *
 * <p>This approach uses a static inner helper class to hold the Singleton instance.</p>
 *
 * <p>How it works:</p>
 * <ul>
 *   <li>The Singleton class itself does not create the instance eagerly.</li>
 *   <li>Instead, a private static inner class (Holder) contains the instance.</li>
 *   <li>The JVM loads the inner class only when getInstance() is called for the first time.</li>
 *   <li>Class loading in Java is thread-safe, so no explicit synchronization is needed.</li>
 * </ul>
 *
 * <p>Advantages:</p>
 * <ul>
 *   <li>Lazy initialization (instance created only when needed).</li>
 *   <li>Thread safety guaranteed by JVM class loader.</li>
 *   <li>No synchronization overhead after initialization.</li>
 * </ul>
 */
class Singleton_4 {
    private Singleton_4() {
        System.out.println("Bill Pugh Singleton created!");
    }

    public static Singleton_4 getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Singleton_4 INSTANCE = new Singleton_4();
    }
}

public class Singleton7Feb {
    public static void main(String[] args) {
        NonSingleton o1 = new NonSingleton();
        NonSingleton o2 = new NonSingleton();
        System.out.println("obj 1 >> " + o1 + " | obj 2 >> " + o2);
        // ----------------------------------------
        Singleton_1 oo1 = Singleton_1.getInstance();
        Singleton_1 oo2 = Singleton_1.getInstance();
        System.out.println("obj 1 >> " + oo1 + " | obj 2 >> " + oo2);
        // ----------------------------------------
        Singleton_2 to1 = Singleton_2.getInstance();
        Singleton_2 to2 = Singleton_2.getInstance();
        System.out.println("obj 1 >> " + to1 + " | obj 2 >> " + to2);
        // ----------------------------------------
        Singleton_3 eo1 = Singleton_3.getInstance();
        Singleton_3 eo2 = Singleton_3.getInstance();
        System.out.println("obj 1 >> " + eo1 + " | obj 2 >> " + eo2);
        // ----------------------------------------
        Singleton_4 bo1 = Singleton_4.getInstance();
        Singleton_4 bo2 = Singleton_4.getInstance();
        System.out.println("obj 1 >> " + bo1 + " | obj 2 >> " + bo2);
    }


}