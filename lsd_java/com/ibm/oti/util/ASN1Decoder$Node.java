/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.ASN1Decoder$BitString;
import com.ibm.oti.util.PriviAction;
import java.security.AccessController;

public class ASN1Decoder$Node {
    public static final int TAG_IMPLICIT;
    public static final int TAG_EXPLICIT;
    public static final int LAST;
    public Object data;
    public int originalType = -1;
    public int tagtype = 1;
    public int type;
    public boolean isPrimitive;
    int elementClass;
    public int startPosition;
    public int endPosition;
    private static String lineTerminator;

    static {
        lineTerminator = null;
        lineTerminator = (String)AccessController.doPrivileged(new PriviAction("line.separator"));
    }

    public boolean isUniversal() {
        return this.elementClass == 0;
    }

    public boolean isApplication() {
        return this.elementClass == 1;
    }

    public boolean isContextSpecific() {
        return this.elementClass == 2;
    }

    public boolean isPrivate() {
        return this.elementClass == 3;
    }

    public ASN1Decoder$Node subnode(int n) {
        try {
            int n2 = ((ASN1Decoder$Node[])this.data).length;
            if (n >= n2) {
                n = n2 - 1 - (-129 - n);
            }
            return ((ASN1Decoder$Node[])this.data)[n];
        }
        catch (Exception exception) {
            return null;
        }
    }

    public ASN1Decoder$Node subnodeWithOriginalType(int n) {
        try {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])this.data;
            int n2 = 0;
            while (n2 < aSN1Decoder$NodeArray.length) {
                ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder$NodeArray[n2];
                if (aSN1Decoder$Node.originalType == n) {
                    return aSN1Decoder$Node;
                }
                ++n2;
            }
        }
        catch (Exception exception) {}
        return null;
    }

    public Object subnode(int[] nArray) {
        try {
            ASN1Decoder$Node aSN1Decoder$Node = ((ASN1Decoder$Node[])this.data)[nArray[0]];
            int n = 1;
            while (n < nArray.length) {
                aSN1Decoder$Node = ((ASN1Decoder$Node[])aSN1Decoder$Node.data)[nArray[n]];
                ++n;
            }
            return aSN1Decoder$Node;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public String toString() {
        return this.toString(0);
    }

    private String toString(int n) {
        if (this.type == 16 || this.type == 17) {
            StringBuffer stringBuffer = new StringBuffer();
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])this.data;
            if (this.type == 16) {
                stringBuffer.append("[SEQUENCE]");
            } else {
                stringBuffer.append("[SET]");
            }
            stringBuffer.append(new StringBuffer("(").append(aSN1Decoder$NodeArray.length).append(") ... ").append(this.endPosition - this.startPosition + 1).toString());
            int n2 = 0;
            while (n2 < aSN1Decoder$NodeArray.length) {
                stringBuffer.append(lineTerminator);
                int n3 = 0;
                while (n3 < n + 2) {
                    stringBuffer.append(" ");
                    ++n3;
                }
                stringBuffer.append(aSN1Decoder$NodeArray[n2].toString(n + 2));
                ++n2;
            }
            return stringBuffer.toString();
        }
        if (this.data == null) {
            return "NULL";
        }
        if (this.data instanceof ASN1Decoder$BitString) {
            return new StringBuffer("[BIT_STRING] ").append(ASN1Decoder$Node.getStringForByteArray(((ASN1Decoder$BitString)this.data).data)).toString();
        }
        if (this.data instanceof byte[]) {
            return new StringBuffer("[BIT_STRING] ").append(ASN1Decoder$Node.getStringForByteArray((byte[])this.data)).toString();
        }
        if (this.data instanceof int[]) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("OID ");
            int[] nArray = (int[])this.data;
            stringBuffer.append(nArray[0]);
            int n4 = 1;
            while (n4 < nArray.length) {
                stringBuffer.append(new StringBuffer(".").append(nArray[n4]).toString());
                ++n4;
            }
            return stringBuffer.toString();
        }
        return this.data.toString();
    }

    private static String getStringForByteArray(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < byArray.length) {
            stringBuffer.append(Integer.toHexString(byArray[n] >> 4 & 0xF));
            stringBuffer.append(Integer.toHexString(byArray[n] & 0xF));
            stringBuffer.append(" ");
            ++n;
        }
        return stringBuffer.toString().toUpperCase();
    }
}

