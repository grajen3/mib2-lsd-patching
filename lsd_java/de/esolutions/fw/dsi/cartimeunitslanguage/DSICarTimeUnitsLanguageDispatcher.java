/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.cartimeunitslanguage;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.DSICarTimeUnitsLanguageReply;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.DSICarTimeUnitsLanguageReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public class DSICarTimeUnitsLanguageDispatcher
extends AbstractDispatcher
implements DSICarTimeUnitsLanguageReply {
    private DSICarTimeUnitsLanguageReplyService service = new DSICarTimeUnitsLanguageReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarTimeUnitsLanguageDispatcher(int n) {
        super(n, (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = DSICarTimeUnitsLanguageDispatcher.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateUnitmasterViewOptions(unitmasterViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateUnitmasterViewOptions(unitmasterViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMenuLanguage(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateMenuLanguage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateMenuLanguage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTemperatureUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateTemperatureUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateTemperatureUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDistanceUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateDistanceUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateDistanceUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeedUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateSpeedUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateSpeedUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePressureUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updatePressureUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updatePressureUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVolumeUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateVolumeUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateVolumeUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateConsumptionPetrolUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateConsumptionPetrolUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateConsumptionPetrolUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateConsumptionGasUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateConsumptionGasUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateConsumptionGasUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateConsumptionElectricUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateConsumptionElectricUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateConsumptionElectricUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockFormat(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockFormat(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockFormat(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDateFormat(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateDateFormat(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateDateFormat(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockViewOptions(clockViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockViewOptions(clockViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockDate(ClockDate clockDate, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockDate(clockDate, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockDate(clockDate, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockTime(ClockTime clockTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockTime(clockTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockTime(clockTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockSource(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockSource(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockSource(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockDayLightSaving(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockDayLightSaving(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockDayLightSaving(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockDayLightSavingData(clockDayLightSavingData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockDayLightSavingData(clockDayLightSavingData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockTimeZoneOffset(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockTimeZoneOffset(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockTimeZoneOffset(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockTimeSourcesAvailable(clockSources, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockTimeSourcesAvailable(clockSources, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateClockGPSSyncData(clockGPSSyncData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateClockGPSSyncData(clockGPSSyncData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeUmSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)objectArray[i2];
                    dSICarTimeUnitsLanguageListener.acknowledgeUmSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUTCOffset(UTCOffset uTCOffset, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateUTCOffset(uTCOffset, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateUTCOffset(uTCOffset, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSkin(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateSkin(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateSkin(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWeightUnit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarTimeUnitsLanguageListener);
                    dSICarTimeUnitsLanguageListener.updateWeightUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)iterator.next();
                    dSICarTimeUnitsLanguageListener.updateWeightUnit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)objectArray[i2];
                    dSICarTimeUnitsLanguageListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = (DSICarTimeUnitsLanguageListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarTimeUnitsLanguageDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarTimeUnitsLanguageDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarTimeUnitsLanguageListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

