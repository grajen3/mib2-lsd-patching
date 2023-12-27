/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser.bap;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.genericevents.GenericEvents;

public class MediaBapBrowser
extends AbstractMediaBrowser {
    public MediaBapBrowser(GenericEvents genericEvents, String string, int n) {
        super(genericEvents, string, n);
    }

    @Override
    public int getDefaultTargetId() {
        return 414126848;
    }

    @Override
    protected void powerOn() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(492571648, true);
    }

    @Override
    public int getComponentId() {
        return 256;
    }
}

