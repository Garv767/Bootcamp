public class AccessModifierDemo {

private int privateField;
String defaultField;
protected double protectedField;
public boolean publicField;

private void privateMethod() {
System.out.println("Private method called");
}

void defaultMethod() {
System.out.println("Default method called");
}

protected void protectedMethod() {
System.out.println("Protected method called");
}

public void publicMethod() {
System.out.println("Public method called");
}

public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
this.privateField = privateField;
this.defaultField = defaultField;
this.protectedField = protectedField;
this.publicField = publicField;
}

public void testInternalAccess() {
System.out.println("Internal Access:");
System.out.println("Private Field: " + privateField);
System.out.println("Default Field: " + defaultField);
System.out.println("Protected Field: " + protectedField);
System.out.println("Public Field: " + publicField);
privateMethod();
defaultMethod();
protectedMethod();
publicMethod();
}

public static void main (String[] args) {
AccessModifierDemo demo = new AccessModifierDemo(10, "Hello", 20.5, true);
// Accessing members within the same class
// All will work because they are accessed internally
demo.testInternalAccess();
}
}

