/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRUserSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRUser;

class DSIOnlineServiceRegistrationProxy$6
implements ISerializable {
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ int val$privacyFlags;
    private final /* synthetic */ DSIOnlineServiceRegistrationProxy this$0;

    DSIOnlineServiceRegistrationProxy$6(DSIOnlineServiceRegistrationProxy dSIOnlineServiceRegistrationProxy, OSRUser oSRUser, int n) {
        this.this$0 = dSIOnlineServiceRegistrationProxy;
        this.val$user = oSRUser;
        this.val$privacyFlags = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRUserSerializer.putOptionalOSRUser(iSerializer, this.val$user);
        iSerializer.putInt32(this.val$privacyFlags);
    }
}

