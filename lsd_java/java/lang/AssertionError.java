/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.lang;

public class AssertionError
extends Error {
    public AssertionError() {
    }

    public AssertionError(Object object) {
        super(String.valueOf(object));
        if (object instanceof Throwable) {
            ((Throwable)((Object)this)).initCause((Throwable)object);
        }
    }

    public AssertionError(boolean bl) {
        this((Object)String.valueOf(bl));
    }

    public AssertionError(char c2) {
        this((Object)String.valueOf(c2));
    }

    public AssertionError(int n) {
        this((Object)Integer.toString(n));
    }

    public AssertionError(long l) {
        this((Object)Long.toString(l));
    }

    public AssertionError(float f2) {
        this((Object)Float.toString(f2));
    }

    public AssertionError(double d2) {
        this((Object)Double.toString((double)d2));
    }
}

