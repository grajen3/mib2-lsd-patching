/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

public class TimeoutException
extends RuntimeException {
    public TimeoutException(String string) {
        super(new StringBuffer().append("Timeout: ").append(string).toString());
    }
}

