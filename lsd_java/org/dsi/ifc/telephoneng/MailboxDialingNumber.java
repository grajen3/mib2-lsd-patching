/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class MailboxDialingNumber {
    public int mailboxIdentifier;
    public String mailboxNumber;
    public boolean tonNpiValid;
    public int tonNpi;
    public boolean alphaIdentifierValid;
    public String alphaIdentifier;
    public boolean extConfCapValid;
    public int extConfCap;
    public boolean extInfoValid;
    public String extInfo;

    public MailboxDialingNumber() {
        this.mailboxIdentifier = 0;
        this.mailboxNumber = null;
        this.tonNpiValid = false;
        this.tonNpi = 0;
        this.alphaIdentifierValid = false;
        this.alphaIdentifier = null;
        this.extConfCapValid = false;
        this.extConfCap = 0;
        this.extInfoValid = false;
        this.extInfo = null;
    }

    public MailboxDialingNumber(int n, String string, boolean bl, int n2, boolean bl2, String string2, boolean bl3, int n3, boolean bl4, String string3) {
        this.mailboxIdentifier = n;
        this.mailboxNumber = string;
        this.tonNpiValid = bl;
        this.tonNpi = n2;
        this.alphaIdentifierValid = bl2;
        this.alphaIdentifier = string2;
        this.extConfCapValid = bl3;
        this.extConfCap = n3;
        this.extInfoValid = bl4;
        this.extInfo = string3;
    }

    public int getMailboxIdentifier() {
        return this.mailboxIdentifier;
    }

    public String getMailboxNumber() {
        return this.mailboxNumber;
    }

    public boolean isTonNpiValid() {
        return this.tonNpiValid;
    }

    public int getTonNpi() {
        return this.tonNpi;
    }

    public boolean isAlphaIdentifierValid() {
        return this.alphaIdentifierValid;
    }

    public String getAlphaIdentifier() {
        return this.alphaIdentifier;
    }

    public boolean isExtConfCapValid() {
        return this.extConfCapValid;
    }

    public int getExtConfCap() {
        return this.extConfCap;
    }

    public boolean isExtInfoValid() {
        return this.extInfoValid;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(650);
        stringBuffer.append("MailboxDialingNumber");
        stringBuffer.append('(');
        stringBuffer.append("mailboxIdentifier");
        stringBuffer.append('=');
        stringBuffer.append(this.mailboxIdentifier);
        stringBuffer.append(',');
        stringBuffer.append("mailboxNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mailboxNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("tonNpiValid");
        stringBuffer.append('=');
        stringBuffer.append(this.tonNpiValid);
        stringBuffer.append(',');
        stringBuffer.append("tonNpi");
        stringBuffer.append('=');
        stringBuffer.append(this.tonNpi);
        stringBuffer.append(',');
        stringBuffer.append("alphaIdentifierValid");
        stringBuffer.append('=');
        stringBuffer.append(this.alphaIdentifierValid);
        stringBuffer.append(',');
        stringBuffer.append("alphaIdentifier");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.alphaIdentifier);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("extConfCapValid");
        stringBuffer.append('=');
        stringBuffer.append(this.extConfCapValid);
        stringBuffer.append(',');
        stringBuffer.append("extConfCap");
        stringBuffer.append('=');
        stringBuffer.append(this.extConfCap);
        stringBuffer.append(',');
        stringBuffer.append("extInfoValid");
        stringBuffer.append('=');
        stringBuffer.append(this.extInfoValid);
        stringBuffer.append(',');
        stringBuffer.append("extInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.extInfo);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

