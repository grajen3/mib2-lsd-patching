/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class InstantiationException
extends Exception {
    private static final long serialVersionUID;

    public InstantiationException() {
    }

    public InstantiationException(String string) {
        super(string);
    }

    InstantiationException(Class clazz) {
        super(clazz.getName());
    }
}

