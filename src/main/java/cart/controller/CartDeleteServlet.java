package cart.controller;

import java.io.IOException;
import java.util.List;

import cart.model.dto.ProductDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/product/cart/delete")
public class CartDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		List<ProductDTO> cart = (List<ProductDTO>)session.getAttribute("cart");
		String index=req.getParameter("index");
		cart.remove(Integer.parseInt(index));
		session.setAttribute("cart", cart);
		if(cart.size()==0) {
			session.setAttribute("cart", null);
			
		}
		resp.sendRedirect("/JavaWebCart/product/cart");
	}

}
