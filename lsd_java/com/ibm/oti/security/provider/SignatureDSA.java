/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.SHAOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;

public class SignatureDSA
extends Signature {
    private static final int STATE_UNINITIALIZED;
    private static final int STATE_SIGN;
    private static final int STATE_VERIFY;
    private int state = 0;
    private DSAPrivateKey privateKey;
    private DSAPublicKey publicKey;
    private SHAOutputStream sha = new SHAOutputStream();
    private static final String[] STATE_DESCRIPTION;

    static {
        STATE_DESCRIPTION = new String[]{"UNINITIALIZED", "SIGN", "VERIFY"};
    }

    public SignatureDSA() {
        super("SHA1withDSA");
    }

    @Override
    protected void engineInitSign(PrivateKey privateKey) {
        boolean bl = privateKey != null;
        try {
            this.privateKey = (DSAPrivateKey)privateKey;
        }
        catch (ClassCastException classCastException) {
            bl = false;
        }
        if (!bl) {
            throw new InvalidKeyException(Msg.getString("K00a5", privateKey));
        }
        this.state = 1;
        this.sha.reset();
    }

    @Override
    protected void engineInitVerify(PublicKey publicKey) {
        boolean bl = publicKey != null;
        try {
            this.publicKey = (DSAPublicKey)publicKey;
        }
        catch (ClassCastException classCastException) {
            bl = false;
        }
        if (!bl) {
            throw new InvalidKeyException(Msg.getString("K00a5", publicKey));
        }
        this.state = 2;
        this.sha.reset();
    }

    private BigInteger multiplicativeInverse(BigInteger bigInteger, BigInteger bigInteger2) {
        boolean bl;
        BigInteger bigInteger3 = bigInteger2;
        BigInteger bigInteger4 = bigInteger;
        BigInteger bigInteger5 = BigInteger.ZERO;
        BigInteger bigInteger6 = BigInteger.ONE;
        do {
            BigInteger bigInteger7 = bigInteger3.divide(bigInteger4);
            BigInteger bigInteger8 = bigInteger4;
            bigInteger4 = bigInteger3.subtract(bigInteger7.multiply(bigInteger8));
            bigInteger3 = bigInteger8;
            bigInteger8 = bigInteger6;
            bigInteger6 = bigInteger5.subtract(bigInteger7.multiply(bigInteger8));
            bigInteger5 = bigInteger8;
        } while (bl = bigInteger4.compareTo(BigInteger.ZERO) > 0);
        return bigInteger5.mod(bigInteger2);
    }

    @Override
    protected byte[] engineSign() {
        int n;
        BigInteger bigInteger;
        BigInteger bigInteger2 = this.privateKey.getX();
        DSAParams dSAParams = this.privateKey.getParams();
        BigInteger bigInteger3 = dSAParams.getG();
        BigInteger bigInteger4 = dSAParams.getP();
        BigInteger bigInteger5 = dSAParams.getQ();
        byte[] byArray = this.sha.getHashAsBytes();
        boolean bl = false;
        SecureRandom secureRandom = new SecureRandom();
        while (!(bl = (bigInteger = new BigInteger(n = bigInteger5.bitLength(), secureRandom)).compareTo(bigInteger5) < 0 && bigInteger.compareTo(BigInteger.ONE) > 0)) {
        }
        BigInteger bigInteger6 = this.multiplicativeInverse(bigInteger, bigInteger5);
        BigInteger bigInteger7 = bigInteger3.modPow(bigInteger, bigInteger4).mod(bigInteger5);
        BigInteger bigInteger8 = new BigInteger(1, byArray);
        BigInteger bigInteger9 = bigInteger8.add(bigInteger2.multiply(bigInteger7));
        bigInteger9 = bigInteger9.multiply(bigInteger6);
        BigInteger bigInteger10 = bigInteger9.mod(bigInteger5);
        BigInteger[] bigIntegerArray = new BigInteger[]{bigInteger7, bigInteger10};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1Encoder aSN1Encoder = new ASN1Encoder(byteArrayOutputStream);
        try {
            aSN1Encoder.writeIntegers(bigIntegerArray);
        }
        catch (IOException iOException) {
            throw new Error(iOException.toString());
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    protected void engineUpdate(byte by) {
        this.sha.write(by);
    }

    @Override
    protected void engineUpdate(byte[] byArray, int n, int n2) {
        this.sha.write(byArray, n, n2);
    }

    @Override
    protected boolean engineVerify(byte[] byArray) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        ASN1Decoder$Node[] aSN1Decoder$NodeArray;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
        try {
            aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder.readContents().data;
        }
        catch (ASN1Exception aSN1Exception) {
            throw new SignatureException(aSN1Exception.toString());
        }
        if (aSN1Decoder$NodeArray.length != 2) {
            throw new SignatureException();
        }
        try {
            bigInteger2 = (BigInteger)aSN1Decoder$NodeArray[0].data;
            bigInteger = (BigInteger)aSN1Decoder$NodeArray[1].data;
        }
        catch (ClassCastException classCastException) {
            throw new SignatureException(classCastException.toString());
        }
        BigInteger bigInteger3 = this.publicKey.getParams().getP();
        BigInteger bigInteger4 = this.publicKey.getParams().getQ();
        BigInteger bigInteger5 = this.publicKey.getParams().getG();
        if (bigInteger2.compareTo(BigInteger.ZERO) <= 0) {
            return false;
        }
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            return false;
        }
        if (bigInteger2.compareTo(bigInteger4) >= 0) {
            return false;
        }
        if (bigInteger.compareTo(bigInteger4) >= 0) {
            return false;
        }
        BigInteger bigInteger6 = this.publicKey.getY();
        byte[] byArray2 = this.sha.getHashAsBytes();
        BigInteger bigInteger7 = new BigInteger(1, byArray2);
        BigInteger bigInteger8 = bigInteger.modInverse(bigInteger4);
        BigInteger bigInteger9 = bigInteger7.multiply(bigInteger8).mod(bigInteger4);
        BigInteger bigInteger10 = bigInteger2.multiply(bigInteger8).mod(bigInteger4);
        BigInteger bigInteger11 = bigInteger5.modPow(bigInteger9, bigInteger3).multiply(bigInteger6.modPow(bigInteger10, bigInteger3)).mod(bigInteger3).mod(bigInteger4);
        return bigInteger11.compareTo(bigInteger2) == 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(" DSA Signature (");
        stringBuffer.append(STATE_DESCRIPTION[this.state]);
        stringBuffer.append(')');
        if (this.state == 0) {
            return stringBuffer.toString();
        }
        BigInteger bigInteger = null;
        BigInteger bigInteger2 = null;
        BigInteger bigInteger3 = null;
        if (this.state == 1) {
            bigInteger = this.privateKey.getParams().getP();
            bigInteger2 = this.privateKey.getParams().getQ();
            bigInteger3 = this.privateKey.getParams().getG();
        } else if (this.state == 2) {
            bigInteger = this.publicKey.getParams().getP();
            bigInteger2 = this.publicKey.getParams().getQ();
            bigInteger3 = this.publicKey.getParams().getG();
        }
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
}

