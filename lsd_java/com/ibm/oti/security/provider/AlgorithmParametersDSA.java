/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Encoder;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class AlgorithmParametersDSA
extends AlgorithmParametersSpi {
    private DSAParameterSpec paramSpec;
    private boolean initialized = false;
    static /* synthetic */ Class class$0;

    @Override
    protected byte[] engineGetEncoded(String string) {
        if (!this.initialized) {
            throw new IOException();
        }
        if (string == null || string.equals("ASN.1")) {
            BigInteger[] bigIntegerArray = new BigInteger[]{this.paramSpec.getP(), this.paramSpec.getQ(), this.paramSpec.getG()};
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
        throw new IOException(Msg.getString("JCP000"));
    }

    @Override
    protected AlgorithmParameterSpec engineGetParameterSpec(Class clazz) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.security.spec.DSAParameterSpec");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if (clazz != clazz2) {
            throw new InvalidParameterSpecException();
        }
        return this.paramSpec;
    }

    @Override
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (!(algorithmParameterSpec instanceof DSAParameterSpec)) {
            throw new InvalidParameterSpecException();
        }
        this.paramSpec = (DSAParameterSpec)algorithmParameterSpec;
        this.initialized = true;
    }

    @Override
    protected void engineInit(byte[] byArray, String string) {
        if (string == null || string.equals("ASN.1")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            ASN1Decoder aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
            try {
                ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder.readContents().data;
                BigInteger bigInteger = (BigInteger)aSN1Decoder$NodeArray[0].data;
                BigInteger bigInteger2 = (BigInteger)aSN1Decoder$NodeArray[1].data;
                BigInteger bigInteger3 = (BigInteger)aSN1Decoder$NodeArray[2].data;
                this.paramSpec = new DSAParameterSpec(bigInteger, bigInteger2, bigInteger3);
            }
            catch (ClassCastException classCastException) {
                throw new IOException(Msg.getString("JCP000"));
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw new IOException(Msg.getString("JCP000"));
            }
            this.initialized = true;
            return;
        }
        throw new IOException(Msg.getString("JCP000"));
    }

    @Override
    protected String engineToString() {
        return this.toString();
    }

    @Override
    protected byte[] engineGetEncoded() {
        return this.engineGetEncoded("ASN.1");
    }

    @Override
    protected void engineInit(byte[] byArray) {
        this.engineInit(byArray, "ASN.1");
    }
}

