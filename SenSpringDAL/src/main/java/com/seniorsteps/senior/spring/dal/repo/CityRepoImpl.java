package com.seniorsteps.senior.spring.dal.repo;

import com.seniorsteps.senior.spring.dal.entity.City;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMARTCS
 */
@Repository
public class CityRepoImpl  extends AbstractEntityRepo<City> implements CityRepo{

    public CityRepoImpl() {
        super(City.class);
        this.setDefaultOrder("nameAr");
    }

    @Override
    public City updateHQL(City city) {
        String hqlQuery = "UPDATE City SET nameAr= :na, nameEn = :ne WHERE id= :id";
        Query updateQuery = getCurrentSession().createQuery(hqlQuery);
        updateQuery.setParameter("na", city.getNameAr());
        updateQuery.setParameter("ne", city.getNameEn());
        updateQuery.setParameter("id", city.getId());
        int affectedRecords = updateQuery.executeUpdate();
        System.out.println("Affected Records " + affectedRecords);
        return city;
    }

    @Override
    public List<City> findListByHQL() {
        String hqlQuery = "FROM City ORDER BY nameAr";
        Query cityQuery = getCurrentSession().createQuery(hqlQuery);
        List<City> cityResultList = cityQuery.getResultList();
        return cityResultList;
    }

    @Override
    public List<City> findLikeByHQl(String keyboard) {
       String pattern = "%" + keyboard + "%";
        String hqlQuery = "FROM City WHERE nameAr LIKE :n OR nameEn LIKE :n ORDER BY nameAr";
        Query cityQuery = getCurrentSession().createQuery(hqlQuery);
        cityQuery.setParameter("n",pattern);
        List<City> cityResultList = cityQuery.getResultList();
        return cityResultList;
    }

    @Override
    public List<City> findLike(String keyboard) {
        String pattern = "%" + keyboard+ "%";
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<City> cityCriteriaQuery = criteriaBuilder.createQuery(City.class);
        Root<City> root = cityCriteriaQuery.from(City.class);
        cityCriteriaQuery.select(root);
        Predicate[] likeConditions = new Predicate[2];
        likeConditions[0] = criteriaBuilder.like(root.get("nameAr"), pattern);
        likeConditions[1] = criteriaBuilder.like(root.get("nameEn"), pattern);
        cityCriteriaQuery.where(criteriaBuilder.or(likeConditions));
        cityCriteriaQuery.orderBy(criteriaBuilder.asc(root.get("nameAr")));
        Query<City> cityQuery = getCurrentSession().createQuery(cityCriteriaQuery);
        List<City> cityResultList = cityQuery.getResultList();
        return cityResultList;
    }

    @Override
    public Long countLike(String keyboard) {
        String pattern = "%" + keyboard+ "%";
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Long> cityCriteriaQuery  = criteriaBuilder.createQuery(Long.class);
        Root<City> root = cityCriteriaQuery.from(City.class);
        cityCriteriaQuery.select(criteriaBuilder.count(root));
        Predicate[] likeConditions = new Predicate[2];
        likeConditions[0] = criteriaBuilder.like(root.get("nameAr"), pattern);
        likeConditions[1] = criteriaBuilder.like(root.get("nameEn"), pattern);
        cityCriteriaQuery.where(criteriaBuilder.or(likeConditions));
        Query<Long> countQuery = getCurrentSession().createQuery(cityCriteriaQuery);
        List<Long> cityResultList = countQuery.getResultList();
        return cityResultList.get(0);
    }

    
}
