/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup.clients;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.api.speechengine.speakonly.SpeakOnlyService;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeakOnlyHKMuteHandler
extends KeyAdapter
implements ServiceTrackerCustomizer {
    private final BundleContext bundleContext;
    private final AbstractClassifiedLogger logger;
    private SpeakOnlyService speakOnlyService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$PromptEngine;

    public SpeakOnlyHKMuteHandler(BundleContext bundleContext, AbstractClassifiedLogger abstractClassifiedLogger) {
        this.bundleContext = bundleContext;
        this.logger = abstractClassifiedLogger;
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$PromptEngine == null ? (class$de$vw$mib$asl$api$speechengine$PromptEngine = SpeakOnlyHKMuteHandler.class$("de.vw.mib.asl.api.speechengine.PromptEngine")) : class$de$vw$mib$asl$api$speechengine$PromptEngine).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker.open();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        PromptEngine promptEngine = (PromptEngine)this.bundleContext.getService(serviceReference);
        this.speakOnlyService = promptEngine.getSpeakOnlyService(1);
        ASLSystemAPI aSLSystemAPI = ASLSystemFactory.getSystemApi();
        if (aSLSystemAPI == null) {
            this.logger.fatal().append("SpeakOnlyHKMuteHandler: ASLSystemFactory..getSystemApi() == null").log();
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("SpeakOnlyHKMuteHandler: Listening to mute keys now").log();
            }
            aSLSystemAPI.addKeyListener(20, this);
            aSLSystemAPI.addKeyListener(21, this);
        }
        return promptEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void onPressed(int n) {
        if (n == 20) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("onPressed( KEY_MUTE )").log();
            }
            this.onAnyMuteHKPressed();
        }
        if (n == 21) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("onPressed( KEY_MFW_MUTE )").log();
            }
            this.onAnyMuteHKPressed();
        }
    }

    private void onAnyMuteHKPressed() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("Calling cancelCurrentRunningPrompt()").log();
        }
        this.speakOnlyService.cancelCurrentRunningPrompt();
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

