/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$BitString;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.spec.DSAParameterSpec;
import java.util.Arrays;

public class DSAPublicKey
implements java.security.interfaces.DSAPublicKey {
    static final String ENCODING_FORMAT;
    private DSAParams parametersDSA;
    private BigInteger y;
    private byte[] encoded;
    static final int[] OID;
    static final int[] OIDalt;

    static {
        OID = new int[]{1, 2, 840, 10040, 4, 1};
        OIDalt = new int[]{1, 3, 14, 3, 2, 12};
    }

    @Override
    public BigInteger getY() {
        return this.y;
    }

    @Override
    public DSAParams getParams() {
        return this.parametersDSA;
    }

    @Override
    public String getAlgorithm() {
        return "DSA";
    }

    byte[] keyToX509Encoding() {
        Object object;
        Object[] objectArray;
        Object[] objectArray2 = new Object[2];
        objectArray2[0] = objectArray = new Object[2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        aSN1Encoder.writeObject(this.getY());
        objectArray2[1] = new ASN1Decoder$BitString(0, byteArrayOutputStream.toByteArray());
        objectArray[0] = OID;
        if (this.parametersDSA != null) {
            object = new Object[]{this.parametersDSA.getP(), this.parametersDSA.getQ(), this.parametersDSA.getG()};
            objectArray[1] = object;
        }
        object = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder2 = new ASN1Encoder((OutputStream)object);
        aSN1Encoder2.writeObject(objectArray2);
        return ((ByteArrayOutputStream)object).toByteArray();
    }

    public ASN1Decoder$Node toASN1Node() {
        ASN1Decoder$Node[] aSN1Decoder$NodeArray;
        ASN1Decoder$Node[] aSN1Decoder$NodeArray2;
        ASN1Decoder$Node aSN1Decoder$Node = new ASN1Decoder$Node();
        aSN1Decoder$Node.type = 16;
        aSN1Decoder$Node.data = aSN1Decoder$NodeArray2 = new ASN1Decoder$Node[2];
        ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = null;
        if (this.parametersDSA != null) {
            aSN1Decoder$NodeArray = new ASN1Decoder$Node();
            aSN1Decoder$NodeArray.type = 16;
            aSN1Decoder$NodeArray.data = aSN1Decoder$NodeArray3 = new ASN1Decoder$Node[3];
            aSN1Decoder$NodeArray3[0] = new ASN1Decoder$Node();
            aSN1Decoder$NodeArray3[0].type = 2;
            aSN1Decoder$NodeArray3[0].data = this.parametersDSA.getP();
            aSN1Decoder$NodeArray3[1] = new ASN1Decoder$Node();
            aSN1Decoder$NodeArray3[1].type = 2;
            aSN1Decoder$NodeArray3[1].data = this.parametersDSA.getQ();
            aSN1Decoder$NodeArray3[2] = new ASN1Decoder$Node();
            aSN1Decoder$NodeArray3[2].type = 2;
            aSN1Decoder$NodeArray3[2].data = this.parametersDSA.getG();
        }
        aSN1Decoder$NodeArray2[0] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray2[0].type = 16;
        aSN1Decoder$NodeArray2[0].data = aSN1Decoder$NodeArray = new ASN1Decoder$Node[2];
        aSN1Decoder$NodeArray[0] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray[0].type = 6;
        aSN1Decoder$NodeArray[0].data = OID;
        aSN1Decoder$NodeArray[1] = new ASN1Decoder$Node();
        if (aSN1Decoder$NodeArray3 != null) {
            aSN1Decoder$NodeArray[1].type = 16;
            aSN1Decoder$NodeArray[1].data = aSN1Decoder$NodeArray3;
        } else {
            aSN1Decoder$NodeArray[1].type = 5;
        }
        ASN1Decoder$Node aSN1Decoder$Node2 = new ASN1Decoder$Node();
        aSN1Decoder$Node2.type = 2;
        aSN1Decoder$Node2.data = this.y;
        aSN1Decoder$NodeArray2[1] = new ASN1Decoder$Node();
        aSN1Decoder$NodeArray2[1].type = 3;
        aSN1Decoder$NodeArray2[1].data = new ASN1Decoder$BitString(0, ASN1Encoder.encodeNode(aSN1Decoder$Node2));
        return aSN1Decoder$Node;
    }

    static Object[] decodeX509(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        Object[] objectArray = new Object[2];
        try {
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder.readContents().data;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[0].data;
            if (!Arrays.equals(OID, (int[])aSN1Decoder$NodeArray2[0].data) && !Arrays.equals(OIDalt, (int[])aSN1Decoder$NodeArray2[0].data)) {
                throw new ASN1Exception();
            }
            ASN1Decoder$BitString aSN1Decoder$BitString = (ASN1Decoder$BitString)aSN1Decoder$NodeArray[1].data;
            byteArrayInputStream = new ByteArrayInputStream(aSN1Decoder$BitString.data);
            aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
            objectArray[1] = (BigInteger)aSN1Decoder.readContents().data;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray2[1].data;
            if (aSN1Decoder$NodeArray3 != null) {
                BigInteger bigInteger = (BigInteger)aSN1Decoder$NodeArray3[0].data;
                BigInteger bigInteger2 = (BigInteger)aSN1Decoder$NodeArray3[1].data;
                BigInteger bigInteger3 = (BigInteger)aSN1Decoder$NodeArray3[2].data;
                objectArray[0] = new DSAParameterSpec(bigInteger, bigInteger2, bigInteger3);
            }
            return objectArray;
        }
        catch (ClassCastException classCastException) {
            throw new ASN1Exception();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ASN1Exception();
        }
    }

    @Override
    public byte[] getEncoded() {
        if (this.encoded == null) {
            try {
                this.encoded = this.keyToX509Encoding();
            }
            catch (ASN1Exception aSN1Exception) {}
        }
        return this.encoded;
    }

    @Override
    public String getFormat() {
        return "X.509";
    }

    public DSAPublicKey(DSAParams dSAParams, BigInteger bigInteger) {
        this.parametersDSA = dSAParams;
        this.y = bigInteger;
    }

    public String toString() {
        BigInteger bigInteger = this.parametersDSA.getP();
        BigInteger bigInteger2 = this.parametersDSA.getQ();
        BigInteger bigInteger3 = this.parametersDSA.getG();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.getClass().getName());
        stringBuffer.append("\n\t");
        stringBuffer.append("Y: ");
        stringBuffer.append(this.getY().toString(16));
        stringBuffer.append("\n\t");
        stringBuffer.append("p: ");
        stringBuffer.append(bigInteger.toString(16));
        stringBuffer.append("\n\t");
        stringBuffer.append("q: ");
        stringBuffer.append(bigInteger2.toString(16));
        stringBuffer.append("\n\t");
        stringBuffer.append("g: ");
        stringBuffer.append(bigInteger3.toString(16));
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.getEncoded());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.encoded = (byte[])objectInputStream.readObject();
        Object[] objectArray = DSAPublicKey.decodeX509(this.encoded);
        this.parametersDSA = (DSAParameterSpec)objectArray[0];
        this.y = (BigInteger)objectArray[1];
    }

    public DSAPublicKey(byte[] byArray) {
        this.encoded = byArray;
        try {
            Object[] objectArray = DSAPublicKey.decodeX509(byArray);
            this.parametersDSA = (DSAParameterSpec)objectArray[0];
            this.y = (BigInteger)objectArray[1];
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
    }
}

