/**
 * 
 */
package net.brilliant.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import net.brilliant.framework.component.ComponentBase;

/**
 * @author ducbq
 *
 */
@Component
public class SystemEventManagement extends ComponentBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7564662407839189753L;

	/*@Inject
	private AuthDataDispatchRepositoryHelper dataServiceDispatchHelper;*/
	//private DataServiceDispatchHelper dataServiceDispatchHelper;

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReadyEventListener() {
		try {
			//dataServiceDispatchHelper.dispatch();
		} catch (Exception e) {
			log.error(e);
		}
		log.info("Leave onApplicationReadyEventListener");
	}
	
}
