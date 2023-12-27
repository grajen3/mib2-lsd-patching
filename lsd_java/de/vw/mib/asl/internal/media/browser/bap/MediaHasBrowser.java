/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser.bap;

import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.genericevents.GenericEvents;

public class MediaHasBrowser
extends AbstractMediaBrowser {
    public MediaHasBrowser(GenericEvents genericEvents, String string, int n) {
        super(genericEvents, string, n);
    }

    @Override
    public int getDefaultTargetId() {
        return 481235712;
    }

    @Override
    public int getComponentId() {
        return 512;
    }
}

