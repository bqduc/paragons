/**
 * 
 */
package net.paramount.framework.controller;

import net.paramount.framework.model.FilterBase;

/**
 * @author bqduc
 *
 */
public abstract class Home <E, F extends FilterBase> extends RootController {
	private static final long serialVersionUID = -3418849331359820691L;

	//protected abstract E buildNoneObject();
	/*@Inject
	protected FacesUtilities facesUtilities;*/

	final public String delete() {
		return deleteSelectedObject();
	}

	protected String deleteSelectedObject() {
		return "success";
	}
}
