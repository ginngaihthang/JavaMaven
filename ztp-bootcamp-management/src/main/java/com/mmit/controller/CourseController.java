package com.mmit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mmit.model.entity.Course;
import com.mmit.model.service.CourseService;
import com.mmit.model.service.LevelService;
@WebServlet(urlPatterns = {"/courses","/add-course","/edit-course","/delete-course"})
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourseService courseService;
    private LevelService levelService;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj == null) {
			emf_obj = Persistence.createEntityManagerFactory("ztp");
			getServletContext().setAttribute("emf", emf_obj);
		}
		courseService = new CourseService(emf_obj.createEntityManager());
		levelService = new LevelService(emf_obj.createEntityManager());
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj != null && emf_obj.isOpen()) {
			emf_obj.close();
		}
    }
    
    public CourseController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		var action = request.getServletPath();
		
		if("/courses".equals(action)) {
			goHomePage(request, response);
		}
		else if("/add-course".equals(action) || "/edit-course".equals(action)) {
			goAddPage(request, response);
		}
		else if("/delete-course".equals(action) ) {
			deleteCourse(request, response);
		}
	}

	
	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var id = request.getParameter("id");
		//delete from db
		courseService.deleById(Integer.parseInt(id));
		//redirect
		response.sendRedirect(request.getContextPath().concat("/courses"));
		
	}

	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var id = request.getParameter("id");
		var obj =  (id == null ? new Course() : courseService.findById(Integer.parseInt(id)));
		var list = levelService.findAll();
		request.setAttribute("title", "Course");
		request.setAttribute("course", obj); 
		request.setAttribute("levels", list);
		getServletContext().getRequestDispatcher("/course-add.jsp").forward(request, response);
	}

	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var id = request.getParameter("levelId");
		var list = (id == null) ? courseService.findAll() : courseService.FindByLevelId(Integer.parseInt(id));
		request.setAttribute("title", "Course");
		request.setAttribute("courses", list);
		getServletContext().getRequestDispatcher("/course-home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 var id = request.getParameter("courseId");
		 var course = ("0".equals(id) ? new Course() : courseService.findById(Integer.parseInt(id)));
		 course.setName(request.getParameter("name"));
		 course.setLevel(levelService.findById(Integer.parseInt(request.getParameter("level"))));
		 course.setContent(request.getParameter("content"));
		 
		 courseService.save(course);
		 
		 response.sendRedirect(request.getContextPath().concat("/courses"));
	}

}
