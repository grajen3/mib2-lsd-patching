/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.https;

import com.ibm.oti.connection.https.Connection;
import com.ibm.oti.util.ASN1Decoder$TypeMapper;

final class Connection$1
implements ASN1Decoder$TypeMapper {
    final /* synthetic */ Connection this$0;

    Connection$1(Connection connection) {
        this.this$0 = connection;
    }

    @Override
    public int map(int n, int n2, int n3) {
        if (n == 2) {
            return 22;
        }
        return n;
    }
}

