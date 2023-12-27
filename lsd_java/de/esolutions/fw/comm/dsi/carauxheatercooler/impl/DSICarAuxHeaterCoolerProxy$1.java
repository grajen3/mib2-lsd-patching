/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerTimerSerializer;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;

class DSICarAuxHeaterCoolerProxy$1
implements ISerializable {
    private final /* synthetic */ AuxHeaterCoolerTimer val$timer;
    private final /* synthetic */ DSICarAuxHeaterCoolerProxy this$0;

    DSICarAuxHeaterCoolerProxy$1(DSICarAuxHeaterCoolerProxy dSICarAuxHeaterCoolerProxy, AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        this.this$0 = dSICarAuxHeaterCoolerProxy;
        this.val$timer = auxHeaterCoolerTimer;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AuxHeaterCoolerTimerSerializer.putOptionalAuxHeaterCoolerTimer(iSerializer, this.val$timer);
    }
}

