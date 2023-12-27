/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationListener;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.internal.media.sourcehandling.clients.SourceStateUpdater;
import de.vw.mib.collections.ints.IntOptHashSet;

class SourceStateUpdater$1
implements MediaIndicationListener {
    private final /* synthetic */ IntOptHashSet val$deviceSet;
    private final /* synthetic */ MediaIndicationListener val$listener;
    private final /* synthetic */ SourceStateUpdater this$0;

    SourceStateUpdater$1(SourceStateUpdater sourceStateUpdater, IntOptHashSet intOptHashSet, MediaIndicationListener mediaIndicationListener) {
        this.this$0 = sourceStateUpdater;
        this.val$deviceSet = intOptHashSet;
        this.val$listener = mediaIndicationListener;
    }

    @Override
    public void onSourceChanged(Source source, Source source2) {
        if (this.val$deviceSet.contains(source.getSourceId().getDeviceType())) {
            this.val$listener.onSourceChanged(source, source2);
        }
    }
}

