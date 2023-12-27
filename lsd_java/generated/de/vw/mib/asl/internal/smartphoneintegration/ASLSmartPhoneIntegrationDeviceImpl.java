/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.smartphoneintegration;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.smartphoneintegration.transformer.SmartPhoneIntegrationDeviceListsTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSmartPhoneIntegrationDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSmartPhoneIntegrationDeviceImpl INSTANCE = new ASLSmartPhoneIntegrationDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLSmartPhoneIntegrationDeviceImpl() {
    }

    public static ASLSmartPhoneIntegrationDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SmartPhoneIntegration";
    }

    @Override
    public int getTargetId() {
        return 13905;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1231498240, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(742403136, 13905);
        serviceRegister.registerService(759180352, 13905);
        serviceRegister.registerService(775957568, 13905);
        serviceRegister.registerService(792734784, 13905);
        serviceRegister.registerService(809512000, 13905);
        serviceRegister.registerService(826289216, 13905);
        serviceRegister.registerService(843066432, 13905);
        serviceRegister.registerService(1010838592, 13905);
        serviceRegister.registerService(859843648, 13905);
        serviceRegister.registerService(876620864, 13905);
        serviceRegister.registerService(893398080, 13905);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2910025: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SmartPhoneIntegration: ").append(n).toString());
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
        return ASLSmartPhoneIntegrationDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSmartPhoneIntegrationDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2910025: {
                genericASLList = aSLListFactory.createGenericASLList(new SmartPhoneIntegrationDeviceListsTransformer(), n, "SmartPhoneIntegration", "DeviceLists");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SmartPhoneIntegration: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

