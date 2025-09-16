public class SamePackageTest {
public static void testAccess() {
System.out.println("\nSame Package Access:");
AccessModifierDemo demo = new AccessModifierDemo(1, "Package", 2.2, false);
// defaultField is accessible
System.out.println("Default Field (Same Package): " + demo.defaultField);
demo.defaultMethod();
// protectedField is accessible
System.out.println("Protected Field (Same Package): " + demo.protectedField);
demo.protectedMethod();
// publicField is accessible
System.out.println("Public Field (Same Package): " + demo.publicField);
demo.publicMethod();
// privateField and privateMethod are NOT accessible (compile error)
// System.out.println(demo.privateField);
// demo.privateMethod();
}
}
