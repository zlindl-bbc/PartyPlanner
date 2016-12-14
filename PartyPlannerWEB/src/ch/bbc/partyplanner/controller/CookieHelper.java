package ch.bbc.partyplanner.controller;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {

	public void setLoggedInCookie(String userId, int expiry, FacesContext facesContext) {
		Cookie cookie = null;
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		Cookie[] userCookies = request.getCookies();

		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("userId")) {
					cookie = userCookies[i];
					break;
				}
			}
		}

		if (cookie != null) {
			cookie.setMaxAge(0);
			cookie.setValue("");
			response.addCookie(cookie);
		}
		cookie = new Cookie("userId", userId);
		cookie.setPath(request.getContextPath());

		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
	}

	public int getUserIdCookie(FacesContext facesContext) {
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Cookie cookie = null;

		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("userId")) {
					cookie = userCookies[i];
				}
			}
		}

		if (cookie != null) {
			System.out.println("UserID = " + cookie.getValue());
			return Integer.parseInt(cookie.getValue());
		} else {
			return 0;
		}

	}
}
