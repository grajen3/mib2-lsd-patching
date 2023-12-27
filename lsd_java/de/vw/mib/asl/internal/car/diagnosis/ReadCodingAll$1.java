/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.diagnosis;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.car.diagnosis.ReadCodingAll;

class ReadCodingAll$1
implements AdaptionResponse {
    private final /* synthetic */ ReadCodingAll this$0;

    ReadCodingAll$1(ReadCodingAll readCodingAll) {
        this.this$0 = readCodingAll;
    }

    @Override
    public void onSuccess(Access access) {
        int n = access.getValue(0);
        int n2 = access.getValue(1);
        int n3 = access.getValue(2);
        int n4 = access.getValue(3);
        if (ReadCodingAll.access$000(this.this$0).isTraceEnabled(1)) {
            ReadCodingAll.access$000(this.this$0).trace(1, new StringBuffer().append("Car type from diagnosis Brand : ").append(n).append(",Class : ").append(n2).append(",Generation : ").append(n3).append(",Derivate : ").append(n4).toString());
        }
        boolean bl = n == 2 && n2 == 5 && n3 == 1 && n4 == 1;
        this.this$0.setCarTypeVw511(bl);
    }

    @Override
    public void onError() {
        ReadCodingAll.access$000(this.this$0).error(1, new StringBuffer().append(super.getClass().getName()).append(" Was not able to read diagnosis coding all!").toString());
    }
}

