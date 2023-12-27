/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.target;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.ActivationRequest;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.Deactivation;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget$MediaActivationRequest;

class MediaInternalSourceHandlingTarget$IndependentBrowsingRequest
extends MediaInternalSourceHandlingTarget$MediaActivationRequest
implements ActivationRequest {
    private final MediaCollector media;
    private final /* synthetic */ MediaInternalSourceHandlingTarget this$0;

    public MediaInternalSourceHandlingTarget$IndependentBrowsingRequest(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, MediaCollector mediaCollector) {
        this.this$0 = mediaInternalSourceHandlingTarget;
        super(mediaInternalSourceHandlingTarget, null);
        this.media = mediaCollector;
    }

    @Override
    public Deactivation granted(Runnable runnable) {
        MediaInternalSourceHandlingTarget.access$402(this.this$0, runnable);
        MediaInternalSourceHandlingTarget.access$500(this.this$0).setMediaActive(MediaInternalSourceHandlingTarget.access$700(this.this$0));
        this.this$0.fireResponse(true, MediaInternalSourceHandlingTarget.access$800());
        return this;
    }

    @Override
    public void rejected() {
        MediaInternalSourceHandlingTarget.access$900(this.this$0, false, MediaInternalSourceHandlingTarget.access$800(), "EntertainmentManager rejected");
    }

    @Override
    public void cancel() {
        boolean bl = MediaInternalSourceHandlingTarget.access$500(this.this$0).cancelEntertainment();
        if (bl) {
            this.this$0.sendSafe(MediaInternalSourceHandlingTarget.access$1000(this.this$0, 330240768, -1517944576));
        }
    }

    public String toString() {
        return new StringBuffer().append("independent browsing request for ").append(this.media).toString();
    }
}

