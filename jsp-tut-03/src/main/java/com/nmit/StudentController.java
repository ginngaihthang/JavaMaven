package com.nmit;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.nmit.entry.Batch;
import com.nmit.entry.Student;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/home","/students", "/student-add" , "/add-student", "/batch", "/add-batch"})
public class StudentController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext context = config.getServletContext();
		

		List<Batch> list = (ArrayList<Batch>) context.getAttribute("batches");
		if(list == null) 
			list = new ArrayList<Batch>();
		
		list.add(new Batch("batch 1", LocalDate.parse("2022-07-12")));
		list.add(new Batch("Batch 2" , LocalDate.parse("2022-08-23")));
		context.setAttribute("batches", list);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println("action anem: " + action);
		String title_value = "";
		String page = "";
		
		if("/students".equals(action)) {
			title_value = "Student";
			page = "/students.jsp";
		}
		else if("/student-add".equals(action)) {
			title_value = "Student|Add";
			page = "/student-add.jsp";
		}
		else if("/batch".equals(action)) {
			title_value = "Batch List";
			page = "/batch.jsp";
		}
		else if("/home".equals(action)) {
			title_value = "Home";
			page = "/index.jsp";
		}
		req.setAttribute("title", title_value);
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// batch
		String Batchname = req.getParameter("batchName");
		String start_date = req.getParameter("startDate");
		// get dat from parameter
		String name = req.getParameter("stdName");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String batchName = req.getParameter("batchs");
		String old_std = req.getParameter("old");
		// create student andt assign data
		Student new_student = new Student();
		new_student.setName(name);
		new_student.setPhone(phone);
		new_student.setEmail(email);
		new_student.setOldStudent(old_std == null ? false : true);
		new_student.setRegisterDate(LocalDate.now());
		new_student.setBatch(batchName);	
		//create batch dand assign data
		
		// get session obj 
		HttpSession session = req.getSession(true);
		
		//get or create student list from session ognect
		String action = req.getServletPath();
		System.out.println("name:  " +action);
		String data = "";
		if("/add-student".equals(action)) {
			List<Student> list1 = (ArrayList<Student>) session.getAttribute("students");
			if(list1 == null) 
				list1 = new ArrayList<Student>();
			list1.add(new_student);
			session.setAttribute("students", list1);
			data = "/students";
		}
		else if("/add-batch".equals(action)) {
			ServletContext context = getServletConfig().getServletContext();
			List<Batch> list = (ArrayList<Batch>) context.getAttribute("batches");
			if(list == null) 
				list = new ArrayList<Batch>();
			list.add(new Batch(Batchname, LocalDate.parse(start_date)));
			context.setAttribute("batches", list);
			data= "/batch";
		}
		//invoke
		resp.sendRedirect(req.getContextPath() + data);
	}
}
