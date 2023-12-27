/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SpeechDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCountryRegionVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2SpeechDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sNavCountryRegionVersion val$data;
    private final /* synthetic */ MMX2SpeechDiagServiceProxy this$0;

    MMX2SpeechDiagServiceProxy$3(MMX2SpeechDiagServiceProxy mMX2SpeechDiagServiceProxy, sNavCountryRegionVersion sNavCountryRegionVersion2) {
        this.this$0 = mMX2SpeechDiagServiceProxy;
        this.val$data = sNavCountryRegionVersion2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sNavCountryRegionVersionSerializer.putOptionalsNavCountryRegionVersion(iSerializer, this.val$data);
    }
}

