/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public final class Compiler {
    private Compiler() {
    }

    public static Object command(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        return Compiler.commandImpl(object);
    }

    private static native Object commandImpl(Object object) {
    }

    public static boolean compileClass(Class clazz) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        return Compiler.compileClassImpl(clazz);
    }

    private static native boolean compileClassImpl(Class clazz) {
    }

    public static boolean compileClasses(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        return Compiler.compileClassesImpl(string);
    }

    private static native boolean compileClassesImpl(String string) {
    }

    public static native void disable() {
    }

    public static native void enable() {
    }
}

