package pe.edu.i202030258.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030258.entity.country;

public class JPARemove {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();

        // Encontrar el país imaginario
        em.getTransaction().begin();
        country country = em.find(country.class, "ABC");

        if (country != null) {
            em.remove(country);
        } else {
            System.out.println("País no encontrado.");
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
