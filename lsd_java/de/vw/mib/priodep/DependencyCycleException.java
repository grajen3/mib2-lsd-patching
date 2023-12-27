/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.priodep;

public class DependencyCycleException
extends RuntimeException {
    private static final long serialVersionUID;

    public DependencyCycleException(String string) {
        super(string);
    }

    public DependencyCycleException() {
    }
}

