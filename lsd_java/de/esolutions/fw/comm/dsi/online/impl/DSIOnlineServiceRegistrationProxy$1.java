/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRLicenseSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRLicense;

class DSIOnlineServiceRegistrationProxy$1
implements ISerializable {
    private final /* synthetic */ OSRLicense val$license;
    private final /* synthetic */ DSIOnlineServiceRegistrationProxy this$0;

    DSIOnlineServiceRegistrationProxy$1(DSIOnlineServiceRegistrationProxy dSIOnlineServiceRegistrationProxy, OSRLicense oSRLicense) {
        this.this$0 = dSIOnlineServiceRegistrationProxy;
        this.val$license = oSRLicense;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        OSRLicenseSerializer.putOptionalOSRLicense(iSerializer, this.val$license);
    }
}

