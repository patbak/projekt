package com.example.projekt.model;

import com.example.projekt.repository.UserJpaRepository;
import com.example.projekt.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    public void testJpaFindByName()throws Exception{
        List<User> users = userJpaRepository.findByNameContains("Patryk");
        

        assertTrue(users.size()>0);
        System.out.println("Imie: "+users.get(0).getName());
    }

    @Test
    @Transactional
    public void testJpaFindUser() throws Exception{
     User user = userJpaRepository.getOne( 1);

     assertTrue(user.getName().equals("Patryk"));

     ConstructionSite constructionSite = user.getConstructionSites().get(0);
     DailyWorkReport dailyWorkReport = user.getDailyWorkReports().get(0);
     System.out.println("Imie: "+user.getName()+" Nazwisko: "+ user.getLastName()+" Email: "+user.getEmail()
             + "Pracuje na budowie: "+ constructionSite.getName() +" Data raportu: " + dailyWorkReport.getReportDate()
     );
    }

}
