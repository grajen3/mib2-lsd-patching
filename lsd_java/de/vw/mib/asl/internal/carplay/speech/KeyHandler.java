/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.speech;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.speech.SpeechApplicant;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.log4mib.LogMessage;

public class KeyHandler
extends KeyAdapter {
    private final String classname;
    private HsmTarget target;
    private SpeechApplicant speech = null;
    private CarPlayGlobalProperies properties;

    public KeyHandler(SpeechApplicant speechApplicant, HsmTarget hsmTarget, CarPlayGlobalProperies carPlayGlobalProperies) {
        this.classname = "KeyHandler";
        this.speech = speechApplicant;
        this.target = hsmTarget;
        this.properties = carPlayGlobalProperies;
        ASLSystemFactory.getSystemApi().addKeyListener(15, this);
    }

    @Override
    public void onPressed(int n) {
        this.properties.setDelayBorrowAudio(false);
        this.properties.setLastPTTKey(1);
        this.speech.setWasSiriStart(false);
        if (this.properties.isConnected() && this.speech != null) {
            if (!this.speech.isCarplayActive() && this.speech.isOtherSpeechActive() == ActivationState.INACTIVE) {
                this.speech.PrewarmSiri();
            } else if (this.speech.isCarplayActive()) {
                this.target.getDSICarPlay().requestSIRIAction(1);
            }
        }
    }

    @Override
    public void onReleased(int n) {
        this.properties.setLastPTTKey(3);
        if (this.properties.isConnected() && this.speech != null) {
            this.speech.StopSiri();
        }
    }

    @Override
    public void onMultiPressed(int n) {
    }

    @Override
    public void onLongPressed(int n) {
        this.properties.setLastPTTKey(2);
        this.properties.setDelayBorrowAudio(false);
        if (this.properties.isConnected() && this.speech != null) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("KeyHandler").append(".onLongPressed()").log();
            }
            if (!this.speech.isCarplayActive()) {
                this.speech.readActivationState();
            } else if (this.speech.isCarplayActive()) {
                // empty if block
            }
        }
    }

    @Override
    public void onLongReleased(int n) {
        this.properties.setLastPTTKey(4);
        if (this.properties.isConnected() && this.speech != null && (this.speech.isCarplayActive() || this.speech.wasSiriStart())) {
            this.speech.StopSiri();
        }
    }
}

