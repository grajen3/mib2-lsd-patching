/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller;

import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.TunerProblemHandler;
import de.vw.mib.asl.internal.speechtuner.controller.SimpleTunerAction;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SimpleTunerHelpAction
extends SimpleTunerAction {
    public SimpleTunerHelpAction(SpeechTunerServiceManager speechTunerServiceManager, TunerProblemHandler tunerProblemHandler, int n) {
        super(speechTunerServiceManager, tunerProblemHandler, n, 5);
    }
}

