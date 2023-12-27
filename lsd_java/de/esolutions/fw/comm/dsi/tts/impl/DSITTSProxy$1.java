/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts.impl;

import de.esolutions.fw.comm.dsi.tts.impl.DSITTSProxy;
import de.esolutions.fw.comm.dsi.tts.impl.TTSPromptSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tts.TTSPrompt;

class DSITTSProxy$1
implements ISerializable {
    private final /* synthetic */ short val$sourceID;
    private final /* synthetic */ TTSPrompt val$prompt;
    private final /* synthetic */ DSITTSProxy this$0;

    DSITTSProxy$1(DSITTSProxy dSITTSProxy, short s, TTSPrompt tTSPrompt) {
        this.this$0 = dSITTSProxy;
        this.val$sourceID = s;
        this.val$prompt = tTSPrompt;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt16(this.val$sourceID);
        TTSPromptSerializer.putOptionalTTSPrompt(iSerializer, this.val$prompt);
    }
}

