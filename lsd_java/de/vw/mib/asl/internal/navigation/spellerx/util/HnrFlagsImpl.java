/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.util;

import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;

public class HnrFlagsImpl
implements IHnrFlags {
    private boolean housenumberNone;
    private boolean housenumberUnique;
    private boolean housenumberMatchesFound;
    private boolean housenumberAlternatives;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        stringBuffer.append("housenumberNone=");
        stringBuffer.append(this.housenumberNone);
        stringBuffer.append("housenumberUnique=");
        stringBuffer.append(this.housenumberUnique);
        stringBuffer.append("housenumberMatchesFound=");
        stringBuffer.append(this.housenumberMatchesFound);
        stringBuffer.append("housenumberAlternatives=");
        stringBuffer.append(this.housenumberAlternatives);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    @Override
    public boolean isHousenumberNone() {
        return this.housenumberNone;
    }

    @Override
    public boolean isHousenumberUnique() {
        return this.housenumberUnique;
    }

    @Override
    public boolean isHousenumberMatchesFound() {
        return this.housenumberMatchesFound;
    }

    @Override
    public boolean isHousenumberAlternatives() {
        return this.housenumberAlternatives;
    }

    public void setHousenumberNone(boolean bl) {
        this.housenumberNone = bl;
    }

    public void setHousenumberUnique(boolean bl) {
        this.housenumberUnique = bl;
    }

    public void setHousenumberAlternatives(boolean bl) {
        this.housenumberAlternatives = bl;
    }

    public void setHousenumberMatchesFound(boolean bl) {
        this.housenumberMatchesFound = bl;
    }
}

