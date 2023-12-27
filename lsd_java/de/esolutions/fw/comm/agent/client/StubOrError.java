/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.service.Stub;

public final class StubOrError {
    private final Stub stub;
    private final int error;

    public StubOrError(Stub stub) {
        this.stub = stub;
        this.error = 0;
    }

    public StubOrError(int n) {
        this.stub = null;
        this.error = n;
    }

    public Stub getStub() {
        return this.stub;
    }

    public int getError() {
        return this.error;
    }

    public boolean hasError() {
        return this.stub == null;
    }
}

