package aidemo.hiberAI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import SGcreate.CreateSG;
import employy.Employy;

public class App 
{
    public static void main( String[] args )
    {
    	
		  Configuration configuration = new Configuration().configure("cfg\\file\\hibernate.cfg.xml").addAnnotatedClass(CreateSG.class).addAnnotatedClass(Employy.class);
		  
	        SessionFactory sessionFactory = configuration.buildSessionFactory();

	        Session session = sessionFactory.openSession();
	        
	        session.beginTransaction();
	        
	        CreateSG obj=new CreateSG(1,"rinic","123456");
	        
			session.save(obj);
			
			Employy emp=new Employy(55,"sneha","jishnu");
			
	        session.save(emp);
	        
	        session.getTransaction().commit();
	        
	        session.close();

	        sessionFactory.close();
    }
}
