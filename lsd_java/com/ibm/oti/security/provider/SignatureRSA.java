/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.PKCS1;
import com.ibm.oti.security.provider.RSAPrivateCrtKey;
import com.ibm.oti.security.provider.RSAPrivateKey;
import com.ibm.oti.security.provider.RSAPublicKey;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public abstract class SignatureRSA
extends Signature {
    protected static final int STATE_UNINITIALIZED;
    protected static final int STATE_SIGN;
    protected static final int STATE_VERIFY;
    protected static final String[] STATE_DESCRIPTION;
    protected RSAPrivateKey privateKey;
    protected RSAPublicKey publicKey;
    protected int state = 0;
    protected String digestAlgorithmName;
    protected PKCS1 rsaEngine = null;

    static {
        STATE_DESCRIPTION = new String[]{"UNINITIALIZED", "SIGN", "VERIFY"};
    }

    public SignatureRSA(String string) {
        super(new StringBuffer(String.valueOf(string)).append("with").append("RSA").toString());
        this.digestAlgorithmName = string;
        this.rsaEngine = new PKCS1(string);
    }

    @Override
    protected void engineInitSign(PrivateKey privateKey) {
        if (privateKey instanceof java.security.interfaces.RSAPrivateCrtKey) {
            this.privateKey = new RSAPrivateCrtKey((java.security.interfaces.RSAPrivateCrtKey)privateKey);
        } else if (privateKey instanceof java.security.interfaces.RSAPrivateKey) {
            this.privateKey = new RSAPrivateKey((RSAPrivateKey)privateKey);
        } else {
            throw new InvalidKeyException(Msg.getString("K00a5", privateKey));
        }
        this.state = 1;
        this.resetHash();
    }

    @Override
    protected void engineInitVerify(PublicKey publicKey) {
        boolean bl = true;
        if (publicKey != null) {
            try {
                this.publicKey = new RSAPublicKey((java.security.interfaces.RSAPublicKey)publicKey);
            }
            catch (ClassCastException classCastException) {
                bl = false;
            }
        } else {
            bl = false;
        }
        if (!bl) {
            throw new InvalidKeyException(Msg.getString("K00a5", publicKey));
        }
        this.state = 2;
        this.resetHash();
    }

    @Override
    protected byte[] engineSign() {
        try {
            byte[] byArray = this.rsaEngine.signSSA_PKCS1_v15Impl(this.privateKey, this.getHash());
            this.resetHash();
            return byArray;
        }
        catch (IOException iOException) {
            throw new SignatureException(iOException.getMessage());
        }
    }

    @Override
    protected void engineUpdate(byte by) {
        this.updateHash(by);
    }

    @Override
    protected void engineUpdate(byte[] byArray, int n, int n2) {
        this.updateHash(byArray, n, n2);
    }

    @Override
    protected boolean engineVerify(byte[] byArray) {
        int n = this.publicKey.getModulus().bitLength();
        int n2 = (int)Math.ceil((double)n / 8.0);
        n2 = Math.min(byArray.length, n2);
        byte[] byArray2 = new byte[n2];
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n2);
        boolean bl = this.rsaEngine.verifySSA_PKCS1_v15Impl(this.publicKey, this.getHash(), byArray2);
        this.resetHash();
        return bl;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(" RSA Signature (");
        stringBuffer.append(STATE_DESCRIPTION[this.state]);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    protected abstract void resetHash() {
    }

    protected abstract void updateHash(byte[] byArray, int n, int n2) {
    }

    protected abstract void updateHash(byte by) {
    }

    protected abstract byte[] getHash() {
    }
}

