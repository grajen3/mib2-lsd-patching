/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.capabilities;

import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.capabilities.RequestVdeCaps;
import org.dsi.ifc.speechrec.VDECapabilities;

class RequestVdeCaps$2
implements Capabilities {
    private final /* synthetic */ VDECapabilities val$capabilities;
    private final /* synthetic */ RequestVdeCaps this$0;

    RequestVdeCaps$2(RequestVdeCaps requestVdeCaps, VDECapabilities vDECapabilities) {
        this.this$0 = requestVdeCaps;
        this.val$capabilities = vDECapabilities;
    }

    @Override
    public boolean isSpelling() {
        return this.val$capabilities.isSpelling();
    }

    @Override
    public boolean isOneShot() {
        return this.val$capabilities.isOneShot();
    }

    @Override
    public boolean isFullWord() {
        return this.val$capabilities.isFullWord();
    }

    @Override
    public String[] getGrammarLanguage() {
        return this.val$capabilities.getGrammarLanguage();
    }
}

