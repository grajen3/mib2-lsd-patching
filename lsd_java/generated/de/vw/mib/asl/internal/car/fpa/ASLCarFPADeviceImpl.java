/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.fpa;

import de.vw.mib.asl.internal.car.fpa.transformer.CarFPAFunctionListTransformer;
import de.vw.mib.asl.internal.car.fpa.transformer.CarFPAFunctionOptionMaskTransformer;
import de.vw.mib.asl.internal.car.fpa.transformer.CarFPAProfileAvailabilityTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarFPADeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarFPADeviceImpl INSTANCE = new ASLCarFPADeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLCarFPADeviceImpl() {
    }

    public static ASLCarFPADeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.FPA";
    }

    @Override
    public int getTargetId() {
        return 11015;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(10333, this);
        aSLListRegistry.registerASLDevice(10279, this);
        aSLListRegistry.registerASLDevice(10280, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-200540096, 11015);
        serviceRegister.registerService(-133431232, 11015);
        serviceRegister.registerService(1443627072, 11015);
        serviceRegister.registerService(1460404288, 11015);
        serviceRegister.registerService(1477181504, 11015);
        serviceRegister.registerService(688717888, 11015);
        serviceRegister.registerService(705495104, 11015);
        serviceRegister.registerService(1225588800, 11015);
        serviceRegister.registerService(1510735936, 11015);
        serviceRegister.registerService(1527513152, 11015);
        serviceRegister.registerService(1544290368, 11015);
        serviceRegister.registerService(1242366016, 11015);
        serviceRegister.registerService(1259143232, 11015);
        serviceRegister.registerService(1594622016, 11015);
        serviceRegister.registerService(1611399232, 11015);
        serviceRegister.registerService(1628176448, 11015);
        serviceRegister.registerService(1644953664, 11015);
        serviceRegister.registerService(1661730880, 11015);
        serviceRegister.registerService(1678508096, 11015);
        serviceRegister.registerService(1695285312, 11015);
        serviceRegister.registerService(1712062528, 11015);
        serviceRegister.registerService(1728839744, 11015);
        serviceRegister.registerService(1745616960, 11015);
        serviceRegister.registerService(1762394176, 11015);
        serviceRegister.registerService(1779171392, 11015);
        serviceRegister.registerService(1795948608, 11015);
        serviceRegister.registerService(1812725824, 11015);
        serviceRegister.registerService(1829503040, 11015);
        serviceRegister.registerService(1846280256, 11015);
        serviceRegister.registerService(1863057472, 11015);
        serviceRegister.registerService(1879834688, 11015);
        serviceRegister.registerService(1896611904, 11015);
        serviceRegister.registerService(1913389120, 11015);
        serviceRegister.registerService(1275920448, 11015);
        serviceRegister.registerService(1946943552, 11015);
        serviceRegister.registerService(1963720768, 11015);
        serviceRegister.registerService(1980497984, 11015);
        serviceRegister.registerService(1997275200, 11015);
        serviceRegister.registerService(0x4D0D0040, 11015);
        serviceRegister.registerService(2030829632, 11015);
        serviceRegister.registerService(2047606848, 11015);
        serviceRegister.registerService(2064384064, 11015);
        serviceRegister.registerService(2081161280, 11015);
        serviceRegister.registerService(2097938496, 11015);
        serviceRegister.registerService(2114715712, 11015);
        serviceRegister.registerService(2131492928, 11015);
        serviceRegister.registerService(-2146697152, 11015);
        serviceRegister.registerService(-2129919936, 11015);
        serviceRegister.registerService(-2113142720, 11015);
        serviceRegister.registerService(1309474880, 11015);
        serviceRegister.registerService(1359806528, 11015);
        serviceRegister.registerService(1376583744, 11015);
        serviceRegister.registerService(-2046033856, 11015);
        serviceRegister.registerService(-2029256640, 11015);
        serviceRegister.registerService(-2012479424, 11015);
        serviceRegister.registerService(-1995702208, 11015);
        serviceRegister.registerService(-1978924992, 11015);
        serviceRegister.registerService(-317980608, 11015);
        serviceRegister.registerService(-1962147776, 11015);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 10333: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 10279: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 10280: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.FPA: ").append(n).toString());
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
        return ASLCarFPADeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarFPADeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 10333: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPAProfileAvailabilityTransformer(), n, "Car.FPA", "ProfileAvailability");
                break;
            }
            case 10279: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPAFunctionListTransformer(), n, "Car.FPA", "FunctionList");
                break;
            }
            case 10280: {
                genericASLList = aSLListFactory.createGenericASLList(new CarFPAFunctionOptionMaskTransformer(), n, "Car.FPA", "FunctionOptionMask");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Car.FPA: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

