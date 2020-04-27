package application;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

import org.hibernate.HibernateException;

import application.exceptions.MainException;
import model.entities.Pessoa;

public class Main {

	public static void main(String args[]) {
		System.out.println();
		System.out.println("==== init prog: main()");

		try {

//			iniciarAula("aula298_exemplo99");
//			iniciarAula("aula298_exemplo01");
//			iniciarAula("aula298_exemplo02");
			iniciarAula("aula298_exemplo03");
//			iniciarAula("aula298_exemplo04");
//			iniciarAula("aula298_exemplo05");

		} catch (HibernateException | MainException e) {
			System.out.println("Error while executing program. Cause: " + e.getMessage());
		}

		System.out.println();
		System.out.println("==== end prog: main()");

	}

	private static void iniciarAula(String aula) {

		switch (aula) {

		case "aula298_exemplo01": {
			Pessoa p1 = new Pessoa(1, "Flavio", "flavio@gmail.com");
			Pessoa p2 = new Pessoa(2, "Eduardo", "eduardo@gmail.com");
			Pessoa p3 = new Pessoa(3, "Mito", "mito@gmail.com");

			System.out.println();
			System.out.println(p1);
			System.out.println(p2);
			System.out.println(p3);

			break;
		}

		case "aula298_exemplo02": {
			Pessoa p1 = new Pessoa(null, "Flavio", "flavio@gmail.com");
			Pessoa p2 = new Pessoa(null, "Eduardo", "eduardo@gmail.com");
			Pessoa p3 = new Pessoa(null, "Mito", "mito@gmail.com");

			EntityManagerFactory emf = null;
			EntityManager em = null;

			try {

				emf = Persistence.createEntityManagerFactory("AulaJPA");
				em = emf.createEntityManager();

				em.getTransaction().begin();
				em.persist(p1);
				em.persist(p2);
				em.persist(p3);
				em.getTransaction().commit();
				System.out.println("Done! Check pessoa's table by SQL query!");

			} catch (IllegalStateException | EntityExistsException | TransactionRequiredException
					| RollbackException e) {
				throw new HibernateException("HibernateException: " + e.getMessage());
			} finally {
				em.close();
				emf.close();
			}

			break;
		}

		case "aula298_exemplo03": {

			EntityManagerFactory emf = null;
			EntityManager em = null;
			Pessoa pessoa = null;

			try {

				emf = Persistence.createEntityManagerFactory("AulaJPA");
				em = emf.createEntityManager();

				pessoa = em.find(Pessoa.class, 3);

				System.out.println("Pessoa = " + pessoa);

			} catch (IllegalStateException | IllegalArgumentException e) {
				throw new HibernateException("HibernateException: " + e.getMessage());
			} finally {
				em.close();
				emf.close();
			}

			break;
		}

		case "aula298_exemplo04": {

			EntityManagerFactory emf = null;
			EntityManager em = null;
			Pessoa pessoa = new Pessoa(2, "Mito", "mito@gmail.com");

			try {

				emf = Persistence.createEntityManagerFactory("AulaJPA");
				em = emf.createEntityManager();

				em.getTransaction().begin();
				em.remove(pessoa);
				em.getTransaction().commit();
				System.out.println("Done! Check pessoa's table by SQL query!");

			} catch (IllegalStateException | IllegalArgumentException | TransactionRequiredException
					| RollbackException e) {
				throw new HibernateException("HibernateException: " + e.getMessage());
			} finally {
				em.close();
				emf.close();
			}

			break;
		}

		case "aula298_exemplo05": {

			EntityManagerFactory emf = null;
			EntityManager em = null;

			try {

				emf = Persistence.createEntityManagerFactory("AulaJPA");
				em = emf.createEntityManager();

				em.getTransaction().begin();
				em.remove(em.find(Pessoa.class, 3));
				em.getTransaction().commit();
				System.out.println("Done! Check pessoa's table by SQL query!");

			} catch (IllegalStateException | IllegalArgumentException | TransactionRequiredException
					| RollbackException e) {
				throw new HibernateException("HibernateException: " + e.getMessage());
			} finally {
				em.close();
				emf.close();
			}

			break;
		}

		default:
			throw new MainException("Aula selecionada não existe no código do programa!");

		}

	}

}
