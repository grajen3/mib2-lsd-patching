/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carkombi;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carkombi.DSICarKombiReply;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCComfortPowerConsumption;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.carkombi.BCIndications;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.BCMaxValues;
import org.dsi.ifc.carkombi.BCMenueConfiguration;
import org.dsi.ifc.carkombi.BCRefuelVolume;
import org.dsi.ifc.carkombi.BCResetTimeStamp;
import org.dsi.ifc.carkombi.BCShortTermGeneralData;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCStatisticsAC;
import org.dsi.ifc.carkombi.BCStatisticsConfig;
import org.dsi.ifc.carkombi.BCStatisticsDistanceEU;
import org.dsi.ifc.carkombi.BCStatisticsRE;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCTankLevel;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteDistance;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.carkombi.HUDContent;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;
import org.dsi.ifc.carkombi.SIADistanceData;
import org.dsi.ifc.carkombi.SIAHistoryListRecord;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;
import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarBCTime;

public class DSICarKombiDispatcher
extends AbstractDispatcher
implements DSICarKombiReply {
    private DSICarKombiReplyService service = new DSICarKombiReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarKombiDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = DSICarKombiDispatcher.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarKombiListener);
                    dSICarKombiListener.updateSIAViewOptions(sIAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIAViewOptions(sIAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIAServiceData(SIAServiceData sIAServiceData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarKombiListener);
                    dSICarKombiListener.updateSIAServiceData(sIAServiceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIAServiceData(sIAServiceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIAOilInspection(SIAOilInspection sIAOilInspection, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarKombiListener);
                    dSICarKombiListener.updateSIAOilInspection(sIAOilInspection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIAOilInspection(sIAOilInspection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateEndOfSIAReset(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.indicateEndOfSIAReset(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIAHistoryListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(103);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(103, dSICarKombiListener);
                    dSICarKombiListener.updateSIAHistoryListUpdateInfo(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(103);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIAHistoryListUpdateInfo(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSIAHistoryList(CarArrayListUpdateInfo carArrayListUpdateInfo, SIAHistoryListRecord[] sIAHistoryListRecordArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseSIAHistoryList(carArrayListUpdateInfo, sIAHistoryListRecordArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIAHistoryListTotalNumberOfElements(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(104);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(104, dSICarKombiListener);
                    dSICarKombiListener.updateSIAHistoryListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(104);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIAHistoryListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIADistanceOilUser(SIADistanceData sIADistanceData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(105);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(105, dSICarKombiListener);
                    dSICarKombiListener.updateSIADistanceOilUser(sIADistanceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(105);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIADistanceOilUser(sIADistanceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIADistanceAirFilterUser(SIADistanceData sIADistanceData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(106);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(106, dSICarKombiListener);
                    dSICarKombiListener.updateSIADistanceAirFilterUser(sIADistanceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(106);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIADistanceAirFilterUser(sIADistanceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIADistanceOilFilterUser(SIADistanceData sIADistanceData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(107);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(107, dSICarKombiListener);
                    dSICarKombiListener.updateSIADistanceOilFilterUser(sIADistanceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(107);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIADistanceOilFilterUser(sIADistanceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIAInspectionDistanceUser(SIADistanceData sIADistanceData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(108);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(108, dSICarKombiListener);
                    dSICarKombiListener.updateSIAInspectionDistanceUser(sIADistanceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(108);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIAInspectionDistanceUser(sIADistanceData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIADailyAverageMileage(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(109);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(109, dSICarKombiListener);
                    dSICarKombiListener.updateSIADailyAverageMileage(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(109);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateSIADailyAverageMileage(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarKombiListener);
                    dSICarKombiListener.updateBCViewOptions(bCViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCViewOptions(bCViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCIndications(BCIndications bCIndications, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarKombiListener);
                    dSICarKombiListener.updateBCIndications(bCIndications, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCIndications(bCIndications, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCCurrentConsumption1(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarKombiListener);
                    dSICarKombiListener.updateBCCurrentConsumption1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCCurrentConsumption1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCCurrentConsumption2(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarKombiListener);
                    dSICarKombiListener.updateBCCurrentConsumption2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCCurrentConsumption2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarKombiListener);
                    dSICarKombiListener.updateBCCurrentRange1(carBCCurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCCurrentRange1(carBCCurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarKombiListener);
                    dSICarKombiListener.updateBCCurrentRange2(carBCCurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCCurrentRange2(carBCCurrentRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCTotalDistance(CarBCDistance carBCDistance, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarKombiListener);
                    dSICarKombiListener.updateBCTotalDistance(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCTotalDistance(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarKombiListener);
                    dSICarKombiListener.updateBCShortTermAverageConsumption1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCShortTermAverageConsumption1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCShortTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarKombiListener);
                    dSICarKombiListener.updateBCShortTermAverageConsumption2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCShortTermAverageConsumption2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCShortTermGeneral(BCShortTermGeneralData bCShortTermGeneralData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarKombiListener);
                    dSICarKombiListener.updateBCShortTermGeneral(bCShortTermGeneralData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCShortTermGeneral(bCShortTermGeneralData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarKombiListener);
                    dSICarKombiListener.updateBCLongTermAverageConsumption1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCLongTermAverageConsumption1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCLongTermAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarKombiListener);
                    dSICarKombiListener.updateBCLongTermAverageConsumption2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCLongTermAverageConsumption2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarKombiListener);
                    dSICarKombiListener.updateBCLongTermGeneral(bCLongTermGeneralData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCLongTermGeneral(bCLongTermGeneralData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCCycleAverageConsumption1(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarKombiListener);
                    dSICarKombiListener.updateBCCycleAverageConsumption1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCCycleAverageConsumption1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCCycleAverageConsumption2(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarKombiListener);
                    dSICarKombiListener.updateBCCycleAverageConsumption2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCCycleAverageConsumption2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCCycleGeneral(BCCycleGeneralData bCCycleGeneralData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarKombiListener);
                    dSICarKombiListener.updateBCCycleGeneral(bCCycleGeneralData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCCycleGeneral(bCCycleGeneralData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCVZADisplay(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarKombiListener);
                    dSICarKombiListener.updateBCVZADisplay(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCVZADisplay(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCLifeTipsDisplay(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarKombiListener);
                    dSICarKombiListener.updateBCLifeTipsDisplay(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCLifeTipsDisplay(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCConsumerDisplay(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarKombiListener);
                    dSICarKombiListener.updateBCConsumerDisplay(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCConsumerDisplay(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCTankLevel1(BCTankLevel bCTankLevel, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarKombiListener);
                    dSICarKombiListener.updateBCTankLevel1(bCTankLevel, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCTankLevel1(bCTankLevel, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCTankLevel2(BCTankLevel bCTankLevel, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarKombiListener);
                    dSICarKombiListener.updateBCTankLevel2(bCTankLevel, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCTankLevel2(bCTankLevel, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCRefuelVolume1(BCRefuelVolume bCRefuelVolume, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarKombiListener);
                    dSICarKombiListener.updateBCRefuelVolume1(bCRefuelVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCRefuelVolume1(bCRefuelVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCRefuelVolume2(BCRefuelVolume bCRefuelVolume, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarKombiListener);
                    dSICarKombiListener.updateBCRefuelVolume2(bCRefuelVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCRefuelVolume2(bCRefuelVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCMenue1Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarKombiListener);
                    dSICarKombiListener.updateBCMenue1Config(bCMenueConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCMenue1Config(bCMenueConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCMenue2Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(28, dSICarKombiListener);
                    dSICarKombiListener.updateBCMenue2Config(bCMenueConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCMenue2Config(bCMenueConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCMenue3Config(BCMenueConfiguration bCMenueConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(29, dSICarKombiListener);
                    dSICarKombiListener.updateBCMenue3Config(bCMenueConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCMenue3Config(bCMenueConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCOilTemperature(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarKombiListener);
                    dSICarKombiListener.updateBCOilTemperature(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCOilTemperature(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCDigitalSpeed(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarKombiListener);
                    dSICarKombiListener.updateBCDigitalSpeed(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCDigitalSpeed(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStopwatch(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarKombiListener);
                    dSICarKombiListener.updateBCStopwatch(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStopwatch(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCVzaMFA(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarKombiListener);
                    dSICarKombiListener.updateBCVzaMFA(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCVzaMFA(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarKombiListener);
                    dSICarKombiListener.updateBCSpeedWarning(bCSpeedWarningSettings, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCSpeedWarning(bCSpeedWarningSettings, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCGearRecommendation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(34, dSICarKombiListener);
                    dSICarKombiListener.updateBCGearRecommendation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCGearRecommendation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCRearSeatbeltWarning(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(35, dSICarKombiListener);
                    dSICarKombiListener.updateBCRearSeatbeltWarning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCRearSeatbeltWarning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCOutsideTemperature(CarBCTemperature carBCTemperature, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(65, dSICarKombiListener);
                    dSICarKombiListener.updateBCOutsideTemperature(carBCTemperature, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCOutsideTemperature(carBCTemperature, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateEndOfBCMenuReset(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.indicateEndOfBCMenuReset(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(41, dSICarKombiListener);
                    dSICarKombiListener.updateBCVehicleStateListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCVehicleStateListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseVehicleStateUpdateInfo(bCVehicleStateUpdateInfoAH, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseVehicleStateListWarningIDdynValueAlternativeText(bCVehicleStateUpdateInfoAH, n, n2, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseVehicleStateListWarningIDdynValue(bCVehicleStateUpdateInfoAH, listWarningIDsDynValuesArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseVehicleStateListAlternativeText(bCVehicleStateUpdateInfoAH, n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseVehicleStateListdynValue(bCVehicleStateUpdateInfoAH, listDynValuesArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseVehicleStateListPos(bCVehicleStateUpdateInfoAH, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeBcSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.acknowledgeBcSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeHUDSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.acknowledgeHUDSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeDCSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.acknowledgeDCSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeBcStatisticsReset(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.acknowledgeBcStatisticsReset(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsDistanceAC1(BCStatisticsAC bCStatisticsAC, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(61, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsDistanceAC1(bCStatisticsAC, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsDistanceAC1(bCStatisticsAC, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsDistanceAC2(BCStatisticsAC bCStatisticsAC, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(60, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsDistanceAC2(bCStatisticsAC, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsDistanceAC2(bCStatisticsAC, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsDistanceRE(BCStatisticsRE bCStatisticsRE, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(59, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsDistanceRE(bCStatisticsRE, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsDistanceRE(bCStatisticsRE, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsDistanceZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(58, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsDistanceZE(bCStatisticsZE, bCZeroEmissionAbsoluteDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsDistanceZE(bCStatisticsZE, bCZeroEmissionAbsoluteDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalAC1(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(57, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsDistanceCurrentIntervalAC1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsDistanceCurrentIntervalAC1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalAC2(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(56, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsDistanceCurrentIntervalAC2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsDistanceCurrentIntervalAC2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(55, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsDistanceCurrentIntervalRE(bCAverageRecoveredEnergy, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsDistanceCurrentIntervalRE(bCAverageRecoveredEnergy, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsDistanceCurrentIntervalZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteDistance bCZeroEmissionAbsoluteDistance, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(54, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsDistanceCurrentIntervalZE(bCZeroEmissionRelative, bCZeroEmissionAbsoluteDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsDistanceCurrentIntervalZE(bCZeroEmissionRelative, bCZeroEmissionAbsoluteDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsTimeAC1(BCStatisticsAC bCStatisticsAC, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(53, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsTimeAC1(bCStatisticsAC, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsTimeAC1(bCStatisticsAC, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsTimeAC2(BCStatisticsAC bCStatisticsAC, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(52, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsTimeAC2(bCStatisticsAC, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsTimeAC2(bCStatisticsAC, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsTimeRE(BCStatisticsRE bCStatisticsRE, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(51, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsTimeRE(bCStatisticsRE, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsTimeRE(bCStatisticsRE, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsTimeZE(BCStatisticsZE bCStatisticsZE, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(50, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsTimeZE(bCStatisticsZE, bCZeroEmissionAbsoluteTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsTimeZE(bCStatisticsZE, bCZeroEmissionAbsoluteTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodAC1(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsTimeCurrentPeriodAC1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsTimeCurrentPeriodAC1(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodAC2(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsTimeCurrentPeriodAC2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsTimeCurrentPeriodAC2(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodRE(BCAverageRecoveredEnergy bCAverageRecoveredEnergy, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(47, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsTimeCurrentPeriodRE(bCAverageRecoveredEnergy, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsTimeCurrentPeriodRE(bCAverageRecoveredEnergy, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsTimeCurrentPeriodZE(BCZeroEmissionRelative bCZeroEmissionRelative, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(46, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsTimeCurrentPeriodZE(bCZeroEmissionRelative, bCZeroEmissionAbsoluteTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsTimeCurrentPeriodZE(bCZeroEmissionRelative, bCZeroEmissionAbsoluteTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticsConfig(BCStatisticsConfig bCStatisticsConfig, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticsConfig(bCStatisticsConfig, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticsConfig(bCStatisticsConfig, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticDistanceEUkm(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(67, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticDistanceEUkm(bCStatisticsDistanceEU, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticDistanceEUkm(bCStatisticsDistanceEU, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCStatisticDistanceEUmls(BCStatisticsDistanceEU bCStatisticsDistanceEU, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(68, dSICarKombiListener);
                    dSICarKombiListener.updateBCStatisticDistanceEUmls(bCStatisticsDistanceEU, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCStatisticDistanceEUmls(bCStatisticsDistanceEU, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(64, dSICarKombiListener);
                    dSICarKombiListener.updateBCOilTemperatureValue(carBCTemperature, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCOilTemperatureValue(carBCTemperature, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCCoolantTemperature(CarBCTemperature carBCTemperature, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(63, dSICarKombiListener);
                    dSICarKombiListener.updateBCCoolantTemperature(carBCTemperature, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCCoolantTemperature(carBCTemperature, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCComfortPowerConsumption(BCComfortPowerConsumption bCComfortPowerConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(62, dSICarKombiListener);
                    dSICarKombiListener.updateBCComfortPowerConsumption(bCComfortPowerConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCComfortPowerConsumption(bCComfortPowerConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCTotalCurrentRange(CarBCDistance carBCDistance, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(69, dSICarKombiListener);
                    dSICarKombiListener.updateBCTotalCurrentRange(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCTotalCurrentRange(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCZeroEmissionDistanceST(CarBCDistance carBCDistance, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(70, dSICarKombiListener);
                    dSICarKombiListener.updateBCZeroEmissionDistanceST(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCZeroEmissionDistanceST(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCZeroEmissionDistanceLT(CarBCDistance carBCDistance, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(72);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(72, dSICarKombiListener);
                    dSICarKombiListener.updateBCZeroEmissionDistanceLT(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(72);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCZeroEmissionDistanceLT(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCZeroEmissionDistanceCY(CarBCDistance carBCDistance, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(74);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(74, dSICarKombiListener);
                    dSICarKombiListener.updateBCZeroEmissionDistanceCY(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(74);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCZeroEmissionDistanceCY(carBCDistance, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCZeroEmissionTimeST(CarBCTime carBCTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(71);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(71, dSICarKombiListener);
                    dSICarKombiListener.updateBCZeroEmissionTimeST(carBCTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(71);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCZeroEmissionTimeST(carBCTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCZeroEmissionTimeLT(CarBCTime carBCTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(73);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(73, dSICarKombiListener);
                    dSICarKombiListener.updateBCZeroEmissionTimeLT(carBCTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(73);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCZeroEmissionTimeLT(carBCTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCZeroEmissionTimeCY(CarBCTime carBCTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(75, dSICarKombiListener);
                    dSICarKombiListener.updateBCZeroEmissionTimeCY(carBCTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCZeroEmissionTimeCY(carBCTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCMaxValues(BCMaxValues bCMaxValues, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(76, dSICarKombiListener);
                    dSICarKombiListener.updateBCMaxValues(bCMaxValues, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCMaxValues(bCMaxValues, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCResetTimeStampST(BCResetTimeStamp bCResetTimeStamp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(77, dSICarKombiListener);
                    dSICarKombiListener.updateBCResetTimeStampST(bCResetTimeStamp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCResetTimeStampST(bCResetTimeStamp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCResetTimeStampLT(BCResetTimeStamp bCResetTimeStamp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(78, dSICarKombiListener);
                    dSICarKombiListener.updateBCResetTimeStampLT(bCResetTimeStamp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCResetTimeStampLT(bCResetTimeStamp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCResetTimeStampCY(BCResetTimeStamp bCResetTimeStamp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(79, dSICarKombiListener);
                    dSICarKombiListener.updateBCResetTimeStampCY(bCResetTimeStamp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCResetTimeStampCY(bCResetTimeStamp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBCAstaMFA(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(94);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(94, dSICarKombiListener);
                    dSICarKombiListener.updateBCAstaMFA(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(94);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateBCAstaMFA(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarKombiListener);
                    dSICarKombiListener.updateHUDViewOptions(hUDViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDViewOptions(hUDViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDHeightAdjustment(byte by, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarKombiListener);
                    dSICarKombiListener.updateHUDHeightAdjustment(by, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDHeightAdjustment(by, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDBrightness(byte by, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarKombiListener);
                    dSICarKombiListener.updateHUDBrightness(by, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDBrightness(by, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDColour(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(81, dSICarKombiListener);
                    dSICarKombiListener.updateHUDColour(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDColour(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDContent(HUDContent hUDContent, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(40, dSICarKombiListener);
                    dSICarKombiListener.updateHUDContent(hUDContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDContent(hUDContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDInfo(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarKombiListener);
                    dSICarKombiListener.updateHUDInfo(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDInfo(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(80, dSICarKombiListener);
                    dSICarKombiListener.updateHUDSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDRotationAdjustment(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(66, dSICarKombiListener);
                    dSICarKombiListener.updateHUDRotationAdjustment(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDRotationAdjustment(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCViewOptions(DCViewOptions dCViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(82, dSICarKombiListener);
                    dSICarKombiListener.updateDCViewOptions(dCViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCViewOptions(dCViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCBrightness(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(83);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(83, dSICarKombiListener);
                    dSICarKombiListener.updateDCBrightness(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(83);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCBrightness(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCVolume(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(84);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(84, dSICarKombiListener);
                    dSICarKombiListener.updateDCVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(84);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(85);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(85, dSICarKombiListener);
                    dSICarKombiListener.updateDCElementContentSelectionListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(85);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCElementContentSelectionListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(86);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(86, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplay1Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(86);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplay1Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(87);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(87, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplay2Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(87);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplay2Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplay3Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(88);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(88, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplay3Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(88);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplay3Setup(dCMainItems, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplay1MainSelection(DCMainItems dCMainItems, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(89);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(89, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplay1MainSelection(dCMainItems, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(89);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplay1MainSelection(dCMainItems, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplay2MainSelection(DCMainItems dCMainItems, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(90);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(90, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplay2MainSelection(dCMainItems, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(90);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplay2MainSelection(dCMainItems, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplay3MainSelection(DCMainItems dCMainItems, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(91);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(91, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplay3MainSelection(dCMainItems, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(91);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplay3MainSelection(dCMainItems, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseDCElementContentSelectionListRAF(dCElementContentSelectionListUpdateInfo, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseDCElementContentSelectionListRA1(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseDCElementContentSelectionListRA2(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA2Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(92);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(92, dSICarKombiListener);
                    dSICarKombiListener.updateDCElementContentSelectionListUpdateInfo(dCElementContentSelectionListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(92);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCElementContentSelectionListUpdateInfo(dCElementContentSelectionListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCAdditionalInstrumentSetup(DCAdditionalInstrument dCAdditionalInstrument, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(93);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(93, dSICarKombiListener);
                    dSICarKombiListener.updateDCAdditionalInstrumentSetup(dCAdditionalInstrument, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(93);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCAdditionalInstrumentSetup(dCAdditionalInstrument, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCAdditionalInstrument2Setup(DCAdditionalInstrument2 dCAdditionalInstrument2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(95);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(95, dSICarKombiListener);
                    dSICarKombiListener.updateDCAdditionalInstrument2Setup(dCAdditionalInstrument2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(95);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCAdditionalInstrument2Setup(dCAdditionalInstrument2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(96);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(96, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplayPresetsListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(96);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplayPresetsListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.responseDCDisplayPresetsList(carArrayListUpdateInfo, dCDisplayPresetsListRecordArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(97);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(97, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplayPresetsListUpdateInfo(carArrayListUpdateInfo, dCDisplayPresetsListRecordArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(97);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplayPresetsListUpdateInfo(carArrayListUpdateInfo, dCDisplayPresetsListRecordArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(98);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(98, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplayDependencySetup(dCDisplayDependency, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(98);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplayDependencySetup(dCDisplayDependency, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCActiveDisplayPreset(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(99);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(99, dSICarKombiListener);
                    dSICarKombiListener.updateDCActiveDisplayPreset(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(99);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCActiveDisplayPreset(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCDisplayViewConfiguration(DCDisplayViewConfiguration dCDisplayViewConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(100);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(100, dSICarKombiListener);
                    dSICarKombiListener.updateDCDisplayViewConfiguration(dCDisplayViewConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(100);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCDisplayViewConfiguration(dCDisplayViewConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCompassInfo(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarKombiListener);
                    dSICarKombiListener.updateCompassInfo(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateCompassInfo(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHUDLicense(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(101);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(101, dSICarKombiListener);
                    dSICarKombiListener.updateHUDLicense(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(101);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateHUDLicense(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDCLEDConfiguration(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(102);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    this.confirmNotificationListener(102, dSICarKombiListener);
                    dSICarKombiListener.updateDCLEDConfiguration(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(102);
            while (iterator.hasNext()) {
                try {
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)iterator.next();
                    dSICarKombiListener.updateDCLEDConfiguration(bl, n);
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
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    dSICarKombiListener.asyncException(n, string, n2);
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
                    DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarKombiDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarKombiDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarKombiListener, new Object[]{string, string2});
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

