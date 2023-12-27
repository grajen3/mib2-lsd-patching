/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.parkassistence.areaview;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewBVSupportedModesCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewBVSupportedModesTransformer;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewFrontSupportedModesCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewFrontSupportedModesTransformer;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewRearSupportedModesCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewRearSupportedModesTransformer;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewSideSupportedModesCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewSideSupportedModesTransformer;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewVPS3DBirdViewPositionCollector;
import generated.de.vw.mib.asl.internal.car.parkassistence.areaview.transformer.CarParkAssistenceAreaViewVPS3DBirdViewPositionTransformer;

public final class ASLCarParkAssistenceAreaViewDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarParkAssistenceAreaViewDeviceImpl INSTANCE = new ASLCarParkAssistenceAreaViewDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLCarParkAssistenceAreaViewDeviceImpl() {
    }

    public static ASLCarParkAssistenceAreaViewDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.ParkAssistence.AreaView";
    }

    @Override
    public int getTargetId() {
        return 11023;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10452, this);
        aSLListRegistry.registerASLDevice(10453, this);
        aSLListRegistry.registerASLDevice(10454, this);
        aSLListRegistry.registerASLDevice(10456, this);
        aSLListRegistry.registerASLDevice(10462, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-569638848, 11023);
        serviceRegister.registerService(-502529984, 11023);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10452: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10453: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 10454: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10456: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 10462: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.ParkAssistence.AreaView: ").append(n).toString());
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
        return ASLCarParkAssistenceAreaViewDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarParkAssistenceAreaViewDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10452: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceAreaViewFrontSupportedModesTransformer(), n, "Car.ParkAssistence.AreaView", "FrontSupportedModes");
                genericASLList.updateList(new CarParkAssistenceAreaViewFrontSupportedModesCollector[]{new CarParkAssistenceAreaViewFrontSupportedModesCollector()});
                break;
            }
            case 10453: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceAreaViewRearSupportedModesTransformer(), n, "Car.ParkAssistence.AreaView", "RearSupportedModes");
                genericASLList.updateList(new CarParkAssistenceAreaViewRearSupportedModesCollector[]{new CarParkAssistenceAreaViewRearSupportedModesCollector()});
                break;
            }
            case 10454: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceAreaViewSideSupportedModesTransformer(), n, "Car.ParkAssistence.AreaView", "SideSupportedModes");
                genericASLList.updateList(new CarParkAssistenceAreaViewSideSupportedModesCollector[]{new CarParkAssistenceAreaViewSideSupportedModesCollector()});
                break;
            }
            case 10456: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceAreaViewBVSupportedModesTransformer(), n, "Car.ParkAssistence.AreaView", "BVSupportedModes");
                genericASLList.updateList(new CarParkAssistenceAreaViewBVSupportedModesCollector[]{new CarParkAssistenceAreaViewBVSupportedModesCollector()});
                break;
            }
            case 10462: {
                genericASLList = aSLListFactory.createGenericASLList(new CarParkAssistenceAreaViewVPS3DBirdViewPositionTransformer(), n, "Car.ParkAssistence.AreaView", "VPS3DBirdViewPosition");
                genericASLList.updateList(new CarParkAssistenceAreaViewVPS3DBirdViewPositionCollector[]{new CarParkAssistenceAreaViewVPS3DBirdViewPositionCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.ParkAssistence.AreaView: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

