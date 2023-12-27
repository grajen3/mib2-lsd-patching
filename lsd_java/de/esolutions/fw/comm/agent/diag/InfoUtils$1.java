/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.PrintUtils$ValueGetter;

final class InfoUtils$1
implements PrintUtils$ValueGetter {
    InfoUtils$1() {
    }

    @Override
    public Object getValue(Object object) {
        return new Integer(((IInfoBase)object).getID());
    }
}

