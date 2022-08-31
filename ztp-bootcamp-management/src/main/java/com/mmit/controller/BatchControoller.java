package com.mmit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mmit.model.entity.Batch;
import com.mmit.model.service.BatchService;
import com.mmit.model.service.LevelService;
@WebServlet(urlPatterns = {"/batches","/add-batch","/edit-batch"})
public class BatchControoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BatchService batchservice;
    private LevelService levelservice;
	
    @Override
    public void init() throws ServletException {
    	
    	super.init();
    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj == null) {
			emf_obj = Persistence.createEntityManagerFactory("ztp");
			getServletContext().setAttribute("emf", emf_obj);
		}
		batchservice = new BatchService(emf_obj.createEntityManager());
		levelservice = new LevelService(emf_obj.createEntityManager());
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    	EntityManagerFactory emf_obj = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf_obj != null && emf_obj.isOpen()) {
			emf_obj.close();
		}
    }
    public BatchControoller() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		var action = request.getServletPath();
		
		if("/batches".equals(action)) {
			goHomePage(request, response);
		}
		else if("/add-batch".equals(action) || "/edit-batch".equals(action)) {
			goAddPage(request, response);
		}
	}

	
	private void goAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var batchId = request.getParameter("id");
		var obj = (batchId == null) ? new Batch() : batchservice.FindById(Integer.parseInt(batchId));
		//var obj = new Batch();
		var list = levelservice.findAll();
		request.setAttribute("title", "Batch");
		request.setAttribute("batch", obj);
		request.setAttribute("levels", list);
		getServletContext().getRequestDispatcher("/batch-add.jsp").forward(request, response);
	}

	private void goHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var id = request.getParameter("levelId");
		var list = id == null ? batchservice.findAll() : batchservice.findByLevelId(Integer.parseInt(id));

		request.setAttribute("title", "Batch");
		
		request.setAttribute("batches", list);
;
		getServletContext().getRequestDispatcher("/batch-home.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var id = request.getParameter("batchId");
		var batch = ("0".equals(id) ? new Batch() : batchservice.FindById(Integer.parseInt(id)));
		batch.setLevel(levelservice.findById(Integer.parseInt(request.getParameter("level"))));
		batch.setName(request.getParameter("name"));
		batch.setStartDate(LocalDate.parse(request.getParameter("startDate")));
		
		batchservice.save(batch);
		
		response.sendRedirect(request.getContextPath().concat("/batches"));
	}

}
