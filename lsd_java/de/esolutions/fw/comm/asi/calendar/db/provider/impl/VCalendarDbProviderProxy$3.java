/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider.impl;

import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.comm.dsi.calendar.impl.ProfileInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.ProfileInfo;

class VCalendarDbProviderProxy$3
implements ISerializable {
    private final /* synthetic */ ProfileInfo val$profile;
    private final /* synthetic */ VCalendarDbProviderProxy this$0;

    VCalendarDbProviderProxy$3(VCalendarDbProviderProxy vCalendarDbProviderProxy, ProfileInfo profileInfo) {
        this.this$0 = vCalendarDbProviderProxy;
        this.val$profile = profileInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ProfileInfoSerializer.putOptionalProfileInfo(iSerializer, this.val$profile);
    }
}

