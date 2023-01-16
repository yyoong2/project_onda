package com.itwillbs.menu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.menu.db.MenuDAO;
import com.itwillbs.menu.db.MenuDTO;

public class FoodList implements Action{


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FoodList 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		String menu_category = request.getParameter("menu_category");
		System.out.println("카테고리: "+ menu_category);
	
		MenuDAO dao = new MenuDAO();
		
		List<MenuDTO> foodList =dao.FoodList(menu_category);


	
		request.setAttribute("foodList",foodList);
		System.out.println(foodList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./menu/foodList.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
