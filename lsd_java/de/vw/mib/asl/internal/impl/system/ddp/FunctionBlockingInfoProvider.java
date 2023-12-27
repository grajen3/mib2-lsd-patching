/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.internal.impl.system.ddp.FunctionBlockingInfo;
import java.util.ArrayList;
import java.util.List;

public class FunctionBlockingInfoProvider {
    public static List provide() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FunctionBlockingInfo("FB_MISC_21", 1113, "ASL.Configuration.isDdpAnimationBlockingEnabled", 1553012736));
        arrayList.add(new FunctionBlockingInfo("FB_MISC_22", 1114, "ASL.Configuration.isDdpSDSReadoutMessageBlockingEnabled", 1536235520));
        arrayList.add(new FunctionBlockingInfo("FB_MISC_24", 1116, "ASL.Configuration.isDdpPictureBlockingEnabled", 1502681088));
        arrayList.add(new FunctionBlockingInfo("FB_MISC_27", 1119, "ASL.Configuration.isDdpSDSHelpTeleprompterBlockingEnabled", 1519458304));
        return arrayList;
    }
}

