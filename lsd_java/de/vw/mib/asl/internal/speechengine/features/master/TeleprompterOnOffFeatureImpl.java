/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.TeleprompterOnOffMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class TeleprompterOnOffFeatureImpl
extends AbstractGenericFeature
implements TeleprompterOnOffMasterFeature,
FeatureParamMasterKeys {
    private int teleprompterOnCommand;
    private int teleprompterOffCommand;
    private OrderedPrompts teleprompterOnPrompts;
    private OrderedPrompts teleprompterOffPrompts;
    private boolean teleprompterOnCommandValid = false;
    private boolean teleprompterOffCommandValid = false;

    public TeleprompterOnOffFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setTeleprompterOnCommand(int n) {
        this.teleprompterOnCommand = n;
        this.teleprompterOnCommandValid = true;
    }

    private void setTeleprompterOffCommand(int n) {
        this.teleprompterOffCommand = n;
        this.teleprompterOffCommandValid = true;
    }

    private void setTeleprompterOnPrompts(OrderedPrompts orderedPrompts) {
        this.teleprompterOnPrompts = orderedPrompts;
    }

    private void setTeleprompterOffPrompts(OrderedPrompts orderedPrompts) {
        this.teleprompterOffPrompts = orderedPrompts;
    }

    @Override
    public boolean isTeleprompterOnCommandValid() {
        return this.teleprompterOnCommandValid;
    }

    @Override
    public boolean isTeleprompterOffCommandValid() {
        return this.teleprompterOffCommandValid;
    }

    @Override
    public boolean isTeleprompterOnPromptsValid() {
        return this.teleprompterOnPrompts != null;
    }

    @Override
    public boolean isTeleprompterOffPromptsValid() {
        return this.teleprompterOffPrompts != null;
    }

    @Override
    public int getTeleprompterOnCommand() {
        return this.teleprompterOnCommand;
    }

    @Override
    public int getTeleprompterOffCommand() {
        return this.teleprompterOffCommand;
    }

    @Override
    public OrderedPrompts getTeleprompterOnPrompts() {
        return this.teleprompterOnPrompts;
    }

    @Override
    public OrderedPrompts getTeleprompterOffPrompts() {
        return this.teleprompterOffPrompts;
    }

    @Override
    public int getFeatureType() {
        return 112;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 1110: {
                this.setTeleprompterOnCommand(n2);
                break;
            }
            case 1111: {
                this.setTeleprompterOffCommand(n2);
                break;
            }
            default: {
                super.setInt(n, n2);
            }
        }
    }

    @Override
    public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
        switch (n) {
            case 1112: {
                this.setTeleprompterOnPrompts(orderedPrompts);
                break;
            }
            case 1113: {
                this.setTeleprompterOffPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

