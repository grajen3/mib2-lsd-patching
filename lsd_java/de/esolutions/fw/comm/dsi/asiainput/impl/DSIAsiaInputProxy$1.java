/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput.impl;

import de.esolutions.fw.comm.dsi.asiainput.impl.DSIAsiaInputProxy;
import de.esolutions.fw.comm.dsi.asiainput.impl.UserDefinedEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiainput.UserDefinedEntry;

class DSIAsiaInputProxy$1
implements ISerializable {
    private final /* synthetic */ UserDefinedEntry val$entry;
    private final /* synthetic */ DSIAsiaInputProxy this$0;

    DSIAsiaInputProxy$1(DSIAsiaInputProxy dSIAsiaInputProxy, UserDefinedEntry userDefinedEntry) {
        this.this$0 = dSIAsiaInputProxy;
        this.val$entry = userDefinedEntry;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UserDefinedEntrySerializer.putOptionalUserDefinedEntry(iSerializer, this.val$entry);
    }
}

