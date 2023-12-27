/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser;

import de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserFileBrowserTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserActiveTrackInfoCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserActiveTrackInfoTransformer;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserBrowsedFolderActiveElementTransformer;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserBrowsedFolderCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserBrowsedFolderTransformer;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserCurrentActionStatusCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserCurrentActionStatusTransformer;

public final class ASLAVDCAudioBapMediaBrowserDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAVDCAudioBapMediaBrowserDeviceImpl INSTANCE = new ASLAVDCAudioBapMediaBrowserDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLAVDCAudioBapMediaBrowserDeviceImpl() {
    }

    public static ASLAVDCAudioBapMediaBrowserDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AVDC.Audio.Bap.MediaBrowser";
    }

    @Override
    public int getTargetId() {
        return 10145;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3829, this);
        aSLListRegistry.registerASLDevice(3831, this);
        aSLListRegistry.registerASLDevice(509348864, this);
        aSLListRegistry.registerASLDevice(526126080, this);
        aSLListRegistry.registerASLDevice(3834, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-938868672, 10145);
        serviceRegister.registerService(238357568, 10145);
        serviceRegister.registerService(-905314240, 10145);
        serviceRegister.registerService(-888537024, 10145);
        serviceRegister.registerService(255134784, 10145);
        serviceRegister.registerService(288689216, 10145);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3829: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 3831: {
                nArray = ListColumnsUtil.getIntArrayByBits(197, 4);
                break;
            }
            case 810014: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 810015: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3834: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Audio.Bap.MediaBrowser: ").append(n).toString());
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
        return ASLAVDCAudioBapMediaBrowserDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLAVDCAudioBapMediaBrowserDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3829: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBapMediaBrowserFileBrowserTransformer(), n, "AVDC.Audio.Bap.MediaBrowser", "fileBrowser");
                break;
            }
            case 3831: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBapMediaBrowserBrowsedFolderTransformer(), n, "AVDC.Audio.Bap.MediaBrowser", "BrowsedFolder");
                genericASLList.updateList(new AVDCAudioBapMediaBrowserBrowsedFolderCollector[]{new AVDCAudioBapMediaBrowserBrowsedFolderCollector()});
                break;
            }
            case 810014: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBapMediaBrowserBrowsedFolderActiveElementTransformer(), n, "AVDC.Audio.Bap.MediaBrowser", "BrowsedFolderActiveElement");
                genericASLList.updateList(new AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector[]{new AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector()});
                break;
            }
            case 810015: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBapMediaBrowserActiveTrackInfoTransformer(), n, "AVDC.Audio.Bap.MediaBrowser", "ActiveTrackInfo");
                genericASLList.updateList(new AVDCAudioBapMediaBrowserActiveTrackInfoCollector[]{new AVDCAudioBapMediaBrowserActiveTrackInfoCollector()});
                break;
            }
            case 3834: {
                genericASLList = aSLListFactory.createGenericASLList(new AVDCAudioBapMediaBrowserCurrentActionStatusTransformer(), n, "AVDC.Audio.Bap.MediaBrowser", "CurrentActionStatus");
                genericASLList.updateList(new AVDCAudioBapMediaBrowserCurrentActionStatusCollector[]{new AVDCAudioBapMediaBrowserCurrentActionStatusCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device AVDC.Audio.Bap.MediaBrowser: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

