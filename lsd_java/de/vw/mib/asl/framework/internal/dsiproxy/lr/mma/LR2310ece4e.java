/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.online.DSIDestinationImportListener;
import org.dsi.ifc.online.DSIOnlineDictationListener;
import org.dsi.ifc.online.DictationValueSentence;
import org.dsi.ifc.online.PortalADBEntry;

public final class LR2310ece4e
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1172648847: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -275502974: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1917146597: {
                if (bl) {
                    if (n2 != -16222285) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
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
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1248354934: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -366303172: {
                if (bl) {
                    if (n2 != 655477574) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1207443964: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
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
            case -556630032: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1894571927: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIOnlineDictationListener)object).dictationResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIOnlineDictationListener)object).finishDictationResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIOnlineDictationListener)object).dictationValueList((DictationValueSentence)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIOnlineDictationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIDestinationImportListener)object).downloadAddressListResult((PortalADBEntry[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIDestinationImportListener)object).stopActionResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIDestinationImportListener)object).updateEntries(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIDestinationImportListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

