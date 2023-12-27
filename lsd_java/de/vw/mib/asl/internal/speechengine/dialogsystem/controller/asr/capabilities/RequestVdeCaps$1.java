/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.capabilities;

import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.capabilities.RequestVdeCaps;

class RequestVdeCaps$1
implements Capabilities {
    private final /* synthetic */ RequestVdeCaps this$0;

    RequestVdeCaps$1(RequestVdeCaps requestVdeCaps) {
        this.this$0 = requestVdeCaps;
    }

    @Override
    public boolean isSpelling() {
        return false;
    }

    @Override
    public boolean isOneShot() {
        return false;
    }

    @Override
    public boolean isFullWord() {
        return false;
    }

    @Override
    public String[] getGrammarLanguage() {
        return new String[0];
    }
}

