/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemProxy;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DisplayContentSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.DisplayContent;

class DSICarParkingSystemProxy$13
implements ISerializable {
    private final /* synthetic */ DisplayContent val$content;
    private final /* synthetic */ DSICarParkingSystemProxy this$0;

    DSICarParkingSystemProxy$13(DSICarParkingSystemProxy dSICarParkingSystemProxy, DisplayContent displayContent) {
        this.this$0 = dSICarParkingSystemProxy;
        this.val$content = displayContent;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DisplayContentSerializer.putOptionalDisplayContent(iSerializer, this.val$content);
    }
}

