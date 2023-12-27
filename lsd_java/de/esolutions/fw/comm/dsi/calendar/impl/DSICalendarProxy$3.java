/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar.impl;

import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarProxy;
import de.esolutions.fw.comm.dsi.calendar.impl.ProfileInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.calendar.ProfileInfo;

class DSICalendarProxy$3
implements ISerializable {
    private final /* synthetic */ ProfileInfo val$profile;
    private final /* synthetic */ DSICalendarProxy this$0;

    DSICalendarProxy$3(DSICalendarProxy dSICalendarProxy, ProfileInfo profileInfo) {
        this.this$0 = dSICalendarProxy;
        this.val$profile = profileInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ProfileInfoSerializer.putOptionalProfileInfo(iSerializer, this.val$profile);
    }
}

