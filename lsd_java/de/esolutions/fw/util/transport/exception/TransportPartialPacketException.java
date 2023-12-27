/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.exception;

import de.esolutions.fw.util.transport.exception.TransportException;

public class TransportPartialPacketException
extends TransportException {
    private static final long serialVersionUID;

    public TransportPartialPacketException() {
    }

    public TransportPartialPacketException(String string) {
        super(string);
    }
}

