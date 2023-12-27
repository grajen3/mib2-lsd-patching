/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgWithID;

public class DbgSmInfo$DbgEvent
extends DbgSmInfo$DbgWithID {
    public String Name;
    public String Type;

    public String toString() {
        return new StringBuffer().append("Event '").append(this.Name).append("'").append(this.idString()).toString();
    }
}

