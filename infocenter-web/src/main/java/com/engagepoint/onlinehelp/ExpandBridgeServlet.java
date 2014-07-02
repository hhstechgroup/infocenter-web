package com.engagepoint.onlinehelp;

import org.eclipse.equinox.servletbridge.BridgeServlet;
import org.eclipse.equinox.servletbridge.FrameworkLauncher;

import javax.servlet.ServletException;
import java.lang.reflect.Field;

/**
 * Created by ykukharskyi on 01.07.14.
 */
public class ExpandBridgeServlet extends BridgeServlet {

    public void destroy() {
        try {
            Field framework = super.getClass().getDeclaredField("framework");
            framework.setAccessible(true);
            FrameworkLauncher frameworkLauncher = new FrameworkLauncher();
//            undeploy((FrameworkLauncher) framework.get(frameworkLauncher));
            framework.get(frameworkLauncher);
            frameworkLauncher.undeploy();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        super.destroy();
    }
//    private void undeploy(FrameworkLauncher fl) {
//        fl.undeploy();
//    }
}
