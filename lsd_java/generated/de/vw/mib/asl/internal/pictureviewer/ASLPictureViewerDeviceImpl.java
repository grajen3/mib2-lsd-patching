/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.pictureviewer.transformer.PictureViewerAvailableBrowsingSourcesTransformer;
import de.vw.mib.asl.internal.pictureviewer.transformer.PictureViewerAvailablePictureSourcesTransformer;
import de.vw.mib.asl.internal.pictureviewer.transformer.PictureViewerBrowserInfoListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPictureViewerDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPictureViewerDeviceImpl INSTANCE = new ASLPictureViewerDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLPictureViewerDeviceImpl() {
    }

    public static ASLPictureViewerDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "PictureViewer";
    }

    @Override
    public int getTargetId() {
        return 10102;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3516, this);
        aSLListRegistry.registerASLDevice(1266, this);
        aSLListRegistry.registerASLDevice(1267, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-771162048, 10102);
        serviceRegister.registerService(1040449600, 10102);
        serviceRegister.registerService(1057226816, 10102);
        serviceRegister.registerService(0x40040040, 10102);
        serviceRegister.registerService(0x41040040, 10102);
        serviceRegister.registerService(0x42040040, 10102);
        serviceRegister.registerService(0x43040040, 10102);
        serviceRegister.registerService(0x44040040, 10102);
        serviceRegister.registerService(0x45040040, 10102);
        serviceRegister.registerService(0x46040040, 10102);
        serviceRegister.registerService(0x47040040, 10102);
        serviceRegister.registerService(0x48040040, 10102);
        serviceRegister.registerService(0x49040040, 10102);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3516: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1266: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1267: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PictureViewer: ").append(n).toString());
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
        return ASLPictureViewerDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPictureViewerDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3516: {
                genericASLList = aSLListFactory.createGenericASLList(new PictureViewerAvailableBrowsingSourcesTransformer(), n, "PictureViewer", "availableBrowsingSources");
                break;
            }
            case 1266: {
                genericASLList = aSLListFactory.createGenericASLList(new PictureViewerAvailablePictureSourcesTransformer(), n, "PictureViewer", "availablePictureSources");
                break;
            }
            case 1267: {
                genericASLList = aSLListFactory.createGenericASLList(new PictureViewerBrowserInfoListTransformer(), n, "PictureViewer", "browserInfoList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device PictureViewer: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

