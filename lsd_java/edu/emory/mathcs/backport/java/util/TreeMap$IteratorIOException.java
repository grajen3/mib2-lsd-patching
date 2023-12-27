/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import java.io.IOException;

class TreeMap$IteratorIOException
extends RuntimeException {
    TreeMap$IteratorIOException(IOException iOException) {
        super(iOException);
    }

    IOException getException() {
        return (IOException)this.getCause();
    }
}

