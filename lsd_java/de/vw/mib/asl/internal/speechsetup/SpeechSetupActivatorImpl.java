/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechsetup;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.internal.speechsetup.SpeechSetupControlSettingsTarget;
import de.vw.mib.asl.internal.speechsetup.ifc.SpeechSetupActivator;
import de.vw.mib.asl.internal.speechsetup.ifc.SpeechSetupParameters;
import de.vw.mib.genericevents.EventDispatcherHSM;

public class SpeechSetupActivatorImpl
implements SpeechSetupActivator {
    SpeechSettingsService settingsService = null;
    ASLPropertyManager datapool = null;

    @Override
    public void activate(SpeechSetupParameters speechSetupParameters) {
        EventDispatcherHSM eventDispatcherHSM = speechSetupParameters.getGenericEvents().getEventDispatcher();
        try {
            eventDispatcherHSM.registerTarget(new SpeechSetupControlSettingsTarget(speechSetupParameters));
        }
        catch (Exception exception) {
            speechSetupParameters.getLogger().error().append("Error while registering target to EventDispatcher.").log();
        }
    }
}

