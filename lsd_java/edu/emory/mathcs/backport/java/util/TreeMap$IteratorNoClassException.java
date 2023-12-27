/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

class TreeMap$IteratorNoClassException
extends RuntimeException {
    TreeMap$IteratorNoClassException(ClassNotFoundException classNotFoundException) {
        super(classNotFoundException);
    }

    ClassNotFoundException getException() {
        return (ClassNotFoundException)this.getCause();
    }
}

