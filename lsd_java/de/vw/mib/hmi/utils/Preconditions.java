/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.StringTemplate;

public class Preconditions {
    public static void checkArgument(boolean bl, Object object) {
        if (!bl) {
            Preconditions.checkNotNull(object, "checkArgument with null-message");
            throw new IllegalArgumentException(String.valueOf(object));
        }
    }

    public static void checkArgument(boolean bl, String string, Object object) {
        if (!bl) {
            Preconditions.checkNotNull(string, "checkArgument with null-message");
            throw new IllegalArgumentException(StringTemplate.format(string, new Object[]{object}));
        }
    }

    public static void checkArgument(boolean bl, String string, Object object, Object object2) {
        if (!bl) {
            Preconditions.checkNotNull(string, "checkArgument with null-message");
            throw new IllegalArgumentException(StringTemplate.format(string, new Object[]{object, object2}));
        }
    }

    public static void checkArgument(boolean bl, String string, Object[] objectArray) {
        if (!bl) {
            Preconditions.checkNotNull(string, "checkArgument with null-message");
            Preconditions.checkNotNull(objectArray, "checkArgument with null-message-arguments");
            throw new IllegalArgumentException(StringTemplate.format(string, objectArray));
        }
    }

    public static void checkState(boolean bl, Object object) {
        if (!bl) {
            Preconditions.checkNotNull(object, "checkState with null-message");
            throw new IllegalStateException(String.valueOf(object));
        }
    }

    public static void checkState(boolean bl, String string, Object object) {
        if (!bl) {
            Preconditions.checkNotNull(string, "checkState with null-message");
            throw new IllegalStateException(StringTemplate.format(string, new Object[]{object}));
        }
    }

    public static void checkState(boolean bl, String string, Object object, Object object2) {
        if (!bl) {
            Preconditions.checkNotNull(string, "checkState with null-message");
            throw new IllegalStateException(StringTemplate.format(string, new Object[]{object, object2}));
        }
    }

    public static void checkState(boolean bl, String string, Object[] objectArray) {
        if (!bl) {
            Preconditions.checkNotNull(string, "checkState with null-message");
            Preconditions.checkNotNull(objectArray, "checkState with null-message-arguments");
            throw new IllegalStateException(StringTemplate.format(string, objectArray));
        }
    }

    public static Object checkInstanceOf(Class clazz, Object object, Object object2) {
        if (!clazz.isInstance(object)) {
            throw new NullPointerException(String.valueOf(object2));
        }
        return object;
    }

    public static Object checkInstanceOf(Class clazz, Object object, String string, Object[] objectArray) {
        if (!clazz.isInstance(object)) {
            Preconditions.checkNotNull(string, "checkState with null-message");
            Preconditions.checkNotNull(objectArray, "checkState with null-message-arguments");
            throw new IllegalArgumentException(StringTemplate.format(string, objectArray));
        }
        return object;
    }

    public static void checkNotNull(Object object, Object object2) {
        if (object == null) {
            Preconditions.checkNotNull(object2, "checkNotNull with null-message");
            throw new NullPointerException(String.valueOf(object2));
        }
    }

    public static void checkNotNull(Object object, String string, Object object2) {
        if (object == null) {
            Preconditions.checkNotNull(string, "checkNotNull with null-message");
            throw new NullPointerException(StringTemplate.format(string, new Object[]{object2}));
        }
    }

    public static void checkNotNull(Object object, String string, Object object2, Object object3) {
        if (object == null) {
            Preconditions.checkNotNull(string, "checkNotNull with null-message");
            throw new NullPointerException(StringTemplate.format(string, new Object[]{object2, object3}));
        }
    }

    public static void checkNotNull(Object object, String string, Object[] objectArray) {
        if (object == null) {
            Preconditions.checkNotNull(string, "checkNotNull with null-message");
            Preconditions.checkNotNull(objectArray, "checkNotNull with null-message-arguments");
            throw new NullPointerException(StringTemplate.format(string, objectArray));
        }
    }

    public static void checkInRange(String string, int n, int n2, int n3) {
        if (n < n2 || n > n3) {
            Preconditions.checkNotNull(string, "checkInRange with null-name");
            Object[] objectArray = new Object[]{string, new Integer(n), new Integer(n2), new Integer(n3)};
            throw new IllegalArgumentException(StringTemplate.format("The value of %s %s is out of bound [%s..%s[.", objectArray));
        }
    }
}

