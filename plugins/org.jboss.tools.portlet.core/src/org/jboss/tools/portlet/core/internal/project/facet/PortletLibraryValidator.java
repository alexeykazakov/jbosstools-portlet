/*************************************************************************************
 * Copyright (c) 2008-2014 Red Hat, Inc. and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     JBoss by Red Hat - Initial implementation.
 ************************************************************************************/
package org.jboss.tools.portlet.core.internal.project.facet;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jst.common.project.facet.core.libprov.user.KeyClassesValidator;
import org.eclipse.jst.common.project.facet.core.libprov.user.UserLibraryProviderInstallOperationConfig;
import org.jboss.tools.portlet.core.Messages;
import org.jboss.tools.portlet.core.PortletCoreActivator;

/**
 * 
 * @author snjeza
 *
 */
public class PortletLibraryValidator extends KeyClassesValidator {

	@Override
	public IStatus validate(UserLibraryProviderInstallOperationConfig config) {
		IStatus status = super.validate(config);
		if (status.getSeverity() == IStatus.OK)
			return status;
		
		String message = Messages.PortletLibraryValidator_MISSING_PORTLET_IMPLEMENTATION_CLASSES;
		return new Status( IStatus.ERROR, PortletCoreActivator.PLUGIN_ID, message );

	}

}
