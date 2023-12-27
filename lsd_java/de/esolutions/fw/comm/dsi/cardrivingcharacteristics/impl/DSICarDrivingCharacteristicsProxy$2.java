/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.CharismaSetupTableWithoutOptionMaskSerializer;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

class DSICarDrivingCharacteristicsProxy$2
implements ISerializable {
    private final /* synthetic */ int val$profileID;
    private final /* synthetic */ CharismaSetupTableWithoutOptionMask[] val$setupTable2;
    private final /* synthetic */ DSICarDrivingCharacteristicsProxy this$0;

    DSICarDrivingCharacteristicsProxy$2(DSICarDrivingCharacteristicsProxy dSICarDrivingCharacteristicsProxy, int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        this.this$0 = dSICarDrivingCharacteristicsProxy;
        this.val$profileID = n;
        this.val$setupTable2 = charismaSetupTableWithoutOptionMaskArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$profileID);
        CharismaSetupTableWithoutOptionMaskSerializer.putOptionalCharismaSetupTableWithoutOptionMaskVarArray(iSerializer, this.val$setupTable2);
    }
}

