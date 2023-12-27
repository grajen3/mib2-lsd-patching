/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCountryRegionVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$17
implements ISerializable {
    private final /* synthetic */ sNavCountryRegionVersion val$data;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$17(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sNavCountryRegionVersion sNavCountryRegionVersion2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$data = sNavCountryRegionVersion2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sNavCountryRegionVersionSerializer.putOptionalsNavCountryRegionVersion(iSerializer, this.val$data);
    }
}

