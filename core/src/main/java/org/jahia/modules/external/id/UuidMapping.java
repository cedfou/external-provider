/**
 * This file is part of Jahia, next-generation open source CMS:
 * Jahia's next-generation, open source CMS stems from a widely acknowledged vision
 * of enterprise application convergence - web, search, document, social and portal -
 * unified by the simplicity of web content management.
 *
 * For more information, please visit http://www.jahia.com.
 *
 * Copyright (C) 2002-2014 Jahia Solutions Group SA. All rights reserved.
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

package org.jahia.modules.external.id;

import javax.persistence.*;

import org.hibernate.annotations.Index;

/**
 * Map that link valid uuid and (@link org.jahia.services.content.impl.external.ExternalData} id
 */
@Entity
@Table(name = "jahia_external_mapping")
public class UuidMapping {

    private String internalUuid;
    private String providerKey;
    private String externalId;

    public UuidMapping() {
    }

    @Id
    @Column(length = 36, nullable = false)
    public String getInternalUuid() {
        return internalUuid;
    }

    public void setInternalUuid(String internalUuid) {
        this.internalUuid = internalUuid;
    }

    @Column(nullable = false)
    @Index(name = "jahia_external_mapping_index1")
    public String getProviderKey() {
        return providerKey;
    }

    public void setProviderKey(String providerKey) {
        this.providerKey = providerKey;
    }

    @Lob
    @Column(nullable = false)
    public String getExternalId() {
        return externalId;
    }

    @Column()
    @Index(name = "jahia_external_mapping_index1")
    public int getExternalIdHash() {
        return externalId != null ? externalId.hashCode() : 0;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setExternalIdHash(int externalIdHash) {
        // do nothing
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UuidMapping that = (UuidMapping) o;

        if (externalId != null ? !externalId.equals(that.externalId) : that.externalId != null) return false;
        if (providerKey != null ? !providerKey.equals(that.providerKey) : that.providerKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = providerKey != null ? providerKey.hashCode() : 0;
        result = 31 * result + (externalId != null ? externalId.hashCode() : 0);
        return result;
    }
}
