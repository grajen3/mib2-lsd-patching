/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecProxy;
import de.esolutions.fw.comm.dsi.speechrec.impl.DictionaryEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.DictionaryEntry;

class DSISpeechRecProxy$5
implements ISerializable {
    private final /* synthetic */ int val$type;
    private final /* synthetic */ String val$language;
    private final /* synthetic */ String val$format;
    private final /* synthetic */ DictionaryEntry[] val$dictionary;
    private final /* synthetic */ DSISpeechRecProxy this$0;

    DSISpeechRecProxy$5(DSISpeechRecProxy dSISpeechRecProxy, int n, String string, String string2, DictionaryEntry[] dictionaryEntryArray) {
        this.this$0 = dSISpeechRecProxy;
        this.val$type = n;
        this.val$language = string;
        this.val$format = string2;
        this.val$dictionary = dictionaryEntryArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$type);
        iSerializer.putOptionalString(this.val$language);
        iSerializer.putOptionalString(this.val$format);
        DictionaryEntrySerializer.putOptionalDictionaryEntryVarArray(iSerializer, this.val$dictionary);
    }
}

