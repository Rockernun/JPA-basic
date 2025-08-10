package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 멤버 하나 만들고,
            Member member = new Member();
            member.setUsername("Member 1");
            em.persist(member);

            // 팀 하나 만들고,
            Team team = new Team();
            team.setName("Team A");
            team.getMembers().add(member);  // 멤버를 추가
            em.persist(team);

            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
