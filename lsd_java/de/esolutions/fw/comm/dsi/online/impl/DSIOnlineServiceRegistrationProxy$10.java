/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRUserSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRUser;

class DSIOnlineServiceRegistrationProxy$10
implements ISerializable {
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ DSIOnlineServiceRegistrationProxy this$0;

    DSIOnlineServiceRegistrationProxy$10(DSIOnlineServiceRegistrationProxy dSIOnlineServiceRegistrationProxy, OSRUser oSRUser) {
        this.this$0 = dSIOnlineServiceRegistrationProxy;
        this.val$user = oSRUser;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRUserSerializer.putOptionalOSRUser(iSerializer, this.val$user);
    }
}

