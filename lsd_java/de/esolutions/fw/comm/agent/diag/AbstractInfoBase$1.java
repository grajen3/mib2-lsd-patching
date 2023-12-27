/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoEntry;
import java.util.Comparator;

class AbstractInfoBase$1
implements Comparator {
    private final /* synthetic */ AbstractInfoBase this$0;

    AbstractInfoBase$1(AbstractInfoBase abstractInfoBase) {
        this.this$0 = abstractInfoBase;
    }

    @Override
    public int compare(Object object, Object object2) {
        InfoEntry infoEntry = (InfoEntry)object;
        InfoEntry infoEntry2 = (InfoEntry)object2;
        return infoEntry.getName().compareTo(infoEntry2.getName());
    }
}

