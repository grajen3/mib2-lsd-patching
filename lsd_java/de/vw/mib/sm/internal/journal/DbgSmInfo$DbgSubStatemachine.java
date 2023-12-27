/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgWithID;

public class DbgSmInfo$DbgSubStatemachine
extends DbgSmInfo$DbgWithID {
    public String Name;
    public IntObjectMap states = new IntObjectOptHashMap();
    public IntObjectMap internals = new IntObjectOptHashMap();
    public IntObjectMap triggereds = new IntObjectOptHashMap();
    public IntObjectMap untriggereds = new IntObjectOptHashMap();

    public String toString() {
        return new StringBuffer().append("SubSM '").append(this.Name).append("'").append(this.idString()).toString();
    }
}

