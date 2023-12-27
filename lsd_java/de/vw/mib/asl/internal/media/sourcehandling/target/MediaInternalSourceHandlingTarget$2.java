/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.target;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget;

class MediaInternalSourceHandlingTarget$2
implements ASLComponentAPICallback {
    private final /* synthetic */ MediaInternalSourceHandlingTarget this$0;

    MediaInternalSourceHandlingTarget$2(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget) {
        this.this$0 = mediaInternalSourceHandlingTarget;
    }

    @Override
    public void registered(Class clazz, Object object) {
        EntertainmentManagerCoreService entertainmentManagerCoreService = (EntertainmentManagerCoreService)object;
        MediaObjectAccessor.mMediaController.sourcesAvailable(this.this$0);
        boolean bl = entertainmentManagerCoreService.getContext() == 2;
        MediaInternalSourceHandlingTarget.access$000(this.this$0, bl, SourceHandlingPersistence.getInstance().getObjectId() & 0xFFFF0000);
        if (bl) {
            MediaInternalSourceHandlingTarget.access$200(this.this$0, MediaInternalSourceHandlingTarget.access$100(this.this$0).mediaCollectorFromObjectId(SourceHandlingPersistence.getInstance().getObjectId()));
        }
    }
}

