/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.ASN1OID;
import com.ibm.oti.security.provider.X500Principal$AttributeValuePair;
import com.ibm.oti.text.Normalizer;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$BMPString;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
import java.util.Vector;

public class X500Principal
implements Principal {
    public static final int OUTPUT_RFC1779;
    public static final int OUTPUT_RFC2253;
    public static final int OUTPUT_CANONICAL;
    private static final int RFC_1779;
    private static final int RFC_2253;
    private static final int RFC_2459;
    private int[] supportedStandards;
    private boolean[] outputMarker;
    protected Vector attributeTypes;
    protected Vector attributeValues;
    private static final ASN1OID[] RFC_1779_OIDs;
    private static final ASN1OID[] RFC_2253_OIDs;
    private static final ASN1OID[] RFC_2459_OIDs;
    private static final String[] RFC_1779_OID_keys;
    private static final String[] RFC_2253_OID_keys;
    private static final String[] RFC_2459_OID_keys;

    static {
        RFC_1779_OIDs = new ASN1OID[7];
        RFC_2253_OIDs = new ASN1OID[2];
        RFC_2459_OIDs = new ASN1OID[9];
        RFC_1779_OID_keys = new String[7];
        RFC_2253_OID_keys = new String[2];
        RFC_2459_OID_keys = new String[9];
        int n = 0;
        int[] nArray = new int[]{2, 5, 4, 3};
        X500Principal.RFC_1779_OIDs[n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "CN";
        nArray = new int[]{2, 5, 4, 11};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "OU";
        nArray = new int[]{2, 5, 4, 10};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "O";
        nArray = new int[]{2, 5, 4, 9};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "STREET";
        nArray = new int[]{2, 5, 4, 7};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "L";
        nArray = new int[]{2, 5, 4, 8};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "ST";
        nArray = new int[]{2, 5, 4, 6};
        X500Principal.RFC_1779_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_1779_OID_keys[n] = "C";
        ++n;
        n = 0;
        int[] nArray2 = new int[7];
        nArray2[1] = 9;
        nArray2[2] = 2342;
        nArray2[3] = 754525185;
        nArray2[4] = 100;
        nArray2[5] = 1;
        nArray2[6] = 25;
        nArray = nArray2;
        X500Principal.RFC_2253_OIDs[n] = new ASN1OID(nArray);
        X500Principal.RFC_2253_OID_keys[n] = "DC";
        ++n;
        int[] nArray3 = new int[7];
        nArray3[1] = 9;
        nArray3[2] = 2342;
        nArray3[3] = 754525185;
        nArray3[4] = 100;
        nArray3[5] = 1;
        nArray3[6] = 1;
        nArray = nArray3;
        X500Principal.RFC_2253_OIDs[n] = new ASN1OID(nArray);
        X500Principal.RFC_2253_OID_keys[n] = "UID";
        ++n;
        n = 0;
        nArray = new int[]{2, 5, 4, 12};
        X500Principal.RFC_2459_OIDs[n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "TITLE";
        nArray = new int[]{2, 5, 4, 42};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "GIVENNAME";
        nArray = new int[]{2, 5, 4, 43};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "INITIALS";
        nArray = new int[]{2, 5, 4, 41};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "SURNAME";
        nArray = new int[]{2, 5, 4, 44};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "GENERATION";
        nArray = new int[]{1, 2, 840, -1917124352, 1, 9, 1};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "EMAILADDRESS";
        nArray = new int[]{2, 5, 4, 46};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "DNQ";
        nArray = new int[]{2, 5, 4, 46};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "DNQUALIFIER";
        nArray = new int[]{2, 5, 4, 5};
        X500Principal.RFC_2459_OIDs[++n] = new ASN1OID(nArray);
        X500Principal.RFC_2459_OID_keys[n] = "SERIALNUMBER";
        ++n;
    }

    public X500Principal(String string) {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
        this.initFrom(string);
        if (this.attributeTypes.size() == 0) {
            throw new IllegalArgumentException(Msg.getString("K039f"));
        }
    }

    public X500Principal(byte[] byArray) {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
        this.initFrom(aSN1Decoder$Node);
    }

    public X500Principal(InputStream inputStream) {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
        ASN1Decoder aSN1Decoder = new ASN1Decoder(inputStream);
        ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
        this.initFrom(aSN1Decoder$Node);
    }

    public X500Principal(ASN1Decoder$Node aSN1Decoder$Node) {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
        this.initFrom(aSN1Decoder$Node);
    }

    private void initFrom(ASN1Decoder$Node aSN1Decoder$Node) {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node.data;
        int n = 0;
        while (n < aSN1Decoder$NodeArray.length) {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[n].data;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray2[0].data;
            String string = null;
            string = aSN1Decoder$NodeArray3[1].data instanceof ASN1Decoder$BMPString ? ((ASN1Decoder$BMPString)aSN1Decoder$NodeArray3[1].data).bmpString : (String)aSN1Decoder$NodeArray3[1].data;
            ASN1OID aSN1OID = new ASN1OID((int[])aSN1Decoder$NodeArray3[0].data);
            this.attributeTypes.addElement(aSN1OID);
            this.attributeValues.addElement(string);
            ++n;
        }
    }

    private void initFrom(String string) {
        int n = 0;
        int n2 = 0;
        char c2 = this.getSeparator();
        while (true) {
            if (n < string.length() && string.charAt(n) == ' ') {
                ++n;
            }
            if ((n2 = string.indexOf(61, n)) == -1) break;
            String string2 = string.substring(n, n2);
            n = n2 + 1;
            boolean bl = false;
            if (string.charAt(n) == '\"') {
                ++n;
                bl = true;
            }
            if ((n2 = string.indexOf(bl ? 34 : (int)c2, n)) == -1) {
                n2 = string.length();
            }
            String string3 = string.substring(n, n2);
            n = n2 + (bl ? 2 : 1);
            ASN1OID aSN1OID = this.getOIDForKey(string2, this.supportedStandards);
            if (aSN1OID == null) {
                String string4 = string2.toLowerCase();
                if (string4.startsWith("oid")) {
                    aSN1OID = new ASN1OID(string4.substring(4));
                } else {
                    throw new IllegalArgumentException(Msg.getString("K03a0"));
                }
            }
            this.attributeTypes.addElement(aSN1OID);
            this.attributeValues.addElement(string3);
        }
    }

    private ASN1OID getOIDForKey(String string, int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException();
        }
        ASN1OID aSN1OID = null;
        int n = 0;
        while (n < nArray.length) {
            aSN1OID = this.getOIDForKey(string, nArray[n]);
            if (aSN1OID != null) {
                return aSN1OID;
            }
            ++n;
        }
        return null;
    }

    private ASN1OID getOIDForKey(String string, int n) {
        String[] stringArray = null;
        ASN1OID[] aSN1OIDArray = null;
        switch (n) {
            case 0: {
                stringArray = RFC_1779_OID_keys;
                aSN1OIDArray = RFC_1779_OIDs;
                break;
            }
            case 1: {
                stringArray = RFC_2253_OID_keys;
                aSN1OIDArray = RFC_2253_OIDs;
                break;
            }
            case 2: {
                stringArray = RFC_2459_OID_keys;
                aSN1OIDArray = RFC_2459_OIDs;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        int n2 = 0;
        while (n2 < stringArray.length) {
            if (stringArray[n2].equals(string)) {
                return aSN1OIDArray[n2];
            }
            ++n2;
        }
        return null;
    }

    private String getKeyForOID(ASN1OID aSN1OID, int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException();
        }
        String string = null;
        int n = 0;
        while (n < nArray.length) {
            string = this.getKeyForOID(aSN1OID, nArray[n]);
            if (string != null) {
                return string;
            }
            ++n;
        }
        return null;
    }

    private String getKeyForOID(ASN1OID aSN1OID, int n) {
        String[] stringArray = null;
        ASN1OID[] aSN1OIDArray = null;
        switch (n) {
            case 0: {
                stringArray = RFC_1779_OID_keys;
                aSN1OIDArray = RFC_1779_OIDs;
                break;
            }
            case 1: {
                stringArray = RFC_2253_OID_keys;
                aSN1OIDArray = RFC_2253_OIDs;
                break;
            }
            case 2: {
                stringArray = RFC_2459_OID_keys;
                aSN1OIDArray = RFC_2459_OIDs;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        int n2 = 0;
        while (n2 < aSN1OIDArray.length) {
            if (aSN1OIDArray[n2].equals(aSN1OID)) {
                return stringArray[n2];
            }
            ++n2;
        }
        return null;
    }

    @Override
    public String getName() {
        return this.getName(1);
    }

    public String getName(int n) {
        int[] nArray;
        switch (n) {
            case 0: {
                nArray = new int[1];
                break;
            }
            case 1: 
            case 2: {
                int[] nArray2 = new int[2];
                nArray2[1] = 1;
                nArray = nArray2;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        this.outputMarker = new boolean[this.attributeTypes.size()];
        Arrays.fill(this.outputMarker, false);
        ASN1OID[] aSN1OIDArray = RFC_1779_OIDs;
        Vector vector = this.getAttributesForOutputFormat(nArray, null, aSN1OIDArray);
        if (n != 0) {
            aSN1OIDArray = RFC_2253_OIDs;
            vector = this.getAttributesForOutputFormat(nArray, vector, aSN1OIDArray);
        }
        int n2 = 0;
        while (n2 < this.attributeTypes.size()) {
            if (!this.outputMarker[n2]) {
                String string = new StringBuffer("OID.").append(((ASN1OID)this.attributeTypes.elementAt(n2)).toString()).toString();
                String string2 = (String)this.attributeValues.elementAt(n2);
                X500Principal$AttributeValuePair x500Principal$AttributeValuePair = new X500Principal$AttributeValuePair(string, string2);
                vector.add(x500Principal$AttributeValuePair);
                this.outputMarker[n2] = true;
            }
            ++n2;
        }
        if (n == 2) {
            return this.getAttributesAsCanonicalString(vector);
        }
        return this.getAttributesAsNonCanonicalString(vector);
    }

    private String getAttributesAsCanonicalString(Vector vector) {
        Object object;
        Object object2;
        TreeSet treeSet = new TreeSet();
        Object object3 = vector.iterator();
        while (object3.hasNext()) {
            object2 = (X500Principal$AttributeValuePair)object3.next();
            treeSet.add(object2);
        }
        object3 = new StringBuffer();
        object2 = treeSet.iterator();
        while (object2.hasNext()) {
            object = (X500Principal$AttributeValuePair)object2.next();
            ((StringBuffer)object3).append(((X500Principal$AttributeValuePair)object).getOutputString(2));
            ((StringBuffer)object3).append(this.getSeparator());
        }
        ((StringBuffer)object3).deleteCharAt(((StringBuffer)object3).length() - 1);
        object2 = ((StringBuffer)object3).toString();
        object2 = ((String)object2).toLowerCase(Locale.US);
        object2 = ((String)object2).toUpperCase(Locale.US);
        object = Normalizer.normalize((String)object2, Normalizer.DECOMP_COMPAT, 0);
        return object;
    }

    private String getAttributesAsNonCanonicalString(Vector vector) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            X500Principal$AttributeValuePair x500Principal$AttributeValuePair = (X500Principal$AttributeValuePair)iterator.next();
            stringBuffer.append(x500Principal$AttributeValuePair.getOutputString(1));
            stringBuffer.append(this.getSeparator());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    private Vector getAttributesForOutputFormat(int[] nArray, Vector vector, ASN1OID[] aSN1OIDArray) {
        Vector vector2 = vector != null ? vector : new Vector();
        int n = 0;
        while (n < aSN1OIDArray.length) {
            ASN1OID aSN1OID = aSN1OIDArray[n];
            int n2 = 0;
            while (n2 < this.attributeTypes.size()) {
                if (this.attributeTypes.elementAt(n2).equals(aSN1OID)) {
                    String string = this.getKeyForOID(aSN1OID, nArray);
                    String string2 = (String)this.attributeValues.elementAt(n2);
                    X500Principal$AttributeValuePair x500Principal$AttributeValuePair = new X500Principal$AttributeValuePair(string, string2);
                    vector2.add(x500Principal$AttributeValuePair);
                    this.outputMarker[n2] = true;
                }
                ++n2;
            }
            ++n;
        }
        return vector2;
    }

    @Override
    public int hashCode() {
        return this.getName(2).hashCode();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String getValueForKey(String string) {
        ASN1OID aSN1OID = this.getOIDForKey(string, this.supportedStandards);
        int n = 0;
        while (n < this.attributeTypes.size()) {
            if (this.attributeTypes.elementAt(n).equals(aSN1OID)) {
                return (String)this.attributeValues.elementAt(n);
            }
            ++n;
        }
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof X500Principal)) {
            return false;
        }
        return this.getName(2).equals(((X500Principal)object).getName(2));
    }

    public byte[] getEncoded() {
        ASN1Decoder$Node aSN1Decoder$Node = this.toASN1Node();
        byte[] byArray = ASN1Encoder.encodeNode(aSN1Decoder$Node);
        return byArray;
    }

    public ASN1Decoder$Node toASN1Node() {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray = new ASN1Decoder$Node[this.attributeTypes.size()];
        int n = 0;
        while (n < this.attributeTypes.size()) {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = new ASN1Decoder$Node[2];
            ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
            aSN1Decoder$Node.type = 6;
            aSN1Decoder$Node.data = ((ASN1OID)this.attributeTypes.elementAt(n)).representation();
            aSN1Decoder$NodeArray2[0] = aSN1Decoder$Node;
            ASN1Decoder$Node aSN1Decoder$Node2 = new ASN1Decoder$Node();
            aSN1Decoder$Node2.type = 12;
            aSN1Decoder$Node2.data = this.attributeValues.elementAt(n);
            aSN1Decoder$NodeArray2[1] = aSN1Decoder$Node2;
            ASN1Decoder$Node aSN1Decoder$Node3 = new ASN1Decoder$Node();
            aSN1Decoder$Node3.type = 16;
            aSN1Decoder$Node3.data = aSN1Decoder$NodeArray2;
            ASN1Decoder$Node aSN1Decoder$Node4 = new ASN1Decoder$Node();
            aSN1Decoder$Node4.type = 17;
            aSN1Decoder$Node4.data = new ASN1Decoder$Node[]{aSN1Decoder$Node3};
            aSN1Decoder$NodeArray[n] = aSN1Decoder$Node4;
            ++n;
        }
        ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
        aSN1Decoder$Node.type = 16;
        aSN1Decoder$Node.data = aSN1Decoder$NodeArray;
        return aSN1Decoder$Node;
    }

    X500Principal() {
        int[] nArray = new int[3];
        nArray[1] = 1;
        nArray[2] = 2;
        this.supportedStandards = nArray;
        this.outputMarker = null;
        this.attributeTypes = new Vector();
        this.attributeValues = new Vector();
    }

    public char getSeparator() {
        return ',';
    }
}

