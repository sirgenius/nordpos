/**
 *
 * NORD POS is a fork of Openbravo POS.
 *
 * Copyright (C) 2009-2013 Nord Trading Ltd. <http://www.nordpos.com>
 *
 * This file is part of NORD POS.
 *
 * NORD POS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * NORD POS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * NORD POS. If not, see <http://www.gnu.org/licenses/>.
 */
package com.nordpos.server.jetty;

import java.io.File;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 * @version NORD POS 3
 */
public class AppContextBuilder {

    private WebAppContext webAppContext;

    public WebAppContext buildWebAppContext(String context, String folder, String name) {
        webAppContext = new WebAppContext();
        if (!name.equals("ROOT")) {
            webAppContext.setContextPath(context.concat(name));
        }
        webAppContext.setExtractWAR(true);
        webAppContext.setWar(new File(folder.concat("/" + name)).getAbsolutePath());
        webAppContext.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/[^/]*taglibs.*\\.jar$");
        webAppContext.setAttribute("webContext", webAppContext);
        return webAppContext;
    }
}
