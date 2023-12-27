/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechheadline.dialog.state;

import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterStateConsumer;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataConsumer;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineLogger;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineServiceManager;

public class ButtonStateHandler
implements TeleprompterStateConsumer,
TeleprompterDataConsumer {
    private static final String LOGGER_PREFIX;
    private SpeechHeadlineServiceManager serviceManager;
    private SpeechHeadlineLogger logger;
    public static int BUTTONSTATE_BACK;
    public static int BUTTONSTATE_CLOSE;
    private int teleprompterState;
    private int teleprompterType;
    private int buttonState;

    public ButtonStateHandler(SpeechHeadlineServiceManager speechHeadlineServiceManager) {
        this.serviceManager = speechHeadlineServiceManager;
        this.logger = speechHeadlineServiceManager.createSpeechHeadlineLogger("[ButtonStateHandler] ");
        this.teleprompterState = 0;
        this.teleprompterType = 2;
        this.buttonState = BUTTONSTATE_CLOSE;
        speechHeadlineServiceManager.writeIntegerToDatapool(-222084864, 2);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Set back/close button state to CLOSE for initialization.");
        }
    }

    public int getButtonState() {
        return this.buttonState;
    }

    private void sendButtonStateToModel() {
        if (this.teleprompterType == 4 || this.teleprompterType == 3) {
            if (this.teleprompterState == 0) {
                this.buttonState = BUTTONSTATE_BACK;
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("activated use case or topic teleprompter = back button in headline");
                }
            } else {
                this.buttonState = BUTTONSTATE_CLOSE;
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("deactivated use case or topic teleprompter = close button in headline");
                }
            }
        } else {
            this.buttonState = BUTTONSTATE_CLOSE;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("main menu or dialog teleprompter = close button in headline");
            }
        }
        if (this.buttonState == BUTTONSTATE_BACK) {
            this.serviceManager.writeIntegerToDatapool(-222084864, 1);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Button state is now 1 (BACK).");
            }
        } else {
            this.serviceManager.writeIntegerToDatapool(-222084864, 2);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Button state is now 2 (CLOSE).");
            }
        }
    }

    @Override
    public void onTeleprompterStateChanged(int n) {
        this.teleprompterState = n;
        this.sendButtonStateToModel();
    }

    @Override
    public void onTeleprompterDataChanged(TeleprompterData teleprompterData) {
        if (teleprompterData != null) {
            if (this.logger.isTraceEnabled()) {
                String string = "";
                string = teleprompterData.getTeleprompterType() == 2 ? "Main Menu" : (teleprompterData.getTeleprompterType() == 4 ? "Use Case" : (teleprompterData.getTeleprompterType() == 3 ? "Topic" : (teleprompterData.getTeleprompterType() == 5 ? "Dialog" : "Idle / Not Active")));
                this.logger.trace(new StringBuffer().append("received new teleprompter type ").append(string).toString());
            }
            this.teleprompterType = teleprompterData.getTeleprompterType();
            this.sendButtonStateToModel();
        }
    }

    static {
        BUTTONSTATE_BACK = 0;
        BUTTONSTATE_CLOSE = 1;
    }
}

