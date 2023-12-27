/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.IWriteable;

public interface IWriter {
    default public int size() {
    }

    default public void write(IWriteable iWriteable) {
    }

    default public void setDebugTag(Object object) {
    }

    default public Object getDebugTag() {
    }
}

