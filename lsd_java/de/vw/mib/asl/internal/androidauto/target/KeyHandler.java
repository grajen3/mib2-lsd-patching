/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoGlobalProperties;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.SpeechHandler;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;

public class KeyHandler
extends KeyAdapter {
    AndroidAutoTarget target;
    AndroidAutoGlobalProperties properties;
    StartupHandler startupHandler;
    SpeechHandler speechHandler;

    public KeyHandler(AndroidAutoTarget androidAutoTarget, AndroidAutoGlobalProperties androidAutoGlobalProperties, StartupHandler startupHandler, SpeechHandler speechHandler) {
        this.target = androidAutoTarget;
        this.properties = androidAutoGlobalProperties;
        this.startupHandler = startupHandler;
        this.speechHandler = speechHandler;
        ASLSystemFactory.getSystemApi().addKeyListener(15, this);
    }

    @Override
    public void onLongPressed(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("KeyHandler::onLongPressed - keyId = ").append(n).toString());
        }
        this.properties.setHkPTTState(3);
        if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered() && !this.properties.isGALSpeechActive()) {
            this.speechHandler.checkAndStartGALSpeech();
        }
    }

    @Override
    public void onLongReleased(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("KeyHandler::onLongReleased - keyId = ").append(n).toString());
        }
        this.properties.setHkPTTState(4);
        if (this.properties.isPTTPressedToStartGALSpeech()) {
            this.properties.setPTTPressedToStartGALSpeech(false);
        } else if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered() && this.properties.isGALSpeechActive()) {
            this.target.getDSIAndroidAuto2().postButtonEvent(84, 1);
        }
    }

    @Override
    public void onMultiPressed(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("KeyHandler::onMultiPressed - keyId = ").append(n).toString());
        }
    }

    @Override
    public void onPressed(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("KeyHandler::onPressed - keyId = ").append(n).toString());
        }
        this.properties.setHkPTTState(1);
        if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered() && this.properties.isGALSpeechActive()) {
            this.target.getDSIAndroidAuto2().postButtonEvent(84, 0);
        }
    }

    @Override
    public void onReleased(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("KeyHandler::onReleased - keyId = ").append(n).toString());
        }
        this.properties.setHkPTTState(2);
        if (this.startupHandler.isDeviceConnected() && this.startupHandler.isDSI2Registered() && this.properties.isGALSpeechActive()) {
            this.target.getDSIAndroidAuto2().postButtonEvent(84, 1);
        }
    }

    @Override
    public void onUltraLongPressed(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("KeyHandler::onUltraLongPressed - keyId = ").append(n).toString());
        }
    }
}

