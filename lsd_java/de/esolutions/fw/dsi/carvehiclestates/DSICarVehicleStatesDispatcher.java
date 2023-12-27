/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carvehiclestates;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carvehiclestates.DSICarVehicleStatesReply;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.DSICarVehicleStatesReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class DSICarVehicleStatesDispatcher
extends AbstractDispatcher
implements DSICarVehicleStatesReply {
    private DSICarVehicleStatesReplyService service = new DSICarVehicleStatesReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarVehicleStatesDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = DSICarVehicleStatesDispatcher.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateOilLevelViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateOilLevelViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateOilLevelData(oilLevelData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateOilLevelData(oilLevelData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVINViewOption(CarViewOption carViewOption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateVINViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateVINViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVINData(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateVINData(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateVINData(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateKeyViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateKeyViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateKeyData(KeyData keyData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateKeyData(keyData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateKeyData(keyData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDrvSchoolSystem(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateDrvSchoolSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateDrvSchoolSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateVehicleInfoViewOptions(vehicleInfoViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateVehicleInfoViewOptions(vehicleInfoViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoHighFrequentViewOptions(dynamicVehicleInfoHighFrequentViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoHighFrequentViewOptions(dynamicVehicleInfoHighFrequentViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoMidFrequentViewOptions(dynamicVehicleInfoMidFrequentViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoMidFrequentViewOptions(dynamicVehicleInfoMidFrequentViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoHighFrequent(dynamicVehicleInfoHighFrequent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoHighFrequent(dynamicVehicleInfoHighFrequent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoMidFrequent(dynamicVehicleInfoMidFrequent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoMidFrequent(dynamicVehicleInfoMidFrequent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateSemiStaticVehicleDataViewOptions(semiStaticDataViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateSemiStaticVehicleDataViewOptions(semiStaticDataViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateSemiStaticVehicleData(semiStaticVehicleData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateSemiStaticVehicleData(semiStaticVehicleData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarVehicleStatesListener);
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoSCR(dynamicVehicleInfoSCR, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)iterator.next();
                    dSICarVehicleStatesListener.updateDynamicVehicleInfoSCR(dynamicVehicleInfoSCR, n);
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
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)objectArray[i2];
                    dSICarVehicleStatesListener.asyncException(n, string, n2);
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
                    DSICarVehicleStatesListener dSICarVehicleStatesListener = (DSICarVehicleStatesListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarVehicleStatesDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarVehicleStatesDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarVehicleStatesListener, new Object[]{string, string2});
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

