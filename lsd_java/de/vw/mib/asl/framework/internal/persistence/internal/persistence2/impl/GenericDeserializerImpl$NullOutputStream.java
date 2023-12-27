/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import java.io.OutputStream;

class GenericDeserializerImpl$NullOutputStream
extends OutputStream {
    public static final GenericDeserializerImpl$NullOutputStream NULL_OUTPUT_STREAM = new GenericDeserializerImpl$NullOutputStream();

    private GenericDeserializerImpl$NullOutputStream() {
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
    }

    @Override
    public void write(int n) {
    }

    @Override
    public void write(byte[] byArray) {
    }
}

