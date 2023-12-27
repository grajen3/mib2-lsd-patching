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
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.DSISDARSSeekListener;
import org.dsi.ifc.sdars.DSISDARSTunerListener;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public final class LR59e3afd9b
extends AbstractProxy
implements DSISDARSTunerListener,
DSISDARSSeekListener {
    private static final Method[] JMS = new Method[45];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR59e3afd9b(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void profileReset(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR59e3afd9b.gjm(0, "org.dsi.ifc.sdars.DSISDARSTunerListener", -1689832120, 1676164096), -1, objectArray);
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
    public void profileResetAll(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(1, "org.dsi.ifc.sdars.DSISDARSTunerListener", 283450095, 1687814400), -1, objectArray);
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
    public void updateProfileState(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR59e3afd9b.gjm(2, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1184260366, 1043255048), -1, objectArray);
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
    public void profileChanged(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR59e3afd9b.gjm(3, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1089708026, 1676164096), -1, objectArray);
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
    public void profileCopied(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR59e3afd9b.gjm(4, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1112303269, 1043255048), -1, objectArray);
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
    public void updateDetectedDevice(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR59e3afd9b.gjm(5, "org.dsi.ifc.sdars.DSISDARSTunerListener", 371972340, 1676164096), 5, objectArray);
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
    public void updateAvailability(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR59e3afd9b.gjm(6, "org.dsi.ifc.sdars.DSISDARSTunerListener", 968828733, 1676164096), 6, objectArray);
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
    public void updateStationList(StationInfo[] stationInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stationInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(7, "org.dsi.ifc.sdars.DSISDARSTunerListener", -558557946, 21361827), 7, objectArray);
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
    public void selectStationStatus(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(8, "org.dsi.ifc.sdars.DSISDARSTunerListener", 536699942, 1687814400), 8, objectArray);
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
    public void updateSelectedStation(StationInfo stationInfo, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stationInfo;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(9, "org.dsi.ifc.sdars.DSISDARSTunerListener", -2058820697, -1821948036), 9, objectArray);
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
    public void updateElectronicSerialCode(String string, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(10, "org.dsi.ifc.sdars.DSISDARSTunerListener", 2079996622, -645498553), 10, objectArray);
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
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = serviceStatus3;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(11, "org.dsi.ifc.sdars.DSISDARSTunerListener", -1435683148, 1126364086), 11, objectArray);
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
    public void updateSignalQuality(SignalQuality signalQuality, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = signalQuality;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(12, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1675959988, -2003753845), 12, objectArray);
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
    public void updateCategoryList(CategoryInfo[] categoryInfoArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = categoryInfoArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(13, "org.dsi.ifc.sdars.DSISDARSTunerListener", -1696826401, -810426608), 13, objectArray);
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
    public void informationRadioText(RadioText radioText) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = radioText;
            this.h.invoke(this, LR59e3afd9b.gjm(14, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1897290486, -1703653079), 14, objectArray);
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
    public void informationRadioText2(RadioText[] radioTextArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = radioTextArray;
            this.h.invoke(this, LR59e3afd9b.gjm(15, "org.dsi.ifc.sdars.DSISDARSTunerListener", 728688852, -55773823), 15, objectArray);
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
    public void updateStaticTaggingInfo(String string, String string2, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = string;
            objectArray[1] = string2;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(16, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1627402771, -1028403557), 16, objectArray);
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
    public void responseTime(DateTime dateTime) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dateTime;
            this.h.invoke(this, LR59e3afd9b.gjm(17, "org.dsi.ifc.sdars.DSISDARSTunerListener", 601213013, -710074599), 17, objectArray);
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
    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = ePGShortInfo;
            this.h.invoke(this, LR59e3afd9b.gjm(18, "org.dsi.ifc.sdars.DSISDARSTunerListener", -1777950330, -2042065314), 18, objectArray);
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
    public void responseEPGDescription(EPGDescription ePGDescription) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = ePGDescription;
            this.h.invoke(this, LR59e3afd9b.gjm(19, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1450841885, 2021106533), 19, objectArray);
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
    public void updateStationDescription(StationDescription[] stationDescriptionArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stationDescriptionArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(20, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1188682463, -211758354), 20, objectArray);
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
    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = subscriptionStatus;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(21, "org.dsi.ifc.sdars.DSISDARSTunerListener", -1916624108, 647673748), 21, objectArray);
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
    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = ePGShortInfoArray;
            this.h.invoke(this, LR59e3afd9b.gjm(22, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1179178783, 1313422749), 22, objectArray);
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
    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = imageInformationArray;
            this.h.invoke(this, LR59e3afd9b.gjm(23, "org.dsi.ifc.sdars.DSISDARSTunerListener", 563057250, 1800982930), 23, objectArray);
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
    public void informationBackgroundArt(ImageInformation[] imageInformationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = imageInformationArray;
            this.h.invoke(this, LR59e3afd9b.gjm(24, "org.dsi.ifc.sdars.DSISDARSTunerListener", -17142188, 1800982930), 24, objectArray);
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
    public void informationAlbumArt(ImageInformation[] imageInformationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = imageInformationArray;
            this.h.invoke(this, LR59e3afd9b.gjm(25, "org.dsi.ifc.sdars.DSISDARSTunerListener", 891879649, 1800982930), 25, objectArray);
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
    public void informationGenreArt(ImageInformation[] imageInformationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = imageInformationArray;
            this.h.invoke(this, LR59e3afd9b.gjm(26, "org.dsi.ifc.sdars.DSISDARSTunerListener", -1579857934, 1800982930), 26, objectArray);
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
    public void informationStudioArt(ImageInformation[] imageInformationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = imageInformationArray;
            this.h.invoke(this, LR59e3afd9b.gjm(27, "org.dsi.ifc.sdars.DSISDARSTunerListener", 1455410618, 1800982930), 27, objectArray);
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
            this.h.invoke(this, LR59e3afd9b.gjm(28, "org.dsi.ifc.sdars.DSISDARSTunerListener", -1459926625, 1276482132), -1, objectArray);
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
    public void updateSeekPossibility(SeekPossibility seekPossibility, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seekPossibility;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(34, "org.dsi.ifc.sdars.DSISDARSSeekListener", -2027258339, 753230955), 34, objectArray);
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
    public void updateSeekList(SeekEntry[] seekEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seekEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(35, "org.dsi.ifc.sdars.DSISDARSSeekListener", -1799537809, 694158163), 35, objectArray);
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
    public void updateLeagueList(LeagueEntry[] leagueEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = leagueEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(36, "org.dsi.ifc.sdars.DSISDARSSeekListener", -1959278925, -1609965898), 36, objectArray);
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
    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = trafficWxEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(37, "org.dsi.ifc.sdars.DSISDARSSeekListener", -1823530506, 1201785706), 37, objectArray);
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
    public void updateSeekAlert(SeekAlert seekAlert, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = seekAlert;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(38, "org.dsi.ifc.sdars.DSISDARSSeekListener", 1892786551, -1786763117), 38, objectArray);
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
    public void setSeekCommandResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(39, "org.dsi.ifc.sdars.DSISDARSSeekListener", -471256708, 1687814400), 39, objectArray);
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
    public void manageSeekResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(40, "org.dsi.ifc.sdars.DSISDARSSeekListener", 1871345847, 1687814400), 40, objectArray);
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
    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = teamEntryArray;
            this.h.invoke(this, LR59e3afd9b.gjm(41, "org.dsi.ifc.sdars.DSISDARSSeekListener", 833209806, 1330010385), 41, objectArray);
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
    public void leagues(LeagueEntry[] leagueEntryArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = leagueEntryArray;
            this.h.invoke(this, LR59e3afd9b.gjm(42, "org.dsi.ifc.sdars.DSISDARSSeekListener", -1711931133, -1581538634), 42, objectArray);
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
    public void updateRegisteredTeams(TeamEntry[] teamEntryArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = teamEntryArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR59e3afd9b.gjm(43, "org.dsi.ifc.sdars.DSISDARSSeekListener", -1066205348, 1318360081), 43, objectArray);
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

