/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt.activator;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.AbstractDialogActivator;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.BeepPlayer;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.GenericEvents;

public class UnavailableByLanguage
extends AbstractDialogActivator {
    private final SpeechGeneralLogger logger;
    private final SystemEventDispatcher systemEventDispatcher;
    private final int eventId;
    private final BeepPlayer beepPlayer;

    public UnavailableByLanguage(DialogSession dialogSession, SystemEventDispatcher systemEventDispatcher, boolean bl, GenericEvents genericEvents, Services services) {
        super("UnavailableByLanguage", dialogSession, services);
        this.logger = new SpeechGeneralLogger(new StringBuffer().append("[").append(this.name).append("] ").toString(), 4096);
        this.systemEventDispatcher = systemEventDispatcher;
        this.beepPlayer = new BeepPlayer(genericEvents);
        this.eventId = bl ? 653996032 : 754659328;
    }

    @Override
    public void onSingleReleased(int n) {
        this.logger.info().append("show popup: Speech language is changing or not-supported").log();
        this.systemEventDispatcher.createAndSubmitHMIEvent(this.eventId);
        this.beepPlayer.playErrorBeep();
    }
}

