package com.factory.main;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.chemical.model.Chemical;


public class HibernateTest {

	public static void main(String[] args) {
		
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();	
			
			Scanner scan=new Scanner(System.in);
			System.out.println("input the case for create give 1 update 2 delete 3");
			switch(scan.nextInt())
			{
			case 1:
			{
				System.out.println("How many input You give");
				int i=scan.nextInt();
				while(i-->0)
				{	
					Chemical chem=new Chemical();
					System.out.println("enter the atomic weight of chemical");
					chem.setAtomicWeight(scan.nextDouble());
					System.out.println("enter the name of chemical");
					chem.setChemicalName(scan.next());
					System.out.println("enter the chemical symbol");
					chem.setChemicalSymbol(scan.next());
					session.save(chem);
					
				}
				
				break;
			}
			case 2:
			{
				System.out.println("row you want to update enter the respective atomic weight");
				Chemical chem=(Chemical)session.get(Chemical.class,scan.nextDouble());
				System.out.println("enter the chemical name");
				chem.setChemicalName(scan.next());
				System.out.println("enter the chemical symbol");
				chem.setChemicalSymbol(scan.next());
				session.update(chem);
				break;
			}
			case 3:
			{
				System.out.println("row you want to delete enter the respective atomic weight");
				Chemical chem=(Chemical)session.get(Chemical.class,scan.nextDouble());
				session.delete(chem);
				break;
			}
			default:
			{
				System.out.println("wrong input");
			}
			
			}
			Criteria criteria = session.createCriteria(Chemical.class);
			List<Chemical> list = criteria.list();
			for(Chemical test: list) {
			    System.out.println(test.getChemicalName() + " " + test.getChemicalSymbol() + " " + test.getAtomicWeight());
			}
			tx.commit();
			session.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
