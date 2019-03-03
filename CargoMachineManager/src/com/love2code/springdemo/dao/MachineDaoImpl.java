package com.love2code.springdemo.dao;

import com.love2code.springdemo.entity.CapacityItem;
import com.love2code.springdemo.entity.CargoMachine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MachineDaoImpl implements MachineDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CargoMachine> getMachines() {
        Session session = sessionFactory.getCurrentSession();
        Query<CargoMachine> query = session.createQuery("from CargoMachine order by name", CargoMachine.class);
        return query.getResultList();
    }

    @Override
    public void saveMachine(CargoMachine machine) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(machine);
        Query<CapacityItem> query = session.createQuery("delete from CapacityItem where machine_id is NULL");
        query.executeUpdate();
    }

    @Override
    public CargoMachine getMachine(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CargoMachine.class, customerId);
    }

    @Override
    public void delete(int machineId) {
        Session session = sessionFactory.getCurrentSession();
        Query<CargoMachine> query = session.createQuery("delete from CargoMachine where id=:machineId");
        query.setParameter("machineId", machineId);
        query.executeUpdate();
    }
}
