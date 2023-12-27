/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.client.state.FeatureParamStateKeys;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.BackstackStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class BackstackFeatureImpl
extends AbstractGenericFeature
implements BackstackStateFeature,
FeatureParamStateKeys {
    private Event backstackEvent;
    private boolean addToBackstack;
    private boolean addToBackstackValid = false;

    public BackstackFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setBackstackEvent(Event event) {
        this.backstackEvent = event;
    }

    private void setAddToBackstack(boolean bl) {
        this.addToBackstack = bl;
        this.addToBackstackValid = true;
    }

    @Override
    public boolean isBackstackEventValid() {
        return this.backstackEvent != null;
    }

    @Override
    public Event getBackstackEvent() {
        return this.backstackEvent;
    }

    @Override
    public boolean isAddToBackstackValid() {
        return this.addToBackstackValid;
    }

    @Override
    public boolean isAddToBackstack() {
        return this.addToBackstack;
    }

    @Override
    public int getFeatureType() {
        return 301;
    }

    @Override
    public void setEvent(int n, Event event) {
        switch (n) {
            case 3010: {
                this.setBackstackEvent(event);
                break;
            }
            default: {
                super.setEvent(n, event);
            }
        }
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        switch (n) {
            case 3011: {
                this.setAddToBackstack(bl);
                break;
            }
            default: {
                super.setBoolean(n, bl);
            }
        }
    }
}

