/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Formatter$Accessor;

final class Formatter$4
implements Formatter$Accessor {
    private final /* synthetic */ long[] val$arrayArg;

    Formatter$4(long[] lArray) {
        this.val$arrayArg = lArray;
    }

    @Override
    public boolean isNull() {
        return this.val$arrayArg == null;
    }

    @Override
    public int getLength() {
        return this.val$arrayArg.length;
    }

    @Override
    public String getValueAt(int n) {
        return String.valueOf(this.val$arrayArg[n]);
    }
}

