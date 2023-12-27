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

public class UnavailableInitializing
extends AbstractDialogActivator {
    private final SpeechGeneralLogger logger;
    private final SystemEventDispatcher systemEventDispatcher;
    private final int eventId;
    private final BeepPlayer beepPlayer;

    public UnavailableInitializing(DialogSession dialogSession, SystemEventDispatcher systemEventDispatcher, GenericEvents genericEvents, Services services) {
        super("UnavailableInitializing", dialogSession, services);
        this.logger = new SpeechGeneralLogger(new StringBuffer().append("[").append(this.name).append("] ").toString(), 4096);
        this.systemEventDispatcher = systemEventDispatcher;
        this.beepPlayer = new BeepPlayer(genericEvents);
        this.eventId = 721104896;
    }

    @Override
    public void onSingleReleased(int n) {
        this.logger.info().append("show popup: initializing Speech - please wait ... ").log();
        this.systemEventDispatcher.createAndSubmitHMIEvent(this.eventId);
        this.beepPlayer.playErrorBeep();
    }
}

