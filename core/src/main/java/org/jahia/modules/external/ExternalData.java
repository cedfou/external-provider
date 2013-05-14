/**
 * This file is part of Jahia, next-generation open source CMS:
 * Jahia's next-generation, open source CMS stems from a widely acknowledged vision
 * of enterprise application convergence - web, search, document, social and portal -
 * unified by the simplicity of web content management.
 *
 * For more information, please visit http://www.jahia.com.
 *
 * Copyright (C) 2002-2013 Jahia Solutions Group SA. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 * As a special exception to the terms and conditions of version 2.0 of
 * the GPL (or any later version), you may redistribute this Program in connection
 * with Free/Libre and Open Source Software ("FLOSS") applications as described
 * in Jahia's FLOSS exception. You should have received a copy of the text
 * describing the FLOSS exception, and it is also available here:
 * http://www.jahia.com/license
 *
 * Commercial and Supported Versions of the program (dual licensing):
 * alternatively, commercial and supported versions of the program may be used
 * in accordance with the terms and conditions contained in a separate
 * written agreement between you and Jahia Solutions Group SA.
 *
 * If you are unsure which license is appropriate for your use,
 * please contact the sales department at sales@jahia.com.
 */

package org.jahia.modules.external;

import javax.jcr.Binary;
import java.util.List;
import java.util.Map;

/**
 * External Data. Encapsulation of data for external provider
 */

public class ExternalData {
    private String id;
    private String path;
    private String type;
    private List<String> mixin;
    private Map<String,String[]> properties;
    private Map<String,Map<String,String[]>> i18nProperties;
    private Map<String,Binary[]> binaryProperties;

    public ExternalData(String id, String path, String type, Map<String, String[]> properties) {
        this.id = id;
        this.path = path;
        this.type = type;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }

    public Map<String,String[]> getProperties() {
        return properties;
    }

    public Map<String,Map<String,String[]>> getI18nProperties() {
        return i18nProperties;
    }

    public void setI18nProperties(Map<String, Map<String, String[]>> i18nProperties) {
        this.i18nProperties = i18nProperties;
    }

    public Map<String, Binary[]> getBinaryProperties() {
        return binaryProperties;
    }

    public void setBinaryProperties(Map<String, Binary[]> binaryProperties) {
        this.binaryProperties = binaryProperties;
    }

    public List<String> getMixin() {
        return mixin;
    }

    public void setMixin(List<String> mixin) {
        this.mixin = mixin;
    }
}