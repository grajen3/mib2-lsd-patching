/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Formatter$Accessor;

final class Formatter$3
implements Formatter$Accessor {
    private final /* synthetic */ int[] val$arrayArg;

    Formatter$3(int[] nArray) {
        this.val$arrayArg = nArray;
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

