/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.speech.map;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.speech.map.transformer.NavigationSpeechMapZoomLevelListCommandsTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationSpeechMapDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationSpeechMapDeviceImpl INSTANCE = new ASLNavigationSpeechMapDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLNavigationSpeechMapDeviceImpl() {
    }

    public static ASLNavigationSpeechMapDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Speech.Map";
    }

    @Override
    public int getTargetId() {
        return 12104;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(653266944, this);
        aSLListRegistry.registerASLDevice(-51441664, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-473427904, 12104);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1110054: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1110012: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Speech.Map: ").append(n).toString());
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
        return ASLNavigationSpeechMapDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationSpeechMapDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1110054: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechMapZoomLevelListCommandsTransformer(), n, "Navigation.Speech.Map", "ZoomLevelListCommands");
                break;
            }
            case 1110012: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationSpeechMapDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "ZoomLevelList"), n, "Navigation.Speech.Map", "ZoomLevelList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Speech.Map: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 1110012: {
                string3 = "de.vw.mib.asl.internal.navigation.speech.map.transformer.";
                string2 = "NavigationSpeechMapZoomLevelListTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.Speech.Map: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.Speech.Map", string);
    }
}

