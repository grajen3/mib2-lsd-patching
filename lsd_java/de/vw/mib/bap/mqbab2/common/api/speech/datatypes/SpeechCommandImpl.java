/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.speech.datatypes;

import de.vw.mib.bap.mqbab2.common.api.speech.datatypes.SpeechCommand;

public class SpeechCommandImpl
implements SpeechCommand {
    private String commandText;
    private boolean dynamicParts;

    public SpeechCommandImpl(String string, boolean bl) {
        this.commandText = string;
        this.dynamicParts = bl;
    }

    @Override
    public String getText() {
        return this.commandText;
    }

    @Override
    public boolean containsDynamicParts() {
        return this.dynamicParts;
    }
}

