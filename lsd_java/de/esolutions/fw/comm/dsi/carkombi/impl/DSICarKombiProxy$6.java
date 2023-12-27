/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.comm.dsi.carkombi.impl.HUDContentSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDContent;

class DSICarKombiProxy$6
implements ISerializable {
    private final /* synthetic */ HUDContent val$content;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$6(DSICarKombiProxy dSICarKombiProxy, HUDContent hUDContent) {
        this.this$0 = dSICarKombiProxy;
        this.val$content = hUDContent;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        HUDContentSerializer.putOptionalHUDContent(iSerializer, this.val$content);
    }
}

