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
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;
import org.dsi.ifc.exboxm.AudioRequest;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.DSIExBoxMListener;
import org.dsi.ifc.exboxm.ExBoxState;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;

public final class LR5c9eaf247
extends AbstractProxy
implements DSIDisplayManagementListener,
DSIExBoxMListener {
    private static final Method[] JMS = new Method[39];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5c9eaf247(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void getBrightness(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(0, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1125719532, 1676164096), 0, objectArray);
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
    public void getDisplayBrightness(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(1, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 1914707728, 1676164096), 1, objectArray);
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
    public void getExtents(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5c9eaf247.gjm(2, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -932906257, 1043255048), 2, objectArray);
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
    public void getDisplayPower(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(3, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 1312711872, 1676164096), 3, objectArray);
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
    public void getContrast(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(4, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -313389222, 1676164096), 4, objectArray);
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
    public void getColor(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(5, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 584598644, 1676164096), 5, objectArray);
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
    public void getTint(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(6, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -423787013, 1676164096), 6, objectArray);
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
    public void getDisplayableInfo(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5c9eaf247.gjm(7, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 691846643, 1043255048), 7, objectArray);
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
    public void activeContext(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5c9eaf247.gjm(8, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 1048472306, 1043255048), 8, objectArray);
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
    public void fadeStarted(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(9, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -637490757, 1676164096), 9, objectArray);
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
    public void fadeComplete(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(10, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 1244806983, 1676164096), 10, objectArray);
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
    public void lockDisplayResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9eaf247.gjm(11, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1994476354, 1687814400), 11, objectArray);
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
    public void unlockDisplayResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9eaf247.gjm(12, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 284508468, 1687814400), 12, objectArray);
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
    public void setCroppingResult(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {
        try {
            Object[] objectArray = this.p.borrowArray(11);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            objectArray[5] = RuntimeUtil.valueOf(n6);
            objectArray[6] = RuntimeUtil.valueOf(n7);
            objectArray[7] = RuntimeUtil.valueOf(n8);
            objectArray[8] = RuntimeUtil.valueOf(n9);
            objectArray[9] = RuntimeUtil.valueOf(n10);
            objectArray[10] = RuntimeUtil.valueOf(n11);
            this.h.invoke(this, LR5c9eaf247.gjm(13, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 919996909, 110401622), 13, objectArray);
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
    public void takeScreenshotOnExternalStorageResult(int n, int n2, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = string;
            this.h.invoke(this, LR5c9eaf247.gjm(14, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 910868492, 1150548731), 14, objectArray);
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
    public void setDisplayTypeResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(15, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1938768275, 1676164096), 15, objectArray);
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
    public void getDisplayTypeResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(16, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 409217170, 1676164096), 16, objectArray);
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
    public void setUpdateRateResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(17, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1119517576, 1676164096), 17, objectArray);
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
    public void getUpdateRateResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(18, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1313830956, 1676164096), 18, objectArray);
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
    public void startComponentResult(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5c9eaf247.gjm(19, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 767918957, -448335035), 19, objectArray);
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
    public void stopComponentResult(int n, int n2, int n3, int n4) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            this.h.invoke(this, LR5c9eaf247.gjm(20, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1915898704, -448335035), 20, objectArray);
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
    public void setAnnotationDataResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(21, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", 1361348118, 1676164096), 21, objectArray);
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
    public void initAnnotationsResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(22, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -902117606, 1676164096), 22, objectArray);
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
    public void destroyImageDisplayableResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(23, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1312515431, 1676164096), 23, objectArray);
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
    public void requestUpdateImageDisplayableResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(24, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -277210366, 1676164096), 24, objectArray);
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
    public void createImageDisplayableResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(25, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1285563890, 1676164096), 25, objectArray);
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
            this.h.invoke(this, LR5c9eaf247.gjm(26, "org.dsi.ifc.displaymanagement.DSIDisplayManagementListener", -1459926625, 1276482132), -1, objectArray);
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
    public void responseDisplayControl(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(27, "org.dsi.ifc.exboxm.DSIExBoxMListener", 1371751666, 1676164096), 27, objectArray);
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
    public void updateAudioRequest(AudioRequest audioRequest, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = audioRequest;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9eaf247.gjm(28, "org.dsi.ifc.exboxm.DSIExBoxMListener", -1212426072, 1084047755), 28, objectArray);
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
    public void updateDisplayRequest(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(29, "org.dsi.ifc.exboxm.DSIExBoxMListener", 199747136, 1676164096), 29, objectArray);
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
    public void updateOperationState(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(30, "org.dsi.ifc.exboxm.DSIExBoxMListener", 0x8BBB848, 1676164096), 30, objectArray);
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
    public void responseVolumeRange(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9eaf247.gjm(31, "org.dsi.ifc.exboxm.DSIExBoxMListener", -1210747537, 1687814400), 31, objectArray);
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
    public void responseResetToFactory(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9eaf247.gjm(32, "org.dsi.ifc.exboxm.DSIExBoxMListener", -1762476098, 1687814400), 32, objectArray);
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
    public void responseConnectionControl(ConnectionControl connectionControl) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = connectionControl;
            this.h.invoke(this, LR5c9eaf247.gjm(33, "org.dsi.ifc.exboxm.DSIExBoxMListener", -742348735, 22060865), 33, objectArray);
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
    public void updateActiveSourceType(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5c9eaf247.gjm(34, "org.dsi.ifc.exboxm.DSIExBoxMListener", -109133828, 1676164096), 34, objectArray);
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
    public void updateCurrentStationInfo(String string, int n, String string2, int n2, int n3, String string3, int n4, String string4, int n5, int n6) {
        try {
            Object[] objectArray = this.p.borrowArray(10);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = string2;
            objectArray[3] = RuntimeUtil.valueOf(n2);
            objectArray[4] = RuntimeUtil.valueOf(n3);
            objectArray[5] = string3;
            objectArray[6] = RuntimeUtil.valueOf(n4);
            objectArray[7] = string4;
            objectArray[8] = RuntimeUtil.valueOf(n5);
            objectArray[9] = RuntimeUtil.valueOf(n6);
            this.h.invoke(this, LR5c9eaf247.gjm(35, "org.dsi.ifc.exboxm.DSIExBoxMListener", -406102889, 860502040), 35, objectArray);
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
    public void updateMobileDeviceLinkStatus(MobileDeviceLinkStatus mobileDeviceLinkStatus, ExBoxState exBoxState, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = mobileDeviceLinkStatus;
            objectArray[1] = exBoxState;
            objectArray[2] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9eaf247.gjm(36, "org.dsi.ifc.exboxm.DSIExBoxMListener", -501568053, -150167592), 36, objectArray);
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
    public void updatePublicDeviceAddress(PublicDeviceAddress publicDeviceAddress, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = publicDeviceAddress;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5c9eaf247.gjm(37, "org.dsi.ifc.exboxm.DSIExBoxMListener", -1044660039, -163162681), 37, objectArray);
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

