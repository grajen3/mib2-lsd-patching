/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

public class InvalidSyntaxException
extends Exception {
    private transient String filter;

    public InvalidSyntaxException(String string, String string2) {
        super(string);
        this.filter = string2;
    }

    public String getFilter() {
        return this.filter;
    }
}

