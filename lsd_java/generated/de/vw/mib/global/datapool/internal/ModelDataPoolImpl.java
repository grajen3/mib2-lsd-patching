/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.datapool.internal;

import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.collections.ints.IntFloatMap;
import de.vw.mib.collections.ints.IntFloatOptHashMap;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.datapool.internal.AbstractDatapool;
import de.vw.mib.error.HMIException;
import de.vw.mib.event.consumer.DatapoolEventConsumer;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.SpellerData;
import java.io.File;
import java.io.IOException;

public class ModelDataPoolImpl
extends AbstractDatapool
implements DatapoolEventConsumer {
    public static final int CHECKSUM;
    private Object[] poolData = null;

    private Object[] getPoolData() {
        if (this.poolData == null) {
            Logger logger = ServiceManagerCommon.loggerFactory.getLogger(8);
            try {
                File file = ResData.getResFile(ServiceManagerCommon.configurationManager, "modeldatapool.res");
                if (ServiceManagerCommon.perfService != null) {
                    ServiceManagerCommon.perfService.performanceLogStartup(2, 2, 1);
                }
                this.poolData = ResData.loadAndCheck(ServiceManagerCommon.fileManager, file, MagicNumber.MODELDATAPOOL_RES, 29644001, 0, logger, 1);
                if (ServiceManagerCommon.perfService != null) {
                    ServiceManagerCommon.perfService.performanceLogStartup(2, 2, 2);
                }
            }
            catch (IOException iOException) {
                HMIException hMIException = new HMIException(iOException.getMessage(), iOException.getCause());
                hMIException.setStackTrace(iOException.getStackTrace());
                throw hMIException;
            }
        }
        return this.poolData;
    }

    @Override
    protected IntObjectMap loadObjectValues() {
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(7, 1, 1);
        }
        IntObjectMap intObjectMap = ModelDataPoolImpl.createObjects(this.getPoolData(), 1);
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(7, 1, 2);
        }
        return intObjectMap;
    }

    @Override
    protected IntBooleanMap loadBooleanValues() {
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(8, 1, 1);
        }
        IntBooleanMap intBooleanMap = this.createBoolean(this.getPoolData(), 6);
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(8, 1, 2);
        }
        return intBooleanMap;
    }

    @Override
    protected IntFloatMap loadFloatValues() {
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(9, 1, 1);
        }
        IntFloatMap intFloatMap = this.createFloat(this.getPoolData(), 11);
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(9, 1, 2);
        }
        return intFloatMap;
    }

    @Override
    protected IntIntMap loadIntValues() {
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(10, 1, 1);
        }
        IntIntMap intIntMap = this.createInt(this.getPoolData(), 16);
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(10, 1, 2);
        }
        return intIntMap;
    }

    @Override
    protected IntLongMap loadLongValues() {
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(11, 1, 1);
        }
        IntLongMap intLongMap = this.createLong(this.getPoolData(), 21);
        if (ServiceManagerCommon.perfService != null) {
            ServiceManagerCommon.perfService.performanceLogStartup(11, 1, 2);
        }
        return intLongMap;
    }

    public static IntObjectMap createObjects(Object[] objectArray, int n) {
        objectArray[n + 1] = ModelDataPoolImpl.convertStringArrayToObjectArray((String[])objectArray[n + 1]);
        objectArray[n + 4] = ModelDataPoolImpl.convertStringArrayToObjectArray((String[])objectArray[n + 4]);
        IntObjectOptHashMap intObjectOptHashMap = IntObjectOptHashMap.createFromInternalData(objectArray, n);
        intObjectOptHashMap.put(21208, new boolean[]{false, false});
        intObjectOptHashMap.put(14901, new boolean[]{false, false});
        intObjectOptHashMap.put(972816384, new int[]{10, 10, 10, 10, 10});
        intObjectOptHashMap.put(12690, new int[]{-1, -1, -1, -1, -1});
        intObjectOptHashMap.put(-876675072, new int[]{10, 10, 10, 10, 10});
        intObjectOptHashMap.put(-1477181440, new int[]{-1, -1, -1, -1, -1});
        intObjectOptHashMap.put(-914161664, new int[]{10, 10, 10, 10, 10});
        intObjectOptHashMap.put(16807, new int[]{-1, -1, -1, -1, -1});
        intObjectOptHashMap.put(16886, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        intObjectOptHashMap.put(31051, new SpellerData());
        intObjectOptHashMap.put(1250951168, new SpellerData());
        intObjectOptHashMap.put(30570, new boolean[]{false, false, false, false});
        intObjectOptHashMap.put(14686, new boolean[]{false, false, false});
        intObjectOptHashMap.put(-2052849664, new boolean[]{false, false, false, false, false});
        intObjectOptHashMap.put(-1601896448, new boolean[]{false, false, false, false});
        intObjectOptHashMap.put(-1649213440, new int[]{-1, -1, -1, -1});
        intObjectOptHashMap.put(28030, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        intObjectOptHashMap.put(-1481637888, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        intObjectOptHashMap.put(1560281344, new SpellerData());
        intObjectOptHashMap.put(-473825280, new SpellerData());
        intObjectOptHashMap.put(1176895744, new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false});
        intObjectOptHashMap.put(-1442381568, new int[]{0});
        intObjectOptHashMap.put(1135280128, new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1});
        intObjectOptHashMap.put(2045444096, new boolean[]{false, false, false, false, false, false, false});
        intObjectOptHashMap.put(24374, new boolean[]{false, false, false});
        intObjectOptHashMap.put(23191, new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1});
        intObjectOptHashMap.put(1845756160, new int[]{0, 0});
        intObjectOptHashMap.put(11282, new int[]{0, 0, 14, 14, 14, 14, 0, 0, 0, 0, 14, 14, 14, 14, 0, 0});
        intObjectOptHashMap.put(-1027997696, new SpellerData());
        intObjectOptHashMap.put(14618, new boolean[]{false, false, false});
        intObjectOptHashMap.put(-1646460928, new int[0]);
        intObjectOptHashMap.put(14599, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        intObjectOptHashMap.put(2031616256, new boolean[]{true, false});
        intObjectOptHashMap.put(10597, new boolean[]{false, false});
        intObjectOptHashMap.put(94175232, new boolean[]{false, false});
        intObjectOptHashMap.put(23383, new boolean[]{false, false});
        intObjectOptHashMap.put(1089601536, new boolean[]{false, false});
        intObjectOptHashMap.put(13625, new boolean[]{false, false});
        intObjectOptHashMap.put(17034, new boolean[]{false, false});
        intObjectOptHashMap.put(13669, new int[]{0, 3, 9, 259, 265, 517, 521, 3, 5, 261, 515, 1});
        intObjectOptHashMap.put(-1880686592, new boolean[]{true, true});
        intObjectOptHashMap.put(-1044905984, new boolean[]{true, true});
        intObjectOptHashMap.put(1256128512, new boolean[]{true, true});
        intObjectOptHashMap.put(10390, new boolean[]{true, true, true, false, true});
        intObjectOptHashMap.put(14573, new SpellerData());
        intObjectOptHashMap.put(1235288064, new SpellerData());
        intObjectOptHashMap.put(-350748416, new SpellerData());
        intObjectOptHashMap.put(32458, new SpellerData());
        intObjectOptHashMap.put(-2112880384, new SpellerData());
        intObjectOptHashMap.put(0xAA80000, new SpellerData());
        intObjectOptHashMap.put(-134020864, new SpellerData());
        intObjectOptHashMap.put(0x4110100, new SpellerData());
        intObjectOptHashMap.put(-1243348992, new SpellerData());
        intObjectOptHashMap.put(10869, new SpellerData());
        intObjectOptHashMap.put(-510984192, new SpellerData());
        intObjectOptHashMap.put(-202375168, new SpellerData());
        intObjectOptHashMap.put(-653721344, new SpellerData());
        intObjectOptHashMap.put(11558, new SpellerData());
        intObjectOptHashMap.put(672268544, new SpellerData());
        intObjectOptHashMap.put(1535639552, new SpellerData());
        intObjectOptHashMap.put(27177, new SpellerData());
        intObjectOptHashMap.put(-371458048, new SpellerData());
        intObjectOptHashMap.put(886898688, new boolean[]{true, true, true, true, true, true, true, true});
        intObjectOptHashMap.put(0x6EEE0000, new SpellerData());
        intObjectOptHashMap.put(-773324800, new SpellerData());
        intObjectOptHashMap.put(-1206583040, new SpellerData());
        intObjectOptHashMap.put(19324, new SpellerData());
        intObjectOptHashMap.put(-1944256256, new SpellerData());
        intObjectOptHashMap.put(10909, new SpellerData());
        intObjectOptHashMap.put(1250623488, new SpellerData());
        intObjectOptHashMap.put(16263, new SpellerData());
        intObjectOptHashMap.put(483065856, new SpellerData());
        intObjectOptHashMap.put(1005322240, new SpellerData());
        intObjectOptHashMap.put(12518, new SpellerData());
        intObjectOptHashMap.put(14878, new SpellerData());
        intObjectOptHashMap.put(952827904, new SpellerData());
        intObjectOptHashMap.put(768540672, new SpellerData());
        intObjectOptHashMap.put(1092681984, new boolean[]{false, false});
        intObjectOptHashMap.put(1373831168, new String[]{"de_DE", "en_GB", "es_ES", "ru_RU", ""});
        intObjectOptHashMap.put(-1743322880, new boolean[]{true, true, true, true, true, true, true, true, true, false, true, true, false, false, false});
        intObjectOptHashMap.put(-435027712, new boolean[]{false, false, false, false, false, false, false});
        intObjectOptHashMap.put(1523974144, new SpellerData());
        intObjectOptHashMap.put(29124, new boolean[0]);
        intObjectOptHashMap.put(-33095424, new String[0]);
        return intObjectOptHashMap;
    }

    private IntBooleanMap createBoolean(Object[] objectArray, int n) {
        objectArray[n + 1] = this.convertByteArrayToBooleanArray((byte[])objectArray[n + 1]);
        objectArray[n + 4] = this.convertByteArrayToBooleanArray((byte[])objectArray[n + 4]);
        IntBooleanOptHashMap intBooleanOptHashMap = IntBooleanOptHashMap.createFromInternalData(objectArray, n);
        return intBooleanOptHashMap;
    }

    private IntFloatMap createFloat(Object[] objectArray, int n) {
        IntFloatOptHashMap intFloatOptHashMap = IntFloatOptHashMap.createFromInternalData(objectArray, n);
        return intFloatOptHashMap;
    }

    private IntIntMap createInt(Object[] objectArray, int n) {
        IntIntOptHashMap intIntOptHashMap = IntIntOptHashMap.createFromInternalData(objectArray, n);
        return intIntOptHashMap;
    }

    private IntLongMap createLong(Object[] objectArray, int n) {
        IntLongOptHashMap intLongOptHashMap = IntLongOptHashMap.createFromInternalData(objectArray, n);
        return intLongOptHashMap;
    }

    private boolean[] convertByteArrayToBooleanArray(byte[] byArray) {
        boolean bl = true;
        boolean[] blArray = new boolean[byArray.length];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            blArray[i2] = byArray[i2] == 1;
        }
        return blArray;
    }

    private static Object[] convertStringArrayToObjectArray(String[] stringArray) {
        String[] stringArray2 = stringArray;
        Object[] objectArray = new Object[stringArray2.length];
        System.arraycopy((Object)stringArray2, 0, (Object)objectArray, 0, stringArray2.length);
        return objectArray;
    }
}

