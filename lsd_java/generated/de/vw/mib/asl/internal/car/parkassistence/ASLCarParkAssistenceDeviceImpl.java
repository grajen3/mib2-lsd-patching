/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.parkassistence;

import de.vw.mib.asl.internal.car.parkassistence.transformer.CarParkAssistenceFunctionAvailabilityTransformer;
import de.vw.mib.asl.internal.car.parkassistence.transformer.CarParkAssistenceFunctionAvailableReasonTransformer;
import de.vw.mib.asl.internal.car.parkassistence.transformer.CarParkAssistenceFunctionExistenceTransformer;
import de.vw.mib.asl.internal.car.parkassistence.transformer.CarParkAssistencePDCAcousticSettingsTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.parkassistence.transformer.CarParkAssistenceDisplayContentCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.transformer.CarParkAssistenceDisplayContentTransformer;

public final class ASLCarParkAssistenceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarParkAssistenceDeviceImpl INSTANCE = new ASLCarParkAssistenceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLCarParkAssistenceDeviceImpl() {
    }

    public static ASLCarParkAssistenceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.ParkAssistence";
    }

    @Override
    public int getTargetId() {
        return 11008;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10560, this);
        aSLListRegistry.registerASLDevice(10742, this);
        aSLListRegistry.registerASLDevice(10743, this);
        aSLListRegistry.registerASLDevice(10744, this);
        aSLListRegistry.registerASLDevice(10162, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(786496, 11008);
        serviceRegister.registerService(17563712, 11008);
        serviceRegister.registerService(34340928, 11008);
        serviceRegister.registerService(51118144, 11008);
        serviceRegister.registerService(0x40C0040, 11008);
        serviceRegister.registerService(84672576, 11008);
        serviceRegister.registerService(101449792, 11008);
        serviceRegister.registerService(118227008, 11008);
        serviceRegister.registerService(135004224, 11008);
        serviceRegister.registerService(151781440, 11008);
        serviceRegister.registerService(168558656, 11008);
        serviceRegister.registerService(185335872, 11008);
        serviceRegister.registerService(-166985664, 11008);
        serviceRegister.registerService(-150208448, 11008);
        serviceRegister.registerService(906821696, 11008);
        serviceRegister.registerService(-32767936, 11008);
        serviceRegister.registerService(-15990720, 11008);
        serviceRegister.registerService(852032, 11008);
        serviceRegister.registerService(17629248, 11008);
        serviceRegister.registerService(34406464, 11008);
        serviceRegister.registerService(51183680, 11008);
        serviceRegister.registerService(84738112, 11008);
        serviceRegister.registerService(923598912, 11008);
        serviceRegister.registerService(973930560, 11008);
        serviceRegister.registerService(990707776, 11008);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10560: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 10742: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10743: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10744: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10162: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.ParkAssistence: ").append(n).toString());
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
        return ASLCarParkAssistenceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarParkAssistenceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10560: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceDisplayContentTransformer(), n, "Car.ParkAssistence", "DisplayContent");
                genericASLList.updateList(new CarParkAssistenceDisplayContentCollector[]{new CarParkAssistenceDisplayContentCollector()});
                break;
            }
            case 10742: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceFunctionExistenceTransformer(), n, "Car.ParkAssistence", "FunctionExistence");
                break;
            }
            case 10743: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceFunctionAvailabilityTransformer(), n, "Car.ParkAssistence", "FunctionAvailability");
                break;
            }
            case 10744: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceFunctionAvailableReasonTransformer(), n, "Car.ParkAssistence", "FunctionAvailableReason");
                break;
            }
            case 10162: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistencePDCAcousticSettingsTransformer(), n, "Car.ParkAssistence", "PDCAcousticSettings");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.ParkAssistence: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

