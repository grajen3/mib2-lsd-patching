/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayPresetsListRecordSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

class DSICarKombiProxy$17
implements ISerializable {
    private final /* synthetic */ CarArrayListUpdateInfo val$arrayHeader;
    private final /* synthetic */ DCDisplayPresetsListRecord[] val$data;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$17(DSICarKombiProxy dSICarKombiProxy, CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        this.this$0 = dSICarKombiProxy;
        this.val$arrayHeader = carArrayListUpdateInfo;
        this.val$data = dCDisplayPresetsListRecordArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, this.val$arrayHeader);
        DCDisplayPresetsListRecordSerializer.putOptionalDCDisplayPresetsListRecordVarArray(iSerializer, this.val$data);
    }
}

