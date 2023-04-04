package co.prod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.MembersService;
import co.prod.service.MembersServiceImpl;

public class MemberRemoveJquery implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String[] members = request.getParameterValues("memberId");

		for (String member : members) {
			System.out.println(member);
		}
		MembersService service = new MembersServiceImpl();
		service.removeMembers(members);

		String json = "{\"retCode\" : \"Success\"}";

		return json + ".ajax";

	}
}
