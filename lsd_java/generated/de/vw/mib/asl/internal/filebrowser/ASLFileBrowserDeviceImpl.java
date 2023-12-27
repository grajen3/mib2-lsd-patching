/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.internal.filebrowser.transformer.FileBrowserAvailableSourcesTransformer;
import de.vw.mib.asl.internal.filebrowser.transformer.FileBrowserAvailableSourcev2Transformer;
import de.vw.mib.asl.internal.filebrowser.transformer.FileBrowserFileBrowserFileInfoTransformer;
import de.vw.mib.asl.internal.filebrowser.transformer.FileBrowserFileBrowserFolderInfoTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLFileBrowserDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLFileBrowserDeviceImpl INSTANCE = new ASLFileBrowserDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLFileBrowserDeviceImpl() {
    }

    public static ASLFileBrowserDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "FileBrowser";
    }

    @Override
    public int getTargetId() {
        return 10026;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(424, this);
        aSLListRegistry.registerASLDevice(425, this);
        aSLListRegistry.registerASLDevice(-205913088, this);
        aSLListRegistry.registerASLDevice(414, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1057030208, 10026);
        serviceRegister.registerService(0x40010040, 10026);
        serviceRegister.registerService(0x41010040, 10026);
        serviceRegister.registerService(-1442250688, 10026);
        serviceRegister.registerService(1107361856, 10026);
        serviceRegister.registerService(1124139072, 10026);
        serviceRegister.registerService(0x44010040, 10026);
        serviceRegister.registerService(1157693504, 10026);
        serviceRegister.registerService(-284622784, 10026);
        serviceRegister.registerService(1174470720, 10026);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 424: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 425: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 310003: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 414: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device FileBrowser: ").append(n).toString());
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
        return ASLFileBrowserDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLFileBrowserDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 424: {
                genericASLList = aSLListFactory.createGenericASLList(new FileBrowserFileBrowserFileInfoTransformer(), n, "FileBrowser", "FileBrowserFileInfo");
                break;
            }
            case 425: {
                genericASLList = aSLListFactory.createGenericASLList(new FileBrowserFileBrowserFolderInfoTransformer(), n, "FileBrowser", "FileBrowserFolderInfo");
                break;
            }
            case 310003: {
                genericASLList = aSLListFactory.createGenericASLList(new FileBrowserAvailableSourcev2Transformer(), n, "FileBrowser", "AvailableSourcev2");
                break;
            }
            case 414: {
                genericASLList = aSLListFactory.createGenericASLList(new FileBrowserAvailableSourcesTransformer(), n, "FileBrowser", "AvailableSources");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device FileBrowser: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

