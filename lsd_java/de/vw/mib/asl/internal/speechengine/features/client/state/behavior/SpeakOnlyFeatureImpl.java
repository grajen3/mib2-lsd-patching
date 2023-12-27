/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state.behavior;

import de.vw.mib.asl.api.speechengine.features.client.state.FeatureParamStateKeys;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.behavior.SpeakOnlyStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class SpeakOnlyFeatureImpl
extends AbstractGenericFeature
implements SpeakOnlyStateFeature,
FeatureParamStateKeys {
    private int sessionType;
    private boolean sessionTypeValid = false;

    public SpeakOnlyFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setSessionType(int n) {
        this.sessionType = n;
        this.sessionTypeValid = true;
    }

    @Override
    public boolean isSessionTypeValid() {
        return this.sessionTypeValid;
    }

    @Override
    public int getSessionType() {
        return this.sessionType;
    }

    @Override
    public int getFeatureType() {
        return 306;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 3070: {
                this.setSessionType(n2);
                break;
            }
            default: {
                super.setInt(n, n2);
            }
        }
    }
}

