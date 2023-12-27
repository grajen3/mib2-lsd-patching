/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo.transformer;

public class UgdoFunctionCollector {
    public boolean functionAvailable;
    public int functionReason;

    public UgdoFunctionCollector() {
        this.functionAvailable = false;
        this.functionReason = 0;
    }

    public UgdoFunctionCollector(boolean bl, int n) {
        this.functionAvailable = bl;
        this.functionReason = n;
    }
}

