/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class InstantiationError
extends IncompatibleClassChangeError {
    private static final long serialVersionUID;

    public InstantiationError() {
    }

    public InstantiationError(String string) {
        super(string);
    }

    InstantiationError(Class clazz) {
        super(clazz.getName());
    }
}

