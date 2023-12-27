/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DisplayContentSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.DisplayContent;

class DSICarParkingSystemProxy$14
implements ISerializable {
    private final /* synthetic */ DisplayContent val$content;
    private final /* synthetic */ int val$reason;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$14(DSICarParkingSystemProxy dSICarParkingSystemProxy, DisplayContent displayContent, int n) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$content = displayContent;
        this.val$reason = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DisplayContentSerializer.putOptionalDisplayContent(iSerializer, this.val$content);
        iSerializer.putInt32(this.val$reason);
    }
}

