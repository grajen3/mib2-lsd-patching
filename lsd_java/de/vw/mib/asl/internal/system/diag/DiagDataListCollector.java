/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.diag;

public final class DiagDataListCollector {
    private String reqName;
    private String reqDescription;
    private String value;
    private String valueDescription;

    DiagDataListCollector(String string, String string2) {
        this.reqName = string;
        this.reqDescription = string2;
    }

    public String getReqName() {
        return this.reqName;
    }

    void setReqName(String string) {
        this.reqName = string;
    }

    public String getReqDescription() {
        return this.reqDescription;
    }

    void setReqDescription(String string) {
        this.reqDescription = string;
    }

    public String getValue() {
        return this.value;
    }

    void setValue(String string) {
        this.value = string;
    }

    public String getValueDescription() {
        return this.valueDescription;
    }

    void setValueDescription(String string) {
        this.valueDescription = string;
    }

    public String toString() {
        return new StringBuffer().append(this.reqName).append(" ").append(this.reqDescription).append(" ").append(this.value).append(" ").append(this.valueDescription).toString();
    }
}

