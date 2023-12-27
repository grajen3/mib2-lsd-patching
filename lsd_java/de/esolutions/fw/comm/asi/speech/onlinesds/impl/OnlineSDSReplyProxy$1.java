/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.LanguageInfoSerializer;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class OnlineSDSReplyProxy$1
implements ISerializable {
    private final /* synthetic */ LanguageInfo val$langInfo;
    private final /* synthetic */ OnlineSDSReplyProxy this$0;

    OnlineSDSReplyProxy$1(OnlineSDSReplyProxy onlineSDSReplyProxy, LanguageInfo languageInfo) {
        this.this$0 = onlineSDSReplyProxy;
        this.val$langInfo = languageInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        LanguageInfoSerializer.putOptionalLanguageInfo(iSerializer, this.val$langInfo);
    }
}

