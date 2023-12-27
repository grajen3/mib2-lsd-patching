/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.speech;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.asl.internal.carlife.speech.SpeechApplicant;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;

public class KeyHandler
extends KeyAdapter {
    private final String classname;
    private final CarlifeHSMTarget target;
    private final SpeechApplicant speech;
    private final CarLifeGlobalProperties properties;

    public KeyHandler(SpeechApplicant speechApplicant, CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties) {
        this.classname = "KeyHandler";
        Preconditions.checkNotNull(carlifeHSMTarget, "CarlifeHSMTarget must not be null!");
        Preconditions.checkNotNull(carLifeGlobalProperties, "Porperties must not be null!");
        Preconditions.checkNotNull(speechApplicant, "SpeechApplicant must not be null!");
        this.speech = speechApplicant;
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
        ASLSystemFactory.getSystemApi().addKeyListener(15, this);
    }

    @Override
    public void onPressed(int n) {
    }

    @Override
    public void onReleased(int n) {
        if (this.properties.isConnected() && this.properties.isDSIRegistered() && this.speech.isCarLifeActive()) {
            this.target.getDSICarLife().postButtonEvent(21, 0);
            this.target.getDSICarLife().postButtonEvent(21, 1);
        }
    }

    @Override
    public void onMultiPressed(int n) {
    }

    @Override
    public void onLongPressed(int n) {
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            if (this.speech.isOtherSpeechActive() == ActivationState.ACTIVE) {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("KeyHandler").append("::onLongPressed - ignored - other speech active").log();
                }
            } else {
                this.target.getDSICarLife().postButtonEvent(20, 0);
                this.target.getDSICarLife().postButtonEvent(20, 1);
            }
        }
    }

    @Override
    public void onLongReleased(int n) {
    }
}

