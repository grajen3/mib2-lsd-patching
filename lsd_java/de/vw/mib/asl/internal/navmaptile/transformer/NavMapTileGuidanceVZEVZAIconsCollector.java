/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile.transformer;

public class NavMapTileGuidanceVZEVZAIconsCollector {
    private boolean additionalIconActive = false;
    private boolean mainIconActive = false;
    private boolean speedIconActive = false;
    private String additionalIconString = "";
    private String mainIconString = "";
    private String speedIconString = "";

    public boolean getAdditionalIconActive() {
        return this.additionalIconActive;
    }

    public void setAdditionalIconActive(boolean bl) {
        this.additionalIconActive = bl;
    }

    public boolean getMainIconActive() {
        return this.mainIconActive;
    }

    public void setMainIconActive(boolean bl) {
        this.mainIconActive = bl;
    }

    public boolean getSpeedIconActive() {
        return this.speedIconActive;
    }

    public void setSpeedIconActive(boolean bl) {
        this.speedIconActive = bl;
    }

    public String getAdditionalIconString() {
        return this.additionalIconString;
    }

    public void setAdditionalIconString(String string) {
        this.additionalIconString = string;
    }

    public String getMainIconString() {
        return this.mainIconString;
    }

    public void setMainIconString(String string) {
        this.mainIconString = string;
    }

    public String getSpeedIconString() {
        return this.speedIconString;
    }

    public void setSpeedIconString(String string) {
        this.speedIconString = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("NavMapTileGuidanceVZEVZAIconsCollector: ");
        stringBuffer.append("mainIconActive: ");
        stringBuffer.append(this.mainIconActive);
        stringBuffer.append(", mainIconString: ");
        stringBuffer.append(this.mainIconString);
        stringBuffer.append(", additionalIconActive: ");
        stringBuffer.append(this.additionalIconActive);
        stringBuffer.append(", additionalIconString: ");
        stringBuffer.append(this.additionalIconString);
        stringBuffer.append(", speedIconActive: ");
        stringBuffer.append(this.speedIconActive);
        stringBuffer.append(", speedIconString: ");
        stringBuffer.append(this.speedIconString);
        return stringBuffer.toString();
    }
}

