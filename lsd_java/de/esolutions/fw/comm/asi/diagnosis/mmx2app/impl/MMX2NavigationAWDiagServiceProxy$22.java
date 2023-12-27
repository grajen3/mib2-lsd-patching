/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCountryRegionVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$22
implements ISerializable {
    private final /* synthetic */ sNavCountryRegionVersion val$data;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$22(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sNavCountryRegionVersion sNavCountryRegionVersion2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$data = sNavCountryRegionVersion2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sNavCountryRegionVersionSerializer.putOptionalsNavCountryRegionVersion(iSerializer, this.val$data);
    }
}

