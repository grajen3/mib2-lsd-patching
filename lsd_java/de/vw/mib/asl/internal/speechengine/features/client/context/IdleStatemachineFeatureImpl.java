/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.context;

import de.vw.mib.asl.api.speechengine.features.client.context.FeatureParamContextKeys;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.context.IdleStatemachineContextFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class IdleStatemachineFeatureImpl
extends AbstractGenericFeature
implements IdleStatemachineContextFeature,
FeatureParamContextKeys {
    private boolean idle;
    private boolean idleValid = false;

    public IdleStatemachineFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setIdle(boolean bl) {
        this.idle = bl;
        this.idleValid = true;
    }

    @Override
    public boolean isIdleValid() {
        return this.idleValid;
    }

    @Override
    public boolean isIdle() {
        return this.idle;
    }

    @Override
    public int getFeatureType() {
        return 202;
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        switch (n) {
            case 2010: {
                this.setIdle(bl);
                break;
            }
            default: {
                super.setBoolean(n, bl);
            }
        }
    }
}

