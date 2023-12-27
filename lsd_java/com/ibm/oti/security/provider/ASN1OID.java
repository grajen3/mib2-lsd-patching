/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public final class ASN1OID {
    private int size = 0;
    private int[] representation = null;
    private int hashCode;

    private ASN1OID() {
    }

    public ASN1OID(int[] nArray) {
        this(nArray.length);
        this.representation = nArray;
        this.cacheHashCode();
    }

    public ASN1OID(String string) {
        this();
        int n;
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",.");
        this.size = n = stringTokenizer.countTokens();
        int[] nArray = new int[n];
        int n2 = 0;
        while (n2 < n) {
            nArray[n2] = Integer.parseInt(stringTokenizer.nextToken());
            ++n2;
        }
        this.representation = nArray;
        this.cacheHashCode();
    }

    private ASN1OID(int n) {
        this();
        this.size = n;
    }

    private void cacheHashCode() {
        this.hashCode = 0;
        if (this.representation != null) {
            int n = 0;
            while (n < this.representation.length) {
                this.hashCode += this.representation[n] & 0xFF;
                ++n;
            }
        }
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof ASN1OID)) {
            return false;
        }
        ASN1OID aSN1OID = (ASN1OID)object;
        if (this.size != aSN1OID.size) {
            return false;
        }
        if (this.representation == aSN1OID.representation) {
            return true;
        }
        if (this.representation == null || aSN1OID.representation == null) {
            return false;
        }
        return Arrays.equals(this.representation, aSN1OID.representation);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public int[] representation() {
        return this.representation;
    }

    public static String OIDToString(int[] nArray) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < nArray.length - 1) {
            stringBuffer.append(nArray[n]);
            stringBuffer.append('.');
            ++n;
        }
        stringBuffer.append(nArray[nArray.length - 1]);
        return stringBuffer.toString();
    }

    public String toString() {
        return ASN1OID.OIDToString(this.representation);
    }

    public static int[] stringToIntOID(String string) {
        Vector vector = new Vector();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (n < string.length()) {
            n2 = string.indexOf(".", n);
            if (n2 == -1) {
                n2 = string.length();
            }
            vector.addElement(string.substring(n, n2));
            ++n3;
            n = n2 + 1;
        }
        Enumeration enumeration = vector.elements();
        int[] nArray = new int[n3];
        int n4 = 0;
        while (enumeration.hasMoreElements()) {
            nArray[n4] = Integer.parseInt((String)enumeration.nextElement());
            ++n4;
        }
        return nArray;
    }
}

