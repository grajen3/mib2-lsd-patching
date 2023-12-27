/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

public class ImportReport {
    public int inserted;
    public int skippedOther;
    public int skippedBecauseTooLong;
    public int skippedBecauseNonEraseable;
    public boolean convError;
    public boolean parseError;
    public boolean overQuota;
    public boolean success;

    public ImportReport() {
    }

    public ImportReport(int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.inserted = n;
        this.skippedOther = n2;
        this.skippedBecauseTooLong = n3;
        this.skippedBecauseNonEraseable = n4;
        this.convError = bl;
        this.parseError = bl2;
        this.overQuota = bl3;
        this.success = bl4;
    }

    public int getInserted() {
        return this.inserted;
    }

    public void setInserted(int n) {
        this.inserted = n;
    }

    public int getSkippedOther() {
        return this.skippedOther;
    }

    public void setSkippedOther(int n) {
        this.skippedOther = n;
    }

    public int getSkippedBecauseTooLong() {
        return this.skippedBecauseTooLong;
    }

    public void setSkippedBecauseTooLong(int n) {
        this.skippedBecauseTooLong = n;
    }

    public int getSkippedBecauseNonEraseable() {
        return this.skippedBecauseNonEraseable;
    }

    public void setSkippedBecauseNonEraseable(int n) {
        this.skippedBecauseNonEraseable = n;
    }

    public boolean isConvError() {
        return this.convError;
    }

    public void setConvError(boolean bl) {
        this.convError = bl;
    }

    public boolean isParseError() {
        return this.parseError;
    }

    public void setParseError(boolean bl) {
        this.parseError = bl;
    }

    public boolean isOverQuota() {
        return this.overQuota;
    }

    public void setOverQuota(boolean bl) {
        this.overQuota = bl;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean bl) {
        this.success = bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("ImportReport");
        stringBuffer.append('(');
        stringBuffer.append("inserted");
        stringBuffer.append('=');
        stringBuffer.append(this.inserted);
        stringBuffer.append(',');
        stringBuffer.append("skippedOther");
        stringBuffer.append('=');
        stringBuffer.append(this.skippedOther);
        stringBuffer.append(',');
        stringBuffer.append("skippedBecauseTooLong");
        stringBuffer.append('=');
        stringBuffer.append(this.skippedBecauseTooLong);
        stringBuffer.append(',');
        stringBuffer.append("skippedBecauseNonEraseable");
        stringBuffer.append('=');
        stringBuffer.append(this.skippedBecauseNonEraseable);
        stringBuffer.append(',');
        stringBuffer.append("convError");
        stringBuffer.append('=');
        stringBuffer.append(this.convError);
        stringBuffer.append(',');
        stringBuffer.append("parseError");
        stringBuffer.append('=');
        stringBuffer.append(this.parseError);
        stringBuffer.append(',');
        stringBuffer.append("overQuota");
        stringBuffer.append('=');
        stringBuffer.append(this.overQuota);
        stringBuffer.append(',');
        stringBuffer.append("success");
        stringBuffer.append('=');
        stringBuffer.append(this.success);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

