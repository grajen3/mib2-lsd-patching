/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state.behavior;

import de.vw.mib.asl.api.speechengine.features.client.state.FeatureParamStateKeys;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.behavior.DialogStepBehaviorStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class DialogStepBehaviorFeatureImpl
extends AbstractGenericFeature
implements DialogStepBehaviorStateFeature,
FeatureParamStateKeys {
    private boolean keepPrompts;
    private boolean startRecognizerAutomatically;
    private boolean endSession;
    private int endSessionType;
    private boolean pauseAutomatically;
    private boolean playHelpPrompt;
    private boolean keepPromptsValid = false;
    private boolean startRecognizerAutomaticallyValid = false;
    private boolean endSessionValid = false;
    private boolean endSessionTypeValid = false;
    private boolean pauseAutomaticallyValid = false;
    private boolean playHelpPromptValid = false;

    public DialogStepBehaviorFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setKeepPrompts(boolean bl) {
        this.keepPrompts = bl;
        this.keepPromptsValid = true;
    }

    private void setStartRecognizerAutomatically(boolean bl) {
        this.startRecognizerAutomatically = bl;
        this.startRecognizerAutomaticallyValid = true;
    }

    private void setEndSession(boolean bl) {
        this.endSession = bl;
        this.endSessionTypeValid = true;
    }

    private void setEndSessionType(int n) {
        this.endSessionType = n;
        this.endSessionTypeValid = true;
    }

    private void setPauseAutomatically(boolean bl) {
        this.pauseAutomatically = bl;
        this.pauseAutomaticallyValid = true;
    }

    private void setPlayHelpPrompt(boolean bl) {
        this.playHelpPrompt = bl;
        this.playHelpPromptValid = true;
    }

    @Override
    public boolean isKeepPromptsValid() {
        return this.keepPromptsValid;
    }

    @Override
    public boolean isKeepPrompts() {
        return this.keepPrompts;
    }

    @Override
    public boolean isEndSessionTypeValid() {
        return this.endSessionTypeValid;
    }

    @Override
    public boolean isStartRecognizerAutomaticallyValid() {
        return this.startRecognizerAutomaticallyValid;
    }

    @Override
    public boolean isEndSessionValid() {
        return this.endSessionValid && this.endSessionTypeValid;
    }

    @Override
    public boolean isPauseAutomaticallyValid() {
        return this.pauseAutomaticallyValid;
    }

    @Override
    public boolean isPlayHelpPromptValid() {
        return this.playHelpPromptValid;
    }

    @Override
    public boolean isStartRecognizerAutomatically() {
        return this.startRecognizerAutomatically;
    }

    @Override
    public boolean isEndSession() {
        return this.endSession;
    }

    @Override
    public int getEndSessionType() {
        return this.endSessionType;
    }

    @Override
    public boolean isPauseAutomatically() {
        return this.pauseAutomatically;
    }

    @Override
    public boolean isPlayHelpPrompt() {
        return this.playHelpPrompt;
    }

    @Override
    public int getFeatureType() {
        return 305;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 3003: {
                this.setEndSessionType(n2);
                break;
            }
            default: {
                super.setInt(n, n2);
            }
        }
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        switch (n) {
            case 3008: {
                this.setKeepPrompts(bl);
                break;
            }
            case 3001: {
                this.setStartRecognizerAutomatically(bl);
                break;
            }
            case 3002: {
                this.setEndSession(bl);
                break;
            }
            case 3005: {
                this.setPauseAutomatically(bl);
                break;
            }
            case 3007: {
                this.setPlayHelpPrompt(bl);
                break;
            }
            default: {
                super.setBoolean(n, bl);
            }
        }
    }
}

