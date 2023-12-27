/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling;

import de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence$1$1;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence$1$2;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;

class SourceHandlingPersistence$1
implements DsiAwareProfileChangeListener {
    private final /* synthetic */ ISources val$sourcesComponent;
    private final /* synthetic */ SourceHandlingPersistence this$0;

    SourceHandlingPersistence$1(SourceHandlingPersistence sourceHandlingPersistence, ISources iSources) {
        this.this$0 = sourceHandlingPersistence;
        this.val$sourcesComponent = iSources;
    }

    @Override
    public void prepareForProfileChange(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        ServiceManager.logger.trace(1024, "SHP.prepareForProfileChange()");
        dsiAwareProfileChangeListenerCallback.notifyTaskDone(true);
    }

    @Override
    public void changeProfilePreDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        ServiceManager.logger.trace(1024, "SHP.changeProfilePreDsi()");
        if (this.val$sourcesComponent.isMediaContext()) {
            this.val$sourcesComponent.setDisconnectedStateWithCallback(new SourceHandlingPersistence$1$1(this, dsiAwareProfileChangeListenerCallback));
        } else {
            dsiAwareProfileChangeListenerCallback.notifyTaskDone(true);
        }
    }

    @Override
    public void changeProfilePostDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        ServiceManager.logger.trace(1024, "SHP.changeProfilePostDsi()");
        SourceHandlingPersistence.access$002(this.this$0, SourceHandlingPersistence.access$100(this.this$0).loadSourcesPersistence());
        int n = this.this$0.getObjectId();
        MediaCollector mediaCollector = this.val$sourcesComponent.getSourceByID(n);
        ServiceManager.logger.trace(1024, new StringBuffer().append("SHP.changeProfilePostDsi(): now objectId ").append(n).append(" which is ").append(mediaCollector.toStringShort()).toString());
        SourceIconController.getInstance().setCurrentAudioSource(mediaCollector);
        EntertainmentManagerCoreService entertainmentManagerCoreService = (EntertainmentManagerCoreService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(SourceHandlingPersistence.class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService == null ? (SourceHandlingPersistence.class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService = SourceHandlingPersistence.class$("de.vw.mib.asl.framework.api.entertainmentmanager.core.EntertainmentManagerCoreService")) : SourceHandlingPersistence.class$de$vw$mib$asl$framework$api$entertainmentmanager$core$EntertainmentManagerCoreService);
        if (null != entertainmentManagerCoreService && entertainmentManagerCoreService.getContext() == 2) {
            Command command = MediaObjectAccessor.mMediaController.insertActivateSourceCmd(mediaCollector, true);
            command.setCommandCallback(new SourceHandlingPersistence$1$2(this, dsiAwareProfileChangeListenerCallback));
        } else {
            dsiAwareProfileChangeListenerCallback.notifyTaskDone(true);
        }
    }
}

