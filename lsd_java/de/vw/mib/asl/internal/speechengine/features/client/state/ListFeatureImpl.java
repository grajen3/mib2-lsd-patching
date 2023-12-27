/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.client.state.FeatureParamStateKeys;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.ListStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class ListFeatureImpl
extends AbstractGenericFeature
implements ListStateFeature,
FeatureParamStateKeys {
    private boolean listHelpPromptActivated;
    private boolean nbestList;
    private boolean listHelpPromptActivatedValid = false;
    private boolean nbestListValid = false;

    public ListFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setListHelpPromptActivated(boolean bl) {
        this.listHelpPromptActivated = bl;
        this.listHelpPromptActivatedValid = true;
    }

    private void setNbestList(boolean bl) {
        this.nbestList = bl;
        this.nbestListValid = true;
    }

    @Override
    public boolean isListHelpPromptActivatedValid() {
        return this.listHelpPromptActivatedValid;
    }

    @Override
    public boolean isListHelpPromptActivated() {
        return this.listHelpPromptActivated;
    }

    @Override
    public boolean isNbestList() {
        return this.nbestList;
    }

    @Override
    public boolean isNbestListValid() {
        return this.nbestListValid;
    }

    @Override
    public int getFeatureType() {
        return 307;
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        switch (n) {
            case 3050: {
                this.setListHelpPromptActivated(bl);
                break;
            }
            case 3051: {
                this.setNbestList(bl);
                break;
            }
            default: {
                super.setBoolean(n, bl);
            }
        }
    }
}

