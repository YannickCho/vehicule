package org.eclipse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.Model.Colis;
import org.eclipse.Model.Personne;
import org.eclipse.Model.Vehicule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class ListeServlet
 */
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "from Vehicule where TYPE_VEHICULE = 'VOITURE'";
		Query query = session.createQuery(hql);
		List<Vehicule> voitures = (List<Vehicule>) query.list();		
		request.setAttribute("voitures", voitures);
		
		hql = "from Vehicule where TYPE_VEHICULE = 'CAMION'";
		query = session.createQuery(hql);
		List<Vehicule> camions = (List<Vehicule>) query.list();		
		request.setAttribute("camions", camions);
		
		hql = "from Personne";
		query = session.createQuery(hql);
		List<Personne> personnes = (List<Personne>) query.list();
		request.setAttribute("personnes", personnes);
		
		hql = "from Colis";
		query = session.createQuery(hql);
		List<Colis> colis = (List<Colis>) query.list();
		request.setAttribute("colis", colis);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		request.getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
