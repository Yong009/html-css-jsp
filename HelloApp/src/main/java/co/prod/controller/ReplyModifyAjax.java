package co.prod.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.ReplyVO;

public class ReplyModifyAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String rid = request.getParameter("replyNo");
		String content = request.getParameter("replyContent");
		
		
		
		ReplyVO vo = new ReplyVO();
		vo.setReplyNo(Integer.parseInt(rid));
		vo.setReplyContent(content);
		
		System.out.println(vo);
		
		ProductService service = new ProductServiceImpl();
			
	   boolean result =service.modifyReply(vo);
	   ReplyVO reply = new ReplyVO();
	   reply = service.getReply(Integer.parseInt(rid));
	   
	   Map<String,Object> resultMap = new HashMap<>();
	   if(result) {
		   resultMap.put("retCode", "Success");
		   resultMap.put("reply", reply);
	   } else {
		   resultMap.put("retCode", "Fail");
		   resultMap.put("reply", null);
	   }
		System.out.println(reply);		
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(resultMap); 
		
		
		return json+".ajax";
	}

}
