package aplicativo;

import dominio.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

  public static void main(String[] args) {
//    Pessoa p1 = new Pessoa(null, "Antenor", "antenor@gmail.com");
    Pessoa p2 = new Pessoa(null, "Felipe", "felipe@gmail.com");
    Pessoa p3 = new Pessoa(null, "Pedro", "pedro@gmail.com");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    EntityManager em = emf.createEntityManager();


    em.getTransaction().begin();
    em.persist(p2); // criação
    em.persist(p3);
    em.getTransaction().commit();

    // em.find(Pessoa.class, id) // encontra no banco de dados

    // Para remover um item, ele precisa ser monitorado e não destacado. Isto é, precisa
    // ser o último item a ser add no DB ou precisa ser buscado com o findById.

//    Pessoa p = em.find(Pessoa.class, 2);
//    em.getTransaction().begin();
//    em.remove(p);
//    em.getTransaction().commit();

//    em.getTransaction().begin();
//
//    em.persist(p1);



    System.out.println("Pronto");

  }

}
