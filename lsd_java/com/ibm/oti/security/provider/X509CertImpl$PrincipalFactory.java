/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.util.ASN1Decoder$Node;

public interface X509CertImpl$PrincipalFactory {
    default public X500Principal getInstance(ASN1Decoder$Node aSN1Decoder$Node) {
    }
}

