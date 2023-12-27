/*
 * Decompiled with CFR 0.152.
 */
package java.lang.reflect;

public class Modifier {
    public static final int PUBLIC;
    public static final int PRIVATE;
    public static final int PROTECTED;
    public static final int STATIC;
    public static final int FINAL;
    public static final int SYNCHRONIZED;
    public static final int VOLATILE;
    public static final int TRANSIENT;
    public static final int NATIVE;
    public static final int INTERFACE;
    public static final int ABSTRACT;
    public static final int STRICT;

    public static boolean isAbstract(int n) {
        return (n & 0x400) != 0;
    }

    public static boolean isFinal(int n) {
        return (n & 0x10) != 0;
    }

    public static boolean isInterface(int n) {
        return (n & 0x200) != 0;
    }

    public static boolean isNative(int n) {
        return (n & 0x100) != 0;
    }

    public static boolean isPrivate(int n) {
        return (n & 2) != 0;
    }

    public static boolean isProtected(int n) {
        return (n & 4) != 0;
    }

    public static boolean isPublic(int n) {
        return (n & 1) != 0;
    }

    public static boolean isStatic(int n) {
        return (n & 8) != 0;
    }

    public static boolean isStrict(int n) {
        return (n & 0x800) != 0;
    }

    public static boolean isSynchronized(int n) {
        return (n & 0x20) != 0;
    }

    public static boolean isTransient(int n) {
        return (n & 0x80) != 0;
    }

    public static boolean isVolatile(int n) {
        return (n & 0x40) != 0;
    }

    public static String toString(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        if (Modifier.isPublic(n)) {
            stringBuffer.append("public ");
        }
        if (Modifier.isProtected(n)) {
            stringBuffer.append("protected ");
        }
        if (Modifier.isPrivate(n)) {
            stringBuffer.append("private ");
        }
        if (Modifier.isAbstract(n)) {
            stringBuffer.append("abstract ");
        }
        if (Modifier.isStatic(n)) {
            stringBuffer.append("static ");
        }
        if (Modifier.isFinal(n)) {
            stringBuffer.append("final ");
        }
        if (Modifier.isTransient(n)) {
            stringBuffer.append("transient ");
        }
        if (Modifier.isVolatile(n)) {
            stringBuffer.append("volatile ");
        }
        if (Modifier.isSynchronized(n)) {
            stringBuffer.append("synchronized ");
        }
        if (Modifier.isNative(n)) {
            stringBuffer.append("native ");
        }
        if (Modifier.isStrict(n)) {
            stringBuffer.append("strictfp ");
        }
        if (Modifier.isInterface(n)) {
            stringBuffer.append("interface ");
        }
        if (stringBuffer.length() == 0) {
            return "";
        }
        stringBuffer.setLength(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }
}

