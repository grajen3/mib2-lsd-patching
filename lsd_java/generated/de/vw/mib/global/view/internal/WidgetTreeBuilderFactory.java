/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.file.FileManager;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.view.internal.treebuilder.ControllerFactory;
import de.vw.mib.view.internal.treebuilder.PoolingControllerFactory;
import de.vw.mib.view.internal.treebuilder.PoolingUIFactory;
import de.vw.mib.view.internal.treebuilder.PoolingWidgetFactory;
import de.vw.mib.view.internal.treebuilder.UIFactory;
import de.vw.mib.view.internal.treebuilder.WidgetFactory;
import de.vw.mib.view.internal.treebuilder.WidgetTreeBuilderImpl;
import de.vw.mib.view.internal.treebuilder.WidgetTreeBuilderResDataAccess;
import generated.de.vw.mib.global.view.internal.ControllerFactoryImpl;
import generated.de.vw.mib.global.view.internal.UIFactoryImpl;
import generated.de.vw.mib.global.view.internal.WidgetFactoryImpl;
import java.io.File;

public final class WidgetTreeBuilderFactory {
    public static final int CHECKSUM;
    private static final float PREFILL_FACTOR;

    private WidgetTreeBuilderFactory() {
    }

    public static WidgetTreeBuilderImpl createBuilder(boolean bl, ConfigurationManager configurationManager, FileManager fileManager, LoggerFactory loggerFactory) {
        WidgetTreeBuilderResDataAccess widgetTreeBuilderResDataAccess = WidgetTreeBuilderFactory.loadResData(configurationManager, fileManager, loggerFactory);
        WidgetFactory widgetFactory = WidgetTreeBuilderFactory.createWidgetFactory(bl);
        ControllerFactory controllerFactory = WidgetTreeBuilderFactory.createControllerFactory(bl);
        UIFactory uIFactory = WidgetTreeBuilderFactory.createUIFactory(bl);
        return new WidgetTreeBuilderImpl(widgetTreeBuilderResDataAccess, widgetFactory, controllerFactory, uIFactory, loggerFactory);
    }

    private static WidgetTreeBuilderResDataAccess loadResData(ConfigurationManager configurationManager, FileManager fileManager, LoggerFactory loggerFactory) {
        Logger logger = loggerFactory.getLogger(1024);
        File file = ResData.getResFile(configurationManager, "widgetfactory.res");
        Object[] objectArray = ResData.loadAndCheck(fileManager, file, MagicNumber.WIDGETFACTORY_RES, 179079488, 0, logger, 1);
        return new WidgetTreeBuilderResDataAccess(objectArray);
    }

    private static WidgetFactory createWidgetFactory(boolean bl) {
        int[] nArray = new int[56];
        nArray[1] = 4;
        nArray[2] = 482;
        nArray[3] = 30;
        nArray[4] = 64;
        nArray[5] = 4;
        nArray[6] = 2;
        nArray[7] = 32;
        nArray[8] = 2;
        nArray[9] = 18;
        nArray[10] = 20;
        nArray[11] = 1580;
        nArray[12] = 4;
        nArray[13] = 102;
        nArray[14] = 408;
        nArray[15] = 96;
        nArray[16] = 2;
        nArray[17] = 6;
        nArray[18] = 2;
        nArray[19] = 2;
        nArray[20] = 32;
        nArray[21] = 10;
        nArray[22] = 10;
        nArray[23] = 120;
        nArray[24] = 8;
        nArray[25] = 16;
        nArray[26] = 2;
        nArray[27] = 856;
        nArray[28] = 2;
        nArray[29] = 6;
        nArray[30] = 2;
        nArray[31] = 2;
        nArray[32] = 2;
        nArray[33] = 2;
        nArray[34] = 2;
        nArray[35] = 8;
        nArray[36] = 72;
        nArray[37] = 2;
        nArray[38] = 2;
        nArray[39] = 42;
        nArray[40] = 10;
        nArray[41] = 8;
        nArray[42] = 16;
        nArray[43] = 62;
        nArray[44] = 4;
        nArray[45] = 590;
        nArray[46] = 144;
        nArray[47] = 2288;
        nArray[48] = 6;
        nArray[49] = 2126;
        nArray[50] = 2;
        nArray[51] = 18;
        nArray[52] = 48;
        nArray[53] = 48;
        nArray[54] = 2;
        nArray[55] = 104;
        PoolingWidgetFactory poolingWidgetFactory = new PoolingWidgetFactory(new WidgetFactoryImpl(), nArray);
        if (bl) {
            poolingWidgetFactory.fillPools(63);
        }
        return poolingWidgetFactory;
    }

    private static ControllerFactory createControllerFactory(boolean bl) {
        int[] nArray = new int[39];
        nArray[1] = 4;
        nArray[2] = 30;
        nArray[3] = 2;
        nArray[4] = 32;
        nArray[5] = 2;
        nArray[6] = 20;
        nArray[7] = 4;
        nArray[8] = 408;
        nArray[9] = 2;
        nArray[10] = 6;
        nArray[11] = 2;
        nArray[12] = 2;
        nArray[13] = 32;
        nArray[14] = 10;
        nArray[15] = 10;
        nArray[16] = 120;
        nArray[17] = 8;
        nArray[18] = 856;
        nArray[19] = 2;
        nArray[20] = 2;
        nArray[21] = 2;
        nArray[22] = 2;
        nArray[23] = 646;
        nArray[24] = 102;
        nArray[25] = 2;
        nArray[27] = 10;
        nArray[28] = 8;
        nArray[29] = 62;
        nArray[30] = 4;
        nArray[31] = 6;
        nArray[32] = 2;
        nArray[33] = 18;
        nArray[34] = 48;
        nArray[35] = 2;
        nArray[36] = 104;
        nArray[37] = 4;
        nArray[38] = 72;
        PoolingControllerFactory poolingControllerFactory = new PoolingControllerFactory(new ControllerFactoryImpl(), nArray);
        if (bl) {
            poolingControllerFactory.fillPools(63);
        }
        return poolingControllerFactory;
    }

    private static UIFactory createUIFactory(boolean bl) {
        int[] nArray = new int[68];
        nArray[1] = 4;
        nArray[2] = 482;
        nArray[3] = 30;
        nArray[4] = 64;
        nArray[5] = 4;
        nArray[6] = 2;
        nArray[8] = 32;
        nArray[9] = 2;
        nArray[10] = 18;
        nArray[11] = 20;
        nArray[12] = 1580;
        nArray[13] = 4;
        nArray[15] = 408;
        nArray[16] = 102;
        nArray[17] = 96;
        nArray[20] = 2;
        nArray[21] = 6;
        nArray[22] = 2;
        nArray[23] = 2;
        nArray[24] = 32;
        nArray[25] = 10;
        nArray[26] = 10;
        nArray[27] = 24;
        nArray[28] = 120;
        nArray[30] = 8;
        nArray[31] = 16;
        nArray[32] = 2;
        nArray[33] = 856;
        nArray[34] = 2;
        nArray[36] = 6;
        nArray[37] = 2;
        nArray[39] = 2;
        nArray[40] = 2;
        nArray[41] = 2;
        nArray[42] = 2;
        nArray[43] = 8;
        nArray[46] = 72;
        nArray[47] = 42;
        nArray[48] = 2;
        nArray[49] = 10;
        nArray[50] = 8;
        nArray[51] = 16;
        nArray[52] = 2;
        nArray[53] = 62;
        nArray[54] = 590;
        nArray[55] = 4;
        nArray[56] = 144;
        nArray[57] = 30;
        nArray[58] = 2288;
        nArray[60] = 6;
        nArray[62] = 2126;
        nArray[63] = 2;
        nArray[64] = 48;
        nArray[65] = 48;
        nArray[66] = 2;
        nArray[67] = 104;
        PoolingUIFactory poolingUIFactory = new PoolingUIFactory(new UIFactoryImpl(), nArray);
        if (bl) {
            poolingUIFactory.fillPools(63);
        }
        return poolingUIFactory;
    }
}

