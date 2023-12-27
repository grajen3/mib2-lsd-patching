/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.model.list;

import de.vw.mib.asl.internal.mirrorlink.model.list.AbstractListHandler;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkSoftKeyListCollector;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import java.util.Collections;

public class SoftKeyList
extends AbstractListHandler {
    private static final int HMI_SOFTKEYS_SIZE;
    private static final MirrorLinkSoftKeyListCollector[] SOFTKEYS;
    private final String _classname;
    private final MirrorLinkTarget target;

    public SoftKeyList(MirrorLinkTarget mirrorLinkTarget) {
        super(3773);
        this._classname = "SoftKeyList";
        this.target = mirrorLinkTarget;
        for (int i2 = 0; i2 < SOFTKEYS.length; ++i2) {
            SoftKeyList.SOFTKEYS[i2] = new MirrorLinkSoftKeyListCollector();
        }
        this.getList().updateList(SOFTKEYS);
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
    }

    @Override
    public void reset() {
        for (int i2 = 0; i2 < SOFTKEYS.length; ++i2) {
            SOFTKEYS[i2].resetType();
        }
    }

    protected void activated(int n) {
    }

    protected void deactivated(int n) {
    }

    public int getDSITypeFromHMIType(int n) {
        int n2 = 0;
        switch (n) {
            case 9: {
                n2 = 131120;
                break;
            }
            case 10: {
                n2 = 16908336;
                break;
            }
            case 11: {
                n2 = 0x2020030;
                break;
            }
            case 12: {
                n2 = 0x3020030;
                break;
            }
            case 13: {
                n2 = 67239984;
                break;
            }
            case 4: {
                n2 = 84017200;
                break;
            }
            case 7: {
                n2 = 100794416;
                break;
            }
            case 1: {
                n2 = 117571632;
                break;
            }
            case 15: {
                n2 = 134348848;
                break;
            }
            case 16: {
                n2 = 151126064;
                break;
            }
            case 5: {
                n2 = 167903280;
                break;
            }
            case 14: {
                n2 = 184680496;
                break;
            }
            case 6: {
                n2 = 201457712;
                break;
            }
            case 2: {
                n2 = 218234928;
                break;
            }
            case 8: {
                n2 = 235012144;
                break;
            }
            case 3: {
                n2 = 251789360;
                break;
            }
            default: {
                LogMessage logMessage = this.getTarget().warn();
                logMessage.append("SoftKeyList").append(".getDSITypeFromHMIType(").append(n).append(") Unknown soft key type").log();
                break;
            }
        }
        return n2;
    }

    public void updateSoftKeys(int[] nArray) {
        Object object;
        this.reset();
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrEmpty(nArray)) {
            object = this.getTarget().warn();
            object.append("SoftKeyList").append(".updateSoftKeys() Invalid soft keys ").log();
        } else {
            block18: for (int i2 = 0; i2 < nArray.length; ++i2) {
                switch (nArray[i2]) {
                    case 0x30000200: {
                        arrayList.add(new Integer(9));
                        continue block18;
                    }
                    case 805306881: {
                        arrayList.add(new Integer(10));
                        continue block18;
                    }
                    case 0x30000202: {
                        arrayList.add(new Integer(11));
                        continue block18;
                    }
                    case 0x30000203: {
                        arrayList.add(new Integer(12));
                        continue block18;
                    }
                    case 805306884: {
                        arrayList.add(new Integer(13));
                        continue block18;
                    }
                    case 805306885: {
                        arrayList.add(new Integer(4));
                        continue block18;
                    }
                    case 805306886: {
                        arrayList.add(new Integer(7));
                        continue block18;
                    }
                    case 805306887: {
                        arrayList.add(new Integer(1));
                        continue block18;
                    }
                    case 805306888: {
                        arrayList.add(new Integer(15));
                        continue block18;
                    }
                    case 805306889: {
                        arrayList.add(new Integer(16));
                        continue block18;
                    }
                    case 805306890: {
                        arrayList.add(new Integer(5));
                        continue block18;
                    }
                    case 805306891: {
                        arrayList.add(new Integer(14));
                        continue block18;
                    }
                    case 805306892: {
                        arrayList.add(new Integer(6));
                        continue block18;
                    }
                    case 805306893: {
                        arrayList.add(new Integer(2));
                        continue block18;
                    }
                    case 805306894: {
                        arrayList.add(new Integer(8));
                        continue block18;
                    }
                    case 805306895: {
                        arrayList.add(new Integer(3));
                        continue block18;
                    }
                    default: {
                        LogMessage logMessage = this.getTarget().warn();
                        logMessage.append("SoftKeyList").append(".updateSoftKeys() Unknown soft key type [").append(nArray[i2]).append("].").log();
                        continue block18;
                    }
                }
            }
        }
        Collections.sort(arrayList);
        object = arrayList.iterator();
        for (int i3 = 0; i3 < arrayList.size() && i3 < 3; ++i3) {
            Integer n = (Integer)object.next();
            if (n == null) continue;
            SOFTKEYS[i3].setType(n);
        }
        this.getList().updateList(SOFTKEYS);
    }

    static {
        SOFTKEYS = new MirrorLinkSoftKeyListCollector[3];
    }
}

