/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.client.state.FeatureParamStateKeys;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexTeleprompterDataFeature;
import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.TeleprompterDataStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class TeleprompterDataStateFeatureImpl
extends AbstractGenericFeature
implements TeleprompterDataStateFeature,
ComplexTeleprompterDataFeature,
FeatureParamStateKeys {
    private DynamicString[] commandExamples;
    private DynamicString headlineText;
    private int teleprompterType;
    private boolean teleprompterTypeValid = false;

    public TeleprompterDataStateFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    @Override
    public DynamicString[] getCommandExamples() {
        return this.commandExamples;
    }

    @Override
    public DynamicString getHeadlineText() {
        return this.headlineText;
    }

    @Override
    public boolean isCommandExamplesValid() {
        return this.commandExamples != null;
    }

    @Override
    public boolean isHeadlineTextValid() {
        return this.headlineText != null;
    }

    @Override
    public int getTeleprompterType() {
        return this.teleprompterType;
    }

    @Override
    public boolean isTeleprompterTypeValid() {
        return this.teleprompterTypeValid;
    }

    @Override
    public int getFeatureType() {
        return 309;
    }

    @Override
    public void setCommandExamples(DynamicString[] dynamicStringArray) {
        this.commandExamples = dynamicStringArray;
    }

    @Override
    public void setHeadline(DynamicString dynamicString) {
        this.headlineText = dynamicString;
    }

    @Override
    public void setTeleprompterType(int n) {
        this.teleprompterType = n;
        this.teleprompterTypeValid = true;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 3081: {
                this.setTeleprompterType(n2);
                break;
            }
            default: {
                super.setInt(n, n2);
            }
        }
    }
}

