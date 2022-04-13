package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Model.Camion;
import org.eclipse.Model.Vehicule;
import org.eclipse.Model.Voiture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class AjoutVehiculeServlet
 */
public class AjoutVehiculeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutVehiculeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String immatriculation = request.getParameter("immatriculation");
		String type = request.getParameter("type");
		int nbPortes = Integer.parseInt(request.getParameter("nbPortes"));
		int volume = Integer.parseInt(request.getParameter("volume"));
		
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		
		if (type.equals("Voiture")) {
			Voiture vehicule = new Voiture();
			vehicule.setNbPortes(nbPortes);
			vehicule.setImmatriculation(immatriculation);
			session.persist(vehicule);
		}
		else {
			Camion vehicule = new Camion();
			vehicule.setVolume(volume);
			vehicule.setImmatriculation(immatriculation);
			session.persist(vehicule);
		}
		
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
