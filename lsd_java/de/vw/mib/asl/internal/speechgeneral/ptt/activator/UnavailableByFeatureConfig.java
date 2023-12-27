/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt.activator;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.AbstractDialogActivator;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.BeepPlayer;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.GenericEvents;

public class UnavailableByFeatureConfig
extends AbstractDialogActivator {
    private final SpeechGeneralLogger logger;
    private final ConfigurationManager configManager;
    private final SystemEventDispatcher systemEventDispatcher;
    private final BeepPlayer beepPlayer;

    public UnavailableByFeatureConfig(DialogSession dialogSession, ConfigurationManager configurationManager, SystemEventDispatcher systemEventDispatcher, GenericEvents genericEvents, Services services) {
        super("UnavailableByFeatureConfig", dialogSession, services);
        this.logger = new SpeechGeneralLogger(new StringBuffer().append("[").append(this.name).append("] ").toString(), 4096);
        this.configManager = configurationManager;
        this.systemEventDispatcher = systemEventDispatcher;
        this.beepPlayer = new BeepPlayer(genericEvents);
    }

    @Override
    public void onSingleReleased(int n) {
        if (!this.configManager.isFeatureFlagSet(582) && this.configManager.isFeatureFlagSet(535)) {
            this.logger.info().append("show popup: Speech-Unavailable-By-SWaP. ").log();
            this.systemEventDispatcher.createAndSubmitHMIEvent(687550464);
            if (!this.beepPlayer.playErrorBeep()) {
                this.logger.warn().append("Playing beep tone failed. ").log();
            } else if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("Playing beep tone. ").log();
            }
        }
    }
}

