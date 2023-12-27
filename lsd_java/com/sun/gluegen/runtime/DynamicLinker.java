/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

interface DynamicLinker {
    default public long openLibrary(String string) {
    }

    default public long lookupSymbol(long l, String string) {
    }

    default public void closeLibrary(long l) {
    }
}

