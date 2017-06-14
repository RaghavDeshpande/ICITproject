package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.BranchBean;
import model.BranchGroupBean;
import model.GuestBean;
import model.ItemBean;
import model.ItemGroupBean;
import model.ItemRateBean;
import model.UserBean;
import pojo.BranchPojo;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String url = "";
		HttpSession session = request.getSession(true);
		try {
			String page = request.getParameter("page");
			System.out.println("Hiii");
			System.out.println(page);
			if (page.equalsIgnoreCase("authenticate")) {
				UserBean userBean = new UserBean(request.getParameter("userName"), request.getParameter("password"));
				if (userBean.authenticate()) {
					System.out.println(userBean.authenticate());
					url = "welcome.jsp";
					session.setAttribute("user", userBean);
				} else
					url = "login.html";
			} 
			//System.out.println("brnach------------------------------------------------------------------------------");
			else if (page.equalsIgnoreCase("branch")) {
				BranchBean bean = new BranchBean();
				List<Object> branchList = bean.getBranches();
				request.setAttribute("BranchList", branchList);
				url = "Branch.jsp";
			}
			 else if (page.equalsIgnoreCase("newbranch")) {

				int i = Integer.parseInt(request.getParameter("branchPhone"));
				BranchBean branchBean = new BranchBean(request.getParameter("branchId"),
						request.getParameter("branchName"), request.getParameter("branchAdd"), i);
				if (branchBean.addBranch() > 0) {
					url = "controller?page=branch";
				} else
					url = "login.html";
			}

			else if (page.equalsIgnoreCase("updateBranch")) {
				System.out.println(request.getParameter("branchid"));
				BranchBean bean = new BranchBean();
				bean.setBranchId(request.getParameter("branchid"));
				bean = bean.getBranch();
				request.setAttribute("branchBean", bean);
				url = "UpdateBranch.jsp";

			} 
			else if (page.equalsIgnoreCase("BranchUpdate")) {

				BranchBean bean = new BranchBean(request.getParameter("branchIdU"), request.getParameter("branchNameU"),
						request.getParameter("branchAddU"), Integer.parseInt(request.getParameter("branchPhoneU")));
				System.out.println(bean);
				System.out.println(bean.updateBranch());
				url = "controller?page=branch";
			}
			 else if (page.equalsIgnoreCase("deleteBranch")) {
				System.out.println(request.getParameter("branchid"));
				BranchBean bean = new BranchBean();
				bean.setBranchId(request.getParameter("branchid"));
				bean = bean.getBranch();
				request.setAttribute("branchBean", bean);
				url = "DeleteBranch.jsp";
			} 
			else if (page.equalsIgnoreCase("BranchDelete")) {
				BranchBean bean = new BranchBean();
				bean.setBranchId(request.getParameter("branchIdD"));
				bean.deleteBranch();
				url = "controller?page=branch";
			} 
			//System.out.println("item----------------------------------------------------------------------------------------");
				else if (page.equalsIgnoreCase("item")) {
				ItemBean bean = new ItemBean();
				List<Object> itemList = bean.getItems();
				request.setAttribute("ItemList", itemList);
				url = "Item.jsp";
			} 
			else if (page.equalsIgnoreCase("newitem")) {

				int i = Integer.parseInt(request.getParameter("vehicle"));

				ItemBean itemBean = new ItemBean(request.getParameter("itemId"), request.getParameter("itemDescriptor"),
						i, request.getParameter("itemGroupId"));
				if (itemBean.addItem() > 0) {
					url = "controller?page=item";
				} else
					url = "login.html";
			}

			else if (page.equalsIgnoreCase("updateItem")) {
				System.out.println(request.getParameter("itemid"));
				ItemBean bean = new ItemBean();
				bean.setItemId(request.getParameter("itemid"));
				bean = bean.getItem();
				request.setAttribute("itemBean", bean);
				url = "UpdateItem.jsp";

			} 
			else if (page.equalsIgnoreCase("ItemUpdate")) {
				
				ItemBean bean = new ItemBean(request.getParameter("itemId"), request.getParameter("itemDescriptor"),
						Integer.parseInt(request.getParameter("vehicle")),request.getParameter("itemGroupId"));
				System.out.println(bean);
				System.out.println(bean.updateItem());
				url = "controller?page=item";
			}
			else if (page.equalsIgnoreCase("deleteItem")) {
				System.out.println(request.getParameter("itemid"));
				ItemBean bean = new ItemBean();
				bean.setItemId(request.getParameter("itemid"));
				bean = bean.getItem();
				request.setAttribute("itemBean", bean);
				url = "DeleteItem.jsp";
			} 
			else if (page.equalsIgnoreCase("ItemDelete")) {
				ItemBean bean = new ItemBean();
				bean.setItemId(request.getParameter("itemIdD"));
				bean.deleteItem();
				url = "controller?page=item";
			}
			//System.out.println("item group---------------------------------------------------------------------------------------");
			else if (page.equalsIgnoreCase("itemgroup")) {
				ItemGroupBean bean = new ItemGroupBean();
				List<Object> itemGroupList = bean.getItemGroups();
				request.setAttribute("ItemGroupList", itemGroupList);
				url = "ItemGroup.jsp";
			} 
			else if (page.equalsIgnoreCase("newitemgroup")) {

				ItemGroupBean branchBean = new ItemGroupBean(request.getParameter("itemGroupId"),
						request.getParameter("description"));
				if (branchBean.addItemGroup() > 0) {
					url = "controller?page=itemgroup";
				} else
					url = "login.html";
			}

			else if (page.equalsIgnoreCase("updateItemGroup")) {
				System.out.println(request.getParameter("itemgroupid"));
				ItemGroupBean bean = new ItemGroupBean();
				bean.setItemGroupId(request.getParameter("itemgroupid"));
				bean = bean.getItemGroup();
				request.setAttribute("itemgroupBean", bean);
				url = "UpdateItemGroup.jsp";

			} 
			else if (page.equalsIgnoreCase("itemgroupupdate")) {

				ItemGroupBean bean = new ItemGroupBean(request.getParameter("itemGroupIdU"), request.getParameter("descriptionU"));
				System.out.println(bean.updateItemGroup());
				url = "controller?page=itemgroup";
			}
			else if (page.equalsIgnoreCase("deleteItemGroup")) {
				System.out.println(request.getParameter("itemgroupid"));
				ItemGroupBean bean = new ItemGroupBean();
				bean.setItemGroupId(request.getParameter("itemgroupid"));
				bean = bean.getItemGroup();
				request.setAttribute("itemgroupBean", bean);
				url = "DeleteItemGroup.jsp";
			}
			 else if (page.equalsIgnoreCase("ItemGroupDelete")) {
				ItemGroupBean bean = new ItemGroupBean();
				bean.setItemGroupId(request.getParameter("itemGroupIdD"));
				bean.deleteItemGroup();
				url = "controller?page=itemgroup";
			}
			//System.out.println("item rate---------------------------------------------------------------------------------------------");
				else if (page.equalsIgnoreCase("itemrate")) {
				ItemRateBean bean = new ItemRateBean();
				List<Object> itemRateList = bean.getItemRates();
				request.setAttribute("ItemRateList", itemRateList);
				url = "ItemRate.jsp";
			}

			else if (page.equalsIgnoreCase("newitemrate")) {
				ItemRateBean itemRateBean = new ItemRateBean(request.getParameter("branchGroupId"),
						request.getParameter("itemId"), request.getParameter("itemRate"));
				if (itemRateBean.addItemRate() > 0) {
					url = "controller?page=itemrate";
				} else
					url = "login.html";
			} else if (page.equalsIgnoreCase("updateitemRate")) {
				System.out.println(request.getParameter("itemratepid"));
				ItemRateBean bean = new ItemRateBean();
				bean.setBranchGroupId(request.getParameter("itemratepid"));
				bean = bean.getItem_Rate();
				request.setAttribute("itemrateBean", bean);
				url = "UpdateItemRate.jsp";

			} 
			else if (page.equalsIgnoreCase("itemRateUpdate")) {

				ItemRateBean bean = new ItemRateBean(request.getParameter("branchGroupId"),
						request.getParameter("itemId"), request.getParameter("itemRate"));
				System.out.println(bean);
				System.out.println(bean.updateItemRate());
				url = "controller?page=itemrate";
			} 
			else if (page.equalsIgnoreCase("deleteItemRate")) {
				System.out.println(request.getParameter("branchgroupid"));
				ItemRateBean bean = new ItemRateBean();
				bean.setBranchGroupId(request.getParameter("branchgroupid"));
				bean = bean.getItem_Rate();
				request.setAttribute("itemrateBean", bean);
				url = "DeleteItemRate.jsp";
			}
			 else if (page.equalsIgnoreCase("ItemRateDelete")) {
				ItemRateBean bean = new ItemRateBean();
				bean.setBranchGroupId(request.getParameter("branchGroupId"));
				bean.deleteItemRate();
				url = "controller?page=itemrate";
			}
			//System.out.println("branch group------------------------------------------------------------------------------------");
				else if (page.equalsIgnoreCase("branchgroup")) {
				BranchGroupBean bean = new BranchGroupBean();
				List<Object> branchgroupList = bean.getBranchGroups();
				request.setAttribute("BranchGroupList", branchgroupList);
				url = "BranchGroup.jsp";
			} 

			else if (page.equalsIgnoreCase("newbranchgroup")) {
				BranchGroupBean branchGroupBean = new BranchGroupBean(request.getParameter("branchGroupId"), request.getParameter("branchId1"),request.getParameter("branchId2"),request.getParameter("splFerryTime"));
				if (branchGroupBean.addBranchGroup()> 0) {
					url = "controller?page=branchgroup";
				} else
					url = "login.html";
			}

			else if (page.equalsIgnoreCase("updateBranchGroup")) {
				System.out.println(request.getParameter("branchgroupid"));
				BranchGroupBean bean = new BranchGroupBean();
				bean.setBranchGroupId(request.getParameter("branchgroupid"));
				bean = bean.getBranchGroup();
				request.setAttribute("branchGroupBean", bean);
				url = "UpdateBranchGroup.jsp";

			} 
			else if (page.equalsIgnoreCase("BranchGroupUpdate")) {

				BranchGroupBean bean = new BranchGroupBean(request.getParameter("branchGroupIdU"), request.getParameter("branchId1U"), request.getParameter("branchId2U"), request.getParameter("splFerryTimeU"));
				System.out.println(bean.updateBranchGroup());
				url = "controller?page=branchgroup";
			}
			else if (page.equalsIgnoreCase("deleteBranchGroup")) {
				System.out.println(request.getParameter("branchgroupid"));
				BranchGroupBean bean = new BranchGroupBean();
				bean.setBranchGroupId(request.getParameter("branchgroupid"));
				bean = bean.getBranchGroup();
				request.setAttribute("branchgroupBean", bean);
				url = "DeleteBranchGroup.jsp";
			} 
			else if (page.equalsIgnoreCase("BranchGroupDelete")) {
				BranchGroupBean bean = new BranchGroupBean();
				bean.setBranchGroupId(request.getParameter("branchGroupIdD"));
				bean.deleteBranchGroup();
				url = "controller?page=branchgroup";
			}
			//System.out.println("guest------------------------------------------------------------------------------");
			else if (page.equalsIgnoreCase("guest")) {
				GuestBean bean = new GuestBean();
				List<Object> guestList = bean.getGuests();
				request.setAttribute("GuestList", guestList);
				url = "Guest.jsp";
			}
			else if (page.equalsIgnoreCase("newguest")) {
				GuestBean guestBean = new GuestBean(request.getParameter("guestId"),request.getParameter("guestName"), request.getParameter("guestAddress"));
				if (guestBean.addGuest() > 0) {
					url = "controller?page=guest";
				} else
					url = "login.html";
			}
			else if (page.equalsIgnoreCase("updateguest")) {
				System.out.println(request.getParameter("guestid"));
				GuestBean bean = new GuestBean();
				bean.setGuestId(request.getParameter("guestid"));
				bean = bean.getGuest();
				request.setAttribute("branchgroupBean", bean);
				url = "UpdateGuest.jsp";

			} 
			else if (page.equalsIgnoreCase("guestUpdate")) {

				GuestBean bean = new GuestBean(request.getParameter("guestId"), request.getParameter("guestName"),
						request.getParameter("guestAddress"));
				System.out.println(bean);
				System.out.println(bean.updateGuest());
				url = "controller?page=guest";
			} 
			else if (page.equalsIgnoreCase("deleteGuest")) {
				System.out.println(request.getParameter("guestid"));
				GuestBean bean = new GuestBean();
				bean.setGuestId(request.getParameter("guestid"));
				bean = bean.getGuest();
				request.setAttribute("guestBean", bean);
				url = "DeleteGuest.jsp";
			} 
			else if (page.equalsIgnoreCase("GuestDelete")) {
				GuestBean bean = new GuestBean();
				bean.setGuestId(request.getParameter("guestIdD"));
				bean.deleteGuest();
				url = "controller?page=guest";
			}
			rd = request.getRequestDispatcher(url);
			rd.forward(request, response);

		} 
			catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
