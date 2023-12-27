/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.BackMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class BackFeatureImpl
extends AbstractGenericFeature
implements BackMasterFeature,
FeatureParamMasterKeys {
    private int backCommand;
    private OrderedPrompts backPrompts;
    boolean backCommandValid = false;

    public BackFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    public void setBackCommand(int n) {
        this.backCommand = n;
        this.backCommandValid = true;
    }

    public void setBackPrompts(OrderedPrompts orderedPrompts) {
        this.backPrompts = orderedPrompts;
    }

    @Override
    public boolean isBackCommandValid() {
        return this.backCommandValid;
    }

    @Override
    public boolean isBackPromptsValid() {
        return this.backPrompts != null;
    }

    @Override
    public int getBackCommand() {
        return this.backCommand;
    }

    @Override
    public OrderedPrompts getBackPrompts() {
        return this.backPrompts;
    }

    @Override
    public int getFeatureType() {
        return 102;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 1010: {
                this.setBackCommand(n2);
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
            case 1011: {
                this.setBackPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

