/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureSpi;

class Signature$Wrapper
extends Signature {
    SignatureSpi signatureProvider;

    Signature$Wrapper(SignatureSpi signatureSpi, String string) {
        super(string);
        this.signatureProvider = signatureSpi;
    }

    @Override
    public Object clone() {
        Signature$Wrapper signature$Wrapper = new Signature$Wrapper((SignatureSpi)this.signatureProvider.clone(), this.getAlgorithm());
        signature$Wrapper.setProvider(this.getProvider());
        return signature$Wrapper;
    }

    @Override
    protected void engineInitSign(PrivateKey privateKey) {
        this.signatureProvider.engineInitSign(privateKey);
    }

    @Override
    protected void engineInitVerify(PublicKey publicKey) {
        this.signatureProvider.engineInitVerify(publicKey);
    }

    @Override
    protected byte[] engineSign() {
        return this.signatureProvider.engineSign();
    }

    @Override
    protected void engineUpdate(byte[] byArray, int n, int n2) {
        this.signatureProvider.engineUpdate(byArray, n, n2);
    }

    @Override
    protected void engineUpdate(byte by) {
        this.signatureProvider.engineUpdate(by);
    }

    @Override
    protected boolean engineVerify(byte[] byArray) {
        return this.signatureProvider.engineVerify(byArray);
    }

    @Override
    public String toString() {
        if (this.signatureProvider != null) {
            return this.signatureProvider.toString();
        }
        return super.toString();
    }
}

