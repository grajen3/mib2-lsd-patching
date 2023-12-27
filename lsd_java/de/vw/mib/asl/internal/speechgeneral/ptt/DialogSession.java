/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogSessionListener;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.DoublePressKeyAdapter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession$PauseOnDDS;
import de.vw.mib.asl.internal.speechgeneral.ptt.SpeechApplicant;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.dialogactivation.ActivationState;

public class DialogSession
extends DoublePressKeyAdapter
implements DialogSessionListener {
    private final SpeechGeneralLogger logger;
    private final DialogManager dialogManager;
    private SpeechApplicant speechApplicant;
    private boolean isActive = false;
    public static final int[] ABORT_KEYS = new int[]{11, 1, 2, 3, 4, 5, 16, 13, 20, 21, 26, 18, 6, 17, 19, 23, 24, 25, 34, 33};

    DialogSession(DialogManager dialogManager) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getServices());
        this.dialogManager = dialogManager;
        this.logger = new SpeechGeneralLogger("[SpeechDialogSession] ", 4096);
        DialogSession$PauseOnDDS dialogSession$PauseOnDDS = new DialogSession$PauseOnDDS(this, dialogManager, this.logger);
        for (int i2 = 0; i2 < ABORT_KEYS.length; ++i2) {
            ASLSystemFactory.getSystemApi().addKeyListener(ABORT_KEYS[i2], this);
        }
        ASLSystemFactory.getSystemApi().addKeyListener(12, dialogSession$PauseOnDDS);
    }

    public void setApplicant(SpeechApplicant speechApplicant) {
        this.speechApplicant = speechApplicant;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void activate() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("Using speech applicant for activation-request").log();
        }
        this.speechApplicant.requestDialogActivation();
    }

    private void deactivate() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("Deactivating, also informing speech applicant of dialog-finish.").log();
        }
        this.isActive = false;
        this.speechApplicant.onDialogFinished();
    }

    public ActivationState getLastSpeechAdminActivationState() {
        return this.speechApplicant.getLastSpeechAdminActivationState();
    }

    public void readSpeechAdminActivationState() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("Read the current activation state on the speech admin").log();
        }
        this.speechApplicant.readSpeechAdminActivationState();
    }

    public void requestDialogActivationGranted() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("Speech applicant granted activation-request").log();
        }
        this.isActive = true;
        this.dialogManager.startSession(this);
    }

    public void cancel() {
        this.dialogManager.endSession(false);
    }

    @Override
    public void onDoublePressed(int n) {
        if (n == 15) {
            this.dialogManager.endSession(true);
        }
    }

    @Override
    public void onSinglePressed(int n) {
        if (n != 15 && this.isActive) {
            this.dialogManager.endSession(true);
        } else if (n == 15 && this.isActive && this.speechApplicant.isMultipleApplicants()) {
            this.dialogManager.startSession(this);
        }
    }

    @Override
    public void onSingleReleased(int n) {
        if (n == 15) {
            this.dialogManager.startSession(this);
        }
    }

    @Override
    public void onUltraLongPressed(int n) {
        if (n == 15) {
            this.dialogManager.endSession(true);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("DialogSession(isActive=");
        stringBuffer.append(this.isActive);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    @Override
    public void onStarted() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("DialogSessionListener#onStarted( )").log();
        }
    }

    @Override
    public void onFinished() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("DialogSessionListener#onFinished( )").log();
        }
        this.deactivate();
    }
}

