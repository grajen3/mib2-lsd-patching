/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc.reflection.generated.mma;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.framework.internal.impl.lsc.DiagLanguageUpdateListener;
import de.vw.mib.asl.framework.internal.impl.lsc.LanguageDiagnosisHandler;
import de.vw.mib.asl.framework.internal.impl.lsc.SpellerLanguageManager;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBordComputerLAC;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;
import de.vw.mib.asl.framework.internal.lsc.api.impl.ASLLscAPIImpl;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.LscController;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public final class LR2dcf060a7
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -959486549: {
                if (bl) {
                    if (n2 != 1889122243) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1389455617: {
                if (bl) {
                    if (n2 != -1514740036) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1380630869: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1899143779: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1588365928: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1273407153: {
                if (bl) {
                    if (n2 != 1965062780) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1113508141: {
                if (bl) {
                    if (n2 != 644240553) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -414772874: {
                if (bl) {
                    if (n2 != 598225155) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -357524422: {
                if (bl) {
                    if (n2 != -666616025) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 122260526: {
                if (bl) {
                    if (n2 != 1237872475) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 263987676: {
                if (bl) {
                    if (n2 != -321432353) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 573948860: {
                if (bl) {
                    if (n2 != 173128360) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 725890952: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1575493758: {
                if (bl) {
                    if (n2 != 815568778) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1710331071: {
                if (bl) {
                    if (n2 != -321432353) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1868268156: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
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
            case -1207476508: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -536575184: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 1270774625: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((LanguageDiagnosisHandler)object).setListener((DiagLanguageUpdateListener)objectArray[0]);
                return null;
            }
            case 1: {
                ((AslTargetLscTNGBordComputerLAC)object).dsiCarTimeUnitsLanguageUpdateUnitmasterViewOptions((UnitmasterViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((AslTargetLscTNGBordComputerLAC)object).dsiCarTimeUnitsLanguageUpdateMenuLanguage(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((AslTargetLscTNGBullhorn)object).helperMethodFillLanguagesForLACsAndGuiIntoList((IntObjectMap)objectArray[0]);
                return null;
            }
            case 4: {
                ((AslTargetLscTNGBullhorn)object).onNewLanguage((LanguageChanger)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
                return null;
            }
            case 5: {
                ((AslTargetLscTNGBullhorn)object).onNewSkin((SkinChanger)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 6: {
                ((AslTargetLscTNGBullhorn)object).onNewSkinmode((SkinmodeChanger)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 7: {
                ((AslTargetLscTNGBullhorn)object).startOfLsc();
                return null;
            }
            case 8: {
                ((AslTargetLscTNGBullhorn)object).endOfLsc((IntObjectMap)objectArray[0]);
                return null;
            }
            case 9: {
                ((AslTargetLscTNGBullhorn)object).guiAvailableForViews();
                return null;
            }
            case 10: {
                ((AslTargetLscTNGBullhorn)object).speechAvailable();
                return null;
            }
            case 11: {
                ((AslTargetLscTNGBullhorn)object).injectDelegatingLscController((LscController)objectArray[0]);
                return null;
            }
            case 12: {
                ((AslTargetLscTNGBullhorn)object).injectSystemApi((ASLSystemAPI)objectArray[0]);
                return null;
            }
            case 13: {
                ((AslTargetLscTNGBullhorn)object).injectAslLscApi((ASLLscAPIImpl)objectArray[0]);
                return null;
            }
            case 14: {
                ((AslTargetLscTNGBullhorn)object).injectSpellerManager((SpellerLanguageManager)objectArray[0]);
                return null;
            }
            case 15: {
                ((AslTargetLscTNGBullhorn)object).changeLanguage((String)objectArray[0]);
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

