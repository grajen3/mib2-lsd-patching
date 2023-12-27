/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Formatter$Accessor;

final class Formatter$5
implements Formatter$Accessor {
    private final /* synthetic */ String[] val$arrayArg;

    Formatter$5(String[] stringArray) {
        this.val$arrayArg = stringArray;
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
        return new StringBuffer().append("\"").append(this.val$arrayArg[n]).append("\"").toString();
    }
}

