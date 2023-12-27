/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.internetbrowser;

import de.vw.mib.asl.internal.internetbrowser.transformer.InternetbrowserBookmarksTitleTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.internetbrowser.transformer.InternetbrowserCurrentPageStatusCollector;
import generated.de.vw.mib.asl.internal.internetbrowser.transformer.InternetbrowserCurrentPageStatusTransformer;

public final class ASLInternetbrowserDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLInternetbrowserDeviceImpl INSTANCE = new ASLInternetbrowserDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLInternetbrowserDeviceImpl() {
    }

    public static ASLInternetbrowserDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Internetbrowser";
    }

    @Override
    public int getTargetId() {
        return 10028;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3344, this);
        aSLListRegistry.registerASLDevice(3343, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(973668416, 10028);
        serviceRegister.registerService(1342242880, 10028);
        serviceRegister.registerService(990445632, 10028);
        serviceRegister.registerService(1007222848, 10028);
        serviceRegister.registerService(-819525312, 10028);
        serviceRegister.registerService(-1054406336, 10028);
        serviceRegister.registerService(-953743040, 10028);
        serviceRegister.registerService(-936965824, 10028);
        serviceRegister.registerService(-1071183552, 10028);
        serviceRegister.registerService(1024000064, 10028);
        serviceRegister.registerService(1040777280, 10028);
        serviceRegister.registerService(1057554496, 10028);
        serviceRegister.registerService(-920188608, 10028);
        serviceRegister.registerService(-903411392, 10028);
        serviceRegister.registerService(-886634176, 10028);
        serviceRegister.registerService(-869856960, 10028);
        serviceRegister.registerService(-836302528, 10028);
        serviceRegister.registerService(-1037629120, 10028);
        serviceRegister.registerService(-1020851904, 10028);
        serviceRegister.registerService(-1004074688, 10028);
        serviceRegister.registerService(-853079744, 10028);
        serviceRegister.registerService(-987297472, 10028);
        serviceRegister.registerService(-970520256, 10028);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3344: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 3343: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Internetbrowser: ").append(n).toString());
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
        return ASLInternetbrowserDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLInternetbrowserDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3344: {
                genericASLList = aSLListFactory.createGenericASLList(new InternetbrowserCurrentPageStatusTransformer(), n, "Internetbrowser", "CurrentPageStatus");
                genericASLList.updateList(new InternetbrowserCurrentPageStatusCollector[]{new InternetbrowserCurrentPageStatusCollector()});
                break;
            }
            case 3343: {
                genericASLList = aSLListFactory.createGenericASLList(new InternetbrowserBookmarksTitleTransformer(), n, "Internetbrowser", "BookmarksTitle");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Internetbrowser: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

