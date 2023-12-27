/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.seats;

import de.vw.mib.asl.internal.car.seats.transformer.CarSeatsFunctionAvailability_2Transformer;
import de.vw.mib.asl.internal.car.seats.transformer.CarSeatsFunctionAvailableReason_2Transformer;
import de.vw.mib.asl.internal.car.seats.transformer.CarSeatsFunctionExistence_2Transformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarSeatsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarSeatsDeviceImpl INSTANCE = new ASLCarSeatsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLCarSeatsDeviceImpl() {
    }

    public static ASLCarSeatsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.Seats";
    }

    @Override
    public int getTargetId() {
        return 11014;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10635, this);
        aSLListRegistry.registerASLDevice(10636, this);
        aSLListRegistry.registerASLDevice(10637, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1393295424, 11014);
        serviceRegister.registerService(1410072640, 11014);
        serviceRegister.registerService(1426849856, 11014);
        serviceRegister.registerService(1041039424, 11014);
        serviceRegister.registerService(1057816640, 11014);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10635: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10636: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10637: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Seats: ").append(n).toString());
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
        return ASLCarSeatsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarSeatsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10635: {
                genericASLList = aSLListFactory.createGenericASLList(new CarSeatsFunctionExistence_2Transformer(), n, "Car.Seats", "FunctionExistence_2");
                break;
            }
            case 10636: {
                genericASLList = aSLListFactory.createGenericASLList(new CarSeatsFunctionAvailability_2Transformer(), n, "Car.Seats", "FunctionAvailability_2");
                break;
            }
            case 10637: {
                genericASLList = aSLListFactory.createGenericASLList(new CarSeatsFunctionAvailableReason_2Transformer(), n, "Car.Seats", "FunctionAvailableReason_2");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.Seats: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

