/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;

abstract class AslPoolListener {
    protected final int mKey;

    AslPoolListener(int n) {
        this.mKey = n;
    }

    int getKey() {
        return this.mKey;
    }

    abstract void notifyUpdate(IAslPool iAslPool, IAslPoolRecord iAslPoolRecord) {
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.mKey;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof AslPoolListener)) {
            return false;
        }
        AslPoolListener aslPoolListener = (AslPoolListener)object;
        return this.mKey == aslPoolListener.mKey;
    }

    public String toString() {
        return new StringBuffer().append(this.mKey).append("=").append(super.getClass().getName()).toString();
    }
}

