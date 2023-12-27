/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.carplay;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.carplay.transformer.CarPlayCanvasDimensionCollector;
import generated.de.vw.mib.asl.internal.carplay.transformer.CarPlayCanvasDimensionTransformer;

public final class ASLCarPlayDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarPlayDeviceImpl INSTANCE = new ASLCarPlayDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLCarPlayDeviceImpl() {
    }

    public static ASLCarPlayDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "CarPlay";
    }

    @Override
    public int getTargetId() {
        return 13903;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(946285568, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(624962624, 13903);
        serviceRegister.registerService(641739840, 13903);
        serviceRegister.registerService(658517056, 13903);
        serviceRegister.registerService(675294272, 13903);
        serviceRegister.registerService(692071488, 13903);
        serviceRegister.registerService(708848704, 13903);
        serviceRegister.registerService(725625920, 13903);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2910008: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device CarPlay: ").append(n).toString());
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
        return ASLCarPlayDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLCarPlayDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2910008: {
                genericASLList = aSLListFactory.createGenericASLList(new CarPlayCanvasDimensionTransformer(), n, "CarPlay", "CanvasDimension");
                genericASLList.updateList(new CarPlayCanvasDimensionCollector[]{new CarPlayCanvasDimensionCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device CarPlay: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

