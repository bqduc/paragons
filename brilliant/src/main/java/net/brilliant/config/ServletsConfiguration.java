/**
 * 
 */
package net.brilliant.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.brilliant.servlet.InventoryImageServlet;
import net.brilliant.servlet.ServletConstants;
import net.brilliant.servlet.UserProfileImageServlet;

/**
 * @author bqduc
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Configuration
public class ServletsConfiguration {

	@Bean
	public ServletRegistrationBean delegateInventoryImageServlet() {
		return new ServletRegistrationBean(new InventoryImageServlet(), ServletConstants.inventoryImageUrlMapping);
	}

	@Bean
	public ServletRegistrationBean<UserProfileImageServlet> delegateUserProfileImageServlet() {
		return new ServletRegistrationBean(new UserProfileImageServlet(), ServletConstants.userProfileImageUrlMapping);
	}
}