/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.AbortMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class AbortFeatureImpl
extends AbstractGenericFeature
implements AbortMasterFeature,
FeatureParamMasterKeys {
    private int abortCommand;
    private OrderedPrompts abortPrompts;
    private boolean abortCommandValid = false;

    public AbortFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    public void setAbortCommand(int n) {
        this.abortCommand = n;
        this.abortCommandValid = true;
    }

    public void setAbortPrompts(OrderedPrompts orderedPrompts) {
        this.abortPrompts = orderedPrompts;
    }

    @Override
    public boolean isAbortCommandValid() {
        return this.abortCommandValid;
    }

    @Override
    public boolean isAbortPromptsValid() {
        return this.abortPrompts != null;
    }

    @Override
    public int getAbortCommand() {
        return this.abortCommand;
    }

    @Override
    public OrderedPrompts getAbortPrompts() {
        return this.abortPrompts;
    }

    @Override
    public int getFeatureType() {
        return 101;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 1001: {
                this.setAbortCommand(n2);
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
            case 1002: {
                this.setAbortPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

