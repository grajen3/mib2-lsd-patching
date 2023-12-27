/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

public class StrategyOverException
extends RuntimeException {
    public StrategyOverException(String string) {
        super(new StringBuffer().append("Strategy over: ").append(string).toString());
    }
}

