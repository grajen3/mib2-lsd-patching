/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

public class DbgSmInfo$DbgWithID {
    public int ID;
    public String SymbolicID;

    protected String idString() {
        return new StringBuffer().append("{{").append(this.ID).append("}}").toString();
    }
}

