/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.PauseMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class PauseFeatureImpl
extends AbstractGenericFeature
implements PauseMasterFeature,
FeatureParamMasterKeys {
    private int pauseCommand;
    private OrderedPrompts commandPausePrompts;
    private OrderedPrompts errorPausePrompts;
    private OrderedPrompts pauseTimeoutPrompts;
    private boolean pauseCommandValid = false;

    public PauseFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setPauseCommand(int n) {
        this.pauseCommand = n;
        this.pauseCommandValid = true;
    }

    private void setCommandPausePrompts(OrderedPrompts orderedPrompts) {
        this.commandPausePrompts = orderedPrompts;
    }

    private void setErrorPausePrompts(OrderedPrompts orderedPrompts) {
        this.errorPausePrompts = orderedPrompts;
    }

    private void setPauseTimeoutPrompts(OrderedPrompts orderedPrompts) {
        this.pauseTimeoutPrompts = orderedPrompts;
    }

    @Override
    public boolean isPauseCommandValid() {
        return this.pauseCommandValid;
    }

    @Override
    public boolean isCommandPausePromptsValid() {
        return this.commandPausePrompts != null;
    }

    @Override
    public boolean isPauseTimeoutPromptsValid() {
        return this.pauseTimeoutPrompts != null;
    }

    @Override
    public boolean isErrorPausePromptsValid() {
        return this.errorPausePrompts != null;
    }

    @Override
    public int getPauseCommand() {
        return this.pauseCommand;
    }

    @Override
    public OrderedPrompts getCommandPausePrompts() {
        return this.commandPausePrompts;
    }

    @Override
    public OrderedPrompts getPauseTimeoutPrompts() {
        return this.pauseTimeoutPrompts;
    }

    @Override
    public OrderedPrompts getErrorPausePrompts() {
        return this.errorPausePrompts;
    }

    @Override
    public int getFeatureType() {
        return 107;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 1060: {
                this.setPauseCommand(n2);
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
            case 1061: {
                this.setCommandPausePrompts(orderedPrompts);
                break;
            }
            case 1062: {
                this.setPauseTimeoutPrompts(orderedPrompts);
                break;
            }
            case 1063: {
                this.setErrorPausePrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

