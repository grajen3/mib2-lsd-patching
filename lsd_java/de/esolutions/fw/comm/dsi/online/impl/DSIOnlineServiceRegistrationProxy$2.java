/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy;
import de.esolutions.fw.comm.dsi.online.impl.OSRApplicationPropertiesSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRApplicationProperties;

class DSIOnlineServiceRegistrationProxy$2
implements ISerializable {
    private final /* synthetic */ String val$id;
    private final /* synthetic */ OSRApplicationProperties[] val$propertyList;
    private final /* synthetic */ DSIOnlineServiceRegistrationProxy this$0;

    DSIOnlineServiceRegistrationProxy$2(DSIOnlineServiceRegistrationProxy dSIOnlineServiceRegistrationProxy, String string, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
        this.this$0 = dSIOnlineServiceRegistrationProxy;
        this.val$id = string;
        this.val$propertyList = oSRApplicationPropertiesArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$id);
        OSRApplicationPropertiesSerializer.putOptionalOSRApplicationPropertiesVarArray(iSerializer, this.val$propertyList);
    }
}

