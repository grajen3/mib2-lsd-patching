/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationListener;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.sourcehandling.clients.SourceStateUpdater;

class SourceStateUpdater$2
implements MediaIndicationListener {
    private final /* synthetic */ MediaIndicationListener val$listener;
    private final /* synthetic */ SourceStateUpdater this$0;

    SourceStateUpdater$2(SourceStateUpdater sourceStateUpdater, MediaIndicationListener mediaIndicationListener) {
        this.this$0 = sourceStateUpdater;
        this.val$listener = mediaIndicationListener;
    }

    @Override
    public void onSourceChanged(Source source, Source source2) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("filtered insertion status, activeMedia: ").append(SourceStateUpdater.access$000(this.this$0).isValue()).log();
        }
        if (!(SourceStateUpdater.access$000(this.this$0).isValue() || source2 != null && source.getInsertion() == source2.getInsertion())) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("filtered insertion status, source: ").append(source.getSourceId()).append(", current insertion: ").append(source.getInsertion()).append(", previous insertion: ").append(source2.getInsertion()).append(", listener: ").append(this.val$listener.toString()).log();
            }
            this.val$listener.onSourceChanged(source, source2);
        }
    }
}

