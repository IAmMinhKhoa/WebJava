package dochoi.webmvc.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dochoi.webmvc.model.Item;
import dochoi.webmvc.model.Order;
import dochoi.webmvc.model.Product;
import dochoi.webmvc.service.ProductService;
import dochoi.webmvc.service.impl.ProductServiceImpl;

public class DeleteProductInCartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService productservice = new ProductServiceImpl();
	DecimalFormat df = new DecimalFormat("#.000");
	DecimalFormat df1 = new DecimalFormat("#.0");
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		HttpSession session = req.getSession(true);
		Product product = productservice.get(Integer.parseInt(id));
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		for(Item item: listItems)
		{
			if(Integer.parseInt(item.getProduct().getId()) == Integer.parseInt(product.getId()))
			{
				order.setSumPrice(order.getSumPrice() - item.getPrice());
				listItems.remove(item);
				session.setAttribute("length_order",(int)session.getAttribute("length_order")-1);
				break;
			}
		}
		order.setItems(listItems);
		session.setAttribute("order", order);
		resp.sendRedirect(req.getContextPath() + "/view/client/cart");
		if(order.getSumPrice() == 0)
		{
			session.setAttribute("sumprice", "0");
			
		} else {
			session.setAttribute("sumprice", df.format(order.getSumPrice()));
		}
		
	}
}
