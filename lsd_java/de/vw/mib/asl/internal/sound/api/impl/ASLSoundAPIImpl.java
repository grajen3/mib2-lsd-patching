/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound.api.impl;

import de.vw.mib.asl.api.sound.ASLSoundAPI;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.sound.api.impl.ASLSoundServices;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;

public class ASLSoundAPIImpl
implements ASLSoundAPI {
    private final de.vw.mib.asl.api.sound.ASLSoundServices aslSoundServices = new ASLSoundServices();

    public static void registerIds(GenericEvents genericEvents) {
        ServiceRegister serviceRegister = genericEvents.getServiceRegister();
        serviceRegister.unregisterService(-284950464);
        serviceRegister.registerService(-284950464, 0, 10106, 0, false, true);
    }

    @Override
    public de.vw.mib.asl.api.sound.ASLSoundServices getASLSoundServices() {
        return this.aslSoundServices;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -217841600);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -117178304);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 17104960);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1443364928);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 0x4050040);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -435748800);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -201064384);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 50659392);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -234618816);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -133955520);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -352059328);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -167509952);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -251396032);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -150732736);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -308526848);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -318504896);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -66846656);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 597508352);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, -586612672);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1594425408);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1627979840);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1711931456);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1577648192);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1611202624);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1258946624);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1081547584);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1299651392);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1266096960);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1098324800);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1131879232);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1148656448);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1165433664);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1249319744);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1198988096);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1215765312);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1232542528);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1282874176);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 1316428608);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1305144064, 319372544, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1305144064, 369704192);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1305144064, 386481408);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1305144064, 420035840);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1305144064, 453590272);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1305144064, 436813056);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1305144064, 252263680);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1288366848, 513622272);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1288366848, -308526848);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1288366848, 252263680);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1288366848, -301727680);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1288366848, -368836544);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1288366848, 638139648);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1338698496, 513622272);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1338698496, 352926976);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1338698496, -100401088);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1338698496, -352059328);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 235486464, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 118045952, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 336149760, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 269040896, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 722025728, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 738802944, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 755580160, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 839466240, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 151600384);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 252263680);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 403258624, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 168377600);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 352926976, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 503921920, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 487144704, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 520699136, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 654916864, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 671694080, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 688471296);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1338698496, 822689024, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 67714304, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 34159872, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 50937088, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 185154816);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 201932032);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 621362432);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 705248512);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 772357376, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1338698496, 789134592, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1321921280, 805911808, true);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1321921280, -352059328);
    }
}

