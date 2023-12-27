/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.openclose;

import de.vw.mib.asl.internal.car.openclose.transformer.CarOpenCloseFunctionAvailability_OpenCloseTransformer;
import de.vw.mib.asl.internal.car.openclose.transformer.CarOpenCloseFunctionAvailableReason_OpenCloseTransformer;
import de.vw.mib.asl.internal.car.openclose.transformer.CarOpenCloseFunctionExistence_OpenCloseTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarOpenCloseDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarOpenCloseDeviceImpl INSTANCE = new ASLCarOpenCloseDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLCarOpenCloseDeviceImpl() {
    }

    public static ASLCarOpenCloseDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.OpenClose";
    }

    @Override
    public int getTargetId() {
        return 11010;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10783, this);
        aSLListRegistry.registerASLDevice(10784, this);
        aSLListRegistry.registerASLDevice(10785, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(353108032, 11010);
        serviceRegister.registerService(369885248, 11010);
        serviceRegister.registerService(386662464, 11010);
        serviceRegister.registerService(403439680, 11010);
        serviceRegister.registerService(420216896, 11010);
        serviceRegister.registerService(436994112, 11010);
        serviceRegister.registerService(453771328, 11010);
        serviceRegister.registerService(470548544, 11010);
        serviceRegister.registerService(537722944, 11010);
        serviceRegister.registerService(470614080, 11010);
        serviceRegister.registerService(554500160, 11010);
        serviceRegister.registerService(1410138176, 11010);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10783: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10784: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10785: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.OpenClose: ").append(n).toString());
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
        return ASLCarOpenCloseDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarOpenCloseDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10783: {
                genericASLList = aSLListFactory.createGenericASLList(new CarOpenCloseFunctionExistence_OpenCloseTransformer(), n, "Car.OpenClose", "FunctionExistence_OpenClose");
                break;
            }
            case 10784: {
                genericASLList = aSLListFactory.createGenericASLList(new CarOpenCloseFunctionAvailableReason_OpenCloseTransformer(), n, "Car.OpenClose", "FunctionAvailableReason_OpenClose");
                break;
            }
            case 10785: {
                genericASLList = aSLListFactory.createGenericASLList(new CarOpenCloseFunctionAvailability_OpenCloseTransformer(), n, "Car.OpenClose", "FunctionAvailability_OpenClose");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.OpenClose: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

