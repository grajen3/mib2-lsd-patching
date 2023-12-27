/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.exception;

import de.esolutions.fw.util.transport.exception.TransportException;

public class TransportTimeoutException
extends TransportException {
    private static final long serialVersionUID;

    public TransportTimeoutException() {
    }

    public TransportTimeoutException(String string) {
        super(string);
    }
}

