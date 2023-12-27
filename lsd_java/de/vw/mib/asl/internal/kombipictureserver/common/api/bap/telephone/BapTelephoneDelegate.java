/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneService;

public interface BapTelephoneDelegate {
    public static final int BAP_TELEPHONE_CALLS;
    public static final int[] BAP_TELEPHONE_PROPERTIES;

    default public void updateBapTelephone(BapTelephoneService bapTelephoneService, int n) {
    }

    static {
        BAP_TELEPHONE_PROPERTIES = new int[]{22};
    }
}

