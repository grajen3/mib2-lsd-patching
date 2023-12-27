/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataProxy;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;

class DSIRadioDataProxy$3
implements ISerializable {
    private final /* synthetic */ RadioStationData val$radioStationData;
    private final /* synthetic */ ResourceLocator val$resourceLocator;
    private final /* synthetic */ int val$alterationType;
    private final /* synthetic */ int val$sessionId;
    private final /* synthetic */ DSIRadioDataProxy this$0;

    DSIRadioDataProxy$3(DSIRadioDataProxy dSIRadioDataProxy, RadioStationData radioStationData, ResourceLocator resourceLocator, int n, int n2) {
        this.this$0 = dSIRadioDataProxy;
        this.val$radioStationData = radioStationData;
        this.val$resourceLocator = resourceLocator;
        this.val$alterationType = n;
        this.val$sessionId = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RadioStationDataSerializer.putOptionalRadioStationData(iSerializer, this.val$radioStationData);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$resourceLocator);
        iSerializer.putInt32(this.val$alterationType);
        iSerializer.putInt32(this.val$sessionId);
    }
}

