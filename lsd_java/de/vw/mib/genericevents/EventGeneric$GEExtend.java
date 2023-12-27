/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;

class EventGeneric$GEExtend {
    public final IntIntOptHashMap parameterTypes = new IntIntOptHashMap(5);
    public final IntObjectOptHashMap objectData = new IntObjectOptHashMap(5);
    public final IntLongOptHashMap primitiveData = new IntLongOptHashMap(5);
    private final /* synthetic */ EventGeneric this$0;

    public EventGeneric$GEExtend(EventGeneric eventGeneric) {
        this.this$0 = eventGeneric;
    }
}

