/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy;
import de.esolutions.fw.comm.dsi.speechrec.impl.GrammarSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.Grammar;

class DSISpeechRecProxy$2
implements ISerializable {
    private final /* synthetic */ Grammar[] val$grammarObject;
    private final /* synthetic */ DSISpeechRecProxy this$0;

    DSISpeechRecProxy$2(DSISpeechRecProxy dSISpeechRecProxy, Grammar[] grammarArray) {
        this.this$0 = dSISpeechRecProxy;
        this.val$grammarObject = grammarArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        GrammarSerializer.putOptionalGrammarVarArray(iSerializer, this.val$grammarObject);
    }
}

