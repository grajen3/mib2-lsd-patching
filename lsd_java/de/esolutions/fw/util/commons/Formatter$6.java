/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Formatter$Accessor;

final class Formatter$6
implements Formatter$Accessor {
    private final /* synthetic */ Object[] val$arrayArg;

    Formatter$6(Object[] objectArray) {
        this.val$arrayArg = objectArray;
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
        Object object = this.val$arrayArg[n];
        return object instanceof String ? new StringBuffer().append("\"").append(object).append("\"").toString() : object.toString();
    }
}

