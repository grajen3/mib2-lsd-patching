/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.std2;

import de.vw.mib.asl.framework.api.diagnosis.config.LoadFurtherData;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessLanguage;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class LoadFurtherDataImpl
extends AccessLanguage
implements LoadFurtherData {
    private final int[] mIndexToId = new int[]{738, 740, 742};

    public LoadFurtherDataImpl(byte[] byArray) {
        super(byArray, new int[]{22}, 906042371, 0);
        boolean bl;
        this.mConfiguration = new int[]{1701732167, 66, 30029, 40, 0, 0, 0, -1, 20051, 8, 5, 0, 0, -1, 30029, 40, 6, 0, 0, -1, 20051, 8, 11, 0, 0, -1, 30029, 40, 12, 0, 0, -1, 20051, 8, 17, 0, 0, -1, 20051, 8, 18, 0, 0, -1, 20051, 8, 19, 0, 0, -1, 0, 30029, 16, 20, 0, 50, -1, 22, 128, 128, 740, 14, 743, 32, 746, 51, 738, 2, 741, 20, 744, 38, 128, 128, 739, 8, 742, 26, 745, 44, 57};
        this.mEngine = new Engine(this.mConfiguration);
        boolean bl2 = bl = !this.validate();
        if (bl) {
            LogMessage logMessage = ServiceManager.logger.error(16384).append("Load Further data invalid");
            for (int i2 = 0; i2 < this.mIndexToId.length; ++i2) {
                logMessage.append(", ");
                logMessage.append(new String(this.getByteArray(this.mIndexToId[i2])));
            }
            logMessage.log();
        }
        ServiceManager.persistence.writeBoolean(906042371, 0, bl);
    }

    private boolean validate() {
        int n;
        for (int i2 = 0; i2 < this.mIndexToId.length; ++i2) {
            n = this.mIndexToId[i2];
            byte[] byArray = this.getByteArray(n);
            if (this.isValidLanguage(byArray)) continue;
            return false;
        }
        String[] stringArray = ServiceManager.configManagerDiag.getVariantDefinedLanguages();
        if (stringArray == null) {
            return false;
        }
        block1: for (n = 0; n < this.mIndexToId.length; ++n) {
            int n2 = this.mIndexToId[n];
            byte[] byArray = this.getByteArray(n2);
            String string = new String(byArray);
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                String string2 = stringArray[i3];
                if (string.equals(string2)) continue block1;
            }
            return false;
        }
        return true;
    }
}

