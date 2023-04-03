package co.prod.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.MembersService;
import co.prod.service.MembersServiceImpl;
import co.prod.vo.MembersVO;

public class MembersAddJquery implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(pass);
		System.out.println(addr);
		System.out.println(tel);
		
		MembersVO vo = new MembersVO();
		vo.setMemberId(id);
		vo.setMemberPw(pass);
		vo.setMemberName(name);
		vo.setMemberAddr(addr);
		vo.setMemberTel(tel);
		
		System.out.println(vo);
		
		MembersService service = new MembersServiceImpl();
		
		boolean result = service.addMembers(vo);
		
		Map<String,Object> resultMap = new HashMap<>();
		if(result) {
			resultMap.put("retCode", "Success");
			resultMap.put("reply", vo);
		} else {
			resultMap.put("retCode", "Fail");
			resultMap.put("reply", null);
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(resultMap);
		
				
		return json+".ajax";
	}

}
