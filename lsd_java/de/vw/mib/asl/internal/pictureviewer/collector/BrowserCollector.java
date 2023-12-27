/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer.collector;

import org.dsi.ifc.filebrowser.BrowsedFile;

public final class BrowserCollector {
    private BrowsedFile mEntry = null;
    private boolean mShowErrorText = false;
    private boolean mActivated = false;

    public BrowsedFile getEntry() {
        return this.mEntry;
    }

    public void setEntry(BrowsedFile browsedFile) {
        this.mEntry = browsedFile;
    }

    public boolean isShowErrorText() {
        return this.mShowErrorText;
    }

    public void setShowErrorText(boolean bl) {
        this.mShowErrorText = bl;
    }

    public boolean isActive() {
        return this.mActivated;
    }

    public void setActive(boolean bl) {
        this.mActivated = bl;
    }
}

