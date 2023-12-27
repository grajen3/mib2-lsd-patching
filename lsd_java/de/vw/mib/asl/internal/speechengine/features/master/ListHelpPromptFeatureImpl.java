/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.ListHelpPromptMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class ListHelpPromptFeatureImpl
extends AbstractGenericFeature
implements ListHelpPromptMasterFeature,
FeatureParamMasterKeys {
    private int listHelpPrompt;
    private boolean listHelpPromptValid = false;

    public ListHelpPromptFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setListHelpPrompt(int n) {
        this.listHelpPrompt = n;
        this.listHelpPromptValid = true;
    }

    @Override
    public int getListHelpPrompt() {
        return this.listHelpPrompt;
    }

    @Override
    public boolean isListHelpPromptValid() {
        return this.listHelpPromptValid;
    }

    @Override
    public int getFeatureType() {
        return 111;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 1100: {
                this.setListHelpPrompt(n2);
                break;
            }
            default: {
                super.setInt(n, n2);
            }
        }
    }
}

