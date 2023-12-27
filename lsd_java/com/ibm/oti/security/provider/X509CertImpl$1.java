/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder$TypeMapper;

final class X509CertImpl$1
implements ASN1Decoder$TypeMapper {
    X509CertImpl$1() {
    }

    @Override
    public int map(int n, int n2, int n3) {
        switch (n) {
            case 1: 
            case 2: {
                return 2;
            }
            case 0: 
            case 3: {
                return 16;
            }
        }
        return n;
    }
}

