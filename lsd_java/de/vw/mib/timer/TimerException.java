/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer;

import de.vw.mib.error.HMIException;

public final class TimerException
extends HMIException {
    private static final long serialVersionUID;

    public TimerException() {
    }

    public TimerException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public TimerException(String string) {
        super(string);
    }

    public TimerException(Throwable throwable) {
        super(throwable);
    }
}

