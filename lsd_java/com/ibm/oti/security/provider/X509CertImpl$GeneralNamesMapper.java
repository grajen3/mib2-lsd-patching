/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.util.ASN1Decoder$TypeMapper;

class X509CertImpl$GeneralNamesMapper
implements ASN1Decoder$TypeMapper {
    @Override
    public int map(int n, int n2, int n3) {
        switch (n) {
            case 1: 
            case 2: 
            case 6: {
                return 22;
            }
            case 4: {
                return 19;
            }
            case 7: {
                return 4;
            }
            case 8: {
                return 6;
            }
        }
        return 4;
    }
}

