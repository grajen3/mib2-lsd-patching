/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.spec.DSAParameterSpec;
import java.util.Arrays;

public class DSAPrivateKey
implements java.security.interfaces.DSAPrivateKey {
    private static final long serialVersionUID;
    static final int[] OID;
    static final int[] OIDalt;
    static final String ENCODING_FORMAT;
    private DSAParams parametersDSA;
    private BigInteger x;
    private byte[] encoded = null;

    static {
        OID = new int[]{1, 2, 840, 10040, 4, 1};
        OIDalt = new int[]{1, 3, 14, 3, 2, 12};
    }

    @Override
    public BigInteger getX() {
        return this.x;
    }

    @Override
    public DSAParams getParams() {
        return this.parametersDSA;
    }

    @Override
    public String getAlgorithm() {
        return "DSA";
    }

    @Override
    public byte[] getEncoded() {
        if (this.encoded == null) {
            try {
                this.encoded = this.keyToPKCS8Encoding();
            }
            catch (ASN1Exception aSN1Exception) {}
        }
        return this.encoded;
    }

    byte[] keyToPKCS8Encoding() {
        Object[] objectArray = new Object[3];
        objectArray[0] = BigInteger.ZERO;
        Object[] objectArray2 = new Object[3];
        Object[] objectArray3 = new Object[]{OID, objectArray2};
        objectArray2[0] = this.parametersDSA.getP();
        objectArray2[1] = this.parametersDSA.getQ();
        objectArray2[2] = this.parametersDSA.getG();
        objectArray[1] = objectArray3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        aSN1Encoder.writeObject(this.getX());
        objectArray[2] = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        aSN1Encoder.writeObject(objectArray);
        return byteArrayOutputStream.toByteArray();
    }

    static BigInteger[] decodePKCS8(byte[] byArray) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder.readContents().data;
            ASN1Decoder$Node[] aSN1Decoder$NodeArray2 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray[1].data;
            if (!Arrays.equals(OID, (int[])aSN1Decoder$NodeArray2[0].data) && !Arrays.equals(OIDalt, (int[])aSN1Decoder$NodeArray2[0].data)) {
                throw new ASN1Exception();
            }
            BigInteger[] bigIntegerArray = new BigInteger[4];
            ASN1Decoder$Node[] aSN1Decoder$NodeArray3 = (ASN1Decoder$Node[])aSN1Decoder$NodeArray2[1].data;
            bigIntegerArray[0] = (BigInteger)aSN1Decoder$NodeArray3[0].data;
            bigIntegerArray[1] = (BigInteger)aSN1Decoder$NodeArray3[1].data;
            bigIntegerArray[2] = (BigInteger)aSN1Decoder$NodeArray3[2].data;
            byteArrayInputStream = new ByteArrayInputStream((byte[])aSN1Decoder$NodeArray[2].data);
            aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
            bigIntegerArray[3] = (BigInteger)aSN1Decoder.readContents().data;
            return bigIntegerArray;
        }
        catch (ClassCastException classCastException) {
            throw new ASN1Exception();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ASN1Exception();
        }
    }

    @Override
    public String getFormat() {
        return "PKCS#8";
    }

    public DSAPrivateKey(DSAParams dSAParams, BigInteger bigInteger) {
        this.parametersDSA = dSAParams;
        this.x = bigInteger;
    }

    public String toString() {
        BigInteger bigInteger = this.parametersDSA.getP();
        BigInteger bigInteger2 = this.parametersDSA.getQ();
        BigInteger bigInteger3 = this.parametersDSA.getG();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.getClass().getName());
        stringBuffer.append("\n\t");
        stringBuffer.append("X: ");
        stringBuffer.append(this.getX().toString(16));
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
        BigInteger[] bigIntegerArray = DSAPrivateKey.decodePKCS8(this.encoded);
        this.parametersDSA = new DSAParameterSpec(bigIntegerArray[0], bigIntegerArray[1], bigIntegerArray[2]);
        this.x = bigIntegerArray[3];
    }

    public DSAPrivateKey(byte[] byArray) {
        this.encoded = byArray;
        try {
            BigInteger[] bigIntegerArray = DSAPrivateKey.decodePKCS8(byArray);
            this.parametersDSA = new DSAParameterSpec(bigIntegerArray[0], bigIntegerArray[1], bigIntegerArray[2]);
            this.x = bigIntegerArray[3];
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException();
        }
    }
}

