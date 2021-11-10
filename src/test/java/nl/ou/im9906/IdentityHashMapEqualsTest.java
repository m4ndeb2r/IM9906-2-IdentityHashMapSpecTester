package nl.ou.im9906;

import org.junit.Test;

import static nl.ou.im9906.ClassInvariantTestHelper.assertClassInvariants;
import static nl.ou.im9906.MethodTestHelper.assertIsPureMethod;

/**
 * Tests the JML specifications of the {@link VerifiedIdentityHashMap#equals(Object)}
 * method.
 *
 * Note: the JML for this method is incomplete, and, therefore, so is this test.
 * Note 2: the equals method is not verfified with KeY.
 */
public class IdentityHashMapEqualsTest {

    /**
     * Tests if the method {@link VerifiedIdentityHashMap#equals(Object)} is a pure method,
     * as specified in the JML. Furthermore, as a precondition as well a postcondition,
     * the class invariants should hold, obviously.
     *
     * @throws NoSuchFieldException   if one or more fields do not exist
     * @throws IllegalAccessException if one or more field cannot be accessed
     * @throws NoSuchMethodException  if the method to invoke does not exist
     * @throws NoSuchClassException   if one of the (inner) classes does not exist
     */
    @Test
    public void testEqualsNormalBehaviour()
            throws NoSuchMethodException, IllegalAccessException,
            NoSuchFieldException, NoSuchClassException {
        // Create a new VerifiedIdentityHashMap
        final VerifiedIdentityHashMap<Object, Object> map = new VerifiedIdentityHashMap<>();
        // Create an equal VerifiedIdentityHashMap
        final VerifiedIdentityHashMap<Object, Object> map2 = new VerifiedIdentityHashMap<>();

        // Test if the class invariants hold (precondition)
        assertClassInvariants(map);

        // Call the equals method, and check if it is pure
        assertIsPureMethod(map, "equals", map2);

        // Test if the class invariants hold (postcondition)
        assertClassInvariants(map);
    }

}