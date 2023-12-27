/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRApplicationPropertiesSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRApplicationProperties;

class DSIOnlineServiceRegistrationProxy$3
implements ISerializable {
    private final /* synthetic */ String val$id;
    private final /* synthetic */ OSRApplicationProperties val$property;
    private final /* synthetic */ DSIOnlineServiceRegistrationProxy this$0;

    DSIOnlineServiceRegistrationProxy$3(DSIOnlineServiceRegistrationProxy dSIOnlineServiceRegistrationProxy, String string, OSRApplicationProperties oSRApplicationProperties) {
        this.this$0 = dSIOnlineServiceRegistrationProxy;
        this.val$id = string;
        this.val$property = oSRApplicationProperties;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$id);
        OSRApplicationPropertiesSerializer.putOptionalOSRApplicationProperties(iSerializer, this.val$property);
    }
}

