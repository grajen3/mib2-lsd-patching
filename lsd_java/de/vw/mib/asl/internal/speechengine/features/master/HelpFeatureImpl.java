/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.HelpMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class HelpFeatureImpl
extends AbstractGenericFeature
implements HelpMasterFeature,
FeatureParamMasterKeys {
    private int helpCommand;
    private OrderedPrompts feedbackPrompts;
    private boolean helpCommandValid = false;

    public HelpFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setHelpCommand(int n) {
        this.helpCommand = n;
        this.helpCommandValid = true;
    }

    private void setFeedbackPrompts(OrderedPrompts orderedPrompts) {
        this.feedbackPrompts = orderedPrompts;
    }

    @Override
    public boolean isHelpCommandValid() {
        return this.helpCommandValid;
    }

    @Override
    public int getHelpCommand() {
        return this.helpCommand;
    }

    @Override
    public boolean isFeedbackPromptsValid() {
        return this.feedbackPrompts != null;
    }

    @Override
    public OrderedPrompts getFeedbackPrompts() {
        return this.feedbackPrompts;
    }

    @Override
    public int getFeatureType() {
        return 104;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 1030: {
                this.setHelpCommand(n2);
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
            case 1031: {
                this.setFeedbackPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

