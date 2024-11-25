package pe.edu.i202030258.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030258.entity.country;
import pe.edu.i202030258.entity.countrylanguage;
import pe.edu.i202030258.entity.countrylanguageId;

public class JPAPersist {

    public static void main(String[] args) {
        // Crear el EntityManagerFactory y EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar la transacción
            em.getTransaction().begin();

            // Crear el país imaginario
            country country = new country();
            country.setCode("ABC");
            country.setName("Brenlandia");

            // Persistir el país
            em.persist(country);

            // Crear los lenguajes nativos
            countrylanguage lang1 = new countrylanguage();
            lang1.setId(new countrylanguageId("ABC", "Brenlandia"));
            lang1.setCountry(country);
            lang1.setOfficial(true);
            lang1.setPercentage(60.0);

            countrylanguage lang2 = new countrylanguage();
            lang2.setId(new countrylanguageId ("ABC", "Armavala"));
            lang2.setCountry(country);
            lang2.setOfficial(false);
            lang2.setPercentage(40.0);

            // Persistir lenguajes
            em.persist(lang1);
            em.persist(lang2);

            // Confirmar la transacción
            em.getTransaction().commit();
            System.out.println("Datos persistidos correctamente.");
        } catch (Exception e) {
            // Manejo de errores y rollback
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Cerrar EntityManager y EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}
