/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.util;

import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import org.dsi.ifc.global.NavLocation;

public class GeneralSubjectUtil {
    public void setOriginalLocation(XSpellerTarget xSpellerTarget, NavLocation navLocation, boolean bl) {
        boolean bl2 = false;
        if (SpellerContext.ACTIVE_STATE == 5 || SpellerContext.ACTIVE_STATE == 4) {
            bl2 = true;
        } else {
            this.log(xSpellerTarget, new StringBuffer("No setting of originalLocation needed for this state: ").append(SpellerContext.ACTIVE_STATE));
        }
        if (!xSpellerTarget.LOCATIONINPUT_ENABLE_NAR_FEATURES && bl2) {
            this.log(xSpellerTarget, new StringBuffer("Setting new originalLocation to: ").append(navLocation.toString()));
            SpellerContext.setOriginalLocation(navLocation, xSpellerTarget);
        } else {
            this.log(xSpellerTarget, new StringBuffer("NAR feature enabled or changeLocation not necessary - do not set originalLocation"));
        }
        if (xSpellerTarget.LOCATIONINPUT_ENABLE_NAR_FEATURES && bl) {
            this.log(xSpellerTarget, new StringBuffer("[CalledByNothing=TRUE] Setting new originalLocation to: ").append(navLocation.toString()));
            SpellerContext.setOriginalLocation(navLocation, xSpellerTarget);
        }
        if (xSpellerTarget.LOCATIONINPUT_ENABLE_NAR_FEATURES) {
            this.log(xSpellerTarget, new StringBuffer("[DEFAULT] Setting new originalLocation to: ").append(navLocation.toString()));
            SpellerContext.setOriginalLocation(navLocation, xSpellerTarget);
        }
    }

    private void log(XSpellerTarget xSpellerTarget, StringBuffer stringBuffer) {
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            xSpellerTarget.getLogger().makeTrace().append(stringBuffer.toString()).log();
        }
    }
}

