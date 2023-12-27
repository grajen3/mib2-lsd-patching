/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerExtendedConditioningSerializer;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;

class DSICarAuxHeaterCoolerProxy$4
implements ISerializable {
    private final /* synthetic */ AuxHeaterCoolerExtendedConditioning val$setup;
    private final /* synthetic */ DSICarAuxHeaterCoolerProxy this$0;

    DSICarAuxHeaterCoolerProxy$4(DSICarAuxHeaterCoolerProxy dSICarAuxHeaterCoolerProxy, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
        this.this$0 = dSICarAuxHeaterCoolerProxy;
        this.val$setup = auxHeaterCoolerExtendedConditioning;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AuxHeaterCoolerExtendedConditioningSerializer.putOptionalAuxHeaterCoolerExtendedConditioning(iSerializer, this.val$setup);
    }
}

