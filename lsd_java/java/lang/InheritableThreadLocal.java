/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class InheritableThreadLocal
extends ThreadLocal {
    protected Object childValue(Object object) {
        return object;
    }
}

