/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRUserSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRUser;

class DSIOnlineServiceRegistrationProxy$11
implements ISerializable {
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ String val$domain;
    private final /* synthetic */ DSIOnlineServiceRegistrationProxy this$0;

    DSIOnlineServiceRegistrationProxy$11(DSIOnlineServiceRegistrationProxy dSIOnlineServiceRegistrationProxy, OSRUser oSRUser, String string) {
        this.this$0 = dSIOnlineServiceRegistrationProxy;
        this.val$user = oSRUser;
        this.val$domain = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRUserSerializer.putOptionalOSRUser(iSerializer, this.val$user);
        iSerializer.putOptionalString(this.val$domain);
    }
}

