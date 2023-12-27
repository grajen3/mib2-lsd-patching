/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRDeviceSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRUserSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRUser;

class DSIOnlineServiceRegistrationProxy$7
implements ISerializable {
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ OSRDevice[] val$devices;
    private final /* synthetic */ DSIOnlineServiceRegistrationProxy this$0;

    DSIOnlineServiceRegistrationProxy$7(DSIOnlineServiceRegistrationProxy dSIOnlineServiceRegistrationProxy, OSRUser oSRUser, OSRDevice[] oSRDeviceArray) {
        this.this$0 = dSIOnlineServiceRegistrationProxy;
        this.val$user = oSRUser;
        this.val$devices = oSRDeviceArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRUserSerializer.putOptionalOSRUser(iSerializer, this.val$user);
        OSRDeviceSerializer.putOptionalOSRDeviceVarArray(iSerializer, this.val$devices);
    }
}

