/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download;

public class PopUpInfo {
    public int popupType;
    public String id;
    public byte prio;
    public int errorCode;
    public int errorCodeDetailed;
    public String info;
    public int delayCount = 0;

    public PopUpInfo(int n, String string) {
        this.popupType = n;
        this.id = string;
    }

    public PopUpInfo(int n, String string, byte by, int n2, int n3, String string2) {
        this.popupType = n;
        this.id = string;
        this.prio = by;
        this.errorCode = n2;
        this.errorCodeDetailed = n3;
        this.info = string2;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.id == null ? 0 : this.id.hashCode());
        n2 = 31 * n2 + this.popupType;
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
        PopUpInfo popUpInfo = (PopUpInfo)object;
        if (this.id == null ? popUpInfo.id != null : !this.id.equals(popUpInfo.id)) {
            return false;
        }
        return this.popupType == popUpInfo.popupType;
    }
}

