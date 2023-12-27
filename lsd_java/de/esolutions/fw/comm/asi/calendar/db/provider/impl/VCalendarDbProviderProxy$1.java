/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.comm.dsi.calendar.impl.VCalendarSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.VCalendar;

class VCalendarDbProviderProxy$1
implements ISerializable {
    private final /* synthetic */ int val$profileId;
    private final /* synthetic */ int val$version;
    private final /* synthetic */ VCalendar[] val$entry;
    private final /* synthetic */ VCalendarDbProviderProxy this$0;

    VCalendarDbProviderProxy$1(VCalendarDbProviderProxy vCalendarDbProviderProxy, int n, int n2, VCalendar[] vCalendarArray) {
        this.this$0 = vCalendarDbProviderProxy;
        this.val$profileId = n;
        this.val$version = n2;
        this.val$entry = vCalendarArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$profileId);
        iSerializer.putInt32(this.val$version);
        VCalendarSerializer.putOptionalVCalendarVarArray(iSerializer, this.val$entry);
    }
}

