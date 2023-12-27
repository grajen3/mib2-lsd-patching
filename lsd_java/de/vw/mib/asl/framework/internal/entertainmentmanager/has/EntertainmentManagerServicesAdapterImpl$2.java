/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.has;

import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.internal.entertainmentmanager.has.EntertainmentManagerServicesAdapterImpl;

class EntertainmentManagerServicesAdapterImpl$2
implements SourceCallback {
    private final /* synthetic */ int val$callId;
    private final /* synthetic */ EntertainmentManagerServicesAdapterImpl this$0;

    EntertainmentManagerServicesAdapterImpl$2(EntertainmentManagerServicesAdapterImpl entertainmentManagerServicesAdapterImpl, int n) {
        this.this$0 = entertainmentManagerServicesAdapterImpl;
        this.val$callId = n;
    }

    @Override
    public void response(ResultCode resultCode, Source source) {
        if (resultCode == ResultCode.OK) {
            EntertainmentManagerServicesAdapterImpl.access$000(this.this$0).activateMediaSourceResult(this.val$callId, 0);
        } else {
            EntertainmentManagerServicesAdapterImpl.access$000(this.this$0).activateMediaSourceResult(this.val$callId, 1);
        }
    }
}

