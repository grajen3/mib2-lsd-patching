/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.context;

import de.vw.mib.asl.api.speechengine.features.client.context.FeatureParamContextKeys;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.context.TeleprompterOnOffContextFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class TeleprompterOnOffContextFeatureImpl
extends AbstractGenericFeature
implements TeleprompterOnOffContextFeature,
FeatureParamContextKeys {
    private Event teleprompterOnEvent;
    private Event teleprompterOffEvent;
    private boolean telepromterStateChanging;
    private boolean telepromterStateChangingValid = false;

    public TeleprompterOnOffContextFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setTeleprompterStateChanging(boolean bl) {
        this.telepromterStateChanging = bl;
        this.telepromterStateChangingValid = true;
    }

    private void setTeleprompterOffEvent(Event event) {
        this.teleprompterOffEvent = event;
    }

    private void setTeleprompterOnEvent(Event event) {
        this.teleprompterOnEvent = event;
    }

    @Override
    public boolean isTeleprompterStateChangingValid() {
        return this.telepromterStateChangingValid;
    }

    @Override
    public boolean isTeleprompterStateChanging() {
        return this.telepromterStateChanging;
    }

    @Override
    public boolean isTeleprompterOnEventValid() {
        return this.teleprompterOnEvent != null;
    }

    @Override
    public boolean isTeleprompterOffEventValid() {
        return this.teleprompterOffEvent != null;
    }

    @Override
    public Event getTeleprompterOnEvent() {
        return this.teleprompterOnEvent;
    }

    @Override
    public Event getTeleprompterOffEvent() {
        return this.teleprompterOffEvent;
    }

    @Override
    public int getFeatureType() {
        return 203;
    }

    @Override
    public void setEvent(int n, Event event) {
        switch (n) {
            case 2020: {
                this.setTeleprompterOnEvent(event);
                break;
            }
            case 2021: {
                this.setTeleprompterOffEvent(event);
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
            case 2022: {
                this.setTeleprompterStateChanging(bl);
                break;
            }
            default: {
                super.setBoolean(n, bl);
            }
        }
    }
}

