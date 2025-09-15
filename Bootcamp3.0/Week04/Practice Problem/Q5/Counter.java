public class Counter {
    // Use a static variable to track the number of objects created.
    // This variable belongs to the class, not to any single instance.
    static int count = 0;

    // The constructor is called each time a new object is created.
    Counter() {
        // Increment the static count each time a new object is instantiated.
        count++;
    }

    // A static method to return the current object count.
    // Since this method is static, it can be called without creating an object.
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        // Create several Counter objects.
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        // Display the number of objects created using the static getCount() method.
        // The static method is called directly on the class name.
        System.out.println("Number of objects created: " + Counter.getCount());
    }
}
