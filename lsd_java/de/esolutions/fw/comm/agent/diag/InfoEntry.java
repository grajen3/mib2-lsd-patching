/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

public final class InfoEntry {
    public final String name;
    public final Object value;

    public InfoEntry(String string, Object object) {
        this.name = string;
        this.value = object;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValue() {
        return this.value;
    }

    public final String getValueString() {
        if (this.value == null) {
            return "null";
        }
        return this.value.toString();
    }
}

