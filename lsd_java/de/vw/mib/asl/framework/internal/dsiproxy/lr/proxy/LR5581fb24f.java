/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.proxy;

import de.vw.mib.reflection.AbstractProxy;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEEnergyFlowComfort;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmERangeGainTotal;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.DSICarEcoListener;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.RangeDataResidualEnergy;
import org.dsi.ifc.careco.RangeDataViewOptions;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.dsi.ifc.careco.StartStopProhibitList;
import org.dsi.ifc.careco.StartStopRestartList;
import org.dsi.ifc.careco.StartStopRestartProhibitList;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCCurrentRange;

public final class LR5581fb24f
extends AbstractProxy
implements DSICarEcoListener,
DSICarDrivingCharacteristicsListener {
    private static final Method[] JMS = new Method[124];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5581fb24f(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void updateBCmEViewOptions(BCmEViewOptions bCmEViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(0, "org.dsi.ifc.careco.DSICarEcoListener", -1934117258, -913457456), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(1, "org.dsi.ifc.careco.DSICarEcoListener", 749577806, 765625423), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmEConsumption(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5581fb24f.gjm(2, "org.dsi.ifc.careco.DSICarEcoListener", -300272497, -448335035), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmELiveTip(int n, boolean bl, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(3, "org.dsi.ifc.careco.DSICarEcoListener", 1646714681, 2077903511), 3, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = bCmEConsumerListArray;
            this.h.invoke(this, LR5581fb24f.gjm(4, "org.dsi.ifc.careco.DSICarEcoListener", -2094882474, -423051988), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeBcmeSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5581fb24f.gjm(5, "org.dsi.ifc.careco.DSICarEcoListener", 2037580866, -1653679357), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = startStopListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(6, "org.dsi.ifc.careco.DSICarEcoListener", 146378568, -1568627599), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseStartStopProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopProhibitList[] startStopProhibitListArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = startStopListUpdateInfo;
            objectArray[1] = startStopProhibitListArray;
            this.h.invoke(this, LR5581fb24f.gjm(7, "org.dsi.ifc.careco.DSICarEcoListener", 1507084261, 2070788862), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopRestartReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = startStopListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(8, "org.dsi.ifc.careco.DSICarEcoListener", 570794639, -1568627599), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseStartStopRestartReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartList[] startStopRestartListArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = startStopListUpdateInfo;
            objectArray[1] = startStopRestartListArray;
            this.h.invoke(this, LR5581fb24f.gjm(9, "org.dsi.ifc.careco.DSICarEcoListener", -472620373, -282023319), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopRestartProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = startStopListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(10, "org.dsi.ifc.careco.DSICarEcoListener", -1592398888, -1568627599), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseStartStopRestartProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartProhibitList[] startStopRestartProhibitListArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = startStopListUpdateInfo;
            objectArray[1] = startStopRestartProhibitListArray;
            this.h.invoke(this, LR5581fb24f.gjm(11, "org.dsi.ifc.careco.DSICarEcoListener", 581983884, -194482013), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(12, "org.dsi.ifc.careco.DSICarEcoListener", 186330602, 1676164096), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopProhibitReasonListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(13, "org.dsi.ifc.careco.DSICarEcoListener", -188833221, 1676164096), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopRestartReasonListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(14, "org.dsi.ifc.careco.DSICarEcoListener", -1698794566, 1676164096), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopRestartProhibitReasonListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(15, "org.dsi.ifc.careco.DSICarEcoListener", -1145568795, 1676164096), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopViewOptions(StartStopViewOptions startStopViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = startStopViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(16, "org.dsi.ifc.careco.DSICarEcoListener", -217184405, 1951127501), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateStartStopCollectedReasons(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(17, "org.dsi.ifc.careco.DSICarEcoListener", 1985521267, 1676164096), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDViewOptions(RangeDataViewOptions rangeDataViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rangeDataViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(18, "org.dsi.ifc.careco.DSICarEcoListener", -212679594, -1855654628), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionMotorway1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(19, "org.dsi.ifc.careco.DSICarEcoListener", -1940673117, 2141253554), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionMotorway2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(20, "org.dsi.ifc.careco.DSICarEcoListener", -1923895901, 2141253554), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionHighway1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(21, "org.dsi.ifc.careco.DSICarEcoListener", 956970963, 2141253554), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionHighway2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(22, "org.dsi.ifc.careco.DSICarEcoListener", 973748179, 2141253554), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionCountryRoad1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(23, "org.dsi.ifc.careco.DSICarEcoListener", -1868213433, 2141253554), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionCountryRoad2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(24, "org.dsi.ifc.careco.DSICarEcoListener", -1851436217, 2141253554), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionDistrictRoad1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(25, "org.dsi.ifc.careco.DSICarEcoListener", -1743478832, 2141253554), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionDistrictRoad2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(26, "org.dsi.ifc.careco.DSICarEcoListener", -1726701616, 2141253554), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionLocalRoad1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(27, "org.dsi.ifc.careco.DSICarEcoListener", -608508154, 2141253554), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionLocalRoad2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(28, "org.dsi.ifc.careco.DSICarEcoListener", -591730938, 2141253554), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionRuralRoad1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(29, "org.dsi.ifc.careco.DSICarEcoListener", -1399034800, 2141253554), 29, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionRuralRoad2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(30, "org.dsi.ifc.careco.DSICarEcoListener", -1382257584, 2141253554), 30, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionUnclassifiedRoad1(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(31, "org.dsi.ifc.careco.DSICarEcoListener", 2051358656, 2141253554), 31, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDConsumptionUnclassifiedRoad2(CarBCConsumption carBCConsumption, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCConsumption;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(32, "org.dsi.ifc.careco.DSICarEcoListener", 2068135872, 2141253554), 32, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDMaxRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCCurrentRange;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(33, "org.dsi.ifc.careco.DSICarEcoListener", 318092607, 1217466906), 33, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDMaxRange2(CarBCCurrentRange carBCCurrentRange, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = carBCCurrentRange;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(34, "org.dsi.ifc.careco.DSICarEcoListener", 334869823, 1217466906), 34, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDResidualEnergy1(RangeDataResidualEnergy rangeDataResidualEnergy, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rangeDataResidualEnergy;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(35, "org.dsi.ifc.careco.DSICarEcoListener", 1592722936, -1114586992), 35, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateRDResidualEnergy2(RangeDataResidualEnergy rangeDataResidualEnergy, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = rangeDataResidualEnergy;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(36, "org.dsi.ifc.careco.DSICarEcoListener", 1609500152, -1114586992), 36, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeRDSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5581fb24f.gjm(37, "org.dsi.ifc.careco.DSICarEcoListener", 540350893, -1653679357), 37, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(38, "org.dsi.ifc.careco.DSICarEcoListener", -1849277258, 765625423), 38, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(39, "org.dsi.ifc.careco.DSICarEcoListener", 871998545, 765625423), 39, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmEEnergyFlowComfort(BCmEEnergyFlowComfort bCmEEnergyFlowComfort, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEEnergyFlowComfort;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(40, "org.dsi.ifc.careco.DSICarEcoListener", -385504130, -1506414482), 40, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmERangeGainTotal(BCmERangeGainTotal bCmERangeGainTotal, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmERangeGainTotal;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(41, "org.dsi.ifc.careco.DSICarEcoListener", 524009561, 540057178), 41, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = bCmEConsumerListConsumptionRA0Array;
            this.h.invoke(this, LR5581fb24f.gjm(42, "org.dsi.ifc.careco.DSICarEcoListener", -1986257756, -2013242426), 42, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = bCmEConsumerListConsumptionRA1Array;
            this.h.invoke(this, LR5581fb24f.gjm(43, "org.dsi.ifc.careco.DSICarEcoListener", -1969480540, 50682822), 43, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR5581fb24f.gjm(44, "org.dsi.ifc.careco.DSICarEcoListener", -1617159004, -397522097), 44, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBCmEConsumerListRangeRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = bCmEConsumerListRangeRA0Array;
            this.h.invoke(this, LR5581fb24f.gjm(45, "org.dsi.ifc.careco.DSICarEcoListener", 666250210, -1298847283), 45, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBCmEConsumerListRangeRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = bCmEConsumerListRangeRA1Array;
            this.h.invoke(this, LR5581fb24f.gjm(46, "org.dsi.ifc.careco.DSICarEcoListener", 683027426, 765077965), 46, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBCmEConsumerListRangeRA2(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = bCmEConsumerListRangeRA2Array;
            this.h.invoke(this, LR5581fb24f.gjm(47, "org.dsi.ifc.careco.DSICarEcoListener", 699804642, -1466029619), 47, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseBCmEConsumerListRangeRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmEListUpdateInfo;
            objectArray[1] = nArray;
            this.h.invoke(this, LR5581fb24f.gjm(48, "org.dsi.ifc.careco.DSICarEcoListener", 1035348962, -397522097), 48, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmECurrentRange(BCmECurrentRange bCmECurrentRange, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = bCmECurrentRange;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(49, "org.dsi.ifc.careco.DSICarEcoListener", -1685565235, 475418797), 49, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmEConsumerListTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(50, "org.dsi.ifc.careco.DSICarEcoListener", -93655922, 1676164096), 50, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmEConsumerListConsumptionTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(51, "org.dsi.ifc.careco.DSICarEcoListener", -888060482, 1676164096), 51, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmEConsumerListRangeTotalNumberOfElements(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(52, "org.dsi.ifc.careco.DSICarEcoListener", -381313833, 1676164096), 52, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmECurrentRangeSOC(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5581fb24f.gjm(53, "org.dsi.ifc.careco.DSICarEcoListener", -163337043, -448335035), 53, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateBCmECatalogueRange(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5581fb24f.gjm(54, "org.dsi.ifc.careco.DSICarEcoListener", 723506817, -448335035), 54, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEAViewOptions(EAViewOptions eAViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = eAViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(55, "org.dsi.ifc.careco.DSICarEcoListener", 1225656355, 115110034), 55, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEASystem(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(56, "org.dsi.ifc.careco.DSICarEcoListener", 702851634, -1665395196), 56, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEAPedalJerk(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(57, "org.dsi.ifc.careco.DSICarEcoListener", 507426087, -1665395196), 57, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeEASetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5581fb24f.gjm(58, "org.dsi.ifc.careco.DSICarEcoListener", -157827859, -1653679357), 58, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEAFreeWheeling(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(59, "org.dsi.ifc.careco.DSICarEcoListener", 1839406608, -1665395196), 59, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateEAStartStop(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(60, "org.dsi.ifc.careco.DSICarEcoListener", 1424521337, -1665395196), 60, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(61, "org.dsi.ifc.careco.DSICarEcoListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suspensionControlViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(62, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 938294211, -603497900), 62, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlLiftMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(63, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -625254655, -1665395196), 63, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlCarJackMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(64, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 343626234, -1665395196), 64, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlTrailerMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(65, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1959709467, -1665395196), 65, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlLoadingMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(66, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -34770688, -1665395196), 66, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlActiveProfile(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(67, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -2119295935, 1676164096), 67, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlAccessibleAirProfiles(SuspensionControlAirProfiles suspensionControlAirProfiles, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suspensionControlAirProfiles;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(68, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 2095291904, -149503222), 68, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlAccessibleDRCProfiles(SuspensionControlDRCProfiles suspensionControlDRCProfiles, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suspensionControlDRCProfiles;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(69, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -948952172, 1118062494), 69, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlVehicleStatus(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(70, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -65479458, 1676164096), 70, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlCurrentLevel(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(71, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1754652911, 1676164096), 71, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlTargetLevel(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(72, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1911157904, 1676164096), 72, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlHeightInfo(SuspensionControlHeightInfo suspensionControlHeightInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suspensionControlHeightInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(73, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1093754812, -628787065), 73, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlOperationMessages(SuspensionControlOperationMessages suspensionControlOperationMessages, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suspensionControlOperationMessages;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(74, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 292970342, 922517002), 74, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlSnowChainMode(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(75, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 2135709936, -1665395196), 75, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlVehicleStateControl(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(76, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -697774766, -1665395196), 76, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlActiveMode(int n, boolean bl, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(bl);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(77, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1779671075, 2077903511), 77, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateeABCEasyEntry(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(78, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1621302251, -1665395196), 78, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateeABCPitchControl(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(79, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1742658541, -1665395196), 79, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateeABCSpecialPosition(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(80, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1852788994, -1665395196), 80, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateeABCPreview(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(81, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1471765719, 1676164096), 81, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateeABCPreviewState(SuspensionControleABCPreview suspensionControleABCPreview, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suspensionControleABCPreview;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(82, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1142789242, 250065082), 82, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSuspensionControlActuatorInfo(SuspensionControlActuatorInfo suspensionControlActuatorInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = suspensionControlActuatorInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(83, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1406626502, 1827478610), 83, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = charismaViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(84, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -247121077, -1965790868), 84, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaActiveProfile(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(85, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1145001786, 1676164096), 85, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaActiveOperationMode(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(86, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -66826664, 1676164096), 86, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaListUpdateInfo(CharismaListUpdateInfo charismaListUpdateInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = charismaListUpdateInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(87, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1488429764, -866704464), 87, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaContent(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(88, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1325168527, 1676164096), 88, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaTrailerDetection(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(89, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1537272388, -1665395196), 89, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaTrailerSetting(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(90, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -280673022, -1665395196), 90, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaProgButton(CharismaProgButton charismaProgButton, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = charismaProgButton;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(91, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -22713757, 590896121), 91, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = charismaSetupTableWithOptionMaskArray;
            this.h.invoke(this, LR5581fb24f.gjm(92, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -280940298, 1157836657), 92, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void responseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = charismaSetupTableWithoutOptionMaskArray;
            this.h.invoke(this, LR5581fb24f.gjm(93, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1805146436, 1298276815), 93, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestCharismaPopup(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(94, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1637080821, 1687814400), 94, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeCharismaPopup(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(95, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1313257114, 1687814400), 95, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeCharismaSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5581fb24f.gjm(96, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -570173403, -1653679357), 96, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCharismaSound(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(97, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 133012279, -1665395196), 97, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADViewOptions(TADViewOptions tADViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tADViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(98, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1063576150, -449776951), 98, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADContent(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(99, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 10085181, 1676164096), 99, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void requestTADPopup(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(100, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 2042983315, 1687814400), 100, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeTADPopup(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(101, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -2041045471, 1687814400), 101, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeTADSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5581fb24f.gjm(102, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 856405139, -1653679357), 102, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeTADMaxMinAngleReset(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5581fb24f.gjm(103, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 439187802, -1653679357), 103, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tADVehicleInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(104, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -2114077951, -1500344287), 104, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADCurrentRollAngle(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(105, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -2145518152, -797832442), 105, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADCurrentPitchAngle(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(106, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -753303385, -797832442), 106, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADPosMaxRollAngle(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(107, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1299498223, -797832442), 107, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADNegMaxRollAngle(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(108, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1989066949, -797832442), 108, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADPosMaxPitchAngle(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(109, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1499684023, -797832442), 109, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateTADNegMaxPitchAngle(float f2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(f2);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(110, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -364476307, -797832442), 110, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSpoilerViewOptions(SpoilerViewOptions spoilerViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = spoilerViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(111, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 900776101, 1514320187), 111, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSpoilerPositionSelection(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(112, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 534061583, 1676164096), 112, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSpoilerState(SpoilerState spoilerState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = spoilerState;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(113, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -850067052, 1920772571), 113, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSpoilerActuation(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(114, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1851063773, -1665395196), 114, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSpoilerMessages(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(115, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1708448228, 1676164096), 115, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSpoilerSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(116, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 489318292, -1665395196), 116, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeSpoilerSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5581fb24f.gjm(117, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1758654749, -1653679357), 117, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSoundViewOptions(SoundViewOptions soundViewOptions, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = soundViewOptions;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(118, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 139315764, -1380947501), 118, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSoundStyle(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5581fb24f.gjm(119, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 2517662, 1676164096), 119, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSoundSystemOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(120, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -255430621, -1665395196), 120, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSoundOnOff(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5581fb24f.gjm(121, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", 1601121950, -1665395196), 121, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void acknowledgeSoundSetFactoryDefault(boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5581fb24f.gjm(122, "org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener", -1151516218, -1653679357), 122, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}

