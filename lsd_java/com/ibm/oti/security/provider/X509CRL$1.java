/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder$TypeMapper;

final class X509CRL$1
implements ASN1Decoder$TypeMapper {
    X509CRL$1() {
    }

    @Override
    public int map(int n, int n2, int n3) {
        if (n == 0) {
            return 16;
        }
        return n;
    }
}

