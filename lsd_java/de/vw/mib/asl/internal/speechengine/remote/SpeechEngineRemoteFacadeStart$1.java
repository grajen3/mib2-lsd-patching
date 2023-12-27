/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.remote;

import de.vw.mib.asl.internal.speechengine.remote.SpeechEngineRemoteFacadeStart;
import de.vw.mib.speech.remote.SpeechEngineRemote;
import org.osgi.framework.BundleContext;

class SpeechEngineRemoteFacadeStart$1
implements Runnable {
    private final /* synthetic */ BundleContext val$bundleContext;
    private final /* synthetic */ SpeechEngineRemote val$speechEngineRemote;
    private final /* synthetic */ SpeechEngineRemoteFacadeStart this$0;

    SpeechEngineRemoteFacadeStart$1(SpeechEngineRemoteFacadeStart speechEngineRemoteFacadeStart, BundleContext bundleContext, SpeechEngineRemote speechEngineRemote) {
        this.this$0 = speechEngineRemoteFacadeStart;
        this.val$bundleContext = bundleContext;
        this.val$speechEngineRemote = speechEngineRemote;
    }

    @Override
    public void run() {
        this.val$bundleContext.registerService((SpeechEngineRemoteFacadeStart.class$de$vw$mib$speech$remote$SpeechEngineRemote == null ? (SpeechEngineRemoteFacadeStart.class$de$vw$mib$speech$remote$SpeechEngineRemote = SpeechEngineRemoteFacadeStart.class$("de.vw.mib.speech.remote.SpeechEngineRemote")) : SpeechEngineRemoteFacadeStart.class$de$vw$mib$speech$remote$SpeechEngineRemote).getName(), (Object)this.val$speechEngineRemote, null);
    }
}

