/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.mediacontrol.browser;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mediacontrol.browser.transformer.MediaControlBrowserDisplayedFolderPathTransformer;
import de.vw.mib.asl.internal.mediacontrol.browser.transformer.MediaControlBrowserListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLMediaControlBrowserDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMediaControlBrowserDeviceImpl INSTANCE = new ASLMediaControlBrowserDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLMediaControlBrowserDeviceImpl() {
    }

    public static ASLMediaControlBrowserDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "MediaControl.Browser";
    }

    @Override
    public int getTargetId() {
        return 16703;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1138731264, this);
        aSLListRegistry.registerASLDevice(-987736320, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1392945600, 16703);
        serviceRegister.registerService(-1208396224, 16703);
        serviceRegister.registerService(-1191619008, 16703);
        serviceRegister.registerService(-1342613952, 16703);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5710012: {
                nArray = ListColumnsUtil.getIntArrayByBits(29, 4);
                break;
            }
            case 5710021: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device MediaControl.Browser: ").append(n).toString());
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
        return ASLMediaControlBrowserDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLMediaControlBrowserDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5710012: {
                genericASLList = aSLListFactory.createGenericASLList(new MediaControlBrowserListTransformer(), n, "MediaControl.Browser", "list");
                break;
            }
            case 5710021: {
                genericASLList = aSLListFactory.createGenericASLList(new MediaControlBrowserDisplayedFolderPathTransformer(), n, "MediaControl.Browser", "DisplayedFolderPath");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device MediaControl.Browser: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

