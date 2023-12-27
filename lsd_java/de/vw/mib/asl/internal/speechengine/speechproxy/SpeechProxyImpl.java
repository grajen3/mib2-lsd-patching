/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.speechproxy;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.speechproxy.SpeechProxy;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerProxy;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class SpeechProxyImpl
implements SpeechProxy {
    static final String LOGGING_PREFIX;
    private final AbstractClassifiedLogger logger;
    private volatile DialogManagerProxy dialogManager;

    public SpeechProxyImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        this.logger = abstractClassifiedLogger;
    }

    @Override
    public void setFeatures(int n, Feature[] featureArray) {
        if (this.dialogManager == null) {
            if (this.logger != null) {
                this.logger.error().append("setFeatures() called, before DialogManager was set.").log();
            }
            return;
        }
        this.dialogManager.setFeatures(n, featureArray);
    }

    @Override
    public void updateFeatures(int n, Feature[] featureArray) {
        if (this.dialogManager == null) {
            if (this.logger != null) {
                this.logger.error().append("updateFeatures() called, before DialogManager was set.").log();
            }
            return;
        }
        this.dialogManager.updateFeatures(n, featureArray);
    }

    void setDialogManager(DialogManagerProxy dialogManagerProxy) {
        this.dialogManager = dialogManagerProxy;
    }
}

