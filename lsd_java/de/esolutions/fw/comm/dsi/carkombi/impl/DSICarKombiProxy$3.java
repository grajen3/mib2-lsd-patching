/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCSpeedWarningSettingsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;

class DSICarKombiProxy$3
implements ISerializable {
    private final /* synthetic */ BCSpeedWarningSettings val$speedWarning;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$3(DSICarKombiProxy dSICarKombiProxy, BCSpeedWarningSettings bCSpeedWarningSettings) {
        this.this$0 = dSICarKombiProxy;
        this.val$speedWarning = bCSpeedWarningSettings;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BCSpeedWarningSettingsSerializer.putOptionalBCSpeedWarningSettings(iSerializer, this.val$speedWarning);
    }
}

