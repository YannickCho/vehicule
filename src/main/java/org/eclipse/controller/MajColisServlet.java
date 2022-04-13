package org.eclipse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Model.Camion;
import org.eclipse.Model.Colis;
import org.eclipse.Model.Personne;
import org.eclipse.Model.Vehicule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class MajColisServlet
 */
public class MajColisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajColisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Colis colis = session.get(Colis.class, id);
		request.setAttribute("colis", colis);
		
		String hql = "from Vehicule where TYPE_VEHICULE = 'CAMION'";
		Query query = session.createQuery(hql);
		List<Camion> camions = (List<Camion>) query.list();		
		request.setAttribute("camions", camions);
		
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		request.getRequestDispatcher("/WEB-INF/majColis.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int nature = Integer.parseInt(request.getParameter("nature"));
		int idCamion = Integer.parseInt(request.getParameter("idCamion"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Colis colis = session.get(Colis.class, id);
		colis.setNature(nature);
		colis.getCamion().removeColis(colis);
		Camion camion = session.get(Camion.class, idCamion);
		camion.addColis(colis);
		session.persist(colis);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		request.getRequestDispatcher("/liste").forward(request, response);
	}

}
