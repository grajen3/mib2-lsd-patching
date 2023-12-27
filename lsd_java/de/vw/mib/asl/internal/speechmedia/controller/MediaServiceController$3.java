/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.media.services.browser.MediaBrowserService;
import de.vw.mib.asl.api.media.services.player.MediaPlayerService;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaListService;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;

class MediaServiceController$3
implements ASLComponentAPICallback {
    private final /* synthetic */ MediaServiceController this$0;

    MediaServiceController$3(MediaServiceController mediaServiceController) {
        this.this$0 = mediaServiceController;
    }

    @Override
    public void registered(Class clazz, Object object) {
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace().append("Service received: ").append(clazz.getName()).log();
        }
        if (clazz == (MediaServiceController.class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService == null ? (MediaServiceController.class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService = MediaServiceController.class$("de.vw.mib.asl.api.media.services.sources.medialist.MediaListService")) : MediaServiceController.class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService)) {
            this.this$0.mediaListService = (MediaListService)object;
            this.this$0.mediaListService.addSourceStateListener(this.this$0);
        } else if (clazz == (MediaServiceController.class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService == null ? (MediaServiceController.class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService = MediaServiceController.class$("de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService")) : MediaServiceController.class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService)) {
            this.this$0.currentMediaSourceService = (CurrentMediaSourceService)object;
            this.this$0.currentMediaSourceService.registerListener(this.this$0);
        } else if (clazz == (MediaServiceController.class$de$vw$mib$asl$api$media$services$player$MediaPlayerService == null ? (MediaServiceController.class$de$vw$mib$asl$api$media$services$player$MediaPlayerService = MediaServiceController.class$("de.vw.mib.asl.api.media.services.player.MediaPlayerService")) : MediaServiceController.class$de$vw$mib$asl$api$media$services$player$MediaPlayerService)) {
            this.this$0.mediaPlayerService = (MediaPlayerService)object;
            this.this$0.mediaPlayerService.addMediaPlaySimilarListener(this.this$0);
            this.this$0.mediaPlayerService.addMediaPlayViewListener(this.this$0);
            this.this$0.mediaPlayerService.addMediaActivationStateListener(this.this$0);
        } else if (clazz == (MediaServiceController.class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService == null ? (MediaServiceController.class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService = MediaServiceController.class$("de.vw.mib.asl.api.media.services.browser.MediaBrowserService")) : MediaServiceController.class$de$vw$mib$asl$api$media$services$browser$MediaBrowserService)) {
            this.this$0.mediaBrowserService = (MediaBrowserService)object;
            this.this$0.mediaBrowserService.addSpeakableElementsListener(this.this$0);
        } else if (clazz == (MediaServiceController.class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (MediaServiceController.class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = MediaServiceController.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : MediaServiceController.class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService)) {
            this.this$0.emService = (EntertainmentManagerService)object;
            this.this$0.emService.addListener(this.this$0);
        }
        this.checkFullInitialization();
    }

    private void checkFullInitialization() {
        if (this.this$0.mediaListService != null && this.this$0.mediaPlayerService != null && this.this$0.currentMediaSourceService != null && this.this$0.emService != null && this.this$0.mediaBrowserService != null) {
            this.this$0.notifyMediaDomainAvailable(true);
        }
    }
}

