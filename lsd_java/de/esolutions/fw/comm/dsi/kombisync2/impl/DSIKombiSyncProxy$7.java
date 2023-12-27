/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncProxy;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayIdentificationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.DisplayIdentification;

class DSIKombiSyncProxy$7
implements ISerializable {
    private final /* synthetic */ DisplayIdentification val$identification;
    private final /* synthetic */ DSIKombiSyncProxy this$0;

    DSIKombiSyncProxy$7(DSIKombiSyncProxy dSIKombiSyncProxy, DisplayIdentification displayIdentification) {
        this.this$0 = dSIKombiSyncProxy;
        this.val$identification = displayIdentification;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DisplayIdentificationSerializer.putOptionalDisplayIdentification(iSerializer, this.val$identification);
    }
}

