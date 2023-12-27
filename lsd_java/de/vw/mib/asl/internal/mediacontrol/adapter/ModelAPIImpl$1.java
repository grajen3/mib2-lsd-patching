/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.adapter.ModelAPIImpl;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.ViewBrowser;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.devicelist.ViewDeviceList;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.opendevice.ViewOpenDevice;

class ModelAPIImpl$1
implements ASLComponentAPICallback {
    private final /* synthetic */ ModelAPIImpl this$0;

    ModelAPIImpl$1(ModelAPIImpl modelAPIImpl) {
        this.this$0 = modelAPIImpl;
    }

    @Override
    public void registered(Class clazz, Object object) {
        ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
        ModelAPIImpl.access$002(this.this$0, (MediaControlAPI)aSLComponentRegistry.getAPIInstance(ModelAPIImpl.class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI == null ? (ModelAPIImpl.class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI = ModelAPIImpl.class$("de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI")) : ModelAPIImpl.class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI));
        ModelAPIImpl.access$100(this.this$0, new ViewOpenDevice(ModelAPIImpl.access$000(this.this$0)));
        ModelAPIImpl.access$200(this.this$0, new ViewDeviceList(ModelAPIImpl.access$000(this.this$0)));
        ModelAPIImpl.access$300(this.this$0, new ViewBrowser(ModelAPIImpl.access$000(this.this$0)));
        ServiceManager.aslPropertyManager.valueChangedInteger(1681, 1);
    }
}

