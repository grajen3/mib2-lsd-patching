/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.comm.dsi.networking.impl.CDataProfileSerializer;
import de.esolutions.fw.comm.dsi.networking.impl.DSIDataConfigurationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.CDataProfile;

class DSIDataConfigurationProxy$1
implements ISerializable {
    private final /* synthetic */ CDataProfile val$dataProfile;
    private final /* synthetic */ DSIDataConfigurationProxy this$0;

    DSIDataConfigurationProxy$1(DSIDataConfigurationProxy dSIDataConfigurationProxy, CDataProfile cDataProfile) {
        this.this$0 = dSIDataConfigurationProxy;
        this.val$dataProfile = cDataProfile;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CDataProfileSerializer.putOptionalCDataProfile(iSerializer, this.val$dataProfile);
    }
}

