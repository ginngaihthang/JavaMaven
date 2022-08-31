package com.mmit.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mmit.model.entity.Bootcamper;
import com.mmit.model.service.BatchService;
import com.mmit.model.service.BootcamperService;

@WebServlet(urlPatterns = {"/bootcampers","/add-bootcamper","/edit-bootcamper"})
public class BootcamperController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    private BootcamperService bootcampService;
    private BatchService batchService;
	
    @Override
    public void init() throws ServletException {
    	
    	super.init();
    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj == null) {
			emf_obj = Persistence.createEntityManagerFactory("ztp");
			getServletContext().setAttribute("emf", emf_obj);
		}
		bootcampService = new BootcamperService(emf_obj.createEntityManager());
		batchService = new BatchService(emf_obj.createEntityManager());

    }
    
    @Override
    public void destroy() {
    	super.destroy();
    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj != null && emf_obj.isOpen()) {
			emf_obj.close();
		}
		
    }
    public BootcamperController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getServletPath();
		
		if("/bootcampers".equals(action)) {
			goHomePage(request, response);
		}
		else if("/add-bootcamper".equals(action) || "/edit-bootcamper".equals(action)) {
			goAddPage(request, response);
		}
	}


	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var id = request.getParameter("id");
		var obj = (id == null) ? new Bootcamper() : bootcampService.findById(Integer.parseInt(id));
		var list = batchService.findAll();
		request.setAttribute("title", "Bootcamper");
		request.setAttribute("bootcamper", obj);
		request.setAttribute("batches", list);
		
		getServletContext().getRequestDispatcher("/bootcamper-add.jsp").forward(request, response);
		
	}

	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var id = request.getParameter("bootcampId");
		var list = id == null ? bootcampService.findAll() : bootcampService.findByBatchId(Integer.parseInt(id));
		//var list = new Bootcamper();
		request.setAttribute("title", "Bootcamper");
		request.setAttribute("bootcampers", list);
		
		getServletContext().getRequestDispatcher("/bootcamper-home.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var id = request.getParameter("bootId");
		var boot = ("0".equals(id)) ? new Bootcamper() : bootcampService.findById(Integer.parseInt(id));
		boot.setBatch(batchService.FindById(Integer.parseInt(request.getParameter("batch"))));
		boot.setName(request.getParameter("name"));
		boot.setEmail(request.getParameter("email"));
		boot.setPhone(request.getParameter("phone"));
		
		bootcampService.save(boot);
		
		response.sendRedirect(request.getContextPath().concat("/bootcampers"));
	}

}
