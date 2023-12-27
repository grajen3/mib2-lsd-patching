/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy;
import de.esolutions.fw.comm.dsi.speechrec.impl.GrammarInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.GrammarInfo;

class DSISpeechRecProxy$3
implements ISerializable {
    private final /* synthetic */ GrammarInfo[] val$info;
    private final /* synthetic */ DSISpeechRecProxy this$0;

    DSISpeechRecProxy$3(DSISpeechRecProxy dSISpeechRecProxy, GrammarInfo[] grammarInfoArray) {
        this.this$0 = dSISpeechRecProxy;
        this.val$info = grammarInfoArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        GrammarInfoSerializer.putOptionalGrammarInfoVarArray(iSerializer, this.val$info);
    }
}

