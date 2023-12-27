/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;
import org.dsi.ifc.exboxm.AudioRequest;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.DSIExBoxMListener;
import org.dsi.ifc.exboxm.ExBoxState;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;

public final class LR2c9eaf247
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1842846696: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1717910351: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1330328179: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1146552102: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1095491959: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1067172274: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -729304911: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -318122442: {
                if (bl) {
                    if (n2 != 110401622) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -268802872: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -227901890: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -205702103: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -75121178: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 35355375: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 213928502: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 249192371: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 270475378: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 350414524: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 377889873: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 449264330: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 876737808: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1195323978: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1510953709: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1837352237: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1841197196: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1950668834: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 2021934525: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1755526169: {
                if (bl) {
                    if (n2 != 860502040) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1462191177: {
                if (bl) {
                    if (n2 != 1084047755) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1178551359: {
                if (bl) {
                    if (n2 != -163162681) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1094716778: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -877847838: {
                if (bl) {
                    if (n2 != -150167592) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -230374575: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -54558983: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1088874251: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1101578451: {
                if (bl) {
                    if (n2 != 22060865) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1220066056: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1869993399: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
        }
        return n3;
    }

    @Override
    public int getIndex(String string, String string2, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        int n4 = RuntimeUtil.buildKey(string2);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case -1403286973: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1058125509: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIDisplayManagementListener)object).getBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIDisplayManagementListener)object).getDisplayBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIDisplayManagementListener)object).getExtents(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIDisplayManagementListener)object).getDisplayPower(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIDisplayManagementListener)object).getContrast(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIDisplayManagementListener)object).getColor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIDisplayManagementListener)object).getTint(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIDisplayManagementListener)object).getDisplayableInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIDisplayManagementListener)object).activeContext(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIDisplayManagementListener)object).fadeStarted(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIDisplayManagementListener)object).fadeComplete(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIDisplayManagementListener)object).lockDisplayResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIDisplayManagementListener)object).unlockDisplayResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIDisplayManagementListener)object).setCroppingResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue(), ((Number)objectArray[10]).intValue());
                return null;
            }
            case 14: {
                ((DSIDisplayManagementListener)object).takeScreenshotOnExternalStorageResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 15: {
                ((DSIDisplayManagementListener)object).setDisplayTypeResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIDisplayManagementListener)object).getDisplayTypeResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIDisplayManagementListener)object).setUpdateRateResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIDisplayManagementListener)object).getUpdateRateResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIDisplayManagementListener)object).startComponentResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 20: {
                ((DSIDisplayManagementListener)object).stopComponentResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 21: {
                ((DSIDisplayManagementListener)object).setAnnotationDataResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIDisplayManagementListener)object).initAnnotationsResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIDisplayManagementListener)object).destroyImageDisplayableResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIDisplayManagementListener)object).requestUpdateImageDisplayableResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIDisplayManagementListener)object).createImageDisplayableResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIDisplayManagementListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 27: {
                ((DSIExBoxMListener)object).responseDisplayControl(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIExBoxMListener)object).updateAudioRequest((AudioRequest)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIExBoxMListener)object).updateDisplayRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIExBoxMListener)object).updateOperationState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSIExBoxMListener)object).responseVolumeRange(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIExBoxMListener)object).responseResetToFactory(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((DSIExBoxMListener)object).responseConnectionControl((ConnectionControl)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSIExBoxMListener)object).updateActiveSourceType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSIExBoxMListener)object).updateCurrentStationInfo((String)objectArray[0], ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), (String)objectArray[5], ((Number)objectArray[6]).intValue(), (String)objectArray[7], ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue());
                return null;
            }
            case 36: {
                ((DSIExBoxMListener)object).updateMobileDeviceLinkStatus((MobileDeviceLinkStatus)objectArray[0], (ExBoxState)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 37: {
                ((DSIExBoxMListener)object).updatePublicDeviceAddress((PublicDeviceAddress)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSIExBoxMListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, object, objectArray);
                }
                case 1: {
                    return this.f1(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

