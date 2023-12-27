/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.TunerProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.TunerAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public abstract class TunerEntertainmentSourceAction
extends TunerAction {
    protected final EntertainmentSourceHandler entertainmentSourceHandler;

    public TunerEntertainmentSourceAction(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, TunerProblemHandler tunerProblemHandler, int n) {
        super(speechTunerServiceManager, tunerProblemHandler, n);
        this.entertainmentSourceHandler = entertainmentSourceHandler;
    }
}

