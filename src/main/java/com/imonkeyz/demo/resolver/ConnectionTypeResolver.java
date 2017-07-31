package com.imonkeyz.demo.resolver;

import net.jawr.web.resource.bundle.variant.VariantResolver;
import net.jawr.web.resource.bundle.variant.VariantSet;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jesse.Zhou on 2017/1/9 0009.
 */
public class ConnectionTypeResolver implements VariantResolver {


    public String getVariantType() {
        return "connectionType";
    }

    public String getAvailableVariant(String s, VariantSet variantSet) {
        System.out.println(" get available variant ");
        return null;
    }

    public String resolveVariant(HttpServletRequest request) {
        String connectionType = "";
        if(request.getScheme().equals("https")) {
            connectionType = "ssl";
        }
        System.out.println(request.getRequestURL());
        System.out.println(" resolve ...");
        return connectionType;
    }
}
