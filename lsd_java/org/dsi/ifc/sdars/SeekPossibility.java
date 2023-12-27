/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.sdars.SeekInformation;
import org.dsi.ifc.sdars.SeekState;

public class SeekPossibility {
    public int sID;
    public int typeOfContent;
    public SeekState[] seekState;
    public SeekInformation[] seekInformation;

    public SeekPossibility() {
        this.sID = 0;
        this.typeOfContent = 0;
        this.seekState = null;
    }

    public SeekPossibility(int n, int n2, SeekState[] seekStateArray, SeekInformation[] seekInformationArray) {
        this.sID = n;
        this.typeOfContent = n2;
        this.seekState = seekStateArray;
        this.seekInformation = seekInformationArray;
    }

    public int getSID() {
        return this.sID;
    }

    public int getTypeOfContent() {
        return this.typeOfContent;
    }

    public SeekState[] getSeekState() {
        return this.seekState;
    }

    public SeekInformation[] getSeekInformation() {
        return this.seekInformation;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SeekPossibility");
        stringBuffer.append('(');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("typeOfContent");
        stringBuffer.append('=');
        stringBuffer.append(this.typeOfContent);
        stringBuffer.append(',');
        stringBuffer.append("seekState");
        stringBuffer.append('[');
        if (this.seekState != null) {
            stringBuffer.append(this.seekState.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.seekState != null) {
            n3 = this.seekState.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.seekState[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.seekState);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("seekInformation");
        stringBuffer.append('[');
        if (this.seekInformation != null) {
            stringBuffer.append(this.seekInformation.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.seekInformation != null) {
            n3 = this.seekInformation.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.seekInformation[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.seekInformation);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

