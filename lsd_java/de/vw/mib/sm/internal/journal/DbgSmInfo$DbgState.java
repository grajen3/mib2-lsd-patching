/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgSubStatemachine;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgWithID;

public class DbgSmInfo$DbgState
extends DbgSmInfo$DbgWithID {
    public String Name;
    public String Kind;
    public DbgSmInfo$DbgState Parent;
    public DbgSmInfo$DbgSubStatemachine owner;

    public String toString() {
        return new StringBuffer().append("S '").append(this.Name).append("':").append(this.Kind.substring(9)).append(this.idString()).toString();
    }
}

