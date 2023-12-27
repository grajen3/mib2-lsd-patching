/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder$TypeMapper;

final class PKCS7$2
implements ASN1Decoder$TypeMapper {
    PKCS7$2() {
    }

    @Override
    public int map(int n, int n2, int n3) {
        if (n == 0 || n == 1) {
            return 17;
        }
        return n;
    }
}

