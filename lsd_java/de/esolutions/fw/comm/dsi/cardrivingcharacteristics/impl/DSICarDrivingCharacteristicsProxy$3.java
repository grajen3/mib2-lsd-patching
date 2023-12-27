/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;

class DSICarDrivingCharacteristicsProxy$3
implements ISerializable {
    private final /* synthetic */ CharismaListUpdateInfo val$listUpdateInfo;
    private final /* synthetic */ DSICarDrivingCharacteristicsProxy this$0;

    DSICarDrivingCharacteristicsProxy$3(DSICarDrivingCharacteristicsProxy dSICarDrivingCharacteristicsProxy, CharismaListUpdateInfo charismaListUpdateInfo) {
        this.this$0 = dSICarDrivingCharacteristicsProxy;
        this.val$listUpdateInfo = charismaListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CharismaListUpdateInfoSerializer.putOptionalCharismaListUpdateInfo(iSerializer, this.val$listUpdateInfo);
    }
}

