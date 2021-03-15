import java.util.HashSet;

public class JavaMain {
    public static void main(String[] args) {
        testForDefaultPojoClass();
        testForEqaulPojoClass();
        testForHashPojoClass();
    }

    private static void testForEqaulPojoClass() {
        PojoClassEqual pojoClassEqual = new PojoClassEqual();
        pojoClassEqual.setNumberData(100);
        pojoClassEqual.setTextData("text");

        PojoClassEqual otherPojoClassEqual = new PojoClassEqual();
        otherPojoClassEqual.setNumberData(100);
        otherPojoClassEqual.setTextData("text");

        System.out.println(pojoClassEqual.toString());
        System.out.println(otherPojoClassEqual);
        System.out.println("is it equal two instance = " + (pojoClassEqual == otherPojoClassEqual)); // false
        System.out.println("is it equal two instance = " + (pojoClassEqual.equals(otherPojoClassEqual))); // true

        HashSet<PojoClassEqual> hashSet = new HashSet<>();
        hashSet.add(pojoClassEqual);
        System.out.println(hashSet.contains(otherPojoClassEqual)); // false
    }

    private static void testForHashPojoClass() {
        PojoClassEqualHashCode pojoClassEqualHashCode = new PojoClassEqualHashCode();
        pojoClassEqualHashCode.setNumberData(100);
        pojoClassEqualHashCode.setTextData("text");

        PojoClassEqualHashCode otherPojoClassEqualHashCode = new PojoClassEqualHashCode();
        otherPojoClassEqualHashCode.setNumberData(100);
        otherPojoClassEqualHashCode.setTextData("text");

        HashSet<PojoClassEqualHashCode> hashSetWithHashCode = new HashSet<>();
        hashSetWithHashCode.add(otherPojoClassEqualHashCode);
        System.out.println(hashSetWithHashCode.contains(otherPojoClassEqualHashCode)); // true
    }

    private static void testForDefaultPojoClass() {
        PojoClass pojoClass = new PojoClass();
        pojoClass.setNumberData(100);
        pojoClass.setTextData("text");

        PojoClass otherPojoClass = new PojoClass();
        otherPojoClass.setNumberData(100);
        otherPojoClass.setTextData("text");

        System.out.println(pojoClass.toString());
        System.out.println(otherPojoClass);
        System.out.println("is it equal two instance = " + (pojoClass == otherPojoClass)); // false
        System.out.println("is it equal two instance = " + (pojoClass.equals(otherPojoClass))); // false
    }
}
