/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

public class BundleException
extends Exception {
    private transient Throwable throwable;

    public BundleException(String string, Throwable throwable) {
        super(string);
        this.throwable = throwable;
    }

    public BundleException(String string) {
        super(string);
        this.throwable = null;
    }

    public Throwable getNestedException() {
        return this.throwable;
    }
}

