/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

class X500Principal$AttributeValuePair
implements Comparable {
    private String type;
    private String value;

    public X500Principal$AttributeValuePair(String string, String string2) {
        this.type = string;
        this.value = string2;
    }

    @Override
    public int compareTo(Object object) {
        X500Principal$AttributeValuePair x500Principal$AttributeValuePair = (X500Principal$AttributeValuePair)object;
        if (this.isOID(this.type)) {
            if (this.isOID(x500Principal$AttributeValuePair.type)) {
                return this.type.compareTo(x500Principal$AttributeValuePair.type);
            }
            return 1;
        }
        if (this.isOID(x500Principal$AttributeValuePair.type)) {
            return -1;
        }
        return this.type.compareTo(x500Principal$AttributeValuePair.type);
    }

    private boolean isOID(String string) {
        return string.toLowerCase().startsWith("oid");
    }

    public String getOutputString(int n) {
        StringBuffer stringBuffer = new StringBuffer(this.type.length() + this.value.length() + 3);
        stringBuffer.append(this.type);
        stringBuffer.append('=');
        String string = this.value;
        string = n == 2 ? this.stripInternalWhitespace(this.value.trim()) : this.value;
        if (this.value.charAt(0) == ' ' || this.value.charAt(0) == '#' || this.value.charAt(this.value.length() - 1) == ' ' || this.value.indexOf(44) != -1 || this.value.indexOf(61) != -1 || this.value.indexOf(43) != -1 || this.value.indexOf(60) != -1 || this.value.indexOf(62) != -1 || this.value.indexOf(35) != -1 || this.value.indexOf(59) != -1) {
            stringBuffer.append('\"');
            stringBuffer.append(string);
            stringBuffer.append('\"');
        } else {
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }

    private String stripInternalWhitespace(String string) {
        char[] cArray = string.toCharArray();
        char[] cArray2 = new char[string.length()];
        int n = 0;
        int n2 = 0;
        while (n2 < string.length()) {
            if (Character.isWhitespace(cArray[n2])) {
                cArray2[n++] = 32;
                ++n2;
                while (Character.isWhitespace(cArray[n2])) {
                    ++n2;
                }
                cArray2[n++] = cArray[n2];
            } else {
                cArray2[n++] = cArray[n2];
            }
            ++n2;
        }
        return new String(cArray2);
    }

    public String toString() {
        return this.getOutputString(1);
    }
}

