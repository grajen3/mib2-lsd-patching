/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;

public class EntityBackRef {
    private final ConnectionFrontendHandler handler;
    private int extId;

    public EntityBackRef(ConnectionFrontendHandler connectionFrontendHandler, int n) {
        this.handler = connectionFrontendHandler;
        this.extId = n;
    }

    public ConnectionFrontendHandler getHandler() {
        return this.handler;
    }

    public int getExtId() {
        return this.extId;
    }
}

