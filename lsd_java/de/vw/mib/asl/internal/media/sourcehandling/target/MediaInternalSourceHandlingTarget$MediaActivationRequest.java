/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.target;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.Deactivation;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget$1;

class MediaInternalSourceHandlingTarget$MediaActivationRequest
implements Deactivation {
    private final /* synthetic */ MediaInternalSourceHandlingTarget this$0;

    private MediaInternalSourceHandlingTarget$MediaActivationRequest(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget) {
        this.this$0 = mediaInternalSourceHandlingTarget;
    }

    public int getContext() {
        return 2;
    }

    @Override
    public void deactivate(int n, Runnable runnable) {
        if (n == 2) {
            runnable.run();
        } else {
            MediaInternalSourceHandlingTarget.access$1102(this.this$0, runnable);
            MediaInternalSourceHandlingTarget.access$1200(this.this$0);
        }
    }

    /* synthetic */ MediaInternalSourceHandlingTarget$MediaActivationRequest(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget, MediaInternalSourceHandlingTarget$1 mediaInternalSourceHandlingTarget$1) {
        this(mediaInternalSourceHandlingTarget);
    }
}

