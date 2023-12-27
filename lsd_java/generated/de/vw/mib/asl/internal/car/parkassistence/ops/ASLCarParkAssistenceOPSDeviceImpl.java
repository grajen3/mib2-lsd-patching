/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.parkassistence.ops;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer.CarParkAssistenceOPSDisplayContentCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer.CarParkAssistenceOPSDisplayContentTransformer;
import generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer.CarParkAssistenceOPSSteeringInfoWheelRadiusCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer.CarParkAssistenceOPSSteeringInfoWheelRadiusTransformer;

public final class ASLCarParkAssistenceOPSDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarParkAssistenceOPSDeviceImpl INSTANCE = new ASLCarParkAssistenceOPSDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLCarParkAssistenceOPSDeviceImpl() {
    }

    public static ASLCarParkAssistenceOPSDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.ParkAssistence.OPS";
    }

    @Override
    public int getTargetId() {
        return 11009;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10197, this);
        aSLListRegistry.registerASLDevice(10198, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(0xC0C0040, 11009);
        serviceRegister.registerService(218890304, 11009);
        serviceRegister.registerService(235667520, 11009);
        serviceRegister.registerService(252444736, 11009);
        serviceRegister.registerService(269221952, 11009);
        serviceRegister.registerService(285999168, 11009);
        serviceRegister.registerService(302776384, 11009);
        serviceRegister.registerService(319553600, 11009);
        serviceRegister.registerService(336330816, 11009);
        serviceRegister.registerService(-603193280, 11009);
        serviceRegister.registerService(-586416064, 11009);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10197: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10198: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.ParkAssistence.OPS: ").append(n).toString());
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
        return ASLCarParkAssistenceOPSDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarParkAssistenceOPSDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10197: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceOPSSteeringInfoWheelRadiusTransformer(), n, "Car.ParkAssistence.OPS", "SteeringInfoWheelRadius");
                genericASLList.updateList(new CarParkAssistenceOPSSteeringInfoWheelRadiusCollector[]{new CarParkAssistenceOPSSteeringInfoWheelRadiusCollector()});
                break;
            }
            case 10198: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceOPSDisplayContentTransformer(), n, "Car.ParkAssistence.OPS", "DisplayContent");
                genericASLList.updateList(new CarParkAssistenceOPSDisplayContentCollector[]{new CarParkAssistenceOPSDisplayContentCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.ParkAssistence.OPS: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

