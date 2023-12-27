/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509CertImpl$PrincipalFactory;
import com.ibm.oti.util.ASN1Decoder$Node;

final class X509CertImpl$1$prinFactory
implements X509CertImpl$PrincipalFactory {
    X509CertImpl$1$prinFactory() {
    }

    @Override
    public X500Principal getInstance(ASN1Decoder$Node aSN1Decoder$Node) {
        return new X500Principal(aSN1Decoder$Node);
    }
}

