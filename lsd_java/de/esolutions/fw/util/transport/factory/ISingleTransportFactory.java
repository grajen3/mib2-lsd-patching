/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;

public interface ISingleTransportFactory {
    default public ITransport createTransport() {
    }

    default public String getDescription() {
    }
}

