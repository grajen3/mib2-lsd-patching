/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiainput.impl;

import de.esolutions.fw.comm.dsi.asiainput.impl.DSIAsiaInputProxy;
import de.esolutions.fw.comm.dsi.asiainput.impl.WordDatabaseSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiainput.WordDatabase;

class DSIAsiaInputProxy$2
implements ISerializable {
    private final /* synthetic */ WordDatabase[] val$databases;
    private final /* synthetic */ DSIAsiaInputProxy this$0;

    DSIAsiaInputProxy$2(DSIAsiaInputProxy dSIAsiaInputProxy, WordDatabase[] wordDatabaseArray) {
        this.this$0 = dSIAsiaInputProxy;
        this.val$databases = wordDatabaseArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        WordDatabaseSerializer.putOptionalWordDatabaseVarArray(iSerializer, this.val$databases);
    }
}

