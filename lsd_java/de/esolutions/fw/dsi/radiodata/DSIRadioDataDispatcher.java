/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radiodata;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioDataReply;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.DSIRadioDataListener;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class DSIRadioDataDispatcher
extends AbstractDispatcher
implements DSIRadioDataReply {
    private DSIRadioDataReplyService service = new DSIRadioDataReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioDataListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIRadioDataDispatcher(int n) {
        super(n, (class$org$dsi$ifc$radiodata$DSIRadioDataListener == null ? (class$org$dsi$ifc$radiodata$DSIRadioDataListener = DSIRadioDataDispatcher.class$("org.dsi.ifc.radiodata.DSIRadioDataListener")) : class$org$dsi$ifc$radiodata$DSIRadioDataListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseRadioStationData(RadioStationDataResponse[] radioStationDataResponseArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responseRadioStationData(radioStationDataResponseArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responseRadioStationLogos(radioStationLogoResponseArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDynamicDatabaseAlteration(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responseDynamicDatabaseAlteration(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCountryList(int[] nArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responseCountryList(nArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDatabaseVersionInfo(int n, int n2, int n3, String string, int n4, int n5, int n6) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responseDatabaseVersionInfo(n, n2, n3, string, n4, n5, n6);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDatabaseState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)iterator.next();
                    this.confirmNotificationListener(1, dSIRadioDataListener);
                    dSIRadioDataListener.updateDatabaseState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)iterator.next();
                    dSIRadioDataListener.updateDatabaseState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePersistStationLogos(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responsePersistStationLogos(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadioStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)iterator.next();
                    this.confirmNotificationListener(2, dSIRadioDataListener);
                    dSIRadioDataListener.updateRadioStationLogos(radioStationLogoResponseArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)iterator.next();
                    dSIRadioDataListener.updateRadioStationLogos(radioStationLogoResponseArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCountryRegionData(CountryRegionData[] countryRegionDataArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responseCountryRegionData(countryRegionDataArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responseCountryRegionTranslationData(countryRegionTranslationDataArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.responsePersistStationLogosWithChangedUrls(radioStationDataArray, resourceLocatorArray, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePersistStationLogosWithChangedUrls(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)iterator.next();
                    this.confirmNotificationListener(4, dSIRadioDataListener);
                    dSIRadioDataListener.updatePersistStationLogosWithChangedUrls(radioStationDataArray, resourceLocatorArray, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)iterator.next();
                    dSIRadioDataListener.updatePersistStationLogosWithChangedUrls(radioStationDataArray, resourceLocatorArray, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)iterator.next();
                    this.confirmNotificationListener(3, dSIRadioDataListener);
                    dSIRadioDataListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)iterator.next();
                    dSIRadioDataListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.profileChanged(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.profileCopied(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.profileReset(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileResetAll(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.profileResetAll(n);
                    continue;
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
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    dSIRadioDataListener.asyncException(n, string, n2);
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
                    DSIRadioDataListener dSIRadioDataListener = (DSIRadioDataListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIRadioDataDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIRadioDataDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIRadioDataListener, new Object[]{string, string2});
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

