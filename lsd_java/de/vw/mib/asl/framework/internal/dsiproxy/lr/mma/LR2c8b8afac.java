/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.organizer.DSIAdbSdsListener;
import org.dsi.ifc.organizer.DSIAdbSetupListener;

public final class LR2c8b8afac
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2139699678: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1668312148: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1514300148: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1171993035: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -589424064: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -434000496: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -389352363: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 458784602: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 470059868: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 696433059: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 735721120: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1178742780: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 2004534175: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -517921550: {
                if (bl) {
                    if (n2 != 513082112) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1289281970: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
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
            case -462331108: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 335670625: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAdbSetupListener)object).resetToFactorySettingsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIAdbSetupListener)object).setLanguageResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIAdbSetupListener)object).updateAdbState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIAdbSetupListener)object).updateSortOrder(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIAdbSetupListener)object).updatePictureVisibility((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIAdbSetupListener)object).setSortOrderResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIAdbSetupListener)object).setPublicProfileVisibilityResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSIAdbSetupListener)object).resetTopDestinationResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 8: {
                ((DSIAdbSetupListener)object).createBackupFileResult(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIAdbSetupListener)object).importBackupFileResult(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIAdbSetupListener)object).setPictureVisibilityResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIAdbSetupListener)object).setContextSpecificVisibilityResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIAdbSetupListener)object).updateContextSpecificVisibility((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIAdbSetupListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIAdbSdsListener)object).getAllVoiceTagsResult(((Number)objectArray[0]).intValue(), (int[])objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIAdbSdsListener)object).deleteVoiceTagsResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIAdbSdsListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

