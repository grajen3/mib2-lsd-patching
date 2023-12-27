/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.e_traction;

import de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionFunctionAvailability_ETRAKTransformer;
import de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionFunctionAvailableReason_ETRAKTransformer;
import de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionFunctionExistence_ETRAKTransformer;
import de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionProfileListTransformer;
import de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionTimerListTransformer;
import de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionTimerWeekdaysTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionChargingDistanceCollector;
import generated.de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionChargingDistanceTransformer;

public final class ASLCarE_TractionDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarE_TractionDeviceImpl INSTANCE = new ASLCarE_TractionDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(7);
    private ASLListFactory listFactory;

    private ASLCarE_TractionDeviceImpl() {
    }

    public static ASLCarE_TractionDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.E_Traction";
    }

    @Override
    public int getTargetId() {
        return 11016;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10374, this);
        aSLListRegistry.registerASLDevice(10375, this);
        aSLListRegistry.registerASLDevice(10376, this);
        aSLListRegistry.registerASLDevice(10360, this);
        aSLListRegistry.registerASLDevice(10787, this);
        aSLListRegistry.registerASLDevice(10788, this);
        aSLListRegistry.registerASLDevice(10789, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1911816128, 11016);
        serviceRegister.registerService(-1895038912, 11016);
        serviceRegister.registerService(-1861484480, 11016);
        serviceRegister.registerService(-1844707264, 11016);
        serviceRegister.registerService(-1811152832, 11016);
        serviceRegister.registerService(-1794375616, 11016);
        serviceRegister.registerService(-1777598400, 11016);
        serviceRegister.registerService(-1760821184, 11016);
        serviceRegister.registerService(-1744043968, 11016);
        serviceRegister.registerService(-1727266752, 11016);
        serviceRegister.registerService(-1710489536, 11016);
        serviceRegister.registerService(-1693712320, 11016);
        serviceRegister.registerService(-1676935104, 11016);
        serviceRegister.registerService(-1660157888, 11016);
        serviceRegister.registerService(-1643380672, 11016);
        serviceRegister.registerService(-1626603456, 11016);
        serviceRegister.registerService(-1593049024, 11016);
        serviceRegister.registerService(-1576271808, 11016);
        serviceRegister.registerService(655163456, 11016);
        serviceRegister.registerService(-1559494592, 11016);
        serviceRegister.registerService(-1542717376, 11016);
        serviceRegister.registerService(-1525940160, 11016);
        serviceRegister.registerService(-1509162944, 11016);
        serviceRegister.registerService(-1492385728, 11016);
        serviceRegister.registerService(-1475608512, 11016);
        serviceRegister.registerService(571277376, 11016);
        serviceRegister.registerService(-1458831296, 11016);
        serviceRegister.registerService(-1442054080, 11016);
        serviceRegister.registerService(-1425276864, 11016);
        serviceRegister.registerService(-552861632, 11016);
        serviceRegister.registerService(-1408499648, 11016);
        serviceRegister.registerService(638386240, 11016);
        serviceRegister.registerService(-1391722432, 11016);
        serviceRegister.registerService(-1358168000, 11016);
        serviceRegister.registerService(-1324613568, 11016);
        serviceRegister.registerService(-1307836352, 11016);
        serviceRegister.registerService(-1291059136, 11016);
        serviceRegister.registerService(-1274281920, 11016);
        serviceRegister.registerService(-1257504704, 11016);
        serviceRegister.registerService(-1240727488, 11016);
        serviceRegister.registerService(-1223950272, 11016);
        serviceRegister.registerService(-1207173056, 11016);
        serviceRegister.registerService(-468975552, 11016);
        serviceRegister.registerService(-452198336, 11016);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10374: {
                nArray = ListColumnsUtil.getSimpleIntArray(14);
                break;
            }
            case 10375: {
                nArray = ListColumnsUtil.getIntArrayByBits(2039, 10);
                break;
            }
            case 10376: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10360: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10787: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10788: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10789: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.E_Traction: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLCarE_TractionDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarE_TractionDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10374: {
                genericASLList = aSLListFactory.createGenericASLList(new CarE_TractionProfileListTransformer(), n, "Car.E_Traction", "ProfileList");
                break;
            }
            case 10375: {
                genericASLList = aSLListFactory.createGenericASLList(new CarE_TractionTimerListTransformer(), n, "Car.E_Traction", "TimerList");
                break;
            }
            case 10376: {
                genericASLList = aSLListFactory.createGenericASLList(new CarE_TractionChargingDistanceTransformer(), n, "Car.E_Traction", "ChargingDistance");
                genericASLList.updateList(new CarE_TractionChargingDistanceCollector[]{new CarE_TractionChargingDistanceCollector()});
                break;
            }
            case 10360: {
                genericASLList = aSLListFactory.createGenericASLList(new CarE_TractionTimerWeekdaysTransformer(), n, "Car.E_Traction", "TimerWeekdays");
                break;
            }
            case 10787: {
                genericASLList = aSLListFactory.createGenericASLList(new CarE_TractionFunctionExistence_ETRAKTransformer(), n, "Car.E_Traction", "FunctionExistence_ETRAK");
                break;
            }
            case 10788: {
                genericASLList = aSLListFactory.createGenericASLList(new CarE_TractionFunctionAvailableReason_ETRAKTransformer(), n, "Car.E_Traction", "FunctionAvailableReason_ETRAK");
                break;
            }
            case 10789: {
                genericASLList = aSLListFactory.createGenericASLList(new CarE_TractionFunctionAvailability_ETRAKTransformer(), n, "Car.E_Traction", "FunctionAvailability_ETRAK");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.E_Traction: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

