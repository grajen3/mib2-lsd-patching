/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.common;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.mediacontrol.adapter.common.ModelView;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import java.util.ArrayList;

public abstract class AbstractModelDomain
extends AbstractASLTarget {
    private ArrayList mModelViews = new ArrayList(3);

    public AbstractModelDomain(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.startupDomain();
                break;
            }
            case 107: {
                this.shutdownDomain();
                break;
            }
            default: {
                if (Util.isNullOrEmpty(this.mModelViews)) break;
                for (int i2 = 0; i2 < this.mModelViews.size(); ++i2) {
                    ((ModelView)this.mModelViews.get(i2)).handleAction(eventGeneric);
                }
            }
        }
    }

    protected abstract void startupDomain() {
    }

    protected abstract void shutdownDomain() {
    }

    protected void addView(ModelView modelView) {
        if (modelView == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.mModelViews.add(modelView);
        this.addObservers(modelView.getSupportedActions());
    }

    protected void removeView(ModelView modelView) {
        if (modelView == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.removeObservers(modelView.getSupportedActions());
        this.mModelViews.remove(modelView);
    }

    protected void removeAllViews() {
        if (!Util.isNullOrEmpty(this.mModelViews)) {
            for (int i2 = 0; i2 < this.mModelViews.size(); ++i2) {
                this.removeObservers(((ModelView)this.mModelViews.get(i2)).getSupportedActions());
            }
            this.mModelViews.clear();
        }
    }
}

