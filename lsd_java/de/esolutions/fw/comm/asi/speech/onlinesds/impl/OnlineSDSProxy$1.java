/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.LanguageInfo;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.LanguageInfoSerializer;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class OnlineSDSProxy$1
implements ISerializable {
    private final /* synthetic */ LanguageInfo[] val$langInfos;
    private final /* synthetic */ OnlineSDSProxy this$0;

    OnlineSDSProxy$1(OnlineSDSProxy onlineSDSProxy, LanguageInfo[] languageInfoArray) {
        this.this$0 = onlineSDSProxy;
        this.val$langInfos = languageInfoArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        LanguageInfoSerializer.putOptionalLanguageInfoVarArray(iSerializer, this.val$langInfos);
    }
}

