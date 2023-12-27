/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.tileselection;

import de.vw.mib.cio.CioIntent;

public class TileAppDescriptor {
    private CioIntent tileApp;
    private boolean selected;

    public TileAppDescriptor(CioIntent cioIntent, boolean bl) {
        this.tileApp = cioIntent;
        this.selected = bl;
    }

    public CioIntent getTileApp() {
        return this.tileApp;
    }

    public void setTileApp(CioIntent cioIntent) {
        this.tileApp = cioIntent;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.selected ? 1231 : 1237);
        n2 = 31 * n2 + (this.tileApp == null ? 0 : this.tileApp.hashCode());
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        TileAppDescriptor tileAppDescriptor = (TileAppDescriptor)object;
        if (this.selected != tileAppDescriptor.selected) {
            return false;
        }
        return !(this.tileApp == null ? tileAppDescriptor.tileApp != null : !this.tileApp.equals(tileAppDescriptor.tileApp));
    }
}

