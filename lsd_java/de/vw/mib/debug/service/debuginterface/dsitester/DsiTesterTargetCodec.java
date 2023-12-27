/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.dsitester;

import de.vw.mib.log4mib.BinaryMessage;

public interface DsiTesterTargetCodec {
    default public BinaryMessage encodeSuccsessResponse(BinaryMessage binaryMessage, boolean bl, String string) {
    }
}

