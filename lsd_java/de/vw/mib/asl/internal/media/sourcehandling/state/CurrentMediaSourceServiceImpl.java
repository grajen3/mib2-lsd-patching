/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.state;

import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceListener;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import java.util.ArrayList;

class CurrentMediaSourceServiceImpl
implements CurrentMediaSourceService {
    private Medium currentMedium = null;
    private Source currentSource;
    private final ArrayList currentMediaSourceListeners = new ArrayList();
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService;

    CurrentMediaSourceServiceImpl() {
    }

    void updateSource(Medium medium) {
        if (medium == this.currentMedium) {
            return;
        }
        this.currentMedium = medium;
        this.currentSource = MediaCollector.createSourceState(this.currentMedium);
        if (ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService == null ? (class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService = CurrentMediaSourceServiceImpl.class$("de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService")) : class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService) == null) {
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService == null ? (class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService = CurrentMediaSourceServiceImpl.class$("de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService")) : class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService, this);
        }
        this.notifyListeners();
    }

    private void notifyListeners() {
        for (int i2 = 0; i2 < this.currentMediaSourceListeners.size(); ++i2) {
            CurrentMediaSourceListener currentMediaSourceListener = (CurrentMediaSourceListener)this.currentMediaSourceListeners.get(i2);
            currentMediaSourceListener.updateCurrentMediaSource(this.currentSource);
        }
    }

    void dsiUpdate() {
        if (this.currentMedium.getCurrentInfo().getFlags() != this.currentMedium.getPreviousInfo().getFlags() || this.currentMedium.getCurrentInfo().getMediaType() != this.currentMedium.getPreviousInfo().getMediaType() || this.currentMedium.getCurrentState().getErrorType() != this.currentMedium.getPreviousState().getErrorType()) {
            this.currentSource = MediaCollector.createSourceState(this.currentMedium);
            this.notifyListeners();
        }
    }

    @Override
    public void registerListener(CurrentMediaSourceListener currentMediaSourceListener) {
        currentMediaSourceListener = (CurrentMediaSourceListener)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(currentMediaSourceListener);
        currentMediaSourceListener.updateCurrentMediaSource(this.currentSource);
        this.currentMediaSourceListeners.add(currentMediaSourceListener);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

