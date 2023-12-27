/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.ddp20;

import org.dsi.ifc.ddp20.ProjectInfo;

public class VersionInfo {
    public int ident;
    public int manufacturer;
    public String swInfo;
    public ProjectInfo projectInfo;
    public int protocolVersion;
    public int characterVersion;
    public int symbolVersion;
    public int frameVersion;
    public int bitmapVersion;
    public int displayInfo;
    public boolean windowCaching;
    public int numEntriesMenu;
    public int numEntriesSubmenu;
    public int numEntriesPopup;
    public int numLaneGuidanceBoxes;
    public int numFrameIDs;
    public int[] frameIDs;

    public VersionInfo() {
        this.ident = 0;
        this.manufacturer = 0;
        this.swInfo = null;
        this.projectInfo = null;
        this.protocolVersion = 0;
        this.characterVersion = 0;
        this.symbolVersion = 0;
        this.frameVersion = 0;
        this.bitmapVersion = 0;
        this.displayInfo = 0;
        this.windowCaching = false;
        this.numEntriesMenu = 0;
        this.numEntriesSubmenu = 0;
        this.numEntriesPopup = 0;
        this.numLaneGuidanceBoxes = 0;
        this.numFrameIDs = 0;
        this.frameIDs = null;
    }

    public VersionInfo(int n, int n2, String string, ProjectInfo projectInfo, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl, int n9, int n10, int n11, int n12, int n13, int[] nArray) {
        this.ident = n;
        this.manufacturer = n2;
        this.swInfo = string;
        this.projectInfo = projectInfo;
        this.protocolVersion = n3;
        this.characterVersion = n4;
        this.symbolVersion = n5;
        this.frameVersion = n6;
        this.bitmapVersion = n7;
        this.displayInfo = n8;
        this.windowCaching = bl;
        this.numEntriesMenu = n9;
        this.numEntriesSubmenu = n10;
        this.numEntriesPopup = n11;
        this.numLaneGuidanceBoxes = n12;
        this.numFrameIDs = n13;
        this.frameIDs = nArray;
    }

    public int getIdent() {
        return this.ident;
    }

    public int getManufacturer() {
        return this.manufacturer;
    }

    public String getSwInfo() {
        return this.swInfo;
    }

    public ProjectInfo getProjectInfo() {
        return this.projectInfo;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public int getCharacterVersion() {
        return this.characterVersion;
    }

    public int getSymbolVersion() {
        return this.symbolVersion;
    }

    public int getFrameVersion() {
        return this.frameVersion;
    }

    public int getBitmapVersion() {
        return this.bitmapVersion;
    }

    public int getDisplayInfo() {
        return this.displayInfo;
    }

    public boolean isWindowCaching() {
        return this.windowCaching;
    }

    public int getNumEntriesMenu() {
        return this.numEntriesMenu;
    }

    public int getNumEntriesSubmenu() {
        return this.numEntriesSubmenu;
    }

    public int getNumEntriesPopup() {
        return this.numEntriesPopup;
    }

    public int getNumLaneGuidanceBoxes() {
        return this.numLaneGuidanceBoxes;
    }

    public int getNumFrameIDs() {
        return this.numFrameIDs;
    }

    public int[] getFrameIDs() {
        return this.frameIDs;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2000);
        stringBuffer.append("VersionInfo");
        stringBuffer.append('(');
        stringBuffer.append("ident");
        stringBuffer.append('=');
        stringBuffer.append(this.ident);
        stringBuffer.append(',');
        stringBuffer.append("manufacturer");
        stringBuffer.append('=');
        stringBuffer.append(this.manufacturer);
        stringBuffer.append(',');
        stringBuffer.append("swInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.swInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("projectInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.projectInfo);
        stringBuffer.append(',');
        stringBuffer.append("protocolVersion");
        stringBuffer.append('=');
        stringBuffer.append(this.protocolVersion);
        stringBuffer.append(',');
        stringBuffer.append("characterVersion");
        stringBuffer.append('=');
        stringBuffer.append(this.characterVersion);
        stringBuffer.append(',');
        stringBuffer.append("symbolVersion");
        stringBuffer.append('=');
        stringBuffer.append(this.symbolVersion);
        stringBuffer.append(',');
        stringBuffer.append("frameVersion");
        stringBuffer.append('=');
        stringBuffer.append(this.frameVersion);
        stringBuffer.append(',');
        stringBuffer.append("bitmapVersion");
        stringBuffer.append('=');
        stringBuffer.append(this.bitmapVersion);
        stringBuffer.append(',');
        stringBuffer.append("displayInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.displayInfo);
        stringBuffer.append(',');
        stringBuffer.append("windowCaching");
        stringBuffer.append('=');
        stringBuffer.append(this.windowCaching);
        stringBuffer.append(',');
        stringBuffer.append("numEntriesMenu");
        stringBuffer.append('=');
        stringBuffer.append(this.numEntriesMenu);
        stringBuffer.append(',');
        stringBuffer.append("numEntriesSubmenu");
        stringBuffer.append('=');
        stringBuffer.append(this.numEntriesSubmenu);
        stringBuffer.append(',');
        stringBuffer.append("numEntriesPopup");
        stringBuffer.append('=');
        stringBuffer.append(this.numEntriesPopup);
        stringBuffer.append(',');
        stringBuffer.append("numLaneGuidanceBoxes");
        stringBuffer.append('=');
        stringBuffer.append(this.numLaneGuidanceBoxes);
        stringBuffer.append(',');
        stringBuffer.append("numFrameIDs");
        stringBuffer.append('=');
        stringBuffer.append(this.numFrameIDs);
        stringBuffer.append(',');
        stringBuffer.append("frameIDs");
        stringBuffer.append('[');
        if (this.frameIDs != null) {
            stringBuffer.append(this.frameIDs.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.frameIDs != null) {
            int n = this.frameIDs.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.frameIDs[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.frameIDs);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

