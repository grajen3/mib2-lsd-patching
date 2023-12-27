/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.fuel;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.speller.SpellerDataHelper;
import de.vw.mib.properties.values.SpellerData;

public final class TravelLinkFreeSpeller {
    SpellerData spellerData = new SpellerData();

    public void deleteChar() {
        block2: {
            try {
                SpellerDataHelper.deleteChar(this.spellerData);
                TLinkServiceManager.getServiceManager().getGuiControllerFuel().updateSpellerFreeCharEntered(this.spellerData);
                TLinkServiceManager.getServiceManager().getGuiControllerFuel().updateSpellerData(this.spellerData);
            }
            catch (Exception exception) {
                if (!ServiceManager.logger2.isTraceEnabled(4)) break block2;
                ServiceManager.logger2.error(4, "COULD NOT DELETE A CHARACTER.", exception);
            }
        }
    }

    public void addChar(String string) {
        block3: {
            try {
                if (null != string) {
                    SpellerDataHelper.addChar(this.spellerData, string);
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().updateSpellerFreeCharEntered(this.spellerData);
                    TLinkServiceManager.getServiceManager().getGuiControllerFuel().updateSpellerData(this.spellerData);
                }
            }
            catch (Exception exception) {
                if (!ServiceManager.logger2.isTraceEnabled(4)) break block3;
                ServiceManager.logger2.error(4, "COULD NOT ADD A CHARACTER IN FREE SPELLER.", exception);
            }
        }
    }

    public void setCursorPosition(int n) {
        block2: {
            try {
                SpellerDataHelper.deselectAll(this.spellerData);
                this.spellerData.setCursorPosition(n);
                TLinkServiceManager.getServiceManager().getGuiControllerFuel().updateSpellerFreeCharEntered(this.spellerData);
                TLinkServiceManager.getServiceManager().getGuiControllerFuel().updateSpellerData(this.spellerData);
            }
            catch (Exception exception) {
                if (!ServiceManager.logger2.isTraceEnabled(4)) break block2;
                ServiceManager.logger2.error(4, "COULD NOT SET CURSOR POSITION IN FREE SPELLER.", exception);
            }
        }
    }

    public void clear() {
        block2: {
            try {
                SpellerDataHelper.clear(this.spellerData);
            }
            catch (Exception exception) {
                if (!ServiceManager.logger2.isTraceEnabled(4)) break block2;
                ServiceManager.logger2.error(4, "COULD NOT CLEAR THE FREE SPELLER.", exception);
            }
        }
    }

    public String getEnteredText() {
        return this.spellerData.getEnteredText().trim();
    }
}

