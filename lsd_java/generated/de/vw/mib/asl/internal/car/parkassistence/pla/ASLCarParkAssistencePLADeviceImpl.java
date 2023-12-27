/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.parkassistence.pla;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.parkassistence.pla.transformer.CarParkAssistencePLAPLAStatusCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.pla.transformer.CarParkAssistencePLAPLAStatusTransformer;

public final class ASLCarParkAssistencePLADeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarParkAssistencePLADeviceImpl INSTANCE = new ASLCarParkAssistencePLADeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLCarParkAssistencePLADeviceImpl() {
    }

    public static ASLCarParkAssistencePLADeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.ParkAssistence.PLA";
    }

    @Override
    public int getTargetId() {
        return 11030;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10809, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10809: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.ParkAssistence.PLA: ").append(n).toString());
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
        return ASLCarParkAssistencePLADeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarParkAssistencePLADeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10809: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistencePLAPLAStatusTransformer(), n, "Car.ParkAssistence.PLA", "PLAStatus");
                genericASLList.updateList(new CarParkAssistencePLAPLAStatusCollector[]{new CarParkAssistencePLAPLAStatusCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.ParkAssistence.PLA: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

