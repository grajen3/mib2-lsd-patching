/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgEvent;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgState;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgSubStatemachine;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgWithID;

public class DbgSmInfo$DbgTransition
extends DbgSmInfo$DbgWithID {
    public DbgSmInfo$DbgState Source;
    public DbgSmInfo$DbgState Target;
    public DbgSmInfo$DbgEvent Trigger;
    public String Guard;
    public String sign;
    public char kind;
    public DbgSmInfo$DbgSubStatemachine owner;

    public String toString() {
        return new StringBuffer().append(this.sign).append("T ").append(DbgSmInfo$DbgTransition.str(this.Source, "${SID=???}")).append(" -> ").append(DbgSmInfo$DbgTransition.str(this.Target, "${SID=???}")).append(" if ").append(DbgSmInfo$DbgTransition.str(this.Trigger, "-")).append("[").append(DbgSmInfo$DbgTransition.str(this.Guard, "")).append("]").append(this.idString()).toString();
    }

    private static String str(Object object, String string) {
        return object != null ? object.toString() : string;
    }
}

