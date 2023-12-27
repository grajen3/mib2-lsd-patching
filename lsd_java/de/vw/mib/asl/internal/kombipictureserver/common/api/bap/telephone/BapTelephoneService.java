/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephone;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneCallInfo;

public interface BapTelephoneService
extends BapTelephone {
    default public BapTelephoneCallInfo[] getCallInfos() {
    }
}

