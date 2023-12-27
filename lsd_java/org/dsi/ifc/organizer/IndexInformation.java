/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.global.CharacterInfo;

public class IndexInformation {
    public int viewtype;
    public CharacterInfo[] characterInfo;

    public IndexInformation() {
        this.viewtype = 0;
        this.characterInfo = null;
    }

    public IndexInformation(int n, CharacterInfo[] characterInfoArray) {
        this.viewtype = n;
        this.characterInfo = characterInfoArray;
    }

    public int getViewtype() {
        return this.viewtype;
    }

    public CharacterInfo[] getCharacterInfo() {
        return this.characterInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("IndexInformation");
        stringBuffer.append('(');
        stringBuffer.append("viewtype");
        stringBuffer.append('=');
        stringBuffer.append(this.viewtype);
        stringBuffer.append(',');
        stringBuffer.append("characterInfo");
        stringBuffer.append('[');
        if (this.characterInfo != null) {
            stringBuffer.append(this.characterInfo.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.characterInfo != null) {
            int n = this.characterInfo.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.characterInfo[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.characterInfo);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

