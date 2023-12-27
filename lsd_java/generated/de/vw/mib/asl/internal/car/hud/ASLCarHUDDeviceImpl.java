/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.hud;

import de.vw.mib.asl.internal.car.hud.transformer.CarHUDFunctionAvailabilityTransformer;
import de.vw.mib.asl.internal.car.hud.transformer.CarHUDFunctionAvailableReasonTransformer;
import de.vw.mib.asl.internal.car.hud.transformer.CarHUDFunctionExistenceTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarHUDDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarHUDDeviceImpl INSTANCE = new ASLCarHUDDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLCarHUDDeviceImpl() {
    }

    public static ASLCarHUDDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.HUD";
    }

    @Override
    public int getTargetId() {
        return 11026;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10722, this);
        aSLListRegistry.registerASLDevice(10723, this);
        aSLListRegistry.registerASLDevice(10724, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10722: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10723: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10724: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.HUD: ").append(n).toString());
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
        return ASLCarHUDDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarHUDDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10722: {
                genericASLList = aSLListFactory.createGenericASLList(new CarHUDFunctionExistenceTransformer(), n, "Car.HUD", "FunctionExistence");
                break;
            }
            case 10723: {
                genericASLList = aSLListFactory.createGenericASLList(new CarHUDFunctionAvailabilityTransformer(), n, "Car.HUD", "FunctionAvailability");
                break;
            }
            case 10724: {
                genericASLList = aSLListFactory.createGenericASLList(new CarHUDFunctionAvailableReasonTransformer(), n, "Car.HUD", "FunctionAvailableReason");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.HUD: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

