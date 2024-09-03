package jpacrudsingle.jpacrudsingle.service;

import jpacrudsingle.jpacrudsingle.dtos.DemoCreateDto;
import jpacrudsingle.jpacrudsingle.entity.Demo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class DemoService {
    @PersistenceContext
    EntityManager entityManager;

    public List<Demo> getDemos() {
        return entityManager.createQuery("select demo from Demo demo order by demo.name", Demo.class).getResultList();
    }

    public Demo createDemo(DemoCreateDto demoCreateDto) {
        Demo demo = new Demo();
        demo.setName(demoCreateDto.getName());

        entityManager.persist(demo);

        return demo;
    }
}
