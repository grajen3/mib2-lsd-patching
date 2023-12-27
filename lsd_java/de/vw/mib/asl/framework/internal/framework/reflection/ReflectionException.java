/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection;

public class ReflectionException
extends RuntimeException {
    private static final long serialVersionUID;

    public ReflectionException(String string) {
        super(string);
    }

    public ReflectionException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public ReflectionException(Throwable throwable) {
        super(throwable);
    }
}

