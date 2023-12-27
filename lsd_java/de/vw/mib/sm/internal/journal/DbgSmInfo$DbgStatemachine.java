/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgWithID;

public class DbgSmInfo$DbgStatemachine
extends DbgSmInfo$DbgWithID {
    public String Name;
    public String Dynamic;
    public final IntObjectMap subStatemachines = new IntObjectOptHashMap();

    public String toString() {
        return new StringBuffer().append("SM '").append(this.Name).append("'").append(this.idString()).toString();
    }
}

