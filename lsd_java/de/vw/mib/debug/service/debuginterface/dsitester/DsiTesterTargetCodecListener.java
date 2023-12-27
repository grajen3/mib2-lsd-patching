/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.dsitester;

public interface DsiTesterTargetCodecListener {
    default public void invokationResult(boolean bl, String string) {
    }

    default public void invokeServiceDecoded(String string, int n, String string2, Object[] objectArray) {
    }

    default public void invokeResponseDecoded(String string, int n, String string2, Object[] objectArray) {
    }

    default public void invokeNotificationDecoded(String string, int n, String string2, Object[] objectArray) {
    }
}

