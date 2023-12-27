/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

public final class LCID {
    private final String name;
    private final String iSO;
    private final String lCID;

    public LCID(String string, String string2, String string3) {
        this.name = string;
        this.iSO = string2;
        this.lCID = string3;
    }

    public String getName() {
        return this.name;
    }

    public String getISO() {
        return this.iSO;
    }

    public String getLCID() {
        return this.lCID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.getClass().getName()).append("[");
        stringBuffer.append("name='").append(this.name).append("',");
        stringBuffer.append("iso='").append(this.iSO).append("',");
        stringBuffer.append("lcid='").append(this.lCID).append("'");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

