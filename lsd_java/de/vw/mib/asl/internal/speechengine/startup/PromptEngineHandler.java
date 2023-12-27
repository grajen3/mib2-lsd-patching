/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.api.speechengine.speakonly.SpeakOnlyService;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.dialogmanager.SpeakOnlyServiceFactory;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class PromptEngineHandler
implements PromptEngine {
    private final Services aslServices;
    private boolean sdFeatureCollectionReady = false;
    private boolean dialogManagerProxyReady = false;
    private SpeakOnlyServiceFactory speakOnlyServiceFactory;
    private AbstractClassifiedLogger logger;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$PromptEngine;

    PromptEngineHandler(AbstractClassifiedLogger abstractClassifiedLogger, Services services) {
        this.logger = abstractClassifiedLogger;
        this.aslServices = services;
    }

    void dialogManagerProxyReady() {
        this.dialogManagerProxyReady = true;
        this.servicesChanged();
    }

    public void speakOnlyServiceFactoryReady(SpeakOnlyServiceFactory speakOnlyServiceFactory) {
        this.speakOnlyServiceFactory = speakOnlyServiceFactory;
        this.servicesChanged();
    }

    void sdFeatureCollectionReady() {
        this.sdFeatureCollectionReady = true;
        this.servicesChanged();
    }

    private void servicesChanged() {
        if (this.sdFeatureCollectionReady && this.dialogManagerProxyReady && this.speakOnlyServiceFactory != null) {
            this.logger.info().append("PromptEngine Up And Running").log();
            this.aslServices.getBundleContext().registerService((class$de$vw$mib$asl$api$speechengine$PromptEngine == null ? (class$de$vw$mib$asl$api$speechengine$PromptEngine = PromptEngineHandler.class$("de.vw.mib.asl.api.speechengine.PromptEngine")) : class$de$vw$mib$asl$api$speechengine$PromptEngine).getName(), (Object)this, null);
        }
    }

    @Override
    public SpeakOnlyService getSpeakOnlyService(int n) {
        return this.speakOnlyServiceFactory.getSpeakOnlyService(n);
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

